package za.ac.cput.ExpencesTracker

import android.app.Application
import za.ac.cput.ExpencesTracker.Data.AppContainer
import za.ac.cput.ExpencesTracker.Data.AppDataContainer

class ExpensesApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}