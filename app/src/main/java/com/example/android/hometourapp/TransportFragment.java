package com.example.android.hometourapp;

import android.content.Intent;
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


public class TransportFragment extends Fragment {

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
        guideItems.add(new GuideItem(R.string.transport1_title, R.string.transport1_description,
                R.drawable.transport1));
        guideItems.add(new GuideItem(R.string.transport2_title, R.string.transport2_description,
                R.drawable.transport2));
        guideItems.add(new GuideItem(R.string.transport3_title, R.string.transport3_description,
                R.drawable.transport3));
        guideItems.add(new GuideItem(R.string.transport4_title, R.string.transport4_description,
                R.drawable.transport4));
        guideItems.add(new GuideItem(R.string.transport5_title, R.string.transport5_description,
                R.drawable.transport5));


        // Create an GuideItemAdapter
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