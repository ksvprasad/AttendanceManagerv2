package p000a.p001a;

import java.lang.reflect.Array;

final class C0016e {

    enum C0015a {
        FIRST,
        LAST
    }

    private static int m101a(int i) {
        return i * 37;
    }

    static int m102a(int i, int i2) {
        return C0016e.m101a(i) + i2;
    }

    static int m103a(int i, Object obj) {
        if (obj == null) {
            return C0016e.m102a(i, 0);
        }
        if (!C0016e.m107a(obj)) {
            return C0016e.m102a(i, obj.hashCode());
        }
        int length = Array.getLength(obj);
        int i2 = 0;
        int i3 = i;
        while (i2 < length) {
            i = C0016e.m103a(i3, Array.get(obj, i2));
            i2++;
            i3 = i;
        }
        return i3;
    }

    static <T extends Comparable<T>> int m104a(T t, T t2, C0015a c0015a) {
        int i = 0;
        if (t != null && t2 != null) {
            return t.compareTo(t2);
        }
        if (!(t == null && t2 == null)) {
            if (t == null && t2 != null) {
                i = -1;
            } else if (t != null && t2 == null) {
                i = 1;
            }
        }
        return C0015a.LAST == c0015a ? i * -1 : i;
    }

    static final int m105a(Object... objArr) {
        int i = 23;
        for (Object a : objArr) {
            i = C0016e.m103a(i, a);
        }
        return i;
    }

    static Boolean m106a(Object obj, Object obj2) {
        return obj == obj2 ? Boolean.TRUE : !obj.getClass().isInstance(obj2) ? Boolean.FALSE : null;
    }

    private static boolean m107a(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    static boolean m108a(Object[] objArr, Object[] objArr2) {
        if (objArr.length != objArr2.length) {
            throw new IllegalArgumentException("Array lengths do not match. 'This' length is " + objArr.length + ", while 'That' length is " + objArr2.length + ".");
        }
        for (int i = 0; i < objArr.length; i++) {
            if (!C0016e.m109b(objArr[i], objArr2[i])) {
                return false;
            }
        }
        return true;
    }

    static boolean m109b(Object obj, Object obj2) {
        if (!C0016e.m107a(obj) && !C0016e.m107a(obj2)) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        } else {
            throw new IllegalArgumentException("This method does not currently support arrays.");
        }
    }
}
