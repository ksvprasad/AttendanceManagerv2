package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;
import com.google.android.gms.p031b.C1493f.C1489c;
import com.google.android.gms.p031b.C1493f.C1492f;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class C1597i {
    static boolean f5142a = false;
    static CountDownLatch f5143b = new CountDownLatch(1);
    private static MessageDigest f5144c = null;
    private static final Object f5145d = new Object();
    private static final Object f5146e = new Object();

    private static final class C1596a implements Runnable {
        private C1596a() {
        }

        public void run() {
            try {
                C1597i.f5144c = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            } finally {
                C1597i.f5143b.countDown();
            }
        }
    }

    private static int m8846a(boolean z) {
        return z ? 239 : 255;
    }

    static C1487a m8847a(long j) {
        C1487a c1487a = new C1487a();
        c1487a.f4675t = Long.valueOf(j);
        return c1487a;
    }

    static String m8848a(C1487a c1487a, String str, boolean z) {
        return C1597i.m8850a(C1357z.m7342a((C1357z) c1487a), str, z);
    }

    static String m8849a(String str, String str2, boolean z) {
        byte[] b = C1597i.m8858b(str, str2, z);
        return b != null ? C1563h.m8703a(b, true) : Integer.toString(7);
    }

    static String m8850a(byte[] bArr, String str, boolean z) {
        return C1563h.m8703a(z ? C1597i.m8859b(bArr, str) : C1597i.m8856a(bArr, str), true);
    }

    static Vector<byte[]> m8852a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + i) - 1) / i;
        Vector<byte[]> vector = new Vector();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * i;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > i ? i3 + i : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return vector;
    }

    static void m8853a() {
        synchronized (f5146e) {
            if (!f5142a) {
                f5142a = true;
                new Thread(new C1596a()).start();
            }
        }
    }

    static void m8854a(String str, byte[] bArr) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new C1839p(str.getBytes("UTF-8")).m10371a(bArr);
    }

    public static byte[] m8855a(byte[] bArr) {
        byte[] digest;
        synchronized (f5145d) {
            MessageDigest b = C1597i.m8857b();
            if (b == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            b.reset();
            b.update(bArr);
            digest = f5144c.digest();
        }
        return digest;
    }

    static byte[] m8856a(byte[] bArr, String str) {
        Vector a = C1597i.m8852a(bArr, 255);
        if (a == null || a.size() == 0) {
            return C1597i.m8859b(C1357z.m7342a(C1597i.m8847a(4096)), str);
        }
        C1357z c1492f = new C1492f();
        c1492f.f4695a = new byte[a.size()][];
        Iterator it = a.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            c1492f.f4695a[i] = C1597i.m8860b((byte[]) it.next(), str, false);
            i = i2;
        }
        c1492f.f4696b = C1597i.m8855a(bArr);
        return C1357z.m7342a(c1492f);
    }

    static MessageDigest m8857b() {
        C1597i.m8853a();
        boolean z = false;
        try {
            z = f5143b.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        return (z && f5144c != null) ? f5144c : null;
    }

    static byte[] m8858b(String str, String str2, boolean z) {
        C1357z c1489c = new C1489c();
        try {
            c1489c.f4686a = str.length() < 3 ? str.getBytes("ISO-8859-1") : C1563h.m8704a(str, true);
            byte[] bytes = z ? str2.length() < 3 ? str2.getBytes("ISO-8859-1") : C1563h.m8704a(str2, true) : (str2 == null || str2.length() == 0) ? Integer.toString(5).getBytes("ISO-8859-1") : C1563h.m8704a(C1597i.m8850a(str2.getBytes("ISO-8859-1"), null, true), true);
            c1489c.f4687b = bytes;
            return C1357z.m7342a(c1489c);
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (NoSuchAlgorithmException e2) {
            return null;
        }
    }

    static byte[] m8859b(byte[] bArr, String str) {
        return C1597i.m8860b(bArr, str, true);
    }

    private static byte[] m8860b(byte[] bArr, String str, boolean z) {
        byte[] bArr2;
        byte[] array;
        int a = C1597i.m8846a(z);
        if (bArr.length > a) {
            bArr = C1357z.m7342a(C1597i.m8847a(4096));
        }
        if (bArr.length < a) {
            bArr2 = new byte[(a - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(a + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(a + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(C1597i.m8855a(array)).put(array).array();
        }
        bArr2 = new byte[256];
        new C1629j().m9047a(array, bArr2);
        if (str != null && str.length() > 0) {
            C1597i.m8854a(str, bArr2);
        }
        return bArr2;
    }
}
