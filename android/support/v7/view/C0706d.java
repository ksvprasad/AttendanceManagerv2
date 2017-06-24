package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.p019b.C0694a.C0692j;
import android.view.LayoutInflater;

public class C0706d extends ContextWrapper {
    private int f1700a;
    private Theme f1701b;
    private LayoutInflater f1702c;

    public C0706d(Context context, int i) {
        super(context);
        this.f1700a = i;
    }

    public C0706d(Context context, Theme theme) {
        super(context);
        this.f1701b = theme;
    }

    private void m3656b() {
        boolean z = this.f1701b == null;
        if (z) {
            this.f1701b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1701b.setTo(theme);
            }
        }
        m3658a(this.f1701b, this.f1700a, z);
    }

    public int m3657a() {
        return this.f1700a;
    }

    protected void m3658a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1702c == null) {
            this.f1702c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1702c;
    }

    public Theme getTheme() {
        if (this.f1701b != null) {
            return this.f1701b;
        }
        if (this.f1700a == 0) {
            this.f1700a = C0692j.Theme_AppCompat_Light;
        }
        m3656b();
        return this.f1701b;
    }

    public void setTheme(int i) {
        if (this.f1700a != i) {
            this.f1700a = i;
            m3656b();
        }
    }
}
