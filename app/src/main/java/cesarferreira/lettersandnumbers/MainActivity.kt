package cesarferreira.lettersandnumbers

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import cesarferreira.lettersandnumbers.di.AppComponent
import cesarferreira.lettersandnumbers.di.ElementsModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    @field:[Inject Named(ElementsModule.NUMBERS_ARRAY)]
    lateinit var numbersList: ArrayList<String>

    @field:[Inject Named(ElementsModule.VOWELS_ARRAY)]
    lateinit var vowelsList: ArrayList<String>

    @field:[Inject Named(ElementsModule.LETTERS_ARRAY)]
    lateinit var lettersList: ArrayList<String>

    private val numbersFragment: ContentFragment by lazy {
        ContentFragment.newInstance(numbersList)
    }

    private val vowelsFragment: ContentFragment by lazy {
        ContentFragment.newInstance(vowelsList)
    }

    private val lettersFragment: ContentFragment by lazy {
        ContentFragment.newInstance(lettersList)
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
