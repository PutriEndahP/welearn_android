package com.example.welearn.Response.Ranking;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RankingAngka implements Parcelable{
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("total")
    @Expose
    private String total;

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(total);
    }

    public RankingAngka(Parcel in) {
        name = in.readString();
        total = in.readString();
    }

    public static final Parcelable.Creator<RankingAngka> CREATOR = new Parcelable.Creator<RankingAngka>() {
        public RankingAngka createFromParcel(Parcel in) {
            return new RankingAngka(in);
        }

        public RankingAngka[] newArray(int size) {
            return new RankingAngka[size];
        }
    };

}
