package com.google.android.gms.p031b;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import com.google.android.gms.p031b.C1493f.C1487a;
import com.google.android.gms.p031b.C1493f.C1487a.C1486a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class ae extends C1365o {
    static boolean f4109k = false;
    protected static volatile ao f4110n = null;
    protected static final Object f4111o = new Object();
    private static final String f4112p = ae.class.getSimpleName();
    private static Method f4113q;
    private static long f4114r = 0;
    protected boolean f4115i = false;
    protected String f4116j;
    protected boolean f4117l = false;
    protected boolean f4118m = false;

    protected ae(Context context, String str) {
        super(context);
        this.f4116j = str;
        this.f4115i = false;
    }

    protected ae(Context context, String str, boolean z) {
        super(context);
        this.f4116j = str;
        this.f4115i = z;
    }

    static List<Long> m7413a(ao aoVar, MotionEvent motionEvent, DisplayMetrics displayMetrics) {
        f4113q = aoVar.m7494a(am.m7451F(), am.m7452G());
        if (f4113q == null || motionEvent == null) {
            throw new an();
        }
        try {
            return (ArrayList) f4113q.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new an(e);
        } catch (Throwable e2) {
            throw new an(e2);
        }
    }

    protected static synchronized void m7414a(Context context, boolean z) {
        synchronized (ae.class) {
            if (!f4109k) {
                f4114r = Calendar.getInstance().getTime().getTime() / 1000;
                f4110n = ae.m7416b(context, z);
                f4109k = true;
            }
        }
    }

    private static void m7415a(ao aoVar) {
        List singletonList = Collections.singletonList(Context.class);
        aoVar.m7495a(am.m7470r(), am.m7471s(), singletonList);
        aoVar.m7495a(am.m7468p(), am.m7469q(), singletonList);
        aoVar.m7495a(am.m7447B(), am.m7448C(), singletonList);
        aoVar.m7495a(am.m7478z(), am.m7446A(), singletonList);
        aoVar.m7495a(am.m7462j(), am.m7463k(), singletonList);
        aoVar.m7495a(am.m7460h(), am.m7461i(), singletonList);
        aoVar.m7495a(am.m7458f(), am.m7459g(), singletonList);
        aoVar.m7495a(am.m7474v(), am.m7475w(), singletonList);
        aoVar.m7495a(am.m7456d(), am.m7457e(), singletonList);
        aoVar.m7495a(am.m7451F(), am.m7452G(), Arrays.asList(new Class[]{MotionEvent.class, DisplayMetrics.class}));
        aoVar.m7495a(am.m7466n(), am.m7467o(), Collections.emptyList());
        aoVar.m7495a(am.m7449D(), am.m7450E(), Collections.emptyList());
        aoVar.m7495a(am.m7476x(), am.m7477y(), Collections.emptyList());
        aoVar.m7495a(am.m7464l(), am.m7465m(), Collections.emptyList());
        aoVar.m7495a(am.m7472t(), am.m7473u(), Collections.emptyList());
    }

    protected static ao m7416b(Context context, boolean z) {
        if (f4110n == null) {
            synchronized (f4111o) {
                if (f4110n == null) {
                    ao a = ao.m7479a(context, am.m7453a(), am.m7455c(), z);
                    ae.m7415a(a);
                    f4110n = a;
                }
            }
        }
        return f4110n;
    }

    protected void mo1641a(ao aoVar, C1487a c1487a) {
        if (aoVar.m7496b() != null) {
            m7418a(mo1238b(aoVar, c1487a));
        }
    }

    protected void m7418a(List<Callable<Void>> list) {
        if (f4110n != null) {
            ExecutorService b = f4110n.m7496b();
            if (b != null && !list.isEmpty()) {
                try {
                    b.invokeAll(list, ((Long) cq.aM.m7801c()).longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable e) {
                    Log.d(f4112p, String.format("class methods got exception: %s", new Object[]{ap.m7512a(e)}));
                }
            }
        }
    }

    protected C1487a mo1236b(Context context) {
        C1487a c1487a = new C1487a();
        if (!TextUtils.isEmpty(this.f4116j)) {
            c1487a.f4657b = this.f4116j;
        }
        ao b = ae.m7416b(context, this.f4115i);
        b.m7508n();
        mo1641a(b, c1487a);
        b.m7509o();
        return c1487a;
    }

    protected List<Callable<Void>> mo1238b(ao aoVar, C1487a c1487a) {
        int p = aoVar.m7510p();
        List arrayList = new ArrayList();
        List list = arrayList;
        list.add(new at(aoVar, am.m7470r(), am.m7471s(), c1487a, p, 27));
        list = arrayList;
        list.add(new ay(aoVar, am.m7466n(), am.m7467o(), c1487a, f4114r, p, 25));
        list = arrayList;
        list.add(new bd(aoVar, am.m7476x(), am.m7477y(), c1487a, p, 1));
        list = arrayList;
        list.add(new be(aoVar, am.m7478z(), am.m7446A(), c1487a, p, 31));
        list = arrayList;
        list.add(new bf(aoVar, am.m7449D(), am.m7450E(), c1487a, p, 33));
        list = arrayList;
        list.add(new as(aoVar, am.m7447B(), am.m7448C(), c1487a, p, 29));
        list = arrayList;
        list.add(new aw(aoVar, am.m7462j(), am.m7463k(), c1487a, p, 5));
        list = arrayList;
        list.add(new bc(aoVar, am.m7474v(), am.m7475w(), c1487a, p, 12));
        list = arrayList;
        list.add(new aq(aoVar, am.m7456d(), am.m7457e(), c1487a, p, 3));
        list = arrayList;
        list.add(new av(aoVar, am.m7460h(), am.m7461i(), c1487a, p, 34));
        list = arrayList;
        list.add(new au(aoVar, am.m7458f(), am.m7459g(), c1487a, p, 35));
        if (((Boolean) cq.aQ.m7801c()).booleanValue()) {
            list = arrayList;
            list.add(new ax(aoVar, am.m7464l(), am.m7465m(), c1487a, p, 44));
        }
        if (((Boolean) cq.aT.m7801c()).booleanValue()) {
            list = arrayList;
            list.add(new bb(aoVar, am.m7472t(), am.m7473u(), c1487a, p, 22));
        }
        return arrayList;
    }

    protected C1487a mo1237c(Context context) {
        C1487a c1487a = new C1487a();
        if (!TextUtils.isEmpty(this.f4116j)) {
            c1487a.f4657b = this.f4116j;
        }
        ao b = ae.m7416b(context, this.f4115i);
        b.m7508n();
        m7423d(b, c1487a);
        b.m7509o();
        return c1487a;
    }

    protected List<Callable<Void>> m7422c(ao aoVar, C1487a c1487a) {
        ArrayList arrayList = new ArrayList();
        if (aoVar.m7496b() == null) {
            return arrayList;
        }
        int p = aoVar.m7510p();
        arrayList.add(new ba(aoVar, c1487a));
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new bd(aoVar, am.m7476x(), am.m7477y(), c1487a, p, 1));
        arrayList2 = arrayList;
        arrayList2.add(new ay(aoVar, am.m7466n(), am.m7467o(), c1487a, f4114r, p, 25));
        if (((Boolean) cq.aR.m7801c()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new ax(aoVar, am.m7464l(), am.m7465m(), c1487a, p, 44));
        }
        arrayList2 = arrayList;
        arrayList2.add(new aq(aoVar, am.m7456d(), am.m7457e(), c1487a, p, 3));
        if (((Boolean) cq.aU.m7801c()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new bb(aoVar, am.m7472t(), am.m7473u(), c1487a, p, 22));
        }
        return arrayList;
    }

    protected void m7423d(ao aoVar, C1487a c1487a) {
        try {
            List a = ae.m7413a(aoVar, this.a, this.h);
            c1487a.f4669n = (Long) a.get(0);
            c1487a.f4670o = (Long) a.get(1);
            if (((Long) a.get(2)).longValue() >= 0) {
                c1487a.f4671p = (Long) a.get(2);
            }
            c1487a.f4639D = (Long) a.get(3);
            c1487a.f4640E = (Long) a.get(4);
        } catch (an e) {
        }
        if (this.c > 0) {
            c1487a.f4644I = Long.valueOf(this.c);
        }
        if (this.d > 0) {
            c1487a.f4643H = Long.valueOf(this.d);
        }
        if (this.e > 0) {
            c1487a.f4642G = Long.valueOf(this.e);
        }
        if (this.f > 0) {
            c1487a.f4645J = Long.valueOf(this.f);
        }
        if (this.g > 0) {
            c1487a.f4647L = Long.valueOf(this.g);
        }
        try {
            int size = this.b.size() - 1;
            if (size > 0) {
                c1487a.f4648M = new C1486a[size];
                for (int i = 0; i < size; i++) {
                    List a2 = ae.m7413a(aoVar, (MotionEvent) this.b.get(i), this.h);
                    C1486a c1486a = new C1486a();
                    c1486a.f4634a = (Long) a2.get(0);
                    c1486a.f4635b = (Long) a2.get(1);
                    c1487a.f4648M[i] = c1486a;
                }
            }
        } catch (an e2) {
            c1487a.f4648M = null;
        }
        m7418a(m7422c(aoVar, c1487a));
    }
}
