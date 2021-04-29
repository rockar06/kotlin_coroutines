package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

var start = 0L

fun main() = runBlocking {
    val time = measureTimeMillis {
        emitter()
            // 1. Adding new thread
            //.flowOn(Dispatchers.IO)
            // 2. Buffering items
            //.buffer()
            // 3. Dropping items
            //.conflate()
            .collect {
                print("Collect $it starts (${currentTime() - start}ms) ")
                delay(3_000)
                println("Collect $it ends (${currentTime() - start}ms)")
            }
    }
    println("Collected in $time ms")
}

fun currentTime() = System.currentTimeMillis()

fun emitter(): Flow<Int> = (1..5)
    .asFlow()
    .onStart { start = currentTime() }
    .onEach {
        delay(1_000)
        println("Emit $it (${currentTime() - start}ms)")
    }