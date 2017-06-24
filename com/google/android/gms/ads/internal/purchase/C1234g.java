package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.stats.C1959b;
import com.google.android.gms.p031b.hg.C1233a;
import com.google.android.gms.p031b.id;

@id
public final class C1234g extends C1233a implements ServiceConnection {
    C1225b f3653a;
    private boolean f3654b = false;
    private Context f3655c;
    private int f3656d;
    private Intent f3657e;
    private C1232f f3658f;
    private String f3659g;

    public C1234g(Context context, String str, boolean z, int i, Intent intent, C1232f c1232f) {
        this.f3659g = str;
        this.f3656d = i;
        this.f3657e = intent;
        this.f3654b = z;
        this.f3655c = context;
        this.f3658f = c1232f;
    }

    public boolean mo1168a() {
        return this.f3654b;
    }

    public String mo1169b() {
        return this.f3659g;
    }

    public Intent mo1170c() {
        return this.f3657e;
    }

    public int mo1171d() {
        return this.f3656d;
    }

    public void mo1172e() {
        int a = C1319u.m7193o().m6846a(this.f3657e);
        if (this.f3656d == -1 && a == 0) {
            this.f3653a = new C1225b(this.f3655c);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            C1959b.m11039a().m11052a(this.f3655c, intent, (ServiceConnection) this, 1);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C1324b.m7232c("In-app billing service connected.");
        this.f3653a.m6797a(iBinder);
        String b = C1319u.m7193o().m6852b(C1319u.m7193o().m6851b(this.f3657e));
        if (b != null) {
            if (this.f3653a.m6794a(this.f3655c.getPackageName(), b) == 0) {
                C1236h.m6837a(this.f3655c).m6842a(this.f3658f);
            }
            C1959b.m11039a().m11050a(this.f3655c, (ServiceConnection) this);
            this.f3653a.m6796a();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C1324b.m7232c("In-app billing service disconnected.");
        this.f3653a.m6796a();
    }
}
