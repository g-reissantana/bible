package com.gabriel.bible.home.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.gabriel.bible.home.presentation.explorer.ExplorerScreen
import com.gabriel.bible.home.presentation.today.TodayScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@OptIn(ExperimentalPagerApi::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val pagerState = rememberPagerState(pageCount = 2)
    HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth()) { page ->
        when (page) {
            0 -> TodayScreen()
            else -> ExplorerScreen()
        }
    }
}

@Preview
@Composable
fun HomeScreen_Preview() {
    HomeScreen(navigator = EmptyDestinationsNavigator)
}