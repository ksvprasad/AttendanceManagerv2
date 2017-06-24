package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.C1982o;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class C2124g {
    SharedPreferences f7129a;
    Context f7130b;

    public C2124g(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public C2124g(Context context, String str) {
        this.f7130b = context;
        this.f7129a = context.getSharedPreferences(str, 4);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        m12186g(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private String m12185c(String str, String str2, String str3) {
        String valueOf = String.valueOf("|T|");
        return new StringBuilder((((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append(valueOf).append(str2).append("|").append(str3).toString();
    }

    private void m12186g(String str) {
        File file = new File(C1982o.m11123a(this.f7130b), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !m12196b()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    FirebaseInstanceId.m12110a(this.f7130b, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String str2 = "InstanceID/Store";
                    String str3 = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                }
            }
        }
    }

    public SharedPreferences m12187a() {
        return this.f7129a;
    }

    synchronized String m12188a(String str) {
        return this.f7129a.getString(str, null);
    }

    synchronized String m12189a(String str, String str2) {
        SharedPreferences sharedPreferences;
        String valueOf;
        sharedPreferences = this.f7129a;
        valueOf = String.valueOf("|S|");
        return sharedPreferences.getString(new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), null);
    }

    public synchronized String m12190a(String str, String str2, String str3) {
        return this.f7129a.getString(m12185c(str, str2, str3), null);
    }

    synchronized KeyPair m12191a(String str, long j) {
        KeyPair a;
        a = C2116a.m12153a();
        Editor edit = this.f7129a.edit();
        m12192a(edit, str, "|P|", FirebaseInstanceId.m12109a(a.getPublic().getEncoded()));
        m12192a(edit, str, "|K|", FirebaseInstanceId.m12109a(a.getPrivate().getEncoded()));
        m12192a(edit, str, "cre", Long.toString(j));
        edit.commit();
        return a;
    }

    synchronized void m12192a(Editor editor, String str, String str2, String str3) {
        String valueOf = String.valueOf("|S|");
        editor.putString(new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), str3);
    }

    public synchronized void m12193a(String str, String str2, String str3, String str4, String str5) {
        String c = m12185c(str, str2, str3);
        Editor edit = this.f7129a.edit();
        edit.putString(c, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    public synchronized void m12194b(String str) {
        Editor edit = this.f7129a.edit();
        for (String str2 : this.f7129a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public synchronized void m12195b(String str, String str2, String str3) {
        String c = m12185c(str, str2, str3);
        Editor edit = this.f7129a.edit();
        edit.remove(c);
        edit.commit();
    }

    public boolean m12196b() {
        return this.f7129a.getAll().isEmpty();
    }

    public KeyPair m12197c(String str) {
        return m12201f(str);
    }

    public synchronized void m12198c() {
        this.f7129a.edit().clear().commit();
    }

    void m12199d(String str) {
        m12194b(String.valueOf(str).concat("|"));
    }

    public void m12200e(String str) {
        m12194b(String.valueOf(str).concat("|T|"));
    }

    KeyPair m12201f(String str) {
        Object e;
        String a = m12189a(str, "|P|");
        String a2 = m12189a(str, "|K|");
        if (a == null || a2 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(a, 8);
            byte[] decode2 = Base64.decode(a2, 8);
            KeyFactory instance = KeyFactory.getInstance("RSA");
            return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
        } catch (InvalidKeySpecException e2) {
            e = e2;
            a = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(a).length() + 19).append("Invalid key stored ").append(a).toString());
            FirebaseInstanceId.m12110a(this.f7130b, this);
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            a = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(a).length() + 19).append("Invalid key stored ").append(a).toString());
            FirebaseInstanceId.m12110a(this.f7130b, this);
            return null;
        }
    }
}
