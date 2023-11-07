import com.sun.org.apache.xml.internal.dtm.ref.CoroutineManager
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.io.encoding.Base64
import kotlin.random.Random


fun main() {//Excueted main thred
    println("Main program starts: ${Thread.currentThread().name}")
    val start = System.currentTimeMillis()
    val parentJob= CoroutineScope(Dispatchers.Default).launch{
     val jobdefreed1:Deferred<String> = async {
         geteData1(Thread.currentThread().name)
         "keshav"
     }
        val jobdeffred2:Deferred<String> = async {
            geteData2((Thread.currentThread().name))

        }
        println(jobdefreed1.await() + "\n${jobdeffred2.await()}")
    }
    runBlocking {// runblocking create a coroutine so you add and type of coroutine
        parentJob.join()
    }
    parentJob.invokeOnCompletion {
        it?.let {
            println("pareent job failed:${it.message}")
        } ?: println("Parent job is SUCCESS!")
    }
    println("total time taken by corouties:${System.currentTimeMillis()-start}")
    println("Main program ends: ${Thread.currentThread().name}")

}
private suspend fun geteData1(threadName:String):String{
    println("fake start :$threadName")
    delay(2000)
    println("fake end:$threadName")
    return "Result 1"
}
private suspend fun geteData2(threadName:String):String{
    println("fake start2:$threadName")
    delay(2000)
    println("fake end2:$threadName")
    return "Result 2"
}