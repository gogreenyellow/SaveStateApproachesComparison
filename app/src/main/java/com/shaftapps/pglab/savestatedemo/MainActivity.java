package com.shaftapps.pglab.savestatedemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Paulina Glab on 16.09.2017.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TOKEN_KEY = "token";
    private static final String DESCRIPTION_KEY = "description";

    private String mToken;
    private String mDescription;
    private TextView mTokenTextView;
    private TextView mDescriptionTextView;
    private CardView mTokenCardView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTokenTextView = (TextView) findViewById(R.id.am_token);
        mDescriptionTextView = (TextView) findViewById(R.id.am_description);
        mTokenCardView = (CardView) findViewById(R.id.am_token_card);
    }

    public void handleButtonClick(View v) {
        new FetchToken().execute();
    }

    private void showToken(String token, String description) {
        mTokenTextView.setText(getString(R.string.token_label, token));
        mDescriptionTextView.setText(description);
        mTokenCardView.setVisibility(View.VISIBLE);
    }

    class FetchToken extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            final String urlString = "https://api.myjson.com/bins/zt5gl";

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String jsonStr = null;

            try {
                URL url = new URL(urlString);

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    jsonStr = null;
                }

                jsonStr = buffer.toString();

            } catch (Exception e) {
                Log.e(this.getClass().getName(), "Error ", e);
                return null;

            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        Log.e(this.getClass().getName(), "Error closing stream", e);
                    }
                }
            }

            return jsonStr;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s == null) {
                return;
            }

            try {
                JSONObject json = new JSONObject(s);
                mToken = json.getString("token");
                mDescription = json.getString("description");
                showToken(mToken, mDescription);
            } catch (JSONException e) {
                Log.e(this.getClass().getName(), "Error ", e);
                e.printStackTrace();
            }
        }
    }
}
