package com.raccooncode.navigationpractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun FeedScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Feed Screen")

        Button(onClick = { navController.navigate(Destination.Profile.route) {
            popUpTo(Destination.Home.route)
        } }) {
            Text(text = "to Profile Screen")
        }

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back")
        }
    }
}