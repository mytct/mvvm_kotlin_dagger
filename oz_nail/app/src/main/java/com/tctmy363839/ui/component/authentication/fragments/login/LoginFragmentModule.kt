package com.tctmy363839.ui.component.authentication.fragments.login

import com.tctmy363839.ui.component.authentication.fragments.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginFragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment
}