package com.pocraft.gassai.ui.browser

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.AttributeSet
import androidx.annotation.ColorRes
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.pocraft.gassai.R

/**
 * refs:
 * https://proandroiddev.com/add-chrome-custom-tabs-to-the-android-navigation-component-75092ce20c6a
 * https://developer.chrome.com/multidevice/android/customtabs
 */
@Navigator.Name("chrome")
class ChromeCustomTabsNavigator(
    private val context: Context
) : Navigator<ChromeCustomTabsNavigator.Destination>() {
    override fun navigate(
        destination: Destination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Extras?
    ): NavDestination? {
        val builder = CustomTabsIntent.Builder()
            .setToolbarColor(ContextCompat.getColor(context, destination.toolbarColor))
            .setSecondaryToolbarColor(ContextCompat.getColor(context, destination.secondaryToolbarColor))
        val intent = builder.build()
        val url = args?.getString("url")
        intent.launchUrl(context, Uri.parse(url))
        return null

    }

    override fun createDestination() =
        Destination(this)

    override fun popBackStack() = true

    @NavDestination.ClassType(Activity::class)
    class Destination(navigator: Navigator<out NavDestination>) : NavDestination(navigator) {
        @ColorRes
        var toolbarColor: Int = 0

        @ColorRes
        var secondaryToolbarColor: Int = 0

        override fun onInflate(context: Context, attrs: AttributeSet) {
            super.onInflate(context, attrs)

            context.withStyledAttributes(attrs, R.styleable.ChromeCustomTabsNavigator, 0, 0) {
                toolbarColor = getResourceId(R.styleable.ChromeCustomTabsNavigator_toolbarColor, 0)
                secondaryToolbarColor = getResourceId(R.styleable.ChromeCustomTabsNavigator_secondaryToolbarColor, 0)
            }
        }
    }
}