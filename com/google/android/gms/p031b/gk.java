package com.google.android.gms.p031b;

import com.google.ads.C0955a.C0953a;
import com.google.ads.mediation.C0983d;
import com.google.ads.mediation.C0984f;
import com.google.ads.mediation.C0988h;
import com.google.ads.mediation.C0990e;
import com.google.ads.mediation.C0991g;
import com.google.ads.mediation.C0994i;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.util.client.C1323a;
import com.google.android.gms.ads.internal.util.client.C1324b;

@id
public final class gk<NETWORK_EXTRAS extends C0994i, SERVER_PARAMETERS extends C0988h> implements C0990e, C0991g {
    private final fz f4933a;

    public gk(fz fzVar) {
        this.f4933a = fzVar;
    }

    public void mo1426a(C0983d<?, ?> c0983d, final C0953a c0953a) {
        String valueOf = String.valueOf(c0953a);
        C1324b.m7227a(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(valueOf).toString());
        if (C1120y.m6293a().m7222b()) {
            try {
                this.f4933a.mo1334a(gl.m8624a(c0953a));
                return;
            } catch (Throwable e) {
                C1324b.m7235d("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        C1324b.m7234d("onFailedToReceiveAd must be called on the main UI thread.");
        C1323a.f3964a.post(new Runnable(this) {
            final /* synthetic */ gk f4932b;

            public void run() {
                try {
                    this.f4932b.f4933a.mo1334a(gl.m8624a(c0953a));
                } catch (Throwable e) {
                    C1324b.m7235d("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void mo1427a(C0984f<?, ?> c0984f, final C0953a c0953a) {
        String valueOf = String.valueOf(c0953a);
        C1324b.m7227a(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(valueOf).append(".").toString());
        if (C1120y.m6293a().m7222b()) {
            try {
                this.f4933a.mo1334a(gl.m8624a(c0953a));
                return;
            } catch (Throwable e) {
                C1324b.m7235d("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        C1324b.m7234d("onFailedToReceiveAd must be called on the main UI thread.");
        C1323a.f3964a.post(new Runnable(this) {
            final /* synthetic */ gk f4930b;

            public void run() {
                try {
                    this.f4930b.f4933a.mo1334a(gl.m8624a(c0953a));
                } catch (Throwable e) {
                    C1324b.m7235d("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }
}
