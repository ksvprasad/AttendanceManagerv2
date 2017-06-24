package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.hc;
import com.google.android.gms.p031b.he.C1230a;
import com.google.android.gms.p031b.id;

@id
public class C1231e extends C1230a implements ServiceConnection {
    C1236h f3641a;
    private final Activity f3642b;
    private Context f3643c;
    private hc f3644d;
    private C1225b f3645e;
    private C1232f f3646f;
    private C1048j f3647g;
    private C1239k f3648h;
    private String f3649i = null;

    public C1231e(Activity activity) {
        this.f3642b = activity;
        this.f3641a = C1236h.m6837a(this.f3642b.getApplicationContext());
    }

    public void mo1165a() {
        GInAppPurchaseManagerInfoParcel a = GInAppPurchaseManagerInfoParcel.m6784a(this.f3642b.getIntent());
        this.f3647g = a.f3622e;
        this.f3648h = a.f3619b;
        this.f3644d = a.f3620c;
        this.f3645e = new C1225b(this.f3642b.getApplicationContext());
        this.f3643c = a.f3621d;
        if (this.f3642b.getResources().getConfiguration().orientation == 2) {
            this.f3642b.setRequestedOrientation(C1319u.m7185g().mo1463a());
        } else {
            this.f3642b.setRequestedOrientation(C1319u.m7185g().mo1465b());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        this.f3642b.bindService(intent, this, 1);
    }

    public void mo1166a(int i, int i2, Intent intent) {
        if (i == 1001) {
            boolean z = false;
            try {
                int a = C1319u.m7193o().m6846a(intent);
                if (i2 == -1) {
                    C1319u.m7193o();
                    if (a == 0) {
                        if (this.f3648h.m6855a(this.f3649i, i2, intent)) {
                            z = true;
                        }
                        this.f3644d.mo1164c(a);
                        this.f3642b.finish();
                        m6824a(this.f3644d.mo1162a(), z, i2, intent);
                    }
                }
                this.f3641a.m6842a(this.f3646f);
                this.f3644d.mo1164c(a);
                this.f3642b.finish();
                m6824a(this.f3644d.mo1162a(), z, i2, intent);
            } catch (RemoteException e) {
                C1324b.m7234d("Fail to process purchase result.");
                this.f3642b.finish();
            } finally {
                this.f3649i = null;
            }
        }
    }

    protected void m6824a(String str, boolean z, int i, Intent intent) {
        if (this.f3647g != null) {
            this.f3647g.mo979a(str, z, i, intent, this.f3646f);
        }
    }

    public void mo1167b() {
        this.f3642b.unbindService(this);
        this.f3645e.m6796a();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Throwable e;
        this.f3645e.m6797a(iBinder);
        try {
            this.f3649i = this.f3648h.m6854a();
            Bundle a = this.f3645e.m6795a(this.f3642b.getPackageName(), this.f3644d.mo1162a(), this.f3649i);
            PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int a2 = C1319u.m7193o().m6847a(a);
                this.f3644d.mo1164c(a2);
                m6824a(this.f3644d.mo1162a(), false, a2, null);
                this.f3642b.finish();
                return;
            }
            this.f3646f = new C1232f(this.f3644d.mo1162a(), this.f3649i);
            this.f3641a.m6844b(this.f3646f);
            this.f3642b.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (RemoteException e2) {
            e = e2;
            C1324b.m7235d("Error when connecting in-app billing service", e);
            this.f3642b.finish();
        } catch (SendIntentException e3) {
            e = e3;
            C1324b.m7235d("Error when connecting in-app billing service", e);
            this.f3642b.finish();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C1324b.m7232c("In-app billing service disconnected.");
        this.f3645e.m6796a();
    }
}
