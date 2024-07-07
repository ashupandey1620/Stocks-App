package com.ashutosh.growappassignment.ui.theme.Component.Tabs

data class TabData (
    val title : String
)

val tabs = listOf(
    TabData(Tabs.Gainers.value) ,
    TabData(Tabs.Losers.value)
)

enum class Tabs (val value:String){
    Gainers("Top Gainers"),
    Losers("Top Losers")
}