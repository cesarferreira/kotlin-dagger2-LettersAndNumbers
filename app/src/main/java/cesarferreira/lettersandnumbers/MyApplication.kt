package cesarferreira.lettersandnumbers

import android.app.Application
import cesarferreira.lettersandnumbers.di.AppComponent
import cesarferreira.lettersandnumbers.di.AppModule
import cesarferreira.lettersandnumbers.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    private fun injectMembers() = appComponent.inject(this)

    override fun onCreate() {
        super.onCreate()
        injectMembers()
    }
}
