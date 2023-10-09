package com.example.mymoviesfinall.ui.navigation

import androidx.navigation.NavArgs
import androidx.navigation.NavType
import androidx.navigation.navArgument


sealed class NavItem(
    val baseRoute : String,
    val navArgs:List<NavArg> = emptyList(),
){
    val route = run {
        val argKey = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argKey)
            .joinToString ("/")
    }
    val args = navArgs.map {
        navArgument(it.key) { type = it.navType}
    }
    object Main : NavItem("main")
    object Detail : NavItem("detail", listOf(NavArg.MediaId)){
        fun createNavRoute(mediaId: Int) = "$baseRoute/$mediaId"
    }

}

enum class NavArg(val key : String, val navType: NavType<*>) {
    MediaId("mediaId", NavType.IntType)

}
