package com.example.myche.stocksolution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] allStockTickers = GetTickers.getTickers();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button[] newsbuttons = new Button[20];
        newsbuttons[0] = (Button) findViewById(R.id.getnews01);
        newsbuttons[1] = (Button) findViewById(R.id.getnews02);
        newsbuttons[2] = (Button) findViewById(R.id.getnews03);
        newsbuttons[3] = (Button) findViewById(R.id.getnews04);
        newsbuttons[4] = (Button) findViewById(R.id.getnews05);
        newsbuttons[5] = (Button) findViewById(R.id.getnews06);
        newsbuttons[6] = (Button) findViewById(R.id.getnews07);
        newsbuttons[7] = (Button) findViewById(R.id.getnews08);
        newsbuttons[8] = (Button) findViewById(R.id.getnews09);
        newsbuttons[9] = (Button) findViewById(R.id.getnews10);
        newsbuttons[10] = (Button) findViewById(R.id.getnews11);
        newsbuttons[11] = (Button) findViewById(R.id.getnews12);
        newsbuttons[12] = (Button) findViewById(R.id.getnews13);
        newsbuttons[13] = (Button) findViewById(R.id.getnews14);
        newsbuttons[14] = (Button) findViewById(R.id.getnews15);
        newsbuttons[15] = (Button) findViewById(R.id.getnews16);
        newsbuttons[16] = (Button) findViewById(R.id.getnews17);
        newsbuttons[17] = (Button) findViewById(R.id.getnews18);
        newsbuttons[18] = (Button) findViewById(R.id.getnews19);
        newsbuttons[19] = (Button) findViewById(R.id.getnews20);

        final TextView[] tickers = new TextView[20];
        tickers[0] = (TextView) findViewById(R.id.ticker01);
        tickers[1] = (TextView) findViewById(R.id.ticker02);
        tickers[2] = (TextView) findViewById(R.id.ticker03);
        tickers[3] = (TextView) findViewById(R.id.ticker04);
        tickers[4] = (TextView) findViewById(R.id.ticker05);
        tickers[5] = (TextView) findViewById(R.id.ticker06);
        tickers[6] = (TextView) findViewById(R.id.ticker07);
        tickers[7] = (TextView) findViewById(R.id.ticker08);
        tickers[8] = (TextView) findViewById(R.id.ticker09);
        tickers[9] = (TextView) findViewById(R.id.ticker10);
        tickers[10] = (TextView) findViewById(R.id.ticker11);
        tickers[11] = (TextView) findViewById(R.id.ticker12);
        tickers[12] = (TextView) findViewById(R.id.ticker13);
        tickers[13] = (TextView) findViewById(R.id.ticker14);
        tickers[14] = (TextView) findViewById(R.id.ticker15);
        tickers[15] = (TextView) findViewById(R.id.ticker16);
        tickers[16] = (TextView) findViewById(R.id.ticker17);
        tickers[17] = (TextView) findViewById(R.id.ticker18);
        tickers[18] = (TextView) findViewById(R.id.ticker19);
        tickers[19] = (TextView) findViewById(R.id.ticker20);

        final TextView[] prices = new TextView[20];
        prices[0] = (TextView) findViewById(R.id.price01);
        prices[1] = (TextView) findViewById(R.id.price02);
        prices[2] = (TextView) findViewById(R.id.price03);
        prices[3] = (TextView) findViewById(R.id.price04);
        prices[4] = (TextView) findViewById(R.id.price05);
        prices[5] = (TextView) findViewById(R.id.price06);
        prices[6] = (TextView) findViewById(R.id.price07);
        prices[7] = (TextView) findViewById(R.id.price08);
        prices[8] = (TextView) findViewById(R.id.price09);
        prices[9] = (TextView) findViewById(R.id.price10);
        prices[10] = (TextView) findViewById(R.id.price11);
        prices[11] = (TextView) findViewById(R.id.price12);
        prices[12] = (TextView) findViewById(R.id.price13);
        prices[13] = (TextView) findViewById(R.id.price14);
        prices[14] = (TextView) findViewById(R.id.price15);
        prices[15] = (TextView) findViewById(R.id.price16);
        prices[16] = (TextView) findViewById(R.id.price17);
        prices[17] = (TextView) findViewById(R.id.price18);
        prices[18] = (TextView) findViewById(R.id.price19);
        prices[19] = (TextView) findViewById(R.id.price20);

        final TextView[] names = new TextView[20];
        names[0] = (TextView) findViewById(R.id.company01);
        names[1] = (TextView) findViewById(R.id.company02);
        names[2] = (TextView) findViewById(R.id.company03);
        names[3] = (TextView) findViewById(R.id.company04);
        names[4] = (TextView) findViewById(R.id.company05);
        names[5] = (TextView) findViewById(R.id.company06);
        names[6] = (TextView) findViewById(R.id.company07);
        names[7] = (TextView) findViewById(R.id.company08);
        names[8] = (TextView) findViewById(R.id.company09);
        names[9] = (TextView) findViewById(R.id.company10);
        names[10] = (TextView) findViewById(R.id.company11);
        names[11] = (TextView) findViewById(R.id.company12);
        names[12] = (TextView) findViewById(R.id.company13);
        names[13] = (TextView) findViewById(R.id.company14);
        names[14] = (TextView) findViewById(R.id.company15);
        names[15] = (TextView) findViewById(R.id.company16);
        names[16] = (TextView) findViewById(R.id.company17);
        names[17] = (TextView) findViewById(R.id.company18);
        names[18] = (TextView) findViewById(R.id.company19);
        names[19] = (TextView) findViewById(R.id.company20);

        for (int i = 0; i < newsbuttons.length; i++) {
            final int copyi = i;
            newsbuttons[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    NewsActivity.setButton(tickers[copyi].getText().toString());
                    startActivity(new Intent(MainActivity.this, NewsActivity.class));
                }
            });
        }

        final Button refresh = (Button) findViewById(R.id.button);
        final EditText maxGetter = (EditText) findViewById(R.id.editText);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int maxPrice;
                try {
                    String maximumStockPrice = maxGetter.getText().toString().trim();
                    maxPrice = Integer.parseInt(maximumStockPrice);
                } catch (Exception e) {
                    maxPrice = 150;
                    maxGetter.setText(Integer.toString(maxPrice));
                }


                String[] stockTickers = new String[20];
                int index = 0;
                for (int i = 0; i < 20; i++) {
                    index = (int) (Math.random() * allStockTickers.length);
                    stockTickers[i] = allStockTickers[index];
                    tickers[i].setText(stockTickers[i]);


                    DataRequest price = new DataRequest(MainActivity.this, prices[i]);
                    price.execute("Stock", "0", stockTickers[i], "latestPrice");

                    DataRequest name = new DataRequest(MainActivity.this, names[i]);
                    name.execute("Stock", "0", stockTickers[i], "companyName");

                    if (prices[i].getText().toString().equals("NONE") || names[i].getText().toString().equals("NONE")) {
                        i--;
                    }
                }
            }
        });
    }

}
