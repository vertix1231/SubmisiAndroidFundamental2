package com.dicoding.android.fundamental.githubuserapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.dicoding.android.fundamental.githubuserapp.R;
import com.dicoding.android.fundamental.githubuserapp.adapter.FragmentPagerAdapterDetailProfil;
import com.dicoding.android.fundamental.githubuserapp.nethelper.ServiceGenerator;
import com.dicoding.android.fundamental.githubuserapp.pojo.Pojogithub;
import com.dicoding.android.fundamental.githubuserapp.service.GithubService;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailUser extends AppCompatActivity {

    private CircleImageView ivgambar;
    private TextView tvusername,tvname,tvcompany,tvlocation,tvrepository,tvfollower,tvfollowing;

    public static final String DATA_USER = "userdata";
    public static final String DATA_EXTRA = "extradata";
    private int gambar;
    private String username,name,company,location,repository,follower,following;
    Context context;
    Pojogithub pojogithub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        Bundle bundle = getIntent().getBundleExtra(DATA_EXTRA);
        assert bundle != null;
        pojogithub = bundle.getParcelable(DATA_USER);

        ivgambar = findViewById(R.id.ivImagedetail);
        tvname = findViewById(R.id.name_detail_tv);
        tvusername = findViewById(R.id.username_detail_tv);
        tvlocation = findViewById(R.id.location_detail_tv);
        tvcompany = findViewById(R.id.company_detail_tv);
        tvrepository = findViewById(R.id.repository_detail_tv);


        final ProgressDialog progressbar = new ProgressDialog(DetailUser.this);
        progressbar.setMessage(getString(R.string.progress));
        progressbar.show();


        Picasso.get().load(pojogithub.getIvprofil()).into(ivgambar);

        GithubService service = ServiceGenerator.getRetrofitInstance().create(GithubService.class);
        Call<Pojogithub> calls = service.getDetailUser(pojogithub.getUsername());
        calls.enqueue(new Callback<Pojogithub>() {
            @Override
            public void onResponse(Call<Pojogithub> call, Response<Pojogithub> response) {
                pojogithub = response.body();

                assert pojogithub != null;
                name = pojogithub.getUsername();
                tvname.setText(name);

                username = pojogithub.getName();
                tvusername.setText(username);

                location = pojogithub.getLocation();
                tvlocation.setText(location);

                company = pojogithub.getCompany();
                tvcompany.setText(company);

                repository = pojogithub.getRepository();
                tvrepository.setText(repository);

                progressbar.dismiss();

//                setFragment();


            }

            @Override
            public void onFailure(Call<Pojogithub> call, Throwable t) {

            }
        });

        FragmentPagerAdapterDetailProfil fragmentPagerAdapterDetailProfil = new FragmentPagerAdapterDetailProfil(this, getSupportFragmentManager(), pojogithub.getUsername());
        ViewPager viewPager = findViewById(R.id.vpdetailprofil);
        viewPager.setAdapter(fragmentPagerAdapterDetailProfil);
        TabLayout tabs = findViewById(R.id.tldetailprofil);
        tabs.setupWithViewPager(viewPager);

        getSupportActionBar().setElevation(0);


    }
}
