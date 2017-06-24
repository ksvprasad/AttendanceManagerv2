package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.p037a.C1354a;
import com.google.android.gms.common.api.C1767c.C1733c;
import com.google.android.gms.common.api.C1767c.C1742b;
import com.google.android.gms.common.internal.C1268k.C1911i;
import com.google.android.gms.common.internal.C1724r;
import com.google.android.gms.common.internal.C1886w;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.C1927n;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.p031b.oa;
import com.google.android.gms.p031b.ob;
import com.google.android.gms.signin.internal.C2103e.C2105a;

public class C2107g extends C1724r<C2103e> implements oa {
    private final boolean f7056a;
    private final C1927n f7057e;
    private final Bundle f7058f;
    private Integer f7059g;

    public C2107g(Context context, Looper looper, boolean z, C1927n c1927n, Bundle bundle, C1742b c1742b, C1733c c1733c) {
        super(context, looper, 44, c1927n, c1742b, c1733c);
        this.f7056a = z;
        this.f7057e = c1927n;
        this.f7058f = bundle;
        this.f7059g = c1927n.m10877i();
    }

    public C2107g(Context context, Looper looper, boolean z, C1927n c1927n, ob obVar, C1742b c1742b, C1733c c1733c) {
        this(context, looper, z, c1927n, C2107g.m12066a(c1927n), c1742b, c1733c);
    }

    public static Bundle m12066a(C1927n c1927n) {
        ob h = c1927n.m10876h();
        Integer i = c1927n.m10877i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c1927n.m10868a());
        if (i != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", i.intValue());
        }
        if (h != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h.m10336a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h.m10337b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h.m10338c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h.m10339d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h.m10340e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h.m10341f());
            if (h.m10342g() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", h.m10342g().longValue());
            }
            if (h.m10343h() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", h.m10343h().longValue());
            }
        }
        return bundle;
    }

    private ResolveAccountRequest m12067x() {
        Account b = this.f7057e.m10870b();
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(b.name)) {
            googleSignInAccount = C1354a.m7318a(m6975o()).m7320a();
        }
        return new ResolveAccountRequest(b, this.f7059g.intValue(), googleSignInAccount);
    }

    protected C2103e m12068a(IBinder iBinder) {
        return C2105a.m12062a(iBinder);
    }

    protected String mo1181a() {
        return "com.google.android.gms.signin.service.START";
    }

    public void mo1770a(C1886w c1886w, boolean z) {
        try {
            ((C2103e) m6981u()).mo1764a(c1886w, this.f7059g.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void mo1771a(C1759d c1759d) {
        C1896c.m10791a((Object) c1759d, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((C2103e) m6981u()).mo1767a(new SignInRequest(m12067x()), c1759d);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                c1759d.mo1600a(new SignInResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    protected /* synthetic */ IInterface mo1182b(IBinder iBinder) {
        return m12068a(iBinder);
    }

    protected String mo1183b() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public boolean mo1772f() {
        return this.f7056a;
    }

    public void mo1702k() {
        try {
            ((C2103e) m6981u()).mo1760a(this.f7059g.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public void mo1773l() {
        m6959a(new C1911i(this));
    }

    protected Bundle mo1774r() {
        if (!m6975o().getPackageName().equals(this.f7057e.m10874f())) {
            this.f7058f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f7057e.m10874f());
        }
        return this.f7058f;
    }
}
