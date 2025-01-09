package com.lilin.pokedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
fun FirstScreen(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = modifier.shadow(8.dp),
                title = { Text("FirstScreen AppBar") },
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { onClick() }) {
                Image(
                    painter = painterResource(R.drawable.ic_add),
                    contentDescription = "Localized description"
                )
            }
        }
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it),
            text = "First Screen",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
internal fun FirstScreenTestView() {
    FirstScreen(
        onClick = {}
    )
}

@Preview
@Composable
fun FirstScreenPreview() {
    FirstScreen(
        onClick = {}
    )
}
