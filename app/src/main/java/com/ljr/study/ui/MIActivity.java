package com.ljr.study.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ljr.study.R;
import com.ljr.study.adapter.ItemAdapter;
import com.ljr.study.main.FirstPageSection;
import com.ljr.study.main.FistPageItemFactory;
import com.ljr.study.main.ItemArguments;

public class MIActivity extends Activity {

    private ItemArguments<?, ?, ?>[] mPairs = new ItemArguments[]{
            new ItemArguments(FirstPageSection.HEAD_NAME, "Merge and include :"),
            new ItemArguments("Include: no set width/height value.",
                    "com.ljr.study.ui.IncludeAndMergeActivity", R.layout.first_merge_container),
            new ItemArguments("Include: set width as 100dp; Content: set width as match parent",
                    "com.ljr.study.ui.IncludeAndMergeActivity",
                    R.layout.second_merge_container),
            new ItemArguments("Include: set width as wrap content",
                    "com.ljr.study.ui.IncludeAndMergeActivity",
                    R.layout.third_merge_container),
            new ItemArguments("Include: set margin as 16dp", "com.ljr.study.ui.IncludeAndMergeActivity",
                    R.layout.fourth_merge_container),
            new ItemArguments("Include: set width as 300dp; Content: set width as wrap content",
                    "com.ljr.study.ui.IncludeAndMergeActivity",
                    R.layout.fifth_merge_container),
            new ItemArguments("Include: set height as match parent; Content: set height as 300dp",
                    "com.ljr.study.ui.IncludeAndMergeActivity",
                    R.layout.sixth_merge_container),
            new ItemArguments(FirstPageSection.HEAD_NAME, "Include :"),
            new ItemArguments("Include: no set width/height value.",
                    "com.ljr.study.ui.IncludeAndMergeActivity", R.layout.first_include_container),
            new ItemArguments("Include: set width as 100dp; Content: set width as match parent",
                    "com.ljr.study.ui.IncludeAndMergeActivity", R.layout.second_include_container),
            new ItemArguments("Include: set width as wrap content, set height as match parent",
                    "com.ljr.study.ui.IncludeAndMergeActivity", R.layout.third_include_container),
            new ItemArguments("Include: check if margin is valid",
                    "com.ljr.study.ui.IncludeAndMergeActivity", R.layout.fourth_include_container),
            new ItemArguments("Include: check if id is valid",
                    "com.ljr.study.ui.IncludeAndMergeActivity", R.layout.fifth_include_container),
            new ItemArguments("Include: check if id of the content is valid",
                    "com.ljr.study.ui.IncludeAndMergeActivity", R.layout.six_include_container),
            new ItemArguments("Include: check if other properties of the content is valid",
                    "com.ljr.study.ui.IncludeAndMergeActivity", R.layout.seventh_include_container),
            new ItemArguments("Switch language",
                    "com.ljr.study.ui.LanguageActivity", R.layout.switch_language)
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
