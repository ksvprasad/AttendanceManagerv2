package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.mediation.C0959c;
import com.google.android.gms.ads.mediation.C0960g;
import com.google.android.gms.ads.mediation.C0961e;
import com.google.android.gms.ads.mediation.C0965i;
import com.google.android.gms.ads.mediation.C1344d;
import com.google.android.gms.ads.mediation.C1345f;
import com.google.android.gms.ads.mediation.C1346h;
import com.google.android.gms.common.internal.C1896c;

@id
public final class gf implements C1344d, C1345f, C1346h {
    private final fz f4914a;
    private C0965i f4915b;

    public gf(fz fzVar) {
        this.f4914a = fzVar;
    }

    public C0965i m8542a() {
        return this.f4915b;
    }

    public void mo1405a(C0959c c0959c) {
        C1896c.m10797b("onAdLoaded must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdLoaded.");
        try {
            this.f4914a.mo1339e();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdLoaded.", e);
        }
    }

    public void mo1406a(C0959c c0959c, int i) {
        C1896c.m10797b("onAdFailedToLoad must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.f4914a.mo1334a(i);
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdFailedToLoad.", e);
        }
    }

    public void mo1407a(C0961e c0961e) {
        C1896c.m10797b("onAdLoaded must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdLoaded.");
        try {
            this.f4914a.mo1339e();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdLoaded.", e);
        }
    }

    public void mo1408a(C0961e c0961e, int i) {
        C1896c.m10797b("onAdFailedToLoad must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.f4914a.mo1334a(i);
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdFailedToLoad.", e);
        }
    }

    public void mo1409a(C0960g c0960g) {
        C1896c.m10797b("onAdOpened must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdOpened.");
        try {
            this.f4914a.mo1338d();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdOpened.", e);
        }
    }

    public void mo1410a(C0960g c0960g, int i) {
        C1896c.m10797b("onAdFailedToLoad must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.f4914a.mo1334a(i);
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdFailedToLoad.", e);
        }
    }

    public void mo1411a(C0960g c0960g, C0965i c0965i) {
        C1896c.m10797b("onAdLoaded must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdLoaded.");
        this.f4915b = c0965i;
        try {
            this.f4914a.mo1339e();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdLoaded.", e);
        }
    }

    public void mo1412b(C0959c c0959c) {
        C1896c.m10797b("onAdOpened must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdOpened.");
        try {
            this.f4914a.mo1338d();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdOpened.", e);
        }
    }

    public void mo1413b(C0961e c0961e) {
        C1896c.m10797b("onAdOpened must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdOpened.");
        try {
            this.f4914a.mo1338d();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdOpened.", e);
        }
    }

    public void mo1414b(C0960g c0960g) {
        C1896c.m10797b("onAdClosed must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdClosed.");
        try {
            this.f4914a.mo1336b();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdClosed.", e);
        }
    }

    public void mo1415c(C0959c c0959c) {
        C1896c.m10797b("onAdClosed must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdClosed.");
        try {
            this.f4914a.mo1336b();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdClosed.", e);
        }
    }

    public void mo1416c(C0961e c0961e) {
        C1896c.m10797b("onAdClosed must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdClosed.");
        try {
            this.f4914a.mo1336b();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdClosed.", e);
        }
    }

    public void mo1417c(C0960g c0960g) {
        C1896c.m10797b("onAdLeftApplication must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdLeftApplication.");
        try {
            this.f4914a.mo1337c();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdLeftApplication.", e);
        }
    }

    public void mo1418d(C0959c c0959c) {
        C1896c.m10797b("onAdLeftApplication must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdLeftApplication.");
        try {
            this.f4914a.mo1337c();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdLeftApplication.", e);
        }
    }

    public void mo1419d(C0961e c0961e) {
        C1896c.m10797b("onAdLeftApplication must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdLeftApplication.");
        try {
            this.f4914a.mo1337c();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdLeftApplication.", e);
        }
    }

    public void mo1420d(C0960g c0960g) {
        C1896c.m10797b("onAdClicked must be called on the main UI thread.");
        C0965i a = m8542a();
        if (a == null) {
            C1324b.m7234d("Could not call onAdClicked since NativeAdMapper is null.");
        } else if (a.m5622b()) {
            C1324b.m7227a("Adapter called onAdClicked.");
            try {
                this.f4914a.mo1333a();
            } catch (Throwable e) {
                C1324b.m7235d("Could not call onAdClicked.", e);
            }
        } else {
            C1324b.m7227a("Could not call onAdClicked since setOverrideClickHandling is not set to true");
        }
    }

    public void mo1421e(C0959c c0959c) {
        C1896c.m10797b("onAdClicked must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdClicked.");
        try {
            this.f4914a.mo1333a();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdClicked.", e);
        }
    }

    public void mo1422e(C0961e c0961e) {
        C1896c.m10797b("onAdClicked must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdClicked.");
        try {
            this.f4914a.mo1333a();
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdClicked.", e);
        }
    }
}
