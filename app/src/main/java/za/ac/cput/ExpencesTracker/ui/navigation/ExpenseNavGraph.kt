package za.ac.cput.ExpencesTracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import za.ac.cput.ExpencesTracker.ui.home.HomeDestination
import za.ac.cput.ExpencesTracker.ui.home.HomeScreen
import za.ac.cput.ExpencesTracker.ui.items.ItemDetailsDestination
import za.ac.cput.ExpencesTracker.ui.items.ItemDetailScreen
import za.ac.cput.ExpencesTracker.ui.items.ItemEditDestination
import za.ac.cput.ExpencesTracker.ui.items.ItemEditScreen
import za.ac.cput.ExpencesTracker.ui.items.ItemEntryDestination
import za.ac.cput.ExpencesTracker.ui.items.ItemEntryScreen

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun ExpensesNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(ItemEntryDestination.route) },
                navigateToItemUpdate = {
                    navController.navigate("${ItemDetailDestination.route}/${it}")
                }
            )
        }
        composable(route = ItemEntryDestination.route) {
            ItemEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = ItemDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemDetailScreen(
                navigateToEditItem = { navController.navigate("${ItemEditDestination.route}/$it") },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(
            route = ItemEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}