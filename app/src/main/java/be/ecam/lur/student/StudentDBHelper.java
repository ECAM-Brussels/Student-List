package be.ecam.lur.student;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import be.ecam.lur.student.StudentContract.*;

/**
 * Created by lur on 13-03-17.
 */

public class StudentDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student.db";

    private static final int DATABASE_VERSION = 1;

    public StudentDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_STUDENT_TABLE = "CREATE TABLE " + StudentEntry.TABLE_NAME + " (" +
                StudentEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                StudentEntry.STUDENT_NAME + " TEXT NOT NULL, " +
                StudentEntry.STUDENT_MATRICULE + " TEXT NOT NULL, " +
                StudentEntry.STUDENT_DIVISION + " TEXT NOT NULL" +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + StudentEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
