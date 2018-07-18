package com.dmd.martin.clowyer.activities

import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.TabHost
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.adapters.FragmentAdapter
import com.dmd.martin.clowyer.fragments.AccountFragment
import com.dmd.martin.clowyer.fragments.CaseFragment
import com.dmd.martin.clowyer.fragments.ClientFragment
import com.dmd.martin.clowyer.fragments.CourtFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener{
    private val listF: MutableList<android.support.v4.app.Fragment> = mutableListOf()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabHost.setup()
        initVIewPager()
        initTabHost()
    }

    private fun initVIewPager(){
        listF.add(CaseFragment())
        listF.add(ClientFragment())
        listF.add(CourtFragment())
        listF.add(AccountFragment())
        val fragmentAdapter = FragmentAdapter(this.supportFragmentManager, listF)
        viewPagerMain.adapter = fragmentAdapter
        viewPagerMain.addOnPageChangeListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initTabHost() {
        val tabNames = arrayOf(getString(R.string.Cases), getString(R.string.Clients), getString(R.string.Courts), getString(R.string.Account))
        var spec: TabHost.TabSpec?
        for (tab in tabNames){
            spec = tabHost.newTabSpec(tab)
            spec!!.setIndicator(tab, getDrawable(R.drawable.case_icon))
            spec.setContent(FakeContent(this))
            tabHost.addTab(spec)
        }
        tabHost.setOnTabChangedListener(this)
    }

    override fun onTabChanged(p0: String?) {
        viewPagerMain.currentItem = tabHost.currentTab
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        horizontalScrollViewMain.smoothScrollTo(tabHost.width * (position / (3 - 1)), 0)
        tabHost.currentTab = position
    }

    inner class FakeContent(context: Context) : TabHost.TabContentFactory {
        var context: Context? = null
        init {
            this.context = context
        }
        override fun createTabContent(p0: String?): View {
            val fakeView = View(context)
            fakeView.minimumHeight = 0
            fakeView.minimumWidth = 0
            return  fakeView
        }
    }
}
