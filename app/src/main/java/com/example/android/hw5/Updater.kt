package com.example.android.hw5

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class Updater {

    var networkView: TextView? = null
    var headsetView: TextView? = null
    var powerView: TextView? = null
    var timeView: TextView? = null

    fun updateNetworkInfo(context: Context) {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo.isConnected) {
            networkView?.text = "Internet available"
        } else networkView?.text = "Internet disable"
    }

    fun updatePowerInfo(info: String){
        powerView?.text = info
    }

    fun updateHeadsetInfo(intent: Intent) {
        val state = intent.getIntExtra("state", -1)
        when (state) {
            0 -> headsetView?.text = "HEADSET UNPLUGGED"
            1 -> headsetView?.text = "HEADSET PLUGGED"
            else -> headsetView?.text = "HZ"
        }
    }

    fun updateTimeDateInfo() {
        val timeZone = TimeZone.getDefault()
        val date = SimpleDateFormat("dd-MM-yyyy", Locale.ROOT)
        val timeText = "Current date:  ${date.format(Date())} Current timezone: ${timeZone.getDisplayName(false, TimeZone.SHORT)}"
        timeView?.text = timeText
    }
}