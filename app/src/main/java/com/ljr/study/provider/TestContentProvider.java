package com.ljr.study.provider;

import static android.content.UriMatcher.NO_MATCH;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ljr.study.LApplication;
import com.ljr.study.utils.Logger;
import com.ljr.study.utils.Utils;

public class TestContentProvider extends ContentProvider {
    private static String AUTHOR = "com.ljr.provider";
    private static UriMatcher sUriMatcher = new UriMatcher(NO_MATCH);

    private static class Singleton {
        static DataBaseHelper sDataBaseHelper = new DataBaseHelper(LApplication.getInstance());

        SQLiteDatabase getReadableDatabase() {
            return sDataBaseHelper.getReadableDatabase();
        }

        SQLiteDatabase getWritableDatabase() {
            return sDataBaseHelper.getWritableDatabase();
        }
    }

    private static Singleton sInstance = new Singleton();

    static {
        sUriMatcher.addURI(AUTHOR, "people/*", 1);
        Logger.setTag("TestContentProvider");
    }

    public TestContentProvider() {
//        Logger.setTag("TestContentProvider");
        Logger.e("constructor ;  is ui thread  =  " + Utils.isUiThread());
    }

    @Override
    public boolean onCreate() {
        Logger.e("onCreate ;  is ui thread  =  " + Utils.isUiThread());
        return false;
    }
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
            @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Logger.e("query ;  is ui thread  =  " + Utils.isUiThread());
        Logger.e("query uri :  " + uri.toString() + " is match :  " + sUriMatcher.match(uri));
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        Logger.e("getType ;  is ui thread  =  " + Utils.isUiThread());
        Logger.e("getType uri :  " + uri.toString() + " is match :  " + sUriMatcher.match(uri));
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Logger.e("insert ;  is ui thread  =  " + Utils.isUiThread());
        Logger.e("insert uri :  " + uri.toString() + " is match :  " + sUriMatcher.match(uri));
        sInstance.getWritableDatabase().insert("test", null, values);
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection,
            @Nullable String[] selectionArgs) {
        Logger.e("delete ;  is ui thread  =  " + Utils.isUiThread());
        Logger.e("delete uri :  " + uri.toString() + " is match :  " + sUriMatcher.match(uri));
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection,
            @Nullable String[] selectionArgs) {
        Logger.e("update ;  is ui thread  =  " + Utils.isUiThread());
        Logger.e("update uri :  " + uri.toString() + " is match :  " + sUriMatcher.match(uri));
        return 0;
    }
}
