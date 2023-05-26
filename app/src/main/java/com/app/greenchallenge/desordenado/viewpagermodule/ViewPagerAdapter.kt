package com.app.greenchallenge.desordenado.viewpagermodule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.greenchallenge.databinding.BoardItemBinding
import com.app.greenchallenge.viewpagermodule.ViewPagerOnClickListener
import com.domain.Board

class ViewPagerAdapter(
    private val boardList: List<Board>,
    private var listener: ViewPagerOnClickListener
) : RecyclerView.Adapter<ViewPagerAdapter.BoardViewHolder>() {

    inner class BoardViewHolder(private val binding: BoardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(board: Board) {
            with(binding) {
                onBoardingImage.setImageResource(board.image)
                tvTittle.text = board.title
                tvMessage.text = board.description

                when (adapterPosition) {
                    0 -> {
                        arrowBack.visibility = View.GONE
                        btnFinish.visibility = View.GONE
                    }
                    1 -> {
                        arrowBack.visibility = View.VISIBLE
                        arrowForward.visibility = View.VISIBLE
                        btnFinish.visibility = View.GONE
                    }
                    else -> {
                        arrowForward.visibility = View.GONE
                        btnFinish.visibility = View.VISIBLE
                    }
                }

                btnFinish.setOnClickListener {
                    listener.onClick()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(
            BoardItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(boardList[position])
    }

    override fun getItemCount(): Int = boardList.size

}
