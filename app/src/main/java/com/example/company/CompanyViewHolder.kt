package com.example.company

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.company.data.model.CompanyModel

class CompanyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var nameTextView =
        itemView.findViewById<TextView>(R.id.company_name)

    private var sectorTextView =
        itemView.findViewById<TextView>(R.id.company_sector)


    fun bind(movie: CompanyModel, onClickListener: (CompanyModel) -> Unit) {
        nameTextView.text = movie.name
        sectorTextView.text = movie.sector

        nameTextView.setOnClickListener {
            onClickListener(movie)
        }

        sectorTextView.setOnClickListener {
            onClickListener(movie)
        }
    }

}
