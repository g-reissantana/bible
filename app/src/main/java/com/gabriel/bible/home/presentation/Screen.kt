package com.gabriel.bible.home.presentation

sealed class Screen(val title: String) {
    object ForYou : Screen("For You")
    object Today : Screen("Today")
}