package com.tctmy363839.ui.component.main

import com.tctmy363839.ui.base.listeners.BaseView

interface MainView: BaseView{
    fun vOpenDashboardFragment()
    fun vOpenMiPatronatoFragment()
    fun vOpenCreatePostFragment()
    fun vOpenDetailFragment()
    fun vOpenMisReportsFragment()
    fun vOpenAccountFragment()
}