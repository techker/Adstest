package com.example.adstest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adstest.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : ReceiverFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ajouts des child
        childFragmentManager.beginTransaction()
            .replace(R.id.childFragmentLayout, ChildFragment.newInstance())
            .commit()

        //on click de ces bouttons pour faire part au recepteur d'envoyer le time stamp via broadcast
        fab.setOnClickListener {
            this.sendTimestamp()
        }
    }

    ///recu timestamp update les vues
    override fun timestampReceived(timestamp: Long) {
        val txt = "${this.dataEditText.text}$timestamp\n"
        this.dataEditText.setText(txt)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}