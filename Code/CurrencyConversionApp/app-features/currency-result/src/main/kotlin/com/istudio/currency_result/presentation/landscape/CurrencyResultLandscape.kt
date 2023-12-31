package com.istudio.currency_result.presentation.landscape

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.istudio.core_ui.composables.AnimatedCard
import com.istudio.currency_result.presentation.states.CurrencyResultScreenUiState
import com.istudio.models.custom.CurrencyResultInput


@Composable
fun CurrencyResultLandscape(
    state: MutableState<CurrencyResultScreenUiState>
) {

    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        val paddingModifier = Modifier.padding(10.dp)
        val cardPadding = 16.dp

        AnimatedCard(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(cardPadding).height(200.dp).weight(1f),
        ) {
            Box(
                modifier = Modifier.width(400.dp).padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "User entered currency",
                        modifier = paddingModifier,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = state.value.userEnteredCardDetails,
                        modifier = paddingModifier,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )

                }
            }
        }

        AnimatedCard(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(16.dp).height(200.dp).weight(1f),
        ) {
            Box(
                modifier = Modifier.width(400.dp).padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Converted currency",
                        modifier = paddingModifier,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = state.value.userCalculatedCardDetails,
                        modifier = paddingModifier,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}