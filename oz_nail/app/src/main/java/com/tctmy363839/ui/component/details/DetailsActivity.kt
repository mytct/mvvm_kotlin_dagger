package com.tctmy363839.ui.component.details

import android.os.Bundle
import com.squareup.picasso.Picasso
import com.tctmy363839.R
import com.tctmy363839.data.remote.dto.NewsItem
import com.tctmy363839.ui.ViewModelFactory
import com.tctmy363839.ui.base.activity.BaseActivity
import com.tctmy363839.utils.Constants
import com.tctmy363839.utils.observe
import kotlinx.android.synthetic.main.details_layout.*
import javax.inject.Inject

/**
 * Created by AhmedEltaher on 11/12/16.
 */

class DetailsActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: DetailsViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val layoutId: Int
        get() = R.layout.details_layout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.newsItem.value = intent.getParcelableExtra(Constants.NEWS_ITEM_KEY)
    }

    override fun observeViewModel() {
        observe(viewModel.newsItem, ::initializeView)
    }

    override fun initializeViewModel() {
        viewModel = viewModelFactory.create(viewModel::class.java)
    }

    private fun initializeView(newsItem: NewsItem) {
        tv_title?.text = newsItem.title
        tv_description?.text = newsItem.abstractInfo
        if (!newsItem.multimedia.isNullOrEmpty()) {
            Picasso.get().load(newsItem.multimedia.last().url).placeholder(R.drawable.news)
                    .into(iv_news_main_Image)
        }
    }
}
