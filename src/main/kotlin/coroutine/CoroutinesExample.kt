package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    repeat(1_000_000) { // launch a lot of coroutines
        launch {
            println("$it")
            delay(5_000L)
        }
    }
}