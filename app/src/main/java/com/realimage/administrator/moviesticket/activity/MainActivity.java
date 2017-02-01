package com.realimage.administrator.moviesticket.activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;

import com.ncapdevi.fragnav.FragNavController;
import com.realimage.administrator.moviesticket.R;
import com.realimage.administrator.moviesticket.fragment.AssistedFragment;
import com.realimage.administrator.moviesticket.fragment.SettingsFragment;
import com.realimage.administrator.moviesticket.fragment.MoviesFragment;
import com.realimage.administrator.moviesticket.fragment.MyprofileFragment;
import com.realimage.administrator.moviesticket.fragment.WalletFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends FragmentActivity {
    private BottomBar bottombar;
    private FragNavController fragNavController;
    //Indices to fragment
    private final int TAB_FIRST = fragNavController.TAB1;
    private final int TAB_SECOND = fragNavController.TAB2;
    private final int TAB_THIRD = fragNavController.TAB3;
    private final int TAB_FOURTH = fragNavController.TAB4;
    private final int TAB_FIVE = fragNavController.TAB5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //a Bundle for restoring the state on configuration change.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Fragment> fragments = new ArrayList<>(5);
        //Add fragment in to the list
        fragments.add(new MoviesFragment());
        fragments.add(new AssistedFragment());
        fragments.add(new MyprofileFragment());
        fragments.add(new WalletFragment());
        fragments.add(new SettingsFragment());
        //Link fragment to container
        fragNavController = new FragNavController(getSupportFragmentManager(), R.id.activity_container, fragments);
        //Scrolling the bottombar
        bottombar = BottomBar.attachShy((CoordinatorLayout) findViewById(R.id.myCoordinator),
                findViewById(R.id.myScrollingContent), savedInstanceState);
        bottombar.setItems(R.menu.bottom_menu);
        bottombar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.intheatre:
                        fragNavController.switchTab(TAB_FIRST);
                        break;
                    case R.id.assistant:
                        fragNavController.switchTab(TAB_SECOND);
                        break;
                    case R.id.myprofile:
                        fragNavController.switchTab(TAB_THIRD);
                        break;
                    case R.id.wallet:
                        fragNavController.switchTab(TAB_FOURTH);
                        break;
                    case R.id.info:
                        fragNavController.switchTab(TAB_FIVE);
                    default:
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.intheatre) {
                    // clearstack---I need to remove or clear my activity stack then start a new activity
                    fragNavController.clearStack();
                }
            }
        });
        //It is the context of the current state of the application, newly created object wt has been going on
        bottombar.getBar().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.yellowgold
        ));
    }

    @Override
    public void onBackPressed() {
        if (fragNavController.getCurrentStack().size() > 1) {
            fragNavController.pop();

        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        //app to add any state data you want to save in outstate
        bottombar.onSaveInstanceState(outState);
    }
    private void commitFragmentTransaction(Fragment fragment){}
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
}
// FragNav: A Library for managing navigation between multiple stacks of fragments (for example tabbed navigation)
//Activity functionality compare to fragmentactivity is less, fragment activity is more functionality
// fragment activity we can reuse the same fragment
