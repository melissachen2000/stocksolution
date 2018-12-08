package com.example.myche.stocksolution;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NewsActivity extends AppCompatActivity {
    static String ticker;
    public static void setButton(String i) {
        ticker = i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_page);

        final TextView[] headlines = new TextView[5];
        headlines[0] = (TextView) findViewById(R.id.headline01);
        headlines[1] = (TextView) findViewById(R.id.headline02);
        headlines[2] = (TextView) findViewById(R.id.headline03);
        headlines[3] = (TextView) findViewById(R.id.headline04);
        headlines[4] = (TextView) findViewById(R.id.headline05);

        final TextView[] sources = new TextView[5];
        sources[0] = (TextView) findViewById(R.id.source01);
        sources[1] = (TextView) findViewById(R.id.source02);
        sources[2] = (TextView) findViewById(R.id.source03);
        sources[3] = (TextView) findViewById(R.id.source04);
        sources[4] = (TextView) findViewById(R.id.source05);

        final TextView[] dates = new TextView[5];
        dates[0] = (TextView) findViewById(R.id.datetime01);
        dates[1] = (TextView) findViewById(R.id.datetime02);
        dates[2] = (TextView) findViewById(R.id.datetime03);
        dates[3] = (TextView) findViewById(R.id.datetime04);
        dates[4] = (TextView) findViewById(R.id.datetime05);

        final Button[] viewArticle = new Button[5];
        viewArticle[0] = (Button) findViewById(R.id.article01);
        viewArticle[1] = (Button) findViewById(R.id.article02);
        viewArticle[2] = (Button) findViewById(R.id.article03);
        viewArticle[3] = (Button) findViewById(R.id.article04);
        viewArticle[4] = (Button) findViewById(R.id.article05);

        for (int i = 0; i < viewArticle.length; i++) {
            final int copyi = i;
            viewArticle[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = links[copyi];

                    Intent it = new Intent(Intent.ACTION_VIEW);
                    it.setData(Uri.parse(url));
                    startActivity(it);
                }
            });

        }
    }
}
