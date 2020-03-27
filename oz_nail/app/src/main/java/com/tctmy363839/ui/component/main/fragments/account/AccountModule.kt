package com.tctmy363839.ui.component.main.fragments.account

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AccountModule {
    @ContributesAndroidInjector
    abstract fun contributeAccountFragment(): AccountFragment
}