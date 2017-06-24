package android.support.v7.p018a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p015g.C0370a;
import android.support.v4.view.ag;
import android.support.v7.p019b.C0694a.C0693k;
import android.support.v7.view.C0706d;
import android.support.v7.widget.C0162n;
import android.support.v7.widget.C0803g;
import android.support.v7.widget.C0869q;
import android.support.v7.widget.C0884i;
import android.support.v7.widget.C0885j;
import android.support.v7.widget.C0886k;
import android.support.v7.widget.C0894o;
import android.support.v7.widget.C0896r;
import android.support.v7.widget.C0900u;
import android.support.v7.widget.C0901v;
import android.support.v7.widget.C0902w;
import android.support.v7.widget.C0910y;
import android.support.v7.widget.ab;
import android.support.v7.widget.be;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

class C0663m {
    private static final Class<?>[] f1619a = new Class[]{Context.class, AttributeSet.class};
    private static final int[] f1620b = new int[]{16843375};
    private static final String[] f1621c = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> f1622d = new C0370a();
    private final Object[] f1623e = new Object[2];

    private static class C0662a implements OnClickListener {
        private final View f1615a;
        private final String f1616b;
        private Method f1617c;
        private Context f1618d;

        public C0662a(View view, String str) {
            this.f1615a = view;
            this.f1616b = str;
        }

        private void m3503a(Context context, String str) {
            for (Context context2 = context; context2 != null; context2 = context2 instanceof ContextWrapper ? ((ContextWrapper) context2).getBaseContext() : null) {
                try {
                    if (!context2.isRestricted()) {
                        Method method = context2.getClass().getMethod(this.f1616b, new Class[]{View.class});
                        if (method != null) {
                            this.f1617c = method;
                            this.f1618d = context2;
                            return;
                        }
                    }
                } catch (NoSuchMethodException e) {
                }
            }
            int id = this.f1615a.getId();
            throw new IllegalStateException("Could not find method " + this.f1616b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.f1615a.getClass() + (id == -1 ? "" : " with id '" + this.f1615a.getContext().getResources().getResourceEntryName(id) + "'"));
        }

        public void onClick(View view) {
            if (this.f1617c == null) {
                m3503a(this.f1615a.getContext(), this.f1616b);
            }
            try {
                this.f1617c.invoke(this.f1618d, new Object[]{view});
            } catch (Throwable e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (Throwable e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    C0663m() {
    }

    private static Context m3504a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0693k.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(C0693k.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0) {
            resourceId = obtainStyledAttributes.getResourceId(C0693k.View_theme, 0);
            if (resourceId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        return i != 0 ? ((context instanceof C0706d) && ((C0706d) context).m3657a() == i) ? context : new C0706d(context, i) : context;
    }

    private View m3505a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f1623e[0] = context;
            this.f1623e[1] = attributeSet;
            View a;
            if (-1 == str.indexOf(46)) {
                for (String a2 : f1621c) {
                    a = m3506a(context, str, a2);
                    if (a != null) {
                        return a;
                    }
                }
                this.f1623e[0] = null;
                this.f1623e[1] = null;
                return null;
            }
            a = m3506a(context, str, null);
            this.f1623e[0] = null;
            this.f1623e[1] = null;
            return a;
        } catch (Exception e) {
            return null;
        } finally {
            this.f1623e[0] = null;
            this.f1623e[1] = null;
        }
    }

    private View m3506a(Context context, String str, String str2) {
        Constructor constructor = (Constructor) f1622d.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f1619a);
                f1622d.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f1623e);
    }

    private void m3507a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (VERSION.SDK_INT < 15 || ag.m2506D(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1620b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C0662a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final View m3508a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = C0663m.m3504a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = be.m5206a(context2);
        }
        View view2 = null;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    obj = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    obj = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    obj = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    obj = null;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    obj = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    obj = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    obj = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    obj = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    obj = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    obj = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    obj = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    obj = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                view2 = new ab(context2, attributeSet);
                break;
            case 1:
                view2 = new C0869q(context2, attributeSet);
                break;
            case 2:
                view2 = new C0884i(context2, attributeSet);
                break;
            case 3:
                view2 = new C0162n(context2, attributeSet);
                break;
            case 4:
                view2 = new C0910y(context2, attributeSet);
                break;
            case 5:
                view2 = new C0894o(context2, attributeSet);
                break;
            case 6:
                view2 = new C0885j(context2, attributeSet);
                break;
            case 7:
                view2 = new C0900u(context2, attributeSet);
                break;
            case 8:
                view2 = new C0886k(context2, attributeSet);
                break;
            case 9:
                view2 = new C0803g(context2, attributeSet);
                break;
            case 10:
                view2 = new C0896r(context2, attributeSet);
                break;
            case 11:
                view2 = new C0901v(context2, attributeSet);
                break;
            case 12:
                view2 = new C0902w(context2, attributeSet);
                break;
        }
        View a = (view2 != null || context == context2) ? view2 : m3505a(context2, str, attributeSet);
        if (a != null) {
            m3507a(a, attributeSet);
        }
        return a;
    }
}
