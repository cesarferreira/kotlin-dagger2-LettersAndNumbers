package cesarferreira.lettersandnumbers

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import cesarferreira.lettersandnumbers.di.AppComponent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var numbersFragment: ContentFragment? = null
    private var vowelsFragment: ContentFragment? = null
    private var lettersFragment: ContentFragment? = null

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
                    switchToNumbersFragment()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_vowels -> {
                    switchToVowelsFragment()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_all_letters -> {
                    switchToLettersFragment()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

        switchToNumbersFragment()
    }

    /**
     * Switch to the Numbers fragment
     */
    private fun switchToNumbersFragment() {
        if (numbersFragment == null) {
            val array: ArrayList<String> = arrayListOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
            numbersFragment = ContentFragment.newInstance(array)
        }

        replaceFragmentWith(numbersFragment!!)
    }

    /**
     * Switch to the Vowels fragment
     */
    private fun switchToVowelsFragment() {
        if (vowelsFragment == null) {
            val array: ArrayList<String> = arrayListOf("A", "E", "I", "O", "U")
            vowelsFragment = ContentFragment.newInstance(array)
        }

        replaceFragmentWith(vowelsFragment!!)
    }

    /**
     * Switch to the Letters fragment
     */
    private fun switchToLettersFragment() {
        if (lettersFragment == null) {
            val array: ArrayList<String> = arrayListOf("A", "B", "C", "D", "E", "F", "G", "H", "I",
                    "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "W", "Y", "Z")
            lettersFragment = ContentFragment.newInstance(array)
        }

        replaceFragmentWith(lettersFragment!!)
    }

    private fun replaceFragmentWith(contentFragment: ContentFragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, contentFragment)
                .commit()
    }
}
