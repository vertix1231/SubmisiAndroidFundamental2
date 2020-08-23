package com.dicoding.android.fundamental.githubuserapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import com.dicoding.android.fundamental.githubuserapp.Database.LocalData;
import com.dicoding.android.fundamental.githubuserapp.R;
import com.dicoding.android.fundamental.githubuserapp.adapter.AdapterGithubapp;
import com.dicoding.android.fundamental.githubuserapp.nethelper.ServiceGenerator;
import com.dicoding.android.fundamental.githubuserapp.pojo.Pojogithub;
import com.dicoding.android.fundamental.githubuserapp.service.GithubService;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvProfilgithub;
    private ArrayList<Pojogithub> dataModelUser = new ArrayList<>();
    private  TextView username;
    private CircleImageView profillist;
    ProgressDialog progressDoalog;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvProfilgithub =findViewById(R.id.rvprofilgithub);
        username = findViewById(R.id.tvusernamelist);
        profillist = findViewById(R.id.ivImage);

        rvProfilgithub.setHasFixedSize(true);
//        dataModelUser.addAll(LocalData.getListData());
        showRecyclerList();

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();


        /*Create handle for the RetrofitInstance interface*/
        GithubService service = ServiceGenerator.getRetrofitInstance().create(GithubService.class);
        Call<List<Pojogithub>> calls = service.getUsers(10,1);
//        Call<Pojogithub> call = service.getUser();
        calls.enqueue(new Callback<List<Pojogithub>>() {
            @Override
            public void onResponse(Call<List<Pojogithub>> call, Response<List<Pojogithub>> response) {
                progressDoalog.dismiss();
                List<Pojogithub> results = response.body();
                AdapterGithubapp adapterGithubapp = new AdapterGithubapp(getApplicationContext(), (ArrayList<Pojogithub>) results);
                rvProfilgithub.setAdapter(adapterGithubapp);
//                showRecyclerListApi(response.body());

            }

            @Override
            public void onFailure(Call<List<Pojogithub>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Gagal Memuat", Toast.LENGTH_SHORT).show();


            }
        });




    }

    private void getDataOnline(final String username) {
        Call<Pojogithub> requests = (Call<Pojogithub>) ServiceGenerator.getRetrofitInstance().create(GithubService.class);
        requests.enqueue(new Callback<Pojogithub>() {
            @Override
            public void onResponse(Call<Pojogithub> call, Response<Pojogithub> response) {
                if (response.isSuccessful()) {
                    //Mengambil data dari internet masuk ke Data Github
                    assert response.body() != null;
                    dataModelUser = (ArrayList<Pojogithub>) response.body().getItems();
                    //Set Adapter ke Recycler View
                    AdapterGithubapp adapterGithubapp = new AdapterGithubapp(getApplicationContext(), dataModelUser);
                    rvProfilgithub.setAdapter(adapterGithubapp);
//                    userrv.setAdapter(new UsersAdapter(MainActivity.this, gitdata));
                    showProgress(false);

                } else {
                    Toast.makeText(MainActivity.this, "Request Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Pojogithub> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Request Failure" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }





    private void showRecyclerList(){
        rvProfilgithub.setLayoutManager(new LinearLayoutManager(this));
        AdapterGithubapp listgithubAdapter = new AdapterGithubapp(this, dataModelUser);   //LIAT LAGI SAMA LIAT LAGI DI CONTRUCTOR BLANK DI ADAPTER
        rvProfilgithub.setAdapter(listgithubAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    private void showProgress(Boolean state) {
        if (state) {
            progress.setVisibility(View.VISIBLE);
        } else {
            progress.setVisibility(View.GONE);
        }
    }



}
