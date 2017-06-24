package android.support.v4.p015g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class C0367g<K, V> {
    C0377b f1101b;
    C0378c f1102c;
    C0380e f1103d;

    final class C0376a<T> implements Iterator<T> {
        final int f1131a;
        int f1132b;
        int f1133c;
        boolean f1134d = false;
        final /* synthetic */ C0367g f1135e;

        C0376a(C0367g c0367g, int i) {
            this.f1135e = c0367g;
            this.f1131a = i;
            this.f1132b = c0367g.mo273a();
        }

        public boolean hasNext() {
            return this.f1133c < this.f1132b;
        }

        public T next() {
            T a = this.f1135e.mo275a(this.f1133c, this.f1131a);
            this.f1133c++;
            this.f1134d = true;
            return a;
        }

        public void remove() {
            if (this.f1134d) {
                this.f1133c--;
                this.f1132b--;
                this.f1134d = false;
                this.f1135e.mo277a(this.f1133c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class C0377b implements Set<Entry<K, V>> {
        final /* synthetic */ C0367g f1136a;

        C0377b(C0367g c0367g) {
            this.f1136a = c0367g;
        }

        public boolean m1931a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ boolean add(Object obj) {
            return m1931a((Entry) obj);
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f1136a.mo273a();
            for (Entry entry : collection) {
                this.f1136a.mo278a(entry.getKey(), entry.getValue());
            }
            return a != this.f1136a.mo273a();
        }

        public void clear() {
            this.f1136a.mo281c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f1136a.mo274a(entry.getKey());
            return a >= 0 ? C0371b.m1908a(this.f1136a.mo275a(a, 1), entry.getValue()) : false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return C0367g.m1865a((Set) this, obj);
        }

        public int hashCode() {
            int a = this.f1136a.mo273a() - 1;
            int i = 0;
            while (a >= 0) {
                Object a2 = this.f1136a.mo275a(a, 0);
                Object a3 = this.f1136a.mo275a(a, 1);
                a--;
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return this.f1136a.mo273a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C0379d(this.f1136a);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.f1136a.mo273a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class C0378c implements Set<K> {
        final /* synthetic */ C0367g f1137a;

        C0378c(C0367g c0367g) {
            this.f1137a = c0367g;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f1137a.mo281c();
        }

        public boolean contains(Object obj) {
            return this.f1137a.mo274a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C0367g.m1864a(this.f1137a.mo280b(), (Collection) collection);
        }

        public boolean equals(Object obj) {
            return C0367g.m1865a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f1137a.mo273a() - 1; a >= 0; a--) {
                Object a2 = this.f1137a.mo275a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return this.f1137a.mo273a() == 0;
        }

        public Iterator<K> iterator() {
            return new C0376a(this.f1137a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.f1137a.mo274a(obj);
            if (a < 0) {
                return false;
            }
            this.f1137a.mo277a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C0367g.m1866b(this.f1137a.mo280b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C0367g.m1867c(this.f1137a.mo280b(), collection);
        }

        public int size() {
            return this.f1137a.mo273a();
        }

        public Object[] toArray() {
            return this.f1137a.m1877b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f1137a.m1874a((Object[]) tArr, 0);
        }
    }

    final class C0379d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int f1138a;
        int f1139b;
        boolean f1140c = false;
        final /* synthetic */ C0367g f1141d;

        C0379d(C0367g c0367g) {
            this.f1141d = c0367g;
            this.f1138a = c0367g.mo273a() - 1;
            this.f1139b = -1;
        }

        public Entry<K, V> m1932a() {
            this.f1139b++;
            this.f1140c = true;
            return this;
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f1140c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(C0371b.m1908a(entry.getKey(), this.f1141d.mo275a(this.f1139b, 0)) && C0371b.m1908a(entry.getValue(), this.f1141d.mo275a(this.f1139b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public K getKey() {
            if (this.f1140c) {
                return this.f1141d.mo275a(this.f1139b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f1140c) {
                return this.f1141d.mo275a(this.f1139b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f1139b < this.f1138a;
        }

        public final int hashCode() {
            int i = 0;
            if (this.f1140c) {
                Object a = this.f1141d.mo275a(this.f1139b, 0);
                Object a2 = this.f1141d.mo275a(this.f1139b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public /* synthetic */ Object next() {
            return m1932a();
        }

        public void remove() {
            if (this.f1140c) {
                this.f1141d.mo277a(this.f1139b);
                this.f1139b--;
                this.f1138a--;
                this.f1140c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.f1140c) {
                return this.f1141d.mo276a(this.f1139b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class C0380e implements Collection<V> {
        final /* synthetic */ C0367g f1142a;

        C0380e(C0367g c0367g) {
            this.f1142a = c0367g;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f1142a.mo281c();
        }

        public boolean contains(Object obj) {
            return this.f1142a.mo279b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f1142a.mo273a() == 0;
        }

        public Iterator<V> iterator() {
            return new C0376a(this.f1142a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.f1142a.mo279b(obj);
            if (b < 0) {
                return false;
            }
            this.f1142a.mo277a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = this.f1142a.mo273a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f1142a.mo275a(i, 1))) {
                    this.f1142a.mo277a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int a = this.f1142a.mo273a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f1142a.mo275a(i, 1))) {
                    this.f1142a.mo277a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.f1142a.mo273a();
        }

        public Object[] toArray() {
            return this.f1142a.m1877b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f1142a.m1874a((Object[]) tArr, 1);
        }
    }

    C0367g() {
    }

    public static <K, V> boolean m1864a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean m1865a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static <K, V> boolean m1866b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m1867c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int mo273a();

    protected abstract int mo274a(Object obj);

    protected abstract Object mo275a(int i, int i2);

    protected abstract V mo276a(int i, V v);

    protected abstract void mo277a(int i);

    protected abstract void mo278a(K k, V v);

    public <T> T[] m1874a(T[] tArr, int i) {
        int a = mo273a();
        T[] tArr2 = tArr.length < a ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a) : tArr;
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = mo275a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    protected abstract int mo279b(Object obj);

    protected abstract Map<K, V> mo280b();

    public Object[] m1877b(int i) {
        int a = mo273a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo275a(i2, i);
        }
        return objArr;
    }

    protected abstract void mo281c();

    public Set<Entry<K, V>> m1879d() {
        if (this.f1101b == null) {
            this.f1101b = new C0377b(this);
        }
        return this.f1101b;
    }

    public Set<K> m1880e() {
        if (this.f1102c == null) {
            this.f1102c = new C0378c(this);
        }
        return this.f1102c;
    }

    public Collection<V> m1881f() {
        if (this.f1103d == null) {
            this.f1103d = new C0380e(this);
        }
        return this.f1103d;
    }
}
