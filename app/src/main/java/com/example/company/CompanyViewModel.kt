package com.example.company

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.company.data.model.CompanyModel
import com.example.company.repositories.CompanyRepository

class CompanyViewModel(private val repository: CompanyRepository) : ViewModel() {
    var name = MutableLiveData("")
    var sector = MutableLiveData("")
    var status = MutableLiveData("")


    fun setSelectedMovie(company: CompanyModel){
        name.value = company.name
        sector.value = company.sector
    }

    fun getCompanys() = repository.getCompanys()

    fun addCompanys(company: CompanyModel) = repository.addCompanys(company)

    fun createCompany() {
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val company = CompanyModel(
            name.value!!,
            sector.value!!,


        )
        addCompanys(company)
        clearData()

        status.value = COMPANY_CREATED
    }

    private fun validateData() : Boolean{
        when {

            name.value.isNullOrEmpty() -> return false
            sector.value.isNullOrEmpty() -> return false

        }
        return true
    }

    fun clearData(){
        name.value = ""
        sector.value = ""

    }

    fun clearStatus(){
        status.value = INACTIVE

    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as CompanyReviewerApplication
                CompanyViewModel(app.CompanyRepository)
            }
        }

        const val COMPANY_CREATED = "Company created"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE = ""
    }
}