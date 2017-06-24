package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.google.android.gms.common.util.C1979l;

public class nm {
    protected final Context f6065a;

    public nm(Context context) {
        this.f6065a = context;
    }

    public ApplicationInfo m10159a(String str, int i) {
        return this.f6065a.getPackageManager().getApplicationInfo(str, i);
    }

    @TargetApi(19)
    public boolean m10160a(int i, String str) {
        if (C1979l.m11114h()) {
            try {
                ((AppOpsManager) this.f6065a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = this.f6065a.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public PackageInfo m10161b(String str, int i) {
        return this.f6065a.getPackageManager().getPackageInfo(str, i);
    }
}
