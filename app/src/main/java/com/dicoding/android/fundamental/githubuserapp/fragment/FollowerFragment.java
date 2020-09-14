package com.dicoding.android.fundamental.githubuserapp.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dicoding.android.fundamental.githubuserapp.R;
import com.dicoding.android.fundamental.githubuserapp.activity.DetailUser;
import com.dicoding.android.fundamental.githubuserapp.adapter.FollowersAdapter;
import com.dicoding.android.fundamental.githubuserapp.nethelper.ServiceGenerator;
import com.dicoding.android.fundamental.githubuserapp.pojo.PojoFollowers;
import com.dicoding.android.fundamental.githubuserapp.pojo.Pojogithub;
import com.dicoding.android.fundamental.githubuserapp.service.GithubService;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowerFragment extends Fragment {
    private RecyclerView rvProfilgithub_follower;
    private ArrayList<PojoFollowers> dataModelUser = new ArrayList<>();
    private TextView username;
    private CircleImageView profillist;
    ProgressDialog progressDoalog;
    private ProgressBar progress;
    Context context;
    PojoFollowers pojoFollowers;
    Pojogithub pojogithub;
    DetailUser detailUser;
    public static final String DATA_USER = "userdata";
    public static final String DATA_EXTRA = "extradata";

//    public static FollowerFragment newInstance(int index) {
//        FollowerFragment followerFragment = FollowerFragment.newInstance(login);
//        DetailUser detailUser = (DetailUser) getActivity();
//        assert detailUser != null;
//        Bundle getbundle = detailUser.getIntent().getBundleExtra(DATA_EXTRA);
//        assert getbundle != null;
//        pojogithub =getbundle.getParcelable(DATA_USER);
//
//        return followerFragment;
//    }

    public FollowerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_follower, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        DetailUser detailUser = (DetailUser) getActivity();
//        assert detailUser != null;
//        Bundle getbundle = detailUser.getIntent().getBundleExtra(DATA_EXTRA);
//        assert getbundle != null;
//        pojogithub =getbundle.getParcelable(DATA_USER);

        rvProfilgithub_follower = view.findViewById(R.id.follower_rv);
        rvProfilgithub_follower.setLayoutManager(new LinearLayoutManager(view.getContext()));



//

//
//        GithubService service = ServiceGenerator.getRetrofitInstance().create(GithubService.class);
//        Call<List<PojoFollowers>> calls = service.getFollowerUser(pojoFollowers.getLogin());
//        calls.enqueue(new Callback<List<PojoFollowers>>() {
//            @Override
//            public void onResponse(Call<List<PojoFollowers>> call, Response<List<PojoFollowers>> response) {
//
//                if (response.isSuccessful()){
//                    if (response.body() != null){
//                        ArrayList<PojoFollowers> followerslist = new ArrayList<>(response.body());
//                        Log.d("Result", "Response: " +followerslist.size());
//                        rvProfilgithub_follower.setAdapter(new FollowersAdapter(context, followerslist));
//                    }
//                } else {
//                    Toast.makeText(getContext(), "Request Failed", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<PojoFollowers>> call, Throwable t) {
//                Toast.makeText(getContext(), "Request Failure"+t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
}
