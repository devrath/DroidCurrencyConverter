package com.istudio.currency_converter.fakes.data.repository

import com.istudio.currency_converter.fakes.domain.features.CurrencyControllerFeaturesFake
import com.istudio.models.local.CurrencyAndRates
import com.istudio.models.local.CurrencyEntity
import com.istudio.models.local.RatesEntity
import com.istudio.models.remote.Currencies
import com.istudio.models.remote.CurrencyConversionValues
import kotlinx.coroutines.flow.Flow

class RepositoryControllerFeaturesFake(
    private val repoImpl : CurrencyControllerFeaturesFake
) : CurrencyControllerFeaturesFake() {


    override suspend fun getCurrenciesFromApi(): Currencies {
        return repoImpl.getCurrenciesFromApi()
    }

    // Get the currency conversion values fata from api
    override suspend fun getCurrencyConversionValuesFromApi(base:String): CurrencyConversionValues {
        return repoImpl.getCurrencyConversionValuesFromApi(base)
    }

    // Insert currencies data into the database
    override suspend fun insertCurrenciesIntoDb(currency: CurrencyEntity) {
        repoImpl.insertCurrenciesIntoDb(currency)
    }

    // Insert currency rates into the database
    override suspend fun insertRatesIntoDb(rates: RatesEntity) {
        repoImpl.insertRatesIntoDb(rates)
    }

    // Retrieve currencies data into the database
    override suspend fun getCurrenciesListFromDb() : Flow<List<CurrencyEntity>> {
        return repoImpl.getCurrenciesListFromDb()
    }

    // Retrieve currency rates into the database
    override suspend fun getRatesListFromDb() : List<CurrencyAndRates> {
        return repoImpl.getRatesListFromDb()
    }

    override suspend fun getCurrencyAndRates(): List<CurrencyAndRates> {
        return repoImpl.getCurrencyAndRates()
    }

}