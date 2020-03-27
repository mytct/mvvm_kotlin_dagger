package com.tctmy363839.ui.component.authentication

import com.tctmy363839.ui.base.listeners.BaseView

interface AuthenticationView: BaseView {
    fun vOpenRegisterFragment()
    fun vOpenLoginFragment()
    fun vOpenMainActivity()
}