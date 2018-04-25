package com.example.android.hometourapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HighlightsFragment extends Fragment {

    @BindView(R.id.list)
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_fragment, container, false);
        // Bind ButterKnife
        ButterKnife.bind(this, rootView);

        // Create a list of words
        final ArrayList <GuideItem> guideItems = new ArrayList <>();
        guideItems.add(new GuideItem(R.string.highlights1_title, R.string.highlights1_description,
                R.drawable.ic_pets_black_18dp));
        guideItems.add(new GuideItem(R.string.highlights2_title, R.string.highlights2_description,
                R.drawable.ic_pets_black_18dp));
        guideItems.add(new GuideItem(R.string.highlights3_title, R.string.highlights3_description,
                R.drawable.ic_pets_black_18dp));

        // Create an {@link GuideItemAdapter}
        GuideItemAdapter adapter = new GuideItemAdapter(getActivity(), guideItems);

        listView.setAdapter(adapter);

        return rootView;
    }
}