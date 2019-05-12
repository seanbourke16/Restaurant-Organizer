package com.example.restaurantorganizer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Reservation implements Parcelable{

    String name;
    Date date;

    public Reservation(String n, Date d){
        name=n;
        date=d;
    }

    private Reservation(Parcel in) {
        name=in.readString();
        date=new Date(in.readInt(),in.readInt(),in.readInt(),in.readInt(),in.readInt(),in.readInt());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(date.getYear());
        dest.writeInt(date.getMonth());
        dest.writeInt(date.getDate());
        dest.writeInt(date.getHours());
        dest.writeInt(date.getMinutes());
    }

    public static final Parcelable.Creator<Reservation> CREATOR
            = new Parcelable.Creator<Reservation>() {
        public Reservation createFromParcel(Parcel in) {
            return new Reservation(in);
        }

        public Reservation[] newArray(int size) {
            return new Reservation[size];
        }
    };
}
