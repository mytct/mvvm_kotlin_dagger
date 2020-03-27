package com.tctmy363839.ui.component.authentication.fragments.register.adapter

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.view.View
import com.tctmy363839.ui.base.BaseViewHolder
import com.tctmy363839.ui.component.authentication.fragments.register.data.RegisterDataGeneral
import com.tctmy363839.ui.component.authentication.fragments.register.data.RegisterDataPhase2
import kotlinx.android.synthetic.main.layout_register_second.view.*
import java.util.*


/**
 * Created by AhmedEltaher on 5/12/2016.
 */

class RegisterPhase2ViewHolder(override val containerView: View) : BaseViewHolder(containerView) {

    lateinit var datePicker: DatePickerDialog
    override fun bind(data: Any, recyclerItemListener: RegisterItemListener) {
        val item = (data as RegisterDataGeneral).dataPhase2
        itemView.edtNombreCompleto.setText(item.fullname)
        itemView.edtCorreoElectronico.setText(item.email)
        itemView.edtFechaDeNacimiento.setText(item.date)
        itemView.edtDireccion.setText(item.address)

        itemView.edtFechaDeNacimiento.setOnClickListener {
            val cldr: Calendar = Calendar.getInstance()
            val day: Int = cldr.get(Calendar.DAY_OF_MONTH)
            val month: Int = cldr.get(Calendar.MONTH)
            val year: Int = cldr.get(Calendar.YEAR)
            // date picker dialog
            // date picker dialog
            datePicker = DatePickerDialog(itemView.context,
                    OnDateSetListener { _, year, monthOfYear, dayOfMonth -> itemView.edtFechaDeNacimiento.setText(dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year) }, year, month, day)
            datePicker.show()
        }
        itemView.btnFinalizar.setOnClickListener {
            val passData = RegisterDataPhase2(
                    itemView.edtNombreCompleto.text.toString(),
                    itemView.edtCorreoElectronico.text.toString(),
                    itemView.edtFechaDeNacimiento.text.toString(),
                    itemView.edtDireccion.text.toString()
            )
            recyclerItemListener.onItemSelected(passData, TypeActionRegister.FINISH)
        }

        itemView.container.setOnClickListener { recyclerItemListener.onItemSelected(type = TypeActionRegister.HIDE_KEYBOARD) }
    }
}

