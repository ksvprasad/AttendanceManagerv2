package com.google.android.gms.common.util;

import android.support.v4.p015g.C0370a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class C1971d {
    public static <T> List<T> m11075a(T t) {
        return Collections.singletonList(t);
    }

    public static <K, V> Map<K, V> m11076a(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map c0370a = new C0370a(6);
        c0370a.put(k, v);
        c0370a.put(k2, v2);
        c0370a.put(k3, v3);
        c0370a.put(k4, v4);
        c0370a.put(k5, v5);
        c0370a.put(k6, v6);
        return Collections.unmodifiableMap(c0370a);
    }

    public static <K, V> Map<K, V> m11077a(K[] kArr, V[] vArr) {
        int i = 0;
        C1971d.m11086b((Object[]) kArr, (Object[]) vArr);
        int length = kArr.length;
        switch (length) {
            case 0:
                return C1971d.m11083b();
            case 1:
                return C1971d.m11084b(kArr[0], vArr[0]);
            default:
                Map c0370a = length <= 32 ? new C0370a(length) : new HashMap(length, 1.0f);
                while (i < length) {
                    c0370a.put(kArr[i], vArr[i]);
                    i++;
                }
                return Collections.unmodifiableMap(c0370a);
        }
    }

    public static <T> Set<T> m11078a() {
        return Collections.emptySet();
    }

    public static <T> Set<T> m11079a(T t, T t2) {
        Set c1968a = new C1968a(2);
        c1968a.add(t);
        c1968a.add(t2);
        return Collections.unmodifiableSet(c1968a);
    }

    public static <T> Set<T> m11080a(T t, T t2, T t3) {
        Set c1968a = new C1968a(3);
        c1968a.add(t);
        c1968a.add(t2);
        c1968a.add(t3);
        return Collections.unmodifiableSet(c1968a);
    }

    public static <T> Set<T> m11081a(T t, T t2, T t3, T t4) {
        Set c1968a = new C1968a(4);
        c1968a.add(t);
        c1968a.add(t2);
        c1968a.add(t3);
        c1968a.add(t4);
        return Collections.unmodifiableSet(c1968a);
    }

    public static <T> Set<T> m11082a(T... tArr) {
        switch (tArr.length) {
            case 0:
                return C1971d.m11078a();
            case 1:
                return C1971d.m11085b(tArr[0]);
            case 2:
                return C1971d.m11079a(tArr[0], tArr[1]);
            case 3:
                return C1971d.m11080a(tArr[0], tArr[1], tArr[2]);
            case 4:
                return C1971d.m11081a(tArr[0], tArr[1], tArr[2], tArr[3]);
            default:
                return Collections.unmodifiableSet(tArr.length <= 32 ? new C1968a(Arrays.asList(tArr)) : new HashSet(Arrays.asList(tArr)));
        }
    }

    public static <K, V> Map<K, V> m11083b() {
        return Collections.emptyMap();
    }

    public static <K, V> Map<K, V> m11084b(K k, V v) {
        return Collections.singletonMap(k, v);
    }

    public static <T> Set<T> m11085b(T t) {
        return Collections.singleton(t);
    }

    private static <K, V> void m11086b(K[] kArr, V[] vArr) {
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + vArr.length);
        }
    }
}
