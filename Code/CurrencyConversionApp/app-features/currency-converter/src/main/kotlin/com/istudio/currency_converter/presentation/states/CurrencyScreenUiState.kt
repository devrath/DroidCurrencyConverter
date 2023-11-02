package com.istudio.currency_converter.presentation.states

import com.istudio.models.local.CurrencyEntity
import com.istudio.models.local.RatesEntity

data class CurrencyScreenUiState(
    val currencyUserEnteredInput: String = "",
    val currencyUserConversionInput: String = "",

    val currencyUserEnteredInputError: Boolean = false,
    val currencyUserConversionInputError: Boolean = false,
    // This flg is set once - > From launched effect state, To start collecting emits only once
    val launchedEffectState: Boolean = false,
    // This variable holds the currency list data
    val currencyList: List<CurrencyEntity> = emptyList(),
    // This variable holds the currency rates data
    val currencyRatesList: List<RatesEntity> = emptyList(),
    // This flag indicates if the currency information is displayed or not
    val isCurrencyDataDisplayed : Boolean = false,
    // This flag indicates if the rates information is displayed or not
    val isCurrencyRatesDataDisplayed : Boolean = false,
    // This flag controls the visibility of UI whether it has to be visible or invisible
    val canUiBeDisplayed : Boolean = false
)