package cesarferreira.lettersandnumbers.di

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class ElementsModule {

    companion object {
        const val NUMBERS_ARRAY : String = "NUMBERS"
        const val VOWELS_ARRAY : String = "VOWELS"
        const val LETTERS_ARRAY : String = "LETTERS"
    }

    @Provides
    @Singleton
    @Named(NUMBERS_ARRAY)
    fun providesNumbersArray(): ArrayList<String> {
        return arrayListOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
    }

    @Provides
    @Singleton
    @Named(VOWELS_ARRAY)
    fun providesVowelsArray(): ArrayList<String> {
        return arrayListOf("A", "E", "I", "O", "U")
    }

    @Provides
    @Singleton
    @Named(LETTERS_ARRAY)
    fun providesLettersArray(): ArrayList<String> {
        return arrayListOf("A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "W", "Y", "Z")
    }
}