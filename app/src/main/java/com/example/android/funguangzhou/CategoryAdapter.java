package com.example.android.funguangzhou;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    /**
     * Declare the name of the tab
     */
    public static final int TAB_SPOTS = 0;
    public static final int TAB_RESTAURANTS = 1;
    public static final int TAB_HOTELS = 2;
    public static final int TAB_THINGS = 3;
    
    /**
     * Number of the fragments
     */
    private static final int PAGE_COUNT = 4;

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TAB_SPOTS:
                return new SpotsFragment();
            case TAB_RESTAURANTS:
                return new RestaurantsFragment();
            case TAB_HOTELS:
                return new HotelsFragment();
            case TAB_THINGS:
                return new ThingsFragment();
            default:
                return null;
        }
    }

    /**
     * Set the number of the fragments
     */
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    /**
     * Return the String that should be displayed for the given page number.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case TAB_SPOTS:
                return mContext.getString(R.string.category_spots);
            case TAB_RESTAURANTS:
                return mContext.getString(R.string.category_restaurants);
            case TAB_HOTELS:
                return mContext.getString(R.string.category_hotels);
            case TAB_THINGS:
                return mContext.getString(R.string.category_things);
            default:
                return null;
        }
    }
}
