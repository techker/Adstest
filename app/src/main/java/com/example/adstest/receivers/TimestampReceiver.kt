package com.example.adstest.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class TimestampReceiver(
    val handler: (timestamp: Long) -> Unit
) : BroadcastReceiver() {
    companion object {
        @JvmStatic
        val TIMESTAMP_ACTION = "TIMESTAMP_ACTION"
        private const val EXTRA_TIMESTAMP = "EXTRA_TIMESTAMP"

        fun sendTimestamp(context: Context) {
            val intent = Intent()
            intent.action = TIMESTAMP_ACTION
            intent.putExtra(EXTRA_TIMESTAMP, System.currentTimeMillis()) ///conversion en milli
            context.sendBroadcast(intent)
        }
    }
    ///class pour faire le broadcast du timestamp

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == TIMESTAMP_ACTION && intent.hasExtra(EXTRA_TIMESTAMP)) {
            handler.invoke(intent.getLongExtra(EXTRA_TIMESTAMP, 0L))
        }
    }
}