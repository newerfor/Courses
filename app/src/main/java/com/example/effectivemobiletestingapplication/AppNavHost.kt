package com.example.effectivemobiletestingapplication

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core_navigation.NavRoutes
import com.example.feature_favorit_course.ui.FavoriteCourseMain
import com.example.feature_login.ui.LoginMainScreen
import com.example.feature_main.ui.Main
import com.example.feature_profile.ui.ProfileMain
import com.example.feature_single_course.ui.CourseInfoMain

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoutes.Login.routes)
    {
        composable(NavRoutes.Login.routes) {
            LoginMainScreen(
                isLoginTrue = {
                    navController.navigate(
                        NavRoutes.MainScreen.routes
                    )
                }
            )
        }
        composable(NavRoutes.MainScreen.routes) {
            Main(navController) { id ->
                navController.navigate(
                    NavRoutes.CourseInfo.passId(id)
                )
            }
        }
        composable(NavRoutes.Favorite.routes) {
            FavoriteCourseMain(navController) { id ->
                navController.navigate(
                    NavRoutes.CourseInfo.passId(id)
                )
            }
        }
        composable(NavRoutes.CourseInfo.routes) {
            val id = it.arguments?.getString("courseId")?.toInt()
            if (id != null) {
                CourseInfoMain(navController, id) {
                    navController.popBackStack()
                }
            } else {
                CourseInfoMain(navController, 100) {
                    navController.popBackStack()
                }
            }
        }
        composable(NavRoutes.Profile.routes) {
            ProfileMain(navController)
        }
    }
}
