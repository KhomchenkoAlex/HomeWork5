package com.example.android.hw5.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.hw5.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment: Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_system_info.setOnClickListener(this)
        btn_frag_com.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_system_info -> {
                fragmentManager?.apply{
                    beginTransaction()
                            .replace(R.id.frame_fragment,SystemInfoFragment())
                            .addToBackStack(null)
                            .commit()
                }
            }
            R.id.btn_frag_com -> {
                fragmentManager?.apply{
                    beginTransaction()
                            .replace(R.id.frame_fragment,CommunicationFragment())
                            .addToBackStack(null)
                            .commit()
                }
            }
        }
    }
}