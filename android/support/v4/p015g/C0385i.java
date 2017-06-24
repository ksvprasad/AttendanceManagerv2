package android.support.v4.p015g;

public final class C0385i {

    public interface C0382a<T> {
        T mo282a();

        boolean mo283a(T t);
    }

    public static class C0383b<T> implements C0382a<T> {
        private final Object[] f1145a;
        private int f1146b;

        public C0383b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f1145a = new Object[i];
        }

        private boolean m1937b(T t) {
            for (int i = 0; i < this.f1146b; i++) {
                if (this.f1145a[i] == t) {
                    return true;
                }
            }
            return false;
        }

        public T mo282a() {
            if (this.f1146b <= 0) {
                return null;
            }
            int i = this.f1146b - 1;
            T t = this.f1145a[i];
            this.f1145a[i] = null;
            this.f1146b--;
            return t;
        }

        public boolean mo283a(T t) {
            if (m1937b(t)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f1146b >= this.f1145a.length) {
                return false;
            } else {
                this.f1145a[this.f1146b] = t;
                this.f1146b++;
                return true;
            }
        }
    }

    public static class C0384c<T> extends C0383b<T> {
        private final Object f1147a = new Object();

        public C0384c(int i) {
            super(i);
        }

        public T mo282a() {
            T a;
            synchronized (this.f1147a) {
                a = super.mo282a();
            }
            return a;
        }

        public boolean mo283a(T t) {
            boolean a;
            synchronized (this.f1147a) {
                a = super.mo283a(t);
            }
            return a;
        }
    }
}
