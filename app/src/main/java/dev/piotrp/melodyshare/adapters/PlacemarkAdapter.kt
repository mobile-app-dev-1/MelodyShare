package dev.piotrp.melodyshare.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.piotrp.melodyshare.databinding.CardPlacemarkBinding
import dev.piotrp.melodyshare.models.PlacemarkModel

interface PlacemarkListener {
    fun onPlacemarkClick(placemark: PlacemarkModel)
}

class PlacemarkAdapter(private var placemarks: List<PlacemarkModel>, private val listener: PlacemarkListener) :
    RecyclerView.Adapter<PlacemarkAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardPlacemarkBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val placemark = placemarks[holder.adapterPosition]
        holder.bind(placemark, listener)
    }

    override fun getItemCount(): Int = placemarks.size

    class MainHolder(private val binding : CardPlacemarkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(placemark: PlacemarkModel, listener: PlacemarkListener) {
            binding.placemarkTitle.text = placemark.title
            binding.placemarkDescription.text = placemark.description
            binding.root.setOnClickListener { listener.onPlacemarkClick(placemark) }
        }
    }
}