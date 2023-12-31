package com.istudio.network.di

import com.istudio.network.BuildConfig
import com.istudio.network.Keys.BASE_URL
import com.istudio.network.api.CurrencyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /*****************************
     * PROVIDES:-> Currency-Api
     * ***************************
     * CONSTRUCTOR INPUT:-> Retrofit
     *****************************/
    @Provides
    @Singleton
    fun provideCurrencyApi(
        retrofit: Retrofit
    ): CurrencyApi {
        return retrofit.create(CurrencyApi::class.java)
    }

    /*****************************
     * PROVIDES:-> Retrofit
     * ***************************
     * CONSTRUCTOR INPUT:-> OkHttp
     *****************************/
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /*****************************
     * PROVIDES:-> Okhttp
     * ***************************
     * CONSTRUCTOR INPUT:-> None
     *****************************/
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            // Add interceptor only for DEBUG
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpBuilder.addInterceptor(loggingInterceptor)
        }
        // Add the timeouts
        okHttpBuilder.apply {
            connectTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
        }

        // Construct the object
        return okHttpBuilder.build()
    }

}