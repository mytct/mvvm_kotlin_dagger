package com.tctmy363839.ui.component.main.fragments.mis_report

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MisReportModule{
    @ContributesAndroidInjector
    abstract fun contributeMisReportFragment(): MisReportFragment
}