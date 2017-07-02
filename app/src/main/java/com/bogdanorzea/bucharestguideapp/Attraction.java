package com.bogdanorzea.bucharestguideapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Attraction implements Parcelable {
    public static final Creator<Attraction> CREATOR = new Creator<Attraction>() {
        @Override
        public Attraction createFromParcel(Parcel in) {
            return new Attraction(in);
        }

        @Override
        public Attraction[] newArray(int size) {
            return new Attraction[size];
        }
    };
    private String mName;
    private String mWebsite;
    private double mLongitude;
    private double mLatitude;
    private int mImageId;

    protected Attraction(Parcel in) {
        mName = in.readString();
        mWebsite = in.readString();
        mLatitude = in.readDouble();
        mLongitude = in.readDouble();
    }

    public Attraction(String name, String website, double latitude, double longitude, int imageId) {
        mName = name;
        mWebsite = website;
        mLatitude = latitude;
        mLongitude = longitude;
        mImageId = imageId;
    }

    public int getImageId() {
        return mImageId;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mWebsite);
        dest.writeDouble(mLatitude);
        dest.writeDouble(mLongitude);
    }

    public String getName() {
        return mName;
    }

    public String getWebsite() {
        return mWebsite;
    }
}
