package coroutine

import kotlin.concurrent.thread

fun main() {
    repeat(100_000) { // launch a lot of threads
        thread(start = true) {
            Thread.sleep(5_000L)
            println("$it")
        }
    }
}