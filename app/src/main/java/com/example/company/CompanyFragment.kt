package com.example.company

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.company.databinding.FragmentCompanyBinding

class CompanyFragment : Fragment() {

    private lateinit var binding: FragmentCompanyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompanyBinding.inflate(inflater,container,false)
        return binding.root
    }

}