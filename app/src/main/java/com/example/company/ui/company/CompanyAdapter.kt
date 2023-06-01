package com.example.company.ui.company

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.company.R
import com.example.company.data.model.CompanyModel

class CompanyAdapter(private val clickListener: (CompanyModel) -> Unit) : RecyclerView.Adapter<CompanyViewHolder>() {

    private var data: List<CompanyModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {
        val inflater = LayoutInflater.from (parent.context)
        val view = inflater.inflate(R.layout.item_company, parent, false)

        return CompanyViewHolder(view)
    }

    fun setData(data: List<CompanyModel>) {
        this.data = data
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        data?.let {
            val company = it[position]
            holder.bind(company, clickListener)
        }
    }


}