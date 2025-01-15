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
        startDestination = Home::class.simpleName!!
    ) {
        composable(Home::class.simpleName!!) {
            HomeScreen()
        }
        composable(Search::class.simpleName!!) {
            SearchScreen()
        }
        composable(Settings::class.simpleName!!) {
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