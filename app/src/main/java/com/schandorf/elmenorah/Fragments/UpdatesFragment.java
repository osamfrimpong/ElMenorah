package com.schandorf.elmenorah.Fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.schandorf.elmenorah.Adapters.DividerItemDecoration;
import com.schandorf.elmenorah.Adapters.HomeRecyclerAdapter;
import com.schandorf.elmenorah.Helpers.Constants;
import com.schandorf.elmenorah.HomeItemPOJO;
import com.schandorf.elmenorah.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdatesFragment extends Fragment {
    RecyclerView homeRecyclerView;
    List<HomeItemPOJO> homelist = new ArrayList<>();


    public UpdatesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        homelist.add(addHomeItem("News","Get the Latest New", Constants.NEWS_IMAGE,"news"));
        homelist.add(addHomeItem("Updates","Updates For Upcoming Programmes",Constants.UPDATES_IMAGE,"updates"));


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_updates, container, false);
        Drawable dividerDrawable = ContextCompat.getDrawable(getActivity(),R.drawable.recyclerview_divider);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(dividerDrawable);
        homeRecyclerView = view.findViewById(R.id.homeRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        HomeRecyclerAdapter homeRecyclerAdapter = new HomeRecyclerAdapter(getActivity(),homelist);
        homeRecyclerView.setLayoutManager(linearLayoutManager);
        homeRecyclerView.setAdapter(homeRecyclerAdapter);
       homeRecyclerView.addItemDecoration(dividerItemDecoration);


        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        homelist.clear();
    }

    public HomeItemPOJO addHomeItem(String mainTitle,String subTitle,int image, String category)
    {
        HomeItemPOJO homeItemPOJO = new HomeItemPOJO();
        homeItemPOJO.setMaintitle(mainTitle);
        homeItemPOJO.setSubtitle(subTitle);
        homeItemPOJO.setImageurl(image);
        homeItemPOJO.setCategory(category);
        return homeItemPOJO;
    }
}
