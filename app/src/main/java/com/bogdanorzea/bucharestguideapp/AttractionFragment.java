package com.bogdanorzea.bucharestguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class AttractionFragment extends Fragment {
    private ArrayList<Attraction> attractions;

    public AttractionFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        // Get arguments from Bundle
        Bundle bundle = getArguments();
        attractions = bundle.getParcelableArrayList("ATTRACTION_LIST");

        // Set the adapter for the ListView
        AttractionAdapter itemsAdapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }
}
