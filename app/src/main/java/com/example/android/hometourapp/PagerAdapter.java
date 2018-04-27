package com.example.android.hometourapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link PagerAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HighlightsFragment();
        } else if (position == 1) {
            return new WildlifeFragment();
        } else if (position == 2) {
            return new ActivitiesFragment();
        } else if (position == 3) {
            return new RestaurantsFragment();
        } else if (position == 4) {
            return new TransportFragment();
        } else {
            return new AccommodationFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 6;
    }

   // @Override
   // public CharSequence getPageTitle(int position) {
   //     if (position == 0) {
   //         return mContext.getString(R.string.highlights);
   //     } else if (position == 1) {
   //         return mContext.getString(R.string.wildlife);
   //     } else if (position == 1) {
   //         return mContext.getString(R.string.activities);
   //     } else if (position == 1) {
   //         return mContext.getString(R.string.restaurants);
   //     } else if (position == 1) {
   //         return mContext.getString(R.string.transport);
   //     } else {
   //         return mContext.getString(R.string.accommodation);
   //     }
   // }
}

