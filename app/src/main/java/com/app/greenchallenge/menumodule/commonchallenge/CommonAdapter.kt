package com.app.greenchallenge.menumodule.commonchallenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.greenchallenge.R

class CommonAdapter(
    private val listCommon: List<ModelCommon>,
    private var listener: CommonOnClickListener
) :
    RecyclerView.Adapter<CommonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.card_view_challenge_common,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = listCommon[position].title
        holder.info.text = listCommon[position].effects
        holder.view.setOnClickListener { view ->
            listener.onClick(view, position, listCommon)
        }
    }

    override fun getItemCount(): Int = listCommon.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.titleChallenge)
        val info: TextView = view.findViewById(R.id.infoChallenge)
    }
}



