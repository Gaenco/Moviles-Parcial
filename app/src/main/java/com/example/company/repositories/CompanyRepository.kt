package com.example.company.repositories

import com.example.company.data.model.CompanyModel

class MovieRepository(private val companys: MutableList<CompanyModel>) {

    fun getCompanys() = companys

    // add a new company to the list of companys dummyData.kt
    fun addCompanys(company: CompanyModel) = companys.add(company)


}