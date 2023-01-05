package com.example.etourismuttrakhand.ui.feature_details_screen.presentation.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.etourismuttrakhand.databinding.PlaceDetailsImageTemplateBinding
import com.example.etourismuttrakhand.ui.feature_details_screen.models.Place

class SearchAdapter:RecyclerView.Adapter<SearchAdapter.PlaceViewHolder>() {

    inner class PlaceViewHolder(val binding: PlaceDetailsImageTemplateBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
       return PlaceViewHolder(
           PlaceDetailsImageTemplateBinding.inflate(
               LayoutInflater.from(parent.context),
               parent,
               false
           )
       )
    }

    private val diffUtil = object :DiffUtil.ItemCallback<Place>(){
        override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem.image == newItem.image
        }

        override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,diffUtil)

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val binding = holder.binding
        val item = differ.currentList[position]

        binding.popularCard1.setOnClickListener {
            onItemClicked?.let {onItemClick->
                onItemClick(item)
            }
        }
        binding.thumbnail.setImageResource(item.image.random())
        binding.location.text = item.name
    }

    override fun getItemCount() = differ.currentList.size

    private var onItemClicked:((Place)->Unit)?=null
    fun setOnItemClickedListener( listener:(Place)->Unit){
        onItemClicked = listener
    }
}