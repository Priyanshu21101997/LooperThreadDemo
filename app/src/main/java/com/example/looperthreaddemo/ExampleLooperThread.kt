package com.example.looperthreaddemo

import android.os.Handler
import android.os.Looper
import android.util.Log

class ExampleLooperThread : Thread() {

    private val TAG = "ExampleLooperThread"

    lateinit var mHandler:Handler
    lateinit var mLooper:Looper
    lateinit var customHandler: Handler

    override fun run() {

        // 1) This Attach looper to our bg thread and attach messageQueue to it.
        Looper.prepare()

        // This returns looper of the current thread
        mLooper = Looper.myLooper()!!

        // 2) Initialise handler in background thread
        mHandler = Handler()

        // CUSTOM HANDLER to interpertet message
        customHandler = ExampleHandler()


        // 3) This starts infinite for loop
        Looper.loop()

        // Now to use handler we need to call looper.prepare . We can only create handler in thread
        // which calls looper.prepare()

//        for(i in 1..5){
//            Log.d(TAG,"Run -> $i")
//            Thread.sleep(1000)
//        }

        Log.d(TAG,"END of Run()")
    }

}