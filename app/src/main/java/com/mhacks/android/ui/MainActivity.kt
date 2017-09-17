package com.mhacks.android.ui

import android.app.FragmentTransaction
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.mhacks.android.MHacksApplication
import com.mhacks.android.data.network.services.HackathonApiService
import com.mhacks.android.data.room.MHacksDatabase
import com.mhacks.android.ui.common.BaseActivity
import com.mhacks.android.ui.common.BaseFragment
import com.mhacks.android.ui.common.NavigationColor
import com.mhacks.android.ui.map.MapViewFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.mhacks.android.R
import javax.inject.Inject

/**
 * Activity defines primarily the initial hackathonService calls to GCM as well as handle Fragment transactions.
 */
class MainActivity : BaseActivity(),
        BaseFragment.OnNavigationChangeListener {

    private val appCallback by lazy {
        application as MHacksApplication
    }

    @Inject lateinit var hackathonService: HackathonApiService
    @Inject lateinit var mhacksDatabase: MHacksDatabase
    private lateinit var menuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appCallback.hackathonComponent.inject(this)
        setTheme(R.style.MHacksTheme)
        initActivity()
    }

    private fun updateFragment(fragment: Fragment?) {

        supportFragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.fragment_container, fragment)
                .commit()
    }

    private fun initActivity() {

        setSystemFullScreenUI()
        setContentView(R.layout.activity_main)
        setBottomNavigationColor(
                NavigationColor(R.color.colorPrimary, R.color.colorPrimaryDark))

        updateFragment(MapViewFragment.instance)

        navigation?.setOnNavigationItemSelectedListener({ item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    updateFragment(MapViewFragment.instance)
                }
                R.id.navigation_announcements -> {
                    updateFragment(MapViewFragment.instance)
                }
            }
            menuItem = item
            true
        })
    }
}
