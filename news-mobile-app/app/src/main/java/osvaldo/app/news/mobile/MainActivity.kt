package osvaldo.app.news.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import osvaldo.app.news.mobile.core.theme.NewsmobileTheme
import osvaldo.app.news.mobile.ui.navigation.NavigationNews

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsmobileTheme {
                NavigationNews()
            }
        }
    }
}