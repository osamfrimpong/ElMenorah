package com.schandorf.elmenorah.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.schandorf.elmenorah.Adapters.DividerItemDecoration;
import com.schandorf.elmenorah.Adapters.HomeRecyclerAdapter;
import com.schandorf.elmenorah.Adapters.LiteratureAdapter;
import com.schandorf.elmenorah.Adapters.VideoAdapter;
import com.schandorf.elmenorah.Fragments.RetrofitInterface;
import com.schandorf.elmenorah.Helpers.Constants;
import com.schandorf.elmenorah.Helpers.DbHelper;
import com.schandorf.elmenorah.Helpers.FontChangeCrawler;
import com.schandorf.elmenorah.HomeItemPOJO;
import com.schandorf.elmenorah.POJO.LiteraturePOJO;
import com.schandorf.elmenorah.POJO.VideosList;
import com.schandorf.elmenorah.R;
import com.schandorf.elmenorah.RetrofitService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {
    Realm realm;
    RecyclerView categoryRecyclerView;
    List<HomeItemPOJO> homelist = new ArrayList<>();
    HomeRecyclerAdapter homeRecyclerAdapter;
    LiteratureAdapter literatureAdapter;
    VideoAdapter videoAdapter;
    ImageView topImage;
    RealmResults<LiteraturePOJO> literatureResults;
    RealmResults<VideosList> videoResults;
    DbHelper dbHelper;
    WebView webView;
    TextView categoryRefresh;
    SwipeRefreshLayout categorySwipe;
    TextView webViewload;
    FontChangeCrawler fontChangeCrawler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.hometoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fontChangeCrawler = new FontChangeCrawler(getAssets(),Constants.FONT_NAME);
        topImage = findViewById(R.id.topImage);
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        categoryRefresh = findViewById(R.id.catergoryRefresh);
        categorySwipe = findViewById(R.id.categorySwipe);
        webViewload = findViewById(R.id.webViewLoad);
        Intent intent = getIntent();
        this.setTitle(intent.getStringExtra("title"));
        String category = intent.getStringExtra("category");
        int image = intent.getIntExtra("image",R.drawable.elmenorah_home_ext);
        topImage.setImageResource(image);
        inflateRcylerview(category);

    }

    private void inflateRcylerview(final String category) {

        Drawable dividerDrawable = ContextCompat.getDrawable(this,R.drawable.recyclerview_divider);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(dividerDrawable);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        categoryRecyclerView.setLayoutManager(linearLayoutManager);
        categoryRecyclerView.addItemDecoration(dividerItemDecoration);
        //get category to inflate recyclerview
        switch (category)
        {
            case "creative_arts":
               // topImage.setImageResource(Constants.CREATIVE_ARTS_IMAGE);
                homelist.add(addHomeItem("Drama","Sermons for your Walk",Constants.DRAMA_IMAGE,"drama"));
                homelist.add(addHomeItem("Dance","Dance videos for your Walk",Constants.DANCE_IMAGE,"dance"));
                homelist.add(addHomeItem("Music","Music for your Walk",Constants.MUSIC_IMAGE,"music"));
                homelist.add(addHomeItem("Spoken Word","Spoken Word for your Walk",Constants.SPOKEN_WORD_IMAGE,"spoken_word"));
                homelist.add(addHomeItem("Poetry","Poetry for your Walk",Constants.POETRY_IMAGE,"poetry"));
                homeRecyclerAdapter = new HomeRecyclerAdapter(this,homelist);
                categoryRecyclerView.setAdapter(homeRecyclerAdapter);
                break;
            case "sex_in_your_closet":
               // topImage.setImageResource(Constants.SEX_IN_YOUR_CLOSET_IMAGE);
                homelist.add(addHomeItem("ElMenorah Series(Text)","Read Our ElMenorah Series",Constants.EL_MENORAH_SERIES_TEXT,"elmenorah_series"));
                homelist.add(addHomeItem("ElMenorah Series(Video)","Watch Our ElMenorah Series",Constants.EL_MENORAH_SERIES_VIDEO_IMAGE,"elmenorah_series_video"));
                homelist.add(addHomeItem("Prayer Request","Prayer Request",Constants.PRAYER_REQUEST_IMAGE,"prayer_request"));
                homeRecyclerAdapter = new HomeRecyclerAdapter(this,homelist);
                categoryRecyclerView.setAdapter(homeRecyclerAdapter);
                break;
//            case "personality":
//                //webview
//               categoryRecyclerView.setVisibility(View.GONE);
//                webView.loadUrl(Constants.BASE_URL+Constants.PERSONALITY_LINK);
//                webView.setWebViewClient(new MyWebViewClient());
//                break;

            default:
                categoryRecyclerView.setBackgroundColor(Color.WHITE);
                //check in array if video or literature
                if(Arrays.asList(Constants.LITERATURE_CATEGORIES).contains(category))
                {
                    //literature db and adapter
                    dbHelper = new DbHelper("literature",this);
                    realm = dbHelper.startRealm();
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(final Realm realm) {
                            literatureResults = realm.where(LiteraturePOJO.class).contains("category",category).findAll();
                            if(literatureResults.size() > 0)
                            {
                                literatureAdapter = new LiteratureAdapter(CategoryActivity.this,literatureResults,fontChangeCrawler);
                                categoryRecyclerView.setAdapter(literatureAdapter);
                                categorySwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                                    @Override
                                    public void onRefresh() {
                                        categorySwipe.setRefreshing(true);
                                        loadFromOnline(category,realm);
                                    }
                                });
                            }
                            else
                            {
                                loadFromOnline(category,realm);
                            }
                        }
                    });
                }
                else if (Arrays.asList(Constants.VIDEO_CATEGORIES).contains(category))
                {
                    //video adapter and db
                    dbHelper = new DbHelper("realm.video",this);
                    realm = dbHelper.startRealm();
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(final Realm realm) {
                            videoResults = realm.where(VideosList.class).contains("videoCategory",category).findAll();
                            if(videoResults.size() > 0)
                            {
                                videoAdapter = new VideoAdapter(CategoryActivity.this,videoResults,fontChangeCrawler);
                                categoryRecyclerView.setAdapter(videoAdapter);
                                categorySwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                                    @Override
                                    public void onRefresh() {
                                        loadVideoFromOnline(category,realm);
                                    }
                                });
                            }
                            else
                            {
                                loadVideoFromOnline(category,realm);
                            }
                        }
                    });
                }
                break;
        }





    }

    private void loadFromOnline(final String category, final Realm realm) {
        RetrofitInterface retrofitInterface = RetrofitService.getClient().create(RetrofitInterface.class);
        Call<List<LiteraturePOJO>> call = retrofitInterface.getLiterature();
        call.enqueue(new Callback<List<LiteraturePOJO>>() {
            @Override
            public void onResponse(Call<List<LiteraturePOJO>> call, final Response<List<LiteraturePOJO>> response) {
                if(categorySwipe.isRefreshing())
                {
                    categorySwipe.setRefreshing(false);
                }
                if(response.isSuccessful())
                {
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.where(LiteraturePOJO.class).findAll().deleteAllFromRealm();
                            realm.copyToRealmOrUpdate((Iterable) response.body());
                            literatureResults = realm.where(LiteraturePOJO.class).contains("category",category).findAll();
                            if(literatureResults.size() > 0)
                            {
                            literatureAdapter = new LiteratureAdapter(CategoryActivity.this,literatureResults,fontChangeCrawler);
                            categoryRecyclerView.setAdapter(literatureAdapter);}
                            else
                            {
                                categoryRecyclerView.setVisibility(View.GONE);
                                categoryRefresh.setVisibility(View.VISIBLE);
                                categoryRefresh.setText("Nothing found.");
                            }

                        }
                    });
                }
                else
                {
                   // Toast.makeText(CategoryActivity.this, "Malformed Response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<LiteraturePOJO>> call, @NonNull Throwable t) {
                if(categorySwipe.isRefreshing())
                {
                    categorySwipe.setRefreshing(false);
                }
                if(literatureResults.size() == 0)
                {
                    categoryRecyclerView.setVisibility(View.GONE);
                    categoryRefresh.setVisibility(View.VISIBLE);
                    categoryRefresh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            categoryRefresh.setVisibility(View.GONE);
                            categoryRecyclerView.setVisibility(View.VISIBLE);
                            loadFromOnline(category,realm);
                        }
                    });
                }
            }
        });
    }

    private void loadVideoFromOnline(final String category, final Realm realm)
    {
        RetrofitInterface videoInterface = RetrofitService.getClient().create(RetrofitInterface.class);
        Call<List<VideosList>> videoCall = videoInterface.getVideos();
        videoCall.enqueue(new Callback<List<VideosList>>() {
            @Override
            public void onResponse(@NonNull Call<List<VideosList>> call, @NonNull final Response<List<VideosList>> response) {
                if(categorySwipe.isRefreshing())
                {categorySwipe.setRefreshing(false);}
                if(response.isSuccessful())
                {
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.where(VideosList.class).findAll().deleteAllFromRealm();
                            realm.copyToRealmOrUpdate((Iterable) response.body());
                            RealmResults<VideosList> vids = realm.where(VideosList.class).contains("videoCategory",category).findAll();
                            if(vids.size() > 0)
                            {
                            videoAdapter = new VideoAdapter(CategoryActivity.this,vids,fontChangeCrawler);
                            categoryRecyclerView.setAdapter(videoAdapter);}
                            else
                            {
                                categoryRecyclerView.setVisibility(View.GONE);
                                categoryRefresh.setVisibility(View.VISIBLE);
                                categoryRefresh.setText("Nothing found.");
                            }
                        }
                    });
                }
                else
                {
                    //malformed response
                   // Toast.makeText(CategoryActivity.this, "Malformed Response", Toast.LENGTH_SHORT).show();
                     }
            }

            @Override
            public void onFailure(Call<List<VideosList>> call, Throwable t) {
                if(categorySwipe.isRefreshing())
                {categorySwipe.setRefreshing(false);}
                if(videoResults.size() == 0 )
                {
                    categoryRecyclerView.setVisibility(View.GONE);
                    categoryRefresh.setVisibility(View.VISIBLE);
                    categoryRefresh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            categoryRefresh.setVisibility(View.GONE);
                            categoryRecyclerView.setVisibility(View.VISIBLE);
                            loadVideoFromOnline(category,realm);
                        }
                    });
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(realm != null) {
            dbHelper.closeRealm(realm);
        }
    }
    public HomeItemPOJO addHomeItem(String mainTitle, String subTitle, int image, String category)
    {
        HomeItemPOJO homeItemPOJO = new HomeItemPOJO();
        homeItemPOJO.setMaintitle(mainTitle);
        homeItemPOJO.setSubtitle(subTitle);
        homeItemPOJO.setImageurl(image);
        homeItemPOJO.setCategory(category);
        return homeItemPOJO;
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            webViewload.setVisibility(View.VISIBLE);
           // Toast.makeText(CategoryActivity.this, "Page is Loading", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            webViewload.setVisibility(View.GONE);
            webView.setVisibility(View.VISIBLE);
            //Toast.makeText(CategoryActivity.this, "Page Finished Loading", Toast.LENGTH_SHORT).show();
        }
    }
}
