package com.schandorf.elmenorah.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.schandorf.elmenorah.Activities.CategoryActivity;
import com.schandorf.elmenorah.Activities.PersonalityActivity;
import com.schandorf.elmenorah.Activities.PrayerRequest;
import com.schandorf.elmenorah.Activities.RegistrationActivity;
import com.schandorf.elmenorah.HomeItemPOJO;
import com.schandorf.elmenorah.R;

import java.util.List;

/**
 * Created by Schandorf on 4/21/2018.
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.MyViewHolder> {

private Context context;
    private List<HomeItemPOJO> homeItemPOJOList;

    public HomeRecyclerAdapter(Context context, List<HomeItemPOJO> homeItemPOJOList) {
        this.context = context;
        this.homeItemPOJOList = homeItemPOJOList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
final HomeItemPOJO hip = homeItemPOJOList.get(position);
        holder.maintitle.setText(hip.getMaintitle());
        holder.subtitle.setText(hip.getSubtitle());
        holder.roundedImageView.setImageResource(hip.getImageurl());
        holder.homeListWrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hip.getCategory() == "updates")
                {
                    Intent intent = new Intent(context, RegistrationActivity.class);
                    context.startActivity(intent);
                }
                else if(hip.getCategory() == "prayer_request")
                {
                    Intent intent = new Intent(context, PrayerRequest.class);
                    context.startActivity(intent);
                }
//                else if(hip.getCategory() == "personality")
//                {
//                    Intent intent = new Intent(context, PersonalityActivity.class);
//                    context.startActivity(intent);
//                }
                else {
                    Intent intent = new Intent(context, CategoryActivity.class);
                    intent.putExtra("title", hip.getMaintitle());
                    intent.putExtra("category", hip.getCategory());
                    intent.putExtra("image", hip.getImageurl());
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeItemPOJOList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView roundedImageView;
        TextView maintitle;
        TextView subtitle;
        LinearLayout homeListWrapper;
        public MyViewHolder(View itemView) {
            super(itemView);
            roundedImageView = itemView.findViewById(R.id.homeItemImage);
            maintitle = itemView.findViewById(R.id.maintitle);
            subtitle = itemView.findViewById(R.id.subtitle);
            homeListWrapper = itemView.findViewById(R.id.homeListWrapper);

        }
    }
}
