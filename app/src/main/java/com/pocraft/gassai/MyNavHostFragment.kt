package com.pocraft.gassai

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.plusAssign
import com.pocraft.gassai.ui.browser.ChromeCustomTabsNavigator

class MyNavHostFragment: NavHostFragment() {
    override fun onCreateNavController(navController: NavController) {
        super.onCreateNavController(navController)

        context?.let {
            navController.navigatorProvider += ChromeCustomTabsNavigator(it)
        }
    }
}