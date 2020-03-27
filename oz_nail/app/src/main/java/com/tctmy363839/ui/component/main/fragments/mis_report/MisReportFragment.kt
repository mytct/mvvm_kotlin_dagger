package com.tctmy363839.ui.component.main.fragments.mis_report

import androidx.recyclerview.widget.LinearLayoutManager
import com.mohamedeleish.tagged.annotation.Tagged
import com.tctmy363839.R
import com.tctmy363839.ui.ViewModelFactory
import com.tctmy363839.ui.base.fragment.BaseFragment
import com.tctmy363839.ui.component.main.MainActivity
import com.tctmy363839.ui.component.main.fragments.mis_report.adapter.ListReportAdapter
import com.tctmy363839.ui.component.main.fragments.mis_report.data.ReportData
import com.tctmy363839.utils.observe
import kotlinx.android.synthetic.main.layout_news.*
import javax.inject.Inject

@Tagged(customValName = "MisReportFragmentTag")
class MisReportFragment : BaseFragment(){
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var misReportViewModel: MisReportViewModel

    companion object {
        fun newInstance() = MisReportFragment()
    }

    override val layoutId: Int
        get() = R.layout.layout_news

    override fun observeViewModel() {
        misReportViewModel = viewModelFactory.create(misReportViewModel::class.java)
        observe(misReportViewModel.misReportLiveData, ::handleListReport)
    }

    fun handleListReport(list: MutableList<ReportData>){
        val adapter = ListReportAdapter(misReportViewModel, list)
        rvData.adapter = adapter
    }

    override fun initListeners() {
        initListReportView()
        misReportViewModel.generateTestList()

        tvVesMas?.setOnClickListener { (activity as MainActivity).vOpenDetailFragment() }
        ivAdd?.setOnClickListener { (activity as MainActivity).vOpenCreatePostFragment() }
    }

    override fun initView() {

    }

    private fun initListReportView() {
        val layoutManager = LinearLayoutManager(context)
        rvData.layoutManager = layoutManager
        rvData.setHasFixedSize(true)
    }

}