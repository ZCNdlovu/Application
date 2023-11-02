package za.ac.cput.ExpencesTracker.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import za.ac.cput.ExpencesTracker.ExpensesApplication
import za.ac.cput.ExpencesTracker.ui.home.HomeViewModel
import za.ac.cput.ExpencesTracker.ui.items.ItemDetailViewModel
import za.ac.cput.ExpencesTracker.ui.items.ItemEditViewModel
import za.ac.cput.ExpencesTracker.ui.items.ItemEntryViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel
        initializer {
            ItemEditViewModel(
                this.createSavedStateHandle()
            )
        }
        // Initializer for ItemEntryViewModel
        initializer {
            ItemEntryViewModel(ExpensesApplication().container.itemRepository)
        }

        // Initializer for ItemDetailsViewModel
        initializer {
            ItemDetailViewModel(
                this.createSavedStateHandle()
            )
        }

        // Initializer for HomeViewModel
        initializer {
            HomeViewModel()
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
fun CreationExtras.expensesApplication(): ExpensesApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ExpensesApplication)