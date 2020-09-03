package com.dicoding.android.fundamental.githubuserapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.dicoding.android.fundamental.githubuserapp.R;
import com.dicoding.android.fundamental.githubuserapp.pojo.Pojogithub;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.FollowersViewHolder> {
    Context context;
    ArrayList<Pojogithub> dataModelUser;

    public FollowersAdapter(Context context, ArrayList<Pojogithub> dataModelUser) {
        this.context = context;
        this.dataModelUser = dataModelUser;
    }

    @NonNull
    @Override
    public FollowersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FollowersViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataModelUser.size();
    }

    public class FollowersViewHolder extends RecyclerView.ViewHolder{
        CircleImageView ivprofil;
        TextView usernamelist;
        ConstraintLayout constraintLayout;
        public FollowersViewHolder(@NonNull View itemView) {
            super(itemView);

            ivprofil = itemView.findViewById(R.id.ivImage_follower);
            usernamelist = itemView.findViewById(R.id.tvusernamelist_follower);
            constraintLayout = itemView.findViewById(R.id.cllistprofilegithub_follower);
        }
    }
}
