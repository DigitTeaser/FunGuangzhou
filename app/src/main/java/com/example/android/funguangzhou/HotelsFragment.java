package com.example.android.funguangzhou;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.place_list, container, false);

        // Add Contents to the array list
        final List<Place> placeList = new ArrayList<>();
        placeList.add(new Place(getString(R.string.name_four_seasons), getString(R.string.type_five_stars),
                getString(R.string.address_four_seasons) + getString(R.string.district_tianhe),
                R.drawable.four_seasons));
        placeList.add(new Place(getString(R.string.name_white_swan), getString(R.string.type_five_stars),
                getString(R.string.address_white_swan) + getString(R.string.district_liwan),
                R.drawable.white_swan));
        placeList.add(new Place(getString(R.string.name_oakwood_premier), getString(R.string.type_vacation_rentals),
                getString(R.string.address_oakwood_premier) + getString(R.string.district_tianhe),
                R.drawable.oakwood_premier));
        placeList.add(new Place(getString(R.string.name_doubletree), getString(R.string.type_business),
                getString(R.string.address_doubletree) + getString(R.string.district_huangpu),
                R.drawable.doubletree));
        placeList.add(new Place(getString(R.string.name_seven_days), getString(R.string.type_budget),
                getString(R.string.address_seven_days) + getString(R.string.district_tianhe),
                R.drawable.seven_days));
        placeList.add(new Place(getString(R.string.name_zhaohuaxishi), getString(R.string.type_youth_hostel),
                getString(R.string.address_zhaohuaxishi) + getString(R.string.district_panyu),
                R.drawable.zhaohuaxishi));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter mAdapter = new PlaceAdapter(placeList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Make the {@link RecycleView} use the {@link PlaceAdapter} created above, so that the
        // {@link RecycleView} will display list items for each {@link Place} in the list.
        recyclerView.setAdapter(mAdapter);

        // Setup an OnItemClickListener to handle the click event of the RecyclerView item
        mAdapter.setOnItemClickListener(new PlaceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(placeList.get(position).getName()) + " " + Uri.encode(placeList.get(position).getAddress()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        return recyclerView;
    }
}
