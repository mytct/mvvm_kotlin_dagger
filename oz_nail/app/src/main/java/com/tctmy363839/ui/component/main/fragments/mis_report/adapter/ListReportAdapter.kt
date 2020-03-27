package com.tctmy363839.ui.component.main.fragments.mis_report.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tctmy363839.R
import com.tctmy363839.ui.base.BaseViewHolder
import com.tctmy363839.ui.component.main.fragments.mis_report.MisReportViewModel
import com.tctmy363839.ui.component.main.fragments.mis_report.data.ReportData

/**
 * Created by AhmedEltaher on 5/12/2016.
 */

class ListReportAdapter(private val misReportViewModel: MisReportViewModel, private val list: List<ReportData>) : RecyclerView.Adapter<BaseViewHolder>() {

    private val onItemClickListener: ReportItemListener = object : ReportItemListener {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ReportViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(list[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

