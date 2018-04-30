package com.example.android.hometourapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        guideItems.add(new GuideItem(R.string.highlights1_title, R.string.highlights1_description));
        guideItems.add(new GuideItem(R.string.highlights2_title, R.string.highlights2_description,
                R.drawable.highlights2));
        guideItems.add(new GuideItem(R.string.highlights3_title, R.string.highlights3_description,
                R.drawable.highlights3));
        guideItems.add(new GuideItem(R.string.highlights4_title, R.string.highlights4_description,
                R.drawable.highlights4));
        guideItems.add(new GuideItem(R.string.highlights5_title, R.string.highlights5_description,
                R.drawable.highlights5));


        // Create an {@link GuideItemAdapter}
        final GuideItemAdapter adapter = new GuideItemAdapter(getActivity(), guideItems);

        listView.setAdapter(adapter);

        // Tracking which item was selected, starting new activity and passing the array
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                // get the data from adapter
                com.example.android.hometourapp.GuideItem getData = adapter.getItem(position);
                // put the data in intent
                Intent guideItemIntent = intent.putExtra("guideItems", getData);
                startActivity(guideItemIntent);
            }
        });

        return rootView;
    }
}