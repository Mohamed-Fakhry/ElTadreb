package com.example.computec.eltadreb

import android.app.Application

import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.example.computec.eltadreb.data.service.AuthInterceptor
import com.example.computec.eltadreb.data.service.Constant
import com.example.computec.eltadreb.data.service.Service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        createApi(null)
    }

    companion object {

        lateinit var getService: Service

        internal fun createApi(authInterceptor: AuthInterceptor?) {
            val clientBulider: OkHttpClient.Builder
            val client: OkHttpClient
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            clientBulider = OkHttpClient.Builder()
                    .addInterceptor(interceptor)

            authInterceptor.let {
                clientBulider.addInterceptor(
                        authInterceptor
                    )
            }

            client = clientBulider.build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            getService = retrofit.create(Service::class.java)
        }
    }
}
