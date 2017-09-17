package com.shaftapps.pglab.savestatedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Paulina Glab on 16.09.2017.
 */

public class MainActivity extends AppCompatActivity {

    private static final String VISIBLE_KEY = "token";

    private boolean mSecretShown;
    private View mSecretView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSecretView = findViewById(R.id.am_secret_view);

        if (savedInstanceState != null && savedInstanceState.containsKey(VISIBLE_KEY)) {
            if (savedInstanceState.getBoolean(VISIBLE_KEY)) {
                showSecretView();
            }
        }
    }

    public void handleButtonClick(View v) {
        showSecretView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(VISIBLE_KEY, mSecretShown);
    }

    private void showSecretView() {
        mSecretShown = true;
        mSecretView.setVisibility(View.VISIBLE);
    }
}
