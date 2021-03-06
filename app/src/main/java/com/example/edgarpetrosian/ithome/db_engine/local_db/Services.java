package com.example.edgarpetrosian.ithome.db_engine.local_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import static com.example.edgarpetrosian.ithome.db_engine.local_db.DB_Constants.DB_TABLE;
import static com.example.edgarpetrosian.ithome.db_engine.local_db.DB_Constants.ID;
import static com.example.edgarpetrosian.ithome.db_engine.local_db.DB_Constants.POSITION;

public class Services extends SQLiteOpenHelper {
    //SQLIte Services
    public Services(Context context) {
        super(context, DB_Constants.DB_NAME, null, DB_Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(

                "CREATE TABLE " + DB_TABLE + " (" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        POSITION + " TEXT NOT NULL); "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        this.onCreate(db);
    }

    //save recyclerView position color
    public void save(Model model) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DB_Constants.POSITION, model.getRecyclerViewPosition());
        db.insert(DB_TABLE, null, cv);
        db.close();
        Log.i("color_posotion",cv.getAsString(POSITION));
    }
    //getAllData
    public List<Model> getAlldata(String filter){
        SQLiteDatabase db=getWritableDatabase();
        String query = "";
        if (filter.equals("")){
            query="SELECT  * FROM "+DB_TABLE;
        }
        List<Model> list=new LinkedList<>();
        Cursor cursor=db.rawQuery(query,null);
        Model model;
        if (cursor.moveToFirst()){
            do {
                model=new Model();
                model.setId(cursor.getInt(cursor.getColumnIndex(ID)));
                model.setRecyclerViewPosition(cursor.getLong(cursor.getColumnIndex(POSITION)));
                list.add(model);
            }while (cursor.moveToNext());
        }
        return list;
    }
}
