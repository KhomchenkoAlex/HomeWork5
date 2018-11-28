package com.example.android.hw5.recivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.android.hw5.Updater
import com.example.android.hw5.fragments.GreenFragment

class GreenBroadcastReceiver : BroadcastReceiver() {

    var viewUpdater: Updater? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            GreenFragment.ACTION -> {
                when {
                    intent.hasExtra("SWITCH_STATUS") -> {
                        val isSwitchOn = intent.getBooleanExtra("SWITCH_STATUS", false)
                        if (isSwitchOn) viewUpdater?.switchStatus?.text = "SWITCH ON"
                        else viewUpdater?.switchStatus?.text = "SWITCH OFF"
                    }
                    intent.hasExtra("EDIT_TEXT") -> {
                        val text = intent.getStringExtra("EDIT_TEXT")
                        viewUpdater?.editTextStatus?.text = text
                    }
                    intent.hasExtra("BUTTON_STATUS") -> {
                        val isButtonPressed = intent.getBooleanExtra("BUTTON_STATUS", true)
                        if (isButtonPressed) viewUpdater?.buttonStatus?.text = "BUTTON PRESSED"
                        else viewUpdater?.buttonStatus?.text = "BUTTON RELEASED"
                    }
                }
            }
        }
    }
}