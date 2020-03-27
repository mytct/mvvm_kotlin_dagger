package com.tctmy363839.ui.component.main.fragments.mi_patronato

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MiPatronatoModule {
    @ContributesAndroidInjector
    abstract fun contributeMiPatronatoFragment(): MiPatronatoFragment
}