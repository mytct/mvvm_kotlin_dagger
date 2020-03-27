package com.tctmy363839.ui.component.main.fragments.create_post

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CreatePostModule {
    @ContributesAndroidInjector
    abstract fun contributeCreatePostFragment(): CreatePostFragment
}