package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigation.ui.theme.BottomNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNavigationTheme {

                val item = listOf(
                    NavItemState(
                        title = "Home",
                        selectedIcon = Icons.Default.Home,
                        unselectedIcon = Icons.Outlined.Home
                    ),
                    NavItemState(
                        title = "Search",
                        selectedIcon = Icons.Default.Search,
                        unselectedIcon = Icons.Outlined.Search
                    ),
                    NavItemState(
                        title = "Settings",
                        selectedIcon = Icons.Default.Settings,
                        unselectedIcon = Icons.Outlined.Settings
                    )
                )
                var navBarState by rememberSaveable {
                    mutableIntStateOf(0)
                }
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            item.forEachIndexed { index, navItemState ->
                                NavigationBarItem (
                                    selected = navBarState == index,
                                    onClick = {
                                        navBarState = index
                                        when (index) {
                                            0 -> navController.navigate(Home)
                                            1 -> navController.navigate(Search)
                                            2 -> navController.navigate(Settings)
                                        }
                                    },
                                    label = {
                                        Text(text = navItemState.title)
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (index == navBarState) navItemState.selectedIcon
                                            else navItemState.unselectedIcon,
                                            contentDescription = navItemState.title
                                        )
                                    },
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
