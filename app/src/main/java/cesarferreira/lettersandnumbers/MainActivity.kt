package cesarferreira.lettersandnumbers

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
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
                switchToAllLettersFragment()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        switchToNumbersFragment()
    }

    private fun switchToNumbersFragment() {
        val array: ArrayList<String> = arrayListOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        replaceFragmentWith(ContentFragment.newInstance(array))
    }

    private fun switchToVowelsFragment() {
        val array: ArrayList<String> = arrayListOf("A", "E", "I", "O", "U")
        replaceFragmentWith(ContentFragment.newInstance(array))
    }

    private fun switchToAllLettersFragment() {
        val array: ArrayList<String> = arrayListOf("A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "W", "Y", "Z")
        replaceFragmentWith(ContentFragment.newInstance(array))
    }

    private fun replaceFragmentWith(contentFragment: ContentFragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, contentFragment)
                .commit()
    }
}
