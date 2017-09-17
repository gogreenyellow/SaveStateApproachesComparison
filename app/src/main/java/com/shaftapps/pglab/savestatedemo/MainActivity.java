package com.shaftapps.pglab.savestatedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by Paulina Glab on 16.09.2017.
 */

public class MainActivity extends AppCompatActivity {

    private static final String VISIBLE_KEY = "token";

    private boolean mCardShown;
    private CardView mCardView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCardView = (CardView) findViewById(R.id.am_card);

        if (savedInstanceState != null && savedInstanceState.containsKey(VISIBLE_KEY)) {
            if (savedInstanceState.getBoolean(VISIBLE_KEY)) {
                showCardView();
            }
        }
    }

    public void handleButtonClick(View v) {
        showCardView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(VISIBLE_KEY, mCardShown);
    }

    private void showCardView() {
        mCardShown = true;
        mCardView.setVisibility(View.VISIBLE);
    }
}
