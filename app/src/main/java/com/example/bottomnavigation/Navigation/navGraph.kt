package com.example.bottomnavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bottomnavigation.Navigation.NavItem
import com.example.bottomnavigation.screens.HomeScreen
import com.example.bottomnavigation.screens.SearchScreen
import com.example.bottomnavigation.screens.SettingsScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavItem.Home.route) {
        composable(NavItem.Home.route) { HomeScreen() }
        composable(NavItem.Search.route) { SearchScreen() }
        composable(NavItem.Settings.route) { SettingsScreen() }
    }
}
