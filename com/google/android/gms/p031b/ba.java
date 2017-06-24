package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;
import java.util.concurrent.Callable;

public class ba implements Callable {
    private final ao f4182a;
    private final C1487a f4183b;

    public ba(ao aoVar, C1487a c1487a) {
        this.f4182a = aoVar;
        this.f4183b = c1487a;
    }

    public Void m7533a() {
        if (this.f4182a.m7505k() != null) {
            this.f4182a.m7505k().get();
        }
        C1357z j = this.f4182a.m7504j();
        if (j != null) {
            try {
                synchronized (this.f4183b) {
                    C1357z.m7340a(this.f4183b, C1357z.m7342a(j));
                }
            } catch (C1848y e) {
            }
        }
        return null;
    }

    public /* synthetic */ Object call() {
        return m7533a();
    }
}
