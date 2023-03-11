package hashem.mousavi.composelazylistanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hashem.mousavi.composelazylistanimation.ui.CustomList
import hashem.mousavi.composelazylistanimation.ui.theme.ComposeLazyListAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLazyListAnimationTheme {
                CustomList(modifier = Modifier.fillMaxSize())
            }
        }
    }
}