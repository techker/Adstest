package com.example.adstest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.adstest.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_child.*

class ChildFragment : ReceiverFragment() {
    lateinit var dataEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ///click boutton child
        childFab.setOnClickListener {
            this.sendTimestamp()
        }

        dataEditText = viewContainer.findViewById(R.id.dataEditText)
        val viewFab = viewContainer.findViewById<FloatingActionButton>(R.id.viewFab)
        viewFab.setOnClickListener {
            this.sendTimestamp()
        }
    }

       //une fois recu update tout les vue relier
        override fun timestampReceived(timestamp: Long) {
        val txt = "${this.dataTextView.text}$timestamp\n"
        this.dataTextView.setText(txt)
        val txt2 = "${this.dataEditText.text}$timestamp\n"
        dataEditText.setText(txt2)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ChildFragment()
    }
}