package com.example.android_learning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mArticlesRV;
    private TextView mTitle;
    private TextView mContent;
    private TextView mDatetime;
    private TextView mUser;
    private ArrayList<Article> mList;
    private String url = TempURL.getStrSite();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mArticlesRV = findViewById(R.id.rv_main);
        mArticlesRV.setAdapter(new MainRVAdapter(this, mList));

    }
}
