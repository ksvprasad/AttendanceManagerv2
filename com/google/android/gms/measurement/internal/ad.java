package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.C1896c;

class ad extends BroadcastReceiver {
    static final String f6742a = ad.class.getName();
    private final aj f6743b;
    private boolean f6744c;
    private boolean f6745d;

    ad(aj ajVar) {
        C1896c.m10790a((Object) ajVar);
        this.f6743b = ajVar;
    }

    private Context m11340d() {
        return this.f6743b.m11513q();
    }

    private ab m11341e() {
        return this.f6743b.m11502f();
    }

    public void m11342a() {
        this.f6743b.m11479a();
        this.f6743b.m11521y();
        if (!this.f6744c) {
            m11340d().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f6745d = this.f6743b.m11512p().m11319f();
            m11341e().m11283E().m11250a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f6745d));
            this.f6744c = true;
        }
    }

    public void m11343b() {
        this.f6743b.m11479a();
        this.f6743b.m11521y();
        if (m11344c()) {
            m11341e().m11283E().m11249a("Unregistering connectivity change receiver");
            this.f6744c = false;
            this.f6745d = false;
            try {
                m11340d().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                m11341e().m11290f().m11250a("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public boolean m11344c() {
        this.f6743b.m11521y();
        return this.f6744c;
    }

    public void onReceive(Context context, Intent intent) {
        this.f6743b.m11479a();
        String action = intent.getAction();
        m11341e().m11283E().m11250a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            final boolean f = this.f6743b.m11512p().m11319f();
            if (this.f6745d != f) {
                this.f6745d = f;
                this.f6743b.m11504h().m11424a(new Runnable(this) {
                    final /* synthetic */ ad f6741b;

                    public void run() {
                        this.f6741b.f6743b.m11488a(f);
                    }
                });
                return;
            }
            return;
        }
        m11341e().m11310z().m11250a("NetworkBroadcastReceiver received unknown action", action);
    }
}
