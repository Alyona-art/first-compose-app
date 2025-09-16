import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapp.R
import com.example.firstcomposeapp.ui.theme.CustomTypography
import com.example.firstcomposeapp.ui.theme.Grey100
import com.example.firstcomposeapp.ui.theme.Grey600
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    appVersion: String = "1.0.41",
    onSplashFinished: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(3000)
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "Logo",
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(PaddingVertical.large))
            Text(
                "NYTIMES",
                color = Grey100,
                style = CustomTypography.titleMedium,
                modifier = Modifier.padding(vertical = 3.dp)
            )
        }
        Text(
            text = appVersion,
            color = Grey600,
            style = CustomTypography.labelSmall,
            modifier = Modifier
                .padding(
                    bottom = 20.dp + WindowInsets.navigationBars.asPaddingValues()
                        .calculateBottomPadding()
                )
                .align(alignment = Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    SplashScreen(onSplashFinished = {})
}
