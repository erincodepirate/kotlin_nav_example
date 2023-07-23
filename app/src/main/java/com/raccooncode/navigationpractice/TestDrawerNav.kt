package com.raccooncode.navigationpractice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestDrawerNav(navController: NavController, drawerState: DrawerState) {
    DrawerHeader()
    DrawerBody(navController = navController, drawerState = drawerState)
}

@Composable
fun DrawerHeader() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xffffcccb))
        .padding(64.dp)) {
        Text(text = "Header", fontSize = 40.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerBody(navController: NavController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()

    Column {
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable{
                navController.navigate(Destination.Home.route)
                scope.launch {
                    drawerState.close()
                }
            }
        ) {
            Icon(Icons.Default.Home, contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Home")
        }
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable{
                navController.navigate(Destination.Feed.route)
                scope.launch {
                    drawerState.close()
                }
            }
        ) {
            Icon(Icons.Default.List, contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Feed")
        }
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable{
                navController.navigate(Destination.Profile.route)
                scope.launch {
                    drawerState.close()
                }
            }
        ) {
            Icon(Icons.Default.Person, contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Profile")
        }
    }
}