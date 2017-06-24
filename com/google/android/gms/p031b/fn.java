package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class fn extends Thread {
    private final BlockingQueue<jr<?>> f4806a;
    private final em f4807b;
    private final ar f4808c;
    private final lo f4809d;
    private volatile boolean f4810e = false;

    public fn(BlockingQueue<jr<?>> blockingQueue, em emVar, ar arVar, lo loVar) {
        super("VolleyNetworkDispatcher");
        this.f4806a = blockingQueue;
        this.f4807b = emVar;
        this.f4808c = arVar;
        this.f4809d = loVar;
    }

    @TargetApi(14)
    private void m8314a(jr<?> jrVar) {
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(jrVar.m7715b());
        }
    }

    private void m8315a(jr<?> jrVar, nj njVar) {
        this.f4809d.mo1302a((jr) jrVar, jrVar.m7713a(njVar));
    }

    public void m8316a() {
        this.f4810e = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                jr jrVar = (jr) this.f4806a.take();
                try {
                    jrVar.m7717b("network-queue-take");
                    if (jrVar.m7722f()) {
                        jrVar.m7719c("network-discard-cancelled");
                    } else {
                        m8314a(jrVar);
                        hp a = this.f4807b.mo1630a(jrVar);
                        jrVar.m7717b("network-http-complete");
                        if (a.f5051d && jrVar.m7737u()) {
                            jrVar.m7719c("not-modified");
                        } else {
                            ln a2 = jrVar.mo1265a(a);
                            jrVar.m7717b("network-parse-complete");
                            if (jrVar.m7732p() && a2.f5770b != null) {
                                this.f4808c.mo1638a(jrVar.m7720d(), a2.f5770b);
                                jrVar.m7717b("network-cache-written");
                            }
                            jrVar.m7736t();
                            this.f4809d.mo1300a(jrVar, a2);
                        }
                    }
                } catch (nj e) {
                    e.m7326a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    m8315a(jrVar, e);
                } catch (Throwable e2) {
                    no.m10168a(e2, "Unhandled exception %s", e2.toString());
                    nj njVar = new nj(e2);
                    njVar.m7326a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f4809d.mo1302a(jrVar, njVar);
                }
            } catch (InterruptedException e3) {
                if (this.f4810e) {
                    return;
                }
            }
        }
    }
}
