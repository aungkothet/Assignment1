package io.github.aungkothet.padc.week2.assignment1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cast_and_crew_list_item.view.*

class CastAndCrewRecyclerAdapter (private val context: Context,private val casts:ArrayList<CastModel>)
    :RecyclerView.Adapter<CastAndCrewRecyclerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cast_and_crew_list_item, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return casts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(context, casts[position])
    }


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val castImage = itemView.castImage
        private val castName = itemView.tv_cast_name
        private val castTitle = itemView.tv_cast_title

        fun bindData(context: Context,cast: CastModel){
            println(cast)
            if(cast.castTitle.isNullOrEmpty()){
                castTitle.visibility = View.GONE
            }
            castTitle.text = cast.castTitle
            castName.text = cast.castName
            castImage.setImageResource(cast.imageID)
        }
    }

}