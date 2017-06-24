package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@id
public class bz {
    private final Object f4286a = new Object();
    private int f4287b;
    private List<by> f4288c = new LinkedList();

    public by m7699a() {
        by byVar = null;
        synchronized (this.f4286a) {
            if (this.f4288c.size() == 0) {
                C1324b.m7227a("Queue empty");
                return null;
            } else if (this.f4288c.size() >= 2) {
                int i = Integer.MIN_VALUE;
                for (by byVar2 : this.f4288c) {
                    by byVar3;
                    int i2;
                    int h = byVar2.m7697h();
                    if (h > i) {
                        int i3 = h;
                        byVar3 = byVar2;
                        i2 = i3;
                    } else {
                        i2 = i;
                        byVar3 = byVar;
                    }
                    i = i2;
                    byVar = byVar3;
                }
                this.f4288c.remove(byVar);
                return byVar;
            } else {
                byVar2 = (by) this.f4288c.get(0);
                byVar2.m7693d();
                return byVar2;
            }
        }
    }

    public boolean m7700a(by byVar) {
        boolean z;
        synchronized (this.f4286a) {
            if (this.f4288c.contains(byVar)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean m7701b(by byVar) {
        boolean z;
        synchronized (this.f4286a) {
            Iterator it = this.f4288c.iterator();
            while (it.hasNext()) {
                by byVar2 = (by) it.next();
                if (byVar != byVar2 && byVar2.m7690b().equals(byVar.m7690b())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public void m7702c(by byVar) {
        synchronized (this.f4286a) {
            if (this.f4288c.size() >= 10) {
                C1324b.m7227a("Queue is full, current size = " + this.f4288c.size());
                this.f4288c.remove(0);
            }
            int i = this.f4287b;
            this.f4287b = i + 1;
            byVar.m7687a(i);
            this.f4288c.add(byVar);
        }
    }
}
