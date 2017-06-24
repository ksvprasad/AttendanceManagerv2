package com.google.android.gms.p031b;

import java.io.ByteArrayOutputStream;

public class C1370b extends ByteArrayOutputStream {
    private final nt f4181a;

    public C1370b(nt ntVar, int i) {
        this.f4181a = ntVar;
        this.buf = this.f4181a.m10207a(Math.max(i, 256));
    }

    private void m7532a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.f4181a.m10207a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f4181a.m10206a(this.buf);
            this.buf = a;
        }
    }

    public void close() {
        this.f4181a.m10206a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f4181a.m10206a(this.buf);
    }

    public synchronized void write(int i) {
        m7532a(1);
        super.write(i);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m7532a(i2);
        super.write(bArr, i, i2);
    }
}
