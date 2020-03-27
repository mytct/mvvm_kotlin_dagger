package com.tctmy363839.ui.base.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.tctmy363839.R
import com.tctmy363839.ui.base.BaseViewModel
import com.tctmy363839.ui.base.activity.BaseActivity
import com.tctmy363839.ui.base.listeners.BaseView
import dagger.android.support.AndroidSupportInjection

/**
 * Created by AhmedEltaher on 5/12/2016
 */


abstract class BaseFragment : BaseImpFragment() {

    protected var baseViewModel: BaseViewModel? = null

    abstract val layoutId: Int

    abstract fun observeViewModel()

    abstract fun initListeners()

    abstract fun initView()

    val container by lazy { view?.findViewById<View>(R.id.container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        observeViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListeners()
        initDefaultClickHideKeyboard()
    }

    private fun initDefaultClickHideKeyboard() { container?.setOnClickListener { vHideKeyboard() } }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    fun setTitle(title: String) {
        val actionBar = (activity as BaseActivity).supportActionBar
        if (actionBar != null) {
            val titleTextView = activity?.findViewById<TextView>(R.id.txt_toolbar_title)
            if (title.isNotEmpty()) {
                titleTextView?.text = title
            }
        }
    }

    override fun vHideKeyboard() { (activity as BaseActivity).vHideKeyboard() }
}
