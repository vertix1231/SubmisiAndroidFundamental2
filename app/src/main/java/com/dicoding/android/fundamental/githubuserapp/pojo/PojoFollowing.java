package com.dicoding.android.fundamental.githubuserapp.pojo;

import com.google.gson.annotations.SerializedName;

public class PojoFollowing {

    @SerializedName("login")
    private String login;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("id")
    private int id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PojoFollowing(String login, String avatarUrl, int id) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.id = id;
    }

    public PojoFollowing() {
    }
}
