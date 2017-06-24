package com.google.android.gms.p031b;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class al {
    private static Cipher f4129b = null;
    private static final Object f4130c = new Object();
    private static final Object f4131d = new Object();
    private final SecureRandom f4132a;

    public class C1366a extends Exception {
        final /* synthetic */ al f4128a;

        public C1366a(al alVar) {
            this.f4128a = alVar;
        }

        public C1366a(al alVar, Throwable th) {
            this.f4128a = alVar;
            super(th);
        }
    }

    public al(SecureRandom secureRandom) {
        this.f4132a = secureRandom;
    }

    private Cipher m7441a() {
        Cipher cipher;
        synchronized (f4131d) {
            if (f4129b == null) {
                f4129b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = f4129b;
        }
        return cipher;
    }

    static void m7442a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public String m7443a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 16) {
            throw new C1366a(this);
        }
        try {
            byte[] doFinal;
            byte[] iv;
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (f4130c) {
                m7441a().init(1, secretKeySpec, this.f4132a);
                doFinal = m7441a().doFinal(bArr2);
                iv = m7441a().getIV();
            }
            int length = doFinal.length + iv.length;
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.put(iv).put(doFinal);
            allocate.flip();
            doFinal = new byte[length];
            allocate.get(doFinal);
            return C1563h.m8703a(doFinal, false);
        } catch (Throwable e) {
            throw new C1366a(this, e);
        } catch (Throwable e2) {
            throw new C1366a(this, e2);
        } catch (Throwable e22) {
            throw new C1366a(this, e22);
        } catch (Throwable e222) {
            throw new C1366a(this, e222);
        } catch (Throwable e2222) {
            throw new C1366a(this, e2222);
        }
    }

    public byte[] m7444a(String str) {
        try {
            byte[] a = C1563h.m8704a(str, false);
            if (a.length != 32) {
                throw new C1366a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            al.m7442a(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C1366a(this, e);
        }
    }

    public byte[] m7445a(byte[] bArr, String str) {
        if (bArr.length != 16) {
            throw new C1366a(this);
        }
        try {
            byte[] a = C1563h.m8704a(str, false);
            if (a.length <= 16) {
                throw new C1366a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (f4130c) {
                m7441a().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                a = m7441a().doFinal(a);
            }
            return a;
        } catch (Throwable e) {
            throw new C1366a(this, e);
        } catch (Throwable e2) {
            throw new C1366a(this, e2);
        } catch (Throwable e22) {
            throw new C1366a(this, e22);
        } catch (Throwable e222) {
            throw new C1366a(this, e222);
        } catch (Throwable e2222) {
            throw new C1366a(this, e2222);
        } catch (Throwable e22222) {
            throw new C1366a(this, e22222);
        } catch (Throwable e222222) {
            throw new C1366a(this, e222222);
        }
    }
}
