package com.dmd.martin.clowyer.navigation.view

import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.TabHost
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.activities.CaseActivity
import com.dmd.martin.clowyer.adapters.FragmentAdapter
import com.dmd.martin.clowyer.fragments.AccountFragment
import com.dmd.martin.clowyer.cardviews.cases.view.CaseFragment
import com.dmd.martin.clowyer.entity.ItemCase
import com.dmd.martin.clowyer.entity.ItemClient
import com.dmd.martin.clowyer.entity.ItemCourt
import com.dmd.martin.clowyer.navigation.presenter.NavigationPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener, NavigationView{

    private val listF: MutableList<android.support.v4.app.Fragment> = mutableListOf()
    private var caseFragment = CaseFragment()
    private var clientFragment = ClientFragment()
    private var courtFragment = CourtFragment()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabHost.setup()
        initVIewPager()
        initTabHost()
    }

    private fun initVIewPager(){
        val navigationPresenter = NavigationPresenterImpl(this)
        caseFragment.setPresenter(navigationPresenter)
        clientFragment.setPresenter(navigationPresenter)
        courtFragment.setPresenter(navigationPresenter)
        listF.add(caseFragment!!)
        listF.add(clientFragment!!)
        listF.add(courtFragment!!)
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

    override fun showProgressBar() {
        imageViewLoadMain.visibility = View.VISIBLE
        progressBarMain.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        imageViewLoadMain.visibility = View.INVISIBLE
        progressBarMain.visibility = View.INVISIBLE
    }

    override fun showCase(case: ItemCase) {
        val bundle = Bundle()
        bundle.putSerializable("Item", case)
        val intent = Intent(this, CaseActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun showClient(client: ItemClient) {
        val bundle = Bundle()
        bundle.putSerializable("Item", client)
        val intent = Intent(this, CaseActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun showCourt(court: ItemCourt) {
        val bundle = Bundle()
        bundle.putSerializable("Item", court)
        val intent = Intent(this, CaseActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun showCreateCase() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCreateClient() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCreateCourt() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSearchError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDeleteError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
