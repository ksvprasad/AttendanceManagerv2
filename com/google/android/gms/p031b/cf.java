package com.google.android.gms.p031b;

import java.security.MessageDigest;

@id
public class cf extends cc {
    private MessageDigest f4338b;

    byte m7772a(int i) {
        return (byte) ((((i & 255) ^ ((65280 & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((-16777216 & i) >> 24));
    }

    public byte[] mo1268a(String str) {
        byte[] bArr;
        int i = 4;
        byte[] a = m7774a(str.split(" "));
        this.f4338b = m7759a();
        synchronized (this.a) {
            if (this.f4338b == null) {
                bArr = new byte[0];
            } else {
                this.f4338b.reset();
                this.f4338b.update(a);
                Object digest = this.f4338b.digest();
                if (digest.length <= 4) {
                    i = digest.length;
                }
                bArr = new byte[i];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }

    byte[] m7774a(String[] strArr) {
        int i = 0;
        if (strArr.length == 1) {
            return ce.m7769b(ce.m7766a(strArr[0]));
        }
        if (strArr.length < 5) {
            byte[] bArr = new byte[(strArr.length * 2)];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                byte[] b = m7775b(ce.m7766a(strArr[i2]));
                bArr[i2 * 2] = b[0];
                bArr[(i2 * 2) + 1] = b[1];
            }
            return bArr;
        }
        byte[] bArr2 = new byte[strArr.length];
        while (i < strArr.length) {
            bArr2[i] = m7772a(ce.m7766a(strArr[i]));
            i++;
        }
        return bArr2;
    }

    byte[] m7775b(int i) {
        int i2 = (65535 & i) ^ ((-65536 & i) >> 16);
        return new byte[]{(byte) i2, (byte) (i2 >> 8)};
    }
}
