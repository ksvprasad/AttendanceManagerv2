package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0048a.C0047i;
import android.support.design.widget.CoordinatorLayout.C0059b;
import android.support.v4.view.C0051w;
import android.support.v4.view.C0543s;
import android.support.v4.view.ae;
import android.support.v4.view.ag;
import android.support.v4.widget.ad;
import android.support.v4.widget.ad.C0064a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends C0059b<V> {
    private float f287a;
    private int f288b;
    private int f289c;
    private int f290d;
    private boolean f291e;
    private int f292f = 4;
    private ad f293g;
    private boolean f294h;
    private int f295i;
    private boolean f296j;
    private int f297k;
    private WeakReference<V> f298l;
    private WeakReference<View> f299m;
    private C0067a f300n;
    private VelocityTracker f301o;
    private int f302p;
    private int f303q;
    private boolean f304r;
    private final C0064a f305s = new C00651(this);

    class C00651 extends C0064a {
        final /* synthetic */ BottomSheetBehavior f282a;

        C00651(BottomSheetBehavior bottomSheetBehavior) {
            this.f282a = bottomSheetBehavior;
        }

        public int mo67a(View view) {
            return this.f282a.f291e ? this.f282a.f297k - this.f282a.f289c : this.f282a.f290d - this.f282a.f289c;
        }

        public int mo68a(View view, int i, int i2) {
            return C0152n.m1009a(i, this.f282a.f289c, this.f282a.f291e ? this.f282a.f297k : this.f282a.f290d);
        }

        public void mo69a(int i) {
            if (i == 1) {
                this.f282a.m497b(1);
            }
        }

        public void mo70a(View view, float f, float f2) {
            int f3;
            int i = 3;
            if (f2 < 0.0f) {
                f3 = this.f282a.f289c;
            } else if (this.f282a.f291e && this.f282a.m495a(view, f2)) {
                f3 = this.f282a.f297k;
                i = 5;
            } else if (f2 == 0.0f) {
                int top = view.getTop();
                if (Math.abs(top - this.f282a.f289c) < Math.abs(top - this.f282a.f290d)) {
                    f3 = this.f282a.f289c;
                } else {
                    f3 = this.f282a.f290d;
                    i = 4;
                }
            } else {
                f3 = this.f282a.f290d;
                i = 4;
            }
            if (this.f282a.f293g.m3030a(view.getLeft(), f3)) {
                this.f282a.m497b(2);
                ag.m2519a(view, new C0068b(this.f282a, view, i));
                return;
            }
            this.f282a.m497b(i);
        }

        public void mo71a(View view, int i, int i2, int i3, int i4) {
            this.f282a.m501c(i2);
        }

        public boolean mo72a(View view, int i) {
            if (this.f282a.f292f == 1 || this.f282a.f304r) {
                return false;
            }
            if (this.f282a.f292f == 3 && this.f282a.f302p == i) {
                View view2 = (View) this.f282a.f299m.get();
                if (view2 != null && ag.m2527b(view2, -1)) {
                    return false;
                }
            }
            boolean z = this.f282a.f298l != null && this.f282a.f298l.get() == view;
            return z;
        }

        public int mo73b(View view, int i, int i2) {
            return view.getLeft();
        }
    }

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C00661();
        final int f283a;

        static class C00661 implements Creator<SavedState> {
            C00661() {
            }

            public SavedState m486a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m487a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m486a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m487a(i);
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f283a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f283a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f283a);
        }
    }

    public static abstract class C0067a {
        public abstract void m488a(View view, float f);

        public abstract void m489a(View view, int i);
    }

    private class C0068b implements Runnable {
        final /* synthetic */ BottomSheetBehavior f284a;
        private final View f285b;
        private final int f286c;

        C0068b(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.f284a = bottomSheetBehavior;
            this.f285b = view;
            this.f286c = i;
        }

        public void run() {
            if (this.f284a.f293g == null || !this.f284a.f293g.m3033a(true)) {
                this.f284a.m497b(this.f286c);
            } else {
                ag.m2519a(this.f285b, (Runnable) this);
            }
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0047i.BottomSheetBehavior_Params);
        m509a(obtainStyledAttributes.getDimensionPixelSize(C0047i.BottomSheetBehavior_Params_behavior_peekHeight, 0));
        m513a(obtainStyledAttributes.getBoolean(C0047i.BottomSheetBehavior_Params_behavior_hideable, false));
        obtainStyledAttributes.recycle();
        this.f287a = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private View m491a(View view) {
        if (view instanceof C0051w) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View a = m491a(viewGroup.getChildAt(i));
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }

    private void m492a() {
        this.f302p = -1;
        if (this.f301o != null) {
            this.f301o.recycle();
            this.f301o = null;
        }
    }

    private boolean m495a(View view, float f) {
        return view.getTop() >= this.f290d && Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.f290d)) / ((float) this.f288b) > 0.5f;
    }

    private float m496b() {
        this.f301o.computeCurrentVelocity(1000, this.f287a);
        return ae.m2318b(this.f301o, this.f302p);
    }

    private void m497b(int i) {
        if (this.f292f != i) {
            this.f292f = i;
            View view = (View) this.f298l.get();
            if (view != null && this.f300n != null) {
                this.f300n.m489a(view, i);
            }
        }
    }

    private void m501c(int i) {
        View view = (View) this.f298l.get();
        if (view != null && this.f300n != null) {
            if (i > this.f290d) {
                this.f300n.m488a(view, ((float) (this.f290d - i)) / ((float) this.f288b));
            } else {
                this.f300n.m488a(view, ((float) (this.f290d - i)) / ((float) (this.f290d - this.f289c)));
            }
        }
    }

    public final void m509a(int i) {
        this.f288b = Math.max(0, i);
        this.f290d = this.f297k - i;
    }

    public void mo49a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.mo49a(coordinatorLayout, (View) v, savedState.getSuperState());
        if (savedState.f283a == 1 || savedState.f283a == 2) {
            this.f292f = 4;
        } else {
            this.f292f = savedState.f283a;
        }
    }

    public void mo50a(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.f289c) {
            m497b(3);
        } else if (view == this.f299m.get() && this.f296j) {
            int i2;
            if (this.f295i > 0) {
                i2 = this.f289c;
            } else if (this.f291e && m495a((View) v, m496b())) {
                i2 = this.f297k;
                i = 5;
            } else if (this.f295i == 0) {
                int top = v.getTop();
                if (Math.abs(top - this.f289c) < Math.abs(top - this.f290d)) {
                    i2 = this.f289c;
                } else {
                    i2 = this.f290d;
                    i = 4;
                }
            } else {
                i2 = this.f290d;
                i = 4;
            }
            if (this.f293g.m3032a((View) v, v.getLeft(), i2)) {
                m497b(2);
                ag.m2519a((View) v, new C0068b(this, v, i));
            } else {
                m497b(i);
            }
            this.f296j = false;
        }
    }

    public void mo52a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == ((View) this.f299m.get())) {
            int top = v.getTop();
            int i3 = top - i2;
            if (i2 > 0) {
                if (i3 < this.f289c) {
                    iArr[1] = top - this.f289c;
                    ag.m2536e(v, -iArr[1]);
                    m497b(3);
                } else {
                    iArr[1] = i2;
                    ag.m2536e(v, -i2);
                    m497b(1);
                }
            } else if (i2 < 0 && !ag.m2527b(view, -1)) {
                if (i3 <= this.f290d || this.f291e) {
                    iArr[1] = i2;
                    ag.m2536e(v, -i2);
                    m497b(1);
                } else {
                    iArr[1] = top - this.f290d;
                    ag.m2536e(v, -iArr[1]);
                    m497b(4);
                }
            }
            m501c(v.getTop());
            this.f295i = i2;
            this.f296j = true;
        }
    }

    public void m513a(boolean z) {
        this.f291e = z;
    }

    public boolean mo42a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (!(this.f292f == 1 || this.f292f == 2)) {
            if (ag.m2552t(coordinatorLayout) && !ag.m2552t(v)) {
                ag.m2521a((View) v, true);
            }
            coordinatorLayout.m592a((View) v, i);
        }
        this.f297k = coordinatorLayout.getHeight();
        this.f289c = Math.max(0, this.f297k - v.getHeight());
        this.f290d = Math.max(this.f297k - this.f288b, this.f289c);
        if (this.f292f == 3) {
            ag.m2536e(v, this.f289c);
        } else if (this.f291e && this.f292f == 5) {
            ag.m2536e(v, this.f297k);
        } else if (this.f292f == 4) {
            ag.m2536e(v, this.f290d);
        }
        if (this.f293g == null) {
            this.f293g = ad.m3011a((ViewGroup) coordinatorLayout, this.f305s);
        }
        this.f298l = new WeakReference(v);
        this.f299m = new WeakReference(m491a((View) v));
        return true;
    }

    public boolean mo43a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = true;
        if (!v.isShown()) {
            return false;
        }
        int a = C0543s.m2893a(motionEvent);
        if (a == 0) {
            m492a();
        }
        if (this.f301o == null) {
            this.f301o = VelocityTracker.obtain();
        }
        this.f301o.addMovement(motionEvent);
        switch (a) {
            case 0:
                int x = (int) motionEvent.getX();
                this.f303q = (int) motionEvent.getY();
                View view = (View) this.f299m.get();
                if (view != null && coordinatorLayout.m598a(view, x, this.f303q)) {
                    this.f302p = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f304r = true;
                }
                boolean z2 = this.f302p == -1 && !coordinatorLayout.m598a((View) v, x, this.f303q);
                this.f294h = z2;
                break;
            case 1:
            case 3:
                this.f304r = false;
                this.f302p = -1;
                if (this.f294h) {
                    this.f294h = false;
                    return false;
                }
                break;
        }
        if (!this.f294h && this.f293g.m3031a(motionEvent)) {
            return true;
        }
        view = (View) this.f299m.get();
        if (a != 2 || view == null || this.f294h || this.f292f == 1 || coordinatorLayout.m598a(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.f303q) - motionEvent.getY()) <= ((float) this.f293g.m3034b())) {
            z = false;
        }
        return z;
    }

    public boolean mo74a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.f299m.get() && (this.f292f != 3 || super.mo74a(coordinatorLayout, (View) v, view, f, f2));
    }

    public boolean mo56a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.f295i = 0;
        this.f296j = false;
        return (i & 2) != 0;
    }

    public Parcelable mo59b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.mo59b(coordinatorLayout, v), this.f292f);
    }

    public boolean mo44b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int a = C0543s.m2893a(motionEvent);
        if (this.f292f == 1 && a == 0) {
            return true;
        }
        this.f293g.m3036b(motionEvent);
        if (a == 0) {
            m492a();
        }
        if (this.f301o == null) {
            this.f301o = VelocityTracker.obtain();
        }
        this.f301o.addMovement(motionEvent);
        if (a == 2 && !this.f294h && Math.abs(((float) this.f303q) - motionEvent.getY()) > ((float) this.f293g.m3034b())) {
            this.f293g.m3028a((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f294h;
    }
}
