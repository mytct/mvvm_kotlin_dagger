package com.tctmy363839.ui.component.authentication

import com.tctmy363839.data.error.mapper.ErrorMapper
import com.tctmy363839.ui.base.BaseViewModel
import com.tctmy363839.usecase.errors.ErrorManager
import javax.inject.Inject

class AuthenticationViewModel @Inject constructor(): BaseViewModel() {
    override val errorManager: ErrorManager
        get() = ErrorManager(ErrorMapper())
}