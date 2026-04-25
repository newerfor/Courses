package com.example.feature_main.ui.SearchAndFilters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_main.constant.MainViewConstant.SPACER_INPUT_TO_BUTTON
import com.example.feature_main.constant.MainViewConstant.SPACER_INPUT_TO_SORTED_TEXT

@Composable
fun SearchAndFiltersScreen(coursesViewModel: CoursesViewModel) {

    Row(Modifier.fillMaxWidth()) {
        Column(Modifier.weight(1f)) {
            SearchSpace()
        }
        Spacer(Modifier.width(SPACER_INPUT_TO_BUTTON))
        SearchFiltersSpace()
    }
    Spacer(Modifier.height(SPACER_INPUT_TO_SORTED_TEXT))
    SortedSpace(coursesViewModel)

}

