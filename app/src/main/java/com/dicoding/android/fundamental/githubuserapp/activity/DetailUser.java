package com.dicoding.android.fundamental.githubuserapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.dicoding.android.fundamental.githubuserapp.R;
import com.dicoding.android.fundamental.githubuserapp.adapter.FragmentPagerAdapterDetailProfil;
import com.dicoding.android.fundamental.githubuserapp.pojo.Pojogithub;
import com.google.android.material.tabs.TabLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailUser extends AppCompatActivity {

    private CircleImageView ivgambar;
    private TextView tvusername,tvname,tvcompany,tvlocation,tvrepository,tvfollower,tvfollowing;

    private int gambar;
    private String username,name,company,location,repository,follower,following;
    public static final String DATA_EXTRA = "extradata";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        tvusername = findViewById(R.id.username_detail_tv);
        tvname = findViewById(R.id.name_detail_tv);
        tvcompany = findViewById(R.id.company_detail_tv);
        tvlocation = findViewById(R.id.location_detail_tv);
        tvrepository = findViewById(R.id.repository_detail_tv);

//        tvfollower = findViewById(R.id.fo);
//        tvfollowing = findViewById(R.id.Following);
//        ivgambar = findViewById(R.id.ivImagedetail);
        Intent intent = getIntent();
        Pojogithub pojogithub = intent.getParcelableExtra(DATA_EXTRA);
//        gambar = pojogithub.getIvprofil();
//        ivgambar.setImageResource(gambar);
//
//        username = pojogithub.getUsername();
//        tvusername.setText(username);
//
//        name = pojogithub.getUsername();
//        tvname.setText(name);

//        company = pojogithub.getCompany();
//        tvcompany.setText(company);
//
//        location = pojogithub.getLocation();
//        tvlocation.setText(location);
//
//        repository = pojogithub.getRepository();
//        tvrepository.setText(repository);
//
//        follower = pojogithub.getFollower();
//        tvfollower.setText(follower);
//
//        following = pojogithub.getFollowing();
//        tvfollowing.setText(following);



        FragmentPagerAdapterDetailProfil fragmentPagerAdapterDetailProfil = new FragmentPagerAdapterDetailProfil(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.vpdetailprofil);
        viewPager.setAdapter(fragmentPagerAdapterDetailProfil);
        TabLayout tabs = findViewById(R.id.tldetailprofil);
        tabs.setupWithViewPager(viewPager);

        getSupportActionBar().setElevation(0);


    }
}
