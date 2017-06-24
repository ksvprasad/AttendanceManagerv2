package com.google.android.gms.p031b;

import java.util.Collections;
import java.util.Map;

public interface ar {

    public static class C1369a {
        public byte[] f4163a;
        public String f4164b;
        public long f4165c;
        public long f4166d;
        public long f4167e;
        public long f4168f;
        public Map<String, String> f4169g = Collections.emptyMap();

        public boolean m7516a() {
            return this.f4167e < System.currentTimeMillis();
        }

        public boolean m7517b() {
            return this.f4168f < System.currentTimeMillis();
        }
    }

    C1369a mo1636a(String str);

    void mo1637a();

    void mo1638a(String str, C1369a c1369a);
}
