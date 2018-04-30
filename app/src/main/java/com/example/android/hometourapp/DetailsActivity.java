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
        // bind ButterKnife
        ButterKnife.bind(this);

        // get the intent from MainActivity
        Intent intent = getIntent();
        com.example.android.hometourapp.GuideItem guideItemChoice = intent.getParcelableExtra("guideItems");

        // initialize the strings and the image view ID
        int getTitle = guideItemChoice.getTitleId();
        int getDescription = guideItemChoice.getDescriptionId();
        int getImage = guideItemChoice.getImageResourceId();

        // set dat to the views
        title.setText(getTitle);
        description.setText(getDescription);

        // Check if an image is provided for this word or not
        if (guideItemChoice.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            image.setImageResource(getImage);
        } else {
            // If an image is not available, display the provided custom image
            image.setImageResource(R.drawable.customphoto);
        }

    }

}
