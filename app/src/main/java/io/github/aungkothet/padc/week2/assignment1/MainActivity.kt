package io.github.aungkothet.padc.week2.assignment1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnContinueClicked(view: View) {
        val name = et_name.text.toString()
        val email = et_email.text.toString()
        val phone = et_phone.text.toString()

        if (isNameValid(name) && isEmailValid(email) && isPhoneValid(phone)) {
            val intent = ProfileActivity.newIntent(this, name, email, phone)
            startActivity(intent)
            finish()
        }
    }

    private fun isEmailValid(email: String): Boolean {
        if (email.isNullOrBlank() || email.isNullOrEmpty()) {
            et_email.error = "Enter valid email!"
            return false
        } else {
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                et_email.error = "Enter valid email!"
                return false
            }
        }
        return true
    }

    private fun isNameValid(name: String): Boolean {
        if (name.isNullOrEmpty() || name.isNullOrBlank()) {
            et_name.error = "Enter your name!"
            return false
        }
        return true
    }

    private fun isPhoneValid(phone: String): Boolean {
        if (phone.isNullOrBlank() || phone.isNullOrEmpty()) {
            et_phone.error = "Enter valid phone number!"
            return false
        } else {
            if (!android.util.Patterns.PHONE.matcher(phone).matches()) {
                et_phone.error = "Enter valid phone number!"
                return false
            }
        }
        return true
    }
}
