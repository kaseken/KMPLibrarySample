package dev.kaseken.kmpsampleandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.kaseken.kmpsampleandroidapp.ui.theme.KMPSampleAndroidAppTheme
import dev.kaseken.kmpsampleandroidapp.utils.PriorityQueueUtil
import kotlin.random.Random

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      KMPSampleAndroidAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          val array = createRandomIntArray(5)
          val min = PriorityQueueUtil.pickMinimum(array)
          Greeting(
              text = "The minimum element in $array is $min.",
              modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }

  private fun createRandomIntArray(size: Int, range: IntRange = -100..100): List<Int> {
    return List(size) { Random.nextInt(range.first, range.last + 1) }
  }
}

@Composable
fun Greeting(text: String, modifier: Modifier = Modifier) {
  Text(text = text, modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  KMPSampleAndroidAppTheme { Greeting("Android") }
}
