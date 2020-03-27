package com.tctmy363839.ui.component.main.fragments.create_post

import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import com.mohamedeleish.tagged.annotation.Tagged
import com.tctmy363839.R
import com.tctmy363839.ui.ViewModelFactory
import com.tctmy363839.ui.base.fragment.BaseFragment
import com.tctmy363839.ui.component.main.MainActivity
import kotlinx.android.synthetic.main.layout_add_news.*
import javax.inject.Inject


@Tagged(customValName = "CreatePostFragmentTag")
class CreatePostFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.layout_add_news

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var createPostViewModel: CreatePostViewModel

    companion object {
        fun newInstance() = CreatePostFragment()
    }

    override fun observeViewModel() {
        createPostViewModel = viewModelFactory.create(createPostViewModel::class.java)
    }

    override fun initListeners() {
        btnEnviar?.setOnClickListener { (activity as MainActivity).vOpenMisReportsFragment() }
    }

    override fun initView() {
//        val ITEMS = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6")
        ArrayAdapter.createFromResource(context!!, R.array.planets_array, android.R.layout.simple_spinner_item).let {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            edtCategory.apply {
                adapter = it

                onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
                    Log.e("MaterialSpinner", "onFocusChange hasFocus=$hasFocus")
                }
            }
        }
    }

//    private val listener by lazy {
//        object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: MaterialSpinner, view: View?, position: Int, id: Long) {
//                Log.e("MaterialSpinner", "onItemSelected parent=${parent.id}, position=$position")
//                parent.focusSearch(View.FOCUS_UP)?.requestFocus()
//            }
//
//            override fun onNothingSelected(parent: MaterialSpinner) {
//                Log.e("MaterialSpinner", "onNothingSelected parent=${parent.id}")
//            }
//        }
//    }
}