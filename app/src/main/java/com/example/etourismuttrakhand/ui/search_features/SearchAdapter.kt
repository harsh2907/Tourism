package com.example.etourismuttrakhand.ui.search_features

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.etourismuttrakhand.databinding.PlaceDetailsImageTemplateBinding
import com.example.etourismuttrakhand.ui.feature_details_screen.data.model.PlaceImage
import com.example.etourismuttrakhand.ui.features_favourite.data_source.entities.Place

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
            return oldItem.image == oldItem.image
        }

        override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,diffUtil)

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val binding = holder.binding
        val item = differ.currentList[position]
        binding.thumbnail.setImageResource(item.image.random())
        binding.location.text = item.name
    }

    override fun getItemCount() = differ.currentList.size

    private var onItemClicked:((Place)->Unit)?=null
    fun setOnItemClickedListener( listener:(Place)->Unit){
        onItemClicked = listener
    }
}