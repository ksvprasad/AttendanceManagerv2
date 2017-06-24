package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ag;
import android.support.v4.view.aw;
import android.support.v4.view.bb;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0687e;
import android.support.v7.p019b.C0694a.C0688f;
import android.support.v7.p019b.C0694a.C0691i;
import android.support.v7.p019b.C0694a.C0693k;
import android.support.v7.view.menu.C0720a;
import android.support.v7.view.menu.C0721l.C0654a;
import android.support.v7.view.menu.C0727f;
import android.support.v7.view.menu.C0727f.C0638a;
import android.support.v7.widget.Toolbar.C0819b;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class bi implements aj {
    private Toolbar f2601a;
    private int f2602b;
    private View f2603c;
    private View f2604d;
    private Drawable f2605e;
    private Drawable f2606f;
    private Drawable f2607g;
    private boolean f2608h;
    private CharSequence f2609i;
    private CharSequence f2610j;
    private CharSequence f2611k;
    private Callback f2612l;
    private boolean f2613m;
    private C0873d f2614n;
    private int f2615o;
    private final C0893m f2616p;
    private int f2617q;
    private Drawable f2618r;

    class C08601 implements OnClickListener {
        final C0720a f2596a = new C0720a(this.f2597b.f2601a.getContext(), 0, 16908332, 0, 0, this.f2597b.f2609i);
        final /* synthetic */ bi f2597b;

        C08601(bi biVar) {
            this.f2597b = biVar;
        }

        public void onClick(View view) {
            if (this.f2597b.f2612l != null && this.f2597b.f2613m) {
                this.f2597b.f2612l.onMenuItemSelected(0, this.f2596a);
            }
        }
    }

    public bi(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0691i.abc_action_bar_up_description, C0687e.abc_ic_ab_back_mtrl_am_alpha);
    }

    public bi(Toolbar toolbar, boolean z, int i, int i2) {
        this.f2615o = 0;
        this.f2617q = 0;
        this.f2601a = toolbar;
        this.f2609i = toolbar.getTitle();
        this.f2610j = toolbar.getSubtitle();
        this.f2608h = this.f2609i != null;
        this.f2607g = toolbar.getNavigationIcon();
        if (z) {
            bh a = bh.m5210a(toolbar.getContext(), null, C0693k.ActionBar, C0683a.actionBarStyle, 0);
            CharSequence c = a.m5219c(C0693k.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                mo837b(c);
            }
            c = a.m5219c(C0693k.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                m5257c(c);
            }
            Drawable a2 = a.m5213a(C0693k.ActionBar_logo);
            if (a2 != null) {
                m5256c(a2);
            }
            a2 = a.m5213a(C0693k.ActionBar_icon);
            if (this.f2607g == null && a2 != null) {
                mo828a(a2);
            }
            a2 = a.m5213a(C0693k.ActionBar_homeAsUpIndicator);
            if (a2 != null) {
                m5261d(a2);
            }
            mo839c(a.m5212a(C0693k.ActionBar_displayOptions, 0));
            int g = a.m5226g(C0693k.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                m5246a(LayoutInflater.from(this.f2601a.getContext()).inflate(g, this.f2601a, false));
                mo839c(this.f2602b | 16);
            }
            g = a.m5224f(C0693k.ActionBar_height, 0);
            if (g > 0) {
                LayoutParams layoutParams = this.f2601a.getLayoutParams();
                layoutParams.height = g;
                this.f2601a.setLayoutParams(layoutParams);
            }
            g = a.m5220d(C0693k.ActionBar_contentInsetStart, -1);
            int d = a.m5220d(C0693k.ActionBar_contentInsetEnd, -1);
            if (g >= 0 || d >= 0) {
                this.f2601a.m4810a(Math.max(g, 0), Math.max(d, 0));
            }
            g = a.m5226g(C0693k.ActionBar_titleTextStyle, 0);
            if (g != 0) {
                this.f2601a.m4811a(this.f2601a.getContext(), g);
            }
            g = a.m5226g(C0693k.ActionBar_subtitleTextStyle, 0);
            if (g != 0) {
                this.f2601a.m4815b(this.f2601a.getContext(), g);
            }
            int g2 = a.m5226g(C0693k.ActionBar_popupTheme, 0);
            if (g2 != 0) {
                this.f2601a.setPopupTheme(g2);
            }
            a.m5214a();
        } else {
            this.f2602b = m5235s();
        }
        this.f2616p = C0893m.m5425a();
        m5260d(i);
        this.f2611k = this.f2601a.getNavigationContentDescription();
        m5252b(this.f2616p.m5448a(mo835b(), i2));
        this.f2601a.setNavigationOnClickListener(new C08601(this));
    }

    private void m5234e(CharSequence charSequence) {
        this.f2609i = charSequence;
        if ((this.f2602b & 8) != 0) {
            this.f2601a.setTitle(charSequence);
        }
    }

    private int m5235s() {
        return this.f2601a.getNavigationIcon() != null ? 15 : 11;
    }

    private void m5236t() {
        Drawable drawable = null;
        if ((this.f2602b & 2) != 0) {
            drawable = (this.f2602b & 1) != 0 ? this.f2606f != null ? this.f2606f : this.f2605e : this.f2605e;
        }
        this.f2601a.setLogo(drawable);
    }

    private void m5237u() {
        if ((this.f2602b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f2611k)) {
            this.f2601a.setNavigationContentDescription(this.f2617q);
        } else {
            this.f2601a.setNavigationContentDescription(this.f2611k);
        }
    }

    private void m5238v() {
        if ((this.f2602b & 4) != 0) {
            this.f2601a.setNavigationIcon(this.f2607g != null ? this.f2607g : this.f2618r);
        }
    }

    public aw mo825a(final int i, long j) {
        return ag.m2549q(this.f2601a).m2727a(i == 0 ? 1.0f : 0.0f).m2728a(j).m2729a(new bb(this) {
            final /* synthetic */ bi f2599b;
            private boolean f2600c = false;

            public void mo98a(View view) {
                this.f2599b.f2601a.setVisibility(0);
            }

            public void mo99b(View view) {
                if (!this.f2600c) {
                    this.f2599b.f2601a.setVisibility(i);
                }
            }

            public void mo100c(View view) {
                this.f2600c = true;
            }
        });
    }

    public ViewGroup mo826a() {
        return this.f2601a;
    }

    public void mo827a(int i) {
        mo828a(i != 0 ? this.f2616p.m5448a(mo835b(), i) : null);
    }

    public void mo828a(Drawable drawable) {
        this.f2605e = drawable;
        m5236t();
    }

    public void mo829a(C0654a c0654a, C0638a c0638a) {
        this.f2601a.m4813a(c0654a, c0638a);
    }

    public void mo830a(az azVar) {
        if (this.f2603c != null && this.f2603c.getParent() == this.f2601a) {
            this.f2601a.removeView(this.f2603c);
        }
        this.f2603c = azVar;
        if (azVar != null && this.f2615o == 2) {
            this.f2601a.addView(this.f2603c, 0);
            C0819b c0819b = (C0819b) this.f2603c.getLayoutParams();
            c0819b.width = -2;
            c0819b.height = -2;
            c0819b.a = 8388691;
            azVar.setAllowCollapse(true);
        }
    }

    public void mo831a(Menu menu, C0654a c0654a) {
        if (this.f2614n == null) {
            this.f2614n = new C0873d(this.f2601a.getContext());
            this.f2614n.m3765a(C0688f.action_menu_presenter);
        }
        this.f2614n.m3769a(c0654a);
        this.f2601a.m4812a((C0727f) menu, this.f2614n);
    }

    public void m5246a(View view) {
        if (!(this.f2604d == null || (this.f2602b & 16) == 0)) {
            this.f2601a.removeView(this.f2604d);
        }
        this.f2604d = view;
        if (view != null && (this.f2602b & 16) != 0) {
            this.f2601a.addView(this.f2604d);
        }
    }

    public void mo832a(Callback callback) {
        this.f2612l = callback;
    }

    public void mo833a(CharSequence charSequence) {
        if (!this.f2608h) {
            m5234e(charSequence);
        }
    }

    public void mo834a(boolean z) {
        this.f2601a.setCollapsible(z);
    }

    public Context mo835b() {
        return this.f2601a.getContext();
    }

    public void mo836b(int i) {
        m5256c(i != 0 ? this.f2616p.m5448a(mo835b(), i) : null);
    }

    public void m5252b(Drawable drawable) {
        if (this.f2618r != drawable) {
            this.f2618r = drawable;
            m5238v();
        }
    }

    public void mo837b(CharSequence charSequence) {
        this.f2608h = true;
        m5234e(charSequence);
    }

    public void mo838b(boolean z) {
    }

    public void mo839c(int i) {
        int i2 = this.f2602b ^ i;
        this.f2602b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m5238v();
                    m5237u();
                } else {
                    this.f2601a.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                m5236t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f2601a.setTitle(this.f2609i);
                    this.f2601a.setSubtitle(this.f2610j);
                } else {
                    this.f2601a.setTitle(null);
                    this.f2601a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f2604d != null) {
                if ((i & 16) != 0) {
                    this.f2601a.addView(this.f2604d);
                } else {
                    this.f2601a.removeView(this.f2604d);
                }
            }
        }
    }

    public void m5256c(Drawable drawable) {
        this.f2606f = drawable;
        m5236t();
    }

    public void m5257c(CharSequence charSequence) {
        this.f2610j = charSequence;
        if ((this.f2602b & 8) != 0) {
            this.f2601a.setSubtitle(charSequence);
        }
    }

    public boolean mo840c() {
        return this.f2601a.m4821g();
    }

    public void mo841d() {
        this.f2601a.m4822h();
    }

    public void m5260d(int i) {
        if (i != this.f2617q) {
            this.f2617q = i;
            if (TextUtils.isEmpty(this.f2601a.getNavigationContentDescription())) {
                m5264e(this.f2617q);
            }
        }
    }

    public void m5261d(Drawable drawable) {
        this.f2607g = drawable;
        m5238v();
    }

    public void m5262d(CharSequence charSequence) {
        this.f2611k = charSequence;
        m5237u();
    }

    public CharSequence mo842e() {
        return this.f2601a.getTitle();
    }

    public void m5264e(int i) {
        m5262d(i == 0 ? null : mo835b().getString(i));
    }

    public void mo843f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void mo844g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean mo845h() {
        return this.f2601a.m4814a();
    }

    public boolean mo846i() {
        return this.f2601a.m4816b();
    }

    public boolean mo847j() {
        return this.f2601a.m4817c();
    }

    public boolean mo848k() {
        return this.f2601a.m4818d();
    }

    public boolean mo849l() {
        return this.f2601a.m4819e();
    }

    public void mo850m() {
        this.f2613m = true;
    }

    public void mo851n() {
        this.f2601a.m4820f();
    }

    public int mo852o() {
        return this.f2602b;
    }

    public int mo853p() {
        return this.f2615o;
    }

    public int mo854q() {
        return this.f2601a.getVisibility();
    }

    public Menu mo855r() {
        return this.f2601a.getMenu();
    }
}
