package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.id;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@id
public class C1236h {
    private static final String f3661a = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
    private static final Object f3662c = new Object();
    private static C1236h f3663d;
    private final C1235a f3664b;

    public class C1235a extends SQLiteOpenHelper {
        final /* synthetic */ C1236h f3660a;

        public C1235a(C1236h c1236h, Context context, String str) {
            this.f3660a = c1236h;
            super(context, str, null, 4);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(C1236h.f3661a);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            C1324b.m7232c("Database updated from version " + i + " to version " + i2);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(sQLiteDatabase);
        }
    }

    C1236h(Context context) {
        this.f3664b = new C1235a(this, context, "google_inapp_purchase.db");
    }

    public static C1236h m6837a(Context context) {
        C1236h c1236h;
        synchronized (f3662c) {
            if (f3663d == null) {
                f3663d = new C1236h(context);
            }
            c1236h = f3663d;
        }
        return c1236h;
    }

    public SQLiteDatabase m6839a() {
        try {
            return this.f3664b.getWritableDatabase();
        } catch (SQLiteException e) {
            C1324b.m7234d("Error opening writable conversion tracking database");
            return null;
        }
    }

    public C1232f m6840a(Cursor cursor) {
        return cursor == null ? null : new C1232f(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public List<C1232f> m6841a(long j) {
        Cursor query;
        SQLiteException e;
        String str;
        String valueOf;
        Throwable th;
        synchronized (f3662c) {
            List<C1232f> linkedList = new LinkedList();
            if (j <= 0) {
                return linkedList;
            }
            SQLiteDatabase a = m6839a();
            if (a == null) {
                return linkedList;
            }
            try {
                query = a.query("InAppPurchase", null, null, null, null, null, "record_time ASC", String.valueOf(j));
                try {
                    if (query.moveToFirst()) {
                        do {
                            linkedList.add(m6840a(query));
                        } while (query.moveToNext());
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        str = "Error extracing purchase info: ";
                        valueOf = String.valueOf(e.getMessage());
                        C1324b.m7234d(valueOf.length() == 0 ? new String(str) : str.concat(valueOf));
                        if (query != null) {
                            query.close();
                        }
                        return linkedList;
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
                str = "Error extracing purchase info: ";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                C1324b.m7234d(valueOf.length() == 0 ? new String(str) : str.concat(valueOf));
                if (query != null) {
                    query.close();
                }
                return linkedList;
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    public void m6842a(C1232f c1232f) {
        if (c1232f != null) {
            synchronized (f3662c) {
                SQLiteDatabase a = m6839a();
                if (a == null) {
                    return;
                }
                a.delete("InAppPurchase", String.format(Locale.US, "%s = %d", new Object[]{"purchase_id", Long.valueOf(c1232f.f3650a)}), null);
            }
        }
    }

    public int m6843b() {
        Cursor cursor = null;
        int i = 0;
        synchronized (f3662c) {
            SQLiteDatabase a = m6839a();
            if (a == null) {
            } else {
                try {
                    cursor = a.rawQuery("select count(*) from InAppPurchase", null);
                    if (cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } else {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (SQLiteException e) {
                    String str = "Error getting record count";
                    String valueOf = String.valueOf(e.getMessage());
                    C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m6844b(com.google.android.gms.ads.internal.purchase.C1232f r7) {
        /*
        r6 = this;
        if (r7 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r1 = f3662c;
        monitor-enter(r1);
        r0 = r6.m6839a();	 Catch:{ all -> 0x000e }
        if (r0 != 0) goto L_0x0011;
    L_0x000c:
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0002;
    L_0x000e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        throw r0;
    L_0x0011:
        r2 = new android.content.ContentValues;	 Catch:{ all -> 0x000e }
        r2.<init>();	 Catch:{ all -> 0x000e }
        r3 = "product_id";
        r4 = r7.f3652c;	 Catch:{ all -> 0x000e }
        r2.put(r3, r4);	 Catch:{ all -> 0x000e }
        r3 = "developer_payload";
        r4 = r7.f3651b;	 Catch:{ all -> 0x000e }
        r2.put(r3, r4);	 Catch:{ all -> 0x000e }
        r3 = "record_time";
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x000e }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x000e }
        r2.put(r3, r4);	 Catch:{ all -> 0x000e }
        r3 = "InAppPurchase";
        r4 = 0;
        r2 = r0.insert(r3, r4, r2);	 Catch:{ all -> 0x000e }
        r7.f3650a = r2;	 Catch:{ all -> 0x000e }
        r0 = r6.m6843b();	 Catch:{ all -> 0x000e }
        r2 = (long) r0;	 Catch:{ all -> 0x000e }
        r4 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0048;
    L_0x0045:
        r6.m6845c();	 Catch:{ all -> 0x000e }
    L_0x0048:
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0002;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.h.b(com.google.android.gms.ads.internal.purchase.f):void");
    }

    public void m6845c() {
        SQLiteException e;
        String str;
        String valueOf;
        Throwable th;
        synchronized (f3662c) {
            SQLiteDatabase a = m6839a();
            if (a == null) {
                return;
            }
            Cursor query;
            try {
                query = a.query("InAppPurchase", null, null, null, null, null, "record_time ASC", "1");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            m6842a(m6840a(query));
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            str = "Error remove oldest record";
                            valueOf = String.valueOf(e.getMessage());
                            C1324b.m7234d(valueOf.length() == 0 ? new String(str) : str.concat(valueOf));
                            if (query != null) {
                                query.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                str = "Error remove oldest record";
                valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() == 0) {
                }
                C1324b.m7234d(valueOf.length() == 0 ? new String(str) : str.concat(valueOf));
                if (query != null) {
                    query.close();
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
    }
}
