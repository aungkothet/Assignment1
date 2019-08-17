package io.github.aungkothet.padc.week2.assignment1.controllers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import io.github.aungkothet.padc.week2.assignment1.R
import io.github.aungkothet.padc.week2.assignment1.adapters.CastAndCrewRecyclerAdapter
import io.github.aungkothet.padc.week2.assignment1.models.CastModel
import io.github.aungkothet.padc.week2.assignment1.utilities.IE_RATING_POINT
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    private var rating: Float = 0f

    companion object {
        fun newIntent(context: Context, rating: Float)
                : Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(IE_RATING_POINT, rating)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        rating = intent.getFloatExtra(IE_RATING_POINT, 0f)

        var castArrayList = arrayListOf(
            CastModel(
                R.drawable.cast1,
                "Dermott Downs",
                "Director"
            ),
            CastModel(
                R.drawable.cast2,
                "Grant Gustin"
            ),
            CastModel(
                R.drawable.cast3,
                "Candice Patton"
            ),
            CastModel(
                R.drawable.cast4,
                "Danielle Panabaker"
            ),
            CastModel(
                R.drawable.cast5,
                "Carlos Valdes"
            ),
            CastModel(
                R.drawable.cast6,
                "Tom Cavanagh"
            ),
            CastModel(
                R.drawable.cast7,
                "Jesse L. Martin"
            ),
            CastModel(
                R.drawable.cast8,
                "Keiynan Lonsdale"
            )
        )
        val castAndCrewRecyclerAdapter =
            CastAndCrewRecyclerAdapter(this, castArrayList)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        cast_recycler_view.layoutManager = layoutManager
        cast_recycler_view.adapter = castAndCrewRecyclerAdapter

        ratingBar.rating = rating
        tv_rating_point.text = "$rating"

        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            this.rating = rating
            tv_rating_point.text = "$rating"
        }
        tb_comment.setOnClickListener {
            if (tb_comment.isChecked) {
                tv_comment_count.text = "${tv_comment_count.text.toString().toInt() + 1}"
            } else {
                tv_comment_count.text = "${tv_comment_count.text.toString().toInt() - 1}"
            }
        }
        tb_fav.setOnClickListener {
            if (tb_fav.isChecked) {
                tv_fav_count.text = "${tv_fav_count.text.toString().toInt() + 1}"
            } else {
                tv_fav_count.text = "${tv_fav_count.text.toString().toInt() - 1}"
            }
        }
    }

    fun onBackButtonClicked(view: View) {
        val intent = Intent()
        intent.putExtra(IE_RATING_POINT, this.rating)
        setResult(RESULT_OK, intent)
        finish()
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra(IE_RATING_POINT, this.rating)
        setResult(RESULT_OK, intent)
        finish()
    }
}
