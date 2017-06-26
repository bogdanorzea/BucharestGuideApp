package com.bogdanorzea.bucharestguideapp;


import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigation;
    private ViewPager viewPager;

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            navigation.getMenu().getItem(position).setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_landmarks:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_museums:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.navigation_parks:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.navigation_restaurants:
                    viewPager.setCurrentItem(3);
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.addOnPageChangeListener(mOnPageChangeListener);
        setupViewPager(viewPager);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private Fragment prepareLandmarksFragment(String numb) {
        Bundle bundle = new Bundle();

        // Generate the list of Attractions to display
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));
        attractions.add(new Attraction(numb, "TODO"));

        // Put the attraction list to the bundle
        bundle.putParcelableArrayList("ATTRACTION_LIST", attractions);

        //Create new Fragment and set the arguments
        Fragment ret = new LandmarksFragment();
        ret.setArguments(bundle);

        // Return the new fragment with the attached arguments
        return ret;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(prepareLandmarksFragment("one"));
        adapter.addFragment(prepareLandmarksFragment("two"));
        adapter.addFragment(prepareLandmarksFragment("three"));
        adapter.addFragment(prepareLandmarksFragment("four"));
        viewPager.setAdapter(adapter);
    }
}
