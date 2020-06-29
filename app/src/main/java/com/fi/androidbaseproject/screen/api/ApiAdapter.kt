package com.fi.androidbaseproject.screen.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fi.androidbaseproject.R
import com.fi.androidbaseproject.models.Name

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 02:45 PM
 ****************************************
 */

class ApiAdapter :
    RecyclerView.Adapter<ApiAdapter.ViewHolder>() {
    var data = listOf<Name>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_example, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tv: TextView = itemView.findViewById(R.id.tv)

        fun bindItem(item: Name) {
            tv.text = item.name
        }
    }
}