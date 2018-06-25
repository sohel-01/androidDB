package com.example.macstudent.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.macstudent.sqlite.db.DBHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper mDBHelper = new DBHelper(this);
        SQLiteDatabase mSQLiteDataBase = mDBHelper.getWritableDatabase();

        //Insert Record
        //INSERT INTO tblStudent VALUES(1,"Sohel md")
        ContentValues mContentValues = new ContentValues();
        mContentValues.put("sid",1);
        mContentValues.put("snm","Sohel Md");
        mSQLiteDataBase.insert("tblStudent","null",mContentValues);

       /* //update
        //UPDATE tblStudent snm = "mdsp" WHERE sid = 1
        String studentId = "1";
        ContentValues mContentValuesUpdate = new ContentValues();
        mContentValuesUpdate.put("snm","mdsp");
        mSQLiteDataBase.update("tblDStudent",mContentValuesUpdate,"sid =?",new String[]{studentId} );


        //delete
        //DELETE tblStudent WHERE sid = 1
        mSQLiteDataBase.delete("tblStudent","sid = ?",new String[]{studentId});
        */

        //SELECT Records
        Cursor mCursor = mSQLiteDataBase.query("tblStudent",null,null,null,null,null,null);

        if (mCursor != null){
            if(mCursor.getCount() != 0){
                while (mCursor.moveToNext()){
                    Log.d("DB",mCursor.getInt(0)+mCursor.getString((mCursor.getColumnIndex("snm"))));
                }
            }
        }

    }
}
