package cesarferreira.lettersandnumbers.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences? {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}
