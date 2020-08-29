package com.dicoding.android.fundamental.githubuserapp.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pojogithub implements Parcelable {
//    private int ivprofil;
//    private String username,name,company,location,repository,follower,following;

    @SerializedName("id")
    private long id;

    private  String location;

    @SerializedName("login")
    private String username;

    @SerializedName("avatar_url")
    private String ivprofil;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIvprofil() {
        return ivprofil;
    }

    public void setIvprofil(String ivprofil) {
        this.ivprofil = ivprofil;
    }

    public Pojogithub(long id, String location, String username, String ivprofil) {
        this.id = id;
        this.location = location;
        this.username = username;
        this.ivprofil = ivprofil;
    }

    public Pojogithub() {
    }
//    private int ivprofill;
//
//    @SerializedName("url")
//    private String url;
//
//    @SerializedName("html_url")
//    private String htmlUrl;
//
//    @SerializedName("followers_url")
//    private String follower;
//
//    @SerializedName("following_url")
//    private String following;
//
//    @SerializedName("gists_url")
//    private String gistsUrl;
//
//    @SerializedName("starred_url")
//    private String starredUrl;
//
//    @SerializedName("subscriptions_url")
//    private String subscriptionsUrl;
//
//    @SerializedName("organizations_url")
//    private String company;
//
//    @SerializedName("repos_url")
//    private String repository;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.location);
        dest.writeString(this.username);
        dest.writeString(this.ivprofil);
    }

    protected Pojogithub(Parcel in) {
        this.id = in.readLong();
        this.location = in.readString();
        this.username = in.readString();
        this.ivprofil = in.readString();
    }

    public static final Parcelable.Creator<Pojogithub> CREATOR = new Parcelable.Creator<Pojogithub>() {
        @Override
        public Pojogithub createFromParcel(Parcel source) {
            return new Pojogithub(source);
        }

        @Override
        public Pojogithub[] newArray(int size) {
            return new Pojogithub[size];
        }
    };
}
