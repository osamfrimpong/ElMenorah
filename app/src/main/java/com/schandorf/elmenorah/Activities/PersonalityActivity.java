package com.schandorf.elmenorah.Activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.schandorf.elmenorah.Helpers.Constants;
import com.schandorf.elmenorah.R;

public class PersonalityActivity extends AppCompatActivity {
    WebView personalityWebView;
    TextView webViewload;
    TextView personalityRefresh;
    SwipeRefreshLayout personalitySwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality);
        this.setTitle("Personality");
        webViewload = findViewById(R.id.webViewLoad);
        personalityWebView = findViewById(R.id.personality_webView);
        personalityRefresh = findViewById(R.id.personalityRefresh);
        personalitySwipe = findViewById(R.id.personalitySwipe);
        loadfromOnline();
        personalitySwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                personalitySwipe.setRefreshing(true);
                loadfromOnline();
            }
        });

    }

    private void loadfromOnline() {
        DetectConnection chkConnection = new DetectConnection();
        if (!chkConnection.checkInternetConnection(PersonalityActivity.this)) {
            Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
            personalityWebView.setVisibility(View.GONE);
            personalityRefresh.setText("Please Check Internet Connectivity and Swipe Down to Reload!");
            personalityRefresh.setVisibility(View.VISIBLE);
            if(personalitySwipe.isRefreshing())
            {
                personalitySwipe.setRefreshing(false);
            }
        } else {

            personalityWebView.loadUrl(Constants.BASE_URL+Constants.PERSONALITY_LINK);
            personalityWebView.setWebViewClient(new MyWebViewClient());
        }

    }

    private class MyWebViewClient extends WebViewClient {



        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            webViewload.setVisibility(View.VISIBLE);


        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            webViewload.setVisibility(View.GONE);
            personalityWebView.setVisibility(View.VISIBLE);
            if(personalitySwipe.isRefreshing())
            {
                personalitySwipe.setRefreshing(false);
            }
            //Toast.makeText(CategoryActivity.this, "Page Finished Loading", Toast.LENGTH_SHORT).show();
        }
    }

    public class DetectConnection {
        public  boolean checkInternetConnection(Context context) {

            ConnectivityManager con_manager = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);

            return (con_manager.getActiveNetworkInfo() != null
                    && con_manager.getActiveNetworkInfo().isAvailable()
                    && con_manager.getActiveNetworkInfo().isConnected());
        }
    }
}
