package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.af.C0216a;
import android.support.v4.app.ag.C0217a;
import android.support.v4.app.ah.C0199a;
import android.support.v4.app.ah.C0199a.C0197a;
import android.support.v4.app.ak.C0218a;
import android.support.v4.app.al.C0219a;
import android.support.v4.app.am.C0220a;
import android.support.v4.app.ap.C0227a;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

public class ae {
    private static final C0207g f836a;

    public static class C0200a extends C0199a {
        public static final C0197a f793d = new C01981();
        public int f794a;
        public CharSequence f795b;
        public PendingIntent f796c;
        private final Bundle f797e;
        private final an[] f798f;

        static class C01981 implements C0197a {
            C01981() {
            }
        }

        public int mo169a() {
            return this.f794a;
        }

        public CharSequence mo170b() {
            return this.f795b;
        }

        public PendingIntent mo171c() {
            return this.f796c;
        }

        public Bundle mo172d() {
            return this.f797e;
        }

        public an[] m1248e() {
            return this.f798f;
        }

        public /* synthetic */ C0227a[] mo173f() {
            return m1248e();
        }
    }

    public static abstract class C0201p {
        CharSequence f799d;
        CharSequence f800e;
        boolean f801f = false;
    }

    public static class C0202b extends C0201p {
        Bitmap f802a;
        Bitmap f803b;
        boolean f804c;
    }

    public static class C0203c extends C0201p {
        CharSequence f805a;
    }

    public static class C0204d {
        Notification f806A;
        public Notification f807B = new Notification();
        public ArrayList<String> f808C;
        public Context f809a;
        public CharSequence f810b;
        public CharSequence f811c;
        PendingIntent f812d;
        PendingIntent f813e;
        RemoteViews f814f;
        public Bitmap f815g;
        public CharSequence f816h;
        public int f817i;
        int f818j;
        boolean f819k = true;
        public boolean f820l;
        public C0201p f821m;
        public CharSequence f822n;
        int f823o;
        int f824p;
        boolean f825q;
        String f826r;
        boolean f827s;
        String f828t;
        public ArrayList<C0200a> f829u = new ArrayList();
        boolean f830v = false;
        String f831w;
        Bundle f832x;
        int f833y = 0;
        int f834z = 0;

        public C0204d(Context context) {
            this.f809a = context;
            this.f807B.when = System.currentTimeMillis();
            this.f807B.audioStreamType = -1;
            this.f818j = 0;
            this.f808C = new ArrayList();
        }

        private void m1250a(int i, boolean z) {
            if (z) {
                Notification notification = this.f807B;
                notification.flags |= i;
                return;
            }
            notification = this.f807B;
            notification.flags &= i ^ -1;
        }

        protected static CharSequence m1251d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public Notification m1252a() {
            return ae.f836a.mo174a(this, m1259b());
        }

        public C0204d m1253a(int i) {
            this.f807B.icon = i;
            return this;
        }

        public C0204d m1254a(long j) {
            this.f807B.when = j;
            return this;
        }

        public C0204d m1255a(PendingIntent pendingIntent) {
            this.f812d = pendingIntent;
            return this;
        }

        public C0204d m1256a(CharSequence charSequence) {
            this.f810b = C0204d.m1251d(charSequence);
            return this;
        }

        public C0204d m1257a(boolean z) {
            m1250a(16, z);
            return this;
        }

        public C0204d m1258b(CharSequence charSequence) {
            this.f811c = C0204d.m1251d(charSequence);
            return this;
        }

        protected C0205e m1259b() {
            return new C0205e();
        }

        public C0204d m1260c(CharSequence charSequence) {
            this.f807B.tickerText = C0204d.m1251d(charSequence);
            return this;
        }
    }

    protected static class C0205e {
        protected C0205e() {
        }

        public Notification m1261a(C0204d c0204d, ad adVar) {
            return adVar.mo177b();
        }
    }

    public static class C0206f extends C0201p {
        ArrayList<CharSequence> f835a = new ArrayList();
    }

    interface C0207g {
        Notification mo174a(C0204d c0204d, C0205e c0205e);
    }

    static class C0208j implements C0207g {
        C0208j() {
        }

        public Notification mo174a(C0204d c0204d, C0205e c0205e) {
            Notification a = ah.m1283a(c0204d.f807B, c0204d.f809a, c0204d.f810b, c0204d.f811c, c0204d.f812d);
            if (c0204d.f818j > 0) {
                a.flags |= 128;
            }
            return a;
        }
    }

    static class C0209n extends C0208j {
        C0209n() {
        }

        public Notification mo174a(C0204d c0204d, C0205e c0205e) {
            ad c0219a = new C0219a(c0204d.f809a, c0204d.f807B, c0204d.f810b, c0204d.f811c, c0204d.f816h, c0204d.f814f, c0204d.f817i, c0204d.f812d, c0204d.f813e, c0204d.f815g, c0204d.f823o, c0204d.f824p, c0204d.f825q, c0204d.f820l, c0204d.f818j, c0204d.f822n, c0204d.f830v, c0204d.f832x, c0204d.f826r, c0204d.f827s, c0204d.f828t);
            ae.m1274b((ac) c0219a, c0204d.f829u);
            ae.m1275b(c0219a, c0204d.f821m);
            return c0205e.m1261a(c0204d, c0219a);
        }
    }

    static class C0210o extends C0209n {
        C0210o() {
        }

        public Notification mo174a(C0204d c0204d, C0205e c0205e) {
            ad c0220a = new C0220a(c0204d.f809a, c0204d.f807B, c0204d.f810b, c0204d.f811c, c0204d.f816h, c0204d.f814f, c0204d.f817i, c0204d.f812d, c0204d.f813e, c0204d.f815g, c0204d.f823o, c0204d.f824p, c0204d.f825q, c0204d.f819k, c0204d.f820l, c0204d.f818j, c0204d.f822n, c0204d.f830v, c0204d.f808C, c0204d.f832x, c0204d.f826r, c0204d.f827s, c0204d.f828t);
            ae.m1274b((ac) c0220a, c0204d.f829u);
            ae.m1275b(c0220a, c0204d.f821m);
            return c0205e.m1261a(c0204d, c0220a);
        }
    }

    static class C0211h extends C0210o {
        C0211h() {
        }

        public Notification mo174a(C0204d c0204d, C0205e c0205e) {
            ad c0216a = new C0216a(c0204d.f809a, c0204d.f807B, c0204d.f810b, c0204d.f811c, c0204d.f816h, c0204d.f814f, c0204d.f817i, c0204d.f812d, c0204d.f813e, c0204d.f815g, c0204d.f823o, c0204d.f824p, c0204d.f825q, c0204d.f819k, c0204d.f820l, c0204d.f818j, c0204d.f822n, c0204d.f830v, c0204d.f808C, c0204d.f832x, c0204d.f826r, c0204d.f827s, c0204d.f828t);
            ae.m1274b((ac) c0216a, c0204d.f829u);
            ae.m1275b(c0216a, c0204d.f821m);
            return c0205e.m1261a(c0204d, c0216a);
        }
    }

    static class C0212i extends C0211h {
        C0212i() {
        }

        public Notification mo174a(C0204d c0204d, C0205e c0205e) {
            ad c0217a = new C0217a(c0204d.f809a, c0204d.f807B, c0204d.f810b, c0204d.f811c, c0204d.f816h, c0204d.f814f, c0204d.f817i, c0204d.f812d, c0204d.f813e, c0204d.f815g, c0204d.f823o, c0204d.f824p, c0204d.f825q, c0204d.f819k, c0204d.f820l, c0204d.f818j, c0204d.f822n, c0204d.f830v, c0204d.f831w, c0204d.f808C, c0204d.f832x, c0204d.f833y, c0204d.f834z, c0204d.f806A, c0204d.f826r, c0204d.f827s, c0204d.f828t);
            ae.m1274b((ac) c0217a, c0204d.f829u);
            ae.m1275b(c0217a, c0204d.f821m);
            return c0205e.m1261a(c0204d, c0217a);
        }
    }

    static class C0213k extends C0208j {
        C0213k() {
        }

        public Notification mo174a(C0204d c0204d, C0205e c0205e) {
            Notification a = ai.m1284a(c0204d.f807B, c0204d.f809a, c0204d.f810b, c0204d.f811c, c0204d.f812d, c0204d.f813e);
            if (c0204d.f818j > 0) {
                a.flags |= 128;
            }
            return a;
        }
    }

    static class C0214l extends C0208j {
        C0214l() {
        }

        public Notification mo174a(C0204d c0204d, C0205e c0205e) {
            return aj.m1285a(c0204d.f809a, c0204d.f807B, c0204d.f810b, c0204d.f811c, c0204d.f816h, c0204d.f814f, c0204d.f817i, c0204d.f812d, c0204d.f813e, c0204d.f815g);
        }
    }

    static class C0215m extends C0208j {
        C0215m() {
        }

        public Notification mo174a(C0204d c0204d, C0205e c0205e) {
            return c0205e.m1261a(c0204d, new C0218a(c0204d.f809a, c0204d.f807B, c0204d.f810b, c0204d.f811c, c0204d.f816h, c0204d.f814f, c0204d.f817i, c0204d.f812d, c0204d.f813e, c0204d.f815g, c0204d.f823o, c0204d.f824p, c0204d.f825q));
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f836a = new C0212i();
        } else if (VERSION.SDK_INT >= 20) {
            f836a = new C0211h();
        } else if (VERSION.SDK_INT >= 19) {
            f836a = new C0210o();
        } else if (VERSION.SDK_INT >= 16) {
            f836a = new C0209n();
        } else if (VERSION.SDK_INT >= 14) {
            f836a = new C0215m();
        } else if (VERSION.SDK_INT >= 11) {
            f836a = new C0214l();
        } else if (VERSION.SDK_INT >= 9) {
            f836a = new C0213k();
        } else {
            f836a = new C0208j();
        }
    }

    private static void m1274b(ac acVar, ArrayList<C0200a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            acVar.mo176a((C0200a) it.next());
        }
    }

    private static void m1275b(ad adVar, C0201p c0201p) {
        if (c0201p == null) {
            return;
        }
        if (c0201p instanceof C0203c) {
            C0203c c0203c = (C0203c) c0201p;
            al.m1295a(adVar, c0203c.d, c0203c.f, c0203c.e, c0203c.f805a);
        } else if (c0201p instanceof C0206f) {
            C0206f c0206f = (C0206f) c0201p;
            al.m1296a(adVar, c0206f.d, c0206f.f, c0206f.e, c0206f.f835a);
        } else if (c0201p instanceof C0202b) {
            C0202b c0202b = (C0202b) c0201p;
            al.m1294a(adVar, c0202b.d, c0202b.f, c0202b.e, c0202b.f802a, c0202b.f803b, c0202b.f804c);
        }
    }
}
