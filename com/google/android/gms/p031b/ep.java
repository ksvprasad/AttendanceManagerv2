package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.C1319u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@id
public class ep implements Iterable<eo> {
    private final List<eo> f4549a = new LinkedList();

    private eo m8055c(la laVar) {
        Iterator it = C1319u.m7202x().iterator();
        while (it.hasNext()) {
            eo eoVar = (eo) it.next();
            if (eoVar.f4546a == laVar) {
                return eoVar;
            }
        }
        return null;
    }

    public int m8056a() {
        return this.f4549a.size();
    }

    public void m8057a(eo eoVar) {
        this.f4549a.add(eoVar);
    }

    public boolean m8058a(la laVar) {
        eo c = m8055c(laVar);
        if (c == null) {
            return false;
        }
        c.f4547b.mo1310b();
        return true;
    }

    public void m8059b(eo eoVar) {
        this.f4549a.remove(eoVar);
    }

    public boolean m8060b(la laVar) {
        return m8055c(laVar) != null;
    }

    public Iterator<eo> iterator() {
        return this.f4549a.iterator();
    }
}
