package com.example.android.funguangzhou;

/**
 * {@link Place} represents a tourist place that the app suggests to go.
 * It contains a name and a type of that place.
 */
public class Place {

    /**
     * Name of the place
     */
    private String mName;

    /**
     * Type of the place
     */
    private String mType;

    /**
     * Address of the place
     */
    private String mAddress;

    /**
     * Image resource ID for the place
     */
    private int mImageResourceId;

    /**
     * Create a new Place object
     *
     * @param name            is the name of a place
     * @param type            is the type of that place
     * @param address         is the address of that place
     * @param imageResourceId is the drawable resource ID for the image associated with the place
     */
    public Place(String name, String type, String address, int imageResourceId) {
        mName = name;
        mType = type;
        mAddress = address;
        mImageResourceId = imageResourceId;
    }

    /**
     * Return the name of the place
     */
    public String getName() {
        return mName;
    }

    /**
     * Return the type of the place
     */
    public String getType() {
        return mType;
    }

    /**
     * Return the address of the place
     */
    public String getAddress() {
        return mAddress;
    }

    /**
     * Return the image resource ID of the place
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
}
