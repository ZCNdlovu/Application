package za.ac.cput.ExpencesTracker.Data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val itemRepository: ItemRepository
}

/**
 * [AppContainer] implementation that provides instance of [NoItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val itemRepository: ItemRepository by lazy {
        NoItemRepository(ExpensesDatabase.getDatabase(context).itemDao())
    }
}