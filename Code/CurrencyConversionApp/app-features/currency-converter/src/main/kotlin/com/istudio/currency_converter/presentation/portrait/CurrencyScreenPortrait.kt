package com.istudio.currency_converter.presentation.portrait

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.istudio.core_ui.composables.DropDownField
import com.istudio.core_ui.composables.GridInput
import com.istudio.core_ui.composables.InputTextField
import com.istudio.core_ui.theme.LocalSpacing
import com.istudio.models.Keys.defaultCurrency
import com.istudio.models.local.CurrencyAndRates
import com.istudio.models.local.CurrencyEntity
import com.istudio.models.local.RatesEntity

@Composable
fun CurrencyScreenPortrait(
    curriencyList : List<CurrencyEntity>,
    curriencyRatesList : List<CurrencyAndRates>,
    currencyInputText : String,
    isCurrencyFieldError : Boolean = false,
    isCurrencyValueDropDownError : Boolean = false,
    onKeyBoardOutsideClick: () -> Unit,
    currencyInputChange : (String) -> Unit,
    setRatesItemSelection : (Int) -> Unit,
    // -----> Drop down data
    currencyTypeState: MutableState<CurrencyEntity> = mutableStateOf(defaultCurrency),
    updateDropDownState : (MutableState<CurrencyEntity>) -> Unit,
    // -----> KeyBoard Action
    keyBoardDoneAction : () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(LocalSpacing.current.spaceSmall)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    onKeyBoardOutsideClick.invoke()
                })
            },
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    ) {

        InputTextField(
            modifier = Modifier.fillMaxWidth(),
            currencyInputText = currencyInputText,
            isError = isCurrencyFieldError,
            currencyInputChange = { currencyInputChange.invoke(it) },
            doneAction = { keyBoardDoneAction }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {

            Spacer(
                modifier = Modifier
                .height(LocalSpacing.current.spaceExtraSmall)
                .width(5.dp).weight(1f)
            )

            Box(
                modifier = Modifier.animateContentSize()
            ) {
                DropDownField(
                    dataList = curriencyList,
                    isError = isCurrencyValueDropDownError,
                    currencyTypeState = currencyTypeState,
                    updateDropDownState = updateDropDownState,

                )
            }
        }

        Spacer(modifier = Modifier.height(LocalSpacing.current.spaceExtraSmall))

        GridInput(data = curriencyRatesList){ selectedItem ->
            setRatesItemSelection.invoke(selectedItem)
        }
    }
}