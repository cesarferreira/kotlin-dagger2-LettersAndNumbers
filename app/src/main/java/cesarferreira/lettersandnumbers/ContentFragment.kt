package cesarferreira.lettersandnumbers


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_content.*
import java.util.*


class ContentFragment : Fragment() {

    private lateinit var randomGenerator: Random
    private lateinit var mItems: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        randomGenerator = Random()

        if (arguments != null) {
            mItems = arguments!!.getStringArrayList(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRandomCharacter()

        characterTextView.setOnClickListener {
            setRandomCharacter()
        }
    }

    private fun setRandomCharacter() {
        characterTextView.text = anyItem()
    }

    private fun anyItem(): String {
        return mItems[randomGenerator.nextInt(mItems.size)]
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
