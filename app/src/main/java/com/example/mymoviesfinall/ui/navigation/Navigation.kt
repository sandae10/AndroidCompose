package com.example.mymoviesfinall.ui.navigation

import  android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mymoviesfinall.ui.theme.screens.details.DetailScreen
import com.example.mymoviesfinall.ui.theme.screens.main.MainDetailScreen
import com.example.mymoviesfinall.ui.theme.screens.main.MainScreen

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Navigation() {
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = NavItem.Main.route
    ) {
        composable(NavItem.Main) {
            BoxWithConstraints {
                when {
                    maxWidth <= 600.dp -> {
                        MainScreen{ mediaItem ->
                            navController.navigate(NavItem.Detail.createNavRoute(mediaItem.id)
                            )}
                    }
                    else -> {
                        MainDetailScreen()
                    }
                }
            }
            /*
               */
        }
        composable(NavItem.Detail) { backStackEntry ->
            //val id = backStackEntry.arguments?.getInt(NavArg.MediaId.key),
            val id =
            DetailScreen(
                mediaId = backStackEntry.findArg(NavArg.MediaId),
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}


//el private fun NavGraphBuilder quita el ".route " de los codigos que terminen en route "NavItem.Detail.route"
private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
){
    composable(
        route = navItem.route,
        arguments = navItem.args
    ){
        content(it)
    }
}

private fun <T> NavBackStackEntry.findArg(arg: NavArg): T {
    val value = arguments?.get(arg.key)
    requireNotNull(value)
    return value as T
}