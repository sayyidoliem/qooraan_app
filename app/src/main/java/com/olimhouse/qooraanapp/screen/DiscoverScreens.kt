package com.olimhouse.qooraanapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.olimhouse.compose.QOORAANAppTheme
import com.olimhouse.qooraanapp.data.kotpref.Qories

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverScreens(openDrawer: () -> Unit) {
    QOORAANAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val scope = rememberCoroutineScope()
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = "Qori Listener",
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        },
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                        navigationIcon = {
                            IconButton(onClick = { openDrawer() }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        }
                    )
                },
            ) { it ->
                Column(modifier = Modifier.padding(it)) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        onClick = { /*TODO*/ }
                    ) {
                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = "Your Bookmarks",
                                modifier = Modifier
                                    .padding(vertical = 16.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.padding(vertical = 8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Bookmarks,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        Modifier
                            .background(color = MaterialTheme.colorScheme.background),
                    ) {
                        items(Qories.values()) { Qories ->
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                CardVideo(modifier = Modifier.clickable {  },Qories.qoriName, Qories.qoriImage)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CardVideo(
    modifier: Modifier,
    name: String,
    image : String
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier.padding(16.dp)) {
        Box(Modifier.fillMaxSize()) {
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxSize().clickable { }
            )
            Text(
                text = name,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
//                color = Color.LightGray,
                style = TextStyle(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Gray, Color.DarkGray)
                    ),
                    shadow = Shadow(
                        color = Color.Gray, offset = Offset(5.0f, 10.0f), blurRadius = 3f
                    )
                )
            )
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
                    .clickable { expanded = true },
                tint = Color.LightGray
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Change Language") },
                    onClick = {
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Translate,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }
}