package com.example.restaurantorganizer;

import android.os.Parcel;
import android.os.Parcelable;


public class Item implements Parcelable {
    String name;
    double price;

    public Item(String n, double p){
        name=n;
        price=p;
    }

    private Item(Parcel in) {
        name=in.readString();
        price=in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
    }

    public static final Parcelable.Creator<Item> CREATOR
            = new Parcelable.Creator<Item>() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
