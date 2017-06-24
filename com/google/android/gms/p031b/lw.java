package com.google.android.gms.p031b;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.clearcut.C1854b.C1730b;
import com.google.android.gms.common.internal.C1895b;
import com.google.android.gms.common.internal.C1896c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class lw implements C1730b {
    static Boolean f5823a = null;
    private static final Charset f5824c = Charset.forName("UTF-8");
    final C1728a f5825b;

    static class C1728a {
        final ContentResolver f5819a;

        C1728a(Context context) {
            if (context == null || !C1728a.m9725a(context)) {
                this.f5819a = null;
                return;
            }
            this.f5819a = context.getContentResolver();
            C1541g.m8453b(this.f5819a, "gms:playlog:service:sampling_");
        }

        private static boolean m9725a(Context context) {
            if (lw.f5823a == null) {
                lw.f5823a = Boolean.valueOf(context.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
            }
            return lw.f5823a.booleanValue();
        }

        long m9726a() {
            return this.f5819a == null ? 0 : C1541g.m8447a(this.f5819a, "android_id", 0);
        }

        String m9727a(String str) {
            if (this.f5819a == null) {
                return null;
            }
            ContentResolver contentResolver = this.f5819a;
            String valueOf = String.valueOf("gms:playlog:service:sampling_");
            String valueOf2 = String.valueOf(str);
            return C1541g.m8450a(contentResolver, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), null);
        }
    }

    static class C1729b {
        public final String f5820a;
        public final long f5821b;
        public final long f5822c;

        public C1729b(String str, long j, long j2) {
            this.f5820a = str;
            this.f5821b = j;
            this.f5822c = j2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1729b)) {
                return false;
            }
            C1729b c1729b = (C1729b) obj;
            return C1895b.m10789a(this.f5820a, c1729b.f5820a) && C1895b.m10789a(Long.valueOf(this.f5821b), Long.valueOf(c1729b.f5821b)) && C1895b.m10789a(Long.valueOf(this.f5822c), Long.valueOf(c1729b.f5822c));
        }

        public int hashCode() {
            return C1895b.m10787a(this.f5820a, Long.valueOf(this.f5821b), Long.valueOf(this.f5822c));
        }
    }

    public lw() {
        this(new C1728a(null));
    }

    public lw(Context context) {
        this(new C1728a(context));
    }

    lw(C1728a c1728a) {
        this.f5825b = (C1728a) C1896c.m10790a((Object) c1728a);
    }

    static long m9729a(long j) {
        return lt.m9714a(ByteBuffer.allocate(8).putLong(j).array());
    }

    static long m9730a(String str, long j) {
        if (str == null || str.isEmpty()) {
            return lw.m9729a(j);
        }
        byte[] bytes = str.getBytes(f5824c);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
        allocate.put(bytes);
        allocate.putLong(j);
        return lt.m9714a(allocate.array());
    }

    static C1729b m9731a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        String str2 = "";
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            str2 = str.substring(0, indexOf);
            i = indexOf + 1;
        }
        int indexOf2 = str.indexOf(47, i);
        if (indexOf2 <= 0) {
            str2 = "LogSamplerImpl";
            String str3 = "Failed to parse the rule: ";
            String valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(i, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong >= 0 && parseLong2 >= 0) {
                return new C1729b(str2, parseLong, parseLong2);
            }
            Log.e("LogSamplerImpl", "negative values not supported: " + parseLong + "/" + parseLong2);
            return null;
        } catch (Throwable e) {
            Throwable th = e;
            str3 = "LogSamplerImpl";
            String str4 = "parseLong() failed while parsing: ";
            valueOf = String.valueOf(str);
            Log.e(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4), th);
            return null;
        }
    }

    static boolean m9732a(long j, long j2, long j3) {
        if (j2 >= 0 && j3 >= 0) {
            return j3 > 0 && lx.m9734a(j, j3) < j2;
        } else {
            throw new IllegalArgumentException("negative values not supported: " + j2 + "/" + j3);
        }
    }

    public boolean mo1559a(String str, int i) {
        if (str == null || str.isEmpty()) {
            str = i >= 0 ? String.valueOf(i) : null;
        }
        if (str == null) {
            return true;
        }
        long a = this.f5825b.m9726a();
        C1729b a2 = lw.m9731a(this.f5825b.m9727a(str));
        return a2 != null ? lw.m9732a(lw.m9730a(a2.f5820a, a), a2.f5821b, a2.f5822c) : true;
    }
}
