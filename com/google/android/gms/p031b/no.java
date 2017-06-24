package com.google.android.gms.p031b;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class no {
    public static String f6074a = "Volley";
    public static boolean f6075b = Log.isLoggable(f6074a, 2);

    static class C1790a {
        public static final boolean f6071a = no.f6075b;
        private final List<C1789a> f6072b = new ArrayList();
        private boolean f6073c = false;

        private static class C1789a {
            public final String f6068a;
            public final long f6069b;
            public final long f6070c;

            public C1789a(String str, long j, long j2) {
                this.f6068a = str;
                this.f6069b = j;
                this.f6070c = j2;
            }
        }

        C1790a() {
        }

        private long m10164a() {
            if (this.f6072b.size() == 0) {
                return 0;
            }
            return ((C1789a) this.f6072b.get(this.f6072b.size() - 1)).f6070c - ((C1789a) this.f6072b.get(0)).f6070c;
        }

        public synchronized void m10165a(String str) {
            this.f6073c = true;
            if (m10164a() > 0) {
                long j = ((C1789a) this.f6072b.get(0)).f6070c;
                no.m10169b("(%-4d ms) %s", Long.valueOf(r2), str);
                long j2 = j;
                for (C1789a c1789a : this.f6072b) {
                    no.m10169b("(+%-4d) [%2d] %s", Long.valueOf(c1789a.f6070c - j2), Long.valueOf(c1789a.f6069b), c1789a.f6068a);
                    j2 = c1789a.f6070c;
                }
            }
        }

        public synchronized void m10166a(String str, long j) {
            if (this.f6073c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f6072b.add(new C1789a(str, j, SystemClock.elapsedRealtime()));
        }

        protected void finalize() {
            if (!this.f6073c) {
                m10165a("Request on the loose");
                no.m10170c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    public static void m10167a(String str, Object... objArr) {
        if (f6075b) {
            Log.v(f6074a, no.m10171d(str, objArr));
        }
    }

    public static void m10168a(Throwable th, String str, Object... objArr) {
        Log.e(f6074a, no.m10171d(str, objArr), th);
    }

    public static void m10169b(String str, Object... objArr) {
        Log.d(f6074a, no.m10171d(str, objArr));
    }

    public static void m10170c(String str, Object... objArr) {
        Log.e(f6074a, no.m10171d(str, objArr));
    }

    private static String m10171d(String str, Object... objArr) {
        String valueOf;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(no.class)) {
                str2 = stackTrace[i].getClassName();
                str2 = str2.substring(str2.lastIndexOf(46) + 1);
                str2 = str2.substring(str2.lastIndexOf(36) + 1);
                valueOf = String.valueOf(stackTrace[i].getMethodName());
                valueOf = new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append(".").append(valueOf).toString();
                break;
            }
        }
        valueOf = str2;
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), valueOf, str});
    }
}
