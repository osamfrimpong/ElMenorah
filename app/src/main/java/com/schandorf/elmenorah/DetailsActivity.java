package com.schandorf.elmenorah;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.schandorf.elmenorah.Helpers.Constants;
import com.schandorf.elmenorah.Helpers.FontChangeCrawler;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    TextView contents;
    ImageView postfeaturedimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FontChangeCrawler fontChangeCrawler = new FontChangeCrawler(getAssets(),"Candara.ttf");
        fontChangeCrawler.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));
        contents =  findViewById(R.id.contents);
        postfeaturedimage =  findViewById(R.id.post_featured_image);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Spanned result;
        Intent i = this.getIntent();
        //GET DATA
        String title=i.getExtras().getString("TITLE_KEY");
        String content=i.getExtras().getString("CONTENT_KEY");
        String featured_image=i.getExtras().getString("FEATURED_IMAGE_KEY");

        Picasso.with(this).load(Constants.BASE_URL+"cms/images/"+featured_image).error(Constants.ARTICLES_IMAGE).noPlaceholder().into(postfeaturedimage);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
           result = Html.fromHtml(content,Html.FROM_HTML_MODE_LEGACY);
        }
        else{
         result = Html.fromHtml(content);}

        contents.setText(result);
        this.setTitle(title);

    }
}
