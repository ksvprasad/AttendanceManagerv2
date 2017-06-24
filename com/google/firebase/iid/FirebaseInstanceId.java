package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.p015g.C0370a;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.C2112a;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class FirebaseInstanceId {
    private static Map<String, FirebaseInstanceId> f7081a = new C0370a();
    private static C2121e f7082b;
    private final C2112a f7083c;
    private final C2120d f7084d;
    private final String f7085e = m12116b();

    private FirebaseInstanceId(C2112a c2112a, C2120d c2120d) {
        this.f7083c = c2112a;
        this.f7084d = c2120d;
        if (this.f7085e == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        FirebaseInstanceIdService.m12137a(this.f7083c.m12099a(), this);
    }

    public static FirebaseInstanceId m12106a() {
        return getInstance(C2112a.m12096d());
    }

    static String m12107a(Context context) {
        return m12106a().f7083c.m12101c().m12104a();
    }

    static String m12108a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static String m12109a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    static void m12110a(Context context, C2124g c2124g) {
        c2124g.m12198c();
        Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.m12125b(context, intent));
    }

    static int m12111b(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return i;
        }
    }

    static String m12112c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    static void m12113d(Context context) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.putExtra("CMD", "SYNC");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.m12125b(context, intent));
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(C2112a c2112a) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) f7081a.get(c2112a.m12101c().m12104a());
            if (firebaseInstanceId == null) {
                C2120d a = C2120d.m12156a(c2112a.m12099a(), null);
                if (f7082b == null) {
                    f7082b = new C2121e(a.m12161c());
                }
                firebaseInstanceId = new FirebaseInstanceId(c2112a, a);
                f7081a.put(c2112a.m12101c().m12104a(), firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    public String m12114a(String str, String str2) {
        return this.f7084d.m12159b(str, str2, null);
    }

    void m12115a(String str) {
        if (m12119d() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        C2120d c2120d = this.f7084d;
        valueOf = m12119d();
        String valueOf3 = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        c2120d.m12159b(valueOf, valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3), bundle);
    }

    String m12116b() {
        String b = this.f7083c.m12101c().m12105b();
        if (b != null) {
            return b;
        }
        b = this.f7083c.m12101c().m12104a();
        if (!b.startsWith("1:")) {
            return b;
        }
        String[] split = b.split(":");
        if (split.length < 2) {
            return null;
        }
        b = split[1];
        return b.isEmpty() ? null : b;
    }

    void m12117b(String str) {
        if (m12119d() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        C2120d c2120d = this.f7084d;
        valueOf = m12119d();
        String valueOf3 = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        c2120d.m12158a(valueOf, valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3), bundle);
    }

    public String m12118c() {
        return m12108a(this.f7084d.m12157a());
    }

    public String m12119d() {
        String e = m12120e();
        if (e == null) {
            FirebaseInstanceIdService.m12136a(this.f7083c.m12099a());
        }
        return e;
    }

    String m12120e() {
        return this.f7084d.m12161c().m12190a("", this.f7085e, "*");
    }

    String m12121f() {
        return m12114a(this.f7085e, "*");
    }

    C2121e m12122g() {
        return f7082b;
    }
}
