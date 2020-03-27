package com.tctmy363839.ui.component.authentication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.tctmy363839.R
import com.tctmy363839.ui.ViewModelFactory
import com.tctmy363839.ui.base.activity.BaseActivity
import com.tctmy363839.ui.component.authentication.fragments.login.LoginFragment
import com.tctmy363839.ui.component.authentication.fragments.register.RegisterFragment
import com.tctmy363839.ui.component.main.MainActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.layout_menu_top.*
import org.jetbrains.anko.startActivity
import tagged.generated.LoginFragmentTag
import tagged.generated.RegisterFragmentTag
import javax.inject.Inject

class AuthenticationActivity : BaseActivity(), HasSupportFragmentInjector, AuthenticationView {
    override val layoutId: Int
        get() = R.layout.authentication_activity

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var authenticationViewModel: AuthenticationViewModel

    override fun initializeViewModel() {
        authenticationViewModel = viewModelFactory.create(authenticationViewModel::class.java)
    }

    override fun observeViewModel() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //open login fragment
        vOpenLoginFragment()
        ibMenu?.setBackgroundResource(R.drawable.ic_keyboard_backspace_black_24dp)
        ibMenuRight?.visibility = View.GONE
    }

    override fun vOpenRegisterFragment() {
        tvMenuTitle?.text = resources.getString(R.string.smart_puerto_cortes)
        tvMenuTitle?.visibility = View.VISIBLE
        replaceFragment(RegisterFragment.newInstance(), RegisterFragmentTag)
    }

    override fun vOpenLoginFragment() {
        tvMenuTitle?.visibility = View.GONE
        replaceFragment(LoginFragment.newInstance(), LoginFragmentTag)
    }

    override fun vOpenMainActivity() {
        startActivity<MainActivity>()
        finish()
    }
}