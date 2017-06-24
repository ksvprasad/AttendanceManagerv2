package com.google.android.gms.p031b;

import android.os.Process;
import com.google.android.gms.p031b.ar.C1369a;
import java.util.concurrent.BlockingQueue;

public class bm extends Thread {
    private static final boolean f4209a = no.f6075b;
    private final BlockingQueue<jr<?>> f4210b;
    private final BlockingQueue<jr<?>> f4211c;
    private final ar f4212d;
    private final lo f4213e;
    private volatile boolean f4214f = false;

    public bm(BlockingQueue<jr<?>> blockingQueue, BlockingQueue<jr<?>> blockingQueue2, ar arVar, lo loVar) {
        super("VolleyCacheDispatcher");
        this.f4210b = blockingQueue;
        this.f4211c = blockingQueue2;
        this.f4212d = arVar;
        this.f4213e = loVar;
    }

    public void m7575a() {
        this.f4214f = true;
        interrupt();
    }

    public void run() {
        if (f4209a) {
            no.m10167a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f4212d.mo1637a();
        while (true) {
            try {
                final jr jrVar = (jr) this.f4210b.take();
                jrVar.m7717b("cache-queue-take");
                if (jrVar.m7722f()) {
                    jrVar.m7719c("cache-discard-canceled");
                } else {
                    C1369a a = this.f4212d.mo1636a(jrVar.m7720d());
                    if (a == null) {
                        jrVar.m7717b("cache-miss");
                        this.f4211c.put(jrVar);
                    } else if (a.m7516a()) {
                        jrVar.m7717b("cache-hit-expired");
                        jrVar.m7709a(a);
                        this.f4211c.put(jrVar);
                    } else {
                        jrVar.m7717b("cache-hit");
                        ln a2 = jrVar.mo1265a(new hp(a.f4163a, a.f4169g));
                        jrVar.m7717b("cache-hit-parsed");
                        if (a.m7517b()) {
                            jrVar.m7717b("cache-hit-refresh-needed");
                            jrVar.m7709a(a);
                            a2.f5772d = true;
                            this.f4213e.mo1301a(jrVar, a2, new Runnable(this) {
                                final /* synthetic */ bm f4208b;

                                public void run() {
                                    try {
                                        this.f4208b.f4211c.put(jrVar);
                                    } catch (InterruptedException e) {
                                    }
                                }
                            });
                        } else {
                            this.f4213e.mo1300a(jrVar, a2);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f4214f) {
                    return;
                }
            }
        }
    }
}
