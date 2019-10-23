package com.example.newsdaily.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.newsdaily.R;

public class AboutActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private AppCompatTextView txt_appname, txt_version, txt_ack,
            txt_ack1, txt_ack2, txt_aboutapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        toolbar = findViewById(R.id.toolbar_about);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);


        txt_appname = findViewById(R.id.txt_name);
        txt_version = findViewById(R.id.version);
        txt_ack = findViewById(R.id.acknowledge);
        txt_ack1 = findViewById(R.id.ack_one);
        txt_ack2 = findViewById(R.id.ack_two);
        txt_aboutapp = findViewById(R.id.aboutapp);


        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/avenirnextregular.ttf");
        txt_appname.setTypeface(font);
        txt_version.setTypeface(font);
        txt_ack.setTypeface(font);
        txt_ack1.setTypeface(font);
        txt_ack2.setTypeface(font);


        txt_aboutapp.setTypeface(font);

    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    @Override
    protected void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }
        return true;
    }
}
