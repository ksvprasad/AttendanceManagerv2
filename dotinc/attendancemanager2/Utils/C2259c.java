package dotinc.attendancemanager2.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import dotinc.attendancemanager2.p045c.C2312b;
import dotinc.attendancemanager2.p045c.C2313c;
import java.util.ArrayList;

public class C2259c extends SQLiteOpenHelper {
    public C2259c(Context context) {
        super(context, "subject_name", null, 2);
    }

    public int m12726a(int i) {
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT past_total_classes FROM Semester_Subjects WHERE subject_id = " + i, null);
        int i2 = 0;
        while (rawQuery.moveToNext()) {
            i2 = rawQuery.getInt(0);
        }
        return i2;
    }

    public ArrayList<C2312b> m12727a() {
        ArrayList<C2312b> arrayList = new ArrayList();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM Semester_Subjects", null);
        if (rawQuery.moveToNext()) {
            do {
                C2312b c2312b = new C2312b();
                c2312b.m12887c(rawQuery.getInt(0));
                c2312b.m12883a(rawQuery.getString(1));
                c2312b.m12885b(rawQuery.getInt(2));
                c2312b.m12882a(rawQuery.getInt(3));
                arrayList.add(c2312b);
            } while (rawQuery.moveToNext());
        }
        writableDatabase.close();
        return arrayList;
    }

    public void m12728a(C2312b c2312b) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("subject_list", c2312b.m12888d());
        writableDatabase.insert("Semester_Subjects", null, contentValues);
        writableDatabase.close();
    }

    public void m12729a(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("DELETE FROM Semester_Subjects WHERE subject_list = '" + str + "'");
        writableDatabase.close();
    }

    public void m12730a(String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("UPDATE Semester_Subjects SET subject_list = '" + str + "' WHERE " + "subject_list" + " = '" + str2 + "'");
        writableDatabase.close();
    }

    public void m12731a(ArrayList<C2312b> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        for (int i = 0; i < arrayList.size(); i++) {
            Log.d("option_attended_past", String.valueOf(((C2312b) arrayList.get(i)).m12884b()));
            String str = "UPDATE Semester_Subjects SET past_total_classes = " + ((C2312b) arrayList.get(i)).m12881a() + " WHERE " + "subject_id" + " = " + ((C2312b) arrayList.get(i)).m12886c();
            String str2 = "UPDATE Semester_Subjects SET past_attended_classes = " + ((C2312b) arrayList.get(i)).m12884b() + " WHERE " + "subject_id" + " = " + ((C2312b) arrayList.get(i)).m12886c();
            writableDatabase.execSQL(str);
            writableDatabase.execSQL(str2);
        }
        writableDatabase.close();
    }

    public int m12732b(int i) {
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT past_attended_classes FROM Semester_Subjects WHERE subject_id = " + i, null);
        int i2 = 0;
        while (rawQuery.moveToNext()) {
            i2 = rawQuery.getInt(0);
        }
        Log.d("option_attende", String.valueOf(i2));
        return i2;
    }

    public ArrayList<C2313c> m12733b() {
        ArrayList<C2313c> arrayList = new ArrayList();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM Semester_Subjects GROUP BY subject_list", null);
        if (rawQuery.moveToNext()) {
            do {
                C2313c c2313c = new C2313c();
                c2313c.m12893b(rawQuery.getInt(0));
                c2313c.m12891a(rawQuery.getString(1));
                arrayList.add(c2313c);
            } while (rawQuery.moveToNext());
        }
        writableDatabase.close();
        return arrayList;
    }

    public void m12734b(ArrayList<String> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < arrayList.size(); i++) {
            contentValues.put("subject_list", (String) arrayList.get(i));
            writableDatabase.insert("Semester_Subjects", null, contentValues);
        }
        writableDatabase.close();
    }

    public void m12735c() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList a = m12727a();
        for (int i = 0; i < a.size(); i++) {
            ((C2312b) a.get(i)).m12882a(0);
            ((C2312b) a.get(i)).m12885b(0);
        }
        m12731a(a);
        writableDatabase.close();
    }

    public boolean m12736d() {
        return C2258b.m12718a("subject_name");
    }

    public boolean m12737e() {
        return C2258b.m12721b("subject_name");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE Semester_Subjects(subject_id INTEGER PRIMARY KEY AUTOINCREMENT,subject_list VARCHAR(30),past_attended_classes INTEGER DEFAULT 0,past_total_classes INTEGER DEFAULT 0);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.d("option_ver_old", String.valueOf(i));
        Log.d("option_ver_new", String.valueOf(i2));
        sQLiteDatabase.execSQL("ALTER TABLE Semester_Subjects ADD COLUMN past_attended_classes INTEGER DEFAULT 0");
        sQLiteDatabase.execSQL("ALTER TABLE Semester_Subjects ADD COLUMN past_total_classes INTEGER DEFAULT 0");
    }
}
