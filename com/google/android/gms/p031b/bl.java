package com.google.android.gms.p031b;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.C1876j;
import com.google.android.gms.p031b.bn.C1372a;
import com.google.android.gms.p031b.bo.C1376a;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;
import com.google.android.gms.p033a.C1003c;
import com.google.android.gms.p033a.C1003c.C1002a;

public final class bl extends C1003c<bo> {
    private static final bl f4206a = new bl();

    private bl() {
        super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
    }

    public static bn m7570a(String str, Context context, boolean z) {
        if (C1876j.m10605b().mo1643a(context) == 0) {
            bn b = f4206a.m7571b(str, context, z);
            if (b != null) {
                return b;
            }
        }
        return new bk(str, context, z);
    }

    private bn m7571b(String str, Context context, boolean z) {
        IBinder a;
        C0998a a2 = C1001b.m5713a((Object) context);
        if (z) {
            try {
                a = ((bo) m5715a(context)).mo1251a(str, a2);
            } catch (RemoteException e) {
                return null;
            } catch (C1002a e2) {
                return null;
            }
        }
        a = ((bo) m5715a(context)).mo1252b(str, a2);
        return C1372a.m7557a(a);
    }

    protected bo m7572a(IBinder iBinder) {
        return C1376a.m7591a(iBinder);
    }

    protected /* synthetic */ Object mo1043b(IBinder iBinder) {
        return m7572a(iBinder);
    }
}
