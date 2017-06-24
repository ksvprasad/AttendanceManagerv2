package android.support.v4.view.p016a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p016a.C0442j.C0433a;
import android.support.v4.view.p016a.C0444k.C0437a;
import java.util.ArrayList;
import java.util.List;

public class C0440i {
    private static final C0432a f1234a;
    private final Object f1235b;

    interface C0432a {
        Object mo346a(C0440i c0440i);
    }

    static class C0435d implements C0432a {
        C0435d() {
        }

        public Object mo346a(C0440i c0440i) {
            return null;
        }
    }

    static class C0436b extends C0435d {
        C0436b() {
        }

        public Object mo346a(final C0440i c0440i) {
            return C0442j.m2269a(new C0433a(this) {
                final /* synthetic */ C0436b f1231b;

                public Object mo343a(int i) {
                    C0426c a = c0440i.m2264a(i);
                    return a == null ? null : a.m2187a();
                }

                public List<Object> mo344a(String str, int i) {
                    List a = c0440i.m2266a(str, i);
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((C0426c) a.get(i2)).m2187a());
                    }
                    return arrayList;
                }

                public boolean mo345a(int i, int i2, Bundle bundle) {
                    return c0440i.m2267a(i, i2, bundle);
                }
            });
        }
    }

    static class C0439c extends C0435d {
        C0439c() {
        }

        public Object mo346a(final C0440i c0440i) {
            return C0444k.m2270a(new C0437a(this) {
                final /* synthetic */ C0439c f1233b;

                public Object mo347a(int i) {
                    C0426c a = c0440i.m2264a(i);
                    return a == null ? null : a.m2187a();
                }

                public List<Object> mo348a(String str, int i) {
                    List a = c0440i.m2266a(str, i);
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((C0426c) a.get(i2)).m2187a());
                    }
                    return arrayList;
                }

                public boolean mo349a(int i, int i2, Bundle bundle) {
                    return c0440i.m2267a(i, i2, bundle);
                }

                public Object mo350b(int i) {
                    C0426c b = c0440i.m2268b(i);
                    return b == null ? null : b.m2187a();
                }
            });
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f1234a = new C0439c();
        } else if (VERSION.SDK_INT >= 16) {
            f1234a = new C0436b();
        } else {
            f1234a = new C0435d();
        }
    }

    public C0440i() {
        this.f1235b = f1234a.mo346a(this);
    }

    public C0440i(Object obj) {
        this.f1235b = obj;
    }

    public C0426c m2264a(int i) {
        return null;
    }

    public Object m2265a() {
        return this.f1235b;
    }

    public List<C0426c> m2266a(String str, int i) {
        return null;
    }

    public boolean m2267a(int i, int i2, Bundle bundle) {
        return false;
    }

    public C0426c m2268b(int i) {
        return null;
    }
}
