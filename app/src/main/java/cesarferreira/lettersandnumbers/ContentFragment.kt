package cesarferreira.lettersandnumbers


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_content.*
import java.util.*


class ContentFragment : Fragment() {

    private lateinit var mItems: ArrayList<String>
    private var previousCharacter: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mItems = arguments!!.getStringArrayList(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRandomCharacter(characterTextView)

        characterTextView.setOnClickListener {
            setRandomCharacter(characterTextView)
        }
    }

    private fun setRandomCharacter(textView: AppCompatTextView) {
        var randomChar: String

        if (previousCharacter.isNullOrEmpty()) {
            randomChar = getRandomCharacter()
        } else {
            do {
                randomChar = getRandomCharacter()
            } while (randomChar == previousCharacter)
        }
        previousCharacter = randomChar

        textView.text = randomChar

        setRandomColorToTextView(textView)
    }

    private fun getRandomCharacter(): String {
        return mItems[Random().nextInt(mItems.size)]
    }

    private fun setRandomColorToTextView(textView: AppCompatTextView) {
        textView.setTextColor(getRandomColor())
    }

    private fun getRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255,
                rnd.nextInt(200), // R
                rnd.nextInt(200), // G
                rnd.nextInt(200)) // B
    }

    companion object {
        private val ARG_PARAM1 = "param1"

        fun newInstance(arrayList: ArrayList<String>): ContentFragment {
            val fragment = ContentFragment()
            val args = Bundle()
            args.putStringArrayList(ARG_PARAM1, arrayList)
            fragment.arguments = args
            return fragment
        }
    }

}
