package com.schandorf.elmenorah.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.schandorf.elmenorah.Adapters.VideoAdapter;
import com.schandorf.elmenorah.Helpers.Constants;
import com.schandorf.elmenorah.Helpers.DbHelper;
import com.schandorf.elmenorah.Helpers.FontChangeCrawler;
import com.schandorf.elmenorah.POJO.VideosList;
import com.schandorf.elmenorah.R;
import com.schandorf.elmenorah.RetrofitService;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentFragment extends Fragment {


    SwipeRefreshLayout swipeRefreshLayout;
   RecyclerView videoRecyclerView;
    TextView refresh;
    Realm videoRealm;
    DbHelper dbHelper;
    RealmResults<VideosList> videoList;
    FontChangeCrawler fontChangeCrawler;
    //List<VideosList> videosLists = new ArrayList<>();


    public EntertainmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         dbHelper = new DbHelper("realm.video",getActivity());

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_entertainment, container, false);
         fontChangeCrawler = new FontChangeCrawler(getActivity().getAssets(), Constants.FONT_NAME);
    videoRecyclerView = view.findViewById(R.id.vieoRecyclerView);
        refresh = view.findViewById(R.id.reloadtext);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadOnlineVideos();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        videoRecyclerView.setLayoutManager(linearLayoutManager);
        videoRecyclerView.setHasFixedSize(true);
        //load from realm
        videoRealm = dbHelper.startRealm();
        videoList =  videoRealm.where(VideosList.class).findAll();
       // Toast.makeText(getActivity(), String.valueOf(videoList.size()), Toast.LENGTH_SHORT).show();
        if(videoList.size() > 0)
        {
            VideoAdapter homeRecyclerAdapter = new VideoAdapter(getActivity(),videoList,fontChangeCrawler);
            videoRecyclerView.setAdapter(homeRecyclerAdapter);
        }
        else {
            loadOnlineVideos();
        }

        swipeRefreshLayout = view.findViewById(R.id.videoSwipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                loadOnlineVideos();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(videoRealm != null) {
            dbHelper.closeRealm(videoRealm);
        }
       // ButterKnife.reset(this);
    }

    private AlertDialog myProgressBar()
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setView(R.layout.progress_bar);
        dialogBuilder.setCancelable(false);
        return dialogBuilder.create();

    }

  private void loadOnlineVideos()
  {
     // final AlertDialog mydialog = myProgressBar();
     // mydialog.show();
//      swipeRefreshLayout.setRefreshing(true);
      RetrofitInterface retrofitInterface = RetrofitService.getClient().create(RetrofitInterface.class);
      Call<List<VideosList>> calllistvideos = retrofitInterface.getVideos();
      calllistvideos.enqueue(new Callback<List<VideosList>>() {
          @Override
          public void onResponse(Call<List<VideosList>> call, final Response<List<VideosList>> response) {
             // mydialog.dismiss();
              if(swipeRefreshLayout.isRefreshing())
              {
                  swipeRefreshLayout.setRefreshing(false);
              }
              if(response.isSuccessful())
              {
                  //videoRealm = Realm.getInstance(videoconfig);
                  //videosLists = response.body();
                  videoRealm.executeTransaction(new Realm.Transaction() {
                      @Override
                      public void execute(Realm realm) {
                          videoRealm.where(VideosList.class).findAll().deleteAllFromRealm();
                          videoRealm.copyToRealmOrUpdate((Iterable) response.body());
                          RealmResults<VideosList> vids = videoRealm.where(VideosList.class).findAll();
                          if(vids.size() >0)
                          {
                          VideoAdapter homeRecyclerAdapter = new VideoAdapter(getActivity(),vids,fontChangeCrawler);
                          videoRecyclerView.setAdapter(homeRecyclerAdapter);}
                          else
                          {
                              videoRecyclerView.setVisibility(View.GONE);
                              refresh.setVisibility(View.VISIBLE);
                              refresh.setText("Nothing found. Please Tap or Swipe Down To Reload Items");
                          }
                      }
                  });
                  //Toast.makeText(getActivity(), videosLists.toString(), Toast.LENGTH_SHORT).show();
              }
              else
              {
                  //Toast.makeText(getActivity(), "Malformed Response", Toast.LENGTH_SHORT).show();
              }
          }

          @Override
          public void onFailure(Call<List<VideosList>> call, Throwable t) {
             // mydialog.dismiss();
              if(swipeRefreshLayout.isRefreshing())
              {
                  swipeRefreshLayout.setRefreshing(false);
              }
            //  Toast.makeText(getActivity(), "Check Internet Connection", Toast.LENGTH_SHORT).show();
              if(videoList.size()==0)
              {
                  videoRecyclerView.setVisibility(View.GONE);
                  refresh.setVisibility(View.VISIBLE);
                  refresh.setText("Please Check Your Internet and Tap or Swipe Down To Reload Items");
              }
          }
      });
  }
}
