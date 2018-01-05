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
public class SpotsFragment extends Fragment {

    public SpotsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.place_list, container, false);

        // Add Contents to the array list
        final List<Place> placeList = new ArrayList<>();
        placeList.add(new Place(getString(R.string.name_baiyun_mountain), getString(R.string.type_scenery),
                getString(R.string.address_baiyun_mountain) + getString(R.string.district_baiyun),
                R.drawable.baiyun_mountain));
        placeList.add(new Place(getString(R.string.name_yuexiu_park), getString(R.string.type_scenery),
                getString(R.string.address_yuexiu_park) + getString(R.string.district_yuexiu),
                R.drawable.yuexiu_park));
        placeList.add(new Place(getString(R.string.name_canton_tower), getString(R.string.type_scenery),
                getString(R.string.address_canton_tower) + getString(R.string.district_Haizhu),
                R.drawable.canton_tower));
        placeList.add(new Place(getString(R.string.name_shangxiajiu), getString(R.string.type_commercial_street),
                getString(R.string.address_shangxiajiu) + getString(R.string.district_liwan),
                R.drawable.shangxiajiu));
        placeList.add(new Place(getString(R.string.name_chime_long_paradise), getString(R.string.type_theme_park),
                getString(R.string.address_chime_long_paradise) + getString(R.string.district_panyu),
                R.drawable.chime_long_paradise));
        placeList.add(new Place(getString(R.string.name_redtory), getString(R.string.type_museum),
                getString(R.string.address_redtory) + getString(R.string.district_tianhe),
                R.drawable.redtory));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter mAdapter = new PlaceAdapter(placeList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);

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
