package android.support.v7.view;

import android.support.v4.view.aw;
import android.support.v4.view.ba;
import android.support.v4.view.bb;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class C0714h {
    private final ArrayList<aw> f1754a = new ArrayList();
    private long f1755b = -1;
    private Interpolator f1756c;
    private ba f1757d;
    private boolean f1758e;
    private final bb f1759f = new C07131(this);

    class C07131 extends bb {
        final /* synthetic */ C0714h f1751a;
        private boolean f1752b = false;
        private int f1753c = 0;

        C07131(C0714h c0714h) {
            this.f1751a = c0714h;
        }

        void m3700a() {
            this.f1753c = 0;
            this.f1752b = false;
            this.f1751a.m3706c();
        }

        public void mo98a(View view) {
            if (!this.f1752b) {
                this.f1752b = true;
                if (this.f1751a.f1757d != null) {
                    this.f1751a.f1757d.mo98a(null);
                }
            }
        }

        public void mo99b(View view) {
            int i = this.f1753c + 1;
            this.f1753c = i;
            if (i == this.f1751a.f1754a.size()) {
                if (this.f1751a.f1757d != null) {
                    this.f1751a.f1757d.mo99b(null);
                }
                m3700a();
            }
        }
    }

    private void m3706c() {
        this.f1758e = false;
    }

    public C0714h m3707a(long j) {
        if (!this.f1758e) {
            this.f1755b = j;
        }
        return this;
    }

    public C0714h m3708a(aw awVar) {
        if (!this.f1758e) {
            this.f1754a.add(awVar);
        }
        return this;
    }

    public C0714h m3709a(aw awVar, aw awVar2) {
        this.f1754a.add(awVar);
        awVar2.m2733b(awVar.m2726a());
        this.f1754a.add(awVar2);
        return this;
    }

    public C0714h m3710a(ba baVar) {
        if (!this.f1758e) {
            this.f1757d = baVar;
        }
        return this;
    }

    public C0714h m3711a(Interpolator interpolator) {
        if (!this.f1758e) {
            this.f1756c = interpolator;
        }
        return this;
    }

    public void m3712a() {
        if (!this.f1758e) {
            Iterator it = this.f1754a.iterator();
            while (it.hasNext()) {
                aw awVar = (aw) it.next();
                if (this.f1755b >= 0) {
                    awVar.m2728a(this.f1755b);
                }
                if (this.f1756c != null) {
                    awVar.m2731a(this.f1756c);
                }
                if (this.f1757d != null) {
                    awVar.m2729a(this.f1759f);
                }
                awVar.m2736c();
            }
            this.f1758e = true;
        }
    }

    public void m3713b() {
        if (this.f1758e) {
            Iterator it = this.f1754a.iterator();
            while (it.hasNext()) {
                ((aw) it.next()).m2734b();
            }
            this.f1758e = false;
        }
    }
}
