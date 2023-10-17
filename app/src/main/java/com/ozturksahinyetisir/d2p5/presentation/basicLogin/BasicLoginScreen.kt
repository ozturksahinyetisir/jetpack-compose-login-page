package com.ozturksahinyetisir.d2p5.presentation.basicLogin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ozturksahinyetisir.d2p5.R
import com.ozturksahinyetisir.d2p5.montserratFontFamily

@Composable
fun LoginScreen() {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(55.dp))
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
            label = { Text("Kullanıcı Adı", fontFamily = montserratFontFamily,) },
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
                }
            },
            label = { Text("Şifre", fontFamily = montserratFontFamily,) },
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
                    Toast.makeText(context, "Giriş Başarılı", Toast.LENGTH_SHORT).show()
                } else if (username == "" || password == "") {
                    Toast.makeText(
                        context,
                        "Kullanıcı Adı veya Şifreyi Boş Bıraktınız!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (password.length < 6) {
                    Toast.makeText(
                        context,
                        "Şifreyi uzunluğu 6'dan küçük olamaz.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "Kullanıcı Adı veya Şifre Hatalı",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )
        {
            Text("Giriş", fontFamily = montserratFontFamily,)
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}