package dotinc.attendancemanager2.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import dotinc.attendancemanager2.p045c.C2311a;
import dotinc.attendancemanager2.p045c.C2313c;
import java.util.ArrayList;

public class C2256a extends SQLiteOpenHelper {
    Context f7739a;

    public C2256a(Context context) {
        super(context, "attendance_track", null, 2);
        this.f7739a = context;
    }

    public int m12699a(int i, String str) {
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT COUNT(action) FROM attendance_tracker WHERE subject_id = " + i + " AND " + "action" + " =1  AND " + "date" + " = '" + str + "'", null);
        if (rawQuery == null) {
            return 0;
        }
        int i2 = 0;
        while (rawQuery.moveToNext()) {
            i2 = rawQuery.getInt(0);
        }
        return i2;
    }

    public int m12700a(String str, int i, int i2) {
        int i3 = 2;
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT * FROM attendance_tracker WHERE date = '" + str + "' AND " + "subject_id" + " = " + i2 + " GROUP BY " + "position", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                if (rawQuery.getInt(3) == i) {
                    i3 = rawQuery.getInt(1);
                }
            }
        }
        return i3;
    }

    public ArrayList<C2311a> m12701a(int i) {
        ArrayList<C2311a> arrayList = new ArrayList();
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT * FROM attendance_tracker WHERE subject_id = " + i + " AND (" + "action" + " =1 OR " + "action" + " =0 OR " + "action" + " =-1)", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                C2311a c2311a = new C2311a();
                c2311a.m12877b(rawQuery.getInt(0));
                c2311a.m12879c(rawQuery.getInt(1));
                c2311a.m12875a(rawQuery.getString(2));
                arrayList.add(c2311a);
            }
        }
        return arrayList;
    }

    public void m12702a() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("attendance_tracker", null, null);
        writableDatabase.close();
    }

    public void m12703a(int i, String str, int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("DELETE FROM attendance_tracker WHERE subject_id = " + i + " AND " + "date" + " = '" + str + "' AND " + "position" + " = " + i2);
        writableDatabase.close();
    }

    public void m12704a(C2311a c2311a) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("subject_id", Integer.valueOf(c2311a.m12876b()));
        contentValues.put("action", Integer.valueOf(c2311a.m12880d()));
        contentValues.put("date", c2311a.m12878c());
        contentValues.put("position", Integer.valueOf(c2311a.m12873a()));
        writableDatabase.insert("attendance_tracker", null, contentValues);
        writableDatabase.close();
    }

    public void m12705a(ArrayList<C2313c> arrayList, int i, String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            contentValues.put("subject_id", Integer.valueOf(((C2313c) arrayList.get(i2)).m12892b()));
            contentValues.put("action", Integer.valueOf(i));
            contentValues.put("date", str);
            contentValues.put("position", Integer.valueOf(((C2313c) arrayList.get(i2)).m12889a()));
            writableDatabase.insert("attendance_tracker", null, contentValues);
        }
        writableDatabase.close();
    }

    public int m12706b(int i) {
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT COUNT(action) FROM attendance_tracker WHERE subject_id = " + i + " AND " + "action" + " =1 ", null);
        if (rawQuery == null) {
            return 0;
        }
        int i2 = 0;
        while (rawQuery.moveToNext()) {
            i2 = rawQuery.getInt(0);
        }
        return i2;
    }

    public int m12707b(int i, String str) {
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT COUNT(action) FROM attendance_tracker WHERE subject_id = " + i + " AND " + "action" + " =0  AND " + "date" + " = '" + str + "'", null);
        if (rawQuery == null) {
            return 0;
        }
        int i2 = 0;
        while (rawQuery.moveToNext()) {
            i2 = rawQuery.getInt(0);
        }
        return i2;
    }

    public boolean m12708b() {
        return C2258b.m12718a("attendance_track");
    }

    public int m12709c(int i) {
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT COUNT(action) FROM attendance_tracker WHERE subject_id = " + i + " AND (" + "action" + " =1 OR " + "action" + "=0)", null);
        if (rawQuery == null) {
            return 0;
        }
        int i2 = 0;
        while (rawQuery.moveToNext()) {
            i2 = rawQuery.getInt(0);
        }
        return i2;
    }

    public int m12710c(int i, String str) {
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT COUNT(action) FROM attendance_tracker WHERE subject_id = " + i + " AND (" + "action" + " =1 OR " + "action" + "=0) AND " + "date" + " = '" + str + "'", null);
        if (rawQuery == null) {
            return 0;
        }
        int i2 = 0;
        while (rawQuery.moveToNext()) {
            i2 = rawQuery.getInt(0);
        }
        return i2;
    }

    public boolean m12711c() {
        return C2258b.m12721b("attendance_track");
    }

    public void m12712d(int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("DELETE FROM attendance_tracker WHERE subject_id = " + i);
        writableDatabase.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE attendance_tracker(subject_id INTEGER ,action INTEGER ,date VARCHAR(50) ,position INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("ALTER TABLE attendance_tracker ADD COLUMN position INTEGER ");
    }
}
