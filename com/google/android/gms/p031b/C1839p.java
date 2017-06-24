package com.google.android.gms.p031b;

public class C1839p {
    private final byte[] f6247a = new byte[256];
    private int f6248b;
    private int f6249c;

    public C1839p(byte[] bArr) {
        int i;
        for (i = 0; i < 256; i++) {
            this.f6247a[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            i = ((i + this.f6247a[i2]) + bArr[i2 % bArr.length]) & 255;
            byte b = this.f6247a[i2];
            this.f6247a[i2] = this.f6247a[i];
            this.f6247a[i] = b;
        }
        this.f6248b = 0;
        this.f6249c = 0;
    }

    public void m10371a(byte[] bArr) {
        int i = this.f6248b;
        int i2 = this.f6249c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.f6247a[i]) & 255;
            byte b = this.f6247a[i];
            this.f6247a[i] = this.f6247a[i2];
            this.f6247a[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.f6247a[(this.f6247a[i] + this.f6247a[i2]) & 255]);
        }
        this.f6248b = i;
        this.f6249c = i2;
    }
}
