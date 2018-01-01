package cesarferreira.lettersandnumbers.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: Application) {

    @Provides
    @PerApplication
    fun provideContext(): Context = app

    @Provides
    @PerApplication
    fun provideSharedPreferences(context: Context): SharedPreferences? {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}
