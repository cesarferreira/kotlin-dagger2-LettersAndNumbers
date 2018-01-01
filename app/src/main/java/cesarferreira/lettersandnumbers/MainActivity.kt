package cesarferreira.lettersandnumbers

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import cesarferreira.lettersandnumbers.di.AppComponent
import cesarferreira.lettersandnumbers.di.ItemsModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    @field:[Inject Named(ItemsModule.NUMBERS_ARRAY)]
    internal lateinit var numbersList: ArrayList<String>

    @field:[Inject Named(ItemsModule.VOWELS_ARRAY)]
    internal lateinit var vowelsList: ArrayList<String>

    @field:[Inject Named(ItemsModule.LETTERS_ARRAY)]
    internal lateinit var lettersList: ArrayList<String>

    private val numbersFragment: ContentFragment by lazy {
        ContentFragment.newInstance(numbersList, R.color.colorNumbers)
    }

    private val vowelsFragment: ContentFragment by lazy {
        ContentFragment.newInstance(vowelsList, R.color.colorVowels)
    }

    private val lettersFragment: ContentFragment by lazy {
        ContentFragment.newInstance(lettersList, R.color.colorLetters)
    }

    private val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as MyApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appComponent.inject(this)

        navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_numbers -> {
                    replaceFragmentWith(numbersFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_vowels -> {
                    replaceFragmentWith(vowelsFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_all_letters -> {
                    replaceFragmentWith(lettersFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

        replaceFragmentWith(numbersFragment)
    }

    private fun replaceFragmentWith(contentFragment: ContentFragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, contentFragment)
                .commit()
    }
}
