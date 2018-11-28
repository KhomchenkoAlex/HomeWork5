package com.example.android.hw5.fragments

import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.hw5.R
import com.example.android.hw5.Updater
import com.example.android.hw5.recivers.GreenBroadcastReceiver

class GreenFragment : Fragment() {

    private val greenBroadcastReceiver by lazy { GreenBroadcastReceiver() }
    private val updater by lazy { Updater() }

    companion object {
        const val ACTION = "COMMUNICATION_ACTION"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.green_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updater.apply {
            this.editTextStatus = view.findViewById(R.id.edit_text_label)
            this.switchStatus = view.findViewById(R.id.switch_label)
            this.buttonStatus = view.findViewById(R.id.button_label)
        }
    }

    override fun onStart() {
        super.onStart()
        context?.registerReceiver(greenBroadcastReceiver.apply { this.viewUpdater = updater }, IntentFilter(ACTION))
    }

    override fun onStop() {
        super.onStop()
        context?.unregisterReceiver(greenBroadcastReceiver)
    }
}