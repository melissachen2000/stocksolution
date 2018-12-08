package com.example.tom.finalproject0;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.*;


/**
 * https://api.iextrading.com/1.0/stock/market/batch?symbols=COMPANYSYMBLE,COMPANYSYMBLE&types=quote,news
 * eg: FB: faceBook
 */


/**
 * public class News:
 *
 * datetime
 * headline
 * source
 * url
 * summary
 * related
 */

/**
 * Stock Variables
 *
 * symbol
 * companyName
 * primaryExchange
 * sector
 * calculationPrice
 * open
 * openTime
 * close
 * closeTime
 * high
 * low
 * latestPrice
 * latestSource
 * latestTime
 * latestUpdate
 * latestVolume
 * iexRealtimePrice
 * iexRealtimeSize
 * iexLastUpdated
 * delayedPrice
 * delayedPriceTime
 * previousClose
 * change
 * changePercent
 * iexMarketPercent
 * iexVolume
 * avgTotalVolume
 * iexBidPrice
 * iexBidSize
 * iexAskPrice
 * iexAskSize
 * marketCap
 * peRatio
 * week52High
 * week52Low
 * ytdChange
 */

public class DataRequest extends AsyncTask<String, String, String> {
    Context context;
    TextView textView;
    Button button;
    ProgressDialog progressDialog;

    /**
     * @param context your context that preform such DataRequest, eg, MainActivity.
     * @param textView the textView you wish to change, must be initialized.
     * @param button the button that linked with this Onclick event.
     */
    DataRequest(Context context, TextView textView, Button button) {
        this.context = context;
        this.textView = textView;
        this.button = button;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            String outPut = "";

            String dataRequest = strings[0];
            Integer index = Integer.parseInt(strings[1]);
            String company = strings[2];

            String apiBase = "https://api.iextrading.com/1.0/stock/market/batch?symbols=";
            String quote = "&types=quote";
            String news = "&types=news";

            switch (dataRequest)
            {
                case "datetime" :
                    outPut =  new News().getDatetime( apiBase + company + "," + news, index, company);
                    break;

                case "headline" :
                    outPut =  new News().getHeadLine( apiBase + company + "," + news, index, company);
                    break;

                case "source" :
                    outPut =  new News().getSource( apiBase + company + "," + news, index, company);
                    break;

                case "url" :
                    outPut =  new News().getUrl( apiBase + company + "," + news, index, company);
                    break;

                case "summary" :
                    outPut =  new News().getSummary( apiBase + company + "," + news, index, company);
                    break;

                case "related" :
                    outPut =  new News().getRelated( apiBase + company + "," + news, index, company);
                    break;
            }

            if (dataRequest.equals("Stock")) {
                String variable = strings[3];
                outPut = new Stock().getData(apiBase + company + "," + quote, variable, company);
            }

            if (outPut.equals("")) {
                outPut = "NONE";
            }

            return outPut;
        } catch (Exception e) {
            return e.toString();
        }
    }

    @Override
    protected void onPreExecute() {
    }

    /**
     * Different behavior may needed.
     * May change.
     */
    @Override
    protected void onPostExecute(String outPut) {
        textView.setText(outPut);
    }

    public class Stock {

        public String getData(String url, String variable, String company) throws Exception {
            String output = "ERROR";
            JsonObject info = DataRequest.readJsonFromUrl(url);
            JsonObject companyData = (JsonObject) info.get(company);
            JsonObject data = companyData.get("quote").getAsJsonObject();
            JsonElement item = data.get(variable);
            if (item.isJsonNull()) {
                return "";
            }
            String re = item.getAsString();
            output = re;
            return output;
        }
    }

    public class News {

        public String getDatetime(String url, int index, String company) throws Exception{
            String output = "ERROR";
            JsonObject info = DataRequest.readJsonFromUrl(url);
            JsonObject companyData = (JsonObject) info.get(company);
            JsonArray allNews = (JsonArray) companyData.get("news");
            JsonObject oneNews = (JsonObject) allNews.get(index);
            String datetime = oneNews.get("datetime").getAsString();
            output = datetime;
            return output;
        }

        public String getHeadLine(String url, int index, String company) throws Exception{
            String output = "ERROR";
            JsonObject info = DataRequest.readJsonFromUrl(url);
            JsonObject companyData = (JsonObject) info.get(company);
            JsonArray allNews = (JsonArray) companyData.get("news");
            JsonObject oneNews = (JsonObject) allNews.get(index);
            String headline = oneNews.get("headline").getAsString();
            output = headline;
            return output;
        }

        public String getSource(String url, int index, String company) throws Exception{
            String output = "ERROR";
            JsonObject info = DataRequest.readJsonFromUrl(url);
            JsonObject companyData = (JsonObject) info.get(company);
            JsonArray allNews = (JsonArray) companyData.get("news");
            JsonObject oneNews = (JsonObject) allNews.get(index);
            String source = oneNews.get("source").getAsString();
            output = source;
            return output;
        }

        public String getUrl(String url, int index, String company) throws Exception{
            String output = "ERROR";
            JsonObject info = DataRequest.readJsonFromUrl(url);
            JsonObject companyData = (JsonObject) info.get(company);
            JsonArray allNews = (JsonArray) companyData.get("news");
            JsonObject oneNews = (JsonObject) allNews.get(index);
            String articleUrl = oneNews.get("url").getAsString();
            output = articleUrl;
            return output;
        }

        public String getSummary(String url, int index, String company) throws Exception{
            String output = "ERROR";
            JsonObject info = DataRequest.readJsonFromUrl(url);
            JsonObject companyData = (JsonObject) info.get(company);
            JsonArray allNews = (JsonArray) companyData.get("news");
            JsonObject oneNews = (JsonObject) allNews.get(index);
            String summary = oneNews.get("summary").getAsString();
            output = summary;
            return output;
        }

        public String getRelated(String url, int index, String company) throws Exception{
            String output = "ERROR";
            JsonObject info = DataRequest.readJsonFromUrl(url);
            JsonObject companyData = (JsonObject) info.get(company);
            JsonArray allNews = (JsonArray) companyData.get("news");
            JsonObject oneNews = (JsonObject) allNews.get(index);
            String related = oneNews.get("related").getAsString();
            output = related;
            return output;
        }

    }


    private static String readAll(Reader reader) {
        StringBuilder stringBuilder = new StringBuilder();
        int element;
        try {
            while ((element = reader.read()) != -1) {
            stringBuilder.append((char) element);
            }
        } finally {
            return stringBuilder.toString();
        }
    }

    public static com.google.gson.JsonObject readJsonFromUrl(String url) throws Exception {
        InputStream stream = new URL(url).openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, Charset.forName("UTF-8")));
        String jsonText = readAll(reader);
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(jsonText).getAsJsonObject();
        stream.close();
        return jsonObject;
    }
}
