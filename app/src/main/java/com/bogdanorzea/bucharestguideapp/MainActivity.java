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
        attractions.add(new Attraction("People's House","https://en.wikipedia.org/wiki/Palace_of_the_Parliament",44.4275,26.0875));
        attractions.add(new Attraction("The Arch Of Triumph","https://en.wikipedia.org/wiki/Arcul_de_Triumf",44.467219,26.078072));
        attractions.add(new Attraction("Romanian Athenaeum","https://en.wikipedia.org/wiki/Romanian_Athenaeum",44.4413,26.0973));
        attractions.add(new Attraction("Cotroceni Palace","https://en.wikipedia.org/wiki/Cotroceni_Palace",44.434613,26.062397));
        attractions.add(new Attraction("Kretzulescu Church","https://en.wikipedia.org/wiki/Kretzulescu_Church",44.438086,26.096639));
        attractions.add(new Attraction("Crețulescu Palace","https://en.wikipedia.org/wiki/Cre%C8%9Bulescu_Palace", 44.439558,26.088589));
        attractions.add(new Attraction("Stavropoleos Church","https://en.wikipedia.org/wiki/Stavropoleos_Monastery",44.431822,26.098794));
        attractions.add(new Attraction("CEC Palace","https://en.wikipedia.org/wiki/CEC_Palace",44.432,26.0965));
        attractions.add(new Attraction("National Arena Stadium Bucharest","https://en.wikipedia.org/wiki/Arena_Na%C8%9Bional%C4%83",44.437208,26.152508));
        attractions.add(new Attraction("BNR Palace","https://en.wikipedia.org/wiki/National_Bank_of_Romania", 44.432594,26.099397));
        attractions.add(new Attraction("House of the Free Press","https://en.wikipedia.org/wiki/Casa_Presei_Libere",44.480907,26.071261));
        attractions.add(new Attraction("Romanian National Opera","https://en.wikipedia.org/wiki/Romanian_National_Opera,_Bucharest",44.435833,26.079444));
        attractions.add(new Attraction("National Theatre Bucharest","https://en.wikipedia.org/wiki/National_Theatre_Bucharest",44.436644,26.103569));

        // Put the attraction list to the bundle
        bundle.putParcelableArrayList("ATTRACTION_LIST", attractions);

        //Create new Fragment and set the arguments
        Fragment ret = new LandmarksFragment();
        ret.setArguments(bundle);

        // Return the new fragment with the attached arguments
        return ret;
    }

    private Fragment prepareMuseumsFragment() {
        Bundle bundle = new Bundle();

        // Generate the list of Attractions to display
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction("Dimitrie Gusti National Village Museum","https://en.wikipedia.org/wiki/Dimitrie_Gusti_National_Village_Museum", 44.473369,26.076581));
        attractions.add(new Attraction("National Museum of Art of Romania","https://en.wikipedia.org/wiki/National_Museum_of_Art_of_Romania", 44.440161,26.095533));
        attractions.add(new Attraction("Grigore Antipa National Museum of Natural History","https://en.wikipedia.org/wiki/Grigore_Antipa_National_Museum_of_Natural_History", 44.4531,26.0846));
        attractions.add(new Attraction("Romanian Peasant Museum","https://en.wikipedia.org/wiki/Romanian_Peasant_Museum",44.454383,26.083678));
        attractions.add(new Attraction("National Museum of Contemporary Art","https://en.wikipedia.org/wiki/National_Museum_of_Contemporary_Art_(Romania)",44.428039,26.087008));
        attractions.add(new Attraction("Cantacuzino Palace","https://en.wikipedia.org/wiki/Cantacuzino_Palace",44.448762,26.088358));
        attractions.add(new Attraction("Foișorul de Foc","https://en.wikipedia.org/wiki/Foi%C8%99orul_de_Foc",44.440333,26.120589));
        attractions.add(new Attraction("Geology Museum","https://en.wikipedia.org/wiki/Geology_Museum_(Romania)",44.454853,26.085411));
        attractions.add(new Attraction("National Museum of Romanian History","https://en.wikipedia.org/wiki/National_Museum_of_Romanian_History",44.431531,26.097225));
        attractions.add(new Attraction("National Military Museum","https://en.wikipedia.org/wiki/National_Military_Museum,_Romania",44.441364,26.076393));

        // Put the attraction list to the bundle
        bundle.putParcelableArrayList("ATTRACTION_LIST", attractions);

        //Create new Fragment and set the arguments
        Fragment ret = new LandmarksFragment();
        ret.setArguments(bundle);

        // Return the new fragment with the attached arguments
        return ret;
    }

    private Fragment prepareParksFragment() {
        Bundle bundle = new Bundle();

        // Generate the list of Attractions to display
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction("Herăstrău Park","https://en.wikipedia.org/wiki/Her%C4%83str%C4%83u_Park",44.478056,26.081417));
        attractions.add(new Attraction("Botanical Garden","https://en.wikipedia.org/wiki/Bucharest_Botanical_Garden",44.4379,26.0636));
        attractions.add(new Attraction("Tineretului Park","https://en.wikipedia.org/wiki/Tineretului_Park",44.407525,26.105597));
        attractions.add(new Attraction("Zoo Băneasa","https://en.wikipedia.org/wiki/Zoo_B%C4%83neasa",44.51736,26.1039));
        attractions.add(new Attraction("Văcărești Nature Park","https://en.wikipedia.org/wiki/V%C4%83c%C4%83re%C8%99ti_Nature_Park", 44.3996,26.1342));
        attractions.add(new Attraction("Cișmigiu Gardens","https://en.wikipedia.org/wiki/Ci%C8%99migiu_Gardens",44.436903,26.090508));
        attractions.add(new Attraction("Carol Park","https://en.wikipedia.org/wiki/Carol_Park",44.413889,26.095833));
        attractions.add(new Attraction("Băneasa Forest","https://en.wikipedia.org/wiki/B%C4%83neasa_Forest",44.517222,26.6));
        attractions.add(new Attraction("Bordei Park","https://en.wikipedia.org/wiki/Bordei_Park",44.4726056,26.0910706));

        // Put the attraction list to the bundle
        bundle.putParcelableArrayList("ATTRACTION_LIST", attractions);

        //Create new Fragment and set the arguments
        Fragment ret = new LandmarksFragment();
        ret.setArguments(bundle);

        // Return the new fragment with the attached arguments
        return ret;
    }

    private Fragment prepareRestaurantsFragment() {
        Bundle bundle = new Bundle();

        // Generate the list of Attractions to display
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction("Caru' cu Bere","https://www.carucubere.ro/en/", 44.431991,26.0981124));
        attractions.add(new Attraction("Manuc's Inn","https://hanulluimanuc.ro/en/",44.429512,26.102242));
        attractions.add(new Attraction("the ARTIST","http://theartist.ro/",44.449707,26.087912));
        attractions.add(new Attraction("La Pescaria Dorobantilor","https://www.facebook.com/pescariadorobantilor",44.459627,26.097061));
        attractions.add(new Attraction("Beraria H","https://www.facebook.com/BerariaH/",44.476641,26.075939));
        attractions.add(new Attraction("Pescarus Restaurant","http://www.restaurantpescarus.ro/en/",44.4725228,26.0849187));
        attractions.add(new Attraction("Energiea","http://energiea.ro/",44.433268,26.094863));
        attractions.add(new Attraction("Grand Cafe Van Gogh","https://www.facebook.com/grandcafe.vangogh",44.432433,26.100207));
        attractions.add(new Attraction("18 Lounge","http://www.18lounge.ro/",44.4776745,26.0716537));
        attractions.add(new Attraction("Shift Pub","http://shiftpub.ro/",44.4449361,26.1016247));
        attractions.add(new Attraction("Alt Shift","http://www.altshift.ro/",44.4354413,26.0971012));
        attractions.add(new Attraction("Upstairs Rooftop","https://www.upstairs.ro/",44.4495211,26.0856454));
        attractions.add(new Attraction("Casa Oamenilor de Stiinta","http://www.cos-restaurant-bucuresti.ro/",44.4457826,26.0991135));

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

        adapter.addFragment(prepareLandmarksFragment());
        adapter.addFragment(prepareMuseumsFragment());
        adapter.addFragment(prepareParksFragment());
        adapter.addFragment(prepareRestaurantsFragment());

        viewPager.setAdapter(adapter);
    }
}
