package com.example.brdemodelete

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var myBroadCastReceiver: MyBroadCastReceiver
    private lateinit var intentFilter: IntentFilter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myBroadCastReceiver = MyBroadCastReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
                registerReceiver(myBroadCastReceiver,it)
        }

    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(myBroadCastReceiver)
    }
}