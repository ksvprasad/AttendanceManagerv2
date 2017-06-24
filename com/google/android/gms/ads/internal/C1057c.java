package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.cy;
import com.google.android.gms.p031b.cz;
import com.google.android.gms.p031b.db;
import com.google.android.gms.p031b.dc;
import com.google.android.gms.p031b.eb;
import com.google.android.gms.p031b.fg;
import com.google.android.gms.p031b.fx;
import com.google.android.gms.p031b.gv;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jf;
import com.google.android.gms.p031b.jl;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.jz;
import com.google.android.gms.p031b.la;
import java.util.Map;

@id
public abstract class C1057c extends C1050b implements C1056h, gv {

    class C10511 implements eb {
        final /* synthetic */ C1057c f3074a;

        C10511(C1057c c1057c) {
            this.f3074a = c1057c;
        }

        public void mo997a(la laVar, Map<String, String> map) {
            if (this.f3074a.f.f3997j != null) {
                this.f3074a.h.m7657a(this.f3074a.f.f3996i, this.f3074a.f.f3997j, laVar.mo1503b(), (fg) laVar);
            } else {
                C1324b.m7234d("Request to enable ActiveView before adState is available.");
            }
        }
    }

    public C1057c(Context context, AdSizeParcel adSizeParcel, String str, fx fxVar, VersionInfoParcel versionInfoParcel, C1122d c1122d) {
        super(context, adSizeParcel, str, fxVar, versionInfoParcel, c1122d);
    }

    public void mo998D() {
        mo915e();
    }

    public void mo999E() {
        m5923A();
        mo971h();
    }

    public void mo1000F() {
        mo1115o();
    }

    protected la mo1048a(C1632a c1632a, C1123e c1123e, jf jfVar) {
        la laVar = null;
        View nextView = this.f.f3993f.getNextView();
        if (nextView instanceof la) {
            laVar = (la) nextView;
            if (((Boolean) cq.ac.m7801c()).booleanValue()) {
                C1324b.m7227a("Reusing webview...");
                laVar.mo1495a(this.f.f3990c, this.f.f3996i, this.a);
            } else {
                laVar.destroy();
                laVar = null;
            }
        }
        if (laVar == null) {
            if (nextView != null) {
                this.f.f3993f.removeView(nextView);
            }
            laVar = C1319u.m7184f().m9481a(this.f.f3990c, this.f.f3996i, false, false, this.f.f3991d, this.f.f3992e, this.a, this, this.i);
            if (this.f.f3996i.f3110h == null) {
                m5869a(laVar.mo1503b());
            }
        }
        fg fgVar = laVar;
        fgVar.mo1519l().m9459a(this, this, this, this, false, this, null, c1123e, this, jfVar);
        m5962a(fgVar);
        fgVar.mo1506b(c1632a.f5408a.f3761w);
        return fgVar;
    }

    public void mo1001a(int i, int i2, int i3, int i4) {
        m5908q();
    }

    public void mo956a(dc dcVar) {
        C1896c.m10797b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.f.f4012y = dcVar;
    }

    protected void m5962a(fg fgVar) {
        fgVar.mo1319a("/trackActiveViewUnit", new C10511(this));
    }

    protected void mo1002a(final C1632a c1632a, final cy cyVar) {
        jf jfVar = null;
        if (c1632a.f5412e != -2) {
            jz.f5567a.post(new Runnable(this) {
                final /* synthetic */ C1057c f3076b;

                public void run() {
                    this.f3076b.mo966b(new jl(c1632a, null, null, null, null, null, null, null));
                }
            });
            return;
        }
        if (c1632a.f5411d != null) {
            this.f.f3996i = c1632a.f5411d;
        }
        if (!c1632a.f5409b.f3786h || c1632a.f5409b.f3766B) {
            if (((Boolean) cq.bI.m7801c()).booleanValue()) {
                jfVar = this.i.f3285d.mo1459a(this.f.f3990c, c1632a.f5409b);
            }
            jz.f5567a.post(new Runnable(this) {
                final /* synthetic */ C1057c f3084d;

                public void run() {
                    if (c1632a.f5409b.f3797s && this.f3084d.f.f4012y != null) {
                        String str = null;
                        if (c1632a.f5409b.f3780b != null) {
                            str = C1319u.m7183e().m9207a(c1632a.f5409b.f3780b);
                        }
                        db czVar = new cz(this.f3084d, str, c1632a.f5409b.f3781c);
                        this.f3084d.f.f3978E = 1;
                        try {
                            this.f3084d.d = false;
                            this.f3084d.f.f4012y.mo1280a(czVar);
                            return;
                        } catch (Throwable e) {
                            C1324b.m7235d("Could not call the onCustomRenderedAdLoadedListener.", e);
                            this.f3084d.d = true;
                        }
                    }
                    final C1123e c1123e = new C1123e(this.f3084d.f.f3990c, c1632a);
                    la a = this.f3084d.mo1048a(c1632a, c1123e, jfVar);
                    a.setOnTouchListener(new OnTouchListener(this) {
                        final /* synthetic */ C10553 f3078b;

                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            c1123e.m6299a();
                            return false;
                        }
                    });
                    a.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ C10553 f3080b;

                        public void onClick(View view) {
                            c1123e.m6299a();
                        }
                    });
                    this.f3084d.f.f3978E = 0;
                    this.f3084d.f.f3995h = C1319u.m7182d().m8766a(this.f3084d.f.f3990c, this.f3084d, c1632a, this.f3084d.f.f3991d, a, this.f3084d.j, this.f3084d, cyVar);
                }
            });
            return;
        }
        this.f.f3978E = 0;
        this.f.f3995h = C1319u.m7182d().m8766a(this.f.f3990c, this, c1632a, this.f.f3991d, null, this.j, this, cyVar);
    }

    protected boolean mo982a(jl jlVar, jl jlVar2) {
        if (this.f.m7250e() && this.f.f3993f != null) {
            this.f.f3993f.m7240a().m9313a(jlVar2.f5418C);
        }
        return super.mo982a(jlVar, jlVar2);
    }

    public void mo1003b(View view) {
        this.f.f3977D = view;
        mo966b(new jl(this.f.f3998k, null, null, null, null, null, null, null));
    }
}
