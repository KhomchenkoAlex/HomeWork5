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
        val myIntent = Intent("MY_SUPER_ACTION")
        myIntent.putExtra("EXTRA_SWITCH_STATUS", isChecked)
        context?.sendBroadcast(myIntent)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        val i : Boolean = !event!!.equals(0)
        val myIntent = Intent("MY_SUPER_ACTION")
        myIntent.putExtra("EXTRA_TOUCH_BUTTON", i)
        context?.sendBroadcast(myIntent)
        return i
    }


    override fun afterTextChanged(s: Editable?) {
        val myIntent = Intent("MY_SUPER_ACTION")
        myIntent.putExtra("EXTRA_EDIT_TEXT", s.toString())
        context?.sendBroadcast(myIntent)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

}