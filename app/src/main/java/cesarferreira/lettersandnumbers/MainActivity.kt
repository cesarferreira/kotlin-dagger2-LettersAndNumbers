package cesarferreira.lettersandnumbers

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import cesarferreira.lettersandnumbers.di.AppComponent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * Lazy load for the Numbers Fragment
     */
    private val numbersFragment: ContentFragment by lazy {
        val array: ArrayList<String> = arrayListOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        ContentFragment.newInstance(array)
    }

    /**
     * Lazy load for the Vowels Fragment
     */
    private val vowelsFragment: ContentFragment by lazy {
        val array: ArrayList<String> = arrayListOf("A", "E", "I", "O", "U")
        ContentFragment.newInstance(array)
    }

    /**
     * Lazy load for the Letters Fragment
     */
    private val lettersFragment: ContentFragment  by lazy {
        val array: ArrayList<String> = arrayListOf("A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "W", "Y", "Z")
        ContentFragment.newInstance(array)
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
