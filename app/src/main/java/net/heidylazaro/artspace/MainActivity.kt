package net.heidylazaro.artspace

import android.media.Image
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.heidylazaro.artspace.ui.theme.ArtSpaceTheme
import org.w3c.dom.Text

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
    var previous by remember{ mutableStateOf(1) }
    //var next by remember{ mutableStateOf(1) }
    Surface() {
        Column(modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = ArtImageClick(result = previous)),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(0.75f)
                // .border(width = 4.dp, color = Color.LightGray)
            )
            Text(
                text = stringResource(id = ArtNameClick(result = previous)),
                fontWeight = FontWeight.Light,
                fontSize = 25.sp
            )
            Text(
                text = stringResource(id = ArtDateClick(result = previous)),
                fontWeight = FontWeight.Bold

            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { /*TODO*/
                    if (previous>1){
                        previous--
                    }else{
                        previous=1
                    }
                              },
                    modifier = Modifier.padding(16.dp)) {
                    Text(text = "Previous")
                }

                Button(
                    onClick = { /*TODO*/
                        if (previous<8){
                            previous++
                        }else{
                            previous=7
                        }
                              },
                    modifier = Modifier.padding(16.dp))
                {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Composable
fun ArtImageClick(result: Int):Int{
    val imageResource = when(result){
        1->R.drawable.frida_1
        2->R.drawable.frida_2
        3-> R.drawable.miguel_1
        4->R.drawable.raphael_1
        5->R.drawable.raphael_2
        6->R.drawable.vinci_1
        else->R.drawable.vinci_2
    }
    return imageResource
}
@Composable
fun ArtNameClick(result: Int):Int{
    val nameStringResource = when(result){
        1->R.string.frida_1
        2->R.string.frida_2
        3->R.string.miguel_1
        4->R.string.raphael_1
        5->R.string.raphael_2
        6->R.string.vinci_1
        else->R.string.vinci_2
    }
    return nameStringResource
}
@Composable
fun ArtDateClick(result: Int):Int{
    val dateStringResource = when(result){
        1->R.string.frida_date_1
        2->R.string.frida_date_2
        3->R.string.miguel_date_1
        4->R.string.raphael_date_1
        5->R.string.raphael_date_2
        6->R.string.vinci_date_1
        else-> R.string.vinci_date_2
    }
    return dateStringResource
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceGreeting()
    }
}