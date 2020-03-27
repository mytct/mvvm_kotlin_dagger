package com.tctmy363839

import android.app.Activity
import android.content.Context
import androidx.multidex.MultiDexApplication
import com.tctmy363839.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by AhmedEltaher on 5/12/2016
 */

open class App : MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initDagger()
    }

    open fun initDagger() {
        DaggerAppComponent.builder().build().inject(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector

    companion object {
        lateinit var context: Context

    }
}
