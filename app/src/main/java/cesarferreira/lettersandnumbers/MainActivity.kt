package cesarferreira.lettersandnumbers

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
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
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ContentFragment.newInstance("one", "two"))
                .commit()
    }

    private fun switchToVowelsFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ContentFragment.newInstance("one", "two"))
                .commit()
    }

    private fun switchToAllLettersFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ContentFragment.newInstance("one", "two"))
                .commit()
    }
}
