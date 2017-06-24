package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class ab {
    private final DataSetObservable f995a = new DataSetObservable();
    private DataSetObserver f996b;

    public int mo1780a(Object obj) {
        return -1;
    }

    public Parcelable mo231a() {
        return null;
    }

    public Object m1576a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object mo232a(ViewGroup viewGroup, int i) {
        return m1576a((View) viewGroup, i);
    }

    public void m1578a(DataSetObserver dataSetObserver) {
        this.f995a.registerObserver(dataSetObserver);
    }

    public void mo233a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void m1580a(View view) {
    }

    public void m1581a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void mo234a(ViewGroup viewGroup) {
        m1580a((View) viewGroup);
    }

    public void mo235a(ViewGroup viewGroup, int i, Object obj) {
        m1581a((View) viewGroup, i, obj);
    }

    public abstract boolean mo236a(View view, Object obj);

    public abstract int mo879b();

    public void m1586b(DataSetObserver dataSetObserver) {
        this.f995a.unregisterObserver(dataSetObserver);
    }

    public void m1587b(View view) {
    }

    public void m1588b(View view, int i, Object obj) {
    }

    public void mo237b(ViewGroup viewGroup) {
        m1587b((View) viewGroup);
    }

    public void mo238b(ViewGroup viewGroup, int i, Object obj) {
        m1588b((View) viewGroup, i, obj);
    }

    public CharSequence mo1801c(int i) {
        return null;
    }

    public void m1592c() {
        synchronized (this) {
            if (this.f996b != null) {
                this.f996b.onChanged();
            }
        }
        this.f995a.notifyChanged();
    }

    void m1593c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f996b = dataSetObserver;
        }
    }

    public float m1594d(int i) {
        return 1.0f;
    }
}
