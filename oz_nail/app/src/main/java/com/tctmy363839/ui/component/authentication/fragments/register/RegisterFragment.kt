package com.tctmy363839.ui.component.authentication.fragments.register

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.mohamedeleish.tagged.annotation.Tagged
import com.tctmy363839.R
import com.tctmy363839.ui.ViewModelFactory
import com.tctmy363839.ui.base.fragment.BaseFragment
import com.tctmy363839.ui.component.authentication.AuthenticationActivity
import com.tctmy363839.ui.component.authentication.fragments.register.adapter.RegisterGeneralAdapter
import com.tctmy363839.ui.component.authentication.fragments.register.data.RegisterDataGeneral
import com.tctmy363839.ui.component.authentication.fragments.register.data.RegisterDataPhase2
import com.tctmy363839.utils.Event
import com.tctmy363839.utils.observe
import kotlinx.android.synthetic.main.layout_register_general.*
import javax.inject.Inject

@Tagged(customValName = "RegisterFragmentTag")
class RegisterFragment: BaseFragment() {

    companion object { fun newInstance() :RegisterFragment = RegisterFragment() }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var registerViewModel: RegisterViewModel

    override val layoutId: Int
        get() = R.layout.layout_register_general

    private fun handleRegisterList(list: MutableList<RegisterDataGeneral>) {
        val newsAdapter = RegisterGeneralAdapter(registerViewModel, list)
        rcData.adapter = newsAdapter
    }

    override fun observeViewModel() {
        registerViewModel = viewModelFactory.create(registerViewModel::class.java)
        observe(registerViewModel.registerLiveData, ::handleRegisterList)
        observe(registerViewModel.finishRegister, ::handleFinishRegister)
        registerViewModel.initData()
    }

    private fun handleFinishRegister(registerDataGeneral: Event<RegisterDataGeneral>) {
        //combine data registration here for call api register
        registerDataGeneral.getContentIfNotHandled()?.let {
            Log.v("TEST","handleFinishRegister ${Gson().toJson(it)}")
            (activity as AuthenticationActivity).vOpenMainActivity()
        }
    }

    override fun initListeners() {
        initListRegister()
        registerViewModel.openRegisterPhase1(RegisterDataPhase2())
    }

    override fun initView() {

    }

    private fun initListRegister() {
        val layoutManager = LinearLayoutManager(context)
        rcData.layoutManager = layoutManager
        rcData.setHasFixedSize(true)
    }
}