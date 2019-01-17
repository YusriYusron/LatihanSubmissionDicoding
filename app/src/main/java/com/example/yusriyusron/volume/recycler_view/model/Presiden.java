package com.example.yusriyusron.volume.recycler_view.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Presiden implements Parcelable {
    private String name, remarks, photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.remarks);
        parcel.writeString(this.photo);
    }

    public Presiden(){

    }
    protected Presiden(Parcel in){
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
    }

    public static final Parcelable.Creator<Presiden> CREATOR = new Parcelable.Creator<Presiden>(){

        @Override
        public Presiden createFromParcel(Parcel parcel) {
            return new Presiden(parcel);
        }

        @Override
        public Presiden[] newArray(int i) {
            return new Presiden[i];
        }
    };
}
