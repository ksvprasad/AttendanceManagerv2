package com.google.android.gms.p031b;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.C1319u;

@id
public abstract class cl<T> {
    private final int f4344a;
    private final String f4345b;
    private final T f4346c;

    class C14011 extends cl<Boolean> {
        C14011(int i, String str, Boolean bool) {
            super(i, str, bool);
        }

        public /* synthetic */ Object mo1270a(SharedPreferences sharedPreferences) {
            return m7803b(sharedPreferences);
        }

        public Boolean m7803b(SharedPreferences sharedPreferences) {
            return Boolean.valueOf(sharedPreferences.getBoolean(m7799a(), ((Boolean) m7800b()).booleanValue()));
        }
    }

    class C14022 extends cl<Integer> {
        C14022(int i, String str, Integer num) {
            super(i, str, num);
        }

        public /* synthetic */ Object mo1270a(SharedPreferences sharedPreferences) {
            return m7805b(sharedPreferences);
        }

        public Integer m7805b(SharedPreferences sharedPreferences) {
            return Integer.valueOf(sharedPreferences.getInt(m7799a(), ((Integer) m7800b()).intValue()));
        }
    }

    class C14033 extends cl<Long> {
        C14033(int i, String str, Long l) {
            super(i, str, l);
        }

        public /* synthetic */ Object mo1270a(SharedPreferences sharedPreferences) {
            return m7807b(sharedPreferences);
        }

        public Long m7807b(SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(m7799a(), ((Long) m7800b()).longValue()));
        }
    }

    class C14044 extends cl<String> {
        C14044(int i, String str, String str2) {
            super(i, str, str2);
        }

        public /* synthetic */ Object mo1270a(SharedPreferences sharedPreferences) {
            return m7809b(sharedPreferences);
        }

        public String m7809b(SharedPreferences sharedPreferences) {
            return sharedPreferences.getString(m7799a(), (String) m7800b());
        }
    }

    private cl(int i, String str, T t) {
        this.f4344a = i;
        this.f4345b = str;
        this.f4346c = t;
        C1319u.m7191m().m7811a(this);
    }

    public static cl<String> m7792a(int i, String str) {
        cl<String> a = cl.m7796a(i, str, null);
        C1319u.m7191m().m7813b(a);
        return a;
    }

    public static cl<Integer> m7793a(int i, String str, int i2) {
        return new C14022(i, str, Integer.valueOf(i2));
    }

    public static cl<Long> m7794a(int i, String str, long j) {
        return new C14033(i, str, Long.valueOf(j));
    }

    public static cl<Boolean> m7795a(int i, String str, Boolean bool) {
        return new C14011(i, str, bool);
    }

    public static cl<String> m7796a(int i, String str, String str2) {
        return new C14044(i, str, str2);
    }

    public static cl<String> m7797b(int i, String str) {
        cl<String> a = cl.m7796a(i, str, null);
        C1319u.m7191m().m7814c(a);
        return a;
    }

    protected abstract T mo1270a(SharedPreferences sharedPreferences);

    public String m7799a() {
        return this.f4345b;
    }

    public T m7800b() {
        return this.f4346c;
    }

    public T m7801c() {
        return C1319u.m7192n().m7824a(this);
    }
}
