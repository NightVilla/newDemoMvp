package com.example.samplecompose.io.mvpdemo2.models

import android.util.Log
import com.example.samplecompose.io.mvpdemo2.ConstValues
import com.example.samplecompose.io.mvpdemo2.data.User
import com.example.samplecompose.io.mvpdemo2.interfaces.LoginContract

class LoginModel() : LoginContract.Model {

    var arraylist: ArrayList<User>? = null

    init {
        arraylist = ArrayList<User>()
    }

    override fun login(email: String, password: String): Boolean {
        return checkUser(email, password)
    }

    private fun checkUser(email: String, password: String): Boolean {
        arraylist?.let {it : ArrayList<User> ->
            it.add(User("john@abc.com", "john123", "password123"))
            it.add(User("mike@def.com", "mike789", "password789"))
            it.add(User("paul@xyz.com", "paul01", "paulxyz01"))
            it.add(User("jane@xyz.com", "jane456", "pass456"))

            for(user in it){

                if(user.email.equals(email) || user.userName.equals(email) && user.password.equals(password)){
                    Log.d(ConstValues.TAG, "User Matched")
                    return true

                }else{
                    Log.d(ConstValues.TAG, "User Not Found")
                    return false
                }
            }
        }


        return false
    }


}