package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.PriorityQueue;

@id
public class cg {

    public static class C1400a {
        final long f4339a;
        final String f4340b;
        final int f4341c;

        C1400a(long j, String str, int i) {
            this.f4339a = j;
            this.f4340b = str;
            this.f4341c = i;
        }

        public boolean equals(Object obj) {
            return (obj == null || !(obj instanceof C1400a)) ? false : ((C1400a) obj).f4339a == this.f4339a && ((C1400a) obj).f4341c == this.f4341c;
        }

        public int hashCode() {
            return (int) this.f4339a;
        }
    }

    static long m7776a(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    static long m7777a(long j, int i) {
        return i == 0 ? 1 : i != 1 ? i % 2 == 0 ? cg.m7777a((j * j) % 1073807359, i / 2) % 1073807359 : ((cg.m7777a((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    static String m7778a(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            C1324b.m7230b("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    static void m7779a(int i, long j, String str, int i2, PriorityQueue<C1400a> priorityQueue) {
        C1400a c1400a = new C1400a(j, str, i2);
        if ((priorityQueue.size() != i || (((C1400a) priorityQueue.peek()).f4341c <= c1400a.f4341c && ((C1400a) priorityQueue.peek()).f4339a <= c1400a.f4339a)) && !priorityQueue.contains(c1400a)) {
            priorityQueue.add(c1400a);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void m7780a(String[] strArr, int i, int i2, PriorityQueue<C1400a> priorityQueue) {
        if (strArr.length < i2) {
            int i3 = i;
            cg.m7779a(i3, cg.m7781b(strArr, 0, strArr.length), cg.m7778a(strArr, 0, strArr.length), strArr.length, (PriorityQueue) priorityQueue);
            return;
        }
        long b = cg.m7781b(strArr, 0, i2);
        cg.m7779a(i, b, cg.m7778a(strArr, 0, i2), i2, (PriorityQueue) priorityQueue);
        long a = cg.m7777a(16785407, i2 - 1);
        int i4 = 1;
        while (i4 < (strArr.length - i2) + 1) {
            long a2 = cg.m7776a(ce.m7766a(strArr[i4 - 1]), ce.m7766a(strArr[(i4 + i2) - 1]), b, a, 16785407);
            cg.m7779a(i, a2, cg.m7778a(strArr, i4, i2), strArr.length, (PriorityQueue) priorityQueue);
            i4++;
            b = a2;
        }
    }

    private static long m7781b(String[] strArr, int i, int i2) {
        long a = (((long) ce.m7766a(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            a = (((a * 16785407) % 1073807359) + ((((long) ce.m7766a(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return a;
    }
}
