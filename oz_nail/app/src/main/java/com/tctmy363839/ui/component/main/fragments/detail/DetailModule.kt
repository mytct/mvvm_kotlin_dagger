package com.tctmy363839.ui.component.main.fragments.detail

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailModule {
    @ContributesAndroidInjector
    abstract fun contributeDetailFragment(): DetailFragment
}