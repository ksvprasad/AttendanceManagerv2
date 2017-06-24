package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.support.v4.p015g.C0370a;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.C1841r;
import com.google.android.gms.p031b.C1843s;
import com.google.android.gms.p031b.nv.C1807a;
import com.google.android.gms.p031b.nv.C1808b;
import com.google.android.gms.p031b.nv.C1811e;
import com.google.android.gms.p031b.nx.C1817b;
import com.google.android.gms.p031b.nx.C1818c;
import com.google.android.gms.p031b.nx.C1820e;
import com.google.android.gms.p031b.nx.C1821f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class C2088q extends C2019b {
    private static final Map<String, String> f6972a = new C0370a(16);
    private final C2087c f6973b = new C2087c(this, mo1740q(), m11894B());
    private final C2078i f6974c = new C2078i(mo1739p());

    interface C2036b {
        void mo1750a(C1820e c1820e);

        boolean mo1751a(long j, C1817b c1817b);
    }

    public static class C2086a {
        long f6967a;
        long f6968b;
        long f6969c;
        long f6970d;
    }

    private class C2087c extends SQLiteOpenHelper {
        final /* synthetic */ C2088q f6971a;

        C2087c(C2088q c2088q, Context context, String str) {
            this.f6971a = c2088q;
            super(context, str, null, 1);
        }

        private void m11880a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) {
            if (!m11882a(sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                m11881a(sQLiteDatabase, str, str3, map);
            } catch (SQLiteException e) {
                this.f6971a.mo1746w().m11290f().m11250a("Failed to verify columns on table that was just created", str);
                throw e;
            }
        }

        private void m11881a(SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) {
            Set b = m11883b(sQLiteDatabase, str);
            String[] split = str2.split(",");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str3 = split[i];
                if (b.remove(str3)) {
                    i++;
                } else {
                    throw new SQLiteException(new StringBuilder((String.valueOf(str).length() + 35) + String.valueOf(str3).length()).append("Table ").append(str).append(" is missing required column: ").append(str3).toString());
                }
            }
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (!b.remove(entry.getKey())) {
                        sQLiteDatabase.execSQL((String) entry.getValue());
                    }
                }
            }
            if (!b.isEmpty()) {
                throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 30).append("Table ").append(str).append(" table has extra columns").toString());
            }
        }

        private boolean m11882a(SQLiteDatabase sQLiteDatabase, String str) {
            Cursor query;
            Object e;
            Throwable th;
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        this.f6971a.mo1746w().m11310z().m11251a("Error querying for table", str, e);
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                this.f6971a.mo1746w().m11310z().m11251a("Error querying for table", str, e);
                if (query != null) {
                    query.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        private Set<String> m11883b(SQLiteDatabase sQLiteDatabase, String str) {
            Set<String> hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
            try {
                Collections.addAll(hashSet, rawQuery.getColumnNames());
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (this.f6971a.f6974c.m11707a(this.f6971a.mo1748y().m11826H())) {
                SQLiteDatabase writableDatabase;
                try {
                    writableDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.f6971a.f6974c.m11706a();
                    this.f6971a.mo1746w().m11290f().m11249a("Opening the database failed, dropping and recreating it");
                    this.f6971a.mo1740q().getDatabasePath(this.f6971a.m11894B()).delete();
                    try {
                        writableDatabase = super.getWritableDatabase();
                        this.f6971a.f6974c.m11708b();
                    } catch (SQLiteException e2) {
                        this.f6971a.mo1746w().m11290f().m11250a("Failed to open freshly created database", e2);
                        throw e2;
                    }
                }
                return writableDatabase;
            }
            throw new SQLiteException("Database open failed");
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT >= 9) {
                File file = new File(sQLiteDatabase.getPath());
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            m11880a(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
            m11880a(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
            m11880a(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", C2088q.f6972a);
            m11880a(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
            m11880a(sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
            m11880a(sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", null);
            m11880a(sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
            m11880a(sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
            m11880a(sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        f6972a.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        f6972a.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        f6972a.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        f6972a.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        f6972a.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        f6972a.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        f6972a.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        f6972a.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        f6972a.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        f6972a.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        f6972a.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        f6972a.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        f6972a.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        f6972a.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        f6972a.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        f6972a.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
    }

    C2088q(aj ajVar) {
        super(ajVar);
    }

    private boolean m11885J() {
        return mo1740q().getDatabasePath(m11894B()).exists();
    }

    @TargetApi(11)
    static int m11886a(Cursor cursor, int i) {
        if (VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        return window.isNull(position, i) ? 0 : window.isLong(position, i) ? 1 : window.isFloat(position, i) ? 2 : window.isString(position, i) ? 3 : window.isBlob(position, i) ? 4 : -1;
    }

    private long m11887a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = m11893A().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            mo1746w().m11290f().m11251a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private long m11888a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = m11893A().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            mo1746w().m11290f().m11251a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void m11890a(String str, C1807a c1807a) {
        Object obj = null;
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        C1896c.m10790a((Object) c1807a);
        C1896c.m10790a(c1807a.f6103c);
        C1896c.m10790a(c1807a.f6102b);
        if (c1807a.f6101a == null) {
            mo1746w().m11310z().m11249a("Audience with no ID");
            return;
        }
        int intValue = c1807a.f6101a.intValue();
        for (C1808b c1808b : c1807a.f6103c) {
            if (c1808b.f6105a == null) {
                mo1746w().m11310z().m11251a("Event filter with no ID. Audience definition ignored. appId, audienceId", str, c1807a.f6101a);
                return;
            }
        }
        for (C1811e c1811e : c1807a.f6102b) {
            if (c1811e.f6121a == null) {
                mo1746w().m11310z().m11251a("Property filter with no ID. Audience definition ignored. appId, audienceId", str, c1807a.f6101a);
                return;
            }
        }
        Object obj2 = 1;
        for (C1808b a : c1807a.f6103c) {
            if (!m11891a(str, intValue, a)) {
                obj2 = null;
                break;
            }
        }
        if (obj2 != null) {
            for (C1811e a2 : c1807a.f6102b) {
                if (!m11892a(str, intValue, a2)) {
                    break;
                }
            }
        }
        obj = obj2;
        if (obj == null) {
            m11922b(str, intValue);
        }
    }

    private boolean m11891a(String str, int i, C1808b c1808b) {
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        C1896c.m10790a((Object) c1808b);
        if (TextUtils.isEmpty(c1808b.f6106b)) {
            mo1746w().m11310z().m11251a("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(c1808b.f6105a));
            return false;
        }
        try {
            byte[] bArr = new byte[c1808b.m7349f()];
            C1843s a = C1843s.m10412a(bArr);
            c1808b.mo1231a(a);
            a.m10458b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", c1808b.f6105a);
            contentValues.put("event_name", c1808b.f6106b);
            contentValues.put("data", bArr);
            try {
                if (m11893A().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    mo1746w().m11290f().m11249a("Failed to insert event filter (got -1)");
                }
                return true;
            } catch (SQLiteException e) {
                mo1746w().m11290f().m11250a("Error storing event filter", e);
                return false;
            }
        } catch (IOException e2) {
            mo1746w().m11290f().m11250a("Configuration loss. Failed to serialize event filter", e2);
            return false;
        }
    }

    private boolean m11892a(String str, int i, C1811e c1811e) {
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        C1896c.m10790a((Object) c1811e);
        if (TextUtils.isEmpty(c1811e.f6122b)) {
            mo1746w().m11310z().m11251a("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(c1811e.f6121a));
            return false;
        }
        try {
            byte[] bArr = new byte[c1811e.m7349f()];
            C1843s a = C1843s.m10412a(bArr);
            c1811e.mo1231a(a);
            a.m10458b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", c1811e.f6121a);
            contentValues.put("property_name", c1811e.f6122b);
            contentValues.put("data", bArr);
            try {
                if (m11893A().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                mo1746w().m11290f().m11249a("Failed to insert property filter (got -1)");
                return false;
            } catch (SQLiteException e) {
                mo1746w().m11290f().m11250a("Error storing property filter", e);
                return false;
            }
        } catch (IOException e2) {
            mo1746w().m11290f().m11250a("Configuration loss. Failed to serialize property filter", e2);
            return false;
        }
    }

    SQLiteDatabase m11893A() {
        mo1733j();
        try {
            return this.f6973b.getWritableDatabase();
        } catch (SQLiteException e) {
            mo1746w().m11310z().m11250a("Error opening database", e);
            throw e;
        }
    }

    String m11894B() {
        if (!mo1748y().m11833O()) {
            return mo1748y().m11830L();
        }
        if (mo1748y().m11834P()) {
            return mo1748y().m11830L();
        }
        mo1746w().m11279A().m11249a("Using secondary database");
        return mo1748y().m11831M();
    }

    public String m11895C() {
        Object e;
        Throwable th;
        String str = null;
        Cursor rawQuery;
        try {
            rawQuery = m11893A().rawQuery("select app_id from queue where app_id not in (select app_id from apps where measurement_enabled=0) order by rowid limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo1746w().m11290f().m11250a("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            mo1746w().m11290f().m11250a("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    void m11896D() {
        mo1733j();
        m11273c();
        if (m11885J()) {
            long a = mo1747x().f6775f.m11351a();
            long b = mo1739p().mo1724b();
            if (Math.abs(b - a) > mo1748y().m11839U()) {
                mo1747x().f6775f.m11352a(b);
                m11897E();
            }
        }
    }

    void m11897E() {
        mo1733j();
        m11273c();
        if (m11885J()) {
            int delete = m11893A().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(mo1739p().mo1723a()), String.valueOf(mo1748y().m11838T())});
            if (delete > 0) {
                mo1746w().m11283E().m11250a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public long m11898F() {
        return m11888a("select max(bundle_end_timestamp) from queue", null, 0);
    }

    public long m11899G() {
        return m11888a("select max(timestamp) from raw_events", null, 0);
    }

    public boolean m11900H() {
        return m11887a("select count(1) > 0 from raw_events", null) != 0;
    }

    public C2086a m11901a(long j, String str, boolean z, boolean z2, boolean z3) {
        Object e;
        Throwable th;
        C1896c.m10792a(str);
        mo1733j();
        m11273c();
        String[] strArr = new String[]{str};
        C2086a c2086a = new C2086a();
        Cursor query;
        try {
            SQLiteDatabase A = m11893A();
            query = A.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        c2086a.f6968b = query.getLong(1);
                        c2086a.f6967a = query.getLong(2);
                        c2086a.f6969c = query.getLong(3);
                        c2086a.f6970d = query.getLong(4);
                    }
                    c2086a.f6968b++;
                    if (z) {
                        c2086a.f6967a++;
                    }
                    if (z2) {
                        c2086a.f6969c++;
                    }
                    if (z3) {
                        c2086a.f6970d++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(c2086a.f6967a));
                    contentValues.put("daily_events_count", Long.valueOf(c2086a.f6968b));
                    contentValues.put("daily_conversions_count", Long.valueOf(c2086a.f6969c));
                    contentValues.put("daily_error_events_count", Long.valueOf(c2086a.f6970d));
                    A.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return c2086a;
                }
                mo1746w().m11310z().m11250a("Not updating daily counts, app is not known", str);
                if (query != null) {
                    query.close();
                }
                return c2086a;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo1746w().m11290f().m11250a("Error updating daily counts", e);
                    if (query != null) {
                        query.close();
                    }
                    return c2086a;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            mo1746w().m11290f().m11250a("Error updating daily counts", e);
            if (query != null) {
                query.close();
            }
            return c2086a;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public C2092u m11902a(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        C1896c.m10792a(str);
        C1896c.m10792a(str2);
        mo1733j();
        m11273c();
        try {
            Cursor query = m11893A().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    C2092u c2092u = new C2092u(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        mo1746w().m11290f().m11249a("Got multiple records for event aggregates, expected one");
                    }
                    if (query == null) {
                        return c2092u;
                    }
                    query.close();
                    return c2092u;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    mo1746w().m11290f().m11252a("Error querying events", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            mo1746w().m11290f().m11252a("Error querying events", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public List<C2081l> m11903a(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        C1896c.m10792a(str);
        mo1733j();
        m11273c();
        List<C2081l> arrayList = new ArrayList();
        try {
            Cursor query = m11893A().query("user_attributes", new String[]{"name", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(mo1748y().m11825G()));
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        long j = query.getLong(1);
                        Object b = m11920b(query, 2);
                        if (b == null) {
                            mo1746w().m11290f().m11249a("Read invalid user property value, ignoring it");
                        } else {
                            arrayList.add(new C2081l(str, string, j, b));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                mo1746w().m11290f().m11251a("Error querying user properties", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public List<Pair<C1820e, Long>> m11904a(String str, int i, int i2) {
        Object e;
        Cursor cursor;
        Throwable th;
        boolean z = true;
        mo1733j();
        m11273c();
        C1896c.m10798b(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        C1896c.m10798b(z);
        C1896c.m10792a(str);
        Cursor query;
        List<Pair<C1820e, Long>> emptyList;
        try {
            query = m11893A().query("queue", new String[]{"rowid", "data"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    List<Pair<C1820e, Long>> arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j = query.getLong(0);
                        int length;
                        try {
                            byte[] b = mo1742s().m11778b(query.getBlob(1));
                            if (!arrayList.isEmpty() && b.length + i3 > i2) {
                                break;
                            }
                            C1841r a = C1841r.m10379a(b);
                            C1820e c1820e = new C1820e();
                            try {
                                C1820e c1820e2 = (C1820e) c1820e.mo1234b(a);
                                length = b.length + i3;
                                arrayList.add(Pair.create(c1820e, Long.valueOf(j)));
                            } catch (IOException e2) {
                                mo1746w().m11290f().m11251a("Failed to merge queued bundle", str, e2);
                                length = i3;
                            }
                            if (!query.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e22) {
                            mo1746w().m11290f().m11251a("Failed to unzip queued bundle", str, e22);
                            length = i3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                emptyList = Collections.emptyList();
                if (query == null) {
                    return emptyList;
                }
                query.close();
                return emptyList;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                mo1746w().m11290f().m11251a("Error querying bundles", str, e);
                emptyList = Collections.emptyList();
                if (cursor == null) {
                    return emptyList;
                }
                cursor.close();
                return emptyList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void m11905a(long j) {
        mo1733j();
        m11273c();
        if (m11893A().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            mo1746w().m11290f().m11249a("Deleted fewer rows from queue than expected");
        }
    }

    void m11906a(ContentValues contentValues, String str, Object obj) {
        C1896c.m10792a(str);
        C1896c.m10790a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public void m11907a(C1820e c1820e) {
        mo1733j();
        m11273c();
        C1896c.m10790a((Object) c1820e);
        C1896c.m10792a(c1820e.f6180o);
        C1896c.m10790a(c1820e.f6171f);
        m11896D();
        long a = mo1739p().mo1723a();
        if (c1820e.f6171f.longValue() < a - mo1748y().m11838T() || c1820e.f6171f.longValue() > mo1748y().m11838T() + a) {
            mo1746w().m11310z().m11251a("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(a), c1820e.f6171f);
        }
        try {
            byte[] bArr = new byte[c1820e.m7349f()];
            C1843s a2 = C1843s.m10412a(bArr);
            c1820e.mo1231a(a2);
            a2.m10458b();
            bArr = mo1742s().m11774a(bArr);
            mo1746w().m11283E().m11250a("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", c1820e.f6180o);
            contentValues.put("bundle_end_timestamp", c1820e.f6171f);
            contentValues.put("data", bArr);
            try {
                if (m11893A().insert("queue", null, contentValues) == -1) {
                    mo1746w().m11290f().m11249a("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                mo1746w().m11290f().m11250a("Error storing bundle", e);
            }
        } catch (IOException e2) {
            mo1746w().m11290f().m11250a("Data loss. Failed to serialize bundle", e2);
        }
    }

    public void m11908a(C2016a c2016a) {
        C1896c.m10790a((Object) c2016a);
        mo1733j();
        m11273c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c2016a.m11206b());
        contentValues.put("app_instance_id", c2016a.m11209c());
        contentValues.put("gmp_app_id", c2016a.m11212d());
        contentValues.put("resettable_device_id_hash", c2016a.m11215e());
        contentValues.put("last_bundle_index", Long.valueOf(c2016a.m11236o()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(c2016a.m11221g()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(c2016a.m11223h()));
        contentValues.put("app_version", c2016a.m11225i());
        contentValues.put("app_store", c2016a.m11229k());
        contentValues.put("gmp_version", Long.valueOf(c2016a.m11231l()));
        contentValues.put("dev_cert_hash", Long.valueOf(c2016a.m11233m()));
        contentValues.put("measurement_enabled", Boolean.valueOf(c2016a.m11235n()));
        contentValues.put("day", Long.valueOf(c2016a.m11240s()));
        contentValues.put("daily_public_events_count", Long.valueOf(c2016a.m11241t()));
        contentValues.put("daily_events_count", Long.valueOf(c2016a.m11242u()));
        contentValues.put("daily_conversions_count", Long.valueOf(c2016a.m11243v()));
        contentValues.put("config_fetched_time", Long.valueOf(c2016a.m11237p()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(c2016a.m11238q()));
        contentValues.put("app_version_int", Long.valueOf(c2016a.m11227j()));
        contentValues.put("firebase_instance_id", c2016a.m11218f());
        contentValues.put("daily_error_events_count", Long.valueOf(c2016a.m11244w()));
        try {
            if (m11893A().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                mo1746w().m11290f().m11249a("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            mo1746w().m11290f().m11250a("Error storing app", e);
        }
    }

    public void m11909a(C2091t c2091t, long j) {
        mo1733j();
        m11273c();
        C1896c.m10790a((Object) c2091t);
        C1896c.m10792a(c2091t.f6979a);
        C1817b c1817b = new C1817b();
        c1817b.f6150d = Long.valueOf(c2091t.f6983e);
        c1817b.f6147a = new C1818c[c2091t.f6984f.m11198a()];
        Iterator it = c2091t.f6984f.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            C1818c c1818c = new C1818c();
            int i2 = i + 1;
            c1817b.f6147a[i] = c1818c;
            c1818c.f6153a = str;
            mo1742s().m11764a(c1818c, c2091t.f6984f.m11199a(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[c1817b.m7349f()];
            C1843s a = C1843s.m10412a(bArr);
            c1817b.mo1231a(a);
            a.m10458b();
            mo1746w().m11283E().m11251a("Saving event, name, data size", c2091t.f6980b, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", c2091t.f6979a);
            contentValues.put("name", c2091t.f6980b);
            contentValues.put("timestamp", Long.valueOf(c2091t.f6982d));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            try {
                if (m11893A().insert("raw_events", null, contentValues) == -1) {
                    mo1746w().m11290f().m11249a("Failed to insert raw event (got -1)");
                }
            } catch (SQLiteException e) {
                mo1746w().m11290f().m11250a("Error storing raw event", e);
            }
        } catch (IOException e2) {
            mo1746w().m11290f().m11250a("Data loss. Failed to serialize event params/data", e2);
        }
    }

    public void m11910a(C2092u c2092u) {
        C1896c.m10790a((Object) c2092u);
        mo1733j();
        m11273c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c2092u.f6985a);
        contentValues.put("name", c2092u.f6986b);
        contentValues.put("lifetime_count", Long.valueOf(c2092u.f6987c));
        contentValues.put("current_bundle_count", Long.valueOf(c2092u.f6988d));
        contentValues.put("last_fire_timestamp", Long.valueOf(c2092u.f6989e));
        try {
            if (m11893A().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                mo1746w().m11290f().m11249a("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            mo1746w().m11290f().m11250a("Error storing event aggregates", e);
        }
    }

    public void m11911a(String str, int i) {
        C1896c.m10792a(str);
        mo1733j();
        m11273c();
        try {
            m11893A().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            mo1746w().m11290f().m11251a("Error pruning currencies", str, e);
        }
    }

    void m11912a(String str, int i, C1821f c1821f) {
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        C1896c.m10790a((Object) c1821f);
        try {
            byte[] bArr = new byte[c1821f.m7349f()];
            C1843s a = C1843s.m10412a(bArr);
            c1821f.mo1231a(a);
            a.m10458b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (m11893A().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    mo1746w().m11290f().m11249a("Failed to insert filter results (got -1)");
                }
            } catch (SQLiteException e) {
                mo1746w().m11290f().m11250a("Error storing filter results", e);
            }
        } catch (IOException e2) {
            mo1746w().m11290f().m11250a("Configuration loss. Failed to serialize filter results", e2);
        }
    }

    public void m11913a(String str, long j, C2036b c2036b) {
        Cursor cursor;
        Object e;
        Throwable th;
        Cursor cursor2 = null;
        C1896c.m10790a((Object) c2036b);
        mo1733j();
        m11273c();
        try {
            Object string;
            String str2;
            SQLiteDatabase A = m11893A();
            String string2;
            if (TextUtils.isEmpty(str)) {
                cursor2 = A.rawQuery("select app_id, metadata_fingerprint from raw_events where app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", new String[]{String.valueOf(j)});
                if (cursor2.moveToFirst()) {
                    string = cursor2.getString(0);
                    string2 = cursor2.getString(1);
                    cursor2.close();
                    str2 = string2;
                    cursor = cursor2;
                } else if (cursor2 != null) {
                    cursor2.close();
                    return;
                } else {
                    return;
                }
            }
            cursor2 = A.rawQuery("select metadata_fingerprint from raw_events where app_id = ? order by rowid limit 1;", new String[]{str});
            if (cursor2.moveToFirst()) {
                string2 = cursor2.getString(0);
                cursor2.close();
                str2 = string2;
                cursor = cursor2;
            } else if (cursor2 != null) {
                cursor2.close();
                return;
            } else {
                return;
            }
            try {
                cursor = A.query("raw_events_metadata", new String[]{"metadata"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", "2");
                if (cursor.moveToFirst()) {
                    C1841r a = C1841r.m10379a(cursor.getBlob(0));
                    C1820e c1820e = new C1820e();
                    try {
                        C1820e c1820e2 = (C1820e) c1820e.mo1234b(a);
                        if (cursor.moveToNext()) {
                            mo1746w().m11310z().m11249a("Get multiple raw event metadata records, expected one");
                        }
                        cursor.close();
                        c2036b.mo1750a(c1820e);
                        cursor2 = A.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", null);
                        if (cursor2.moveToFirst()) {
                            do {
                                long j2 = cursor2.getLong(0);
                                C1841r a2 = C1841r.m10379a(cursor2.getBlob(3));
                                C1817b c1817b = new C1817b();
                                try {
                                    C1817b c1817b2 = (C1817b) c1817b.mo1234b(a2);
                                    c1817b.f6148b = cursor2.getString(1);
                                    c1817b.f6149c = Long.valueOf(cursor2.getLong(2));
                                    if (!c2036b.mo1751a(j2, c1817b)) {
                                        if (cursor2 != null) {
                                            cursor2.close();
                                            return;
                                        }
                                        return;
                                    }
                                } catch (IOException e2) {
                                    try {
                                        mo1746w().m11290f().m11251a("Data loss. Failed to merge raw event", string, e2);
                                    } catch (SQLiteException e3) {
                                        e = e3;
                                    }
                                }
                            } while (cursor2.moveToNext());
                            if (cursor2 != null) {
                                cursor2.close();
                                return;
                            }
                            return;
                        }
                        mo1746w().m11310z().m11249a("Raw event data disappeared while in transaction");
                        if (cursor2 != null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    } catch (IOException e22) {
                        mo1746w().m11290f().m11251a("Data loss. Failed to merge raw event metadata", string, e22);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
                mo1746w().m11290f().m11249a("Raw event metadata record is missing");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor2 = cursor;
                try {
                    mo1746w().m11290f().m11250a("Data loss. Error selecting raw event", e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e32) {
            e = e32;
        } catch (Throwable th4) {
            th = th4;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void m11914a(String str, byte[] bArr) {
        C1896c.m10792a(str);
        mo1733j();
        m11273c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) m11893A().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                mo1746w().m11290f().m11249a("Failed to update remote config (got 0)");
            }
        } catch (SQLiteException e) {
            mo1746w().m11290f().m11250a("Error storing remote config", e);
        }
    }

    void m11915a(String str, C1807a[] c1807aArr) {
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        C1896c.m10790a((Object) c1807aArr);
        SQLiteDatabase A = m11893A();
        A.beginTransaction();
        try {
            m11930e(str);
            for (C1807a a : c1807aArr) {
                m11890a(str, a);
            }
            A.setTransactionSuccessful();
        } finally {
            A.endTransaction();
        }
    }

    public void m11916a(List<Long> list) {
        C1896c.m10790a((Object) list);
        mo1733j();
        m11273c();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long) list.get(i)).longValue());
        }
        stringBuilder.append(")");
        int delete = m11893A().delete("raw_events", stringBuilder.toString(), null);
        if (delete != list.size()) {
            mo1746w().m11290f().m11251a("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public boolean m11917a(C2081l c2081l) {
        C1896c.m10790a((Object) c2081l);
        mo1733j();
        m11273c();
        if (m11925c(c2081l.f6961a, c2081l.f6962b) == null) {
            if (C2082m.m11751a(c2081l.f6962b)) {
                if (m11887a("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{c2081l.f6961a}) >= ((long) mo1748y().m11824F())) {
                    return false;
                }
            }
            if (m11887a("select count(1) from user_attributes where app_id=?", new String[]{c2081l.f6961a}) >= ((long) mo1748y().m11825G())) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c2081l.f6961a);
        contentValues.put("name", c2081l.f6962b);
        contentValues.put("set_timestamp", Long.valueOf(c2081l.f6963c));
        m11906a(contentValues, "value", c2081l.f6964d);
        try {
            if (m11893A().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                mo1746w().m11290f().m11249a("Failed to insert/update user property (got -1)");
            }
        } catch (SQLiteException e) {
            mo1746w().m11290f().m11250a("Error storing user property", e);
        }
        return true;
    }

    public long m11918b(C1820e c1820e) {
        mo1733j();
        m11273c();
        C1896c.m10790a((Object) c1820e);
        C1896c.m10792a(c1820e.f6180o);
        try {
            byte[] bArr = new byte[c1820e.m7349f()];
            C1843s a = C1843s.m10412a(bArr);
            c1820e.mo1231a(a);
            a.m10458b();
            long d = mo1742s().m11782d(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", c1820e.f6180o);
            contentValues.put("metadata_fingerprint", Long.valueOf(d));
            contentValues.put("metadata", bArr);
            try {
                m11893A().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return d;
            } catch (SQLiteException e) {
                mo1746w().m11290f().m11250a("Error storing raw event metadata", e);
                throw e;
            }
        } catch (IOException e2) {
            mo1746w().m11290f().m11250a("Data loss. Failed to serialize event metadata", e2);
            throw e2;
        }
    }

    public C2016a m11919b(String str) {
        Cursor query;
        Object e;
        Throwable th;
        C1896c.m10792a(str);
        mo1733j();
        m11273c();
        try {
            query = m11893A().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    C2016a c2016a = new C2016a(this.n, str);
                    c2016a.m11204a(query.getString(0));
                    c2016a.m11208b(query.getString(1));
                    c2016a.m11211c(query.getString(2));
                    c2016a.m11219f(query.getLong(3));
                    c2016a.m11203a(query.getLong(4));
                    c2016a.m11207b(query.getLong(5));
                    c2016a.m11217e(query.getString(6));
                    c2016a.m11220f(query.getString(7));
                    c2016a.m11213d(query.getLong(8));
                    c2016a.m11216e(query.getLong(9));
                    c2016a.m11205a((query.isNull(10) ? 1 : query.getInt(10)) != 0);
                    c2016a.m11226i(query.getLong(11));
                    c2016a.m11228j(query.getLong(12));
                    c2016a.m11230k(query.getLong(13));
                    c2016a.m11232l(query.getLong(14));
                    c2016a.m11222g(query.getLong(15));
                    c2016a.m11224h(query.getLong(16));
                    c2016a.m11210c(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                    c2016a.m11214d(query.getString(18));
                    c2016a.m11234m(query.getLong(19));
                    c2016a.m11202a();
                    if (query.moveToNext()) {
                        mo1746w().m11290f().m11249a("Got multiple records for app, expected one");
                    }
                    if (query == null) {
                        return c2016a;
                    }
                    query.close();
                    return c2016a;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo1746w().m11290f().m11251a("Error querying app", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            mo1746w().m11290f().m11251a("Error querying app", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Object m11920b(Cursor cursor, int i) {
        int a = C2088q.m11886a(cursor, i);
        switch (a) {
            case 0:
                mo1746w().m11290f().m11249a("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                mo1746w().m11290f().m11249a("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                mo1746w().m11290f().m11250a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(a));
                return null;
        }
    }

    public String m11921b(long j) {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        mo1733j();
        m11273c();
        try {
            rawQuery = m11893A().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else {
                    mo1746w().m11283E().m11249a("No expired configs for apps with pending events");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo1746w().m11290f().m11250a("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = str;
            mo1746w().m11290f().m11250a("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = str;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    void m11922b(String str, int i) {
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        SQLiteDatabase A = m11893A();
        A.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        A.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }

    public void m11923b(String str, String str2) {
        C1896c.m10792a(str);
        C1896c.m10792a(str2);
        mo1733j();
        m11273c();
        try {
            mo1746w().m11283E().m11250a("Deleted user attribute rows:", Integer.valueOf(m11893A().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            mo1746w().m11290f().m11252a("Error deleting user attribute", str, str2, e);
        }
    }

    public long m11924c(String str) {
        C1896c.m10792a(str);
        mo1733j();
        m11273c();
        try {
            SQLiteDatabase A = m11893A();
            String valueOf = String.valueOf(mo1748y().m11859f(str));
            return (long) A.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            mo1746w().m11290f().m11250a("Error deleting over the limit events", e);
            return 0;
        }
    }

    public C2081l m11925c(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        C1896c.m10792a(str);
        C1896c.m10792a(str2);
        mo1733j();
        m11273c();
        try {
            Cursor query = m11893A().query("user_attributes", new String[]{"set_timestamp", "value"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    C2081l c2081l = new C2081l(str, str2, query.getLong(0), m11920b(query, 1));
                    if (query.moveToNext()) {
                        mo1746w().m11290f().m11249a("Got multiple records for user property, expected one");
                    }
                    if (query == null) {
                        return c2081l;
                    }
                    query.close();
                    return c2081l;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    mo1746w().m11290f().m11252a("Error querying user property", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            mo1746w().m11290f().m11252a("Error querying user property", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    Map<Integer, List<C1808b>> m11926d(String str, String str2) {
        Object e;
        Throwable th;
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        C1896c.m10792a(str2);
        Map<Integer, List<C1808b>> c0370a = new C0370a();
        Cursor query;
        try {
            query = m11893A().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    try {
                        C1841r a = C1841r.m10379a(query.getBlob(1));
                        C1808b c1808b = new C1808b();
                        try {
                            C1808b c1808b2 = (C1808b) c1808b.mo1234b(a);
                            int i = query.getInt(0);
                            List list = (List) c0370a.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                c0370a.put(Integer.valueOf(i), list);
                            }
                            list.add(c1808b);
                        } catch (IOException e2) {
                            mo1746w().m11290f().m11251a("Failed to merge filter", str, e2);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return c0370a;
            }
            Map<Integer, List<C1808b>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                mo1746w().m11290f().m11250a("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public byte[] m11927d(String str) {
        Cursor query;
        Object e;
        Throwable th;
        C1896c.m10792a(str);
        mo1733j();
        m11273c();
        try {
            query = m11893A().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        mo1746w().m11290f().m11249a("Got multiple records for app config, expected one");
                    }
                    if (query == null) {
                        return blob;
                    }
                    query.close();
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo1746w().m11290f().m11251a("Error querying remote config", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            mo1746w().m11290f().m11251a("Error querying remote config", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Map<Integer, List<C1811e>> m11928e(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        C1896c.m10792a(str2);
        Map<Integer, List<C1811e>> c0370a = new C0370a();
        try {
            query = m11893A().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    try {
                        C1841r a = C1841r.m10379a(query.getBlob(1));
                        C1811e c1811e = new C1811e();
                        try {
                            C1811e c1811e2 = (C1811e) c1811e.mo1234b(a);
                            int i = query.getInt(0);
                            List list = (List) c0370a.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                c0370a.put(Integer.valueOf(i), list);
                            }
                            list.add(c1811e);
                        } catch (IOException e2) {
                            mo1746w().m11290f().m11251a("Failed to merge filter", str, e2);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return c0370a;
            }
            Map<Integer, List<C1811e>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                mo1746w().m11290f().m11250a("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    protected void mo1730e() {
    }

    void m11930e(String str) {
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        SQLiteDatabase A = m11893A();
        A.delete("property_filters", "app_id=?", new String[]{str});
        A.delete("event_filters", "app_id=?", new String[]{str});
    }

    Map<Integer, C1821f> m11931f(String str) {
        Cursor query;
        Object e;
        Cursor cursor;
        Throwable th;
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        try {
            query = m11893A().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    Map<Integer, C1821f> c0370a = new C0370a();
                    do {
                        int i = query.getInt(0);
                        C1841r a = C1841r.m10379a(query.getBlob(1));
                        C1821f c1821f = new C1821f();
                        try {
                            C1821f c1821f2 = (C1821f) c1821f.mo1234b(a);
                            c0370a.put(Integer.valueOf(i), c1821f);
                        } catch (IOException e2) {
                            mo1746w().m11290f().m11252a("Failed to merge filter results. appId, audienceId, error", str, Integer.valueOf(i), e2);
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return c0370a;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                mo1746w().m11290f().m11250a("Database error querying filter results", e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void m11932f() {
        m11273c();
        m11893A().beginTransaction();
    }

    public void m11933g() {
        m11273c();
        m11893A().setTransactionSuccessful();
    }

    void m11934g(String str) {
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        try {
            SQLiteDatabase A = m11893A();
            String[] strArr = new String[]{str};
            int delete = A.delete("audience_filter_values", "app_id=?", strArr) + (((((((A.delete("events", "app_id=?", strArr) + 0) + A.delete("user_attributes", "app_id=?", strArr)) + A.delete("apps", "app_id=?", strArr)) + A.delete("raw_events", "app_id=?", strArr)) + A.delete("raw_events_metadata", "app_id=?", strArr)) + A.delete("event_filters", "app_id=?", strArr)) + A.delete("property_filters", "app_id=?", strArr));
            if (delete > 0) {
                mo1746w().m11283E().m11251a("Deleted application data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            mo1746w().m11290f().m11251a("Error deleting application data. appId, error", str, e);
        }
    }

    public void m11935h(String str) {
        try {
            m11893A().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            mo1746w().m11290f().m11250a("Failed to remove unused event metadata", e);
        }
    }

    public long m11936i(String str) {
        C1896c.m10792a(str);
        return m11888a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public void m11937z() {
        m11273c();
        m11893A().endTransaction();
    }
}
