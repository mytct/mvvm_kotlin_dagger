package com.tctmy363839.ui.component.splash

import android.os.Bundle
import com.tctmy363839.R
import com.tctmy363839.ui.ViewModelFactory
import com.tctmy363839.ui.base.activity.BaseActivity
import kotlinx.android.synthetic.main.splash_layout.*
import javax.inject.Inject

/**
 * Created by AhmedEltaher on 5/12/2016
 */

class SplashActivity : BaseActivity(){
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var splashViewModel: SplashViewModel

    override val layoutId: Int
        get() = R.layout.splash_layout

    override fun initializeViewModel() {
        splashViewModel = viewModelFactory.create(splashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnIniciar.setOnClickListener { vOpenAuthenticationScreen() }
    }

    override fun observeViewModel() {}
}