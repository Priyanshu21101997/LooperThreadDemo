package com.example.looperthreaddemo

import android.os.Handler
import android.os.Message
import android.util.Log

class ExampleHandler:Handler() {
    // Here msg is received
    private val TAG = "ExampleHandler"

    override fun handleMessage(msg: Message) {
        when(msg.what){
            1->{
                Log.d(TAG,"Task 1 Executed")
            }
        }
    }
}