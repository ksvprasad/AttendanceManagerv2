package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p006e.C0056d;
import android.support.v4.p006e.C0341c;
import android.support.v4.view.p016a.C0413a;
import android.support.v4.view.p016a.C0426c;
import android.support.v4.view.p016a.C0450l;
import android.support.v4.widget.C0576h;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int[] f1172a = new int[]{16842931};
    private static final C0400j ai = new C0400j();
    private static final Comparator<C0393b> f1173c = new C03871();
    private static final Interpolator f1174d = new C03882();
    private int f1175A = 1;
    private boolean f1176B;
    private boolean f1177C;
    private int f1178D;
    private int f1179E;
    private int f1180F;
    private float f1181G;
    private float f1182H;
    private float f1183I;
    private float f1184J;
    private int f1185K = -1;
    private VelocityTracker f1186L;
    private int f1187M;
    private int f1188N;
    private int f1189O;
    private int f1190P;
    private boolean f1191Q;
    private C0576h f1192R;
    private C0576h f1193S;
    private boolean f1194T = true;
    private boolean f1195U = false;
    private boolean f1196V;
    private int f1197W;
    private List<C0115f> aa;
    private C0115f ab;
    private C0115f ac;
    private C0396e ad;
    private C0397g ae;
    private Method af;
    private int ag;
    private ArrayList<View> ah;
    private final Runnable aj = new C03893(this);
    private int ak = 0;
    private int f1198b;
    private final ArrayList<C0393b> f1199e = new ArrayList();
    private final C0393b f1200f = new C0393b();
    private final Rect f1201g = new Rect();
    private ab f1202h;
    private int f1203i;
    private int f1204j = -1;
    private Parcelable f1205k = null;
    private ClassLoader f1206l = null;
    private Scroller f1207m;
    private boolean f1208n;
    private C0398h f1209o;
    private int f1210p;
    private Drawable f1211q;
    private int f1212r;
    private int f1213s;
    private float f1214t = -3.4028235E38f;
    private float f1215u = Float.MAX_VALUE;
    private int f1216v;
    private int f1217w;
    private boolean f1218x;
    private boolean f1219y;
    private boolean f1220z;

    public interface C0115f {
        void mo107a(int i);

        void mo108a(int i, float f, int i2);

        void mo109b(int i);
    }

    static class C03871 implements Comparator<C0393b> {
        C03871() {
        }

        public int m1954a(C0393b c0393b, C0393b c0393b2) {
            return c0393b.f1160b - c0393b2.f1160b;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1954a((C0393b) obj, (C0393b) obj2);
        }
    }

    static class C03882 implements Interpolator {
        C03882() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class C03893 implements Runnable {
        final /* synthetic */ ViewPager f1153a;

        C03893(ViewPager viewPager) {
            this.f1153a = viewPager;
        }

        public void run() {
            this.f1153a.setScrollState(0);
            this.f1153a.m2012c();
        }
    }

    class C03904 implements aa {
        final /* synthetic */ ViewPager f1154a;
        private final Rect f1155b = new Rect();

        C03904(ViewPager viewPager) {
            this.f1154a = viewPager;
        }

        public bd mo38a(View view, bd bdVar) {
            bd a = ag.m2510a(view, bdVar);
            if (a.mo446e()) {
                return a;
            }
            Rect rect = this.f1155b;
            rect.left = a.mo441a();
            rect.top = a.mo443b();
            rect.right = a.mo444c();
            rect.bottom = a.mo445d();
            int childCount = this.f1154a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                bd b = ag.m2523b(this.f1154a.getChildAt(i), a);
                rect.left = Math.min(b.mo441a(), rect.left);
                rect.top = Math.min(b.mo443b(), rect.top);
                rect.right = Math.min(b.mo444c(), rect.right);
                rect.bottom = Math.min(b.mo445d(), rect.bottom);
            }
            return a.mo442a(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = C0341c.m1829a(new C03911());
        int f1156a;
        Parcelable f1157b;
        ClassLoader f1158c;

        static class C03911 implements C0056d<SavedState> {
            C03911() {
            }

            public SavedState m1956a(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] m1957a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object mo40b(Parcel parcel, ClassLoader classLoader) {
                return m1956a(parcel, classLoader);
            }

            public /* synthetic */ Object[] mo41b(int i) {
                return m1957a(i);
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f1156a = parcel.readInt();
            this.f1157b = parcel.readParcelable(classLoader);
            this.f1158c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1156a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1156a);
            parcel.writeParcelable(this.f1157b, i);
        }
    }

    interface C0392a {
    }

    static class C0393b {
        Object f1159a;
        int f1160b;
        boolean f1161c;
        float f1162d;
        float f1163e;

        C0393b() {
        }
    }

    public static class C0394c extends LayoutParams {
        public boolean f1164a;
        public int f1165b;
        float f1166c = 0.0f;
        boolean f1167d;
        int f1168e;
        int f1169f;

        public C0394c() {
            super(-1, -1);
        }

        public C0394c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f1172a);
            this.f1165b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    class C0395d extends C0124a {
        final /* synthetic */ ViewPager f1170a;

        C0395d(ViewPager viewPager) {
            this.f1170a = viewPager;
        }

        private boolean m1960b() {
            return this.f1170a.f1202h != null && this.f1170a.f1202h.mo879b() > 1;
        }

        public void mo113a(View view, C0426c c0426c) {
            super.mo113a(view, c0426c);
            c0426c.m2191a(ViewPager.class.getName());
            c0426c.m2193a(m1960b());
            if (this.f1170a.canScrollHorizontally(1)) {
                c0426c.m2188a(4096);
            }
            if (this.f1170a.canScrollHorizontally(-1)) {
                c0426c.m2188a(8192);
            }
        }

        public void mo114a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo114a(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            C0450l a = C0413a.m2088a(accessibilityEvent);
            a.m2296a(m1960b());
            if (accessibilityEvent.getEventType() == 4096 && this.f1170a.f1202h != null) {
                a.m2295a(this.f1170a.f1202h.mo879b());
                a.m2297b(this.f1170a.f1203i);
                a.m2298c(this.f1170a.f1203i);
            }
        }

        public boolean mo284a(View view, int i, Bundle bundle) {
            if (super.mo284a(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!this.f1170a.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.f1170a.setCurrentItem(this.f1170a.f1203i + 1);
                    return true;
                case 8192:
                    if (!this.f1170a.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.f1170a.setCurrentItem(this.f1170a.f1203i - 1);
                    return true;
                default:
                    return false;
            }
        }
    }

    interface C0396e {
        void m1964a(ab abVar, ab abVar2);
    }

    public interface C0397g {
        void mo1779a(View view, float f);
    }

    private class C0398h extends DataSetObserver {
        final /* synthetic */ ViewPager f1171a;

        private C0398h(ViewPager viewPager) {
            this.f1171a = viewPager;
        }

        public void onChanged() {
            this.f1171a.m2010b();
        }

        public void onInvalidated() {
            this.f1171a.m2010b();
        }
    }

    public static class C0399i implements C0115f {
        public void mo107a(int i) {
        }

        public void mo108a(int i, float f, int i2) {
        }

        public void mo109b(int i) {
        }
    }

    static class C0400j implements Comparator<View> {
        C0400j() {
        }

        public int m1969a(View view, View view2) {
            C0394c c0394c = (C0394c) view.getLayoutParams();
            C0394c c0394c2 = (C0394c) view2.getLayoutParams();
            return c0394c.f1164a != c0394c2.f1164a ? c0394c.f1164a ? 1 : -1 : c0394c.f1168e - c0394c2.f1168e;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1969a((View) obj, (View) obj2);
        }
    }

    public ViewPager(Context context) {
        super(context);
        m1997a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1997a();
    }

    private int m1970a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f1189O || Math.abs(i2) <= this.f1187M) {
            i = (int) ((i >= this.f1203i ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f1199e.size() <= 0) {
            return i;
        }
        return Math.max(((C0393b) this.f1199e.get(0)).f1160b, Math.min(i, ((C0393b) this.f1199e.get(this.f1199e.size() - 1)).f1160b));
    }

    private Rect m1971a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private void m1973a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f1199e.isEmpty()) {
            C0393b b = m2008b(this.f1203i);
            int min = (int) ((b != null ? Math.min(b.f1163e, this.f1215u) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m1978a(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.f1207m.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.f1207m.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    private void m1974a(int i, boolean z, int i2, boolean z2) {
        int max;
        C0393b b = m2008b(i);
        if (b != null) {
            max = (int) (Math.max(this.f1214t, Math.min(b.f1163e, this.f1215u)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m2000a(max, 0, i2);
            if (z2) {
                m1986e(i);
                return;
            }
            return;
        }
        if (z2) {
            m1986e(i);
        }
        m1978a(false);
        scrollTo(max, 0);
        m1985d(max);
    }

    private void m1975a(C0393b c0393b, int i, C0393b c0393b2) {
        float f;
        int i2;
        C0393b c0393b3;
        int i3;
        int b = this.f1202h.mo879b();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.f1210p) / ((float) clientWidth) : 0.0f;
        if (c0393b2 != null) {
            clientWidth = c0393b2.f1160b;
            int i4;
            if (clientWidth < c0393b.f1160b) {
                f = (c0393b2.f1163e + c0393b2.f1162d) + f2;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= c0393b.f1160b && i2 < this.f1199e.size()) {
                    c0393b3 = (C0393b) this.f1199e.get(i2);
                    while (i4 > c0393b3.f1160b && i2 < this.f1199e.size() - 1) {
                        i2++;
                        c0393b3 = (C0393b) this.f1199e.get(i2);
                    }
                    while (i4 < c0393b3.f1160b) {
                        f += this.f1202h.m1594d(i4) + f2;
                        i4++;
                    }
                    c0393b3.f1163e = f;
                    f += c0393b3.f1162d + f2;
                    i4++;
                }
            } else if (clientWidth > c0393b.f1160b) {
                i2 = this.f1199e.size() - 1;
                f = c0393b2.f1163e;
                i4 = clientWidth - 1;
                while (i4 >= c0393b.f1160b && i2 >= 0) {
                    c0393b3 = (C0393b) this.f1199e.get(i2);
                    while (i4 < c0393b3.f1160b && i2 > 0) {
                        i2--;
                        c0393b3 = (C0393b) this.f1199e.get(i2);
                    }
                    while (i4 > c0393b3.f1160b) {
                        f -= this.f1202h.m1594d(i4) + f2;
                        i4--;
                    }
                    f -= c0393b3.f1162d + f2;
                    c0393b3.f1163e = f;
                    i4--;
                }
            }
        }
        int size = this.f1199e.size();
        float f3 = c0393b.f1163e;
        i2 = c0393b.f1160b - 1;
        this.f1214t = c0393b.f1160b == 0 ? c0393b.f1163e : -3.4028235E38f;
        this.f1215u = c0393b.f1160b == b + -1 ? (c0393b.f1163e + c0393b.f1162d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            c0393b3 = (C0393b) this.f1199e.get(i3);
            f = f3;
            while (i2 > c0393b3.f1160b) {
                f -= this.f1202h.m1594d(i2) + f2;
                i2--;
            }
            f3 = f - (c0393b3.f1162d + f2);
            c0393b3.f1163e = f3;
            if (c0393b3.f1160b == 0) {
                this.f1214t = f3;
            }
            i2--;
        }
        f3 = (c0393b.f1163e + c0393b.f1162d) + f2;
        i2 = c0393b.f1160b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            c0393b3 = (C0393b) this.f1199e.get(i3);
            f = f3;
            while (i2 < c0393b3.f1160b) {
                f = (this.f1202h.m1594d(i2) + f2) + f;
                i2++;
            }
            if (c0393b3.f1160b == b - 1) {
                this.f1215u = (c0393b3.f1162d + f) - 1.0f;
            }
            c0393b3.f1163e = f;
            f3 = f + (c0393b3.f1162d + f2);
            i2++;
        }
        this.f1195U = false;
    }

    private void m1977a(MotionEvent motionEvent) {
        int b = C0543s.m2895b(motionEvent);
        if (C0543s.m2896b(motionEvent, b) == this.f1185K) {
            b = b == 0 ? 1 : 0;
            this.f1181G = C0543s.m2897c(motionEvent, b);
            this.f1185K = C0543s.m2896b(motionEvent, b);
            if (this.f1186L != null) {
                this.f1186L.clear();
            }
        }
    }

    private void m1978a(boolean z) {
        int scrollX;
        boolean z2 = this.ak == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f1207m.isFinished()) {
                this.f1207m.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f1207m.getCurrX();
                int currY = this.f1207m.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m1985d(currX);
                    }
                }
            }
        }
        this.f1220z = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.f1199e.size(); scrollX++) {
            C0393b c0393b = (C0393b) this.f1199e.get(scrollX);
            if (c0393b.f1161c) {
                c0393b.f1161c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            ag.m2519a((View) this, this.aj);
        } else {
            this.aj.run();
        }
    }

    private boolean m1979a(float f, float f2) {
        return (f < ((float) this.f1179E) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f1179E)) && f2 < 0.0f);
    }

    private void m1981b(int i, float f, int i2) {
        if (this.ab != null) {
            this.ab.mo108a(i, f, i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0115f c0115f = (C0115f) this.aa.get(i3);
                if (c0115f != null) {
                    c0115f.mo108a(i, f, i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.mo108a(i, f, i2);
        }
    }

    private void m1982b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ag.m2514a(getChildAt(i), z ? 2 : 0, null);
        }
    }

    private boolean m1983b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f1181G - f;
        this.f1181G = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f1214t;
        float f5 = ((float) clientWidth) * this.f1215u;
        C0393b c0393b = (C0393b) this.f1199e.get(0);
        C0393b c0393b2 = (C0393b) this.f1199e.get(this.f1199e.size() - 1);
        if (c0393b.f1160b != 0) {
            f4 = c0393b.f1163e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (c0393b2.f1160b != this.f1202h.mo879b() - 1) {
            f2 = c0393b2.f1163e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f1192R.m3104a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f1193S.m3104a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f1181G += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m1985d((int) f4);
        return z3;
    }

    private void m1984c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean m1985d(int i) {
        if (this.f1199e.size() != 0) {
            C0393b j = m1992j();
            int clientWidth = getClientWidth();
            int i2 = this.f1210p + clientWidth;
            float f = ((float) this.f1210p) / ((float) clientWidth);
            int i3 = j.f1160b;
            float f2 = ((((float) i) / ((float) clientWidth)) - j.f1163e) / (j.f1162d + f);
            clientWidth = (int) (((float) i2) * f2);
            this.f1196V = false;
            m1999a(i3, f2, clientWidth);
            if (this.f1196V) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.f1194T) {
            return false;
        } else {
            this.f1196V = false;
            m1999a(0, 0.0f, 0);
            if (this.f1196V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private void m1986e(int i) {
        if (this.ab != null) {
            this.ab.mo109b(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0115f c0115f = (C0115f) this.aa.get(i2);
                if (c0115f != null) {
                    c0115f.mo109b(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.mo109b(i);
        }
    }

    private void m1987f(int i) {
        if (this.ab != null) {
            this.ab.mo107a(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0115f c0115f = (C0115f) this.aa.get(i2);
                if (c0115f != null) {
                    c0115f.mo107a(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.mo107a(i);
        }
    }

    private void m1989g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0394c) getChildAt(i).getLayoutParams()).f1164a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void m1990h() {
        if (this.ag != 0) {
            if (this.ah == null) {
                this.ah = new ArrayList();
            } else {
                this.ah.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ah.add(getChildAt(i));
            }
            Collections.sort(this.ah, ai);
        }
    }

    private boolean m1991i() {
        this.f1185K = -1;
        m1993k();
        return this.f1192R.m3109c() | this.f1193S.m3109c();
    }

    private C0393b m1992j() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.f1210p) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        C0393b c0393b = null;
        while (i2 < this.f1199e.size()) {
            int i3;
            C0393b c0393b2;
            C0393b c0393b3 = (C0393b) this.f1199e.get(i2);
            C0393b c0393b4;
            if (obj != null || c0393b3.f1160b == i + 1) {
                c0393b4 = c0393b3;
                i3 = i2;
                c0393b2 = c0393b4;
            } else {
                c0393b3 = this.f1200f;
                c0393b3.f1163e = (f2 + f3) + f;
                c0393b3.f1160b = i + 1;
                c0393b3.f1162d = this.f1202h.m1594d(c0393b3.f1160b);
                c0393b4 = c0393b3;
                i3 = i2 - 1;
                c0393b2 = c0393b4;
            }
            f2 = c0393b2.f1163e;
            f3 = (c0393b2.f1162d + f2) + f;
            if (obj == null && scrollX < f2) {
                return c0393b;
            }
            if (scrollX < f3 || i3 == this.f1199e.size() - 1) {
                return c0393b2;
            }
            f3 = f2;
            i = c0393b2.f1160b;
            obj = null;
            f2 = c0393b2.f1162d;
            c0393b = c0393b2;
            i2 = i3 + 1;
        }
        return c0393b;
    }

    private void m1993k() {
        this.f1176B = false;
        this.f1177C = false;
        if (this.f1186L != null) {
            this.f1186L.recycle();
            this.f1186L = null;
        }
    }

    private void setScrollState(int i) {
        if (this.ak != i) {
            this.ak = i;
            if (this.ae != null) {
                m1982b(i != 0);
            }
            m1987f(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f1219y != z) {
            this.f1219y = z;
        }
    }

    float m1994a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    C0393b m1995a(int i, int i2) {
        C0393b c0393b = new C0393b();
        c0393b.f1160b = i;
        c0393b.f1159a = this.f1202h.mo232a((ViewGroup) this, i);
        c0393b.f1162d = this.f1202h.m1594d(i);
        if (i2 < 0 || i2 >= this.f1199e.size()) {
            this.f1199e.add(c0393b);
        } else {
            this.f1199e.add(i2, c0393b);
        }
        return c0393b;
    }

    C0393b m1996a(View view) {
        for (int i = 0; i < this.f1199e.size(); i++) {
            C0393b c0393b = (C0393b) this.f1199e.get(i);
            if (this.f1202h.mo236a(view, c0393b.f1159a)) {
                return c0393b;
            }
        }
        return null;
    }

    void m1997a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f1207m = new Scroller(context, f1174d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1180F = ar.m2640a(viewConfiguration);
        this.f1187M = (int) (400.0f * f);
        this.f1188N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1192R = new C0576h(context);
        this.f1193S = new C0576h(context);
        this.f1189O = (int) (25.0f * f);
        this.f1190P = (int) (2.0f * f);
        this.f1178D = (int) (16.0f * f);
        ag.m2517a((View) this, new C0395d(this));
        if (ag.m2535e(this) == 0) {
            ag.m2529c((View) this, 1);
        }
        ag.m2518a((View) this, new C03904(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1998a(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.f1203i;
        r0 = r18;
        if (r3 == r0) goto L_0x0323;
    L_0x0009:
        r0 = r17;
        r2 = r0.f1203i;
        r0 = r17;
        r2 = r0.m2008b(r2);
        r0 = r18;
        r1 = r17;
        r1.f1203i = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.f1202h;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.m1990h();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.f1220z;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.m1990h();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.f1202h;
        r0 = r17;
        r2.mo234a(r0);
        r0 = r17;
        r2 = r0.f1175A;
        r4 = 0;
        r0 = r17;
        r5 = r0.f1203i;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.f1202h;
        r11 = r4.mo879b();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.f1203i;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.f1198b;
        if (r11 == r2) goto L_0x00cb;
    L_0x0064:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00c1 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00c1 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c1 }
    L_0x0070:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r17;
        r5 = r0.f1198b;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.f1202h;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c1:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0070;
    L_0x00cb:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00ce:
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x0320;
    L_0x00d8:
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0393b) r2;
        r6 = r2.f1160b;
        r0 = r17;
        r7 = r0.f1203i;
        if (r6 < r7) goto L_0x01bc;
    L_0x00ea:
        r6 = r2.f1160b;
        r0 = r17;
        r7 = r0.f1203i;
        if (r6 != r7) goto L_0x0320;
    L_0x00f2:
        if (r2 != 0) goto L_0x031d;
    L_0x00f4:
        if (r11 <= 0) goto L_0x031d;
    L_0x00f6:
        r0 = r17;
        r2 = r0.f1203i;
        r0 = r17;
        r2 = r0.m1995a(r2, r4);
        r9 = r2;
    L_0x0101:
        if (r9 == 0) goto L_0x016d;
    L_0x0103:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x01c1;
    L_0x0108:
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.C0393b) r2;
    L_0x0112:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x01c4;
    L_0x0118:
        r5 = 0;
    L_0x0119:
        r0 = r17;
        r6 = r0.f1203i;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x0127:
        if (r8 < 0) goto L_0x0131;
    L_0x0129:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x0203;
    L_0x012d:
        if (r8 >= r10) goto L_0x0203;
    L_0x012f:
        if (r2 != 0) goto L_0x01d3;
    L_0x0131:
        r5 = r9.f1162d;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0168;
    L_0x013b:
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0239;
    L_0x0145:
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.C0393b) r2;
        r6 = r2;
    L_0x0150:
        if (r13 > 0) goto L_0x023c;
    L_0x0152:
        r2 = 0;
        r4 = r2;
    L_0x0154:
        r0 = r17;
        r2 = r0.f1203i;
        r2 = r2 + 1;
        r15 = r2;
        r2 = r6;
        r6 = r8;
        r8 = r15;
    L_0x015e:
        if (r8 >= r11) goto L_0x0168;
    L_0x0160:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0283;
    L_0x0164:
        if (r8 <= r12) goto L_0x0283;
    L_0x0166:
        if (r2 != 0) goto L_0x0249;
    L_0x0168:
        r0 = r17;
        r0.m1975a(r9, r7, r3);
    L_0x016d:
        r0 = r17;
        r3 = r0.f1202h;
        r0 = r17;
        r4 = r0.f1203i;
        if (r9 == 0) goto L_0x02cd;
    L_0x0177:
        r2 = r9.f1159a;
    L_0x0179:
        r0 = r17;
        r3.mo238b(r0, r4, r2);
        r0 = r17;
        r2 = r0.f1202h;
        r0 = r17;
        r2.mo237b(r0);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x018d:
        if (r3 >= r4) goto L_0x02d0;
    L_0x018f:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.C0394c) r2;
        r2.f1169f = r3;
        r6 = r2.f1164a;
        if (r6 != 0) goto L_0x01b8;
    L_0x01a1:
        r6 = r2.f1166c;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x01b8;
    L_0x01a8:
        r0 = r17;
        r5 = r0.m1996a(r5);
        if (r5 == 0) goto L_0x01b8;
    L_0x01b0:
        r6 = r5.f1162d;
        r2.f1166c = r6;
        r5 = r5.f1160b;
        r2.f1168e = r5;
    L_0x01b8:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x018d;
    L_0x01bc:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00ce;
    L_0x01c1:
        r2 = 0;
        goto L_0x0112;
    L_0x01c4:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.f1162d;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0119;
    L_0x01d3:
        r14 = r2.f1160b;
        if (r8 != r14) goto L_0x01fd;
    L_0x01d7:
        r14 = r2.f1161c;
        if (r14 != 0) goto L_0x01fd;
    L_0x01db:
        r0 = r17;
        r14 = r0.f1199e;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.f1202h;
        r2 = r2.f1159a;
        r0 = r17;
        r14.mo235a(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x0201;
    L_0x01f3:
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0393b) r2;
    L_0x01fd:
        r8 = r8 + -1;
        goto L_0x0127;
    L_0x0201:
        r2 = 0;
        goto L_0x01fd;
    L_0x0203:
        if (r2 == 0) goto L_0x021d;
    L_0x0205:
        r14 = r2.f1160b;
        if (r8 != r14) goto L_0x021d;
    L_0x0209:
        r2 = r2.f1162d;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x021b;
    L_0x0210:
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0393b) r2;
        goto L_0x01fd;
    L_0x021b:
        r2 = 0;
        goto L_0x01fd;
    L_0x021d:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.m1995a(r8, r2);
        r2 = r2.f1162d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x0237;
    L_0x022c:
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0393b) r2;
        goto L_0x01fd;
    L_0x0237:
        r2 = 0;
        goto L_0x01fd;
    L_0x0239:
        r6 = 0;
        goto L_0x0150;
    L_0x023c:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x0154;
    L_0x0249:
        r10 = r2.f1160b;
        if (r8 != r10) goto L_0x0318;
    L_0x024d:
        r10 = r2.f1161c;
        if (r10 != 0) goto L_0x0318;
    L_0x0251:
        r0 = r17;
        r10 = r0.f1199e;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.f1202h;
        r2 = r2.f1159a;
        r0 = r17;
        r10.mo235a(r0, r8, r2);
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0281;
    L_0x026d:
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0393b) r2;
    L_0x0277:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x027a:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x015e;
    L_0x0281:
        r2 = 0;
        goto L_0x0277;
    L_0x0283:
        if (r2 == 0) goto L_0x02a8;
    L_0x0285:
        r10 = r2.f1160b;
        if (r8 != r10) goto L_0x02a8;
    L_0x0289:
        r2 = r2.f1162d;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02a6;
    L_0x0298:
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0393b) r2;
    L_0x02a2:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02a6:
        r2 = 0;
        goto L_0x02a2;
    L_0x02a8:
        r0 = r17;
        r2 = r0.m1995a(r8, r6);
        r6 = r6 + 1;
        r2 = r2.f1162d;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02cb;
    L_0x02bd:
        r0 = r17;
        r2 = r0.f1199e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0393b) r2;
    L_0x02c7:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02cb:
        r2 = 0;
        goto L_0x02c7;
    L_0x02cd:
        r2 = 0;
        goto L_0x0179;
    L_0x02d0:
        r17.m1990h();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02d9:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x0316;
    L_0x02df:
        r0 = r17;
        r2 = r0.m2009b(r2);
    L_0x02e5:
        if (r2 == 0) goto L_0x02ef;
    L_0x02e7:
        r2 = r2.f1160b;
        r0 = r17;
        r3 = r0.f1203i;
        if (r2 == r3) goto L_0x0023;
    L_0x02ef:
        r2 = 0;
    L_0x02f0:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02f6:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.m1996a(r3);
        if (r4 == 0) goto L_0x0313;
    L_0x0304:
        r4 = r4.f1160b;
        r0 = r17;
        r5 = r0.f1203i;
        if (r4 != r5) goto L_0x0313;
    L_0x030c:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x0313:
        r2 = r2 + 1;
        goto L_0x02f0;
    L_0x0316:
        r2 = 0;
        goto L_0x02e5;
    L_0x0318:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x031d:
        r9 = r2;
        goto L_0x0101;
    L_0x0320:
        r2 = r5;
        goto L_0x00f2;
    L_0x0323:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    protected void m1999a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.f1197W > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                C0394c c0394c = (C0394c) childAt.getLayoutParams();
                if (c0394c.f1164a) {
                    int max;
                    switch (c0394c.f1165b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        m1981b(i, f, i2);
        if (this.ae != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((C0394c) childAt2.getLayoutParams()).f1164a) {
                    this.ae.mo1779a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.f1196V = true;
    }

    void m2000a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int i4;
        boolean z = (this.f1207m == null || this.f1207m.isFinished()) ? false : true;
        if (z) {
            int currX = this.f1208n ? this.f1207m.getCurrX() : this.f1207m.getStartX();
            this.f1207m.abortAnimation();
            setScrollingCacheEnabled(false);
            i4 = currX;
        } else {
            i4 = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m1978a(false);
            m2012c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        currX = getClientWidth();
        int i7 = currX / 2;
        float a = (((float) i7) * m1994a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) currX)))) + ((float) i7);
        int abs = Math.abs(i3);
        i7 = Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4 : (int) (((((float) Math.abs(i5)) / ((((float) currX) * this.f1202h.m1594d(this.f1203i)) + ((float) this.f1210p))) + 1.0f) * 100.0f), 600);
        this.f1208n = false;
        this.f1207m.startScroll(i4, scrollY, i5, i6, i7);
        ag.m2532d(this);
    }

    public void m2001a(int i, boolean z) {
        this.f1220z = false;
        m2002a(i, z, false);
    }

    void m2002a(int i, boolean z, boolean z2) {
        m2003a(i, z, z2, 0);
    }

    void m2003a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f1202h == null || this.f1202h.mo879b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f1203i != i || this.f1199e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f1202h.mo879b()) {
                i = this.f1202h.mo879b() - 1;
            }
            int i3 = this.f1175A;
            if (i > this.f1203i + i3 || i < this.f1203i - i3) {
                for (int i4 = 0; i4 < this.f1199e.size(); i4++) {
                    ((C0393b) this.f1199e.get(i4)).f1161c = true;
                }
            }
            if (this.f1203i != i) {
                z3 = true;
            }
            if (this.f1194T) {
                this.f1203i = i;
                if (z3) {
                    m1986e(i);
                }
                requestLayout();
                return;
            }
            m1998a(i);
            m1974a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void m2004a(C0115f c0115f) {
        if (this.aa == null) {
            this.aa = new ArrayList();
        }
        this.aa.add(c0115f);
    }

    public void m2005a(boolean z, C0397g c0397g) {
        int i = 1;
        if (VERSION.SDK_INT >= 11) {
            boolean z2 = c0397g != null;
            int i2 = z2 != (this.ae != null) ? 1 : 0;
            this.ae = c0397g;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                if (z) {
                    i = 2;
                }
                this.ag = i;
            } else {
                this.ag = 0;
            }
            if (i2 != 0) {
                m2012c();
            }
        }
    }

    public boolean m2006a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return m2013c(17);
            case 22:
                return m2013c(66);
            case 61:
                return VERSION.SDK_INT >= 11 ? C0513g.m2809a(keyEvent) ? m2013c(2) : C0513g.m2810a(keyEvent, 1) ? m2013c(1) : false : false;
            default:
                return false;
        }
    }

    protected boolean m2007a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m2007a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && ag.m2522a(view, -i);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C0393b a = m1996a(childAt);
                    if (a != null && a.f1160b == this.f1203i) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0393b a = m1996a(childAt);
                if (a != null && a.f1160b == this.f1203i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        C0394c c0394c = (C0394c) generateLayoutParams;
        c0394c.f1164a |= view instanceof C0392a;
        if (!this.f1218x) {
            super.addView(view, i, generateLayoutParams);
        } else if (c0394c == null || !c0394c.f1164a) {
            c0394c.f1167d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    C0393b m2008b(int i) {
        for (int i2 = 0; i2 < this.f1199e.size(); i2++) {
            C0393b c0393b = (C0393b) this.f1199e.get(i2);
            if (c0393b.f1160b == i) {
                return c0393b;
            }
        }
        return null;
    }

    C0393b m2009b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return m1996a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    void m2010b() {
        int b = this.f1202h.mo879b();
        this.f1198b = b;
        boolean z = this.f1199e.size() < (this.f1175A * 2) + 1 && this.f1199e.size() < b;
        boolean z2 = false;
        int i = this.f1203i;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.f1199e.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            C0393b c0393b = (C0393b) this.f1199e.get(i2);
            int a = this.f1202h.mo1780a(c0393b.f1159a);
            if (a == -1) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (a == -2) {
                this.f1199e.remove(i2);
                i2--;
                if (!z2) {
                    this.f1202h.mo234a((ViewGroup) this);
                    z2 = true;
                }
                this.f1202h.mo235a((ViewGroup) this, c0393b.f1160b, c0393b.f1159a);
                if (this.f1203i == c0393b.f1160b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.f1203i, b - 1));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (c0393b.f1160b != a) {
                if (c0393b.f1160b == this.f1203i) {
                    i = a;
                }
                c0393b.f1160b = a;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.f1202h.mo237b((ViewGroup) this);
        }
        Collections.sort(this.f1199e, f1173c);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                C0394c c0394c = (C0394c) getChildAt(i2).getLayoutParams();
                if (!c0394c.f1164a) {
                    c0394c.f1166c = 0.0f;
                }
            }
            m2002a(i, false, true);
            requestLayout();
        }
    }

    public void m2011b(C0115f c0115f) {
        if (this.aa != null) {
            this.aa.remove(c0115f);
        }
    }

    void m2012c() {
        m1998a(this.f1203i);
    }

    public boolean m2013c(int i) {
        View view;
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                d = m2014d();
            } else {
                if (i == 66 || i == 2) {
                    d = m2015e();
                }
                d = false;
            }
        } else if (i == 17) {
            d = (view == null || m1971a(this.f1201g, findNextFocus).left < m1971a(this.f1201g, view).left) ? findNextFocus.requestFocus() : m2014d();
        } else {
            if (i == 66) {
                d = (view == null || m1971a(this.f1201g, findNextFocus).left > m1971a(this.f1201g, view).left) ? findNextFocus.requestFocus() : m2015e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f1202h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f1214t))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f1215u))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0394c) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.f1208n = true;
        if (this.f1207m.isFinished() || !this.f1207m.computeScrollOffset()) {
            m1978a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f1207m.getCurrX();
        int currY = this.f1207m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m1985d(currX)) {
                this.f1207m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ag.m2532d(this);
    }

    boolean m2014d() {
        if (this.f1203i <= 0) {
            return false;
        }
        m2001a(this.f1203i - 1, true);
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2006a(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0393b a = m1996a(childAt);
                if (a != null && a.f1160b == this.f1203i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ag.m2509a(this);
        if (a == 0 || (a == 1 && this.f1202h != null && this.f1202h.mo879b() > 1)) {
            int height;
            int width;
            if (!this.f1192R.m3103a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f1214t * ((float) width));
                this.f1192R.m3102a(height, width);
                i = 0 | this.f1192R.m3107a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.f1193S.m3103a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f1215u + 1.0f)) * ((float) height));
                this.f1193S.m3102a(width, height);
                i |= this.f1193S.m3107a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f1192R.m3108b();
            this.f1193S.m3108b();
        }
        if (i != 0) {
            ag.m2532d(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1211q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    boolean m2015e() {
        if (this.f1202h == null || this.f1203i >= this.f1202h.mo879b() - 1) {
            return false;
        }
        m2001a(this.f1203i + 1, true);
        return true;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0394c();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0394c(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public ab getAdapter() {
        return this.f1202h;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ag == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C0394c) ((View) this.ah.get(i2)).getLayoutParams()).f1169f;
    }

    public int getCurrentItem() {
        return this.f1203i;
    }

    public int getOffscreenPageLimit() {
        return this.f1175A;
    }

    public int getPageMargin() {
        return this.f1210p;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1194T = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.aj);
        if (!(this.f1207m == null || this.f1207m.isFinished())) {
            this.f1207m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1210p > 0 && this.f1211q != null && this.f1199e.size() > 0 && this.f1202h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f1210p) / ((float) width);
            C0393b c0393b = (C0393b) this.f1199e.get(0);
            float f2 = c0393b.f1163e;
            int size = this.f1199e.size();
            int i = c0393b.f1160b;
            int i2 = ((C0393b) this.f1199e.get(size - 1)).f1160b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > c0393b.f1160b && i3 < size) {
                    i3++;
                    c0393b = (C0393b) this.f1199e.get(i3);
                }
                if (i4 == c0393b.f1160b) {
                    f3 = (c0393b.f1163e + c0393b.f1162d) * ((float) width);
                    f2 = (c0393b.f1163e + c0393b.f1162d) + f;
                } else {
                    float d = this.f1202h.m1594d(i4);
                    f3 = (f2 + d) * ((float) width);
                    f2 += d + f;
                }
                if (((float) this.f1210p) + f3 > ((float) scrollX)) {
                    this.f1211q.setBounds(Math.round(f3), this.f1212r, Math.round(((float) this.f1210p) + f3), this.f1213s);
                    this.f1211q.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m1991i();
            return false;
        }
        if (action != 0) {
            if (this.f1176B) {
                return true;
            }
            if (this.f1177C) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f1183I = x;
                this.f1181G = x;
                x = motionEvent.getY();
                this.f1184J = x;
                this.f1182H = x;
                this.f1185K = C0543s.m2896b(motionEvent, 0);
                this.f1177C = false;
                this.f1208n = true;
                this.f1207m.computeScrollOffset();
                if (this.ak == 2 && Math.abs(this.f1207m.getFinalX() - this.f1207m.getCurrX()) > this.f1190P) {
                    this.f1207m.abortAnimation();
                    this.f1220z = false;
                    m2012c();
                    this.f1176B = true;
                    m1984c(true);
                    setScrollState(1);
                    break;
                }
                m1978a(false);
                this.f1176B = false;
                break;
            case 2:
                action = this.f1185K;
                if (action != -1) {
                    action = C0543s.m2894a(motionEvent, action);
                    float c = C0543s.m2897c(motionEvent, action);
                    float f = c - this.f1181G;
                    float abs = Math.abs(f);
                    float d = C0543s.m2899d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f1184J);
                    if (f == 0.0f || m1979a(this.f1181G, f) || !m2007a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.f1180F) && 0.5f * abs > abs2) {
                            this.f1176B = true;
                            m1984c(true);
                            setScrollState(1);
                            this.f1181G = f > 0.0f ? this.f1183I + ((float) this.f1180F) : this.f1183I - ((float) this.f1180F);
                            this.f1182H = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f1180F)) {
                            this.f1177C = true;
                        }
                        if (this.f1176B && m1983b(c)) {
                            ag.m2532d(this);
                            break;
                        }
                    }
                    this.f1181G = c;
                    this.f1182H = d;
                    this.f1177C = true;
                    return false;
                }
                break;
            case 6:
                m1977a(motionEvent);
                break;
        }
        if (this.f1186L == null) {
            this.f1186L = VelocityTracker.obtain();
        }
        this.f1186L.addMovement(motionEvent);
        return this.f1176B;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0394c c0394c;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                c0394c = (C0394c) childAt.getLayoutParams();
                if (c0394c.f1164a) {
                    int i9 = c0394c.f1165b & 112;
                    switch (c0394c.f1165b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                c0394c = (C0394c) childAt2.getLayoutParams();
                if (!c0394c.f1164a) {
                    C0393b a = m1996a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f1163e * ((float) max))) + paddingLeft;
                        if (c0394c.f1167d) {
                            c0394c.f1167d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0394c.f1166c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f1212r = paddingTop;
        this.f1213s = i6 - paddingBottom;
        this.f1197W = i7;
        if (this.f1194T) {
            m1974a(this.f1203i, false, 0, false);
        }
        this.f1194T = false;
    }

    protected void onMeasure(int i, int i2) {
        C0394c c0394c;
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f1179E = Math.min(measuredWidth / 10, this.f1178D);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                c0394c = (C0394c) childAt.getLayoutParams();
                if (c0394c != null && c0394c.f1164a) {
                    int i6 = c0394c.f1165b & 7;
                    int i7 = c0394c.f1165b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (c0394c.width != -2) {
                        i7 = 1073741824;
                        i3 = c0394c.width != -1 ? c0394c.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (c0394c.height != -2) {
                        i5 = 1073741824;
                        if (c0394c.height != -1) {
                            measuredWidth = c0394c.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f1216v = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f1217w = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f1218x = true;
        m2012c();
        this.f1218x = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                c0394c = (C0394c) childAt2.getLayoutParams();
                if (c0394c == null || !c0394c.f1164a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0394c.f1166c * ((float) paddingLeft)), 1073741824), this.f1217w);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                C0393b a = m1996a(childAt);
                if (a != null && a.f1160b == this.f1203i && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.f1202h != null) {
                this.f1202h.mo233a(savedState.f1157b, savedState.f1158c);
                m2002a(savedState.f1156a, false, true);
                return;
            }
            this.f1204j = savedState.f1156a;
            this.f1205k = savedState.f1157b;
            this.f1206l = savedState.f1158c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1156a = this.f1203i;
        if (this.f1202h != null) {
            savedState.f1157b = this.f1202h.mo231a();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m1973a(i, i3, this.f1210p, this.f1210p);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f1191Q) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f1202h == null || this.f1202h.mo879b() == 0) {
            return false;
        }
        if (this.f1186L == null) {
            this.f1186L = VelocityTracker.obtain();
        }
        this.f1186L.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f1207m.abortAnimation();
                this.f1220z = false;
                m2012c();
                x = motionEvent.getX();
                this.f1183I = x;
                this.f1181G = x;
                x = motionEvent.getY();
                this.f1184J = x;
                this.f1182H = x;
                this.f1185K = C0543s.m2896b(motionEvent, 0);
                break;
            case 1:
                if (this.f1176B) {
                    VelocityTracker velocityTracker = this.f1186L;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1188N);
                    a = (int) ae.m2317a(velocityTracker, this.f1185K);
                    this.f1220z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C0393b j = m1992j();
                    m2003a(m1970a(j.f1160b, ((((float) scrollX) / ((float) clientWidth)) - j.f1163e) / (j.f1162d + (((float) this.f1210p) / ((float) clientWidth))), a, (int) (C0543s.m2897c(motionEvent, C0543s.m2894a(motionEvent, this.f1185K)) - this.f1183I)), true, true, a);
                    z = m1991i();
                    break;
                }
                break;
            case 2:
                if (!this.f1176B) {
                    a = C0543s.m2894a(motionEvent, this.f1185K);
                    if (a == -1) {
                        z = m1991i();
                        break;
                    }
                    float c = C0543s.m2897c(motionEvent, a);
                    float abs = Math.abs(c - this.f1181G);
                    float d = C0543s.m2899d(motionEvent, a);
                    x = Math.abs(d - this.f1182H);
                    if (abs > ((float) this.f1180F) && abs > x) {
                        this.f1176B = true;
                        m1984c(true);
                        this.f1181G = c - this.f1183I > 0.0f ? this.f1183I + ((float) this.f1180F) : this.f1183I - ((float) this.f1180F);
                        this.f1182H = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f1176B) {
                    z = false | m1983b(C0543s.m2897c(motionEvent, C0543s.m2894a(motionEvent, this.f1185K)));
                    break;
                }
                break;
            case 3:
                if (this.f1176B) {
                    m1974a(this.f1203i, true, 0, false);
                    z = m1991i();
                    break;
                }
                break;
            case 5:
                a = C0543s.m2895b(motionEvent);
                this.f1181G = C0543s.m2897c(motionEvent, a);
                this.f1185K = C0543s.m2896b(motionEvent, a);
                break;
            case 6:
                m1977a(motionEvent);
                this.f1181G = C0543s.m2897c(motionEvent, C0543s.m2894a(motionEvent, this.f1185K));
                break;
        }
        if (z) {
            ag.m2532d(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.f1218x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(ab abVar) {
        if (this.f1202h != null) {
            this.f1202h.m1593c(null);
            this.f1202h.mo234a((ViewGroup) this);
            for (int i = 0; i < this.f1199e.size(); i++) {
                C0393b c0393b = (C0393b) this.f1199e.get(i);
                this.f1202h.mo235a((ViewGroup) this, c0393b.f1160b, c0393b.f1159a);
            }
            this.f1202h.mo237b((ViewGroup) this);
            this.f1199e.clear();
            m1989g();
            this.f1203i = 0;
            scrollTo(0, 0);
        }
        ab abVar2 = this.f1202h;
        this.f1202h = abVar;
        this.f1198b = 0;
        if (this.f1202h != null) {
            if (this.f1209o == null) {
                this.f1209o = new C0398h();
            }
            this.f1202h.m1593c(this.f1209o);
            this.f1220z = false;
            boolean z = this.f1194T;
            this.f1194T = true;
            this.f1198b = this.f1202h.mo879b();
            if (this.f1204j >= 0) {
                this.f1202h.mo233a(this.f1205k, this.f1206l);
                m2002a(this.f1204j, false, true);
                this.f1204j = -1;
                this.f1205k = null;
                this.f1206l = null;
            } else if (z) {
                requestLayout();
            } else {
                m2012c();
            }
        }
        if (this.ad != null && abVar2 != abVar) {
            this.ad.m1964a(abVar2, abVar);
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.af == null) {
                try {
                    this.af = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.af.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f1220z = false;
        m2002a(i, !this.f1194T, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f1175A) {
            this.f1175A = i;
            m2012c();
        }
    }

    void setOnAdapterChangeListener(C0396e c0396e) {
        this.ad = c0396e;
    }

    @Deprecated
    public void setOnPageChangeListener(C0115f c0115f) {
        this.ab = c0115f;
    }

    public void setPageMargin(int i) {
        int i2 = this.f1210p;
        this.f1210p = i;
        int width = getWidth();
        m1973a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f1211q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1211q;
    }
}
