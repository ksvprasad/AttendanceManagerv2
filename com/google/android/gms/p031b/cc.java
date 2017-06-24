package com.google.android.gms.p031b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@id
public abstract class cc {
    private static MessageDigest f4329b = null;
    protected Object f4330a = new Object();

    protected MessageDigest m7759a() {
        MessageDigest messageDigest;
        synchronized (this.f4330a) {
            if (f4329b != null) {
                messageDigest = f4329b;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        f4329b = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = f4329b;
            }
        }
        return messageDigest;
    }

    abstract byte[] mo1268a(String str);
}
