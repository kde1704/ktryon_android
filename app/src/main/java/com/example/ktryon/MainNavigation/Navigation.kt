package com.example.ktryon.MainNavigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavHostController
import com.example.ktryon.CatalogueScreen.CatalogueScreen
import com.example.ktryon.PreviewScreen.PreviewScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun mainNavController(previewNavController: NavHostController?): NavHostController {
    val navController: NavHostController = previewNavController ?: rememberAnimatedNavController()
    return navController
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavHost(navController: NavHostController) {
    val enterTransition = enterTransition()
    val exitTransition = exitTransition()
    AnimatedNavHost(navController = navController, startDestination = "Catalogue") {
        composable(
            "Catalogue",
            enterTransition = { enterTransition },
            exitTransition = { exitTransition },
        ) { backStackEntry ->
            CatalogueScreen(navController)
        }

        composable(
            "Preview/{name}/{price}/{image_url}",
            enterTransition = { enterTransition },
            exitTransition = { exitTransition },
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val price = backStackEntry.arguments?.getString("price")
            val image_url = backStackEntry.arguments?.getString("image_url")?.replace("|", "/")

            if (name != null && price != null && image_url != null) {
                PreviewScreen(navController, name, price, image_url)
            } else {
                navController.navigate("Catalogue")
            }
        }
    }
}

private fun enterTransition(durationMillis: Int = 400): EnterTransition {
    return slideIn(animationSpec = tween(durationMillis, easing = EaseOutCubic)) { fullSize ->
        IntOffset(fullSize.width / 4, 100)
    } + fadeIn(animationSpec = tween(durationMillis, easing = EaseOutCubic))
}

private fun exitTransition(durationMillis: Int = 400): ExitTransition {
    return slideOut(animationSpec = tween(durationMillis, easing = EaseOutCubic)) {
        IntOffset(-180, 50)
    } + fadeOut(animationSpec = tween(durationMillis, easing = EaseOutCubic))
}