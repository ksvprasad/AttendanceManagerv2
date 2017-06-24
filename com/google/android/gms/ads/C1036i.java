package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.C1081c;
import com.google.android.gms.ads.internal.client.C1100l;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.id;

@id
public final class C1036i {
    private final Object f3045a = new Object();
    private C1081c f3046b;
    private C1035a f3047c;

    public static abstract class C1035a {
        public void m5831a() {
        }
    }

    public void m5832a(C1035a c1035a) {
        C1896c.m10791a((Object) c1035a, (Object) "VideoLifecycleCallbacks may not be null.");
        synchronized (this.f3045a) {
            this.f3047c = c1035a;
            if (this.f3046b == null) {
                return;
            }
            try {
                this.f3046b.mo1032a(new C1100l(c1035a));
            } catch (Throwable e) {
                C1324b.m7231b("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public void m5833a(C1081c c1081c) {
        synchronized (this.f3045a) {
            this.f3046b = c1081c;
            if (this.f3047c != null) {
                m5832a(this.f3047c);
            }
        }
    }
}
