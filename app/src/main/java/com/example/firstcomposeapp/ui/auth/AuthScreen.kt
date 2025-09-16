import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapp.R
import com.example.firstcomposeapp.ui.auth.validateLogin
import com.example.firstcomposeapp.ui.auth.validatePassword
import com.example.firstcomposeapp.ui.theme.CustomTypography
import com.example.firstcomposeapp.ui.theme.Grey100
import com.example.firstcomposeapp.ui.theme.Grey600
import com.example.firstcomposeapp.ui.theme.Grey800
import com.example.firstcomposeapp.ui.theme.Grey900

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var loginError: String? by remember { mutableStateOf(null) }
    var passwordError: String? by remember { mutableStateOf(null) }

    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(
                    top = 31.dp + WindowInsets.statusBars.asPaddingValues()
                        .calculateTopPadding()
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "NYTIMES",
                color = Grey100,
                style = CustomTypography.titleMedium
            )
            Spacer(modifier = Modifier.width(2.dp))
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "Logo",
                modifier = Modifier.size(48.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = PaddingHorizontal.small),
            verticalArrangement = Arrangement.Center
        ) {
            CustomTextField(
                value = login,
                onValueChange = {
                    login = it
                    loginError = validateLogin(login)
                },
                label = "Логин",
                error = loginError
            )
            CustomTextField(
                value = password,
                onValueChange = {
                    password = it
                    passwordError = validatePassword(password)
                },
                label = "Пароль",
                error = passwordError,
                isHidden = true
            )
            Spacer(modifier = Modifier.height(if (loginError != null || passwordError != null) 12.dp else 16.dp))
            Button(
                onClick = {},
                enabled = login.isNotEmpty() && password.isNotEmpty() && loginError == null && passwordError == null,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Grey100,
                    contentColor = Grey900,
                    disabledContainerColor = Grey600,
                    disabledContentColor = Grey800
                ),
                shape = RoundedCornerShape(size = 4.dp),
                contentPadding = PaddingValues(
                    horizontal = PaddingHorizontal.medium,
                    vertical = PaddingVertical.medium
                ),
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.End)
            ) {
                Text(
                    "ВОЙТИ",
                    style = CustomTypography.headlineLarge,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AuthScreenPreview() {
    AuthScreen()
}
