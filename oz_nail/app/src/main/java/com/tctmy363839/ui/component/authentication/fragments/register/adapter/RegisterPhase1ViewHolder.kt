package com.tctmy363839.ui.component.authentication.fragments.register.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tctmy363839.R
import com.tctmy363839.data.remote.dto.NewsItem
import com.tctmy363839.ui.base.BaseViewHolder
import com.tctmy363839.ui.base.listeners.RecyclerItemListener
import com.tctmy363839.ui.component.authentication.fragments.register.data.RegisterDataGeneral
import com.tctmy363839.ui.component.authentication.fragments.register.data.RegisterDataPhase1
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_register_first.view.*
import kotlinx.android.synthetic.main.news_item.*

/**
 * Created by AhmedEltaher on 5/12/2016.
 */

class RegisterPhase1ViewHolder(override val containerView: View) : BaseViewHolder(containerView) {

    override fun bind(data: Any, recyclerItemListener: RegisterItemListener) {
        val item = (data as RegisterDataGeneral).dataPhase1
        itemView.edtNombreCompleto.setText(item.name)
        itemView.edtNoDeIdentidad.setText(item.identity)
        itemView.edtCorreoElectronico.setText(item.mail)
        itemView.edtContrasena.setText(item.password)
        itemView.edtConfirmarContrasena.setText(item.confirmPassword)
        itemView.btnContinuar.setOnClickListener {
            val passData = RegisterDataPhase1(
                    itemView.edtNombreCompleto.text.toString(),
                    itemView.edtNoDeIdentidad.text.toString(),
                    itemView.edtCorreoElectronico.text.toString(),
                    itemView.edtContrasena.text.toString(),
                    itemView.edtConfirmarContrasena.text.toString()
            )
            recyclerItemListener.onItemSelected(passData, TypeActionRegister.TO_PHASE2)
        }

        itemView.container.setOnClickListener { recyclerItemListener.onItemSelected(type = TypeActionRegister.HIDE_KEYBOARD) }
    }
}

