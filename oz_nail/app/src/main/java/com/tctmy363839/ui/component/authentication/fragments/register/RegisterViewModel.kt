package com.tctmy363839.ui.component.authentication.fragments.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tctmy363839.data.error.mapper.ErrorMapper
import com.tctmy363839.ui.base.BaseViewModel
import com.tctmy363839.ui.component.authentication.fragments.register.data.RegisterDataGeneral
import com.tctmy363839.ui.component.authentication.fragments.register.data.RegisterDataPhase1
import com.tctmy363839.ui.component.authentication.fragments.register.data.RegisterDataPhase2
import com.tctmy363839.ui.component.authentication.fragments.register.data.TypeRegisterData
import com.tctmy363839.usecase.errors.ErrorManager
import com.tctmy363839.utils.Event
import javax.inject.Inject

class RegisterViewModel @Inject constructor(): BaseViewModel() {
    var registerLiveData = MutableLiveData<MutableList<RegisterDataGeneral>>()
    val list = mutableListOf<RegisterDataGeneral>()

    private val finishRegisterPrivate: MutableLiveData<Event<RegisterDataGeneral>> = MutableLiveData()
    val finishRegister: LiveData<Event<RegisterDataGeneral>> get() = finishRegisterPrivate

    fun initData(){
        list.add(RegisterDataGeneral(type = TypeRegisterData.REGISTER_PHASE_1))
        list.add(RegisterDataGeneral(type = TypeRegisterData.REGISTER_PHASE_2))
    }

    override val errorManager: ErrorManager
        get() = ErrorManager(ErrorMapper())

    fun openRegisterPhase1(dataPhase2: RegisterDataPhase2) {
        list[1].dataPhase2 = dataPhase2
        refreshRegisterLayout(list[0])
    }

    private fun refreshRegisterLayout(data: RegisterDataGeneral){
        val list = mutableListOf<RegisterDataGeneral>()
        list.add(data)
        registerLiveData.value = list
    }

    fun finishRegister(dataPhase2: RegisterDataPhase2){
        list[1].dataPhase2 = dataPhase2
        finishRegisterPrivate.value = Event(RegisterDataGeneral(dataPhase1 = list[0].dataPhase1, dataPhase2 = list[1].dataPhase2))
    }

    fun openRegisterPhase2(dataPhase1: RegisterDataPhase1) {
        list[0].dataPhase1 = dataPhase1
        refreshRegisterLayout(list[1])
    }
}