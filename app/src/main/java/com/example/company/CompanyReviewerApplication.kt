package com.example.company

import android.app.Application
import com.example.company.data.companys
import com.example.company.repositories.CompanyRepository
import java.util.concurrent.ConcurrentMap

class CompanyReviewerApplication: Application(){
    val CompanyRepository: CompanyRepository by lazy {
        CompanyRepository(companys)
    }
}
