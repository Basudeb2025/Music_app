package com.example.musiapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class adptar(val dataList:List<Data>, val context: Activity):RecyclerView.Adapter<adptar.myviewHolder>() {
    private lateinit var myListener:onItemclicklitener
    interface onItemclicklitener{
        fun onItemclick(position: Int)
    }
    fun setItemclickListener(listener:onItemclicklitener){
        myListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.custom,parent,false)
        return myviewHolder(view,myListener)
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: myviewHolder, position: Int) {
       val current = dataList[position]
        holder.title.text = current.title.toString()
        holder.singer.text = current.artist.name
        Picasso.get().load(current.album.cover).into(holder.img)
    }
    class myviewHolder(itemview: View,listener: onItemclicklitener):RecyclerView.ViewHolder(itemview){
        val title = itemview.findViewById<TextView>(R.id.song_name)
        val singer = itemview.findViewById<TextView>(R.id.singer_name)
        val img = itemview.findViewById<ImageView>(R.id.song_pic)
        init {
            itemview.setOnClickListener {
                listener.onItemclick(adapterPosition)
            }
        }
    }

}