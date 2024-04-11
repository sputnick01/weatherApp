package com.example.weatherapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.weatherapp.Adapters.FutureAdapters;
import com.example.weatherapp.Domains.FutureDomain;
import com.example.weatherapp.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapterTommorow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);
        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout constraintLayout=findViewById(R.id.constraintBack);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FutureActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items=new ArrayList<>();
        items.add(new FutureDomain("Sat","storm","storm",25,10));
        items.add(new FutureDomain("Sun","cloudy","cloudy",24,16));
        items.add(new FutureDomain("Mon","windy","windy",29,15));
        items.add(new FutureDomain("Tue","cloudy_sunny","Cloudy Sunny",25,10));
        items.add(new FutureDomain("Wen","sunny","Sunny",35,13));
        items.add(new FutureDomain("Thu","rain","Rainy",23,12));
        recyclerView=findViewById(R.id.futureRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapterTommorow=new FutureAdapters(items);
        recyclerView.setAdapter(adapterTommorow);
    }
}