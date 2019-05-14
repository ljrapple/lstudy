package com.ljr.study.provider;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ljr.study.utils.Logger;
import com.ljr.study.utils.Utils;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int version = 4;
    private static final String name = "test_db";

    public DataBaseHelper(Context context) {
        this(context, name, null, version, null);
        Logger.e("DataBaseHelper  :  constructor");
    }

    public DataBaseHelper(Context context, String name,
            SQLiteDatabase.CursorFactory factory, int version,
            DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String sqlCreateImageTable = "CREATE TABLE test"
                + " ( id TEXT PRIMARY KEY ON CONFLICT IGNORE, "
                + " name TEXT NOT NULL, "
                + " description TEXT "
                + ");";
        Logger.e("DataBaseHelper  :  onCreate  is ui thread =  "  + Utils.isUiThread());
        db.execSQL(sqlCreateImageTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Logger.e("DataBaseHelper  :  onUpgrade old =  " + oldVersion +  "  ;  new  = " + newVersion
        + " is ui thread =  "  + Utils.isUiThread());
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
