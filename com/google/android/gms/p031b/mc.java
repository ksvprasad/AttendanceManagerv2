package com.google.android.gms.p031b;

import android.os.RemoteException;
import com.google.android.gms.common.api.C1767c;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.C1864a;
import com.google.android.gms.common.api.C1864a.C1721c;
import com.google.android.gms.common.api.C1864a.C1859d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.nh.C1781b;
import java.util.concurrent.atomic.AtomicReference;

public class mc {

    public static abstract class C1714a<R extends C1857g, A extends C1721c> extends me<R> {
        private final C1859d<A> f5796d;
        private final C1864a<?> f5797e;
        private AtomicReference<C1781b> f5798f = new AtomicReference();

        protected C1714a(C1864a<?> c1864a, C1767c c1767c) {
            super((C1767c) C1896c.m10791a((Object) c1767c, (Object) "GoogleApiClient must not be null"));
            this.f5796d = c1864a.m10576d();
            this.f5797e = c1864a;
        }

        private void m9656a(RemoteException remoteException) {
            m9663c(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        public void m9657a(C1781b c1781b) {
            this.f5798f.set(c1781b);
        }

        protected abstract void mo1553a(A a);

        protected void mo1549a(R r) {
        }

        public final C1859d<A> mo1550b() {
            return this.f5796d;
        }

        public final void m9661b(A a) {
            try {
                mo1553a((C1721c) a);
            } catch (RemoteException e) {
                m9656a(e);
                throw e;
            } catch (RemoteException e2) {
                m9656a(e2);
            }
        }

        public final C1864a<?> m9662c() {
            return this.f5797e;
        }

        public final void m9663c(Status status) {
            C1896c.m10799b(!status.m10565e(), "Failed result must not be success");
            C1857g b = mo1554b(status);
            m9647b(b);
            mo1549a(b);
        }

        public void m9664d() {
            mo1548a(null);
        }

        protected void mo1551e() {
            C1781b c1781b = (C1781b) this.f5798f.getAndSet(null);
            if (c1781b != null) {
                c1781b.mo1622a(this);
            }
        }
    }
}
