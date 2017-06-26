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
    private String mDescription;

    public Attraction(String name, String description) {
        mName = name;
        mDescription = description;
    }

    protected Attraction(Parcel in) {
        mName = in.readString();
        mDescription = in.readString();
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mDescription);
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }
}
