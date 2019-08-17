package io.github.aungkothet.padc.week2.assignment1.controllers

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.github.aungkothet.padc.week2.assignment1.*
import io.github.aungkothet.padc.week2.assignment1.utilities.IE_EMAIL
import io.github.aungkothet.padc.week2.assignment1.utilities.IE_NAME
import io.github.aungkothet.padc.week2.assignment1.utilities.IE_PHONE
import io.github.aungkothet.padc.week2.assignment1.utilities.IE_RATING_POINT
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity: AppCompatActivity() {

    private val RC_FROM_PROFILE_ACTIVITY = 11111
    private var rating = 2.4f
    companion object {
        fun newIntent(context: Context, name: String, email: String, phone: String)
                : Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra(IE_NAME,name)
            intent.putExtra(IE_EMAIL,email)
            intent.putExtra(IE_PHONE,phone)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val name = intent.getStringExtra(IE_NAME)
        val email = intent.getStringExtra(IE_EMAIL)
        val phone = intent.getStringExtra(IE_PHONE)
        tv_email.text = email
        tv_name.text = name
        tv_phone.text = phone

        tv_flash_rating.text = "$rating"
        tv_hotel_tran_3_rating.text = "9.3"
    }

    fun onBackButtonClicked(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun onMovieCardClicked(view: View){
        val intent = MovieDetailActivity.newIntent(
            this,
            rating
        )
        startActivityForResult(intent,RC_FROM_PROFILE_ACTIVITY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == RC_FROM_PROFILE_ACTIVITY && resultCode == Activity.RESULT_OK && data != null)
        {
            rating = data.getFloatExtra(IE_RATING_POINT,5.0f)
            tv_flash_rating.text = "$rating"
        }
    }
}
