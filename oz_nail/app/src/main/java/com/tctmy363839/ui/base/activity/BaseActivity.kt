package com.tctmy363839.ui.base.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tctmy363839.R
import com.tctmy363839.ui.base.BaseViewModel
import com.tctmy363839.ui.base.listeners.ActionBarView
import com.tctmy363839.ui.base.listeners.BaseView
import com.tctmy363839.ui.component.authentication.AuthenticationActivity
import com.tctmy363839.utils.replaceFragment
import com.yinglan.keyboard.HideUtil
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.startActivity

/**
 * Created by AhmedEltaher on 5/12/2016
 */


abstract class BaseActivity : AppCompatActivity(), BaseView, ActionBarView {

    protected lateinit var baseViewModel: BaseViewModel

    abstract val layoutId: Int

    protected abstract fun initializeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initializeToolbar()
        initializeViewModel()
        observeViewModel()
    }

    private fun initializeToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar?.title = ""
        }
    }

    override fun setUpIconVisibility(visible: Boolean) {
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(visible)
    }

    override fun setTitle(titleKey: String) {
        val actionBar = supportActionBar
        if (actionBar != null) {
            val title = findViewById<TextView>(R.id.txt_toolbar_title)
            title?.text = titleKey
        }
    }

    override fun setSettingsIconVisibility(visibility: Boolean) {
        val actionBar = supportActionBar
        if (actionBar != null) {
            val icon = findViewById<ImageView>(R.id.ic_toolbar_setting)
            icon?.visibility = if (visibility) VISIBLE else GONE
        }
    }

    override fun setRefreshVisibility(visibility: Boolean) {
        val actionBar = supportActionBar
        if (actionBar != null) {
            val icon = findViewById<ImageView>(R.id.ic_toolbar_refresh)
            icon?.visibility = if (visibility) VISIBLE else GONE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    abstract fun observeViewModel()

    fun replaceFragment(fragment: Fragment, tag: String){ supportFragmentManager.replaceFragment(R.id.content, fragment, tag) }

    override fun vHideKeyboard() { HideUtil.hideSoftKeyboard(this) }

    override fun vOpenAuthenticationScreen() {
        startActivity<AuthenticationActivity>()
        finish()
    }

    override fun onBackPressed() {}
}
