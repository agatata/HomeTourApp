package com.example.android.hometourapp;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * {@link GuideItemAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link GuideItem} objects.
 */
public class GuideItemAdapter extends ArrayAdapter <GuideItem> {

    /**
     * Create a new {@link GuideItemAdapter} object.
     * @param guideItems is the list of {@link GuideItem}s to be displayed.
     */
    public GuideItemAdapter(Context context, ArrayList <GuideItem> guideItems) {
        super(context, 0, guideItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_fragment_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        GuideItem currentItem = getItem(position);

        // Find the TextView in the list_fragment_item.xml and get the title from the currentItem object. Then set it on the titleTextView.
        TextView titleTextView = listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentItem.getTitleId());

        // Find the TextView in the list_fragment_item.xml and get the description from the currentItem object. Then set it on the descriptionTextView.
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
       descriptionTextView.setText(currentItem.getDescriptionId());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentItem.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentItem.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}