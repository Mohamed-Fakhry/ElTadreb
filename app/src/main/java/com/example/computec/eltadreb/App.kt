package com.example.computec.eltadreb

import android.app.Application

import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.example.computec.eltadreb.data.service.AuthInterceptor
import com.example.computec.eltadreb.data.service.Constant
import com.example.computec.eltadreb.data.service.Service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        createApi(null)

        initCalligraphyConfig()
    }

    private fun initCalligraphyConfig() {
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.font_name))
                .setFontAttrId(R.attr.fontPath)
                .build())
    }

    companion object {

        lateinit var getService: Service

        internal fun createApi(authInterceptor: AuthInterceptor?) {
            val clientBuilder: OkHttpClient.Builder
            val client: OkHttpClient
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            clientBuilder = OkHttpClient.Builder()
                    .addInterceptor(interceptor)

            authInterceptor?.let {
                clientBuilder.addInterceptor(
                        authInterceptor
                    )
            }

            client = clientBuilder.build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            getService = retrofit.create(Service::class.java)
        }
    }
}
