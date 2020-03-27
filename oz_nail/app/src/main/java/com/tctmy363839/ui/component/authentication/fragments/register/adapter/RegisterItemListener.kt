package com.tctmy363839.ui.component.authentication.fragments.register.adapter

import com.tctmy363839.data.remote.dto.NewsItem
import com.tctmy363839.ui.base.listeners.RecyclerItemListener

/**
 * Created by AhmedEltaher on 5/12/2016
 */

interface RegisterItemListener : RecyclerItemListener{
    fun onItemSelected(data: Any? = null, type: TypeActionRegister)
}
