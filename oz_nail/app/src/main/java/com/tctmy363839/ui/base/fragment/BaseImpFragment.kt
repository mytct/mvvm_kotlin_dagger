package com.tctmy363839.ui.base.fragment

import androidx.fragment.app.Fragment
import com.tctmy363839.ui.base.activity.BaseActivity
import com.tctmy363839.ui.base.listeners.BaseView

abstract class BaseImpFragment : Fragment(), BaseView {
    override fun vOpenAuthenticationScreen() { (activity as BaseActivity).vOpenAuthenticationScreen() }
}