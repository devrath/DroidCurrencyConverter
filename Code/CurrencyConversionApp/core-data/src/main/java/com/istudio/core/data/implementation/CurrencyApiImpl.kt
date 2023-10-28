package com.istudio.core.data.implementation

import com.istudio.core.data.modules.api.CurrencyApi
import com.istudio.core.domain.api.CurrencyApiFeatures
import com.istudio.core.domain.models.Currencies
import com.istudio.core.domain.models.CurrencyConversionValues
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CurrencyApiImpl @Inject constructor(
    private val api : CurrencyApi
) : CurrencyApiFeatures {
    override suspend fun getCurrencies(): Flow<Currencies> {
        return api.getCurrencies()
    }

    override suspend fun getCurrencyConversionValues(): Flow<CurrencyConversionValues> {
        return api.getCurrencyConversionValues()
    }
}