package com.example.recyclerviewpool;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class MainActivityB extends AppCompatActivity {
    private ViewPager viewPager;
    boolean has;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        final RecyclerView recyclerView=new RecyclerView(this);
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListAdapter(this));
        final FrameLayout frameLayout=findViewById(R.id.f1);
        frameLayout.addView(recyclerView);
        has=true;


        findViewById(R.id.textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (has){
                    //setVisibl);
                    frameLayout.removeAllViews();
                    //frameLayout.setVisibility(View.GONE);
                    has=false;
                }

                else {
                    has=true;
                    //frameLayout.setVisibility(View.VISIBLE);
                    frameLayout.addView(recyclerView);
                }
            }
        });

    }


}
