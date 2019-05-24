package com.schandorf.elmenorah.Fragments;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.schandorf.elmenorah.Activities.AboutActivity;
import com.schandorf.elmenorah.Adapters.DividerItemDecoration;
import com.schandorf.elmenorah.Adapters.HomeRecyclerAdapter;
import com.schandorf.elmenorah.Helpers.Constants;
import com.schandorf.elmenorah.HomeItemPOJO;
import com.schandorf.elmenorah.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    RecyclerView homeRecyclerView;
    List<HomeItemPOJO> homelist = new ArrayList<>();
    TextView aboutText;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        homelist.add(addHomeItem("Sermons","Sermons for your Walk", Constants.SERMON_IMAGE,"sermon"));
        homelist.add(addHomeItem("Creative Arts","Entertainment for you",Constants.CREATIVE_ARTS_IMAGE,"creative_arts"));
        homelist.add(addHomeItem("Personality","Personality  of the week",Constants.PERSONALITY_IMAGE,"personality"));
        homelist.add(addHomeItem("Sex In your closet","Sex in your closet",Constants.SEX_IN_YOUR_CLOSET_IMAGE,"sex_in_your_closet"));

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Drawable dividerDrawable = ContextCompat.getDrawable(getActivity(),R.drawable.recyclerview_divider);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(dividerDrawable);
        homeRecyclerView = view.findViewById(R.id.homeRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        HomeRecyclerAdapter homeRecyclerAdapter = new HomeRecyclerAdapter(getActivity(),homelist);
        homeRecyclerView.setLayoutManager(linearLayoutManager);
        homeRecyclerView.setAdapter(homeRecyclerAdapter);
       homeRecyclerView.addItemDecoration(dividerItemDecoration);
        aboutText = view.findViewById(R.id.aboutText);
        aboutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getActivity(), "About Text Clicked!", Toast.LENGTH_SHORT).show();
                Intent aboutIntent = new Intent(getActivity(), AboutActivity.class);
                getActivity().startActivity(aboutIntent);
            }
        });
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
