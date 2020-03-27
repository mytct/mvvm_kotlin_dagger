package com.tctmy363839.ui.component.authentication.fragments.register

import com.tctmy363839.ui.component.authentication.fragments.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RegisterFragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeRegisterFragment(): RegisterFragment
}