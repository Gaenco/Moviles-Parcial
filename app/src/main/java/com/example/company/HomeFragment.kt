package com.example.company

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
import com.example.company.data.companys
import com.example.company.data.model.CompanyModel
import com.example.company.databinding.FragmentCompanyBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentCompanyBinding
    private lateinit var adapter: CompanyAdapter
    private lateinit var btnCreateNewMovie: Button


    private val movieViewModel: CompanyViewModel by activityViewModels {
        CompanyViewModel.Factory
    }

    private fun showSelectedItem(movie: CompanyModel) {
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_homeFragment_to_companyFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompanyBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setRecyclerView(view: View) {
        binding.cardrecycler.layoutManager = LinearLayoutManager(view.context)
        adapter = CompanyAdapter { selectedMovie -> showSelectedItem(selectedMovie) }
        binding.cardrecycler.adapter = adapter
        displayMovies()
    }

    private fun displayMovies() {
        adapter.setData(movieViewModel.getCompanys())
        adapter.notifyDataSetChanged()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)
        adapter.setData(companys)

        btnCreateNewMovie.setOnClickListener {
            movieViewModel.clearData()

            it.findNavController().navigate(R.id.action_homeFragment_to_newCompanyFragment)
        }

    }
}