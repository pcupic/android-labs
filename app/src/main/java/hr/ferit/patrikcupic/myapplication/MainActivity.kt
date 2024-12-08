package hr.ferit.patrikcupic.myapplication

import NavigationController
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationController()  // This sets up the navigation
        }
    }
}
