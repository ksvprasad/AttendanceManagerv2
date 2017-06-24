package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.C0048a.C0039a;
import android.support.design.C0048a.C0042d;
import android.support.design.C0048a.C0043e;
import android.support.design.C0048a.C0044f;
import android.support.design.C0048a.C0047i;
import android.support.design.widget.C0157q.C0090a;
import android.support.design.widget.CoordinatorLayout.C0059b;
import android.support.design.widget.CoordinatorLayout.C0078e;
import android.support.design.widget.SwipeDismissBehavior.C0092a;
import android.support.v4.view.ag;
import android.support.v4.view.bb;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class Snackbar {
    private static final Handler f425a = new Handler(Looper.getMainLooper(), new C00881());
    private final ViewGroup f426b;
    private final Context f427c;
    private final SnackbarLayout f428d;
    private int f429e;
    private C0103b f430f;
    private final AccessibilityManager f431g;
    private final C0090a f432h = new C00913(this);

    static class C00881 implements Callback {
        C00881() {
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((Snackbar) message.obj).m727c();
                    return true;
                case 1:
                    ((Snackbar) message.obj).m725b(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    }

    class C00913 implements C0090a {
        final /* synthetic */ Snackbar f399a;

        C00913(Snackbar snackbar) {
            this.f399a = snackbar;
        }

        public void mo91a() {
            Snackbar.f425a.sendMessage(Snackbar.f425a.obtainMessage(0, this.f399a));
        }

        public void mo92a(int i) {
            Snackbar.f425a.sendMessage(Snackbar.f425a.obtainMessage(1, i, 0, this.f399a));
        }
    }

    class C00934 implements C0092a {
        final /* synthetic */ Snackbar f400a;

        C00934(Snackbar snackbar) {
            this.f400a = snackbar;
        }

        public void mo93a(int i) {
            switch (i) {
                case 0:
                    C0157q.m1028a().m1041d(this.f400a.f432h);
                    return;
                case 1:
                case 2:
                    C0157q.m1028a().m1040c(this.f400a.f432h);
                    return;
                default:
                    return;
            }
        }

        public void mo94a(View view) {
            view.setVisibility(8);
            this.f400a.m712c(0);
        }
    }

    class C00965 implements C0095a {
        final /* synthetic */ Snackbar f402a;

        class C00941 implements Runnable {
            final /* synthetic */ C00965 f401a;

            C00941(C00965 c00965) {
                this.f401a = c00965;
            }

            public void run() {
                this.f401a.f402a.m718e(3);
            }
        }

        C00965(Snackbar snackbar) {
            this.f402a = snackbar;
        }

        public void mo95a(View view) {
        }

        public void mo96b(View view) {
            if (this.f402a.m726b()) {
                Snackbar.f425a.post(new C00941(this));
            }
        }
    }

    class C00986 implements C0097b {
        final /* synthetic */ Snackbar f403a;

        C00986(Snackbar snackbar) {
            this.f403a = snackbar;
        }

        public void mo97a(View view, int i, int i2, int i3, int i4) {
            this.f403a.f428d.setOnLayoutChangeListener(null);
            if (this.f403a.m721g()) {
                this.f403a.m717e();
            } else {
                this.f403a.m720f();
            }
        }
    }

    class C00997 extends bb {
        final /* synthetic */ Snackbar f404a;

        C00997(Snackbar snackbar) {
            this.f404a = snackbar;
        }

        public void mo98a(View view) {
            this.f404a.f428d.m680a(70, 180);
        }

        public void mo99b(View view) {
            this.f404a.m720f();
        }
    }

    class C01008 implements AnimationListener {
        final /* synthetic */ Snackbar f405a;

        C01008(Snackbar snackbar) {
            this.f405a = snackbar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f405a.m720f();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static class SnackbarLayout extends LinearLayout {
        private TextView f408a;
        private Button f409b;
        private int f410c;
        private int f411d;
        private C0097b f412e;
        private C0095a f413f;

        interface C0095a {
            void mo95a(View view);

            void mo96b(View view);
        }

        interface C0097b {
            void mo97a(View view, int i, int i2, int i3, int i4);
        }

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0047i.SnackbarLayout);
            this.f410c = obtainStyledAttributes.getDimensionPixelSize(C0047i.SnackbarLayout_android_maxWidth, -1);
            this.f411d = obtainStyledAttributes.getDimensionPixelSize(C0047i.SnackbarLayout_maxActionInlineWidth, -1);
            if (obtainStyledAttributes.hasValue(C0047i.SnackbarLayout_elevation)) {
                ag.m2533d((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(C0047i.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(C0044f.design_layout_snackbar_include, this);
            ag.m2534d((View) this, 1);
            ag.m2529c((View) this, 1);
        }

        private static void m678a(View view, int i, int i2) {
            if (ag.m2555w(view)) {
                ag.m2513a(view, ag.m2543k(view), i, ag.m2544l(view), i2);
            } else {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
            }
        }

        private boolean m679a(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.f408a.getPaddingTop() == i2 && this.f408a.getPaddingBottom() == i3) {
                return z;
            }
            m678a(this.f408a, i2, i3);
            return true;
        }

        void m680a(int i, int i2) {
            ag.m2528c(this.f408a, 0.0f);
            ag.m2549q(this.f408a).m2727a(1.0f).m2728a((long) i2).m2733b((long) i).m2736c();
            if (this.f409b.getVisibility() == 0) {
                ag.m2528c(this.f409b, 0.0f);
                ag.m2549q(this.f409b).m2727a(1.0f).m2728a((long) i2).m2733b((long) i).m2736c();
            }
        }

        void m681b(int i, int i2) {
            ag.m2528c(this.f408a, 1.0f);
            ag.m2549q(this.f408a).m2727a(0.0f).m2728a((long) i2).m2733b((long) i).m2736c();
            if (this.f409b.getVisibility() == 0) {
                ag.m2528c(this.f409b, 1.0f);
                ag.m2549q(this.f409b).m2727a(0.0f).m2728a((long) i2).m2733b((long) i).m2736c();
            }
        }

        Button getActionView() {
            return this.f409b;
        }

        TextView getMessageView() {
            return this.f408a;
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f413f != null) {
                this.f413f.mo95a(this);
            }
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f413f != null) {
                this.f413f.mo96b(this);
            }
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.f408a = (TextView) findViewById(C0043e.snackbar_text);
            this.f409b = (Button) findViewById(C0043e.snackbar_action);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f412e != null) {
                this.f412e.mo97a(this, i, i2, i3, i4);
            }
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f410c > 0 && getMeasuredWidth() > this.f410c) {
                i = MeasureSpec.makeMeasureSpec(this.f410c, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(C0042d.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0042d.design_snackbar_padding_vertical);
            int i3 = this.f408a.getLayout().getLineCount() > 1 ? 1 : 0;
            if (i3 == 0 || this.f411d <= 0 || this.f409b.getMeasuredWidth() <= this.f411d) {
                if (i3 == 0) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (m679a(0, dimensionPixelSize, dimensionPixelSize)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            } else {
                if (m679a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize != 0) {
                super.onMeasure(i, i2);
            }
        }

        void setOnAttachStateChangeListener(C0095a c0095a) {
            this.f413f = c0095a;
        }

        void setOnLayoutChangeListener(C0097b c0097b) {
            this.f412e = c0097b;
        }
    }

    final class C0102a extends SwipeDismissBehavior<SnackbarLayout> {
        final /* synthetic */ Snackbar f424a;

        C0102a(Snackbar snackbar) {
            this.f424a = snackbar;
        }

        public boolean m701a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.m598a((View) snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        C0157q.m1028a().m1040c(this.f424a.f432h);
                        break;
                    case 1:
                    case 3:
                        C0157q.m1028a().m1041d(this.f424a.f432h);
                        break;
                }
            }
            return super.mo43a(coordinatorLayout, (View) snackbarLayout, motionEvent);
        }

        public boolean mo101a(View view) {
            return view instanceof SnackbarLayout;
        }
    }

    public static abstract class C0103b {
        public void m704a(Snackbar snackbar) {
        }

        public void m705a(Snackbar snackbar, int i) {
        }
    }

    private Snackbar(ViewGroup viewGroup) {
        this.f426b = viewGroup;
        this.f427c = viewGroup.getContext();
        C0164u.m1053a(this.f427c);
        this.f428d = (SnackbarLayout) LayoutInflater.from(this.f427c).inflate(C0044f.design_layout_snackbar, this.f426b, false);
        this.f431g = (AccessibilityManager) this.f427c.getSystemService("accessibility");
    }

    public static Snackbar m706a(View view, CharSequence charSequence, int i) {
        Snackbar snackbar = new Snackbar(m708a(view));
        snackbar.m723a(charSequence);
        snackbar.m722a(i);
        return snackbar;
    }

    private static ViewGroup m708a(View view) {
        ViewGroup viewGroup = null;
        View view2 = view;
        while (!(view2 instanceof CoordinatorLayout)) {
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    return (ViewGroup) view2;
                }
                viewGroup = (ViewGroup) view2;
            }
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                    continue;
                } else {
                    view2 = null;
                    continue;
                }
            }
            if (view2 == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view2;
    }

    private void m712c(int i) {
        C0157q.m1028a().m1038a(this.f432h, i);
    }

    private void m715d(final int i) {
        if (VERSION.SDK_INT >= 14) {
            ag.m2549q(this.f428d).m2735c((float) this.f428d.getHeight()).m2731a(C0127a.f537b).m2728a(250).m2729a(new bb(this) {
                final /* synthetic */ Snackbar f407b;

                public void mo98a(View view) {
                    this.f407b.f428d.m681b(0, 180);
                }

                public void mo99b(View view) {
                    this.f407b.m718e(i);
                }
            }).m2736c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f428d.getContext(), C0039a.design_snackbar_out);
        loadAnimation.setInterpolator(C0127a.f537b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ Snackbar f398b;

            public void onAnimationEnd(Animation animation) {
                this.f398b.m718e(i);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.f428d.startAnimation(loadAnimation);
    }

    private void m717e() {
        if (VERSION.SDK_INT >= 14) {
            ag.m2524b(this.f428d, (float) this.f428d.getHeight());
            ag.m2549q(this.f428d).m2735c(0.0f).m2731a(C0127a.f537b).m2728a(250).m2729a(new C00997(this)).m2736c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f428d.getContext(), C0039a.design_snackbar_in);
        loadAnimation.setInterpolator(C0127a.f537b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C01008(this));
        this.f428d.startAnimation(loadAnimation);
    }

    private void m718e(int i) {
        C0157q.m1028a().m1037a(this.f432h);
        if (this.f430f != null) {
            this.f430f.m705a(this, i);
        }
        ViewParent parent = this.f428d.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f428d);
        }
    }

    private void m720f() {
        C0157q.m1028a().m1039b(this.f432h);
        if (this.f430f != null) {
            this.f430f.m704a(this);
        }
    }

    private boolean m721g() {
        return !this.f431g.isEnabled();
    }

    public Snackbar m722a(int i) {
        this.f429e = i;
        return this;
    }

    public Snackbar m723a(CharSequence charSequence) {
        this.f428d.getMessageView().setText(charSequence);
        return this;
    }

    public void m724a() {
        C0157q.m1028a().m1036a(this.f429e, this.f432h);
    }

    final void m725b(int i) {
        if (m721g() && this.f428d.getVisibility() == 0) {
            m715d(i);
        } else {
            m718e(i);
        }
    }

    public boolean m726b() {
        return C0157q.m1028a().m1042e(this.f432h);
    }

    final void m727c() {
        if (this.f428d.getParent() == null) {
            LayoutParams layoutParams = this.f428d.getLayoutParams();
            if (layoutParams instanceof C0078e) {
                C0059b c0102a = new C0102a(this);
                c0102a.m694a(0.1f);
                c0102a.m699b(0.6f);
                c0102a.m695a(0);
                c0102a.m696a(new C00934(this));
                ((C0078e) layoutParams).m554a(c0102a);
            }
            this.f426b.addView(this.f428d);
        }
        this.f428d.setOnAttachStateChangeListener(new C00965(this));
        if (!ag.m2503A(this.f428d)) {
            this.f428d.setOnLayoutChangeListener(new C00986(this));
        } else if (m721g()) {
            m717e();
        } else {
            m720f();
        }
    }
}
