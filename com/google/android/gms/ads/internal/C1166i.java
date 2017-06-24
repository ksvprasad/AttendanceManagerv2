package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.C1165n;
import com.google.android.gms.p031b.ai;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jy;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@id
class C1166i implements C1165n, Runnable {
    CountDownLatch f3402a = new CountDownLatch(1);
    private final List<Object[]> f3403b = new Vector();
    private final AtomicReference<C1165n> f3404c = new AtomicReference();
    private C1328v f3405d;

    public C1166i(C1328v c1328v) {
        this.f3405d = c1328v;
        if (C1120y.m6293a().m7222b()) {
            jy.m9180a((Runnable) this);
        } else {
            run();
        }
    }

    private Context m6484b(Context context) {
        if (!((Boolean) cq.f4399n.m7801c()).booleanValue()) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    private void m6485b() {
        if (!this.f3403b.isEmpty()) {
            for (Object[] objArr : this.f3403b) {
                if (objArr.length == 1) {
                    ((C1165n) this.f3404c.get()).mo1105a((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((C1165n) this.f3404c.get()).mo1104a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.f3403b.clear();
        }
    }

    protected C1165n m6486a(String str, Context context, boolean z) {
        return ai.m7426a(str, context, z);
    }

    public String mo1102a(Context context) {
        if (m6492a()) {
            C1165n c1165n = (C1165n) this.f3404c.get();
            if (c1165n != null) {
                m6485b();
                return c1165n.mo1102a(m6484b(context));
            }
        }
        return "";
    }

    public String mo1103a(Context context, String str) {
        if (m6492a()) {
            C1165n c1165n = (C1165n) this.f3404c.get();
            if (c1165n != null) {
                m6485b();
                return c1165n.mo1103a(m6484b(context), str);
            }
        }
        return "";
    }

    public void mo1104a(int i, int i2, int i3) {
        C1165n c1165n = (C1165n) this.f3404c.get();
        if (c1165n != null) {
            m6485b();
            c1165n.mo1104a(i, i2, i3);
            return;
        }
        this.f3403b.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public void mo1105a(MotionEvent motionEvent) {
        C1165n c1165n = (C1165n) this.f3404c.get();
        if (c1165n != null) {
            m6485b();
            c1165n.mo1105a(motionEvent);
            return;
        }
        this.f3403b.add(new Object[]{motionEvent});
    }

    protected void m6491a(C1165n c1165n) {
        this.f3404c.set(c1165n);
    }

    protected boolean m6492a() {
        try {
            this.f3402a.await();
            return true;
        } catch (Throwable e) {
            C1324b.m7235d("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    public void run() {
        try {
            boolean z = !((Boolean) cq.f4411z.m7801c()).booleanValue() || this.f3405d.f3992e.f3960e;
            m6491a(m6486a(this.f3405d.f3992e.f3957b, m6484b(this.f3405d.f3990c), z));
        } finally {
            this.f3402a.countDown();
            this.f3405d = null;
        }
    }
}
