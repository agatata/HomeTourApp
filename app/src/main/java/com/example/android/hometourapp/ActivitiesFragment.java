package com.example.android.hometourapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;


public class ActivitiesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activities, container, false);

        // Create a list of words
        final ArrayList <GuideItem> guideItems = new ArrayList <>();
        guideItems.add(new GuideItem(R.string.activities1_title, R.string.activities1_description,
                R.drawable.ic_pets_black_18dp));
        guideItems.add(new GuideItem(R.string.activities2_title, R.string.activities2_description,
                R.drawable.ic_pets_black_18dp));
        guideItems.add(new GuideItem(R.string.activities3_title, R.string.activities3_description,
                R.drawable.ic_pets_black_18dp));

        // Create an {@link GuideItemAdapter}
        GuideItemAdapter adapter = new GuideItemAdapter(getActivity(), guideItems);

        // Find the {@link ListView} object.
        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}