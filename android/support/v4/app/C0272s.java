package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.C0251i.C0249b;
import android.support.v4.app.C0263r.C0262a;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.p015g.C0372c;
import android.support.v4.p015g.C0373d;
import android.support.v4.view.C0271m;
import android.support.v4.view.ag;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class C0272s extends C0263r implements C0271m {
    static final Interpolator f965A = new DecelerateInterpolator(2.5f);
    static final Interpolator f966B = new DecelerateInterpolator(1.5f);
    static final Interpolator f967C = new AccelerateInterpolator(2.5f);
    static final Interpolator f968D = new AccelerateInterpolator(1.5f);
    static boolean f969a = false;
    static final boolean f970b;
    static Field f971r = null;
    ArrayList<Runnable> f972c;
    Runnable[] f973d;
    boolean f974e;
    ArrayList<Fragment> f975f;
    ArrayList<Fragment> f976g;
    ArrayList<Integer> f977h;
    ArrayList<C0251i> f978i;
    ArrayList<Fragment> f979j;
    ArrayList<C0251i> f980k;
    ArrayList<Integer> f981l;
    ArrayList<C0262a> f982m;
    int f983n = 0;
    C0257q f984o;
    C0187o f985p;
    Fragment f986q;
    boolean f987s;
    boolean f988t;
    boolean f989u;
    String f990v;
    boolean f991w;
    Bundle f992x = null;
    SparseArray<Parcelable> f993y = null;
    Runnable f994z = new C02641(this);

    class C02641 implements Runnable {
        final /* synthetic */ C0272s f953a;

        C02641(C0272s c0272s) {
            this.f953a = c0272s;
        }

        public void run() {
            this.f953a.m1556e();
        }
    }

    static class C0266a implements AnimationListener {
        private AnimationListener f957a = null;
        private boolean f958b = false;
        private View f959c = null;

        class C02681 implements Runnable {
            final /* synthetic */ C0266a f962a;

            C02681(C0266a c0266a) {
                this.f962a = c0266a;
            }

            public void run() {
                ag.m2514a(this.f962a.f959c, 2, null);
            }
        }

        class C02692 implements Runnable {
            final /* synthetic */ C0266a f963a;

            C02692(C0266a c0266a) {
                this.f963a = c0266a;
            }

            public void run() {
                ag.m2514a(this.f963a.f959c, 0, null);
            }
        }

        public C0266a(View view, Animation animation) {
            if (view != null && animation != null) {
                this.f959c = view;
            }
        }

        public C0266a(View view, Animation animation, AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.f957a = animationListener;
                this.f959c = view;
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f959c != null && this.f958b) {
                this.f959c.post(new C02692(this));
            }
            if (this.f957a != null) {
                this.f957a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.f957a != null) {
                this.f957a.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.f959c != null) {
                this.f958b = C0272s.m1509a(this.f959c, animation);
                if (this.f958b) {
                    this.f959c.post(new C02681(this));
                }
            }
            if (this.f957a != null) {
                this.f957a.onAnimationStart(animation);
            }
        }
    }

    static class C0270b {
        public static final int[] f964a = new int[]{16842755, 16842960, 16842961};
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f970b = z;
    }

    C0272s() {
    }

    static Animation m1506a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f966B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    static Animation m1507a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f965A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f966B);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private void m1508a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0373d("FragmentManager"));
        if (this.f984o != null) {
            try {
                this.f984o.mo207a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo228a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    static boolean m1509a(View view, Animation animation) {
        return VERSION.SDK_INT >= 19 && ag.m2539g(view) == 0 && ag.m2554v(view) && C0272s.m1510a(animation);
    }

    static boolean m1510a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    public static int m1511b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    private void m1512b(View view, Animation animation) {
        if (view != null && animation != null && C0272s.m1509a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (f971r == null) {
                    f971r = Animation.class.getDeclaredField("mListener");
                    f971r.setAccessible(true);
                }
                animationListener = (AnimationListener) f971r.get(animation);
            } catch (Throwable e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            animation.setAnimationListener(new C0266a(view, animation, animationListener));
        }
    }

    public static int m1513c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void m1514u() {
        if (this.f988t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f990v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f990v);
        }
    }

    public int m1515a(C0251i c0251i) {
        int size;
        synchronized (this) {
            if (this.f981l == null || this.f981l.size() <= 0) {
                if (this.f980k == null) {
                    this.f980k = new ArrayList();
                }
                size = this.f980k.size();
                if (f969a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0251i);
                }
                this.f980k.add(c0251i);
            } else {
                size = ((Integer) this.f981l.remove(this.f981l.size() - 1)).intValue();
                if (f969a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0251i);
                }
                this.f980k.set(size, c0251i);
            }
        }
        return size;
    }

    public SavedState mo221a(Fragment fragment) {
        if (fragment.f765p < 0) {
            m1508a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.f760k <= 0) {
            return null;
        }
        Bundle g = m1559g(fragment);
        return g != null ? new SavedState(g) : null;
    }

    public Fragment m1517a(int i) {
        int size;
        Fragment fragment;
        if (this.f976g != null) {
            for (size = this.f976g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f976g.get(size);
                if (fragment != null && fragment.f739F == i) {
                    return fragment;
                }
            }
        }
        if (this.f975f != null) {
            for (size = this.f975f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f975f.get(size);
                if (fragment != null && fragment.f739F == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment mo222a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f975f.size()) {
            m1508a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f975f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m1508a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public Fragment mo223a(String str) {
        int size;
        Fragment fragment;
        if (!(this.f976g == null || str == null)) {
            for (size = this.f976g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f976g.get(size);
                if (fragment != null && str.equals(fragment.f741H)) {
                    return fragment;
                }
            }
        }
        if (!(this.f975f == null || str == null)) {
            for (size = this.f975f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f975f.get(size);
                if (fragment != null && str.equals(fragment.f741H)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public C0250v mo224a() {
        return new C0251i(this);
    }

    public View mo225a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0270b.f964a);
        String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.m1138b(this.f984o.m1430g(), string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment a = resourceId != -1 ? m1517a(resourceId) : null;
        if (a == null && string2 != null) {
            a = mo223a(string2);
        }
        if (a == null && id != -1) {
            a = m1517a(id);
        }
        if (f969a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a);
        }
        if (a == null) {
            Fragment a2 = Fragment.m1136a(context, string);
            a2.f773x = true;
            a2.f739F = resourceId != 0 ? resourceId : id;
            a2.f740G = id;
            a2.f741H = string2;
            a2.f774y = true;
            a2.f735B = this;
            a2.f736C = this.f984o;
            a2.m1162a(this.f984o.m1430g(), attributeSet, a2.f763n);
            m1532a(a2, true);
            fragment = a2;
        } else if (a.f774y) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            a.f774y = true;
            a.f736C = this.f984o;
            if (!a.f745L) {
                a.m1162a(this.f984o.m1430g(), attributeSet, a.f763n);
            }
            fragment = a;
        }
        if (this.f983n >= 1 || !fragment.f773x) {
            m1548c(fragment);
        } else {
            m1531a(fragment, 1, 0, 0, false);
        }
        if (fragment.f751R == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.f751R.setId(resourceId);
        }
        if (fragment.f751R.getTag() == null) {
            fragment.f751R.setTag(string2);
        }
        return fragment.f751R;
    }

    Animation m1522a(Fragment fragment, int i, boolean z, int i2) {
        Animation a = fragment.m1155a(i, z, fragment.f749P);
        if (a != null) {
            return a;
        }
        if (fragment.f749P != 0) {
            a = AnimationUtils.loadAnimation(this.f984o.m1430g(), fragment.f749P);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = C0272s.m1511b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return C0272s.m1507a(this.f984o.m1430g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return C0272s.m1507a(this.f984o.m1430g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return C0272s.m1507a(this.f984o.m1430g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return C0272s.m1507a(this.f984o.m1430g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return C0272s.m1506a(this.f984o.m1430g(), 0.0f, 1.0f);
            case 6:
                return C0272s.m1506a(this.f984o.m1430g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f984o.mo212d()) {
                    i2 = this.f984o.mo213e();
                }
                return i2 == 0 ? null : null;
        }
    }

    public void mo226a(final int i, final int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m1534a(new Runnable(this) {
            final /* synthetic */ C0272s f956c;

            public void run() {
                this.f956c.m1536a(this.f956c.f984o.m1431h(), null, i, i2);
            }
        }, false);
    }

    void m1524a(int i, int i2, int i3, boolean z) {
        if (this.f984o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.f983n != i) {
            this.f983n = i;
            if (this.f975f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f975f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f975f.get(i4);
                    if (fragment != null) {
                        m1531a(fragment, i, i2, i3, false);
                        if (fragment.f755V != null) {
                            a = i5 | fragment.f755V.mo239a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m1551d();
                }
                if (this.f987s && this.f984o != null && this.f983n == 5) {
                    this.f984o.mo211c();
                    this.f987s = false;
                }
            }
        }
    }

    public void m1525a(int i, C0251i c0251i) {
        synchronized (this) {
            if (this.f980k == null) {
                this.f980k = new ArrayList();
            }
            int size = this.f980k.size();
            if (i < size) {
                if (f969a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0251i);
                }
                this.f980k.set(i, c0251i);
            } else {
                while (size < i) {
                    this.f980k.add(null);
                    if (this.f981l == null) {
                        this.f981l = new ArrayList();
                    }
                    if (f969a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f981l.add(Integer.valueOf(size));
                    size++;
                }
                if (f969a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0251i);
                }
                this.f980k.add(c0251i);
            }
        }
    }

    void m1526a(int i, boolean z) {
        m1524a(i, 0, 0, z);
    }

    public void m1527a(Configuration configuration) {
        if (this.f976g != null) {
            for (int i = 0; i < this.f976g.size(); i++) {
                Fragment fragment = (Fragment) this.f976g.get(i);
                if (fragment != null) {
                    fragment.m1166a(configuration);
                }
            }
        }
    }

    public void mo227a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f765p < 0) {
            m1508a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.f765p);
    }

    void m1529a(Parcelable parcelable, List<Fragment> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f776a != null) {
                int i;
                Fragment fragment;
                int i2;
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        fragment = (Fragment) list.get(i);
                        if (f969a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f776a[fragment.f765p];
                        fragmentState.f789k = fragment;
                        fragment.f764o = null;
                        fragment.f734A = 0;
                        fragment.f774y = false;
                        fragment.f771v = false;
                        fragment.f768s = null;
                        if (fragmentState.f788j != null) {
                            fragmentState.f788j.setClassLoader(this.f984o.m1430g().getClassLoader());
                            fragment.f764o = fragmentState.f788j.getSparseParcelableArray("android:view_state");
                            fragment.f763n = fragmentState.f788j;
                        }
                    }
                }
                this.f975f = new ArrayList(fragmentManagerState.f776a.length);
                if (this.f977h != null) {
                    this.f977h.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.f776a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.f776a[i2];
                    if (fragmentState2 != null) {
                        Fragment a = fragmentState2.m1223a(this.f984o, this.f986q);
                        if (f969a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.f975f.add(a);
                        fragmentState2.f789k = null;
                    } else {
                        this.f975f.add(null);
                        if (this.f977h == null) {
                            this.f977h = new ArrayList();
                        }
                        if (f969a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f977h.add(Integer.valueOf(i2));
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        fragment = (Fragment) list.get(i3);
                        if (fragment.f769t >= 0) {
                            if (fragment.f769t < this.f975f.size()) {
                                fragment.f768s = (Fragment) this.f975f.get(fragment.f769t);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.f769t);
                                fragment.f768s = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f777b != null) {
                    this.f976g = new ArrayList(fragmentManagerState.f777b.length);
                    for (i = 0; i < fragmentManagerState.f777b.length; i++) {
                        fragment = (Fragment) this.f975f.get(fragmentManagerState.f777b[i]);
                        if (fragment == null) {
                            m1508a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f777b[i]));
                        }
                        fragment.f771v = true;
                        if (f969a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment);
                        }
                        if (this.f976g.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f976g.add(fragment);
                    }
                } else {
                    this.f976g = null;
                }
                if (fragmentManagerState.f778c != null) {
                    this.f978i = new ArrayList(fragmentManagerState.f778c.length);
                    for (i2 = 0; i2 < fragmentManagerState.f778c.length; i2++) {
                        C0251i a2 = fragmentManagerState.f778c[i2].m1129a(this);
                        if (f969a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.f909p + "): " + a2);
                            a2.m1390a("  ", new PrintWriter(new C0373d("FragmentManager")), false);
                        }
                        this.f978i.add(a2);
                        if (a2.f909p >= 0) {
                            m1525a(a2.f909p, a2);
                        }
                    }
                    return;
                }
                this.f978i = null;
            }
        }
    }

    public void m1530a(Fragment fragment, int i, int i2) {
        if (f969a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f734A);
        }
        boolean z = !fragment.m1195g();
        if (!fragment.f743J || z) {
            if (this.f976g != null) {
                this.f976g.remove(fragment);
            }
            if (fragment.f746M && fragment.f747N) {
                this.f987s = true;
            }
            fragment.f771v = false;
            fragment.f772w = true;
            m1531a(fragment, z ? 0 : 1, i, i2, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1531a(final android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r3 = 0;
        r7 = 0;
        r0 = r11.f771v;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.f743J;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.f772w;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.f760k;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.f760k;
    L_0x001a:
        r0 = r11.f753T;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.f760k;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.f760k;
        if (r0 >= r12) goto L_0x02aa;
    L_0x0029:
        r0 = r11.f773x;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.f774y;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.f761l;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.f761l = r7;
        r2 = r11.f762m;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m1531a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.f760k;
        switch(r0) {
            case 0: goto L_0x0080;
            case 1: goto L_0x0176;
            case 2: goto L_0x0247;
            case 3: goto L_0x0247;
            case 4: goto L_0x0268;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.f760k;
        if (r0 == r12) goto L_0x0031;
    L_0x0049:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.f760k;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.f760k = r12;
        goto L_0x0031;
    L_0x0080:
        r0 = f969a;
        if (r0 == 0) goto L_0x009c;
    L_0x0084:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x009c:
        r0 = r11.f763n;
        if (r0 == 0) goto L_0x00e4;
    L_0x00a0:
        r0 = r11.f763n;
        r1 = r10.f984o;
        r1 = r1.m1430g();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.f763n;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.f764o = r0;
        r0 = r11.f763n;
        r1 = "android:target_state";
        r0 = r10.mo222a(r0, r1);
        r11.f768s = r0;
        r0 = r11.f768s;
        if (r0 == 0) goto L_0x00d1;
    L_0x00c7:
        r0 = r11.f763n;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.f770u = r0;
    L_0x00d1:
        r0 = r11.f763n;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.f754U = r0;
        r0 = r11.f754U;
        if (r0 != 0) goto L_0x00e4;
    L_0x00df:
        r11.f753T = r5;
        if (r12 <= r6) goto L_0x00e4;
    L_0x00e3:
        r12 = r6;
    L_0x00e4:
        r0 = r10.f984o;
        r11.f736C = r0;
        r0 = r10.f986q;
        r11.f738E = r0;
        r0 = r10.f986q;
        if (r0 == 0) goto L_0x0124;
    L_0x00f0:
        r0 = r10.f986q;
        r0 = r0.f737D;
    L_0x00f4:
        r11.f735B = r0;
        r11.f748O = r3;
        r0 = r10.f984o;
        r0 = r0.m1430g();
        r11.m1161a(r0);
        r0 = r11.f748O;
        if (r0 != 0) goto L_0x012b;
    L_0x0105:
        r0 = new android.support.v4.app.as;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0124:
        r0 = r10.f984o;
        r0 = r0.m1432i();
        goto L_0x00f4;
    L_0x012b:
        r0 = r11.f738E;
        if (r0 != 0) goto L_0x0134;
    L_0x012f:
        r0 = r10.f984o;
        r0.mo210b(r11);
    L_0x0134:
        r0 = r11.f745L;
        if (r0 != 0) goto L_0x013d;
    L_0x0138:
        r0 = r11.f763n;
        r11.m1199i(r0);
    L_0x013d:
        r11.f745L = r3;
        r0 = r11.f773x;
        if (r0 == 0) goto L_0x0176;
    L_0x0143:
        r0 = r11.f763n;
        r0 = r11.mo199b(r0);
        r1 = r11.f763n;
        r0 = r11.m1175b(r0, r7, r1);
        r11.f751R = r0;
        r0 = r11.f751R;
        if (r0 == 0) goto L_0x0299;
    L_0x0155:
        r0 = r11.f751R;
        r11.f752S = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x028f;
    L_0x015f:
        r0 = r11.f751R;
        android.support.v4.view.ag.m2525b(r0, r3);
    L_0x0164:
        r0 = r11.f742I;
        if (r0 == 0) goto L_0x016f;
    L_0x0168:
        r0 = r11.f751R;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x016f:
        r0 = r11.f751R;
        r1 = r11.f763n;
        r11.mo1787a(r0, r1);
    L_0x0176:
        if (r12 <= r5) goto L_0x0247;
    L_0x0178:
        r0 = f969a;
        if (r0 == 0) goto L_0x0194;
    L_0x017c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0194:
        r0 = r11.f773x;
        if (r0 != 0) goto L_0x0237;
    L_0x0198:
        r0 = r11.f740G;
        if (r0 == 0) goto L_0x0408;
    L_0x019c:
        r0 = r10.f985p;
        r1 = r11.f740G;
        r0 = r0.mo167a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01eb;
    L_0x01a8:
        r1 = r11.f775z;
        if (r1 != 0) goto L_0x01eb;
    L_0x01ac:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "No view found for id 0x";
        r2 = r2.append(r4);
        r4 = r11.f740G;
        r4 = java.lang.Integer.toHexString(r4);
        r2 = r2.append(r4);
        r4 = " (";
        r2 = r2.append(r4);
        r4 = r11.m1202k();
        r8 = r11.f740G;
        r4 = r4.getResourceName(r8);
        r2 = r2.append(r4);
        r4 = ") for fragment ";
        r2 = r2.append(r4);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r1.<init>(r2);
        r10.m1508a(r1);
    L_0x01eb:
        r11.f750Q = r0;
        r1 = r11.f763n;
        r1 = r11.mo199b(r1);
        r2 = r11.f763n;
        r1 = r11.m1175b(r1, r0, r2);
        r11.f751R = r1;
        r1 = r11.f751R;
        if (r1 == 0) goto L_0x02a7;
    L_0x01ff:
        r1 = r11.f751R;
        r11.f752S = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x029d;
    L_0x0209:
        r1 = r11.f751R;
        android.support.v4.view.ag.m2525b(r1, r3);
    L_0x020e:
        if (r0 == 0) goto L_0x0225;
    L_0x0210:
        r1 = r10.m1522a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x0220;
    L_0x0216:
        r2 = r11.f751R;
        r10.m1512b(r2, r1);
        r2 = r11.f751R;
        r2.startAnimation(r1);
    L_0x0220:
        r1 = r11.f751R;
        r0.addView(r1);
    L_0x0225:
        r0 = r11.f742I;
        if (r0 == 0) goto L_0x0230;
    L_0x0229:
        r0 = r11.f751R;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0230:
        r0 = r11.f751R;
        r1 = r11.f763n;
        r11.mo1787a(r0, r1);
    L_0x0237:
        r0 = r11.f763n;
        r11.m1201j(r0);
        r0 = r11.f751R;
        if (r0 == 0) goto L_0x0245;
    L_0x0240:
        r0 = r11.f763n;
        r11.m1192f(r0);
    L_0x0245:
        r11.f763n = r7;
    L_0x0247:
        if (r12 <= r6) goto L_0x0268;
    L_0x0249:
        r0 = f969a;
        if (r0 == 0) goto L_0x0265;
    L_0x024d:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0265:
        r11.m1145G();
    L_0x0268:
        if (r12 <= r9) goto L_0x0045;
    L_0x026a:
        r0 = f969a;
        if (r0 == 0) goto L_0x0286;
    L_0x026e:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0286:
        r11.m1146H();
        r11.f763n = r7;
        r11.f764o = r7;
        goto L_0x0045;
    L_0x028f:
        r0 = r11.f751R;
        r0 = android.support.v4.app.ab.m1235a(r0);
        r11.f751R = r0;
        goto L_0x0164;
    L_0x0299:
        r11.f752S = r7;
        goto L_0x0176;
    L_0x029d:
        r1 = r11.f751R;
        r1 = android.support.v4.app.ab.m1235a(r1);
        r11.f751R = r1;
        goto L_0x020e;
    L_0x02a7:
        r11.f752S = r7;
        goto L_0x0237;
    L_0x02aa:
        r0 = r11.f760k;
        if (r0 <= r12) goto L_0x0045;
    L_0x02ae:
        r0 = r11.f760k;
        switch(r0) {
            case 1: goto L_0x02b5;
            case 2: goto L_0x0333;
            case 3: goto L_0x0312;
            case 4: goto L_0x02f1;
            case 5: goto L_0x02cf;
            default: goto L_0x02b3;
        };
    L_0x02b3:
        goto L_0x0045;
    L_0x02b5:
        if (r12 >= r5) goto L_0x0045;
    L_0x02b7:
        r0 = r10.f989u;
        if (r0 == 0) goto L_0x02c6;
    L_0x02bb:
        r0 = r11.f761l;
        if (r0 == 0) goto L_0x02c6;
    L_0x02bf:
        r0 = r11.f761l;
        r11.f761l = r7;
        r0.clearAnimation();
    L_0x02c6:
        r0 = r11.f761l;
        if (r0 == 0) goto L_0x03a2;
    L_0x02ca:
        r11.f762m = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x02cf:
        r0 = 5;
        if (r12 >= r0) goto L_0x02f1;
    L_0x02d2:
        r0 = f969a;
        if (r0 == 0) goto L_0x02ee;
    L_0x02d6:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02ee:
        r11.m1148J();
    L_0x02f1:
        if (r12 >= r9) goto L_0x0312;
    L_0x02f3:
        r0 = f969a;
        if (r0 == 0) goto L_0x030f;
    L_0x02f7:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x030f:
        r11.m1149K();
    L_0x0312:
        if (r12 >= r6) goto L_0x0333;
    L_0x0314:
        r0 = f969a;
        if (r0 == 0) goto L_0x0330;
    L_0x0318:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0330:
        r11.m1150L();
    L_0x0333:
        r0 = 2;
        if (r12 >= r0) goto L_0x02b5;
    L_0x0336:
        r0 = f969a;
        if (r0 == 0) goto L_0x0352;
    L_0x033a:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0352:
        r0 = r11.f751R;
        if (r0 == 0) goto L_0x0365;
    L_0x0356:
        r0 = r10.f984o;
        r0 = r0.mo208a(r11);
        if (r0 == 0) goto L_0x0365;
    L_0x035e:
        r0 = r11.f764o;
        if (r0 != 0) goto L_0x0365;
    L_0x0362:
        r10.m1558f(r11);
    L_0x0365:
        r11.m1151M();
        r0 = r11.f751R;
        if (r0 == 0) goto L_0x039a;
    L_0x036c:
        r0 = r11.f750Q;
        if (r0 == 0) goto L_0x039a;
    L_0x0370:
        r0 = r10.f983n;
        if (r0 <= 0) goto L_0x0405;
    L_0x0374:
        r0 = r10.f989u;
        if (r0 != 0) goto L_0x0405;
    L_0x0378:
        r0 = r10.m1522a(r11, r13, r3, r14);
    L_0x037c:
        if (r0 == 0) goto L_0x0393;
    L_0x037e:
        r1 = r11.f751R;
        r11.f761l = r1;
        r11.f762m = r12;
        r1 = r11.f751R;
        r2 = new android.support.v4.app.s$3;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.f751R;
        r1.startAnimation(r0);
    L_0x0393:
        r0 = r11.f750Q;
        r1 = r11.f751R;
        r0.removeView(r1);
    L_0x039a:
        r11.f750Q = r7;
        r11.f751R = r7;
        r11.f752S = r7;
        goto L_0x02b5;
    L_0x03a2:
        r0 = f969a;
        if (r0 == 0) goto L_0x03be;
    L_0x03a6:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03be:
        r0 = r11.f745L;
        if (r0 != 0) goto L_0x03ed;
    L_0x03c2:
        r11.m1152N();
    L_0x03c5:
        r11.f748O = r3;
        r11.mo200c();
        r0 = r11.f748O;
        if (r0 != 0) goto L_0x03f0;
    L_0x03ce:
        r0 = new android.support.v4.app.as;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x03ed:
        r11.f760k = r3;
        goto L_0x03c5;
    L_0x03f0:
        if (r15 != 0) goto L_0x0045;
    L_0x03f2:
        r0 = r11.f745L;
        if (r0 != 0) goto L_0x03fb;
    L_0x03f6:
        r10.m1554e(r11);
        goto L_0x0045;
    L_0x03fb:
        r11.f736C = r7;
        r11.f738E = r7;
        r11.f735B = r7;
        r11.f737D = r7;
        goto L_0x0045;
    L_0x0405:
        r0 = r7;
        goto L_0x037c;
    L_0x0408:
        r0 = r7;
        goto L_0x01eb;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.s.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    public void m1532a(Fragment fragment, boolean z) {
        if (this.f976g == null) {
            this.f976g = new ArrayList();
        }
        if (f969a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m1552d(fragment);
        if (!fragment.f743J) {
            if (this.f976g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.f976g.add(fragment);
            fragment.f771v = true;
            fragment.f772w = false;
            if (fragment.f746M && fragment.f747N) {
                this.f987s = true;
            }
            if (z) {
                m1548c(fragment);
            }
        }
    }

    public void m1533a(C0257q c0257q, C0187o c0187o, Fragment fragment) {
        if (this.f984o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f984o = c0257q;
        this.f985p = c0187o;
        this.f986q = fragment;
    }

    public void m1534a(Runnable runnable, boolean z) {
        if (!z) {
            m1514u();
        }
        synchronized (this) {
            if (this.f989u || this.f984o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f972c == null) {
                this.f972c = new ArrayList();
            }
            this.f972c.add(runnable);
            if (this.f972c.size() == 1) {
                this.f984o.m1431h().removeCallbacks(this.f994z);
                this.f984o.m1431h().post(this.f994z);
            }
        }
    }

    public void mo228a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f975f != null) {
            size = this.f975f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f975f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.mo1620a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f976g != null) {
            size = this.f976g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f976g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f979j != null) {
            size = this.f979j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f979j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f978i != null) {
            size = this.f978i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0251i c0251i = (C0251i) this.f978i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0251i.toString());
                    c0251i.m1389a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f980k != null) {
                int size2 = this.f980k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0251i = (C0251i) this.f980k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0251i);
                    }
                }
            }
            if (this.f981l != null && this.f981l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f981l.toArray()));
            }
        }
        if (this.f972c != null) {
            i = this.f972c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f972c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f984o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f985p);
        if (this.f986q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f986q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f983n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f988t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f989u);
        if (this.f987s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f987s);
        }
        if (this.f990v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f990v);
        }
        if (this.f977h != null && this.f977h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f977h.toArray()));
        }
    }

    boolean m1536a(Handler handler, String str, int i, int i2) {
        if (this.f978i == null) {
            return false;
        }
        int size;
        C0251i c0251i;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.f978i.size() - 1;
            if (size < 0) {
                return false;
            }
            c0251i = (C0251i) this.f978i.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            c0251i.m1388a(sparseArray, sparseArray2);
            c0251i.m1381a(true, null, sparseArray, sparseArray2);
            m1557f();
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                size2 = this.f978i.size() - 1;
                while (size2 >= 0) {
                    c0251i = (C0251i) this.f978i.get(size2);
                    if ((str != null && str.equals(c0251i.m1396c())) || (i >= 0 && i == c0251i.f909p)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        c0251i = (C0251i) this.f978i.get(size2);
                        if ((str == null || !str.equals(c0251i.m1396c())) && (i < 0 || i != c0251i.f909p)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.f978i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size2 = this.f978i.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f978i.remove(size2));
            }
            int size3 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            for (size2 = 0; size2 <= size3; size2++) {
                ((C0251i) arrayList.get(size2)).m1388a(sparseArray3, sparseArray4);
            }
            C0249b c0249b = null;
            int i3 = 0;
            while (i3 <= size3) {
                if (f969a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i3));
                }
                i3++;
                c0249b = ((C0251i) arrayList.get(i3)).m1381a(i3 == size3, c0249b, sparseArray3, sparseArray4);
            }
            m1557f();
        }
        return true;
    }

    public boolean m1537a(Menu menu) {
        if (this.f976g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f976g.size(); i++) {
            Fragment fragment = (Fragment) this.f976g.get(i);
            if (fragment != null && fragment.m1181c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m1538a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f976g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f976g.size()) {
                fragment = (Fragment) this.f976g.get(i2);
                if (fragment != null && fragment.m1177b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f979j != null) {
            while (i < this.f979j.size()) {
                fragment = (Fragment) this.f979j.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.m1215w();
                }
                i++;
            }
        }
        this.f979j = arrayList;
        return z;
    }

    public boolean m1539a(MenuItem menuItem) {
        if (this.f976g == null) {
            return false;
        }
        for (int i = 0; i < this.f976g.size(); i++) {
            Fragment fragment = (Fragment) this.f976g.get(i);
            if (fragment != null && fragment.m1182c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public Fragment m1540b(String str) {
        if (!(this.f975f == null || str == null)) {
            for (int size = this.f975f.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f975f.get(size);
                if (fragment != null) {
                    fragment = fragment.m1153a(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    public void m1541b(int i) {
        synchronized (this) {
            this.f980k.set(i, null);
            if (this.f981l == null) {
                this.f981l = new ArrayList();
            }
            if (f969a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f981l.add(Integer.valueOf(i));
        }
    }

    public void m1542b(Fragment fragment) {
        if (!fragment.f753T) {
            return;
        }
        if (this.f974e) {
            this.f991w = true;
            return;
        }
        fragment.f753T = false;
        m1531a(fragment, this.f983n, 0, 0, false);
    }

    public void m1543b(Fragment fragment, int i, int i2) {
        if (f969a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.f742I) {
            fragment.f742I = true;
            if (fragment.f751R != null) {
                Animation a = m1522a(fragment, i, false, i2);
                if (a != null) {
                    m1512b(fragment.f751R, a);
                    fragment.f751R.startAnimation(a);
                }
                fragment.f751R.setVisibility(8);
            }
            if (fragment.f771v && fragment.f746M && fragment.f747N) {
                this.f987s = true;
            }
            fragment.m1180c(true);
        }
    }

    void m1544b(C0251i c0251i) {
        if (this.f978i == null) {
            this.f978i = new ArrayList();
        }
        this.f978i.add(c0251i);
        m1557f();
    }

    public void m1545b(Menu menu) {
        if (this.f976g != null) {
            for (int i = 0; i < this.f976g.size(); i++) {
                Fragment fragment = (Fragment) this.f976g.get(i);
                if (fragment != null) {
                    fragment.m1185d(menu);
                }
            }
        }
    }

    public boolean mo229b() {
        return m1556e();
    }

    public boolean m1547b(MenuItem menuItem) {
        if (this.f976g == null) {
            return false;
        }
        for (int i = 0; i < this.f976g.size(); i++) {
            Fragment fragment = (Fragment) this.f976g.get(i);
            if (fragment != null && fragment.m1187d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void m1548c(Fragment fragment) {
        m1531a(fragment, this.f983n, 0, 0, false);
    }

    public void m1549c(Fragment fragment, int i, int i2) {
        if (f969a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f742I) {
            fragment.f742I = false;
            if (fragment.f751R != null) {
                Animation a = m1522a(fragment, i, true, i2);
                if (a != null) {
                    m1512b(fragment.f751R, a);
                    fragment.f751R.startAnimation(a);
                }
                fragment.f751R.setVisibility(0);
            }
            if (fragment.f771v && fragment.f746M && fragment.f747N) {
                this.f987s = true;
            }
            fragment.m1180c(false);
        }
    }

    public boolean mo230c() {
        m1514u();
        mo229b();
        return m1536a(this.f984o.m1431h(), null, -1, 0);
    }

    void m1551d() {
        if (this.f975f != null) {
            for (int i = 0; i < this.f975f.size(); i++) {
                Fragment fragment = (Fragment) this.f975f.get(i);
                if (fragment != null) {
                    m1542b(fragment);
                }
            }
        }
    }

    void m1552d(Fragment fragment) {
        if (fragment.f765p < 0) {
            if (this.f977h == null || this.f977h.size() <= 0) {
                if (this.f975f == null) {
                    this.f975f = new ArrayList();
                }
                fragment.m1157a(this.f975f.size(), this.f986q);
                this.f975f.add(fragment);
            } else {
                fragment.m1157a(((Integer) this.f977h.remove(this.f977h.size() - 1)).intValue(), this.f986q);
                this.f975f.set(fragment.f765p, fragment);
            }
            if (f969a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    public void m1553d(Fragment fragment, int i, int i2) {
        if (f969a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.f743J) {
            fragment.f743J = true;
            if (fragment.f771v) {
                if (this.f976g != null) {
                    if (f969a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f976g.remove(fragment);
                }
                if (fragment.f746M && fragment.f747N) {
                    this.f987s = true;
                }
                fragment.f771v = false;
                m1531a(fragment, 1, i, i2, false);
            }
        }
    }

    void m1554e(Fragment fragment) {
        if (fragment.f765p >= 0) {
            if (f969a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f975f.set(fragment.f765p, null);
            if (this.f977h == null) {
                this.f977h = new ArrayList();
            }
            this.f977h.add(Integer.valueOf(fragment.f765p));
            this.f984o.m1418a(fragment.f766q);
            fragment.m1214v();
        }
    }

    public void m1555e(Fragment fragment, int i, int i2) {
        if (f969a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f743J) {
            fragment.f743J = false;
            if (!fragment.f771v) {
                if (this.f976g == null) {
                    this.f976g = new ArrayList();
                }
                if (this.f976g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f969a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f976g.add(fragment);
                fragment.f771v = true;
                if (fragment.f746M && fragment.f747N) {
                    this.f987s = true;
                }
                m1531a(fragment, this.f983n, i, i2, false);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m1556e() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.f974e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.f984o;
        r3 = r3.m1431h();
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0026;
    L_0x001e:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r1 = r2;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.f972c;	 Catch:{ all -> 0x009b }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.f972c;	 Catch:{ all -> 0x009b }
        r3 = r3.size();	 Catch:{ all -> 0x009b }
        if (r3 != 0) goto L_0x005c;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r0 = r6.f991w;
        if (r0 == 0) goto L_0x00a9;
    L_0x0039:
        r3 = r2;
        r4 = r2;
    L_0x003b:
        r0 = r6.f975f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x00a2;
    L_0x0043:
        r0 = r6.f975f;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x0058;
    L_0x004d:
        r5 = r0.f755V;
        if (r5 == 0) goto L_0x0058;
    L_0x0051:
        r0 = r0.f755V;
        r0 = r0.mo239a();
        r4 = r4 | r0;
    L_0x0058:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x003b;
    L_0x005c:
        r1 = r6.f972c;	 Catch:{ all -> 0x009b }
        r3 = r1.size();	 Catch:{ all -> 0x009b }
        r1 = r6.f973d;	 Catch:{ all -> 0x009b }
        if (r1 == 0) goto L_0x006b;
    L_0x0066:
        r1 = r6.f973d;	 Catch:{ all -> 0x009b }
        r1 = r1.length;	 Catch:{ all -> 0x009b }
        if (r1 >= r3) goto L_0x006f;
    L_0x006b:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x009b }
        r6.f973d = r1;	 Catch:{ all -> 0x009b }
    L_0x006f:
        r1 = r6.f972c;	 Catch:{ all -> 0x009b }
        r4 = r6.f973d;	 Catch:{ all -> 0x009b }
        r1.toArray(r4);	 Catch:{ all -> 0x009b }
        r1 = r6.f972c;	 Catch:{ all -> 0x009b }
        r1.clear();	 Catch:{ all -> 0x009b }
        r1 = r6.f984o;	 Catch:{ all -> 0x009b }
        r1 = r1.m1431h();	 Catch:{ all -> 0x009b }
        r4 = r6.f994z;	 Catch:{ all -> 0x009b }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x009b }
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r6.f974e = r0;
        r1 = r2;
    L_0x008a:
        if (r1 >= r3) goto L_0x009e;
    L_0x008c:
        r4 = r6.f973d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.f973d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x008a;
    L_0x009b:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        throw r0;
    L_0x009e:
        r6.f974e = r2;
        r1 = r0;
        goto L_0x0027;
    L_0x00a2:
        if (r4 != 0) goto L_0x00a9;
    L_0x00a4:
        r6.f991w = r2;
        r6.m1551d();
    L_0x00a9:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.s.e():boolean");
    }

    void m1557f() {
        if (this.f982m != null) {
            for (int i = 0; i < this.f982m.size(); i++) {
                ((C0262a) this.f982m.get(i)).m1494a();
            }
        }
    }

    void m1558f(Fragment fragment) {
        if (fragment.f752S != null) {
            if (this.f993y == null) {
                this.f993y = new SparseArray();
            } else {
                this.f993y.clear();
            }
            fragment.f752S.saveHierarchyState(this.f993y);
            if (this.f993y.size() > 0) {
                fragment.f764o = this.f993y;
                this.f993y = null;
            }
        }
    }

    Bundle m1559g(Fragment fragment) {
        Bundle bundle;
        if (this.f992x == null) {
            this.f992x = new Bundle();
        }
        fragment.m1203k(this.f992x);
        if (this.f992x.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f992x;
            this.f992x = null;
        }
        if (fragment.f751R != null) {
            m1558f(fragment);
        }
        if (fragment.f764o != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f764o);
        }
        if (!fragment.f754U) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.f754U);
        }
        return bundle;
    }

    ArrayList<Fragment> m1560g() {
        ArrayList<Fragment> arrayList = null;
        if (this.f975f != null) {
            for (int i = 0; i < this.f975f.size(); i++) {
                Fragment fragment = (Fragment) this.f975f.get(i);
                if (fragment != null && fragment.f744K) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.f745L = true;
                    fragment.f769t = fragment.f768s != null ? fragment.f768s.f765p : -1;
                    if (f969a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    Parcelable m1561h() {
        BackStackState[] backStackStateArr = null;
        m1556e();
        if (f970b) {
            this.f988t = true;
        }
        if (this.f975f == null || this.f975f.size() <= 0) {
            return null;
        }
        int size = this.f975f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f975f.get(i);
            if (fragment != null) {
                if (fragment.f765p < 0) {
                    m1508a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f765p));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.f760k <= 0 || fragmentState.f788j != null) {
                    fragmentState.f788j = fragment.f763n;
                } else {
                    fragmentState.f788j = m1559g(fragment);
                    if (fragment.f768s != null) {
                        if (fragment.f768s.f765p < 0) {
                            m1508a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f768s));
                        }
                        if (fragmentState.f788j == null) {
                            fragmentState.f788j = new Bundle();
                        }
                        mo227a(fragmentState.f788j, "android:target_state", fragment.f768s);
                        if (fragment.f770u != 0) {
                            fragmentState.f788j.putInt("android:target_req_state", fragment.f770u);
                        }
                    }
                }
                if (f969a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f788j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.f976g != null) {
                i = this.f976g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.f976g.get(i2)).f765p;
                        if (iArr[i2] < 0) {
                            m1508a(new IllegalStateException("Failure saving state: active " + this.f976g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f969a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f976g.get(i2));
                        }
                    }
                    if (this.f978i != null) {
                        i = this.f978i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState((C0251i) this.f978i.get(i2));
                                if (f969a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f978i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.f776a = fragmentStateArr;
                    fragmentManagerState.f777b = iArr;
                    fragmentManagerState.f778c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.f978i != null) {
                i = this.f978i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((C0251i) this.f978i.get(i2));
                        if (f969a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f978i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f776a = fragmentStateArr;
            fragmentManagerState.f777b = iArr;
            fragmentManagerState.f778c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f969a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public void m1562i() {
        this.f988t = false;
    }

    public void m1563j() {
        this.f988t = false;
        m1526a(1, false);
    }

    public void m1564k() {
        this.f988t = false;
        m1526a(2, false);
    }

    public void m1565l() {
        this.f988t = false;
        m1526a(4, false);
    }

    public void m1566m() {
        this.f988t = false;
        m1526a(5, false);
    }

    public void m1567n() {
        m1526a(4, false);
    }

    public void m1568o() {
        this.f988t = true;
        m1526a(3, false);
    }

    public void m1569p() {
        m1526a(2, false);
    }

    public void m1570q() {
        m1526a(1, false);
    }

    public void m1571r() {
        this.f989u = true;
        m1556e();
        m1526a(0, false);
        this.f984o = null;
        this.f985p = null;
        this.f986q = null;
    }

    public void m1572s() {
        if (this.f976g != null) {
            for (int i = 0; i < this.f976g.size(); i++) {
                Fragment fragment = (Fragment) this.f976g.get(i);
                if (fragment != null) {
                    fragment.m1147I();
                }
            }
        }
    }

    C0271m m1573t() {
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f986q != null) {
            C0372c.m1911a(this.f986q, stringBuilder);
        } else {
            C0372c.m1911a(this.f984o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
