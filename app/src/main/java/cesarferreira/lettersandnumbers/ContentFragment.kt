package cesarferreira.lettersandnumbers


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_content.*
import java.util.*


class ContentFragment : Fragment() {

    private lateinit var mItems: ArrayList<String>
    private var mCharactersColor: Int? = null
    private var mPreviousCharacter: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mItems = arguments!!.getStringArrayList(ARG_ITEMS)
            mCharactersColor = arguments!!.getInt(ARG_CHARACTERS_COLOR)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mCharactersColor?.let {
            characterTextView.setTextColor(ContextCompat.getColor(this.context!!, it))
        }

        setRandomCharacter(characterTextView)

        characterTextView.setOnClickListener {
            setRandomCharacter(characterTextView)
        }
    }

    private fun setRandomCharacter(textView: AppCompatTextView) {
        var randomChar: String

        if (mPreviousCharacter.isNullOrEmpty()) {
            randomChar = getRandomCharacter()
        } else {
            do {
                randomChar = getRandomCharacter()
            } while (randomChar == mPreviousCharacter)
        }
        mPreviousCharacter = randomChar

        textView.text = randomChar
    }

    private fun getRandomCharacter(): String {
        return mItems[Random().nextInt(mItems.size)]
    }

    companion object {
        private val ARG_ITEMS = "param_items"
        private val ARG_CHARACTERS_COLOR = "param_characters_color"

        fun newInstance(arrayList: ArrayList<String>, colorCharacters: Int): ContentFragment {
            val fragment = ContentFragment()
            val args = Bundle()
            args.putStringArrayList(ARG_ITEMS, arrayList)
            args.putInt(ARG_CHARACTERS_COLOR, colorCharacters)
            fragment.arguments = args
            return fragment
        }
    }
}
