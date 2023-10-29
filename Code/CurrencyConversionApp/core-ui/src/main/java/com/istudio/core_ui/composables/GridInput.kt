package com.istudio.core_ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GridInput(
    modifier: Modifier = Modifier,
){

    // Context
    val cxt = LocalContext.current
    val noOfColumns = 3

    val state = rememberLazyGridState()

    LazyVerticalGrid(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
        columns = GridCells.Fixed(noOfColumns),
        state = state,
        content = {
            items(100){ i ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(5.dp))
                        .background(color = MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Text->$i",
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    )

}

@Preview
@Composable
private fun CurrentDisplay() {
    GridInput()
}