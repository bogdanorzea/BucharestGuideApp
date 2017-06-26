package com.bogdanorzea.bucharestguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LandmarksFragment extends Fragment {
    private ArrayList<Attraction> attractions;

    public LandmarksFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        // Get arguments from Bundle
        Bundle bundle = getArguments();
        attractions = bundle.getParcelableArrayList("ATTRACTION_LIST");

        // Set the adapter for the ListView
        AttractionAdapter itemsAdapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        // Attach onClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // TODO Implement something nice here
                Toast.makeText(view.getContext(), "TADA!", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}
