package com.example.android.hometourapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * {@link GuideItemAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link GuideItem} objects.
 */
public class GuideItemAdapter extends ArrayAdapter <GuideItem> {

    /**
     * Create a new GuideItemAdapter object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of GuideItem s to be displayed.
     */
    public GuideItemAdapter(Context context, ArrayList<GuideItem> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        ViewHolder holder;
        if (listItemView != null) {
            holder = (ViewHolder) listItemView.getTag();
        } else {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_fragment_item, parent, false);
            holder = new ViewHolder(listItemView);
            listItemView.setTag(holder);
        }


        // Get the GuideItem object located at this position in the list
        GuideItem currentItem = getItem(position);

        holder.titleTextView.setText(currentItem.getTitleId());
        holder.descriptionTextView.setText(currentItem.getDescriptionId());


        // Check if an image is provided for this word or not
        if (currentItem.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            holder.imageView.setImageResource(currentItem.getImageResourceId());
            // Make sure the view is visible
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            holder.imageView.setVisibility(View.INVISIBLE);
        }

        return listItemView;
    }

    static class ViewHolder {
        @BindView(R.id.title_text_view)
        TextView titleTextView;
        @BindView(R.id.description_text_view)
        TextView descriptionTextView;
        @BindView(R.id.image)
        ImageView imageView;

        public ViewHolder(View listItemView) {
            ButterKnife.bind(this, listItemView);
        }
    }

    // /**
    //  * Create a new {@link GuideItemAdapter} object.
    //  *
    //  * @param guideItems is the list of {@link GuideItem}s to be displayed.
    //  */
    // public GuideItemAdapter(Context context, ArrayList <GuideItem> guideItems) {
    //     super(context, 0, guideItems);
    // }
    //
    // @BindView(R.id.title_text_view)
    // TextView titleTextView;
    // @BindView(R.id.description_text_view)
    // TextView descriptionTextView;
    //
    // @Override
    // public View getView(int position, View convertView, ViewGroup parent) {
    //     View listItemView = convertView;
    //
    //     // Check if an existing view is being reused, otherwise inflate the view
    //     if (listItemView == null) {
    //         listItemView = LayoutInflater.from(getContext()).inflate(
    //                 R.layout.list_fragment_item, parent, false);
    //     }
    //
    //     // Get the {@link Word} object located at this position in the list
    //     GuideItem currentItem = getItem(position);
    //
    //     // Get the title from the currentItem object and set it on the titleTextView.
    //     titleTextView.setText(currentItem.getTitleId());
    //
    //     // Get the description from the currentItem object and set it on the descriptionTextView.
    //     descriptionTextView.setText(currentItem.getDescriptionId());
    //
    //     // Find the ImageView in the list_item.xml layout with the ID image.
    //     ImageView imageView = listItemView.findViewById(R.id.image);
    //
    //     // Check if an image is provided for this word or not
    //     if (currentItem.hasImage()) {
    //         // If an image is available, display the provided image based on the resource ID
    //         imageView.setImageResource(currentItem.getImageResourceId());
    //         // Make sure the view is visible
    //         imageView.setVisibility(View.VISIBLE);
    //     } else {
    //         // Otherwise hide the ImageView (set visibility to GONE)
    //         imageView.setVisibility(View.INVISIBLE);
    //     }
    //
    //     // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
    //     // the ListView.
    //     return listItemView;
    // }
}