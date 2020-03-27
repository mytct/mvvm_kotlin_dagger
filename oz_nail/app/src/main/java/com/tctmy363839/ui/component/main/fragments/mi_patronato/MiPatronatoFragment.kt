package com.tctmy363839.ui.component.main.fragments.mi_patronato

import com.mohamedeleish.tagged.annotation.Tagged
import com.tctmy363839.R
import com.tctmy363839.ui.ViewModelFactory
import com.tctmy363839.ui.base.fragment.BaseFragment
import javax.inject.Inject

@Tagged(customValName = "MiPatronatoFragmentTag")
class MiPatronatoFragment : BaseFragment() {

    companion object {
        fun newInstance() = MiPatronatoFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var miPatronatoViewModel: MiPatronatoViewModel

    override val layoutId: Int
        get() = R.layout.layout_mi_patronato

    override fun observeViewModel() {
        miPatronatoViewModel = viewModelFactory.create(miPatronatoViewModel::class.java)
    }

    override fun initListeners() {
    }

    override fun initView() {

    }
}