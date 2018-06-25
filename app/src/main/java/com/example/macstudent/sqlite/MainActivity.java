package com.example.macstudent.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macstudent.sqlite.db.DBHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtLable)
    TextView txtLable;
    @BindView(R.id.imgText)
    ImageView imgText;
    @BindView(R.id.btnSignUp)
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DBHelper mDBHelper = new DBHelper(this);
        SQLiteDatabase mSQLiteDataBase = mDBHelper.getWritableDatabase();

        //Insert Record
        //INSERT INTO tblStudent VALUES(1,"Sohel md")
        ContentValues mContentValues = new ContentValues();
        mContentValues.put("sid", 1);
        mContentValues.put("snm", "Sohel Md");
        mSQLiteDataBase.insert("tblStudent", "null", mContentValues);

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
        Cursor mCursor = mSQLiteDataBase.query("tblStudent", null, null, null, null, null, null);

        if (mCursor != null) {
            if (mCursor.getCount() != 0) {
                while (mCursor.moveToNext()) {
                    Log.d("DB", mCursor.getInt(0) + mCursor.getString((mCursor.getColumnIndex("snm"))));
                }
            }
        }
mSQLiteDataBase.close();
    }
    @OnClick(R.id.btnSubmit)
    public void onViewClicked(){

    }
}
