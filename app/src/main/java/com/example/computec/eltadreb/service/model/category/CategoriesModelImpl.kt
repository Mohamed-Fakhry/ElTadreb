package com.example.computec.eltadreb.service.model.category

import com.example.computec.eltadreb.App
import com.example.computec.eltadreb.model.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesModelImpl : CategoriesModel {
    override fun getCategories(listener: CategoriesModel.OnGetCategoriesListener) {
        App.getService.getCoursesSortBYCategory().enqueue(object: Callback<MutableList<Category>> {
            override fun onResponse(call: Call<MutableList<Category>>, response: Response<MutableList<Category>>) =
                    when {
                        response.isSuccessful -> listener.onSuccess(response.body()!!)
                        response.code() == 401 -> listener.onCanceled()
                        else -> listener.onCanceled()
                    }

            override fun onFailure(call: Call<MutableList<Category>>, t: Throwable) {
                listener.onCanceled()
            }
        })
    }
}