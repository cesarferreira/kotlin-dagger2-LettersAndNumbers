package cesarferreira.lettersandnumbers.di

import cesarferreira.lettersandnumbers.MainActivity
import cesarferreira.lettersandnumbers.MyApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ItemsModule::class))
interface AppComponent {
    fun inject(target: MainActivity)
    fun inject(target: MyApplication)
}