package com.example.android.hometourapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.details_image)
    ImageView image;
    @BindView(R.id.details_title)
    TextView title;
    @BindView(R.id.details_description)
    TextView description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        // binding ButterKnife
        ButterKnife.bind(this);

        // get the intent from MainActivity
        Intent intent = getIntent();
        com.example.android.hometourapp.GuideItem birdChoice = intent.getParcelableExtra("guideItems");

        // initialize the strings and the image view ID
        int birdName = birdChoice.getTitleId();
        int birdPlace = birdChoice.getDescriptionId();
        int birdImage = birdChoice.getImageResourceId();

        // set dat to the views
        title.setText(birdName);
        description.setText(birdPlace);
        image.setImageResource(birdImage);

    }

}
