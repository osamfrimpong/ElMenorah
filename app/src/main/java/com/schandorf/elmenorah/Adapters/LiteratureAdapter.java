package com.schandorf.elmenorah.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.schandorf.elmenorah.DetailsActivity;
import com.schandorf.elmenorah.Helpers.Constants;
import com.schandorf.elmenorah.Helpers.FontChangeCrawler;
import com.schandorf.elmenorah.POJO.LiteraturePOJO;
import com.schandorf.elmenorah.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Schandorf on 5/19/2018.
 */

public class LiteratureAdapter extends RecyclerView.Adapter<LiteratureAdapter.MyViewHolder> {

    private Context ctx;
    private List<LiteraturePOJO> literatureList;
    private FontChangeCrawler fontChangeCrawler;

    public LiteratureAdapter(Context ctx, List<LiteraturePOJO> literatureList, FontChangeCrawler fontChangeCrawler) {
        this.ctx = ctx;
        this.literatureList = literatureList;
        this.fontChangeCrawler = fontChangeCrawler;
    }

    @Override
    public LiteratureAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType ==1)
        {
         view = LayoutInflater.from(parent.getContext()).inflate(R.layout.literature_layout_two,parent,false);}
        else if(viewType == 2)
        { view = LayoutInflater.from(parent.getContext()).inflate(R.layout.literature_layout_one,parent,false);}
        else if(viewType == 3)
        { view = LayoutInflater.from(parent.getContext()).inflate(R.layout.literature_layout_three,parent,false);}
        else
        {view = LayoutInflater.from(parent.getContext()).inflate(R.layout.literature_layout_two,parent,false);}
        fontChangeCrawler.replaceFonts((ViewGroup) view);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LiteratureAdapter.MyViewHolder holder, int position) {
        final LiteraturePOJO litt = literatureList.get(position);
        holder.title.setText(litt.getTitle());
        holder.date.setText(litt.getDateAdded());
        String content = litt.getContent();
        Spanned results;
        if(litt.getContent().length() > 170)
        {
         content = litt.getContent().substring(0,170);}
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
             results = Html.fromHtml(content,Html.FROM_HTML_MODE_LEGACY);
        }
        else
        {
            results = Html.fromHtml(content);
        }
        holder.content.setText(results);
        Picasso.with(ctx).load(Constants.BASE_URL+"cms/images/"+litt.getImage()).error(Constants.ARTICLES_IMAGE).noPlaceholder().into(holder.imageHold);
        holder.detailsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openDetailActivity(litt.getTitle(),litt.getId(),litt.getContent(),litt.getImage());
            }
        });
    }

    @Override
    public int getItemCount() {
        return literatureList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;
        TextView content;
        ImageView imageHold;
        LinearLayout detailsLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titletext);
            date= itemView.findViewById(R.id.datetext);
            content = itemView.findViewById(R.id.contenttext);
            imageHold = itemView.findViewById(R.id.imageholder);
            detailsLayout = itemView.findViewById(R.id.detailsLayout);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2 == 0)
        {
            return 2;
        }
        else if(position%2 == 1)
        {
            return 3;
        }
        else
        {
            return 1;
        }
    }

    private void openDetailActivity(String...details)
    {
        Intent i=new Intent(ctx, DetailsActivity.class);
        i.putExtra("TITLE_KEY",details[0]);
        i.putExtra("ID_KEY",details[1]);
       // i.putExtra("DATE_KEY",details[1]);
        i.putExtra("CONTENT_KEY",details[2]);
        i.putExtra("FEATURED_IMAGE_KEY",details[3]);

        ctx.startActivity(i);

    }
}
