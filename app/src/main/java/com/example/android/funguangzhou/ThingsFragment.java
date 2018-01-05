package com.example.android.funguangzhou;


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
public class ThingsFragment extends Fragment {

    public ThingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.place_list, container, false);

        // Add Contents to the array list
        final List<Place> placeList = new ArrayList<>();
        placeList.add(new Place(getString(R.string.name_ham_cookies), getString(R.string.type_specialty),
                getString(R.string.address_ham_cookies), R.drawable.ham_cookies));
        placeList.add(new Place(getString(R.string.name_cantonese_sausage), getString(R.string.type_specialty),
                getString(R.string.address_cantonese_sausage), R.drawable.cantonese_sausage));
        placeList.add(new Place(getString(R.string.name_dried_longan), getString(R.string.type_specialty),
                getString(R.string.address_dried_longan), R.drawable.dried_longan));
        placeList.add(new Place(getString(R.string.name_canton_enamel), getString(R.string.type_artworks),
                getString(R.string.address_canton_enamel), R.drawable.canton_enamel));
        placeList.add(new Place(getString(R.string.name_canton_embroider), getString(R.string.type_artworks),
                getString(R.string.address_canton_embroider), R.drawable.canton_embroidery));
        placeList.add(new Place(getString(R.string.name_rooster_olives), getString(R.string.type_rooster_olives),
                getString(R.string.address_rooster_olives), R.drawable.rooster_olives));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter mAdapter = new PlaceAdapter(placeList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Make the {@link RecycleView} use the {@link PlaceAdapter} created above, so that the
        // {@link RecycleView} will display list items for each {@link Place} in the list.
        recyclerView.setAdapter(mAdapter);

        return recyclerView;
    }

}
