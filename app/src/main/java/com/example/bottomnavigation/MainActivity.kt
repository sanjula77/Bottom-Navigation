package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigation.Navigation.NavItem
import com.example.bottomnavigation.navigation.NavGraph
import com.example.bottomnavigation.ui.theme.BottomNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNavigationTheme {
                val navController = rememberNavController()

                val navItems = listOf(
                    NavItem.Home,
                    NavItem.Search,
                    NavItem.Settings
                )

                val currentBackStackEntry by navController.currentBackStackEntryFlow.collectAsStateWithLifecycle(null)
                val currentRoute = currentBackStackEntry?.destination?.route

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            navItems.forEach { navItem ->
                                val selected = currentRoute == navItem.route
                                NavigationBarItem(
                                    selected = selected,
                                    onClick = {
                                        navController.navigate(navItem.route) {
                                            popUpTo(navController.graph.startDestinationId) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    label = { Text(text = navItem.title) },
                                    icon = {
                                        Icon(
                                            imageVector = if (selected) navItem.selectedIcon else navItem.unselectedIcon,
                                            contentDescription = navItem.title
                                        )
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        NavGraph(navController = navController)
                    }
                }
            }
        }
    }
}
