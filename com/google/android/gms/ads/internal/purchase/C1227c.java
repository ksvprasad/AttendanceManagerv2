package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.stats.C1959b;
import com.google.android.gms.p031b.hh;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.ju;
import com.google.android.gms.p031b.jv;
import com.google.android.gms.p031b.jz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@id
public class C1227c extends ju implements ServiceConnection {
    private final Object f3629a;
    private boolean f3630b;
    private Context f3631c;
    private hh f3632d;
    private C1225b f3633e;
    private C1236h f3634f;
    private List<C1232f> f3635g;
    private C1239k f3636h;

    public C1227c(Context context, hh hhVar, C1239k c1239k) {
        this(context, hhVar, c1239k, new C1225b(context), C1236h.m6837a(context.getApplicationContext()));
    }

    C1227c(Context context, hh hhVar, C1239k c1239k, C1225b c1225b, C1236h c1236h) {
        this.f3629a = new Object();
        this.f3630b = false;
        this.f3635g = null;
        this.f3631c = context;
        this.f3632d = hhVar;
        this.f3636h = c1239k;
        this.f3633e = c1225b;
        this.f3634f = c1236h;
        this.f3635g = this.f3634f.m6841a(10);
    }

    private void m6800a(long j) {
        do {
            if (!m6802b(j)) {
                jv.m9152e("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.f3630b);
    }

    private boolean m6802b(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f3629a.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            C1324b.m7234d("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void mo1108a() {
        synchronized (this.f3629a) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            C1959b.m11039a().m11052a(this.f3631c, intent, (ServiceConnection) this, 1);
            m6800a(SystemClock.elapsedRealtime());
            C1959b.m11039a().m11050a(this.f3631c, (ServiceConnection) this);
            this.f3633e.m6796a();
        }
    }

    protected void m6805a(final C1232f c1232f, String str, String str2) {
        final Intent intent = new Intent();
        C1319u.m7193o();
        intent.putExtra("RESPONSE_CODE", 0);
        C1319u.m7193o();
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        C1319u.m7193o();
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        jz.f5567a.post(new Runnable(this) {
            final /* synthetic */ C1227c f3628c;

            public void run() {
                try {
                    if (this.f3628c.f3636h.m6855a(c1232f.f3651b, -1, intent)) {
                        this.f3628c.f3632d.mo1431a(new C1234g(this.f3628c.f3631c, c1232f.f3652c, true, -1, intent, c1232f));
                    } else {
                        this.f3628c.f3632d.mo1431a(new C1234g(this.f3628c.f3631c, c1232f.f3652c, false, -1, intent, c1232f));
                    }
                } catch (RemoteException e) {
                    C1324b.m7234d("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    public void mo1109b() {
        synchronized (this.f3629a) {
            C1959b.m11039a().m11050a(this.f3631c, (ServiceConnection) this);
            this.f3633e.m6796a();
        }
    }

    protected void m6807c() {
        if (!this.f3635g.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (C1232f c1232f : this.f3635g) {
                hashMap.put(c1232f.f3652c, c1232f);
            }
            String str = null;
            while (true) {
                Bundle b = this.f3633e.m6798b(this.f3631c.getPackageName(), str);
                if (b == null || C1319u.m7193o().m6847a(b) != 0) {
                    break;
                }
                ArrayList stringArrayList = b.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList stringArrayList2 = b.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList stringArrayList3 = b.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String string = b.getString("INAPP_CONTINUATION_TOKEN");
                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (hashMap.containsKey(stringArrayList.get(i))) {
                        str = (String) stringArrayList.get(i);
                        String str2 = (String) stringArrayList2.get(i);
                        String str3 = (String) stringArrayList3.get(i);
                        C1232f c1232f2 = (C1232f) hashMap.get(str);
                        if (c1232f2.f3651b.equals(C1319u.m7193o().m6848a(str2))) {
                            m6805a(c1232f2, str2, str3);
                            hashMap.remove(str);
                        }
                    }
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str4 : hashMap.keySet()) {
                this.f3634f.m6842a((C1232f) hashMap.get(str4));
            }
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f3629a) {
            this.f3633e.m6797a(iBinder);
            m6807c();
            this.f3630b = true;
            this.f3629a.notify();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C1324b.m7232c("In-app billing service disconnected.");
        this.f3633e.m6796a();
    }
}
