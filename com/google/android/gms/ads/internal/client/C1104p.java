package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.ae.C1065a;
import com.google.android.gms.ads.internal.client.af.C1067a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.internal.C1914l;
import com.google.android.gms.p031b.fx;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p033a.C1001b;
import com.google.android.gms.p033a.C1003c;

@id
public final class C1104p extends C1003c<af> {
    public C1104p() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public ae m6228a(Context context, String str, fx fxVar) {
        try {
            return C1065a.m6014a(((af) m5715a(context)).mo1021a(C1001b.m5713a((Object) context), str, fxVar, C1914l.f6455a));
        } catch (Throwable e) {
            C1324b.m7235d("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (Throwable e2) {
            C1324b.m7235d("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    protected af m6229a(IBinder iBinder) {
        return C1067a.m6017a(iBinder);
    }

    protected /* synthetic */ Object mo1043b(IBinder iBinder) {
        return m6229a(iBinder);
    }
}
