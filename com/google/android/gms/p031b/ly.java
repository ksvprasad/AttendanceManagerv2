package com.google.android.gms.p031b;

import android.util.SparseArray;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.C1864a.C1721c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.p031b.mc.C1714a;

public abstract class ly {
    public final int f5826a;
    public final int f5827b;

    public static final class C1731a extends ly {
        public final C1714a<? extends C1857g, C1721c> f5828c;

        public void mo1560a(SparseArray<nh> sparseArray) {
            nh nhVar = (nh) sparseArray.get(this.a);
            if (nhVar != null) {
                nhVar.m10135a(this.f5828c);
            }
        }

        public void mo1561a(Status status) {
            this.f5828c.m9663c(status);
        }

        public void mo1562a(C1721c c1721c) {
            this.f5828c.m9661b(c1721c);
        }

        public boolean mo1563a() {
            return this.f5828c.m9652h();
        }
    }

    public void mo1560a(SparseArray<nh> sparseArray) {
    }

    public abstract void mo1561a(Status status);

    public abstract void mo1562a(C1721c c1721c);

    public boolean mo1563a() {
        return true;
    }
}
