package com.tctmy363839.ui.component.main.fragments.account

import com.mohamedeleish.tagged.annotation.Tagged
import com.tctmy363839.R
import com.tctmy363839.ui.ViewModelFactory
import com.tctmy363839.ui.base.fragment.BaseFragment
import com.tctmy363839.ui.component.main.MainActivity
import kotlinx.android.synthetic.main.layout_support.*
import javax.inject.Inject

@Tagged(customValName = "AccountFragmentTag")
class AccountFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var accountViewModel: AccountViewModel

    companion object {
        fun newInstance() = AccountFragment()
    }

    override val layoutId: Int
        get() = R.layout.layout_support

    override fun observeViewModel() {
        accountViewModel = viewModelFactory.create(accountViewModel::class.java)
    }

    override fun initListeners() {
        ivBack?.setOnClickListener { (activity as MainActivity).vOpenMisReportsFragment() }
    }

    override fun initView() {

    }
}