package com.app.greenchallenge.desordenado.menumodule.news

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.greenchallenge.databinding.ItemNewsCardBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class NewsAdapter(
    private var mOpenWebSite: OpenWebSite,
    private var mList: ArrayList<NewsModel>
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context

        return ViewHolder(

            ItemNewsCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mList[position]

        with(holder) {
            container.setOnClickListener {
                mOpenWebSite.onClick(item.url)
            }

            Glide.with(context)
                .load(item.img)
                .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(imageView)

            title.text = item.title
            description.text = item.description
        }
    }

    override fun getItemCount(): Int = mList.size


    inner class ViewHolder(binding: ItemNewsCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val imageView = binding.imageView
        val title = binding.titleTextView
        val description = binding.descriptionTextView
        val container = binding.container

    }

}