package com.example.company

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class HomeFragment : Fragment() {

    private lateinit var btnNewCompanyFragment: Button
    private lateinit var btnCompanyFragment: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        btnCompanyFragment.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_companyFragment)
        }
        btnNewCompanyFragment.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_newCompanyFragment)
        }
    }

private fun bind(){
    btnCompanyFragment = view?.findViewById(R.id.companyFragment) as Button
    btnNewCompanyFragment = view?.findViewById(R.id.btn_new_company) as Button
}

    }
