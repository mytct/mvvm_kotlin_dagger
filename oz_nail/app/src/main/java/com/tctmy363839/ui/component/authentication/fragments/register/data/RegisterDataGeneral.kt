package com.tctmy363839.ui.component.authentication.fragments.register.data

enum class TypeRegisterData { REGISTER_PHASE_1, REGISTER_PHASE_2 }

data class RegisterDataGeneral (
    //default
    val type: TypeRegisterData = TypeRegisterData.REGISTER_PHASE_1,
    var dataPhase1: RegisterDataPhase1 = RegisterDataPhase1(),
    var dataPhase2: RegisterDataPhase2 = RegisterDataPhase2()
){
    val readData: Any
        get() = when(type){
            TypeRegisterData.REGISTER_PHASE_1-> dataPhase1
            else-> dataPhase2
        }
}

data class RegisterDataPhase1 (
        val name: String = "",
        val identity: String = "",
        val mail: String = "",
        val password: String = "",
        val confirmPassword: String = ""
)

data class RegisterDataPhase2 (
        val fullname: String = "",
        val email: String = "",
        val date: String = "",
        val address: String = ""
)

