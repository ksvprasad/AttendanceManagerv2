package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.design.C0048a.C0046h;
import android.support.design.C0048a.C0047i;
import android.support.v4.p004c.p005a.C0314a;
import android.support.v4.p006e.C0056d;
import android.support.v4.p006e.C0341c;
import android.support.v4.p010b.C0195a;
import android.support.v4.view.C0081y;
import android.support.v4.view.C0507e;
import android.support.v4.view.C0543s;
import android.support.v4.view.C0548z;
import android.support.v4.view.aa;
import android.support.v4.view.ag;
import android.support.v4.view.bd;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements C0081y {
    static final String f350a;
    static final Class<?>[] f351b = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<C0059b>>> f352c = new ThreadLocal();
    static final Comparator<View> f353e;
    static final C0136e f354f;
    private final C0548z f355A;
    final Comparator<View> f356d;
    private final List<View> f357g;
    private final List<View> f358h;
    private final List<View> f359i;
    private final Rect f360j;
    private final Rect f361k;
    private final Rect f362l;
    private final int[] f363m;
    private Paint f364n;
    private boolean f365o;
    private boolean f366p;
    private int[] f367q;
    private View f368r;
    private View f369s;
    private View f370t;
    private C0079f f371u;
    private boolean f372v;
    private bd f373w;
    private boolean f374x;
    private Drawable f375y;
    private OnHierarchyChangeListener f376z;

    public static abstract class C0059b<V extends View> {
        public C0059b(Context context, AttributeSet attributeSet) {
        }

        public bd m348a(CoordinatorLayout coordinatorLayout, V v, bd bdVar) {
            return bdVar;
        }

        public void mo49a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public void mo50a(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void mo51a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        public void mo52a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public boolean mo42a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean mo54a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean mo43a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean mo74a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public boolean mo55a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean mo56a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public Parcelable mo59b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        public void m360b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean mo44b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean mo65b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public int m363c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public boolean mo66c(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public float m365d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public void mo85d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean m367e(CoordinatorLayout coordinatorLayout, V v) {
            return m365d(coordinatorLayout, v) > 0.0f;
        }
    }

    class C00731 implements Comparator<View> {
        final /* synthetic */ CoordinatorLayout f332a;

        C00731(CoordinatorLayout coordinatorLayout) {
            this.f332a = coordinatorLayout;
        }

        public int m542a(View view, View view2) {
            return view == view2 ? 0 : ((C0078e) view.getLayoutParams()).m557a(this.f332a, view, view2) ? 1 : ((C0078e) view2.getLayoutParams()).m557a(this.f332a, view2, view) ? -1 : 0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m542a((View) obj, (View) obj2);
        }
    }

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = C0341c.m1829a(new C00741());
        SparseArray<Parcelable> f333a;

        static class C00741 implements C0056d<SavedState> {
            C00741() {
            }

            public SavedState m543a(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] m544a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object mo40b(Parcel parcel, ClassLoader classLoader) {
                return m543a(parcel, classLoader);
            }

            public /* synthetic */ Object[] mo41b(int i) {
                return m544a(i);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f333a = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f333a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.f333a != null ? this.f333a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.f333a.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.f333a.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    private class C0075a implements aa {
        final /* synthetic */ CoordinatorLayout f334a;

        private C0075a(CoordinatorLayout coordinatorLayout) {
            this.f334a = coordinatorLayout;
        }

        public bd mo38a(View view, bd bdVar) {
            return this.f334a.m574a(bdVar);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface C0076c {
        Class<? extends C0059b> m548a();
    }

    private class C0077d implements OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout f335a;

        private C0077d(CoordinatorLayout coordinatorLayout) {
            this.f335a = coordinatorLayout;
        }

        public void onChildViewAdded(View view, View view2) {
            if (this.f335a.f376z != null) {
                this.f335a.f376z.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            this.f335a.m601b(view2);
            if (this.f335a.f376z != null) {
                this.f335a.f376z.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class C0078e extends MarginLayoutParams {
        C0059b f336a;
        boolean f337b = false;
        public int f338c = 0;
        public int f339d = 0;
        public int f340e = -1;
        int f341f = -1;
        View f342g;
        View f343h;
        final Rect f344i = new Rect();
        Object f345j;
        private boolean f346k;
        private boolean f347l;
        private boolean f348m;

        public C0078e(int i, int i2) {
            super(i, i2);
        }

        C0078e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0047i.CoordinatorLayout_LayoutParams);
            this.f338c = obtainStyledAttributes.getInteger(C0047i.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
            this.f341f = obtainStyledAttributes.getResourceId(C0047i.CoordinatorLayout_LayoutParams_layout_anchor, -1);
            this.f339d = obtainStyledAttributes.getInteger(C0047i.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
            this.f340e = obtainStyledAttributes.getInteger(C0047i.CoordinatorLayout_LayoutParams_layout_keyline, -1);
            this.f337b = obtainStyledAttributes.hasValue(C0047i.CoordinatorLayout_LayoutParams_layout_behavior);
            if (this.f337b) {
                this.f336a = CoordinatorLayout.m572a(context, attributeSet, obtainStyledAttributes.getString(C0047i.CoordinatorLayout_LayoutParams_layout_behavior));
            }
            obtainStyledAttributes.recycle();
        }

        public C0078e(C0078e c0078e) {
            super(c0078e);
        }

        public C0078e(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0078e(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        private void m549a(View view, CoordinatorLayout coordinatorLayout) {
            this.f342g = coordinatorLayout.findViewById(this.f341f);
            if (this.f342g != null) {
                if (this.f342g != coordinatorLayout) {
                    View view2 = this.f342g;
                    View parent = this.f342g.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.f343h = null;
                            this.f342g = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f343h = view2;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f343h = null;
                    this.f342g = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f343h = null;
                this.f342g = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f341f) + " to anchor view " + view);
            }
        }

        private boolean m550b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f342g.getId() != this.f341f) {
                return false;
            }
            View view2 = this.f342g;
            View parent = this.f342g.getParent();
            while (parent != coordinatorLayout) {
                if (parent == null || parent == view) {
                    this.f343h = null;
                    this.f342g = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
                parent = parent.getParent();
            }
            this.f343h = view2;
            return true;
        }

        public int m551a() {
            return this.f341f;
        }

        public void m552a(int i) {
            m569k();
            this.f341f = i;
        }

        void m553a(Rect rect) {
            this.f344i.set(rect);
        }

        public void m554a(C0059b c0059b) {
            if (this.f336a != c0059b) {
                this.f336a = c0059b;
                this.f345j = null;
                this.f337b = true;
            }
        }

        void m555a(boolean z) {
            this.f347l = z;
        }

        boolean m556a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f346k) {
                return true;
            }
            boolean e = (this.f336a != null ? this.f336a.m367e(coordinatorLayout, view) : 0) | this.f346k;
            this.f346k = e;
            return e;
        }

        boolean m557a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.f343h || (this.f336a != null && this.f336a.mo65b(coordinatorLayout, view, view2));
        }

        public C0059b m558b() {
            return this.f336a;
        }

        View m559b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f341f == -1) {
                this.f343h = null;
                this.f342g = null;
                return null;
            }
            if (this.f342g == null || !m550b(view, coordinatorLayout)) {
                m549a(view, coordinatorLayout);
            }
            return this.f342g;
        }

        void m560b(boolean z) {
            this.f348m = z;
        }

        Rect m561c() {
            return this.f344i;
        }

        boolean m562d() {
            return this.f342g == null && this.f341f != -1;
        }

        boolean m563e() {
            if (this.f336a == null) {
                this.f346k = false;
            }
            return this.f346k;
        }

        void m564f() {
            this.f346k = false;
        }

        void m565g() {
            this.f347l = false;
        }

        boolean m566h() {
            return this.f347l;
        }

        boolean m567i() {
            return this.f348m;
        }

        void m568j() {
            this.f348m = false;
        }

        void m569k() {
            this.f343h = null;
            this.f342g = null;
        }
    }

    class C0079f implements OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout f349a;

        C0079f(CoordinatorLayout coordinatorLayout) {
            this.f349a = coordinatorLayout;
        }

        public boolean onPreDraw() {
            this.f349a.m597a(false);
            return true;
        }
    }

    static class C0080g implements Comparator<View> {
        C0080g() {
        }

        public int m570a(View view, View view2) {
            float B = ag.m2504B(view);
            float B2 = ag.m2504B(view2);
            return B > B2 ? -1 : B < B2 ? 1 : 0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m570a((View) obj, (View) obj2);
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        f350a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            f353e = new C0080g();
            f354f = new C0137f();
        } else {
            f353e = null;
            f354f = null;
        }
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.f356d = new C00731(this);
        this.f357g = new ArrayList();
        this.f358h = new ArrayList();
        this.f359i = new ArrayList();
        this.f360j = new Rect();
        this.f361k = new Rect();
        this.f362l = new Rect();
        this.f363m = new int[2];
        this.f355A = new C0548z(this);
        C0164u.m1053a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0047i.CoordinatorLayout, i, C0046h.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(C0047i.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f367q = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f367q.length;
            while (i2 < length) {
                int[] iArr = this.f367q;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
                i2++;
            }
        }
        this.f375y = obtainStyledAttributes.getDrawable(C0047i.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        if (f354f != null) {
            f354f.mo118a(this, new C0075a());
        }
        super.setOnHierarchyChangeListener(new C0077d());
    }

    private int m571a(int i) {
        if (this.f367q == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.f367q.length) {
            return this.f367q[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    static C0059b m572a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f350a)) {
            str = f350a + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) f352c.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                f352c.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(f351b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (C0059b) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private bd m574a(bd bdVar) {
        boolean z = true;
        if (this.f373w == bdVar) {
            return bdVar;
        }
        this.f373w = bdVar;
        boolean z2 = bdVar != null && bdVar.mo443b() > 0;
        this.f374x = z2;
        if (this.f374x || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        bdVar = m581b(bdVar);
        requestLayout();
        return bdVar;
    }

    private void m576a(View view, View view2, int i) {
        C0078e c0078e = (C0078e) view.getLayoutParams();
        Rect rect = this.f360j;
        Rect rect2 = this.f361k;
        m595a(view2, rect);
        m594a(view, i, rect, rect2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void m577a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        if (f353e != null) {
            Collections.sort(list, f353e);
        }
    }

    private static void m578a(List<View> list, Comparator<View> comparator) {
        if (list != null && list.size() >= 2) {
            int i;
            View[] viewArr = new View[list.size()];
            list.toArray(viewArr);
            for (int i2 = 0; i2 < r5; i2++) {
                i = i2;
                for (int i3 = i2 + 1; i3 < r5; i3++) {
                    if (comparator.compare(viewArr[i3], viewArr[i]) < 0) {
                        i = i3;
                    }
                }
                if (i2 != i) {
                    View view = viewArr[i];
                    viewArr[i] = viewArr[i2];
                    viewArr[i2] = view;
                }
            }
            list.clear();
            for (Object add : viewArr) {
                list.add(add);
            }
        }
    }

    private boolean m579a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        MotionEvent motionEvent2 = null;
        int a = C0543s.m2893a(motionEvent);
        List list = this.f358h;
        m577a(list);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i2);
            C0078e c0078e = (C0078e) view.getLayoutParams();
            C0059b b = c0078e.m558b();
            if ((!z2 && obj == null) || a == 0) {
                if (!(z2 || b == null)) {
                    switch (i) {
                        case 0:
                            z2 = b.mo43a(this, view, motionEvent);
                            break;
                        case 1:
                            z2 = b.mo44b(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.f368r = view;
                    }
                }
                z = z2;
                boolean e = c0078e.m563e();
                boolean a2 = c0078e.m556a(this, view);
                Object obj3 = (!a2 || e) ? null : 1;
                if (a2 && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (b != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        b.mo43a(this, view, motionEvent3);
                        break;
                    case 1:
                        b.mo44b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i2++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    private static int m580b(int i) {
        return i == 0 ? 8388659 : i;
    }

    private bd m581b(bd bdVar) {
        if (bdVar.mo446e()) {
            return bdVar;
        }
        bd a;
        int childCount = getChildCount();
        int i = 0;
        bd bdVar2 = bdVar;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (ag.m2552t(childAt)) {
                C0059b b = ((C0078e) childAt.getLayoutParams()).m558b();
                if (b != null) {
                    a = b.m348a(this, childAt, bdVar2);
                    if (a.mo446e()) {
                        break;
                    }
                    i++;
                    bdVar2 = a;
                }
            }
            a = bdVar2;
            i++;
            bdVar2 = a;
        }
        a = bdVar2;
        return a;
    }

    private void m582b(View view, int i, int i2) {
        C0078e c0078e = (C0078e) view.getLayoutParams();
        int a = C0507e.m2796a(m583c(c0078e.f338c), i2);
        int i3 = a & 7;
        int i4 = a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int a2 = m571a(i) - measuredWidth;
        a = 0;
        switch (i3) {
            case 1:
                a2 += measuredWidth / 2;
                break;
            case 5:
                a2 += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                a = 0 + (measuredHeight / 2);
                break;
            case 80:
                a = 0 + measuredHeight;
                break;
        }
        a2 = Math.max(getPaddingLeft() + c0078e.leftMargin, Math.min(a2, ((width - getPaddingRight()) - measuredWidth) - c0078e.rightMargin));
        int max = Math.max(getPaddingTop() + c0078e.topMargin, Math.min(a, ((height - getPaddingBottom()) - measuredHeight) - c0078e.bottomMargin));
        view.layout(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    private static int m583c(int i) {
        return i == 0 ? 8388661 : i;
    }

    private void m584c(View view, int i) {
        C0078e c0078e = (C0078e) view.getLayoutParams();
        Rect rect = this.f360j;
        rect.set(getPaddingLeft() + c0078e.leftMargin, getPaddingTop() + c0078e.topMargin, (getWidth() - getPaddingRight()) - c0078e.rightMargin, (getHeight() - getPaddingBottom()) - c0078e.bottomMargin);
        if (!(this.f373w == null || !ag.m2552t(this) || ag.m2552t(view))) {
            rect.left += this.f373w.mo441a();
            rect.top += this.f373w.mo443b();
            rect.right -= this.f373w.mo444c();
            rect.bottom -= this.f373w.mo445d();
        }
        Rect rect2 = this.f361k;
        C0507e.m2797a(m580b(c0078e.f338c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private static int m585d(int i) {
        return i == 0 ? 17 : i;
    }

    private void m586e() {
        if (this.f368r != null) {
            C0059b b = ((C0078e) this.f368r.getLayoutParams()).m558b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                b.mo44b(this, this.f368r, obtain);
                obtain.recycle();
            }
            this.f368r = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((C0078e) getChildAt(i).getLayoutParams()).m564f();
        }
        this.f365o = false;
    }

    private void m587f() {
        this.f357g.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            m589a(childAt).m559b(this, childAt);
            this.f357g.add(childAt);
        }
        m578a(this.f357g, this.f356d);
    }

    public C0078e m588a(AttributeSet attributeSet) {
        return new C0078e(getContext(), attributeSet);
    }

    C0078e m589a(View view) {
        C0078e c0078e = (C0078e) view.getLayoutParams();
        if (!c0078e.f337b) {
            C0076c c0076c = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                c0076c = (C0076c) cls.getAnnotation(C0076c.class);
                if (c0076c != null) {
                    break;
                }
            }
            C0076c c0076c2 = c0076c;
            if (c0076c2 != null) {
                try {
                    c0078e.m554a((C0059b) c0076c2.m548a().newInstance());
                } catch (Throwable e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + c0076c2.m548a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            c0078e.f337b = true;
        }
        return c0078e;
    }

    protected C0078e m590a(LayoutParams layoutParams) {
        return layoutParams instanceof C0078e ? new C0078e((C0078e) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0078e((MarginLayoutParams) layoutParams) : new C0078e(layoutParams);
    }

    void m591a() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m609e(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.f372v) {
            return;
        }
        if (z) {
            m600b();
        } else {
            m604c();
        }
    }

    public void m592a(View view, int i) {
        C0078e c0078e = (C0078e) view.getLayoutParams();
        if (c0078e.m562d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (c0078e.f342g != null) {
            m576a(view, c0078e.f342g, i);
        } else if (c0078e.f340e >= 0) {
            m582b(view, c0078e.f340e, i);
        } else {
            m584c(view, i);
        }
    }

    public void m593a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    void m594a(View view, int i, Rect rect, Rect rect2) {
        C0078e c0078e = (C0078e) view.getLayoutParams();
        int a = C0507e.m2796a(m585d(c0078e.f338c), i);
        int a2 = C0507e.m2796a(m580b(c0078e.f339d), i);
        int i2 = a & 7;
        int i3 = a & 112;
        a = a2 & 7;
        int i4 = a2 & 112;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        switch (a) {
            case 1:
                a2 = (rect.width() / 2) + rect.left;
                break;
            case 5:
                a2 = rect.right;
                break;
            default:
                a2 = rect.left;
                break;
        }
        switch (i4) {
            case 16:
                a = rect.top + (rect.height() / 2);
                break;
            case 80:
                a = rect.bottom;
                break;
            default:
                a = rect.top;
                break;
        }
        switch (i2) {
            case 1:
                a2 -= measuredWidth / 2;
                break;
            case 5:
                break;
            default:
                a2 -= measuredWidth;
                break;
        }
        switch (i3) {
            case 16:
                a -= measuredHeight / 2;
                break;
            case 80:
                break;
            default:
                a -= measuredHeight;
                break;
        }
        i2 = getWidth();
        i3 = getHeight();
        a2 = Math.max(getPaddingLeft() + c0078e.leftMargin, Math.min(a2, ((i2 - getPaddingRight()) - measuredWidth) - c0078e.rightMargin));
        int max = Math.max(getPaddingTop() + c0078e.topMargin, Math.min(a, ((i3 - getPaddingBottom()) - measuredHeight) - c0078e.bottomMargin));
        rect2.set(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    void m595a(View view, Rect rect) {
        C0180y.m1120b(this, view, rect);
    }

    void m596a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        } else if (z) {
            m595a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    void m597a(boolean z) {
        int h = ag.m2540h(this);
        int size = this.f357g.size();
        for (int i = 0; i < size; i++) {
            int i2;
            View view = (View) this.f357g.get(i);
            C0078e c0078e = (C0078e) view.getLayoutParams();
            for (i2 = 0; i2 < i; i2++) {
                if (c0078e.f343h == ((View) this.f357g.get(i2))) {
                    m602b(view, h);
                }
            }
            Rect rect = this.f360j;
            Rect rect2 = this.f361k;
            m606c(view, rect);
            m596a(view, true, rect2);
            if (!rect.equals(rect2)) {
                m603b(view, rect2);
                for (i2 = i + 1; i2 < size; i2++) {
                    View view2 = (View) this.f357g.get(i2);
                    C0078e c0078e2 = (C0078e) view2.getLayoutParams();
                    C0059b b = c0078e2.m558b();
                    if (b != null && b.mo65b(this, view2, view)) {
                        if (z || !c0078e2.m567i()) {
                            boolean c = b.mo66c(this, view2, view);
                            if (z) {
                                c0078e2.m560b(c);
                            }
                        } else {
                            c0078e2.m568j();
                        }
                    }
                }
            }
        }
    }

    public boolean m598a(View view, int i, int i2) {
        Rect rect = this.f360j;
        m595a(view, rect);
        return rect.contains(i, i2);
    }

    public boolean m599a(View view, View view2) {
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect rect = this.f360j;
        m596a(view, view.getParent() != this, rect);
        Rect rect2 = this.f361k;
        m596a(view2, view2.getParent() != this, rect2);
        return rect.left <= rect2.right && rect.top <= rect2.bottom && rect.right >= rect2.left && rect.bottom >= rect2.top;
    }

    void m600b() {
        if (this.f366p) {
            if (this.f371u == null) {
                this.f371u = new C0079f(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f371u);
        }
        this.f372v = true;
    }

    void m601b(View view) {
        int size = this.f357g.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            View view2 = (View) this.f357g.get(i);
            if (view2 == view) {
                obj2 = 1;
            } else {
                if (obj != null) {
                    C0078e c0078e = (C0078e) view2.getLayoutParams();
                    C0059b b = c0078e.m558b();
                    if (b != null && c0078e.m557a(this, view2, view)) {
                        b.mo85d(this, view2, view);
                    }
                }
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
    }

    void m602b(View view, int i) {
        C0078e c0078e = (C0078e) view.getLayoutParams();
        if (c0078e.f342g != null) {
            Rect rect = this.f360j;
            Rect rect2 = this.f361k;
            Rect rect3 = this.f362l;
            m595a(c0078e.f342g, rect);
            m596a(view, false, rect2);
            m594a(view, i, rect, rect3);
            int i2 = rect3.left - rect2.left;
            int i3 = rect3.top - rect2.top;
            if (i2 != 0) {
                view.offsetLeftAndRight(i2);
            }
            if (i3 != 0) {
                view.offsetTopAndBottom(i3);
            }
            if (i2 != 0 || i3 != 0) {
                C0059b b = c0078e.m558b();
                if (b != null) {
                    b.mo66c(this, view, c0078e.f342g);
                }
            }
        }
    }

    void m603b(View view, Rect rect) {
        ((C0078e) view.getLayoutParams()).m553a(rect);
    }

    void m604c() {
        if (this.f366p && this.f371u != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f371u);
        }
        this.f372v = false;
    }

    public void m605c(View view) {
        int size = this.f357g.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            View view2 = (View) this.f357g.get(i);
            if (view2 == view) {
                obj2 = 1;
            } else {
                if (obj != null) {
                    C0078e c0078e = (C0078e) view2.getLayoutParams();
                    C0059b b = c0078e.m558b();
                    if (b != null && c0078e.m557a(this, view2, view)) {
                        b.mo66c(this, view2, view);
                    }
                }
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
    }

    void m606c(View view, Rect rect) {
        rect.set(((C0078e) view.getLayoutParams()).m561c());
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0078e) && super.checkLayoutParams(layoutParams);
    }

    protected C0078e m607d() {
        return new C0078e(-2, -2);
    }

    public List<View> m608d(View view) {
        C0078e c0078e = (C0078e) view.getLayoutParams();
        List<View> list = this.f359i;
        list.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && c0078e.m557a(this, view, childAt)) {
                list.add(childAt);
            }
        }
        return list;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        C0078e c0078e = (C0078e) view.getLayoutParams();
        if (c0078e.f336a != null && c0078e.f336a.m365d(this, view) > 0.0f) {
            if (this.f364n == null) {
                this.f364n = new Paint();
            }
            this.f364n.setColor(c0078e.f336a.m363c(this, view));
            canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f364n);
        }
        return super.drawChild(canvas, view, j);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.f375y;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    boolean m609e(View view) {
        C0078e c0078e = (C0078e) view.getLayoutParams();
        if (c0078e.f342g != null) {
            return true;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && c0078e.m557a(this, view, childAt)) {
                return true;
            }
        }
        return false;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m607d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m588a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m590a(layoutParams);
    }

    public int getNestedScrollAxes() {
        return this.f355A.m2918a();
    }

    public Drawable getStatusBarBackground() {
        return this.f375y;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m586e();
        if (this.f372v) {
            if (this.f371u == null) {
                this.f371u = new C0079f(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f371u);
        }
        if (this.f373w == null && ag.m2552t(this)) {
            ag.m2551s(this);
        }
        this.f366p = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m586e();
        if (this.f372v && this.f371u != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f371u);
        }
        if (this.f370t != null) {
            onStopNestedScroll(this.f370t);
        }
        this.f366p = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f374x && this.f375y != null) {
            int b = this.f373w != null ? this.f373w.mo443b() : 0;
            if (b > 0) {
                this.f375y.setBounds(0, 0, getWidth(), b);
                this.f375y.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int a = C0543s.m2893a(motionEvent);
        if (a == 0) {
            m586e();
        }
        boolean a2 = m579a(motionEvent, 0);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (a == 1 || a == 3) {
            m586e();
        }
        return a2;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int h = ag.m2540h(this);
        int size = this.f357g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.f357g.get(i5);
            C0059b b = ((C0078e) view.getLayoutParams()).m558b();
            if (b == null || !b.mo42a(this, view, h)) {
                m592a(view, h);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        m587f();
        m591a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int h = ag.m2540h(this);
        Object obj = h == 1 ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        paddingBottom = getSuggestedMinimumHeight();
        Object obj2 = (this.f373w == null || !ag.m2552t(this)) ? null : 1;
        int size3 = this.f357g.size();
        int i5 = 0;
        int i6 = 0;
        int i7 = paddingBottom;
        int i8 = suggestedMinimumWidth;
        while (i5 < size3) {
            int i9;
            View view = (View) this.f357g.get(i5);
            C0078e c0078e = (C0078e) view.getLayoutParams();
            int i10 = 0;
            if (c0078e.f340e >= 0 && mode != 0) {
                int a = m571a(c0078e.f340e);
                paddingTop = C0507e.m2796a(m583c(c0078e.f338c), h) & 7;
                if ((paddingTop == 3 && obj == null) || (paddingTop == 5 && obj != null)) {
                    i10 = Math.max(0, (size - paddingRight) - a);
                } else if ((paddingTop == 5 && obj == null) || (paddingTop == 3 && obj != null)) {
                    i10 = Math.max(0, a - paddingLeft);
                }
            }
            if (obj2 == null || ag.m2552t(view)) {
                i9 = i2;
                suggestedMinimumWidth = i;
            } else {
                paddingTop = this.f373w.mo443b() + this.f373w.mo445d();
                suggestedMinimumWidth = MeasureSpec.makeMeasureSpec(size - (this.f373w.mo441a() + this.f373w.mo444c()), mode);
                i9 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
            }
            C0059b b = c0078e.m558b();
            if (b == null || !b.mo54a(this, view, suggestedMinimumWidth, i10, i9, 0)) {
                m593a(view, suggestedMinimumWidth, i10, i9, 0);
            }
            i10 = Math.max(i8, ((view.getMeasuredWidth() + i3) + c0078e.leftMargin) + c0078e.rightMargin);
            suggestedMinimumWidth = Math.max(i7, ((view.getMeasuredHeight() + i4) + c0078e.topMargin) + c0078e.bottomMargin);
            i5++;
            i6 = ag.m2507a(i6, ag.m2542j(view));
            i7 = suggestedMinimumWidth;
            i8 = i10;
        }
        setMeasuredDimension(ag.m2508a(i8, i, -16777216 & i6), ag.m2508a(i7, i2, i6 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            C0078e c0078e = (C0078e) childAt.getLayoutParams();
            if (c0078e.m566h()) {
                C0059b b = c0078e.m558b();
                a = b != null ? b.mo55a(this, childAt, view, f, f2, z) | z2 : z2;
            } else {
                a = z2;
            }
            i++;
            z2 = a;
        }
        if (z2) {
            m597a(true);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            C0078e c0078e = (C0078e) childAt.getLayoutParams();
            if (c0078e.m566h()) {
                C0059b b = c0078e.m558b();
                a = b != null ? b.mo74a(this, childAt, view, f, f2) | z : z;
            } else {
                a = z;
            }
            i++;
            z = a;
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            int max;
            int max2;
            Object obj2;
            View childAt = getChildAt(i5);
            C0078e c0078e = (C0078e) childAt.getLayoutParams();
            if (c0078e.m566h()) {
                C0059b b = c0078e.m558b();
                if (b != null) {
                    int[] iArr2 = this.f363m;
                    this.f363m[1] = 0;
                    iArr2[0] = 0;
                    b.mo52a(this, childAt, view, i, i2, this.f363m);
                    max = i > 0 ? Math.max(i3, this.f363m[0]) : Math.min(i3, this.f363m[0]);
                    max2 = i2 > 0 ? Math.max(i4, this.f363m[1]) : Math.min(i4, this.f363m[1]);
                    int i6 = 1;
                } else {
                    obj2 = obj;
                    max = i3;
                    max2 = i4;
                }
            } else {
                obj2 = obj;
                max = i3;
                max2 = i4;
            }
            i5++;
            i4 = max2;
            i3 = max;
            obj = obj2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            m597a(true);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Object obj = null;
        int i5 = 0;
        while (i5 < childCount) {
            Object obj2;
            View childAt = getChildAt(i5);
            C0078e c0078e = (C0078e) childAt.getLayoutParams();
            if (c0078e.m566h()) {
                C0059b b = c0078e.m558b();
                if (b != null) {
                    b.mo51a(this, childAt, view, i, i2, i3, i4);
                    obj2 = 1;
                } else {
                    obj2 = obj;
                }
            } else {
                obj2 = obj;
            }
            i5++;
            obj = obj2;
        }
        if (obj != null) {
            m597a(true);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f355A.m2920a(view, view2, i);
        this.f369s = view;
        this.f370t = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0078e c0078e = (C0078e) childAt.getLayoutParams();
            if (c0078e.m566h()) {
                C0059b b = c0078e.m558b();
                if (b != null) {
                    b.m360b(this, childAt, view, view2, i);
                }
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            SparseArray sparseArray = savedState.f333a;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                C0059b b = m589a(childAt).m558b();
                if (!(id == -1 || b == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        b.mo49a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0059b b = ((C0078e) childAt.getLayoutParams()).m558b();
            if (!(id == -1 || b == null)) {
                Parcelable b2 = b.mo59b(this, childAt);
                if (b2 != null) {
                    sparseArray.append(id, b2);
                }
            }
        }
        savedState.f333a = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            C0078e c0078e = (C0078e) childAt.getLayoutParams();
            C0059b b = c0078e.m558b();
            if (b != null) {
                boolean a = b.mo56a(this, childAt, view, view2, i);
                z2 = z | a;
                c0078e.m555a(a);
            } else {
                c0078e.m555a(false);
                z2 = z;
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public void onStopNestedScroll(View view) {
        this.f355A.m2919a(view);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0078e c0078e = (C0078e) childAt.getLayoutParams();
            if (c0078e.m566h()) {
                C0059b b = c0078e.m558b();
                if (b != null) {
                    b.mo50a(this, childAt, view);
                }
                c0078e.m565g();
                c0078e.m568j();
            }
        }
        this.f369s = null;
        this.f370t = null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        MotionEvent obtain;
        MotionEvent motionEvent2 = null;
        int a = C0543s.m2893a(motionEvent);
        if (this.f368r == null) {
            boolean a2 = m579a(motionEvent, 1);
            if (a2) {
                z = a2;
            } else {
                z = a2;
                z2 = false;
                if (this.f368r == null) {
                    z2 |= super.onTouchEvent(motionEvent);
                } else if (z) {
                    if (null != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    } else {
                        obtain = null;
                    }
                    super.onTouchEvent(obtain);
                    motionEvent2 = obtain;
                }
                if (!z2 || a == 0) {
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    if (a == 1 || a == 3) {
                        m586e();
                    }
                    return z2;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                m586e();
                return z2;
            }
        }
        z = false;
        C0059b b = ((C0078e) this.f368r.getLayoutParams()).m558b();
        z2 = b != null ? b.mo44b(this, this.f368r, motionEvent) : false;
        if (this.f368r == null) {
            z2 |= super.onTouchEvent(motionEvent);
        } else if (z) {
            if (null != null) {
                obtain = null;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                obtain = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            }
            super.onTouchEvent(obtain);
            motionEvent2 = obtain;
        }
        if (z2) {
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        m586e();
        return z2;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.f365o) {
            m586e();
            this.f365o = true;
        }
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f376z = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f375y != drawable) {
            if (this.f375y != null) {
                this.f375y.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f375y = drawable2;
            if (this.f375y != null) {
                if (this.f375y.isStateful()) {
                    this.f375y.setState(getDrawableState());
                }
                C0314a.m1771b(this.f375y, ag.m2540h(this));
                this.f375y.setVisible(getVisibility() == 0, false);
                this.f375y.setCallback(this);
            }
            ag.m2532d(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? C0195a.m1224a(getContext(), i) : null);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f375y != null && this.f375y.isVisible() != z) {
            this.f375y.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f375y;
    }
}
