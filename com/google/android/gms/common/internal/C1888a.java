package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C1881l;
import com.google.android.gms.common.internal.C1886w.C1887a;

public class C1888a extends C1887a {
    int f6427a;

    public static Account m10683a(C1886w c1886w) {
        Account account = null;
        if (c1886w != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = c1886w.mo1654a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public Account mo1654a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.f6427a) {
            if (C1881l.m10638a(null, callingUid)) {
                this.f6427a = callingUid;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        Account account = null;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1888a)) {
            return false;
        }
        C1888a c1888a = (C1888a) obj;
        return account.equals(account);
    }
}
