package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.C1956k.C1950a;
import com.google.android.gms.common.C1956k.C1951b;
import com.google.android.gms.common.C1956k.C1955d;
import com.google.android.gms.common.internal.C1896c;

public class C1957m {
    private static C1957m f6537a;
    private final Context f6538b;

    private C1957m(Context context) {
        this.f6538b = context.getApplicationContext();
    }

    public static C1957m m11001a(Context context) {
        C1896c.m10790a((Object) context);
        synchronized (C1957m.class) {
            if (f6537a == null) {
                C1956k.m11000a(context);
                f6537a = new C1957m(context);
            }
        }
        return f6537a;
    }

    C1950a m11002a(PackageInfo packageInfo, C1950a... c1950aArr) {
        int i = 0;
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        C1951b c1951b = new C1951b(packageInfo.signatures[0].toByteArray());
        while (i < c1950aArr.length) {
            if (c1950aArr[i].equals(c1951b)) {
                return c1950aArr[i];
            }
            i++;
        }
        return null;
    }

    public boolean m11003a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            C1950a a;
            if (z) {
                a = m11002a(packageInfo, C1955d.f6535a);
            } else {
                a = m11002a(packageInfo, C1955d.f6535a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    public boolean m11004a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (m11003a(packageInfo, false)) {
            return true;
        }
        if (!m11003a(packageInfo, true)) {
            return false;
        }
        if (C1881l.m10645d(this.f6538b)) {
            return true;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return false;
    }
}
