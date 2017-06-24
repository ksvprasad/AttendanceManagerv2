package dotinc.attendancemanager2.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import dotinc.attendancemanager2.p045c.C2313c;
import java.util.ArrayList;

public class C2260d extends SQLiteOpenHelper {
    Context f7746a;

    public C2260d(Context context) {
        super(context, "timetable_database", null, 2);
        this.f7746a = context;
    }

    public int m12738a() {
        return getWritableDatabase().rawQuery("SELECT * FROM timetable", null).getCount() != 0 ? 1 : 0;
    }

    public void m12739a(int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("DELETE FROM timetable WHERE subject_id = " + i);
        writableDatabase.close();
    }

    public void m12740a(C2313c c2313c) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("subject_id", Integer.valueOf(c2313c.m12892b()));
        contentValues.put("day_code", Integer.valueOf(c2313c.m12896d()));
        contentValues.put("subjects_selected", c2313c.m12894c());
        contentValues.put("position", Integer.valueOf(c2313c.m12889a()));
        writableDatabase.insert("timetable", null, contentValues);
        writableDatabase.close();
    }

    public void m12741a(String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("UPDATE timetable SET subjects_selected = '" + str + "' WHERE " + "subjects_selected" + " = '" + str2 + "'");
        writableDatabase.close();
    }

    public ArrayList<C2313c> m12742b(C2313c c2313c) {
        ArrayList<C2313c> arrayList = new ArrayList();
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT * FROM timetable WHERE day_code = " + c2313c.m12896d(), null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                C2313c c2313c2 = new C2313c();
                c2313c2.m12893b(rawQuery.getInt(0));
                c2313c2.m12895c(rawQuery.getInt(1));
                c2313c2.m12891a(rawQuery.getString(2));
                c2313c2.m12890a(rawQuery.getInt(3));
                arrayList.add(c2313c2);
            }
        }
        return arrayList;
    }

    public boolean m12743b() {
        return C2258b.m12718a("timetable_database");
    }

    public void m12744c(C2313c c2313c) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("DELETE FROM timetable WHERE subject_id = " + c2313c.m12892b() + " and " + "subjects_selected" + " = '" + c2313c.m12894c() + "' and " + "position" + " = " + c2313c.m12889a() + " and " + "day_code" + " = " + c2313c.m12896d());
        writableDatabase.close();
    }

    public boolean m12745c() {
        return C2258b.m12721b("timetable_database");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE timetable(subject_id INTEGER ,day_code INTEGER ,subjects_selected VARCHAR(30) ,position INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("ALTER TABLE timetable ADD COLUMN position INTEGER ");
    }
}
