package com.google.android.gms.p031b;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class C1843s {
    private final ByteBuffer f6262a;

    public static class C1842a extends IOException {
        C1842a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private C1843s(ByteBuffer byteBuffer) {
        this.f6262a = byteBuffer;
        this.f6262a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private C1843s(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int m10409a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < '') {
            i++;
        }
        int i2 = i;
        i = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= 'ࠀ') {
                i += C1843s.m10410a(charSequence, i2);
                break;
            }
            i2++;
            i = ((127 - charAt) >>> 31) + i;
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    private static int m10410a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 'ࠀ') {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if ('?' <= charAt && charAt <= '?') {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int m10411a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < '?' || '?' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    public static C1843s m10412a(byte[] bArr) {
        return C1843s.m10413a(bArr, 0, bArr.length);
    }

    public static C1843s m10413a(byte[] bArr, int i, int i2) {
        return new C1843s(bArr, i, i2);
    }

    private static void m10414a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(C1843s.m10411a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            C1843s.m10427b(charSequence, byteBuffer);
        }
    }

    public static int m10415b(double d) {
        return 8;
    }

    public static int m10416b(float f) {
        return 4;
    }

    public static int m10417b(int i) {
        return i >= 0 ? C1843s.m10437f(i) : 10;
    }

    public static int m10418b(int i, double d) {
        return C1843s.m10431d(i) + C1843s.m10415b(d);
    }

    public static int m10419b(int i, float f) {
        return C1843s.m10431d(i) + C1843s.m10416b(f);
    }

    public static int m10420b(int i, int i2) {
        return C1843s.m10431d(i) + C1843s.m10417b(i2);
    }

    public static int m10421b(int i, C1357z c1357z) {
        return (C1843s.m10431d(i) * 2) + C1843s.m10429c(c1357z);
    }

    public static int m10422b(int i, String str) {
        return C1843s.m10431d(i) + C1843s.m10425b(str);
    }

    public static int m10423b(int i, boolean z) {
        return C1843s.m10431d(i) + C1843s.m10426b(z);
    }

    public static int m10424b(int i, byte[] bArr) {
        return C1843s.m10431d(i) + C1843s.m10430c(bArr);
    }

    public static int m10425b(String str) {
        int a = C1843s.m10409a((CharSequence) str);
        return a + C1843s.m10437f(a);
    }

    public static int m10426b(boolean z) {
        return 1;
    }

    private static void m10427b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else if (charAt < '?' || '?' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int m10428c(int i, C1357z c1357z) {
        return C1843s.m10431d(i) + C1843s.m10434d(c1357z);
    }

    public static int m10429c(C1357z c1357z) {
        return c1357z.m7349f();
    }

    public static int m10430c(byte[] bArr) {
        return C1843s.m10437f(bArr.length) + bArr.length;
    }

    public static int m10431d(int i) {
        return C1843s.m10437f(ac.m7336a(i, 0));
    }

    public static int m10432d(int i, long j) {
        return C1843s.m10431d(i) + C1843s.m10436e(j);
    }

    public static int m10433d(long j) {
        return C1843s.m10439h(j);
    }

    public static int m10434d(C1357z c1357z) {
        int f = c1357z.m7349f();
        return f + C1843s.m10437f(f);
    }

    public static int m10435e(int i, long j) {
        return C1843s.m10431d(i) + C1843s.m10438f(j);
    }

    public static int m10436e(long j) {
        return C1843s.m10439h(j);
    }

    public static int m10437f(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int m10438f(long j) {
        return C1843s.m10439h(C1843s.m10440j(j));
    }

    public static int m10439h(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long m10440j(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public int m10441a() {
        return this.f6262a.remaining();
    }

    public void m10442a(byte b) {
        if (this.f6262a.hasRemaining()) {
            this.f6262a.put(b);
            return;
        }
        throw new C1842a(this.f6262a.position(), this.f6262a.limit());
    }

    public void m10443a(double d) {
        m10472i(Double.doubleToLongBits(d));
    }

    public void m10444a(float f) {
        m10470g(Float.floatToIntBits(f));
    }

    public void m10445a(int i) {
        if (i >= 0) {
            m10469e(i);
        } else {
            m10471g((long) i);
        }
    }

    public void m10446a(int i, double d) {
        m10465c(i, 1);
        m10443a(d);
    }

    public void m10447a(int i, float f) {
        m10465c(i, 5);
        m10444a(f);
    }

    public void m10448a(int i, int i2) {
        m10465c(i, 0);
        m10445a(i2);
    }

    public void m10449a(int i, long j) {
        m10465c(i, 0);
        m10454a(j);
    }

    public void m10450a(int i, C1357z c1357z) {
        m10465c(i, 2);
        m10461b(c1357z);
    }

    public void m10451a(int i, String str) {
        m10465c(i, 2);
        m10456a(str);
    }

    public void m10452a(int i, boolean z) {
        m10465c(i, 0);
        m10457a(z);
    }

    public void m10453a(int i, byte[] bArr) {
        m10465c(i, 2);
        m10462b(bArr);
    }

    public void m10454a(long j) {
        m10471g(j);
    }

    public void m10455a(C1357z c1357z) {
        c1357z.mo1231a(this);
    }

    public void m10456a(String str) {
        try {
            int f = C1843s.m10437f(str.length());
            if (f == C1843s.m10437f(str.length() * 3)) {
                int position = this.f6262a.position();
                if (this.f6262a.remaining() < f) {
                    throw new C1842a(f + position, this.f6262a.limit());
                }
                this.f6262a.position(position + f);
                C1843s.m10414a((CharSequence) str, this.f6262a);
                int position2 = this.f6262a.position();
                this.f6262a.position(position);
                m10469e((position2 - position) - f);
                this.f6262a.position(position2);
                return;
            }
            m10469e(C1843s.m10409a((CharSequence) str));
            C1843s.m10414a((CharSequence) str, this.f6262a);
        } catch (Throwable e) {
            C1842a c1842a = new C1842a(this.f6262a.position(), this.f6262a.limit());
            c1842a.initCause(e);
            throw c1842a;
        }
    }

    public void m10457a(boolean z) {
        m10464c(z ? 1 : 0);
    }

    public void m10458b() {
        if (m10441a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void m10459b(int i, long j) {
        m10465c(i, 0);
        m10460b(j);
    }

    public void m10460b(long j) {
        m10471g(j);
    }

    public void m10461b(C1357z c1357z) {
        m10469e(c1357z.m7348e());
        c1357z.mo1231a(this);
    }

    public void m10462b(byte[] bArr) {
        m10469e(bArr.length);
        m10468d(bArr);
    }

    public void m10463b(byte[] bArr, int i, int i2) {
        if (this.f6262a.remaining() >= i2) {
            this.f6262a.put(bArr, i, i2);
            return;
        }
        throw new C1842a(this.f6262a.position(), this.f6262a.limit());
    }

    public void m10464c(int i) {
        m10442a((byte) i);
    }

    public void m10465c(int i, int i2) {
        m10469e(ac.m7336a(i, i2));
    }

    public void m10466c(int i, long j) {
        m10465c(i, 0);
        m10467c(j);
    }

    public void m10467c(long j) {
        m10471g(C1843s.m10440j(j));
    }

    public void m10468d(byte[] bArr) {
        m10463b(bArr, 0, bArr.length);
    }

    public void m10469e(int i) {
        while ((i & -128) != 0) {
            m10464c((i & 127) | 128);
            i >>>= 7;
        }
        m10464c(i);
    }

    public void m10470g(int i) {
        if (this.f6262a.remaining() < 4) {
            throw new C1842a(this.f6262a.position(), this.f6262a.limit());
        }
        this.f6262a.putInt(i);
    }

    public void m10471g(long j) {
        while ((-128 & j) != 0) {
            m10464c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m10464c((int) j);
    }

    public void m10472i(long j) {
        if (this.f6262a.remaining() < 8) {
            throw new C1842a(this.f6262a.position(), this.f6262a.limit());
        }
        this.f6262a.putLong(j);
    }
}
