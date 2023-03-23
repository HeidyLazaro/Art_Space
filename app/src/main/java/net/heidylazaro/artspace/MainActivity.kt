package net.heidylazaro.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.heidylazaro.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceGreeting()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceGreeting(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
    Surface() {
        Column(modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.frida_1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(0.75f)
                   // .border(width = 4.dp, color = Color.LightGray)
            )
            Text(
                text = stringResource(id = R.string.frida_1)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(16.dp)) {
                    Text(text = "Previous")
                }

                Button(onClick = { /*TODO*/ },modifier = Modifier.padding(16.dp)) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Composable
fun Art(

){

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceGreeting()
    }
}