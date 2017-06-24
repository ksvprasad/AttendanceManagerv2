package com.google.android.gms.p031b;

import android.os.Handler;
import java.util.concurrent.Executor;

public class C1426do implements lo {
    private final Executor f4475a;

    private class C1425a implements Runnable {
        final /* synthetic */ C1426do f4471a;
        private final jr f4472b;
        private final ln f4473c;
        private final Runnable f4474d;

        public C1425a(C1426do c1426do, jr jrVar, ln lnVar, Runnable runnable) {
            this.f4471a = c1426do;
            this.f4472b = jrVar;
            this.f4473c = lnVar;
            this.f4474d = runnable;
        }

        public void run() {
            if (this.f4472b.m7722f()) {
                this.f4472b.m7719c("canceled-at-delivery");
                return;
            }
            if (this.f4473c.m9633a()) {
                this.f4472b.mo1266a(this.f4473c.f5769a);
            } else {
                this.f4472b.m7716b(this.f4473c.f5771c);
            }
            if (this.f4473c.f5772d) {
                this.f4472b.m7717b("intermediate-response");
            } else {
                this.f4472b.m7719c("done");
            }
            if (this.f4474d != null) {
                this.f4474d.run();
            }
        }
    }

    public C1426do(final Handler handler) {
        this.f4475a = new Executor(this) {
            final /* synthetic */ C1426do f4470b;

            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public void mo1300a(jr<?> jrVar, ln<?> lnVar) {
        mo1301a(jrVar, lnVar, null);
    }

    public void mo1301a(jr<?> jrVar, ln<?> lnVar, Runnable runnable) {
        jrVar.m7736t();
        jrVar.m7717b("post-response");
        this.f4475a.execute(new C1425a(this, jrVar, lnVar, runnable));
    }

    public void mo1302a(jr<?> jrVar, nj njVar) {
        jrVar.m7717b("post-error");
        this.f4475a.execute(new C1425a(this, jrVar, ln.m9631a(njVar), null));
    }
}
