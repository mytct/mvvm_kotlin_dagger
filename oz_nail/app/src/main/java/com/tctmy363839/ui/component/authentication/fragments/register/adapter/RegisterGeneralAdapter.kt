package com.tctmy363839.ui.component.authentication.fragments.register.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tctmy363839.R
import com.tctmy363839.data.remote.dto.NewsItem
import com.tctmy363839.ui.base.BaseViewHolder
import com.tctmy363839.ui.base.listeners.RecyclerItemListener
import com.tctmy363839.ui.component.authentication.fragments.register.RegisterViewModel
import com.tctmy363839.ui.component.authentication.fragments.register.data.RegisterDataGeneral
import com.tctmy363839.ui.component.authentication.fragments.register.data.RegisterDataPhase1
import com.tctmy363839.ui.component.authentication.fragments.register.data.RegisterDataPhase2

/**
 * Created by AhmedEltaher on 5/12/2016.
 */
enum class TypeActionRegister { TO_PHASE2, BACK_PHASE1, FINISH, HIDE_KEYBOARD }

class RegisterGeneralAdapter(private val registerViewModel: RegisterViewModel, private val list: List<RegisterDataGeneral>) : RecyclerView.Adapter<BaseViewHolder>() {

    private val onItemClickListener: RegisterItemListener = object : RegisterItemListener {
        override fun onItemSelected(data: Any?, type: TypeActionRegister) {
            when(type){
                TypeActionRegister.TO_PHASE2-> registerViewModel.openRegisterPhase2(data as RegisterDataPhase1)
                TypeActionRegister.BACK_PHASE1-> registerViewModel.openRegisterPhase1(data as RegisterDataPhase2)
                TypeActionRegister.HIDE_KEYBOARD-> {}
                else-> registerViewModel.finishRegister(data as RegisterDataPhase2)
            }
        }
    }

    override fun getItemViewType(position: Int): Int = list[position].type.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutId = when(viewType){
            0-> R.layout.layout_register_first
            else-> R.layout.layout_register_second
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return when(viewType){
            0-> RegisterPhase1ViewHolder(view)
            else-> RegisterPhase2ViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(list[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

