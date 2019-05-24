package com.schandorf.elmenorah.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.schandorf.elmenorah.Helpers.Constants;
import com.schandorf.elmenorah.Helpers.FontChangeCrawler;
import com.schandorf.elmenorah.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class AboutActivity extends AppCompatActivity {


    Spanned aboutText;
    @InjectView(R.id.about_text)
    TextView aboutTextView;
    @InjectView(R.id.share_app)
    Button shareApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.inject(this);
        this.setTitle("About ElMenorah");
        FontChangeCrawler fontChangeCrawler = new FontChangeCrawler(getAssets(), Constants.FONT_NAME);
        fontChangeCrawler.replaceFonts((ViewGroup) this.findViewById(android.R.id.content));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            aboutText = Html.fromHtml(getRawContent(), Html.FROM_HTML_MODE_LEGACY);
        } else {
            aboutText = Html.fromHtml(getRawContent());
        }
        aboutTextView.setText(aboutText);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private String getRawContent() {
        String aboutTextString;
        StringBuilder sb = new StringBuilder();
        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("about.html")));
            while ((aboutTextString = bufferedReader.readLine()) != null) {
                sb.append(aboutTextString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private void shareApp() {
        String shareText = "Download the ElMenorah App from\n\n "+Constants.BASE_URL+Constants.APP_LINK;
    Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT,shareText);
        shareIntent.setType("text/plain");
        startActivity(Intent.createChooser(shareIntent,"Share ElMenorah App With"));
    }

    @OnClick(R.id.share_app)
    public void onClick() {
        shareApp();
    }
}
