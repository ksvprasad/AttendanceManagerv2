package com.google.android.gms.p031b;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.C1877b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.p031b.mr.C1736a;

public abstract class md extends mv implements OnCancelListener {
    protected boolean f5841a;
    protected boolean f5842b;
    protected final C1877b f5843c;
    private ConnectionResult f5844e;
    private int f5845f;
    private final Handler f5846g;

    private class C1738a implements Runnable {
        final /* synthetic */ md f5852a;

        private C1738a(md mdVar) {
            this.f5852a = mdVar;
        }

        public void run() {
            if (!this.f5852a.f5841a) {
                return;
            }
            if (this.f5852a.f5844e.m10546a()) {
                this.f5852a.d.startActivityForResult(GoogleApiActivity.m10556b(this.f5852a.m9759e(), this.f5852a.f5844e.m10549d(), this.f5852a.f5845f, false), 1);
            } else if (this.f5852a.f5843c.mo1647a(this.f5852a.f5844e.m10548c())) {
                this.f5852a.f5843c.m10630a(this.f5852a.m9759e(), this.f5852a.d, this.f5852a.f5844e.m10548c(), 2, this.f5852a);
            } else if (this.f5852a.f5844e.m10548c() == 18) {
                final Dialog a = this.f5852a.f5843c.m10620a(this.f5852a.m9759e(), this.f5852a);
                this.f5852a.f5843c.m10626a(this.f5852a.m9759e().getApplicationContext(), new C1736a(this) {
                    final /* synthetic */ C1738a f5851b;

                    public void mo1573a() {
                        this.f5851b.f5852a.m9770d();
                        if (a.isShowing()) {
                            a.dismiss();
                        }
                    }
                });
            } else {
                this.f5852a.mo1570a(this.f5852a.f5844e, this.f5852a.f5845f);
            }
        }
    }

    protected md(mw mwVar) {
        this(mwVar, C1877b.m10617a());
    }

    md(mw mwVar, C1877b c1877b) {
        super(mwVar);
        this.f5845f = -1;
        this.f5846g = new Handler(Looper.getMainLooper());
        this.f5843c = c1877b;
    }

    public void mo1565a() {
        super.mo1565a();
        this.f5841a = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1566a(int r6, int r7, android.content.Intent r8) {
        /*
        r5 = this;
        r4 = 18;
        r2 = 13;
        r0 = 1;
        r1 = 0;
        switch(r6) {
            case 1: goto L_0x0027;
            case 2: goto L_0x0010;
            default: goto L_0x0009;
        };
    L_0x0009:
        r0 = r1;
    L_0x000a:
        if (r0 == 0) goto L_0x003d;
    L_0x000c:
        r5.m9770d();
    L_0x000f:
        return;
    L_0x0010:
        r2 = r5.f5843c;
        r3 = r5.m9759e();
        r2 = r2.mo1643a(r3);
        if (r2 != 0) goto L_0x0047;
    L_0x001c:
        r1 = r5.f5844e;
        r1 = r1.m10548c();
        if (r1 != r4) goto L_0x000a;
    L_0x0024:
        if (r2 != r4) goto L_0x000a;
    L_0x0026:
        goto L_0x000f;
    L_0x0027:
        r3 = -1;
        if (r7 == r3) goto L_0x000a;
    L_0x002a:
        if (r7 != 0) goto L_0x0009;
    L_0x002c:
        if (r8 == 0) goto L_0x0045;
    L_0x002e:
        r0 = "<<ResolutionFailureErrorDetail>>";
        r0 = r8.getIntExtra(r0, r2);
    L_0x0034:
        r2 = new com.google.android.gms.common.ConnectionResult;
        r3 = 0;
        r2.<init>(r0, r3);
        r5.f5844e = r2;
        goto L_0x0009;
    L_0x003d:
        r0 = r5.f5844e;
        r1 = r5.f5845f;
        r5.mo1570a(r0, r1);
        goto L_0x000f;
    L_0x0045:
        r0 = r2;
        goto L_0x0034;
    L_0x0047:
        r0 = r1;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.md.a(int, int, android.content.Intent):void");
    }

    public void mo1567a(Bundle bundle) {
        super.mo1567a(bundle);
        if (bundle != null) {
            this.f5842b = bundle.getBoolean("resolving_error", false);
            if (this.f5842b) {
                this.f5845f = bundle.getInt("failed_client_id", -1);
                this.f5844e = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    protected abstract void mo1570a(ConnectionResult connectionResult, int i);

    public void mo1568b() {
        super.mo1568b();
        this.f5841a = false;
    }

    public void mo1569b(Bundle bundle) {
        super.mo1569b(bundle);
        bundle.putBoolean("resolving_error", this.f5842b);
        if (this.f5842b) {
            bundle.putInt("failed_client_id", this.f5845f);
            bundle.putInt("failed_status", this.f5844e.m10548c());
            bundle.putParcelable("failed_resolution", this.f5844e.m10549d());
        }
    }

    public void m9768b(ConnectionResult connectionResult, int i) {
        if (!this.f5842b) {
            this.f5842b = true;
            this.f5845f = i;
            this.f5844e = connectionResult;
            this.f5846g.post(new C1738a());
        }
    }

    protected abstract void mo1572c();

    protected void m9770d() {
        this.f5845f = -1;
        this.f5842b = false;
        this.f5844e = null;
        mo1572c();
    }

    public void onCancel(DialogInterface dialogInterface) {
        mo1570a(new ConnectionResult(13, null), this.f5845f);
        m9770d();
    }
}
