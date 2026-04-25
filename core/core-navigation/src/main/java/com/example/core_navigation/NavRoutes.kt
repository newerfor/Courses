package com.example.core_navigation

sealed class NavRoutes(val routes: String) {
    object Login : NavRoutes("login")
    object MainScreen : NavRoutes("main")
    object Favorite : NavRoutes("favorite")
    object Profile : NavRoutes("profile")
    data object CourseInfo : NavRoutes("course_info/{courseId}") {
        fun passId(id: Int): String = "course_info/$id"
    }
}