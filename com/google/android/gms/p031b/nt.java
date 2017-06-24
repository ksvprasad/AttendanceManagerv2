package com.google.android.gms.p031b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class nt {
    protected static final Comparator<byte[]> f6095a = new C18061();
    private List<byte[]> f6096b = new LinkedList();
    private List<byte[]> f6097c = new ArrayList(64);
    private int f6098d = 0;
    private final int f6099e;

    class C18061 implements Comparator<byte[]> {
        C18061() {
        }

        public int m10204a(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m10204a((byte[]) obj, (byte[]) obj2);
        }
    }

    public nt(int i) {
        this.f6099e = i;
    }

    private synchronized void m10205a() {
        while (this.f6098d > this.f6099e) {
            byte[] bArr = (byte[]) this.f6096b.remove(0);
            this.f6097c.remove(bArr);
            this.f6098d -= bArr.length;
        }
    }

    public synchronized void m10206a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f6099e) {
                this.f6096b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f6097c, bArr, f6095a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f6097c.add(binarySearch, bArr);
                this.f6098d += bArr.length;
                m10205a();
            }
        }
    }

    public synchronized byte[] m10207a(int i) {
        byte[] bArr;
        for (int i2 = 0; i2 < this.f6097c.size(); i2++) {
            bArr = (byte[]) this.f6097c.get(i2);
            if (bArr.length >= i) {
                this.f6098d -= bArr.length;
                this.f6097c.remove(i2);
                this.f6096b.remove(bArr);
                break;
            }
        }
        bArr = new byte[i];
        return bArr;
    }
}
