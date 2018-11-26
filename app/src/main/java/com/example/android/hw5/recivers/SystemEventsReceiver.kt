package com.example.android.hw5.recivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast
import com.example.android.hw5.Updater

class SystemEventsReceiver : BroadcastReceiver() {

    var updater : Updater? = null
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            ConnectivityManager.CONNECTIVITY_ACTION -> {
                Toast.makeText(context, "NET", Toast.LENGTH_LONG).show()
                updater?.updateNetworkInfo(context)}
            Intent.ACTION_POWER_CONNECTED -> {
                Toast.makeText(context, "POWER", Toast.LENGTH_LONG).show()
                updater?.updatePowerInfo("POWER ON")
            }
            Intent.ACTION_POWER_DISCONNECTED -> {
                Toast.makeText(context, "POWER", Toast.LENGTH_LONG).show()
                updater?.updatePowerInfo("POWER OFF")
            }
            Intent.ACTION_HEADSET_PLUG -> {
                Toast.makeText(context, "HS", Toast.LENGTH_LONG).show()
                updater?.updateHeadsetInfo(intent)
            }
            Intent.ACTION_TIMEZONE_CHANGED -> {
                Toast.makeText(context, "TIMEZONE CHANGED", Toast.LENGTH_LONG).show()
                updater?.updateTimeDateInfo()
            }
            Intent.ACTION_DATE_CHANGED -> {
                Toast.makeText(context, "DATE CHANGED", Toast.LENGTH_LONG).show()
                updater?.updateTimeDateInfo()
            }
        }
    }

}
