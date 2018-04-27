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
}