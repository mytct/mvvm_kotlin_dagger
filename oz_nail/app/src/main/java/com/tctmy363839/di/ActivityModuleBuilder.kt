/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tctmy363839.di
import com.tctmy363839.ui.component.authentication.AuthenticationActivity
import com.tctmy363839.ui.component.authentication.fragments.login.LoginFragmentModule
import com.tctmy363839.ui.component.authentication.fragments.register.RegisterFragmentModule
import com.tctmy363839.ui.component.details.DetailsActivity
import com.tctmy363839.ui.component.main.MainActivity
import com.tctmy363839.ui.component.main.fragments.account.AccountModule
import com.tctmy363839.ui.component.main.fragments.create_post.CreatePostModule
import com.tctmy363839.ui.component.main.fragments.dashboard.DashboardModule
import com.tctmy363839.ui.component.main.fragments.detail.DetailFragment
import com.tctmy363839.ui.component.main.fragments.detail.DetailModule
import com.tctmy363839.ui.component.main.fragments.mi_patronato.MiPatronatoModule
import com.tctmy363839.ui.component.main.fragments.mis_report.MisReportModule
import com.tctmy363839.ui.component.news.NewsListActivity
import com.tctmy363839.ui.component.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModuleBuilder {
    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): NewsListActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailsActivity(): DetailsActivity

    @ContributesAndroidInjector(modules = [DashboardModule::class,
        CreatePostModule::class, MiPatronatoModule::class, MisReportModule::class, DetailModule::class, AccountModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [LoginFragmentModule::class, RegisterFragmentModule::class])
    abstract fun contributeAuthencationActivity(): AuthenticationActivity
}
