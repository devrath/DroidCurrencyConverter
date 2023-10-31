package com.istudio.common.modules.network.api

import com.istudio.common.BuildConfig
import com.istudio.models.remote.Currencies
import com.istudio.models.remote.CurrencyConversionValues
import retrofit2.http.GET

interface CurrencyApi {

    companion object {
        const val APP_ID = BuildConfig.API_KEY
    }

    // API -> Getting the list of currencies
    // DOC -> https://docs.openexchangerates.org/reference/currencies-json
    @GET("currencies.json")
    suspend fun getCurrencies(): Currencies

    // API -> Getting the conversion values for all currencies
    // DOC -> https://docs.openexchangerates.org/reference/latest-json
    @GET("latest.json?app_id=$APP_ID")
    suspend fun getCurrencyConversionValues(): CurrencyConversionValues

}