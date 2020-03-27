package com.tctmy363839.ui.component.main.fragments.dashboard

import com.mohamedeleish.tagged.annotation.Tagged
import com.tctmy363839.R
import com.tctmy363839.ui.ViewModelFactory
import com.tctmy363839.ui.base.fragment.BaseFragment
import com.tctmy363839.ui.component.main.MainActivity
import com.tctmy363839.ui.component.main.fragments.mi_patronato.MiPatronatoFragment
import com.tctmy363839.ui.component.main.fragments.mis_report.MisReportFragment
import kotlinx.android.synthetic.main.layout_profile.*
import tagged.generated.MiPatronatoFragmentTag
import tagged.generated.MisReportFragmentTag
import javax.inject.Inject

@Tagged(customValName = "DashboardFragmentTag")
class DashboardFragment: BaseFragment() {
    override val layoutId: Int
        get() = R.layout.layout_profile

    companion object {
        fun newInstance() = DashboardFragment()
    }

    @Inject
    lateinit var dashboardViewModel: DashboardViewModel

    @Inject
    lateinit var viewmodelFactory: ViewModelFactory

    override fun observeViewModel() {
        dashboardViewModel = viewmodelFactory.create(dashboardViewModel::class.java)
    }

    override fun initListeners() {
        tvMiPatronato?.setOnClickListener { (activity as MainActivity).vOpenMiPatronatoFragment() }
        tvMisReportes?.setOnClickListener { (activity as MainActivity).vOpenMisReportsFragment() }
        btnCerrarSesion?.setOnClickListener { (activity as MainActivity).vOpenAuthenticationScreen() }
        tvInicio?.setOnClickListener { (activity as MainActivity).vOpenCreatePostFragment() }
    }

    override fun initView() {

    }
}