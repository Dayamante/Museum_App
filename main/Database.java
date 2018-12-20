package com.gurnaud.antoine.museumapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "museumDB.db";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ProfilDAO.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Don't do anything
        // Maintainers should handle the transition themselves
        // Drop tables will remove all data our users have created
    }

    @Override
    public SQLiteDatabase getWritableDatabase() { return super.getWritableDatabase(); }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    /////////////////////////////////////////////////////////
    //  Singleton part

    private static Database sInstance = null;

    private Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static boolean isInstantiated() { return sInstance != null; }

    public static Database getInstance() {
        return sInstance;
    }

    public static boolean initInstance(Context context) {
        sInstance = new Database(context);
        return sInstance != null;
    }

    public static void freeInstance() {
        sInstance = null;
    }
}