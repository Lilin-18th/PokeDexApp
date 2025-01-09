package com.lilin.pokedex.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lilin.pokedex.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = modifier.shadow(8.dp),
                title = { Text("SecondScreen AppBar") },
                navigationIcon = {
                    IconButton(onClick = { onClickBack() }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_back),
                            contentDescription = "navigation back"
                        )
                    }
                }
            )
        },
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it),
            text = "Second Screen",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
internal fun SecondScreenTestView() {
    SecondScreen(
        onClickBack = {}
    )
}

@Preview
@Composable
fun SecondScreenPreview() {
    SecondScreen(
        onClickBack = {}
    )
}
