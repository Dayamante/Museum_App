import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "museumDB.db";
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

    //initialize the database
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "(" +  COLUMN_ID + "INTEGER NOT NULL AUTOINCREMENT PRIMARYKEY,"
                + COLUMN_EMAIL + "TEXT NOT NULL UNIQUE,"
                + COLUMN_PASSWORD + "TEXT NOT NULL,"
                + COLUMN_IMAGE + "TEXT,"
                + COLUMN_FIRSTNAME + "TEXT,"
                + COLUMN_LASTNAME + "TEXT,"
                + COLUMN_PHONE + "INTEGER,"
                + COLUMN_CITY + "TEXT,"
                + COLUMN_NBMUSEUM + "INTEGER,"
                + COLUMN_LEVEL + "INTEGER )";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
    public String loadHandler() {
        String result = "";
        String query = "Select * FROM" + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }
    public void addHandler( Profil profil, String email, String password) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_IMAGE), profil.get
        values.put(COLUMN_LEVEL, profil.getLevel());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public Profil findHandler(String email) {
        String query = "Select * FROM " + TABLE_NAME + "WHERE" + COLUMN_EMAIL + " = " + "'" + email + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Profil profil = new Profil();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            profil.setId(Integer.parseInt(cursor.getString(0)));
            profil.setEmail(cursor.getString(1));
            profil.set
                    (cursor.getString(1));

            cursor.close();
        } else {
            student = null;
        }
        db.close();
        return student;
    }
    public boolean deleteHandler(int ID) {

    }
    public boolean updateHandler(int ID, String name) {

    }
}
