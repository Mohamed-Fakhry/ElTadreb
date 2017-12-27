package com.example.computec.eltadreb.ui.base

import android.app.Dialog
import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.annotation.StringRes
import android.view.View
import com.example.computec.eltadreb.utils.CommonUtils

abstract class BaseYoutubeFragment : Fragment(), MvpView {

    var baseActivity: BaseYoutubeCustomActivity? = null

    private var mProgressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseYoutubeCustomActivity) {
            val activity = context as BaseYoutubeCustomActivity?
            this.baseActivity = activity
            activity!!.onFragmentAttached()
        }
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = CommonUtils.showLoadingDialog(this!!.activity)
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    override fun onError(message: String?) {
        baseActivity!!.onError(message)
    }

    override fun onError(@StringRes resId: Int) {
        baseActivity!!.onError(resId)
    }

    override fun showMessage(message: String?) {
        baseActivity!!.showMessage(message)
    }

    override fun showMessage(@StringRes resId: Int) {
        baseActivity!!.showMessage(resId)
    }

    override fun isNetworkConnected(): Boolean = baseActivity!!.isNetworkConnected()

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    override fun hideKeyboard() {
        baseActivity!!.hideKeyboard()
    }

    override fun openActivityOnTokenExpire() {
        baseActivity!!.openActivityOnTokenExpire()
    }

    protected abstract fun setUp(view: View?)

    override fun onDestroy() {
        super.onDestroy()
    }

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}