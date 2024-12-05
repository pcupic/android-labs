package hr.ferit.patrikcupic.myapplication.ui

import Pink
import Purple500
import White
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hr.ferit.patrikcupic.myapplication.R
import androidx.compose.foundation.layout.Row as Row

@Preview(showBackground = true)
@Composable
fun RecipesScreen() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        ScreenTitle(
            title = "What would you like to cook today?",
            subtitle = "Good morning, Patrik"
        )
        SearchBar(
            iconResource = R.drawable.ic_search,
            labelText = "Search something"
        )
        RecipeCategories()
        RecipeCard(imageResource = R.drawable.strawberry_pie_2, title = "Strawberry pie")
        IconButton(iconResource = R.drawable.ic_plus, text = "Add new recipe")
    }
}

@Composable
fun ScreenTitle(title: String, subtitle: String) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = subtitle,
            style = TextStyle(
                color = Purple500,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    @DrawableRes iconResource: Int,
    labelText: String,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent,
        placeholderColor = Color.DarkGray,
        textColor = Color.DarkGray,
        unfocusedLabelColor = Color.DarkGray,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
    )
) {
    val searchInput = remember { mutableStateOf("") }
    TextField(
        value = searchInput.value,
        onValueChange = { searchInput.value = it },
        label = { Text(labelText) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = labelText,
                tint = Color.DarkGray,
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
            )
        },
        colors = colors,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun TabButton(
    text: String,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Button (
        shape = RoundedCornerShape(24.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
        colors = if (isActive) {
            ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Pink)
        } else {
            ButtonDefaults.buttonColors(contentColor = Color.DarkGray, containerColor = Color.LightGray)
        },
        onClick = { onClick() }
    ) {
        Text(text)
    }
}

@Composable
fun RecipeCategories() {
    val currentActiveButton = remember { mutableStateOf(0) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(44.dp)
    ) {
        TabButton(
            text = "All",
            isActive = currentActiveButton.value == 0,
        ) { currentActiveButton.value = 0 }
        TabButton(
            text = "Breakfast",
            isActive = currentActiveButton.value == 1,
        ) { currentActiveButton.value = 1 }
        TabButton(
            text = "Lunch",
            isActive = currentActiveButton.value == 2,
        ) { currentActiveButton.value = 2 }
    }
}

@Composable
fun IconButton(
    @DrawableRes iconResource: Int,
    text: String,
    colors: ButtonColors = ButtonDefaults.buttonColors(containerColor = Pink)
) {
    Button (
        onClick = { },
        colors = colors,
    ) {
        Row {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = text
            )
            Spacer(Modifier.width(2.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
            )
        }
    }
}


@Composable fun Chip(
    text: String,
    backgroundColor: Color = Color.White,
    textColor: Color = Color.Magenta,
) {
    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = textColor,
                fontSize = 12.sp
            )
        )
    }
}

@Composable
fun RecipeCard(
    @DrawableRes imageResource: Int,
    title: String
) {
    Box(
        modifier = Modifier
            .width(215.dp)
            .height(326.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(26.dp))
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = title,
                style = TextStyle (
                    color = White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Row {
                Chip(text = "30 min", backgroundColor = White, textColor = Pink)
                Spacer(modifier = Modifier.width(4.dp))
                Chip(text = "4 Ingredients", backgroundColor = White, textColor = Pink)
            }
        }
    }
}
