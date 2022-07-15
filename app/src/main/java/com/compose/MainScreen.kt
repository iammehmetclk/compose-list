package com.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.compose.ui.theme.*

@Composable
fun MainScreen(viewModel: MainViewModel) {
    ComposeTheme {
        Scaffold(
            topBar = {
                TopAppBar {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        color = White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 12.dp)
                    )
                }
            },
            content = {
                Column(
                    content = {
                        LazyColumn(
                            modifier = Modifier.weight(1F),
                            content = {
                                itemsIndexed(viewModel.items) { index, item ->
                                    if (index == 0) {
                                        Spacer(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(16.dp)
                                        )
                                    }
                                    MainItem(item)
                                    Spacer(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(16.dp)
                                    )
                                }
                            }
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color1)
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 16.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(Purple500)
                                    .clickable {
                                        viewModel.addItem()
                                    }
                                    .padding(16.dp)
                                    .align(Alignment.CenterVertically)
                                    .weight(1f),
                                text = "Add Item",
                                color = White,
                                textAlign = TextAlign.Center,
                            )
                            Text(
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 16.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(Purple500)
                                    .padding(16.dp)
                                    .align(Alignment.CenterVertically)
                                    .weight(1f),
                                text = "Item Count: ${viewModel.count}",
                                color = White,
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                )
            }
        )
    }
}

@Composable
fun MainItem(item: ItemModel) {
    Row(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(item.imageUrl)
                .crossfade(true)
                .build(),
            modifier = Modifier
                .clip(CircleShape)
                .background(Color2)
                .width(56.dp)
                .height(56.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )
        Column(
            modifier = Modifier
                .weight(1F)
                .padding(start = 16.dp)
        ) {
            Text(
                text = item.title,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                fontSize = 14.sp,
                color = Black,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = item.description,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                fontSize = 16.sp,
                color = Black_64,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}