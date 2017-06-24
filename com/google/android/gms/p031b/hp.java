package com.google.android.gms.p031b;

import java.util.Map;

public class hp {
    public final int f5048a;
    public final byte[] f5049b;
    public final Map<String, String> f5050c;
    public final boolean f5051d;
    public final long f5052e;

    public hp(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.f5048a = i;
        this.f5049b = bArr;
        this.f5050c = map;
        this.f5051d = z;
        this.f5052e = j;
    }

    public hp(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0);
    }
}
