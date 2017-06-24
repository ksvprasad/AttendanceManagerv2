package com.google.android.gms.common.internal;

import java.util.Iterator;

public class ac {
    private final String f6430a;

    private ac(String str) {
        this.f6430a = str;
    }

    public static ac m10779a(String str) {
        return new ac(str);
    }

    CharSequence m10780a(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String m10781a(Iterable<?> iterable) {
        return m10782a(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder m10782a(StringBuilder stringBuilder, Iterable<?> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            stringBuilder.append(m10780a(it.next()));
            while (it.hasNext()) {
                stringBuilder.append(this.f6430a);
                stringBuilder.append(m10780a(it.next()));
            }
        }
        return stringBuilder;
    }
}
