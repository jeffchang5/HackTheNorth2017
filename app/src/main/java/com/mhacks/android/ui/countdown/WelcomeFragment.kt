package com.mhacks.android.ui.countdown


import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView

import com.mhacks.android.data.model.Countdown
import com.mhacks.android.data.network.HackathonCallback
// import com.mhacks.android.data.network.NetworkManager
import com.mhacks.android.ui.common.BaseFragment

import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.format.DateTimeFormat
import org.mhacks.android.R

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

/**
 * Created by jawad on 04/11/14.
 * Updated by Shashank on 08/30/17
 */

class WelcomeFragment : BaseFragment() {

    override var setTransparent: Boolean = true
    override var AppBarTitle: Int = R.string.welcome
    override var LayoutResourceID: Int = R.layout.fragment_welcome


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        val instance get() = WelcomeFragment()
    }
}

