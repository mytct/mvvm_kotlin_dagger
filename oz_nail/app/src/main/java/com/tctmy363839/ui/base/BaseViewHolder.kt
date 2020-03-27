package com.tctmy363839.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tctmy363839.R
import com.tctmy363839.data.remote.dto.NewsItem
import com.tctmy363839.ui.base.listeners.RecyclerItemListener
import com.tctmy363839.ui.component.authentication.fragments.register.adapter.RegisterItemListener
import com.tctmy363839.ui.component.main.fragments.mis_report.adapter.ReportItemListener
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.news_item.*

/**
 * Created by AhmedEltaher on 5/12/2016.
 */

abstract class BaseViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    open fun bind(data: Any, recyclerItemListener: RecyclerItemListener){}
    open fun bind(data: Any, recyclerItemListener: RegisterItemListener){}
    open fun bind(data: Any, recyclerItemListener: ReportItemListener){}
}

