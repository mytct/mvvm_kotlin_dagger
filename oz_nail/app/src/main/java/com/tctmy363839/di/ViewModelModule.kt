/*
 * Copyright (C) 2018 The Android Open Source Project
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

import androidx.lifecycle.ViewModel
import com.tctmy363839.ui.component.authentication.AuthenticationViewModel
import com.tctmy363839.ui.component.authentication.fragments.login.LoginViewModel
import com.tctmy363839.ui.component.authentication.fragments.register.RegisterViewModel
import com.tctmy363839.ui.component.details.DetailsViewModel
import com.tctmy363839.ui.component.main.MainViewModel
import com.tctmy363839.ui.component.main.fragments.account.AccountViewModel
import com.tctmy363839.ui.component.main.fragments.create_post.CreatePostViewModel
import com.tctmy363839.ui.component.main.fragments.dashboard.DashboardViewModel
import com.tctmy363839.ui.component.main.fragments.detail.DetailViewModel
import com.tctmy363839.ui.component.main.fragments.mi_patronato.MiPatronatoViewModel
import com.tctmy363839.ui.component.main.fragments.mis_report.MisReportViewModel
import com.tctmy363839.ui.component.news.NewsListViewModel
import com.tctmy363839.ui.component.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(NewsListViewModel::class)
    abstract fun bindUserViewModel(viewModel: NewsListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    internal abstract fun bindSplashViewModel(viewModel: DetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AuthenticationViewModel::class)
    abstract fun bindAuthenticationViewModel(viewModel: AuthenticationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindRegisterViewModel(viewModel: RegisterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindDashboardViewModel(viewModel: DashboardViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreatePostViewModel::class)
    abstract fun bindCreatePostViewModel(viewModel: CreatePostViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MiPatronatoViewModel::class)
    abstract fun bindMiPatronatoViewModel(viewModel: MiPatronatoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MisReportViewModel::class)
    abstract fun bindMisReportViewModel(viewModel: MisReportViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AccountViewModel::class)
    abstract fun bindAccountViewModel(viewModel: AccountViewModel): ViewModel
}
