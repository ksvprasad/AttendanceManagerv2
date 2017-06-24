package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class C1895b {

    public static final class C1894a {
        private final List<String> f6435a;
        private final Object f6436b;

        private C1894a(Object obj) {
            this.f6436b = C1896c.m10790a(obj);
            this.f6435a = new ArrayList();
        }

        public C1894a m10786a(String str, Object obj) {
            List list = this.f6435a;
            String str2 = (String) C1896c.m10790a((Object) str);
            String valueOf = String.valueOf(String.valueOf(obj));
            list.add(new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f6436b.getClass().getSimpleName()).append('{');
            int size = this.f6435a.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.f6435a.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static int m10787a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static C1894a m10788a(Object obj) {
        return new C1894a(obj);
    }

    public static boolean m10789a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
