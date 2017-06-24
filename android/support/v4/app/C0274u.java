package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.ab;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class C0274u extends ab {
    private final C0263r f1000a;
    private C0250v f1001b = null;
    private ArrayList<SavedState> f1002c = new ArrayList();
    private ArrayList<Fragment> f1003d = new ArrayList();
    private Fragment f1004e = null;

    public C0274u(C0263r c0263r) {
        this.f1000a = c0263r;
    }

    public Parcelable mo231a() {
        Bundle bundle = null;
        if (this.f1002c.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new SavedState[this.f1002c.size()];
            this.f1002c.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.f1003d.size(); i++) {
            Fragment fragment = (Fragment) this.f1003d.get(i);
            if (fragment != null && fragment.m1206n()) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.f1000a.mo227a(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public abstract Fragment mo1800a(int i);

    public Object mo232a(ViewGroup viewGroup, int i) {
        if (this.f1003d.size() > i) {
            Fragment fragment = (Fragment) this.f1003d.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f1001b == null) {
            this.f1001b = this.f1000a.mo224a();
        }
        Fragment a = mo1800a(i);
        if (this.f1002c.size() > i) {
            SavedState savedState = (SavedState) this.f1002c.get(i);
            if (savedState != null) {
                a.m1168a(savedState);
            }
        }
        while (this.f1003d.size() <= i) {
            this.f1003d.add(null);
        }
        a.m1190e(false);
        a.m1193f(false);
        this.f1003d.set(i, a);
        this.f1001b.mo188a(viewGroup.getId(), a);
        return a;
    }

    public void mo233a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f1002c.clear();
            this.f1003d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f1002c.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a = this.f1000a.mo222a(bundle, str);
                    if (a != null) {
                        while (this.f1003d.size() <= parseInt) {
                            this.f1003d.add(null);
                        }
                        a.m1190e(false);
                        this.f1003d.set(parseInt, a);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public void mo234a(ViewGroup viewGroup) {
    }

    public void mo235a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f1001b == null) {
            this.f1001b = this.f1000a.mo224a();
        }
        while (this.f1002c.size() <= i) {
            this.f1002c.add(null);
        }
        this.f1002c.set(i, fragment.m1206n() ? this.f1000a.mo221a(fragment) : null);
        this.f1003d.set(i, null);
        this.f1001b.mo190a(fragment);
    }

    public boolean mo236a(View view, Object obj) {
        return ((Fragment) obj).m1210r() == view;
    }

    public void mo237b(ViewGroup viewGroup) {
        if (this.f1001b != null) {
            this.f1001b.mo192b();
            this.f1001b = null;
            this.f1000a.mo229b();
        }
    }

    public void mo238b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f1004e) {
            if (this.f1004e != null) {
                this.f1004e.m1190e(false);
                this.f1004e.m1193f(false);
            }
            if (fragment != null) {
                fragment.m1190e(true);
                fragment.m1193f(true);
            }
            this.f1004e = fragment;
        }
    }
}
