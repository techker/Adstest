package com.example.adstest.ui.fragments

import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.adstest.receivers.TimestampReceiver

abstract class ReceiverFragment : Fragment() {

    //recepteur
    private val receiver = TimestampReceiver(handler = { timestampReceived(it) })

    open fun timestampReceived(timestamp: Long) {}

    protected fun sendTimestamp() {
        this.context?.let {
            TimestampReceiver.sendTimestamp(it)
        }
    }

    ///doit enregistrer sont recepteur
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.context?.registerReceiver(receiver, IntentFilter(TimestampReceiver.TIMESTAMP_ACTION))
    }

    override fun onDestroyView() {
        this.context?.unregisterReceiver(receiver)
        super.onDestroyView()
    }
}