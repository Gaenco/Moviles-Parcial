package com.example.company.ui.company

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.company.R
import com.example.company.data.model.CompanyModel

class CompanyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var nameTextView =
        itemView.findViewById<TextView>(R.id.company_name)

    private var sectorTextView =
        itemView.findViewById<TextView>(R.id.company_sector)


    fun bind(company: CompanyModel, onClickListener: (CompanyModel) -> Unit) {
        nameTextView.text = company.name
        sectorTextView.text = company.sector

        nameTextView.setOnClickListener {
            onClickListener(company)
        }

        sectorTextView.setOnClickListener {
            onClickListener(company)
        }
    }

}
