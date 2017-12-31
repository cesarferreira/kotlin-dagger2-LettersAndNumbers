package cesarferreira.lettersandnumbers

import android.app.Application
import cesarferreira.lettersandnumbers.di.AppComponent
import cesarferreira.lettersandnumbers.di.AppModule
import cesarferreira.lettersandnumbers.di.DaggerAppComponent
import cesarferreira.lettersandnumbers.di.ElementsModule

class MyApplication : Application() {

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .elementsModule(ElementsModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
    }
}
