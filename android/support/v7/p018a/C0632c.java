package android.support.v7.p018a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.p018a.C0628b.C0625a;
import android.support.v7.p019b.C0694a.C0683a;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

public class C0632c extends C0631l implements DialogInterface {
    private C0628b f1520a = new C0628b(getContext(), this, getWindow());

    public static class C0629a {
        private final C0625a f1517a;
        private int f1518b;

        public C0629a(Context context) {
            this(context, C0632c.m3325a(context, 0));
        }

        public C0629a(Context context, int i) {
            this.f1517a = new C0625a(new ContextThemeWrapper(context, C0632c.m3325a(context, i)));
            this.f1518b = i;
        }

        public Context m3303a() {
            return this.f1517a.f1450a;
        }

        public C0629a m3304a(OnKeyListener onKeyListener) {
            this.f1517a.f1467r = onKeyListener;
            return this;
        }

        public C0629a m3305a(Drawable drawable) {
            this.f1517a.f1453d = drawable;
            return this;
        }

        public C0629a m3306a(View view) {
            this.f1517a.f1456g = view;
            return this;
        }

        public C0629a m3307a(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f1517a.f1469t = listAdapter;
            this.f1517a.f1470u = onClickListener;
            return this;
        }

        public C0629a m3308a(CharSequence charSequence) {
            this.f1517a.f1455f = charSequence;
            return this;
        }

        public C0629a m3309a(CharSequence charSequence, OnClickListener onClickListener) {
            this.f1517a.f1458i = charSequence;
            this.f1517a.f1459j = onClickListener;
            return this;
        }

        public C0629a m3310a(boolean z) {
            this.f1517a.f1464o = z;
            return this;
        }

        public C0629a m3311b(View view) {
            this.f1517a.f1472w = view;
            this.f1517a.f1471v = 0;
            this.f1517a.f1438B = false;
            return this;
        }

        public C0629a m3312b(CharSequence charSequence) {
            this.f1517a.f1457h = charSequence;
            return this;
        }

        public C0629a m3313b(CharSequence charSequence, OnClickListener onClickListener) {
            this.f1517a.f1460k = charSequence;
            this.f1517a.f1461l = onClickListener;
            return this;
        }

        public C0632c m3314b() {
            C0632c c0632c = new C0632c(this.f1517a.f1450a, this.f1518b, false);
            this.f1517a.m3261a(c0632c.f1520a);
            c0632c.setCancelable(this.f1517a.f1464o);
            if (this.f1517a.f1464o) {
                c0632c.setCanceledOnTouchOutside(true);
            }
            c0632c.setOnCancelListener(this.f1517a.f1465p);
            c0632c.setOnDismissListener(this.f1517a.f1466q);
            if (this.f1517a.f1467r != null) {
                c0632c.setOnKeyListener(this.f1517a.f1467r);
            }
            return c0632c;
        }

        public C0632c m3315c() {
            C0632c b = m3314b();
            b.show();
            return b;
        }
    }

    C0632c(Context context, int i, boolean z) {
        super(context, C0632c.m3325a(context, i));
    }

    static int m3325a(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0683a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1520a.m3290a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f1520a.m3296a(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f1520a.m3300b(i, keyEvent) ? true : super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1520a.m3295a(charSequence);
    }
}
