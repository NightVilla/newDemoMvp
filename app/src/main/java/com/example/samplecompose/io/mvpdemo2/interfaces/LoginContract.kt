package com.example.samplecompose.io.mvpdemo2.interfaces

interface LoginContract {

    interface View{
        fun showInvalidCredentialsErr() : Unit
        fun showLoginSuccessfullMsg() : Unit
    }

    interface Presenter{
        fun onLoginButtonClicked(email : String, password : String) : Unit
    }

    interface Model{
        fun login(email : String, password: String) : Boolean
    }
}