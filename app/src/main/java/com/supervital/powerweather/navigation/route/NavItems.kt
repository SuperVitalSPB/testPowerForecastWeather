package com.supervital.powerweather.navigation.route

object NavItems {
    val navItems = listOf(
        NavItem(
            route = NavRoutes.MainScreen.route
        )
    )

    fun getNavItem(route: String?): NavItem {
        val found = navItems.filter { barItem ->
            barItem.route == route
        }
        return if (found == emptyList<NavItem>()) navItems[0] else found[0]
    }

}