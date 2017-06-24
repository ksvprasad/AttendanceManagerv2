package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1970c;
import com.google.android.gms.common.util.C1971d;
import com.google.android.gms.measurement.AppMeasurement.C2010b;
import com.google.android.gms.measurement.AppMeasurement.C2011c;
import java.util.HashSet;
import java.util.Set;

public class C2053d extends C2019b {
    private C2052a f6894a;
    private C2010b f6895b;
    private final Set<C2011c> f6896c = new HashSet();
    private boolean f6897d;

    class C20491 implements Runnable {
        final /* synthetic */ boolean f6877a;
        final /* synthetic */ C2053d f6878b;

        public void run() {
            this.f6878b.m11572a(this.f6877a);
        }
    }

    @TargetApi(14)
    private class C2052a implements ActivityLifecycleCallbacks {
        final /* synthetic */ C2053d f6893a;

        private C2052a(C2053d c2053d) {
            this.f6893a = c2053d;
        }

        private boolean m11564a(Uri uri) {
            Object queryParameter = uri.getQueryParameter("utm_campaign");
            Object queryParameter2 = uri.getQueryParameter("utm_source");
            Object queryParameter3 = uri.getQueryParameter("utm_medium");
            Object queryParameter4 = uri.getQueryParameter("gclid");
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4)) {
                return false;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            queryParameter = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("content", queryParameter);
            }
            queryParameter = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("aclid", queryParameter);
            }
            queryParameter = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("cp1", queryParameter);
            }
            queryParameter = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("anid", queryParameter);
            }
            this.f6893a.m11579a("auto", "_cmp", bundle);
            return true;
        }

        private boolean m11565a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.f6893a.m11581a("auto", "_ldl", (Object) str);
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                this.f6893a.mo1746w().m11283E().m11249a("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        if (bundle == null) {
                            m11564a(data);
                        }
                        String queryParameter = data.getQueryParameter("referrer");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            if (queryParameter.contains("gclid")) {
                                this.f6893a.mo1746w().m11282D().m11250a("Activity created with referrer", queryParameter);
                                m11565a(queryParameter);
                                return;
                            }
                            this.f6893a.mo1746w().m11282D().m11249a("Activity created with data 'referrer' param without gclid");
                        }
                    }
                }
            } catch (Throwable th) {
                this.f6893a.mo1746w().m11290f().m11250a("Throwable caught in onActivityCreated", th);
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            this.f6893a.mo1744u().m11684g();
        }

        public void onActivityResumed(Activity activity) {
            this.f6893a.mo1744u().m11683f();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    protected C2053d(aj ajVar) {
        super(ajVar);
    }

    private String m11566A() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    private void m11570a(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        m11577a(str, str2, mo1739p().mo1723a(), bundle, z, z2, z3, str3);
    }

    private void m11571a(String str, String str2, Object obj, long j) {
        C1896c.m10792a(str);
        C1896c.m10792a(str2);
        mo1733j();
        mo1731h();
        m11273c();
        if (!this.n.m11470D()) {
            mo1746w().m11282D().m11249a("User property not set since app measurement is disabled");
        } else if (this.n.m11495b()) {
            mo1746w().m11282D().m11251a("Setting user property (FE)", str2, obj);
            mo1738o().m11637a(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    private void m11572a(boolean z) {
        mo1733j();
        mo1731h();
        m11273c();
        mo1746w().m11282D().m11250a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        mo1747x().m11371b(z);
        mo1738o().m11640g();
    }

    private void m11573b(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        C1896c.m10792a(str);
        C1896c.m10792a(str2);
        C1896c.m10790a((Object) bundle);
        mo1733j();
        m11273c();
        if (this.n.m11470D()) {
            if (!this.f6897d) {
                this.f6897d = true;
                m11574z();
            }
            boolean k = C2082m.m11758k(str2);
            if (z && this.f6895b != null && !k) {
                mo1746w().m11282D().m11251a("Passing event to registered event handler (FE)", str2, bundle);
                this.f6895b.m11187a(str, str2, bundle, j);
                return;
            } else if (this.n.m11495b()) {
                int c = mo1742s().m11779c(str2);
                if (c != 0) {
                    this.n.m11510n().m11762a(c, "_ev", mo1742s().m11761a(str2, mo1748y().m11852c(), true));
                    return;
                }
                bundle.putString("_o", str);
                Bundle a = mo1742s().m11760a(str2, bundle, C1971d.m11075a((Object) "_o"), z3);
                Bundle a2 = z2 ? m11575a(a) : a;
                mo1746w().m11282D().m11251a("Logging event (FE)", str2, a2);
                mo1738o().m11636a(new EventParcel(str2, new EventParams(a2), str, j), str3);
                for (C2011c a3 : this.f6896c) {
                    a3.m11188a(str, str2, a2, j);
                }
                return;
            } else {
                return;
            }
        }
        mo1746w().m11282D().m11249a("Event not sent since app measurement is disabled");
    }

    private void m11574z() {
        try {
            m11576a(Class.forName(m11566A()));
        } catch (ClassNotFoundException e) {
            mo1746w().m11281C().m11249a("Tag Manager is not found and thus will not be used");
        }
    }

    Bundle m11575a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object b = mo1742s().m11776b(str, bundle.get(str));
                if (b == null) {
                    mo1746w().m11310z().m11250a("Param value can't be null", str);
                } else if ((!(b instanceof String) && !(b instanceof Character) && !(b instanceof CharSequence)) || !TextUtils.isEmpty(String.valueOf(b))) {
                    mo1742s().m11763a(bundle2, str, b);
                }
            }
        }
        return bundle2;
    }

    public void m11576a(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{mo1740q()});
        } catch (Exception e) {
            mo1746w().m11310z().m11250a("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    protected void m11577a(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        final Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        final String str4 = str;
        final String str5 = str2;
        final long j2 = j;
        final boolean z4 = z;
        final boolean z5 = z2;
        final boolean z6 = z3;
        final String str6 = str3;
        mo1745v().m11424a(new Runnable(this) {
            final /* synthetic */ C2053d f6887i;

            public void run() {
                this.f6887i.m11573b(str4, str5, j2, bundle2, z4, z5, z6, str6);
            }
        });
    }

    void m11578a(String str, String str2, long j, Object obj) {
        final String str3 = str;
        final String str4 = str2;
        final Object obj2 = obj;
        final long j2 = j;
        mo1745v().m11424a(new Runnable(this) {
            final /* synthetic */ C2053d f6892e;

            public void run() {
                this.f6892e.m11571a(str3, str4, obj2, j2);
            }
        });
    }

    public void m11579a(String str, String str2, Bundle bundle) {
        mo1731h();
        boolean z = this.f6895b == null || C2082m.m11758k(str2);
        m11570a(str, str2, bundle, true, z, false, null);
    }

    public void m11580a(String str, String str2, Bundle bundle, boolean z) {
        mo1731h();
        boolean z2 = this.f6895b == null || C2082m.m11758k(str2);
        m11570a(str, str2, bundle, true, z2, z, null);
    }

    public void m11581a(String str, String str2, Object obj) {
        C1896c.m10792a(str);
        long a = mo1739p().mo1723a();
        int d = mo1742s().m11781d(str2);
        if (d != 0) {
            this.n.m11510n().m11762a(d, "_ev", mo1742s().m11761a(str2, mo1748y().m11854d(), true));
        } else if (obj != null) {
            d = mo1742s().m11780c(str2, obj);
            if (d != 0) {
                this.n.m11510n().m11762a(d, "_ev", mo1742s().m11761a(str2, mo1748y().m11854d(), true));
                return;
            }
            Object d2 = mo1742s().m11783d(str2, obj);
            if (d2 != null) {
                m11578a(str, str2, a, d2);
            }
        } else {
            m11578a(str, str2, a, null);
        }
    }

    protected void mo1730e() {
    }

    @TargetApi(14)
    public void m11583f() {
        if (mo1740q().getApplicationContext() instanceof Application) {
            Application application = (Application) mo1740q().getApplicationContext();
            if (this.f6894a == null) {
                this.f6894a = new C2052a();
            }
            application.unregisterActivityLifecycleCallbacks(this.f6894a);
            application.registerActivityLifecycleCallbacks(this.f6894a);
            mo1746w().m11283E().m11249a("Registered activity lifecycle callback");
        }
    }

    public void m11584g() {
        mo1733j();
        mo1731h();
        m11273c();
        if (this.n.m11495b()) {
            mo1738o().m11659z();
            String D = mo1747x().m11367D();
            if (!TextUtils.isEmpty(D) && !D.equals(mo1737n().m11942g())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", D);
                m11579a("auto", "_ou", bundle);
            }
        }
    }

    public /* bridge */ /* synthetic */ void mo1731h() {
        super.mo1731h();
    }

    public /* bridge */ /* synthetic */ void mo1732i() {
        super.mo1732i();
    }

    public /* bridge */ /* synthetic */ void mo1733j() {
        super.mo1733j();
    }

    public /* bridge */ /* synthetic */ C2084o mo1734k() {
        return super.mo1734k();
    }

    public /* bridge */ /* synthetic */ C2053d mo1735l() {
        return super.mo1735l();
    }

    public /* bridge */ /* synthetic */ C2098z mo1736m() {
        return super.mo1736m();
    }

    public /* bridge */ /* synthetic */ C2090s mo1737n() {
        return super.mo1737n();
    }

    public /* bridge */ /* synthetic */ C2066e mo1738o() {
        return super.mo1738o();
    }

    public /* bridge */ /* synthetic */ C1970c mo1739p() {
        return super.mo1739p();
    }

    public /* bridge */ /* synthetic */ Context mo1740q() {
        return super.mo1740q();
    }

    public /* bridge */ /* synthetic */ C2088q mo1741r() {
        return super.mo1741r();
    }

    public /* bridge */ /* synthetic */ C2082m mo1742s() {
        return super.mo1742s();
    }

    public /* bridge */ /* synthetic */ ah mo1743t() {
        return super.mo1743t();
    }

    public /* bridge */ /* synthetic */ C2076g mo1744u() {
        return super.mo1744u();
    }

    public /* bridge */ /* synthetic */ ai mo1745v() {
        return super.mo1745v();
    }

    public /* bridge */ /* synthetic */ ab mo1746w() {
        return super.mo1746w();
    }

    public /* bridge */ /* synthetic */ af mo1747x() {
        return super.mo1747x();
    }

    public /* bridge */ /* synthetic */ C2085p mo1748y() {
        return super.mo1748y();
    }
}
