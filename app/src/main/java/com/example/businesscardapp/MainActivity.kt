package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }


            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1.5f)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = stringResource(R.string.android_logo_text),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(height = 120.dp, width = 110.dp)
                    .background(Color("#063042".toColorInt()))
            )
            Text(
                stringResource(R.string.name_value_text),
                fontSize = 38.sp,
                fontWeight = FontWeight.Light,
                lineHeight = 70.sp
            )
            Text(
                stringResource(R.string.android_developer_artisan_text),
                fontWeight = FontWeight.Bold,
                color = Color("#016d3b".toColorInt())
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .weight(1f)
//                .background(Color.Red)
                .padding(bottom = 40.dp)

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentSize()
            ) {
                ContactDetail(
                    imageVector = Icons.Default.Call,
                    contentDescription = stringResource(R.string.phone_number_text),
                    text = stringResource(R.string.phone_number_value_text)
                )
                ContactDetail(
                    imageVector = Icons.Default.Share,
                    contentDescription = stringResource(R.string.x_or_twitter_text),
                    text = stringResource(R.string.x_value_text)
                )
                ContactDetail(
                    imageVector = Icons.Default.Email,
                    contentDescription = stringResource(R.string.email_text),
                    text = stringResource(R.string.email_value_text)
                )
            }

        }

    }
}

@Composable
fun ContactDetail(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String,
    text: String
) {
    Row(modifier = modifier.padding(vertical = 4.dp)) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = Color("#016d3b".toColorInt())
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = text)
    }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            BusinessCardApp(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}