package com.tctmy363839.ui.component.authentication.fragments.login

import com.mohamedeleish.tagged.annotation.Tagged
import com.tctmy363839.R
import com.tctmy363839.ui.ViewModelFactory
import com.tctmy363839.ui.base.fragment.BaseFragment
import com.tctmy363839.ui.component.authentication.AuthenticationActivity
import kotlinx.android.synthetic.main.layout_login.*
import javax.inject.Inject

@Tagged(customValName = "LoginFragmentTag")
class LoginFragment @Inject constructor(): BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var loginViewModel: LoginViewModel

    companion object {
        fun newInstance(): LoginFragment = LoginFragment()
    }

    override val layoutId: Int
        get() = R.layout.layout_login

    override fun observeViewModel() {
        loginViewModel = viewModelFactory.create(loginViewModel::class.java)
    }

    override fun initListeners() {
        tvDescription?.setOnClickListener { openRegisterFragment() }
        btnIcrearMiCuentaAhora?.setOnClickListener { openDashboardFragment() }
    }

    override fun initView() {

    }

    private fun openRegisterFragment() { (activity as AuthenticationActivity).vOpenRegisterFragment() }

    private fun openDashboardFragment() { (activity as AuthenticationActivity).vOpenMainActivity() }
}