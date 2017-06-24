package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@id
public class kp {

    public interface C1589a<D, R> {
        R mo1440a(D d);
    }

    class C16841 implements Runnable {
        final /* synthetic */ kn f5638a;
        final /* synthetic */ C1589a f5639b;
        final /* synthetic */ kq f5640c;

        C16841(kn knVar, C1589a c1589a, kq kqVar) {
            this.f5638a = knVar;
            this.f5639b = c1589a;
            this.f5640c = kqVar;
        }

        public void run() {
            try {
                this.f5638a.m8236b(this.f5639b.mo1440a(this.f5640c.get()));
                return;
            } catch (CancellationException e) {
            } catch (InterruptedException e2) {
            } catch (ExecutionException e3) {
            }
            this.f5638a.cancel(true);
        }
    }

    class C16852 implements Runnable {
        final /* synthetic */ AtomicInteger f5641a;
        final /* synthetic */ int f5642b;
        final /* synthetic */ kn f5643c;
        final /* synthetic */ List f5644d;

        C16852(AtomicInteger atomicInteger, int i, kn knVar, List list) {
            this.f5641a = atomicInteger;
            this.f5642b = i;
            this.f5643c = knVar;
            this.f5644d = list;
        }

        public void run() {
            Throwable e;
            if (this.f5641a.incrementAndGet() >= this.f5642b) {
                try {
                    this.f5643c.m8236b(kp.m9364c(this.f5644d));
                    return;
                } catch (ExecutionException e2) {
                    e = e2;
                } catch (InterruptedException e3) {
                    e = e3;
                }
            } else {
                return;
            }
            C1324b.m7235d("Unable to convert list of futures to a future of list", e);
        }
    }

    public static <A, B> kq<B> m9361a(kq<A> kqVar, C1589a<A, B> c1589a) {
        kq knVar = new kn();
        kqVar.mo1314a(new C16841(knVar, c1589a, kqVar));
        return knVar;
    }

    public static <V> kq<List<V>> m9362a(List<kq<V>> list) {
        kq knVar = new kn();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (kq a : list) {
            a.mo1314a(new C16852(atomicInteger, size, knVar, list));
        }
        return knVar;
    }

    private static <V> List<V> m9364c(List<kq<V>> list) {
        List<V> arrayList = new ArrayList();
        for (kq kqVar : list) {
            Object obj = kqVar.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
