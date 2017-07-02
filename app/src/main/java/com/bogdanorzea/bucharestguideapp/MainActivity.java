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

    private Fragment prepareLandmarksFragment() {
        Bundle bundle = new Bundle();

        // Generate the list of Attractions to display
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(getString(R.string.palace_parliament_name), "https://en.wikipedia.org/wiki/Palace_of_the_Parliament", 44.4275, 26.0875, R.drawable.palace_parliament));
        attractions.add(new Attraction(getString(R.string.arch_triumph_name), "https://en.wikipedia.org/wiki/Arcul_de_Triumf", 44.467219, 26.078072, R.drawable.arch_triumph));
        attractions.add(new Attraction(getString(R.string.athenaeum_name), "https://en.wikipedia.org/wiki/Romanian_Athenaeum", 44.4413, 26.0973, R.drawable.atheneum));
        attractions.add(new Attraction(getString(R.string.palace_cotroceni_name), "https://en.wikipedia.org/wiki/Cotroceni_Palace", 44.434613, 26.062397, R.drawable.palace_cotroceni));
        attractions.add(new Attraction(getString(R.string.church_kretulescu_name), "https://en.wikipedia.org/wiki/Kretzulescu_Church", 44.438086, 26.096639, R.drawable.church_cretulescu));
        attractions.add(new Attraction(getString(R.string.palace_kretulescu_name), "https://en.wikipedia.org/wiki/Cre%C8%9Bulescu_Palace", 44.439558, 26.088589, R.drawable.palace_cretulescu));
        attractions.add(new Attraction(getString(R.string.churchu_stavropoleos_name), "https://en.wikipedia.org/wiki/Stavropoleos_Monastery", 44.431822, 26.098794, R.drawable.church_stavropoleos));
        attractions.add(new Attraction(getString(R.string.palace_cec_name), "https://en.wikipedia.org/wiki/CEC_Palace", 44.432, 26.0965, R.drawable.palace_cec));
        attractions.add(new Attraction(getString(R.string.national_arena_name), "https://en.wikipedia.org/wiki/Arena_Na%C8%9Bional%C4%83", 44.437208, 26.152508, R.drawable.national_arena));
        attractions.add(new Attraction(getString(R.string.palace_bnr_name), "https://en.wikipedia.org/wiki/National_Bank_of_Romania", 44.432594, 26.099397, R.drawable.palace_bnr));
        attractions.add(new Attraction(getString(R.string.house_press_name), "https://en.wikipedia.org/wiki/Casa_Presei_Libere", 44.480907, 26.071261, R.drawable.house_free_press));
        attractions.add(new Attraction(getString(R.string.opera_name), "https://en.wikipedia.org/wiki/Romanian_National_Opera,_Bucharest", 44.435833, 26.079444, R.drawable.opera));
        attractions.add(new Attraction(getString(R.string.national_theatre_name), "https://en.wikipedia.org/wiki/National_Theatre_Bucharest", 44.436644, 26.103569, R.drawable.tnb));

        // Put the attraction list to the bundle
        bundle.putParcelableArrayList("ATTRACTION_LIST", attractions);

        //Create new Fragment and set the arguments
        Fragment ret = new AttractionFragment();
        ret.setArguments(bundle);

        // Return the new fragment with the attached arguments
        return ret;
    }

    private Fragment prepareMuseumsFragment() {
        Bundle bundle = new Bundle();

        // Generate the list of Attractions to display
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(getString(R.string.museum_village_name), "https://en.wikipedia.org/wiki/Dimitrie_Gusti_National_Village_Museum", 44.473369, 26.076581, R.drawable.museum_village));
        attractions.add(new Attraction(getString(R.string.museum_art_name), "https://en.wikipedia.org/wiki/National_Museum_of_Art_of_Romania", 44.440161, 26.095533, R.drawable.museum_art));
        attractions.add(new Attraction(getString(R.string.museum_antipa_name), "https://en.wikipedia.org/wiki/Grigore_Antipa_National_Museum_of_Natural_History", 44.4531, 26.0846, R.drawable.museum_antipa));
        attractions.add(new Attraction(getString(R.string.museum_peasant_name), "https://en.wikipedia.org/wiki/Romanian_Peasant_Museum", 44.454383, 26.083678, R.drawable.museum_peasant));
        attractions.add(new Attraction(getString(R.string.museum_cont_art_name), "https://en.wikipedia.org/wiki/National_Museum_of_Contemporary_Art_(Romania)", 44.428039, 26.087008, R.drawable.museum_cont_art));
        attractions.add(new Attraction(getString(R.string.palace_cantacuzino_name), "https://en.wikipedia.org/wiki/Cantacuzino_Palace", 44.448762, 26.088358, R.drawable.palace_cantacuzino));
        attractions.add(new Attraction(getString(R.string.foisor_foc_name), "https://en.wikipedia.org/wiki/Foi%C8%99orul_de_Foc", 44.440333, 26.120589, R.drawable.foisorul_foc));
        attractions.add(new Attraction(getString(R.string.museum_geology_name), "https://en.wikipedia.org/wiki/Geology_Museum_(Romania)", 44.454853, 26.085411, R.drawable.museum_geology));
        attractions.add(new Attraction(getString(R.string.museum_history_name), "https://en.wikipedia.org/wiki/National_Museum_of_Romanian_History", 44.431531, 26.097225, R.drawable.museum_history));
        attractions.add(new Attraction(getString(R.string.museum_military_name), "https://en.wikipedia.org/wiki/National_Military_Museum,_Romania", 44.441364, 26.076393, R.drawable.museum_military));

        // Put the attraction list to the bundle
        bundle.putParcelableArrayList("ATTRACTION_LIST", attractions);

        //Create new Fragment and set the arguments
        Fragment ret = new AttractionFragment();
        ret.setArguments(bundle);

        // Return the new fragment with the attached arguments
        return ret;
    }

    private Fragment prepareParksFragment() {
        Bundle bundle = new Bundle();

        // Generate the list of Attractions to display
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(getString(R.string.park_herastrau_name), "https://en.wikipedia.org/wiki/Her%C4%83str%C4%83u_Park", 44.478056, 26.081417, R.drawable.park_herastrau));
        attractions.add(new Attraction(getString(R.string.garden_botanical_name), "https://en.wikipedia.org/wiki/Bucharest_Botanical_Garden", 44.4379, 26.0636, R.drawable.garden_botanical));
        attractions.add(new Attraction(getString(R.string.park_tineretului_name), "https://en.wikipedia.org/wiki/Tineretului_Park", 44.407525, 26.105597, R.drawable.park_tineretului));
        attractions.add(new Attraction(getString(R.string.zoo_baneasa_name), "https://en.wikipedia.org/wiki/Zoo_B%C4%83neasa", 44.51736, 26.1039, R.drawable.zoo_baneasa));
        attractions.add(new Attraction(getString(R.string.park_vacaresti_name), "https://en.wikipedia.org/wiki/V%C4%83c%C4%83re%C8%99ti_Nature_Park", 44.3996, 26.1342, R.drawable.park_vacaresti));
        attractions.add(new Attraction(getString(R.string.gardens_cismigiu_name), "https://en.wikipedia.org/wiki/Ci%C8%99migiu_Gardens", 44.436903, 26.090508, R.drawable.garden_cismigiu));
        attractions.add(new Attraction(getString(R.string.park_carol_name), "https://en.wikipedia.org/wiki/Carol_Park", 44.413889, 26.095833, R.drawable.park_carol));
        attractions.add(new Attraction(getString(R.string.forest_baneasa_name), "https://en.wikipedia.org/wiki/B%C4%83neasa_Forest", 44.517222, 26.6, R.drawable.forest_baneasa));
        attractions.add(new Attraction(getString(R.string.park_bordei_name), "https://en.wikipedia.org/wiki/Bordei_Park", 44.4726056, 26.0910706, R.drawable.park_bordei));

        // Put the attraction list to the bundle
        bundle.putParcelableArrayList("ATTRACTION_LIST", attractions);

        //Create new Fragment and set the arguments
        Fragment ret = new AttractionFragment();
        ret.setArguments(bundle);

        // Return the new fragment with the attached arguments
        return ret;
    }

    private Fragment prepareRestaurantsFragment() {
        Bundle bundle = new Bundle();

        // Generate the list of Attractions to display
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(getString(R.string.caru_bere_name), "https://www.carucubere.ro/en/", 44.431991, 26.0981124, R.drawable.caru_bere));
        attractions.add(new Attraction(getString(R.string.manuc_inn_name), "https://hanulluimanuc.ro/en/", 44.429512, 26.102242, R.drawable.manuc_inn));
        attractions.add(new Attraction(getString(R.string.the_artist_name), "http://theartist.ro/", 44.449707, 26.087912, R.drawable.the_artist));
        attractions.add(new Attraction(getString(R.string.pescaria_dorobantilor_name), "https://www.facebook.com/pescariadorobantilor", 44.459627, 26.097061, R.drawable.pescaria_dorobantilor));
        attractions.add(new Attraction(getString(R.string.beraria_h_name), "https://www.facebook.com/BerariaH/", 44.476641, 26.075939, R.drawable.beraria_h));
        attractions.add(new Attraction(getString(R.string.pescarus_name), "http://www.restaurantpescarus.ro/en/", 44.4725228, 26.0849187, R.drawable.pescarus_restaurant));
        attractions.add(new Attraction(getString(R.string.energiea_name), "http://energiea.ro/", 44.433268, 26.094863, R.drawable.energiea));
        attractions.add(new Attraction(getString(R.string.van_gogh_name), "https://www.facebook.com/grandcafe.vangogh", 44.432433, 26.100207, R.drawable.van_gogh));
        attractions.add(new Attraction(getString(R.string.lounge_18_name), "http://www.18lounge.ro/", 44.4776745, 26.0716537, R.drawable.lounge_18));
        attractions.add(new Attraction(getString(R.string.shift_pub_name), "http://shiftpub.ro/", 44.4449361, 26.1016247, R.drawable.shift_pub));
        attractions.add(new Attraction(getString(R.string.alt_shift_name), "http://www.altshift.ro/", 44.4354413, 26.0971012, R.drawable.alt_shift));
        attractions.add(new Attraction(getString(R.string.upstairs_rooftop_name), "https://www.upstairs.ro/", 44.4495211, 26.0856454, R.drawable.upstairs_rooftop));
        attractions.add(new Attraction(getString(R.string.cos_name), "http://www.cos-restaurant-bucuresti.ro/", 44.4457826, 26.0991135, R.drawable.cos));

        // Put the attraction list to the bundle
        bundle.putParcelableArrayList("ATTRACTION_LIST", attractions);

        //Create new Fragment and set the arguments
        Fragment ret = new AttractionFragment();
        ret.setArguments(bundle);

        // Return the new fragment with the attached arguments
        return ret;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(prepareLandmarksFragment());
        adapter.addFragment(prepareMuseumsFragment());
        adapter.addFragment(prepareParksFragment());
        adapter.addFragment(prepareRestaurantsFragment());

        viewPager.setAdapter(adapter);
    }
}
