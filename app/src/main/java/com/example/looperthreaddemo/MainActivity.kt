package com.example.looperthreaddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    val looperThread = ExampleLooperThread()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.button)
        val btnStop = findViewById<Button>(R.id.button2)
        val btnTaskA = findViewById<Button>(R.id.button3)
        val btnTaskB = findViewById<Button>(R.id.button4)

        btnStart.setOnClickListener{
            looperThread.start()
        }

        // Post some task on bg thread msgQueue from Ui thread
        btnTaskA.setOnClickListener{


            looperThread.mHandler.post(Runnable {
                for (i in 1..5){
                    Log.d(TAG,"Run -> $i")
                    Thread.sleep(1000)
                }
            })
        }

        // Instead of posting a runnable we can  send message directly
        // To interpret our msg we need to make own handler(ExampleHandler)
        btnTaskB.setOnClickListener{
            val msg = Message.obtain()
            msg.what = 1
            looperThread.customHandler.sendMessage(msg)
        }

        // Stop the infinite for loop
        btnStop.setOnClickListener{
            looperThread.mLooper.quit()
        }


    }
}