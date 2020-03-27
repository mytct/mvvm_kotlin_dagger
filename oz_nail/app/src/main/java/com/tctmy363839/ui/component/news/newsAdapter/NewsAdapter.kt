package com.tctmy363839.ui.component.news.newsAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tctmy363839.R
import com.tctmy363839.data.remote.dto.NewsItem
import com.tctmy363839.ui.base.listeners.RecyclerItemListener
import com.tctmy363839.ui.component.news.NewsListViewModel

/**
 * Created by AhmedEltaher on 5/12/2016.
 */

class NewsAdapter(private val newsListViewModel: NewsListViewModel, private val news: List<NewsItem>) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        //holder.bind(news[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return news.size
    }
}

