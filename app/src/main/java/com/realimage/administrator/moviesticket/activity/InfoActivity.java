package com.realimage.administrator.moviesticket.activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.realimage.administrator.moviesticket.R;
import com.realimage.administrator.moviesticket.adapter.InfopagerAdapter;
import com.realimage.administrator.moviesticket.adapter.PagerAdapter;
import com.realimage.administrator.moviesticket.fragment.InfoFragment;
import com.realimage.administrator.moviesticket.fragment.MoviesFragment;
import com.realimage.administrator.moviesticket.fragment.ReviewFragment;
import com.realimage.administrator.moviesticket.fragment.ShowFragment;
public class InfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        //Toolbar’s are also more flexible. You can modify its size, colour, position, etc. You can also add logos, labels, navigation icons
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        //TO SET THE TOOLBAR IN TO ACTION BAR
        setSupportActionBar(toolbar);
        //SWIPE left to right entire screen using pager adapter
        ViewPager viewPager = (ViewPager) findViewById(R.id.id_viewpager);
        //can use getActivity to call the current activity which the fragment is in and get getSupportFragmentManager()
        InfopagerAdapter infoadapter = new InfopagerAdapter(getSupportFragmentManager());
        infoadapter.addFragment(new InfoFragment(), "Info");
        infoadapter.addFragment(new ShowFragment(), "Shows");
        infoadapter.addFragment(new ReviewFragment(), "Review");
        viewPager.setAdapter(infoadapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.id_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
