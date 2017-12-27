package com.example.computec.eltadreb.service.model.category

import com.example.computec.eltadreb.model.Category

interface CategoriesModel {

    interface OnGetCategoriesListener {

        fun onCanceled()

        fun onSuccess(categories: MutableList<Category>)

        fun onAccountStopped()
    }

    fun getCategories(listener: OnGetCategoriesListener)
}