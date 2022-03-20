package com.example.nika.mycompapp

import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nika.mycompapp.ui.theme.MyCompAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCompAppTheme {
                // A surface container using the 'background' color from the theme
                var oldnumber:Double=0.0;
                var newnumber:Double=0.0;
                var opertion:String="";
                Surface(color = MaterialTheme.colors.background) {
                   // Greeting("Android")
                    var text by remember { mutableStateOf("") }
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                        BigText(text)
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Buttonnumber("7") { text = text+"7";newnumber=text.toDouble() }
                            Buttonnumber("8") { text = text+"8";newnumber=text.toDouble() }
                            Buttonnumber("9") { text = text+"9";newnumber=text.toDouble() }
                            Buttonopertar("x"){ text = "";oldnumber=newnumber;newnumber=0.0;opertion="x"}
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Buttonnumber("4") { text = text+"4";newnumber=text.toDouble() }
                            Buttonnumber("5") { text = text+"5";newnumber=text.toDouble() }
                            Buttonnumber("6") { text = text+"6";newnumber=text.toDouble() }
                            Buttonopertar("-"){ text = "";oldnumber=newnumber;newnumber=0.0;opertion="-"}
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Buttonnumber("1") { text = text+"1";newnumber=text.toDouble() }
                            Buttonnumber("2") { text = text+"2";newnumber=text.toDouble() }
                            Buttonnumber("3") { text = text+"3";newnumber=text.toDouble() }
                            Buttonopertar("+"){ text = "";oldnumber=newnumber;newnumber=0.0;opertion="+"}
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Buttonnumber("0") { text = text + 0;newnumber = text.toDouble(); }
                            Buttonopertar("/"){text = "";oldnumber=newnumber;newnumber=0.0;opertion="/"}
                            Buttonopertar("="){ text = opertion1(oldnumber,newnumber,opertion)
                                ;newnumber=text.toDouble();oldnumber=0.0}
                            Buttonopertar("clear"){ text = " ";newnumber=0.0;oldnumber=0.0}

                        }

                    }
                }
            }
        }
    }
}

@Composable
fun BigText(text:String) {
    Text(text, fontSize = 40.sp)

}


@Composable
fun Buttonnumber(text:String, onClickAction: () -> Unit) {
    Button(onClick = onClickAction ,
        Modifier.size(Dp(90F),Dp(160F)),
        ) {
        Text(text)
    }
}

@Composable
fun Buttonopertar(text :String,onClickAction: () -> Unit) {
    Button(onClick =  onClickAction ,
        Modifier.size(Dp(90F),Dp(160F)),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = DarkGray
        )) {
        Text(text)
    }
}

fun opertion1(double: Double,double2: Double,string: String):String
{
    if(string=="x"){
        return (double*double2).toString()
    }else if(string=="+"){
        return (double+double2).toString()
    }else if(string=="/"){
        return (double/double2).toString()
    }else{
        return (double-double2).toString()
    }
}
