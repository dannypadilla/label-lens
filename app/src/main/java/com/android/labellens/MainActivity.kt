package com.android.labellens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.android.labellens.databinding.ActivityMainBinding
import com.amazonaws.mobile.client.AWSMobileClient


class MainActivity : AppCompatActivity() {
    val LOG_TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navController = this.findNavController(R.id.navHostFragment)

        AWSMobileClient.getInstance().initialize(this
        ) {
            Log.d(LOG_TAG, "AWSMobileClient is instantiated and you are connected to AWS!")
        }.execute()
    }
}
