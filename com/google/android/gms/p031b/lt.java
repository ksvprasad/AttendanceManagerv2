package com.google.android.gms.p031b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class lt {
    private static long m9712a(long j) {
        return (j >>> 47) ^ j;
    }

    private static long m9713a(long j, long j2) {
        long j3 = (j2 ^ j) * -4132994306676758123L;
        j3 = ((j3 ^ (j3 >>> 47)) ^ j) * -4132994306676758123L;
        return (j3 ^ (j3 >>> 47)) * -4132994306676758123L;
    }

    public static long m9714a(byte[] bArr) {
        long j = -6505348102511208375L;
        long a = bArr.length <= 32 ? lt.m9717a(bArr, -1397348546323613475L) : bArr.length <= 64 ? lt.m9719b(bArr) : lt.m9720c(bArr);
        long a2 = bArr.length >= 8 ? lt.m9715a(bArr, 0) : -6505348102511208375L;
        if (bArr.length >= 9) {
            j = lt.m9715a(bArr, bArr.length - 8);
        }
        a = lt.m9713a(a + j, a2);
        return (a == 0 || a == 1) ? a - 2 : a;
    }

    private static long m9715a(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 8);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getLong();
    }

    private static long m9716a(byte[] bArr, int i, int i2) {
        long j = 0;
        for (int i3 = 0; i3 < Math.min(i2, 8); i3++) {
            j |= (((long) bArr[i + i3]) & 255) << (i3 * 8);
        }
        return j;
    }

    private static long m9717a(byte[] bArr, long j) {
        int length = bArr.length & -8;
        int length2 = bArr.length & 7;
        long length3 = j ^ (((long) bArr.length) * -4132994306676758123L);
        int i = 0;
        while (i < length) {
            long a = (length3 ^ (lt.m9712a(lt.m9715a(bArr, i) * -4132994306676758123L) * -4132994306676758123L)) * -4132994306676758123L;
            i += 8;
            length3 = a;
        }
        if (length2 != 0) {
            length3 = (length3 ^ lt.m9716a(bArr, length, length2)) * -4132994306676758123L;
        }
        return lt.m9712a(lt.m9712a(length3) * -4132994306676758123L);
    }

    private static void m9718a(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long a = lt.m9715a(bArr, i);
        long a2 = lt.m9715a(bArr, i + 8);
        long a3 = lt.m9715a(bArr, i + 16);
        long a4 = lt.m9715a(bArr, i + 24);
        a += j;
        a2 = (a2 + a) + a3;
        a3 = Long.rotateRight(a2, 23) + Long.rotateRight((j2 + a) + a4, 51);
        jArr[0] = a2 + a4;
        jArr[1] = a + a3;
    }

    private static long m9719b(byte[] bArr) {
        int length = bArr.length;
        long a = lt.m9715a(bArr, 24);
        long a2 = lt.m9715a(bArr, 0) + ((((long) length) + lt.m9715a(bArr, length - 16)) * -6505348102511208375L);
        long rotateRight = Long.rotateRight(a2 + a, 52);
        long rotateRight2 = Long.rotateRight(a2, 37);
        a2 += lt.m9715a(bArr, 8);
        rotateRight2 += Long.rotateRight(a2, 7);
        a2 += lt.m9715a(bArr, 16);
        a += a2;
        a2 = (Long.rotateRight(a2, 31) + rotateRight) + rotateRight2;
        rotateRight = lt.m9715a(bArr, 16) + lt.m9715a(bArr, length - 32);
        rotateRight2 = lt.m9715a(bArr, length - 8);
        long rotateRight3 = Long.rotateRight(rotateRight + rotateRight2, 52);
        long rotateRight4 = Long.rotateRight(rotateRight, 37);
        rotateRight += lt.m9715a(bArr, length - 24);
        long a3 = lt.m9715a(bArr, length - 16) + rotateRight;
        return lt.m9712a((lt.m9712a(((((Long.rotateRight(a3, 31) + rotateRight3) + (rotateRight4 + Long.rotateRight(rotateRight, 7))) + a) * -4288712594273399085L) + (((a3 + rotateRight2) + a2) * -6505348102511208375L)) * -6505348102511208375L) + a2) * -4288712594273399085L;
    }

    private static long m9720c(byte[] bArr) {
        int length = bArr.length;
        long a = lt.m9715a(bArr, 0);
        long a2 = lt.m9715a(bArr, length - 16) ^ -8261664234251669945L;
        long a3 = lt.m9715a(bArr, length - 56) ^ -6505348102511208375L;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        lt.m9718a(bArr, length - 64, (long) length, a2, jArr);
        lt.m9718a(bArr, length - 32, ((long) length) * -8261664234251669945L, -6505348102511208375L, jArr2);
        long a4 = a3 + (lt.m9712a(jArr[1]) * -8261664234251669945L);
        long rotateRight = Long.rotateRight(a2, 33) * -8261664234251669945L;
        int i = 0;
        a2 = -8261664234251669945L * Long.rotateRight(a4 + a, 39);
        length = (length - 1) & -64;
        while (true) {
            a2 = Long.rotateRight(((a2 + rotateRight) + jArr[0]) + lt.m9715a(bArr, i + 16), 37) * -8261664234251669945L;
            a = a2 ^ jArr2[1];
            rotateRight = (Long.rotateRight((jArr[1] + rotateRight) + lt.m9715a(bArr, i + 48), 42) * -8261664234251669945L) ^ jArr[0];
            a3 = Long.rotateRight(a4 ^ jArr2[0], 33);
            lt.m9718a(bArr, i, jArr[1] * -8261664234251669945L, jArr2[0] + a, jArr);
            lt.m9718a(bArr, i + 32, a3 + jArr2[1], rotateRight, jArr2);
            i += 64;
            int i2 = length - 64;
            if (i2 == 0) {
                return lt.m9713a((lt.m9713a(jArr[0], jArr2[0]) + (lt.m9712a(rotateRight) * -8261664234251669945L)) + a, lt.m9713a(jArr[1], jArr2[1]) + a3);
            }
            a4 = a;
            a2 = a3;
            length = i2;
        }
    }
}
