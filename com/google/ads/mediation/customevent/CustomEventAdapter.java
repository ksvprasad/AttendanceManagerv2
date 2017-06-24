package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.C0955a.C0953a;
import com.google.ads.C0956b;
import com.google.ads.mediation.C0977b;
import com.google.ads.mediation.C0983d;
import com.google.ads.mediation.C0984f;
import com.google.ads.mediation.C0990e;
import com.google.ads.mediation.C0991g;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.mediation.customevent.C1341d;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class CustomEventAdapter implements C0983d<C1341d, C0989f>, C0984f<C1341d, C0989f> {
    C0986b f2971a;
    C0987d f2972b;
    private View f2973c;

    static final class C0980a implements C0979c {
        private final CustomEventAdapter f2966a;
        private final C0990e f2967b;

        public C0980a(CustomEventAdapter customEventAdapter, C0990e c0990e) {
            this.f2966a = customEventAdapter;
            this.f2967b = c0990e;
        }
    }

    class C0982b implements C0981e {
        final /* synthetic */ CustomEventAdapter f2968a;
        private final CustomEventAdapter f2969b;
        private final C0991g f2970c;

        public C0982b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, C0991g c0991g) {
            this.f2968a = customEventAdapter;
            this.f2969b = customEventAdapter2;
            this.f2970c = c0991g;
        }
    }

    private static <T> T m5691a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String valueOf = String.valueOf(th.getMessage());
            C1324b.m7234d(new StringBuilder((String.valueOf(str).length() + 46) + String.valueOf(valueOf).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(valueOf).toString());
            return null;
        }
    }

    C0982b m5692a(C0991g c0991g) {
        return new C0982b(this, this, c0991g);
    }

    public void mo918a() {
        if (this.f2971a != null) {
            this.f2971a.m5702a();
        }
        if (this.f2972b != null) {
            this.f2972b.m5702a();
        }
    }

    public void m5694a(C0990e c0990e, Activity activity, C0989f c0989f, C0956b c0956b, C0977b c0977b, C1341d c1341d) {
        this.f2971a = (C0986b) m5691a(c0989f.f2975b);
        if (this.f2971a == null) {
            c0990e.mo1426a(this, C0953a.INTERNAL_ERROR);
        } else {
            this.f2971a.m5703a(new C0980a(this, c0990e), activity, c0989f.f2974a, c0989f.f2976c, c0956b, c0977b, c1341d == null ? null : c1341d.m7273a(c0989f.f2974a));
        }
    }

    public void m5696a(C0991g c0991g, Activity activity, C0989f c0989f, C0977b c0977b, C1341d c1341d) {
        this.f2972b = (C0987d) m5691a(c0989f.f2975b);
        if (this.f2972b == null) {
            c0991g.mo1427a(this, C0953a.INTERNAL_ERROR);
        } else {
            this.f2972b.m5704a(m5692a(c0991g), activity, c0989f.f2974a, c0989f.f2976c, c0977b, c1341d == null ? null : c1341d.m7273a(c0989f.f2974a));
        }
    }

    public Class<C1341d> mo921b() {
        return C1341d.class;
    }

    public Class<C0989f> mo922c() {
        return C0989f.class;
    }

    public View mo923d() {
        return this.f2973c;
    }

    public void mo924e() {
        this.f2972b.m5705b();
    }
}
