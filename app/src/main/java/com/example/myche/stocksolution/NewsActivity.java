package com.example.myche.stocksolution;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class NewsActivity extends AppCompatActivity {
    static String ticker;
    public static void setButton(String i) {
        ticker = i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_page);

        final TextView[] headlines = new TextView[3];
        headlines[0] = (TextView) findViewById(R.id.headline01);
        headlines[1] = (TextView) findViewById(R.id.headline02);
        headlines[2] = (TextView) findViewById(R.id.headline03);

        final TextView[] sources = new TextView[3];
        sources[0] = (TextView) findViewById(R.id.source01);
        sources[1] = (TextView) findViewById(R.id.source02);
        sources[2] = (TextView) findViewById(R.id.source03);

        final TextView[] dates = new TextView[3];
        dates[0] = (TextView) findViewById(R.id.datetime01);
        dates[1] = (TextView) findViewById(R.id.datetime02);
        dates[2] = (TextView) findViewById(R.id.datetime03);

        final Button[] viewArticle = new Button[3];
        viewArticle[0] = (Button) findViewById(R.id.article01);
        viewArticle[1] = (Button) findViewById(R.id.article02);
        viewArticle[2] = (Button) findViewById(R.id.article03);

        for (int i = 0; i < headlines.length; i++) {
            DataRequest headline = new DataRequest(NewsActivity.this, headlines[i]);
            try {
                headline.execute("headline", Integer.toString(i), ticker);
            } catch (Exception e) {
                headlines[i].setText("");
                viewArticle[i].setText("");
            }
        }

        for (int i = 0; i < dates.length; i++) {
            DataRequest date = new DataRequest(NewsActivity.this, dates[i]);
            try {
                date.execute("datetime", Integer.toString(i), ticker);
            } catch (Exception e) {
                dates[i].setText("");
            }
        }

        for (int i = 0; i < sources.length; i++) {
            DataRequest source = new DataRequest(NewsActivity.this, sources[i]);
            try {
                source.execute("source", Integer.toString(i), ticker);
            } catch (Exception e) {
                sources[i].setText("");
            }
        }

        for (int i = 0; i < viewArticle.length; i++) {
            final int copyi = i;
            viewArticle[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String link = "";

                    if (!link.equals("ERROR")) {
                        viewArticle[copyi].setText(link);
                        Intent it = new Intent(Intent.ACTION_VIEW);
                        it.setData(Uri.parse(link));
                        startActivity(it);
                    }
                }
            });

        }

    }
}
