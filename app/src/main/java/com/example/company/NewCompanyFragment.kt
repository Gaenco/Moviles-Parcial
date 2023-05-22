package com.example.company

import android.os.Bundle
import android.util.Log
import android.view.DisplayCutout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.company.databinding.FragmentNewCompanyBinding

class NewCompanyFragment : Fragment() {

    private val companyViewModel: CompanyViewModel by activityViewModels {
        CompanyViewModel.Factory
    }

    private lateinit var binding : FragmentNewCompanyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewCompanyBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observerStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = companyViewModel

    }

    private fun observerStatus() {
        companyViewModel.status.observe(viewLifecycleOwner) {
                status -> when {
            status.equals(CompanyViewModel.WRONG_INFORMATION) -> {
                Log.d(APP_TAG, status)
                companyViewModel.clearStatus()
            }
            status.equals(CompanyViewModel.COMPANY_CREATED) -> {
                Log.d(APP_TAG, status)
                Log.d(APP_TAG, companyViewModel.getCompanys().toString())

                companyViewModel.clearStatus()
                findNavController().popBackStack()
            }
        }
        }

    }

    companion object {
        const val APP_TAG = "APP TAG"
    }



    // add a movie using the view model




}