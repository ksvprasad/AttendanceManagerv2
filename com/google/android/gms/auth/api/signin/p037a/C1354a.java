package com.google.android.gms.auth.api.signin.p037a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.C1896c;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class C1354a {
    private static final Lock f4043a = new ReentrantLock();
    private static C1354a f4044b;
    private final Lock f4045c = new ReentrantLock();
    private final SharedPreferences f4046d;

    C1354a(Context context) {
        this.f4046d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static C1354a m7318a(Context context) {
        C1896c.m10790a((Object) context);
        f4043a.lock();
        try {
            if (f4044b == null) {
                f4044b = new C1354a(context.getApplicationContext());
            }
            C1354a c1354a = f4044b;
            return c1354a;
        } finally {
            f4043a.unlock();
        }
    }

    private String m7319a(String str, String str2) {
        String valueOf = String.valueOf(":");
        return new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString();
    }

    public GoogleSignInAccount m7320a() {
        return m7321a(m7322b("defaultGoogleSignInAccount"));
    }

    GoogleSignInAccount m7321a(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String b = m7322b(m7319a("googleSignInAccount", str));
            if (b != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.m7303a(b);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    protected String m7322b(String str) {
        this.f4045c.lock();
        try {
            String string = this.f4046d.getString(str, null);
            return string;
        } finally {
            this.f4045c.unlock();
        }
    }
}
