package com.example.quakereport.Latest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quakereport.R
import com.example.quakereport.news.News
import com.example.quakereport.news.NewsItemClicked
import com.example.quakereport.news.NewsViewHolder

class LatestListAdapter(private val listener: QuakeItemClicked): RecyclerView.Adapter<QuakeViewHolder>()  {

    private val items: ArrayList<QuakeList> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuakeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quake_list_layout, parent, false)
        val viewHolder = QuakeViewHolder(view)
        view.setOnClickListener{
            listener.onItemClicked(items[viewHolder.bindingAdapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: QuakeViewHolder, position: Int) {
        val currentItem = items[position]
        holder.mag.text = currentItem.mag
        holder.location.text = currentItem.location
    }

    fun updateQuakeList(updateQuakeList: ArrayList<QuakeList>) {
        items.clear()
        items.addAll(updateQuakeList)

        notifyDataSetChanged()
    }
}

class QuakeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mag: TextView = itemView.findViewById(R.id.magnitude)
    val location: TextView = itemView.findViewById(R.id.location)
}

interface QuakeItemClicked {
    fun onItemClicked(item: QuakeList)
}