package com.gabriel.bible.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gabriel.bible.home.presentation.for_you.ForYouScreen
import com.gabriel.bible.home.presentation.today.TodayScreen
import com.gabriel.bible.ui.theme.Green
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val screens = listOf(Screen.Today, Screen.ForYou)
    val pagerState = rememberPagerState(pageCount = screens.size)

    Column {
        Spacer(modifier = Modifier.height(16.dp))
        Header(pagerState = pagerState, screens = screens)
        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth()) { page ->
            when (page) {
                0 -> TodayScreen()
                else -> ForYouScreen()
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Header(pagerState: PagerState, screens: List<Screen>) {
    val scope = rememberCoroutineScope()
    ScrollableTabRow(
        edgePadding = 0.dp,
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colors.background,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                color = Green
            )
        },
        divider = {}
    ) {
        screens.forEachIndexed { index, screen ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch { pagerState.animateScrollToPage(index) }
                },
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 10.dp)
            ) {
                Text(screen.title)
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun Header_Preview() {
    Header(
        pagerState = rememberPagerState(pageCount = 2),
        screens = listOf(Screen.Today, Screen.ForYou)
    )
}