package com.example.company.data

import com.example.company.data.model.CompanyModel

// company
val name = "Burger King"
val sector = "Administration"

val name2 = "Nike"
val sector2 = "Finances"

var companys = mutableListOf(
    CompanyModel(name, sector),
    CompanyModel(name2, sector2),
)