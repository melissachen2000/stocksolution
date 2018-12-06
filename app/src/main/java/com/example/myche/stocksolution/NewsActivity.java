package com.example.myche.stocksolution;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


public class NewsActivity extends AppCompatActivity {

    private String[] title;
    private String[] author;
    private String[] datetime;
    private String[] links;

    private void getNews() {
        String[] headlines = {"UK stocks fall as Brexit headlines drive up sterling",
                "The Stock Market Hasn't Been This Bad Since the 1970s",
                "Stock market to close Wednesday, Dec. 5, in honor of George HW Bush",
                "It's Trump's stock market now",
                "This chart may be a key reason the stock market is plunging"};

        String[] sources = {"The Washington Post", "Time, Inc.", "USA Today", "The Washington Post", "Market Watch"};

        String[] dates = {"December 5, 2018 @ 2:24 PM", "December 5, 2018 @ 10:59 AM", "December 5, 2018 @ 7:32 AM", "December 5, 2018 @ 12:15 PM", "December 5, 2018 @ 2:49 PM"};

        String[] urls = {"http://www.washingtonpost.com/opinions/the-stock-market-decline-means--what/2018/12/05/972f350a-f8bc-11e8-8d64-4e79db33382f_story.html?noredirect=on&utm_term=.c47ef280b4bf",
                        "http://time.com/money/5471092/stock-market-news-worst-time-since-1972/",
                        "http://www.usatoday.com/story/money/2018/12/03/stock-market-closed-december-5-george-h-w-bush/2192106002/",
                        "https://www.washingtonpost.com/opinions/2018/12/05/its-trumps-stock-market-now/?utm_term=.94f532419bc3",
                        "http://www.marketwatch.com/story/this-chart-may-be-a-key-reason-the-stock-market-is-plunging-2018-12-04"};

        title = headlines;
        author = sources;
        datetime = dates;
        links = urls;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_page);

        getNews();

        final TextView[] headlines = new TextView[5];
        headlines[0] = (TextView) findViewById(R.id.headline01);
        headlines[1] = (TextView) findViewById(R.id.headline02);
        headlines[2] = (TextView) findViewById(R.id.headline03);
        headlines[3] = (TextView) findViewById(R.id.headline04);
        headlines[4] = (TextView) findViewById(R.id.headline05);

        for (int i = 0; i < headlines.length; i++) {
            headlines[i].setText(title[i]);
        }

        final TextView[] sources = new TextView[5];
        sources[0] = (TextView) findViewById(R.id.source01);
        sources[1] = (TextView) findViewById(R.id.source02);
        sources[2] = (TextView) findViewById(R.id.source03);
        sources[3] = (TextView) findViewById(R.id.source04);
        sources[4] = (TextView) findViewById(R.id.source05);

        for (int i = 0; i < sources.length; i++) {
            sources[i].setText(author[i]);
        }

        final TextView[] dates = new TextView[5];
        dates[0] = (TextView) findViewById(R.id.datetime01);
        dates[1] = (TextView) findViewById(R.id.datetime02);
        dates[2] = (TextView) findViewById(R.id.datetime03);
        dates[3] = (TextView) findViewById(R.id.datetime04);
        dates[4] = (TextView) findViewById(R.id.datetime05);

        for (int i = 0; i < dates.length; i++) {
            dates[i].setText(datetime[i]);
        }

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
