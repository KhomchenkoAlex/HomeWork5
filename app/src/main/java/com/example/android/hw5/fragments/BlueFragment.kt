package com.example.android.hw5.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.example.android.hw5.R
import kotlinx.android.synthetic.main.blue_fragment.*

class BlueFragment : Fragment(), CompoundButton.OnCheckedChangeListener, TextWatcher, View.OnTouchListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.blue_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        switch_label.setOnCheckedChangeListener(this)
        edit_text_label.addTextChangedListener(this)
        button_label.setOnTouchListener(this)

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        Intent("COMMUNICATION_ACTION").putExtra("SWITCH_STATUS", isChecked)
                .let { context?.sendBroadcast(it) }
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> Intent("COMMUNICATION_ACTION").putExtra("BUTTON_STATUS", true)
                    .let { context?.sendBroadcast(it) }
            MotionEvent.ACTION_UP -> Intent("COMMUNICATION_ACTION").putExtra("BUTTON_STATUS", false)
                    .let { context?.sendBroadcast(it) }
        }
        return true
    }

    override fun afterTextChanged(s: Editable?) {
        Intent("COMMUNICATION_ACTION").putExtra("EDIT_TEXT", s.toString())
                .let { context?.sendBroadcast(it) }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
}