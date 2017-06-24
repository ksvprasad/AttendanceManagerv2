package com.google.android.gms.p031b;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ks {
    private AtomicInteger f5649a;
    private final Map<String, Queue<jr<?>>> f5650b;
    private final Set<jr<?>> f5651c;
    private final PriorityBlockingQueue<jr<?>> f5652d;
    private final PriorityBlockingQueue<jr<?>> f5653e;
    private final ar f5654f;
    private final em f5655g;
    private final lo f5656h;
    private fn[] f5657i;
    private bm f5658j;
    private List<C1686a> f5659k;

    public interface C1686a<T> {
        void m9370a(jr<T> jrVar);
    }

    public ks(ar arVar, em emVar) {
        this(arVar, emVar, 4);
    }

    public ks(ar arVar, em emVar, int i) {
        this(arVar, emVar, i, new C1426do(new Handler(Looper.getMainLooper())));
    }

    public ks(ar arVar, em emVar, int i, lo loVar) {
        this.f5649a = new AtomicInteger();
        this.f5650b = new HashMap();
        this.f5651c = new HashSet();
        this.f5652d = new PriorityBlockingQueue();
        this.f5653e = new PriorityBlockingQueue();
        this.f5659k = new ArrayList();
        this.f5654f = arVar;
        this.f5655g = emVar;
        this.f5657i = new fn[i];
        this.f5656h = loVar;
    }

    public <T> jr<T> m9371a(jr<T> jrVar) {
        jrVar.m7710a(this);
        synchronized (this.f5651c) {
            this.f5651c.add(jrVar);
        }
        jrVar.m7708a(m9375c());
        jrVar.m7717b("add-to-queue");
        if (jrVar.m7732p()) {
            synchronized (this.f5650b) {
                String d = jrVar.m7720d();
                if (this.f5650b.containsKey(d)) {
                    Queue queue = (Queue) this.f5650b.get(d);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(jrVar);
                    this.f5650b.put(d, queue);
                    if (no.f6075b) {
                        no.m10167a("Request for cacheKey=%s is in flight, putting on hold.", d);
                    }
                } else {
                    this.f5650b.put(d, null);
                    this.f5652d.add(jrVar);
                }
            }
        } else {
            this.f5653e.add(jrVar);
        }
        return jrVar;
    }

    public void m9372a() {
        m9373b();
        this.f5658j = new bm(this.f5652d, this.f5653e, this.f5654f, this.f5656h);
        this.f5658j.start();
        for (int i = 0; i < this.f5657i.length; i++) {
            fn fnVar = new fn(this.f5653e, this.f5655g, this.f5654f, this.f5656h);
            this.f5657i[i] = fnVar;
            fnVar.start();
        }
    }

    public void m9373b() {
        if (this.f5658j != null) {
            this.f5658j.m7575a();
        }
        for (int i = 0; i < this.f5657i.length; i++) {
            if (this.f5657i[i] != null) {
                this.f5657i[i].m8316a();
            }
        }
    }

    <T> void m9374b(jr<T> jrVar) {
        synchronized (this.f5651c) {
            this.f5651c.remove(jrVar);
        }
        synchronized (this.f5659k) {
            for (C1686a a : this.f5659k) {
                a.m9370a(jrVar);
            }
        }
        if (jrVar.m7732p()) {
            synchronized (this.f5650b) {
                Queue queue = (Queue) this.f5650b.remove(jrVar.m7720d());
                if (queue != null) {
                    if (no.f6075b) {
                        no.m10167a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r2);
                    }
                    this.f5652d.addAll(queue);
                }
            }
        }
    }

    public int m9375c() {
        return this.f5649a.incrementAndGet();
    }
}
