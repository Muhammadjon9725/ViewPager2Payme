package com.example.viewpager2payme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.viewpager2payme.Adapter.User
import com.example.viewpager2payme.Adapter.ViewPager2Adapter
import com.example.viewpager2payme.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import java.util.Objects

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ViewPager2Adapter
    lateinit var list: ArrayList<User>
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
        adapter = ViewPager2Adapter(list)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ ->
        }.attach()

        binding.apply {
            tabLayout.addOnTabSelectedListener(object :OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if (tab?.position==list.size-1){
                        btnClick.visibility =View.INVISIBLE
                    }else{
                        btnClick.visibility=View.VISIBLE
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            })
            btnNext.setOnClickListener {
                tabLayout.selectTab(tabLayout.getTabAt(list.size-1))
            }
            btnClick.setOnClickListener {
                tabLayout.selectTab(tabLayout.getTabAt(tabLayout.selectedTabPosition+1))
                if (binding.viewPager.currentItem==list.size-1){
                    btnClick.visibility =View.INVISIBLE
                }else{
                    btnClick.visibility=View.VISIBLE
                }
            }
        }
    }




    private fun loadData() {
        list = ArrayList()
        list.add(User(R.drawable.img,"Click va Paymega o'tish xizmati","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."))
        list.add(User(R.drawable.img_1,"Barcha operatorlar bo'yicha statika","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."))
        list.add(User(R.drawable.img_2,"Tariflarni filtrlash","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."))
        list.add(User(R.drawable.img_3,"Yangi imkoniyatlar","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."))
    }
}