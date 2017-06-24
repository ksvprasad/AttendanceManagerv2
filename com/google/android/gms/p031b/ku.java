package com.google.android.gms.p031b;

import com.google.android.gms.p031b.kt.C1161c;
import com.google.android.gms.p031b.kt.C1261a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@id
public class ku<T> implements kt<T> {
    protected int f4761a = 0;
    protected final BlockingQueue<C1688a> f4762b = new LinkedBlockingQueue();
    protected T f4763c;
    private final Object f4764d = new Object();

    class C1688a {
        public final C1161c<T> f5660a;
        public final C1261a f5661b;
        final /* synthetic */ ku f5662c;

        public C1688a(ku kuVar, C1161c<T> c1161c, C1261a c1261a) {
            this.f5662c = kuVar;
            this.f5660a = c1161c;
            this.f5661b = c1261a;
        }
    }

    public void mo1329a() {
        synchronized (this.f4764d) {
            if (this.f4761a != 0) {
                throw new UnsupportedOperationException();
            }
            this.f4761a = -1;
            for (C1688a c1688a : this.f4762b) {
                c1688a.f5661b.mo1175a();
            }
            this.f4762b.clear();
        }
    }

    public void mo1327a(C1161c<T> c1161c, C1261a c1261a) {
        synchronized (this.f4764d) {
            if (this.f4761a == 1) {
                c1161c.mo1101a(this.f4763c);
            } else if (this.f4761a == -1) {
                c1261a.mo1175a();
            } else if (this.f4761a == 0) {
                this.f4762b.add(new C1688a(this, c1161c, c1261a));
            }
        }
    }

    public void mo1328a(T t) {
        synchronized (this.f4764d) {
            if (this.f4761a != 0) {
                throw new UnsupportedOperationException();
            }
            this.f4763c = t;
            this.f4761a = 1;
            for (C1688a c1688a : this.f4762b) {
                c1688a.f5660a.mo1101a(t);
            }
            this.f4762b.clear();
        }
    }

    public int mo1330b() {
        return this.f4761a;
    }
}
