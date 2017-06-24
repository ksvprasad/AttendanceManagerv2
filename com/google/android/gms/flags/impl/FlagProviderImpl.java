package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.flags.impl.C1986a.C1987a;
import com.google.android.gms.flags.impl.C1986a.C1989b;
import com.google.android.gms.flags.impl.C1986a.C1991c;
import com.google.android.gms.flags.impl.C1986a.C1993d;
import com.google.android.gms.p031b.ns.C1805a;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;

@DynamiteApi
public class FlagProviderImpl extends C1805a {
    private boolean f6617a = false;
    private SharedPreferences f6618b;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.f6617a ? z : C1987a.m11140a(this.f6618b, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return !this.f6617a ? i : C1989b.m11142a(this.f6618b, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return !this.f6617a ? j : C1991c.m11144a(this.f6618b, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return !this.f6617a ? str2 : C1993d.m11146a(this.f6618b, str, str2);
    }

    public void init(C0998a c0998a) {
        Context context = (Context) C1001b.m5714a(c0998a);
        if (!this.f6617a) {
            try {
                this.f6618b = C1995b.m11148a(context.createPackageContext("com.google.android.gms", 0));
                this.f6617a = true;
            } catch (NameNotFoundException e) {
            }
        }
    }
}
