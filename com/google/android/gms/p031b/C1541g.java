package com.google.android.gms.p031b;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class C1541g {
    public static final Uri f4895a = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri f4896b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern f4897c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern f4898d = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    static HashMap<String, String> f4899e;
    static HashSet<String> f4900f = new HashSet();
    private static Object f4901g;

    class C15401 extends Thread {
        final /* synthetic */ ContentResolver f4894a;

        C15401(String str, ContentResolver contentResolver) {
            this.f4894a = contentResolver;
            super(str);
        }

        public void run() {
            Looper.prepare();
            this.f4894a.registerContentObserver(C1541g.f4895a, true, new ContentObserver(this, new Handler(Looper.myLooper())) {
                final /* synthetic */ C15401 f4893a;

                public void onChange(boolean z) {
                    synchronized (C1541g.class) {
                        C1541g.f4899e.clear();
                        C1541g.f4901g = new Object();
                        if (!C1541g.f4900f.isEmpty()) {
                            C1541g.m8453b(this.f4893a.f4894a, (String[]) C1541g.f4900f.toArray(new String[C1541g.f4900f.size()]));
                        }
                    }
                }
            });
            Looper.loop();
        }
    }

    public static long m8447a(ContentResolver contentResolver, String str, long j) {
        String a = C1541g.m8449a(contentResolver, str);
        if (a != null) {
            try {
                j = Long.parseLong(a);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public static String m8449a(ContentResolver contentResolver, String str) {
        return C1541g.m8450a(contentResolver, str, null);
    }

    public static String m8450a(ContentResolver contentResolver, String str, String str2) {
        synchronized (C1541g.class) {
            C1541g.m8452a(contentResolver);
            Object obj = f4901g;
            String str3;
            if (f4899e.containsKey(str)) {
                str3 = (String) f4899e.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            } else {
                Iterator it = f4900f.iterator();
                while (it.hasNext()) {
                    if (str.startsWith((String) it.next())) {
                        break;
                    }
                }
                Cursor query = contentResolver.query(f4895a, null, null, new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str3 = query.getString(1);
                            synchronized (C1541g.class) {
                                if (obj == f4901g) {
                                    f4899e.put(str, str3);
                                }
                            }
                            if (str3 != null) {
                                str2 = str3;
                            }
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                    }
                }
                f4899e.put(str, null);
                if (query != null) {
                    query.close();
                }
            }
        }
        return str2;
    }

    public static Map<String, String> m8451a(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(f4896b, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return treeMap;
    }

    private static void m8452a(ContentResolver contentResolver) {
        if (f4899e == null) {
            f4899e = new HashMap();
            f4901g = new Object();
            new C15401("Gservices", contentResolver).start();
        }
    }

    public static void m8453b(ContentResolver contentResolver, String... strArr) {
        Map a = C1541g.m8451a(contentResolver, strArr);
        synchronized (C1541g.class) {
            C1541g.m8452a(contentResolver);
            f4900f.addAll(Arrays.asList(strArr));
            for (Entry entry : a.entrySet()) {
                f4899e.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }
}
