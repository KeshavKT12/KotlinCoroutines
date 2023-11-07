
import com.sun.org.apache.xml.internal.dtm.ref.CoroutineManager
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.io.encoding.Base64
import kotlin.random.Random


fun main() {//Excueted main thred
    println("Main program starts: ${Thread.currentThread().name}")

   val parentJob= CoroutineScope(Dispatchers.Default).launch{
        println("fake work start:${Thread.currentThread().name}")
        //delay(200)//not pause entire coroutinesthis pause only specific coroutines
        println("fake work end:${Thread.currentThread().name}")
       delay(200)
    }
    runBlocking {// runblocking create a coroutine so you add and type of coroutine
        parentJob.join()
    }



    println("Main program ends: ${Thread.currentThread().name}")
}