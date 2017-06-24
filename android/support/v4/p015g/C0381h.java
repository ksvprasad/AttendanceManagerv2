package android.support.v4.p015g;

public class C0381h<F, S> {
    public final F f1143a;
    public final S f1144b;

    public C0381h(F f, S s) {
        this.f1143a = f;
        this.f1144b = s;
    }

    public static <A, B> C0381h<A, B> m1933a(A a, B b) {
        return new C0381h(a, b);
    }

    private static boolean m1934b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0381h)) {
            return false;
        }
        C0381h c0381h = (C0381h) obj;
        return C0381h.m1934b(c0381h.f1143a, this.f1143a) && C0381h.m1934b(c0381h.f1144b, this.f1144b);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f1143a == null ? 0 : this.f1143a.hashCode();
        if (this.f1144b != null) {
            i = this.f1144b.hashCode();
        }
        return hashCode ^ i;
    }
}
