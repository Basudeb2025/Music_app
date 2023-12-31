package com.example.musiapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class second_recycle_smal_adapter(val array: MutableList<String>, val context: Activity): RecyclerView.Adapter<second_recycle_smal_adapter.myviewHolder>() {
    private lateinit var myListener:onItemclicklitener
    interface onItemclicklitener{
        fun onItemclick(position: Int)
    }
    fun setItemclickListener(listener:onItemclicklitener){
        myListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.smaleitems,parent,false)
        return myviewHolder(view, myListener)
    }

    override fun getItemCount(): Int {
        return array?.size!!
    }

    override fun onBindViewHolder(holder: myviewHolder, position: Int) {
        val current = array?.get(position)
        Picasso.get().load(current).into(holder.img)
    }
    class myviewHolder(itemview: View,listener: onItemclicklitener): RecyclerView.ViewHolder(itemview) {
          val img = itemview.findViewById<ImageView>(R.id.second_pic)
        init {
            itemview.setOnClickListener {
                listener.onItemclick(adapterPosition)
            }
        }
    }

}