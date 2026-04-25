package com.example.feature_profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.theme.Background
import com.example.core_ui.ui.NavigationBar
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_profile.costant.ProfileViewConstant.MAIN_TOP_PADDING
import org.koin.androidx.compose.koinViewModel


@Composable
fun ProfileMain(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .systemBarsPadding()
    ) {
        Column(Modifier.weight(1f)) {
            ProfileView()
        }
        Column {
            NavigationBar(
                navController = navController,
            )
        }
    }
}

@Composable
fun ProfileView(coursesViewModel: CoursesViewModel = koinViewModel()) {
    val courseList = listOf(
        CoursesDomainModel(
            id = 101,
            title = "3D-дженералист",
            text = "Освой профессию 3D-дженералиста и стань универсальным специалистом, который умеет создавать 3D-модели, текстуры и анимации, а также может строить карьеру в геймдеве, кино, рекламе или дизайне.",
            price = "12 000",
            rate = "3.9",
            startDate = "2024-09-10",
            hasLike = true,
            publishDate = "2024-01-20",
            imageIndex = 2
        ),
        CoursesDomainModel(
            id = 100,
            title = "Java-разработчик с нуля",
            text = "Освойте backend-разработку и программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
            price = "999",
            rate = "4.9",
            startDate = "2024-05-22",
            hasLike = false,
            publishDate = "2024-02-02",
            imageIndex = 1
        ),
    )
    Column(Modifier
        .fillMaxSize()
        .padding(top = MAIN_TOP_PADDING)) {
        ProfileScreen(courseList, coursesViewModel)
    }
}