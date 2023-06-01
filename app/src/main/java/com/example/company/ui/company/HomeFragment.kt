package com.example.company.ui.company

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.company.R
import com.example.company.data.companys
import com.example.company.data.model.CompanyModel
import com.example.company.databinding.FragmentCompanyBinding
import com.example.company.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: CompanyAdapter

    private val companyViewModel: CompanyViewModel by activityViewModels {
        CompanyViewModel.Factory
    }

    private fun showSelectedItem(company: CompanyModel) {
        companyViewModel.setSelectedCompany(company)
        findNavController().navigate(R.id.action_homeFragment_to_companyFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setRecyclerView(view: View){
        binding.RecycleCard.layoutManager = LinearLayoutManager(view.context)
        adapter = CompanyAdapter { selectedCompany -> showSelectedItem(selectedCompany) }
        binding.RecycleCard.adapter = adapter
        displayCompany()

    }


    private fun displayCompany() {
        adapter.setData(companyViewModel.getCompanys())
        adapter.notifyDataSetChanged()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)
        adapter.setData(companys)

        binding.btnNavCreateNewCompany.setOnClickListener {
            companyViewModel.clearData()

            it.findNavController().navigate(R.id.action_homeFragment_to_newCompanyFragment)
        }

    }
}