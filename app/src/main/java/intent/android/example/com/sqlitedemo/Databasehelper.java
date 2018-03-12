package intent.android.example.com.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

/**
 * Created by tulsi on 3/9/2018.
 */

public class Databasehelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "NewProduct.db";
    public static final String TABLE_NAME = "product_table";
    public static final String COL_1 = "ITEMNAME";
    public static final String COL_2 = "ITEMDESCRIPTION";
    public static final String COL_3 = "ITEMPRICE";
    public static final String COL_4 = "ITEMREVIEW";

    public Databasehelper(Context context) {
        super( context,DATABASE_NAME, null, 1 );

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME  + "(" +
                COL_1 + " TEXT PRIMARY KEY, " +
                COL_2 + " TEXT NOT NULL, " +
                COL_3+ " TEXT NOT NULL, " +
                COL_4 + " TEXT NOT NULL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String itemname, String Itemdescription, String itemprice, String itemreview){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(  );
        contentValues.put(COL_1,itemname );
        contentValues.put(COL_2,Itemdescription );
        contentValues.put(COL_3,itemprice);
        contentValues.put(COL_4,itemreview);
        long result= db.insert(TABLE_NAME,null,contentValues  );
        if(result==-1)
            return false;
        else
            return true;

    }



}
