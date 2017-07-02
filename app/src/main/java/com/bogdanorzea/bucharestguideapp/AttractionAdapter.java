package com.bogdanorzea.bucharestguideapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class AttractionAdapter extends ArrayAdapter<Attraction> {
    ArrayList<Attraction> mAttractions;

    public AttractionAdapter(Context context, ArrayList<Attraction> objects) {
        super(context, 0, objects);
        mAttractions = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Check to see if the view was re-used or not
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.attraction_item, parent, false);
        }

        // Get the current attraction from the list
        final Attraction currentAttraction = mAttractions.get(position);

        // Set the Attraction name
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.name);
        defaultTextView.setText(currentAttraction.getName());

        // Set the Attraction website
        ImageView openWebsite = (ImageView) listItemView.findViewById(R.id.browser);
        openWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(currentAttraction.getWebsite())));
            }
        });

        // Set the Attraction map
        ImageView openMap = (ImageView) listItemView.findViewById(R.id.map);
        openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lat = currentAttraction.getLatitude();
                double lon = currentAttraction.getLongitude();
                getContext().startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:<" + lat + ">,<" + lon + ">?q=<" + lat + ">,<" + lon + ">(" + currentAttraction.getName() + ")")));
            }
        });


        // Return the view
        return listItemView;
    }
}
