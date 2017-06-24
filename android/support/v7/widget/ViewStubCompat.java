package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.p019b.C0694a.C0693k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private int f2351a;
    private int f2352b;
    private WeakReference<View> f2353c;
    private LayoutInflater f2354d;
    private C0820a f2355e;

    public interface C0820a {
        void m4826a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2351a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0693k.ViewStubCompat, i, 0);
        this.f2352b = obtainStyledAttributes.getResourceId(C0693k.ViewStubCompat_android_inflatedId, -1);
        this.f2351a = obtainStyledAttributes.getResourceId(C0693k.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0693k.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View m4827a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f2351a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            View inflate = (this.f2354d != null ? this.f2354d : LayoutInflater.from(getContext())).inflate(this.f2351a, viewGroup, false);
            if (this.f2352b != -1) {
                inflate.setId(this.f2352b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f2353c = new WeakReference(inflate);
            if (this.f2355e != null) {
                this.f2355e.m4826a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f2352b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f2354d;
    }

    public int getLayoutResource() {
        return this.f2351a;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f2352b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f2354d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f2351a = i;
    }

    public void setOnInflateListener(C0820a c0820a) {
        this.f2355e = c0820a;
    }

    public void setVisibility(int i) {
        if (this.f2353c != null) {
            View view = (View) this.f2353c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m4827a();
        }
    }
}
