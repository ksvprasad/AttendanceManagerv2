package com.google.android.gms.p031b;

public final class ac {
    public static final int[] f4051a = new int[0];
    public static final long[] f4052b = new long[0];
    public static final float[] f4053c = new float[0];
    public static final double[] f4054d = new double[0];
    public static final boolean[] f4055e = new boolean[0];
    public static final String[] f4056f = new String[0];
    public static final byte[][] f4057g = new byte[0][];
    public static final byte[] f4058h = new byte[0];

    static int m7335a(int i) {
        return i & 7;
    }

    public static int m7336a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean m7337a(C1841r c1841r, int i) {
        return c1841r.m10387b(i);
    }

    public static int m7338b(int i) {
        return i >>> 3;
    }

    public static final int m7339b(C1841r c1841r, int i) {
        int i2 = 1;
        int r = c1841r.m10407r();
        c1841r.m10387b(i);
        while (c1841r.m10382a() == i) {
            c1841r.m10387b(i);
            i2++;
        }
        c1841r.m10393e(r);
        return i2;
    }
}
