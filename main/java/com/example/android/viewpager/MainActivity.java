package com.example.android.viewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new NumberFragment(),"Number");
        viewPagerAdapter.addFragment(new ColorFragment(),"Color");
        viewPagerAdapter.addFragment(new PharaseFragment(),"Phrase");
        viewPagerAdapter.addFragment(new FamilyFragment(),"Family");
        viewPagerAdapter.addFragment(new NewsFragment(),"News");
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayout =(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter{
        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();
        public  ViewPagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);

        }
        @Override
       public Fragment getItem(int position){
            return fragmentList.get(position);
        }
        @Override
        public  int getCount(){
            return fragmentList.size();
        }
        public void addFragment(Fragment fragment,String title){
            fragmentList.add(fragment);
            fragmentTitle.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position){
            return  fragmentTitle.get(position);
        }
    }
}
