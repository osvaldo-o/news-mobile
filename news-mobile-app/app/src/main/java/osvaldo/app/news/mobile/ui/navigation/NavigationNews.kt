package osvaldo.app.news.mobile.ui.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import osvaldo.app.news.mobile.ui.screen.detail.DetailScreen
import osvaldo.app.news.mobile.ui.screen.home.HomeScreen
import osvaldo.app.news.mobile.ui.viewmodel.NewsViewModel

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun NavigationNews(
    navController: NavHostController = rememberNavController(),
    viewModel: NewsViewModel = viewModel(factory = NewsViewModel.Factory)
) {

    val uiState = viewModel.uiState.collectAsState().value

    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = Home
        ) {

            composable<Home> {
                HomeScreen(
                    uiState = uiState,
                    onEvent = viewModel::onEvent,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@composable,
                    navDetail = { navController.navigate(Detail(it)) }
                )
            }

            composable<Detail> { backStackEntry ->

                val detail = backStackEntry.toRoute<Detail>()

                uiState.newsDetail?.let { news ->
                    DetailScreen(
                        news = news,
                        index = detail.index,
                        onEvent = viewModel::onEvent,
                        onBack = { navController.popBackStack() },
                        sharedTransitionScope = this@SharedTransitionLayout,
                        animatedVisibilityScope = this@composable
                    )
                }
            }

        }
    }



}