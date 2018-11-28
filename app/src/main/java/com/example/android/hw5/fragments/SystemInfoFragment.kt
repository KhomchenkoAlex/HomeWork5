package com.example.android.hw5.fragments

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.hw5.R
import com.example.android.hw5.Updater
import com.example.android.hw5.recivers.SystemEventsReceiver


class SystemInfoFragment : Fragment() {

    private val systemEventsReceiver by lazy { SystemEventsReceiver() }
    private val viewUpdater by lazy { Updater() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.system_info_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewUpdater.apply {
            this.networkView = view.findViewById(R.id.network_view)
            this.headsetView = view.findViewById(R.id.headset_view)
            this.powerView = view.findViewById(R.id.power_view)
            this.timeView = view.findViewById(R.id.time_view)
        }
        viewUpdater.updateTimeDateInfo()
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter()
        filter.apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_HEADSET_PLUG)
            addAction(Intent.ACTION_DATE_CHANGED)
            addAction(Intent.ACTION_TIMEZONE_CHANGED)
            addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        }
        context?.registerReceiver(systemEventsReceiver.apply {
            this.updater = viewUpdater
        }, filter)
    }

    override fun onStop() {
        super.onStop()
        context?.unregisterReceiver(systemEventsReceiver)
    }
}