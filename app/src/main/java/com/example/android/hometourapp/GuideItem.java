package com.example.android.hometourapp;

public class GuideItem {
    /** String resource ID for the title of the list item */
    private int mTitleId;

    /** String resource ID for the description of the list item */
    private int mDescriptionId;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Word object.
     *
     * @param titleId is the string resource ID for the title of the list item of the guide
     * @param descriptionId is the string resource Id for the description of the list item
     */
    public GuideItem(int titleId, int descriptionId) {
        mTitleId = titleId;
        mDescriptionId = descriptionId;
    }

    /**
     * Create a new Word object.
     *
     * @param titleId is the string resource ID for the title of the list item of the guide
     * @param descriptionId is the string resource Id for the description of the list item
     * @param imageResourceId is the drawable resource ID for the image associated with the list item
     */
    public GuideItem(int titleId, int descriptionId, int imageResourceId) {
        mTitleId = titleId;
        mDescriptionId = descriptionId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the string resource ID for the title of the list item.
     */
    public int getTitleId() {
        return mTitleId;
    }

    /**
     * Get the string resource ID for the description.
     */
    public int getDescriptionId() {
        return mDescriptionId;
    }

    /**
     * Return the image resource ID of the list item.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this list item.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
