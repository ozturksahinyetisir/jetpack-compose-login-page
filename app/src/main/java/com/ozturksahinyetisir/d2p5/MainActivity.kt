package com.ozturksahinyetisir.d2p5

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ozturksahinyetisir.d2p5.ui.theme.D2p5Theme
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

val montserratFontFamily = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_bold, FontWeight.Bold))

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            D2p5Theme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = null,
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Fit,
            )
        TextField(
            value = username,
            onValueChange = {
                if (it.length <= 12) { // The maximum length of the ID can be up to 12.
                    username = it
                    username = it.replace(" ", "") //Suppresses line breaks

                }
            },
            label = { Text("Kullanıcı Adı",fontFamily = montserratFontFamily,)}
        )
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = "Maksimum karakter uzunluğu 12'dir.\nSadece kullanıcı adı ile giriş yapılabilir. ",
            color = Color.Gray,
            fontSize = 12.sp,
            fontFamily = montserratFontFamily,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = {
                if (it.length <= 16) { // The maximum length of the password can be up to 16.
                    password = it
                    password = it.replace(" ", "") //Suppresses line breaks
            } },
            label = { Text("Şifre",fontFamily = montserratFontFamily,) },
            visualTransformation = PasswordVisualTransformation(),
        )
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = "Maksimum karakter uzunluğu 16'dır.\nŞifreniz en az 6 karakterden oluşmalıdır",
            color = Color.Gray,
            fontSize = 12.sp,
            fontFamily = montserratFontFamily,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {

                if (username == "ozturk" && password == "123123") { // Basic login information control.
                    Toast.makeText(context,"Giriş Başarılı",Toast.LENGTH_SHORT).show()
                }
                else if (username =="" || password == ""){
                    Toast.makeText(context,"Kullanıcı Adı veya Şifreyi Boş Bıraktınız!",Toast.LENGTH_SHORT).show()
                }else if ( password.length < 6){
                    Toast.makeText(context,"Şifreyi uzunluğu 6'dan küçük olamaz.",Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(context,"Kullanıcı Adı veya Şifre Hatalı",Toast.LENGTH_SHORT).show()
                }
            }
        )
        {
            Text("Giriş",fontFamily = montserratFontFamily,)
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

