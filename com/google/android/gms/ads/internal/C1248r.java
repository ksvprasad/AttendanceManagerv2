package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jz;
import java.lang.ref.WeakReference;

@id
public class C1248r {
    private final C1247a f3680a;
    private final Runnable f3681b;
    private AdRequestParcel f3682c;
    private boolean f3683d;
    private boolean f3684e;
    private long f3685f;

    public static class C1247a {
        private final Handler f3679a;

        public C1247a(Handler handler) {
            this.f3679a = handler;
        }

        public void m6880a(Runnable runnable) {
            this.f3679a.removeCallbacks(runnable);
        }

        public boolean m6881a(Runnable runnable, long j) {
            return this.f3679a.postDelayed(runnable, j);
        }
    }

    public C1248r(C1043a c1043a) {
        this(c1043a, new C1247a(jz.f5567a));
    }

    C1248r(C1043a c1043a, C1247a c1247a) {
        this.f3683d = false;
        this.f3684e = false;
        this.f3685f = 0;
        this.f3680a = c1247a;
        final WeakReference weakReference = new WeakReference(c1043a);
        this.f3681b = new Runnable(this) {
            final /* synthetic */ C1248r f3678b;

            public void run() {
                this.f3678b.f3683d = false;
                C1043a c1043a = (C1043a) weakReference.get();
                if (c1043a != null) {
                    c1043a.m5895c(this.f3678b.f3682c);
                }
            }
        };
    }

    public void m6884a() {
        this.f3683d = false;
        this.f3680a.m6880a(this.f3681b);
    }

    public void m6885a(AdRequestParcel adRequestParcel) {
        m6886a(adRequestParcel, 60000);
    }

    public void m6886a(AdRequestParcel adRequestParcel, long j) {
        if (this.f3683d) {
            C1324b.m7234d("An ad refresh is already scheduled.");
            return;
        }
        this.f3682c = adRequestParcel;
        this.f3683d = true;
        this.f3685f = j;
        if (!this.f3684e) {
            C1324b.m7232c("Scheduling ad refresh " + j + " milliseconds from now.");
            this.f3680a.m6881a(this.f3681b, j);
        }
    }

    public void m6887b() {
        this.f3684e = true;
        if (this.f3683d) {
            this.f3680a.m6880a(this.f3681b);
        }
    }

    public void m6888c() {
        this.f3684e = false;
        if (this.f3683d) {
            this.f3683d = false;
            m6886a(this.f3682c, this.f3685f);
        }
    }

    public boolean m6889d() {
        return this.f3683d;
    }
}
