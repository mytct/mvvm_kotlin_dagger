package com.tctmy363839.ui.component.main.fragments.mis_report

import androidx.lifecycle.MutableLiveData
import com.tctmy363839.data.error.mapper.ErrorMapper
import com.tctmy363839.ui.base.BaseViewModel
import com.tctmy363839.ui.component.main.fragments.mis_report.data.ReportData
import com.tctmy363839.usecase.errors.ErrorManager
import javax.inject.Inject

class MisReportViewModel @Inject constructor(): BaseViewModel(){
    override val errorManager: ErrorManager
        get() = ErrorManager(ErrorMapper())

    var misReportLiveData = MutableLiveData<MutableList<ReportData>>()

    fun generateTestList(){
        val list = mutableListOf<ReportData>()
        for(i in 0..10){
            list.add(ReportData("test"))
        }
        misReportLiveData.value = list
    }
}