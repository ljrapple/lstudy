package com.ljr.study;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ljr.study.adapter.ItemAdapter;
import com.ljr.study.main.FirstPageSection;
import com.ljr.study.main.FistPageItemFactory;

public class MainActivity extends Activity {
    private Pair<String, String>[] mPairs = new Pair[]{
            new Pair(FirstPageSection.HEAD_NAME, "UI")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ItemAdapter itemAdapter =
                new ItemAdapter(new FistPageItemFactory(), new FirstPageSection(mPairs));
        recyclerView.setAdapter(itemAdapter);
    }
}
