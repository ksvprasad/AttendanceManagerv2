package com.google.android.gms.p031b;

import android.os.Binder;

public abstract class ni<T> {
    private static final Object f6052c = new Object();
    private static C1788a f6053d = null;
    private static int f6054e = 0;
    private static String f6055f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String f6056a;
    protected final T f6057b;
    private T f6058g = null;

    class C17841 extends ni<Boolean> {
        C17841(String str, Boolean bool) {
            super(str, bool);
        }

        protected /* synthetic */ Object mo1623a(String str) {
            return m10148b(str);
        }

        protected Boolean m10148b(String str) {
            return null.m10155a(this.a, (Boolean) this.b);
        }
    }

    class C17852 extends ni<Long> {
        C17852(String str, Long l) {
            super(str, l);
        }

        protected /* synthetic */ Object mo1623a(String str) {
            return m10150b(str);
        }

        protected Long m10150b(String str) {
            return null.m10157a(this.a, (Long) this.b);
        }
    }

    class C17863 extends ni<Integer> {
        C17863(String str, Integer num) {
            super(str, num);
        }

        protected /* synthetic */ Object mo1623a(String str) {
            return m10152b(str);
        }

        protected Integer m10152b(String str) {
            return null.m10156a(this.a, (Integer) this.b);
        }
    }

    class C17874 extends ni<String> {
        C17874(String str, String str2) {
            super(str, str2);
        }

        protected /* synthetic */ Object mo1623a(String str) {
            return m10154b(str);
        }

        protected String m10154b(String str) {
            return null.m10158a(this.a, (String) this.b);
        }
    }

    private interface C1788a {
        Boolean m10155a(String str, Boolean bool);

        Integer m10156a(String str, Integer num);

        Long m10157a(String str, Long l);

        String m10158a(String str, String str2);
    }

    protected ni(String str, T t) {
        this.f6056a = str;
        this.f6057b = t;
    }

    public static ni<Integer> m10140a(String str, Integer num) {
        return new C17863(str, num);
    }

    public static ni<Long> m10141a(String str, Long l) {
        return new C17852(str, l);
    }

    public static ni<String> m10142a(String str, String str2) {
        return new C17874(str, str2);
    }

    public static ni<Boolean> m10143a(String str, boolean z) {
        return new C17841(str, Boolean.valueOf(z));
    }

    public final T m10145a() {
        T a;
        long clearCallingIdentity;
        try {
            a = mo1623a(this.f6056a);
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            a = mo1623a(this.f6056a);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return a;
    }

    protected abstract T mo1623a(String str);
}
