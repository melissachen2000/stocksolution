package com.example.myche.stocksolution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button[] newsbuttons = new Button[20];

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

        for (int i = 0; i < newsbuttons.length; i++) {
            newsbuttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, NewsActivity.class));
                }
            });
        }

        Button newsButton = (Button) findViewById(R.id.button);
        final EditText maxGetter = (EditText) findViewById(R.id.editText);

        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maximumStockPrice = maxGetter.getText().toString().trim();
                int maxPrice = Integer.parseInt(maximumStockPrice);
            }
        });
    }

}
