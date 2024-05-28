package com.example.samplecompose.io.mvpdemo2.launcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.samplecompose.io.mvpdemo2.activities.HomeAct
import com.example.samplecompose.io.mvpdemo2.interfaces.LoginContract
import com.example.samplecompose.io.mvpdemo2.R
import com.example.samplecompose.io.mvpdemo2.presenters.LoginPresenter

class MainActivity : AppCompatActivity(), LoginContract.View {

    lateinit var emailEditText : EditText
    lateinit var passwordEditText : EditText
    lateinit var loginButton : Button
    var loginPresenter : LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inintViews()

        loginButton.setOnClickListener({view ->
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()


            if(email.length == 0 || password.length == 0){
                Toast.makeText(this, "Field can't be left empty", Toast.LENGTH_SHORT).show()
            }else{
                loginPresenter = LoginPresenter(this)
                loginPresenter?.let {
                    it.onLoginButtonClicked(email, password)
                }
            }


        })

    }

    private fun inintViews() {
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
    }

    override fun showInvalidCredentialsErr() {
        Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()


    }

    override fun showLoginSuccessfullMsg() {
        val intent = Intent(this, HomeAct::class.java)
        startActivity(intent)
    }
}