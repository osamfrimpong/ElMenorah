package com.schandorf.elmenorah.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.schandorf.elmenorah.Helpers.FontChangeCrawler;
import com.schandorf.elmenorah.POJO.VideosList;
import com.schandorf.elmenorah.R;
import com.schandorf.elmenorah.VideoPlayer;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Schandorf on 4/22/2018.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {

    private Context context;
    private List<VideosList> videos;
    private FontChangeCrawler fontChangeCrawler;

    public VideoAdapter(Context context, List<VideosList> videos, FontChangeCrawler fontChangeCrawler) {
        this.context = context;
        this.videos = videos;
        this.fontChangeCrawler = fontChangeCrawler;
    }

    @Override
    public VideoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_video_item,parent,false);
        fontChangeCrawler.replaceFonts((ViewGroup) v);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(VideoAdapter.MyViewHolder holder, int position) {
 final   VideosList video = videos.get(position);
      //  holder.videodescription.setText(video.getDescription());
        String videoCategory = video.getVideoCategory();
        holder.videotitle.setText(video.getTitle());

        Picasso.with(context).load("http://img.youtube.com/vi/"+video.getVideoId()+"/0.jpg").error(R.drawable.menorah).placeholder(R.drawable.menorah).into(holder.thumbNail);
        holder.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, VideoPlayer.class);
                i.putExtra("videoId",video.getVideoId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView playButton;
        ImageView thumbNail;
        TextView videotitle;
       // TextView videodescription;
        public MyViewHolder(View itemView) {
            super(itemView);
            playButton = itemView.findViewById(R.id.playbutton);
            thumbNail = itemView.findViewById(R.id.thumbnail);
            videotitle = itemView.findViewById(R.id.videotitle);
           // videodescription = itemView.findViewById(R.id.videodescription);
        }
    }
}
