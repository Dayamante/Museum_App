package com.gurnaud.antoine.museumapp;

import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;

public class ProfilDAO {
    //information of database
    public static final String TABLE_NAME = "Profil";
    public static final String COLUMN_ID = "ProfilID";
    public static final String COLUMN_EMAIL = "ProfilEmail";
    public static final String COLUMN_PASSWORD = "ProfilPassword";
    private static final String COLUMN_IMAGE = "profilImage";
    private static final String COLUMN_FIRSTNAME  = "profilFirstName";
    private static final String COLUMN_LASTNAME = "profilLastName";
    private static final int COLUMN_PHONE = 0;
    private static final String COLUMN_CITY = "profilCity";
    private static final int COLUMN_NBMUSEUM = 0;
    public static final int COLUMN_LEVEL = 0;


    public static String createTable() {
        String query = "CREATE TABLE" + TABLE_NAME + "("
                + COLUMN_ID + "INTEGER NOT NULL AUTOINCREMENT PRIMARYKEY,"
                + COLUMN_EMAIL + "TEXT NOT NULL UNIQUE,"
                + COLUMN_PASSWORD + "TEXT NOT NULL,"
                + COLUMN_IMAGE + "TEXT,"
                + COLUMN_FIRSTNAME + "TEXT,"
                + COLUMN_LASTNAME + "TEXT,"
                + COLUMN_PHONE + "INTEGER,"
                + COLUMN_CITY + "TEXT,"
                + COLUMN_NBMUSEUM + "INTEGER,"
                + COLUMN_LEVEL + "INTEGER )";
        return query;
    }

    public void registerProfil( Profil profil, String email, String password) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_IMAGE, profil.getImage());
        values.put(COLUMN_FIRSTNAME, profil.getFirstName());
        values.put(COLUMN_LASTNAME, profil.getLastName());
        values.put(String.valueOf(COLUMN_PHONE), profil.getPhone());
        values.put(COLUMN_CITY, profil.getCity());
        values.put(String.valueOf(COLUMN_NBMUSEUM), profil.getNbMuseum());
        values.put(String.valueOf(COLUMN_LEVEL), profil.getLevel());
        SQLiteDatabase db = null;
        try {
            db = Database.getInstance().getWritableDatabase();
            db.insert(TABLE_NAME, null, values);
        }catch (Exception e) {
            System.out.println(e.toString());
        }finally {
            db.close();
        }
    }

    public static boolean isAUser ( String email ) {
        String query = "SELECT * FROM " + TABLE_NAME
                + "WHERE" + COLUMN_EMAIL + " = " + "'" + email + "'";
        SQLiteDatabase db = null;
        Cursor cursor = null;
        Profil profil = new Profil();
        try {
            db = Database.getInstance().getWritableDatabase();
            cursor = db.rawQuery(query, null);
            if (cursor.getCount() == 1) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e) {
            System.out.println(e.toString());
        }finally {
            db.close();
            cursor.close();
        }
        return false;
    }

    public static Profil loginProfil(String email, String password) {
        String query = "SELECT * FROM " + TABLE_NAME
                + "WHERE" + COLUMN_EMAIL + " = " + "'" + email + "'"
                + "AND" + COLUMN_PASSWORD + " = " + "'" + password + "'";
        SQLiteDatabase db = null;
        Cursor cursor = null;
        Profil profil = new Profil();
        try {
            db = Database.getInstance().getWritableDatabase();
            cursor = db.rawQuery(query, null);
            if (cursor.getCount() == 1) {
                cursor.moveToFirst();
                profil.setImage((cursor.getString(3)));
                profil.setFirstName(cursor.getString(4));
                profil.setLastName(cursor.getString(5));
                profil.setPhone(Integer.parseInt(cursor.getString(6)));
                profil.setCity(cursor.getString(7));
                profil.setNbMuseum(Integer.parseInt(cursor.getString(8)));
            } else {
                profil = null;
            }
        }catch (Exception e) {
            System.out.println(e.toString());
        }finally {
            db.close();
            cursor.close();
        }
        return profil;
    }
    /**
    public boolean deleteHandler(int ID) {}

    public boolean updateHandler(int ID, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID, ID);
        args.put(COLUMN_NAME, name);
        return db.update(TABLE_NAME, args, COLUMN_ID + "=" + ID, null) > 0;
    }
     */
}
