package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.ag.C1039a;
import com.google.android.gms.ads.internal.client.ah.C1070a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.internal.C1914l;
import com.google.android.gms.p031b.fx;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p033a.C1001b;
import com.google.android.gms.p033a.C1003c;
import com.google.android.gms.p033a.C1003c.C1002a;

@id
public class C1105q extends C1003c<ah> {
    public C1105q() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public ag m6231a(Context context, AdSizeParcel adSizeParcel, String str, fx fxVar, int i) {
        Throwable e;
        try {
            return C1039a.m5857a(((ah) m5715a(context)).mo1023a(C1001b.m5713a((Object) context), adSizeParcel, str, fxVar, C1914l.f6455a, i));
        } catch (RemoteException e2) {
            e = e2;
            C1324b.m7228a("Could not create remote AdManager.", e);
            return null;
        } catch (C1002a e3) {
            e = e3;
            C1324b.m7228a("Could not create remote AdManager.", e);
            return null;
        }
    }

    protected ah m6232a(IBinder iBinder) {
        return C1070a.m6045a(iBinder);
    }

    protected /* synthetic */ Object mo1043b(IBinder iBinder) {
        return m6232a(iBinder);
    }
}
