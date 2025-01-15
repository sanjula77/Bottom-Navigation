package com.example.bottomnavigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            HomeScreen()
        }
        composable<Search> {
            SearchScreen()
        }
        composable<Settings> {
            SettingsScreen()
        }
    }
}


@Composable
fun HomeScreen() {
    Text(text = "Home")
}

@Composable
fun SearchScreen() {
    Text(text = "Search")
}

@Composable
fun SettingsScreen() {
    Text(text = "Settings")
}

@Serializable
object Home

@Serializable
object Search

@Serializable
object Settings