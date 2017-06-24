package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ap.C0227a;
import android.support.v4.app.ap.C0227a.C0221a;

public final class an extends C0227a {
    public static final C0221a f851a = new C02221();
    private static final C0223a f852g;
    private final String f853b;
    private final CharSequence f854c;
    private final CharSequence[] f855d;
    private final boolean f856e;
    private final Bundle f857f;

    static class C02221 implements C0221a {
        C02221() {
        }
    }

    interface C0223a {
    }

    static class C0224b implements C0223a {
        C0224b() {
        }
    }

    static class C0225c implements C0223a {
        C0225c() {
        }
    }

    static class C0226d implements C0223a {
        C0226d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            f852g = new C0224b();
        } else if (VERSION.SDK_INT >= 16) {
            f852g = new C0226d();
        } else {
            f852g = new C0225c();
        }
    }

    public String mo178a() {
        return this.f853b;
    }

    public CharSequence mo179b() {
        return this.f854c;
    }

    public CharSequence[] mo180c() {
        return this.f855d;
    }

    public boolean mo181d() {
        return this.f856e;
    }

    public Bundle mo182e() {
        return this.f857f;
    }
}
