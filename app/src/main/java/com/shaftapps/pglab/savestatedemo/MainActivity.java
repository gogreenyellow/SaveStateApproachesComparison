package com.shaftapps.pglab.savestatedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Paulina Glab on 16.09.2017.
 */

public class MainActivity extends AppCompatActivity {

    private View mSecretView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSecretView = findViewById(R.id.am_secret_view);
    }

    public void handleButtonClick(View v) {
        showSecretView();
    }

    private void showSecretView() {
        mSecretView.setVisibility(View.VISIBLE);
    }
}
