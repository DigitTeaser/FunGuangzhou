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
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.place_list, container, false);

        // Add Contents to the array list
        final List<Place> placeList = new ArrayList<>();
        placeList.add(new Place(getString(R.string.name_diandude), getString(R.string.type_dim_sum),
                getString(R.string.address_diandude) + getString(R.string.district_yuexiu),
                R.drawable.diandude));
        placeList.add(new Place(getString(R.string.name_yinji), getString(R.string.type_high_tea),
                getString(R.string.address_yinji) + getString(R.string.district_liwan),
                R.drawable.yinji));
        placeList.add(new Place(getString(R.string.name_huishijia), getString(R.string.type_cantonese),
                getString(R.string.address_huishijia) + getString(R.string.district_Haizhu),
                R.drawable.huishijia));
        placeList.add(new Place(getString(R.string.name_nanxin_desserts), getString(R.string.type_high_tea),
                getString(R.string.address_nanxin_desserts) + getString(R.string.district_liwan),
                R.drawable.nanxin_desserts));
        placeList.add(new Place(getString(R.string.name_bingsheng_taste), getString(R.string.type_cantonese),
                getString(R.string.address_bingsheng_taste) + getString(R.string.district_Haizhu),
                R.drawable.bingsheng_taste));
        placeList.add(new Place(getString(R.string.name_totokui), getString(R.string.type_cantonese),
                getString(R.string.address_totokui) + getString(R.string.district_liwan),
                R.drawable.totokui));

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
