package android.support.v4.p015g;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C0370a<K, V> extends C0369j<K, V> implements Map<K, V> {
    C0367g<K, V> f1112a;

    class C03681 extends C0367g<K, V> {
        final /* synthetic */ C0370a f1104a;

        C03681(C0370a c0370a) {
            this.f1104a = c0370a;
        }

        protected int mo273a() {
            return this.f1104a.h;
        }

        protected int mo274a(Object obj) {
            return this.f1104a.m1894a(obj);
        }

        protected Object mo275a(int i, int i2) {
            return this.f1104a.g[(i << 1) + i2];
        }

        protected V mo276a(int i, V v) {
            return this.f1104a.m1896a(i, (Object) v);
        }

        protected void mo277a(int i) {
            this.f1104a.m1902d(i);
        }

        protected void mo278a(K k, V v) {
            this.f1104a.put(k, v);
        }

        protected int mo279b(Object obj) {
            return this.f1104a.m1899b(obj);
        }

        protected Map<K, V> mo280b() {
            return this.f1104a;
        }

        protected void mo281c() {
            this.f1104a.clear();
        }
    }

    public C0370a(int i) {
        super(i);
    }

    private C0367g<K, V> m1903b() {
        if (this.f1112a == null) {
            this.f1112a = new C03681(this);
        }
        return this.f1112a;
    }

    public boolean m1904a(Collection<?> collection) {
        return C0367g.m1867c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m1903b().m1879d();
    }

    public Set<K> keySet() {
        return m1903b().m1880e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m1897a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return m1903b().m1881f();
    }
}
