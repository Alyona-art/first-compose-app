import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.firstcomposeapp.R
import com.example.firstcomposeapp.ui.theme.CustomTypography
import com.example.firstcomposeapp.ui.theme.Grey100
import com.example.firstcomposeapp.ui.theme.Grey600
import com.example.firstcomposeapp.ui.theme.Grey700
import com.example.firstcomposeapp.ui.theme.Grey800
import com.example.firstcomposeapp.ui.theme.Red500
import com.example.firstcomposeapp.ui.theme.Red600

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    error: String?,
    isHidden: Boolean = false,
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            singleLine = true,
            visualTransformation = if (isHidden && !passwordVisible) PasswordVisualTransformation(
                '*'
            ) else VisualTransformation.None,
            trailingIcon = {
                val painter = painterResource(
                    if (passwordVisible) R.drawable.ic_hide else R.drawable.ic_show
                )
                val description = if (passwordVisible) "Hide password" else "Show password"

                if (isHidden && value.isNotEmpty())
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painter,
                            contentDescription = description,
                            tint = Grey100,
                        )
                    }
            },
            isError = error != null,
            supportingText = {
                if (error != null) {
                    Text(
                        error,
                        style = CustomTypography.labelMedium,
                        color = Red500
                    )
                } else null
            },
            textStyle = CustomTypography.bodyMedium,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                focusedIndicatorColor = Grey800,
                unfocusedIndicatorColor = Grey800,
                errorIndicatorColor = Red600,
                focusedLabelColor = Grey700,
                unfocusedLabelColor = Grey600,
                errorLabelColor = Grey700,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                errorTextColor = Color.White,
                cursorColor = Color.White,
                errorCursorColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}