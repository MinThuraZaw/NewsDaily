package com.example.newsdaily.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.newsdaily.R;
import com.example.newsdaily.news_activities.BusinessActivity;
import com.example.newsdaily.news_activities.EntertainmentActivity;
import com.example.newsdaily.news_activities.GeneralActivity;
import com.example.newsdaily.news_activities.HealthActivity;
import com.example.newsdaily.news_activities.ScienceActivity;
import com.example.newsdaily.news_activities.SportsActivity;
import com.example.newsdaily.news_activities.TechnologyActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private CardView card_tech, card_business, card_health, card_entertain, card_sports,
            card_general,card_science ;
    private AppCompatTextView tv_general, tv_tech, tv_science, tv_business, tv_health, tv_sport,
            tv_enter,tv_coming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/avenirnextregular.ttf");

        //declare cards by id
        card_tech = findViewById(R.id.card_tech);
        card_business = findViewById(R.id.card_business);
        card_health = findViewById(R.id.card_health);
        card_entertain = findViewById(R.id.card_entertain);
        card_sports = findViewById(R.id.card_sports);
        card_general = findViewById(R.id.card_general);
        card_science = findViewById(R.id.card_science);

        //declare textviews
        tv_general = findViewById(R.id.tv_general);
        tv_tech = findViewById(R.id.tv_tech);
        tv_science = findViewById(R.id.tv_science);
        tv_business = findViewById(R.id.tv_business);
        tv_health = findViewById(R.id.tv_health);
        tv_sport = findViewById(R.id.tv_sports);
        tv_enter = findViewById(R.id.tv_entertain);
        tv_coming = findViewById(R.id.tv_coming);

        //set typeface for textviews
        tv_general.setTypeface(font, Typeface.BOLD);
        tv_tech.setTypeface(font, Typeface.BOLD);
        tv_science.setTypeface(font, Typeface.BOLD);
        tv_business.setTypeface(font, Typeface.BOLD);
        tv_health.setTypeface(font, Typeface.BOLD);
        tv_sport.setTypeface(font, Typeface.BOLD);
        tv_enter.setTypeface(font, Typeface.BOLD);
        tv_coming.setTypeface(font, Typeface.BOLD);


        //set onClick for the cards
        card_tech.setOnClickListener(this);
        card_business.setOnClickListener(this);
        card_health.setOnClickListener(this);
        card_entertain.setOnClickListener(this);
        card_sports.setOnClickListener(this);
        card_general.setOnClickListener(this);
        card_science.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.action_about){
            startActivity(new Intent(MainActivity.this, AboutActivity.class));
            overridePendingTransition(0, 0);
            //overridePendingTransition(0,0);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.card_general:
                startActivity(new Intent(MainActivity.this, GeneralActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.card_tech:
                startActivity(new Intent(MainActivity.this, TechnologyActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.card_science:
                startActivity(new Intent(MainActivity.this, ScienceActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.card_business:
                startActivity(new Intent(MainActivity.this, BusinessActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.card_entertain:
                startActivity(new Intent(MainActivity.this, EntertainmentActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.card_health:
                startActivity(new Intent(MainActivity.this, HealthActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.card_sports:
                startActivity(new Intent(MainActivity.this, SportsActivity.class));
                overridePendingTransition(0,0);
                break;

            default:break;
        }

    }
}
