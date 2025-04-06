package com.example.a30daysofcartips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a30daysofcartips.data.Datasource
import com.example.a30daysofcartips.model.Tip
import com.example.a30daysofcartips.ui.theme._30DaysOfCarTipsTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysOfCarTipsTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                        color = MaterialTheme.colorScheme.background
                ) {
                    CarsTipsApp()
                }
            }
        }
    }
}

@Composable
fun CarsTipsApp(){
    Column(modifier = Modifier.fillMaxSize()) {
    Text(
        text = stringResource(R.string.app_name),
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(16.dp),
    )
    TipList(tipList = Datasource().loadTips())
    }
}

@Composable
fun TipsCard(tip: Tip, modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .padding(8.dp)
            .clickable { expanded = !expanded },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.animateContentSize()) {
            Text(
                text = stringResource(tip.dayResourceId),
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                style = MaterialTheme.typography.labelLarge
            )

            Text(
                text = stringResource(tip.titleResourceId),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp),
                style = MaterialTheme.typography.titleMedium
            )

            Image(
                painter = painterResource(tip.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )

            if (expanded) {
                Text(
                    text = stringResource(tip.descriptionResourceId),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
private fun TipList(tipList: List<Tip>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier){
        items(tipList) {tip -> TipsCard(tip = tip) }
    }
}

@Preview
@Composable
private fun TipCardPreview() {
    TipsCard(tip = Tip(R.string.tip1_day, R.string.tip1_titulo, R.string.tip1_conteudo, R.drawable.tip1))
}