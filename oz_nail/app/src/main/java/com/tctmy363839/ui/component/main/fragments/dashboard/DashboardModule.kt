package com.tctmy363839.ui.component.main.fragments.dashboard

import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Inject

@Module
abstract class DashboardModule{
    @ContributesAndroidInjector
    abstract fun contributeDashboardFragment(): DashboardFragment
}