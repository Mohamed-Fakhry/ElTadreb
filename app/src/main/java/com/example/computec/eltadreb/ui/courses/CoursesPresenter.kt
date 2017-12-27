package com.example.computec.eltadreb.ui.courses

import com.example.computec.eltadreb.model.Category
import com.example.computec.eltadreb.service.model.category.CategoriesModel
import com.example.computec.eltadreb.service.model.category.CategoriesModelImpl
import com.example.computec.eltadreb.ui.base.BasePresenter

class CoursesPresenter<V: CoursesContract.View>: BasePresenter<V>(), CoursesContract.Presenter<V>, CategoriesModel.OnGetCategoriesListener {

    val categoriesModel: CategoriesModel = CategoriesModelImpl()

    override fun getCourses() {
        mvpView?.showLoading()
        categoriesModel.getCategories(this)
    }

    override fun onSuccess(categories: MutableList<Category>) {
        mvpView?.hideLoading()
        mvpView?.setCourses(categories)
    }

    override fun onCanceled() {
        mvpView?.hideLoading()
    }

    override fun onAccountStopped() {
        mvpView?.hideLoading()
    }
}