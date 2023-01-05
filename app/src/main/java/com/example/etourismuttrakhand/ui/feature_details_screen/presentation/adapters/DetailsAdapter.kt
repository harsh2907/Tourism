package com.example.etourismuttrakhand.ui.feature_details_screen.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.etourismuttrakhand.databinding.PlaceDetailsImageTemplate2Binding
import com.example.etourismuttrakhand.ui.feature_details_screen.models.Place

class DetailsAdapter:RecyclerView.Adapter<DetailsAdapter.PlaceViewHolder>() {

    inner class PlaceViewHolder(val binding: PlaceDetailsImageTemplate2Binding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
       return PlaceViewHolder(
           PlaceDetailsImageTemplate2Binding.inflate(
               LayoutInflater.from(parent.context),
               parent,
               false
           )
       )
    }

    private val diffUtil = object :DiffUtil.ItemCallback<Int>(){
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == oldItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,diffUtil)

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val binding = holder.binding
        val item = differ.currentList[position]
        binding.thumbnail.setImageResource(item)
    }

    override fun getItemCount() = differ.currentList.size

    private var onItemClicked:((Place)->Unit)?=null
    fun setOnItemClickedListener( listener:(Place)->Unit){
        onItemClicked = listener
    }
}