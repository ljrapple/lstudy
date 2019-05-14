package com.ljr.study.provider;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;

import com.ljr.study.R;
import com.ljr.study.utils.Logger;

public class ProviderTestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_service);
        Logger.e("ProviderTestActivity onCreate");
        testInsertSuperThread();
        testInsertNumber();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    void testInsertNumber() {
        ContentValues values = new ContentValues();
        values.put("name", "test");
        values.put("description", "testing");
        getContentResolver()
                .insert(Uri.parse("content://com.ljr.provider/people/10"), values);
    }

    void testInsertString() {
        getContentResolver().getType(Uri.parse("content://com.ljr.provider/people/s"));
    }

    void testInsertSuperThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ContentValues values = new ContentValues();
                values.put("name", "test");
                values.put("description", "testing");
                getContentResolver()
                        .insert(Uri.parse("content://com.ljr.provider/people/10"), values);
            }
        });
        thread.start();
    }


}
