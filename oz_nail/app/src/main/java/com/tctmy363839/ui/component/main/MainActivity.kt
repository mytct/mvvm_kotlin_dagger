package com.tctmy363839.ui.component.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.tctmy363839.R
import com.tctmy363839.ui.ViewModelFactory
import com.tctmy363839.ui.base.activity.BaseActivity
import com.tctmy363839.ui.component.main.fragments.account.AccountFragment
import com.tctmy363839.ui.component.main.fragments.create_post.CreatePostFragment
import com.tctmy363839.ui.component.main.fragments.dashboard.DashboardFragment
import com.tctmy363839.ui.component.main.fragments.detail.DetailFragment
import com.tctmy363839.ui.component.main.fragments.mi_patronato.MiPatronatoFragment
import com.tctmy363839.ui.component.main.fragments.mis_report.MisReportFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.layout_menu_top.*
import kotlinx.android.synthetic.main.main_activity.*
import tagged.generated.*
import javax.inject.Inject

class MainActivity: BaseActivity(), HasSupportFragmentInjector, MainView{
    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector

    override val layoutId: Int
        get() = R.layout.main_activity

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun initializeViewModel() {
        mainViewModel = viewModelFactory.create(mainViewModel::class.java)
    }

    override fun observeViewModel() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //check logic display
        vOpenDashboardFragment()
        ibMenu?.setOnClickListener { vOpenAccountFragment() }
        ibMenuRight?.setOnClickListener { vOpenDashboardFragment() }
    }

    fun refreshMenuTop(titleId: Int){
        var menuTitle = ""
        when(titleId){
            R.string.mi_patronato -> {
                menuTitle = resources.getString(R.string.mi_patronato)
                clMenuTop?.visibility = View.VISIBLE
            }
            R.string.mis_reportes -> {
                menuTitle = resources.getString(R.string.mis_reportes)
                clMenuTop?.visibility = View.VISIBLE}
            else-> {
                menuTitle = ""
                clMenuTop?.visibility = View.GONE
            }
        }
        tvMenuTitle?.text = menuTitle
    }

    override fun vOpenAccountFragment() {
        refreshMenuTop(0)
        replaceFragment(AccountFragment.newInstance(), AccountFragmentTag)
    }

    override fun vOpenDashboardFragment() {
        refreshMenuTop(0)
        replaceFragment(DashboardFragment.newInstance(), DashboardFragmentTag)
    }

    override fun vOpenMiPatronatoFragment() {
        refreshMenuTop(R.string.mi_patronato)
        replaceFragment(MiPatronatoFragment.newInstance(), MiPatronatoFragmentTag)
    }

    override fun vOpenCreatePostFragment() {
        refreshMenuTop(0)
        replaceFragment(CreatePostFragment.newInstance(), CreatePostFragmentTag)
    }

    override fun vOpenDetailFragment() {
        refreshMenuTop(0)
        replaceFragment(DetailFragment.newInstance(), DetailFragmentTag)
    }

    override fun vOpenMisReportsFragment() {
        refreshMenuTop(R.string.mis_reportes)
        replaceFragment(MisReportFragment.newInstance(), MisReportFragmentTag)
    }
}