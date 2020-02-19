package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    private List<NewApi.Result> results;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        APIFetch();
    }

    public void APIFetch(){

//        ProgressDialog progress = new ProgressDialog(this);
//        progress.setMessage("Loading Data....");
//        progress.show();

        RetrofitClient client = new RetrofitClient();

        TimesApi timesApi = client.getRetrofitInstance().create(TimesApi.class);

        Call<NewApi> call = timesApi.getNewApi("sports","J4yVETKpkjGB07PACWlol3TmUtrDunKa");
                                                                      //J4yVETKpkjGB07PACWlol3TmUtrDunKa

        call.enqueue(new Callback<NewApi>() {
            @Override
            public void onResponse(Call<NewApi> call, Response<NewApi> response) {

                if(response.isSuccessful()) {
                    Log.d("HELP!", response.body().results.get(0).title);
                    NewApi newApi = response.body();

                    results = newApi.results;

                    mAdapter = new MyAdapter(results);
                    recyclerView.setAdapter(mAdapter);
                }

            }

            @Override
            public void onFailure(Call<NewApi> call, Throwable t) {

                Log.d("HELP!", t.toString());
            }
        });
    }
}
