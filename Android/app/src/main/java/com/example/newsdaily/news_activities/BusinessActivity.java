package com.example.newsdaily.news_activities;

import android.graphics.PorterDuff;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsdaily.R;
import com.example.newsdaily.adapter.NewsAdapter;
import com.example.newsdaily.model.NewsModel;
import com.example.newsdaily.network.NetApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BusinessActivity extends AppCompatActivity {

    private NewsAdapter mAdapter;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private String API_BASE_URL = "https://newsapi.org";
    private NewsModel data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_layout);

        toolbar = findViewById(R.id.toolbar_news);
        toolbar.setTitle(R.string.business_news);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadJSON();

    }

    void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NetApi request = retrofit.create(NetApi.class);

        request.getBusinessNews().enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {

                if(response.isSuccessful()){

                    data  = response.body();
                    mAdapter = new NewsAdapter(getApplicationContext(),data);

                    recyclerView.setAdapter(mAdapter);
                    Log.i("test","success"+data.toString());

                }

            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

                Toast.makeText(BusinessActivity.this, "Check your connection and try again", Toast.LENGTH_SHORT).show();
                Log.i("JSON",""+t.getMessage());
                Log.i("test","fail");

            }
        });


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
