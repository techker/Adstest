package com.example.adstest

import android.content.IntentFilter
import android.os.Bundle
import android.view.Menu
import android.widget.EditText
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.adstest.receivers.TimestampReceiver
import com.example.adstest.ui.fragments.MainFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    lateinit var dataEditText: EditText

    var receiver = TimestampReceiver(handler = { timestampReceived(it) })

    ///time stamp recu et ajoute aux vues
     fun timestampReceived(timestamp: Long) {
        val txt = "${this.dataEditText.text}$timestamp\n"
        dataEditText.setText(txt)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Drawer(enlever tout nav)
        val listener =
            ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open, R.string.close)
        drawer_layout.addDrawerListener(listener)
        listener.syncState()


        supportFragmentManager.beginTransaction()
            .replace(R.id.leftFragmentLayout, MainFragment.newInstance())///ajoute fragment 1
            .replace(R.id.rightFragmentLayout, MainFragment.newInstance())//ajoute fragment 2
            .commit()

        dataEditText = nav_view.findViewById(R.id.dataEditText)

        val viewFab = nav_view.findViewById<FloatingActionButton>(R.id.viewFab)//boutton

        //On CLick envoie un message pour cree le time stamp et l'envoyer aux vue
        viewFab.setOnClickListener {
            TimestampReceiver.sendTimestamp(this)
        }
         //enregistremer au broadcast
        registerReceiver(receiver, IntentFilter(TimestampReceiver.TIMESTAMP_ACTION))
    }

    ///Detruit le receiver
    override fun onDestroy() {
        unregisterReceiver(this.receiver)
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return false
    }
}