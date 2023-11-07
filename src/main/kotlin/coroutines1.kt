import kotlin.concurrent.thread

fun main() {//Excueted main thred
    println("Main program starts: ${Thread.currentThread().name}")
//    Thread.sleep(2000)//pretend some work
//    //but this thread usefull for not heavy work
    //now we created backgrounf thread
    //this also called backgorund thread
    thread {
        println("fake work start:${Thread.currentThread().name}")
        Thread.sleep(20000)
        println("fake work end:${Thread.currentThread().name}")
    }
    println("Main program ends: ${Thread.currentThread().name}")
}
//import same thing use coroutines in next file