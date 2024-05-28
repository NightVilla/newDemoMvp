package com.example.samplecompose.io.mvpdemo2.presenters

import android.content.Context
import android.util.Log
import com.example.samplecompose.io.mvpdemo2.ConstValues
import com.example.samplecompose.io.mvpdemo2.interfaces.LoginContract
import com.example.samplecompose.io.mvpdemo2.models.LoginModel

class LoginPresenter(var context: Context) : LoginContract.Presenter {

    var view: LoginContract.View
    var loginModel : LoginModel? = null

    init {
        view = context as LoginContract.View
        loginModel = LoginModel()
    }

    override fun onLoginButtonClicked(email: String, password: String) {

        loginModel?.let {
            Log.d(ConstValues.TAG, "P_someChangsInMaster" + email)
            Log.d(ConstValues.TAG, "P_someChangsInMaster" + password)
            val userResult = it.login(email, password)

           if (userResult)
               view.showLoginSuccessfullMsg()
            else
                view.showInvalidCredentialsErr()

        }

    }
}