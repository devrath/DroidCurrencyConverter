package com.istudio.network.data

import com.istudio.models.remote.Currencies
import com.istudio.models.remote.CurrencyConversionValues
import javax.inject.Inject

open class CurrencyApiRepository @Inject constructor(
    private val features : CurrencyApiImpl
) {

    suspend fun getCurrencies(): Currencies {
        return features.getCurrencies()
    }

    suspend fun getCurrencyConversionValues(base:String): CurrencyConversionValues {
        return features.getCurrencyConversionValues(base)
    }

}