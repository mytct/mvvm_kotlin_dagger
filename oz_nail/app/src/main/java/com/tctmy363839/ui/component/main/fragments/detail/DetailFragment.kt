package com.tctmy363839.ui.component.main.fragments.detail

import com.mohamedeleish.tagged.annotation.Tagged
import com.tctmy363839.R
import com.tctmy363839.ui.ViewModelFactory
import com.tctmy363839.ui.base.fragment.BaseFragment
import com.tctmy363839.ui.component.main.MainActivity
import kotlinx.android.synthetic.main.layout_news_detail.*
import javax.inject.Inject

@Tagged(customValName = "DetailFragmentTag")
class DetailFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var detailViewModel: DetailViewModel

    companion object {
        fun newInstance() = DetailFragment()
    }

    override val layoutId: Int
        get() = R.layout.layout_news_detail

    override fun observeViewModel() {
        detailViewModel = viewModelFactory.create(detailViewModel::class.java)
    }

    override fun initListeners() {
        btnRegresar?.setOnClickListener { (activity as MainActivity).vOpenMisReportsFragment() }
    }

    override fun initView() {

    }
}