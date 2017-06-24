package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.p002a.p003a.C0024b;
import android.support.p002a.p003a.C0038f;
import android.support.v4.p004c.C0334a;
import android.support.v4.p004c.p005a.C0314a;
import android.support.v4.p010b.C0195a;
import android.support.v4.p015g.C0370a;
import android.support.v4.p015g.C0374e;
import android.support.v4.p015g.C0375f;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0687e;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class C0893m {
    private static final Mode f2716a = Mode.SRC_IN;
    private static C0893m f2717b;
    private static final C0891b f2718c = new C0891b(6);
    private static final int[] f2719d = new int[]{C0687e.abc_textfield_search_default_mtrl_alpha, C0687e.abc_textfield_default_mtrl_alpha, C0687e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] f2720e = new int[]{C0687e.abc_ic_ab_back_mtrl_am_alpha, C0687e.abc_ic_go_search_api_mtrl_alpha, C0687e.abc_ic_search_api_mtrl_alpha, C0687e.abc_ic_commit_search_api_mtrl_alpha, C0687e.abc_ic_clear_mtrl_alpha, C0687e.abc_ic_menu_share_mtrl_alpha, C0687e.abc_ic_menu_copy_mtrl_am_alpha, C0687e.abc_ic_menu_cut_mtrl_alpha, C0687e.abc_ic_menu_selectall_mtrl_alpha, C0687e.abc_ic_menu_paste_mtrl_am_alpha, C0687e.abc_ic_menu_moreoverflow_mtrl_alpha, C0687e.abc_ic_voice_search_api_mtrl_alpha};
    private static final int[] f2721f = new int[]{C0687e.abc_textfield_activated_mtrl_alpha, C0687e.abc_textfield_search_activated_mtrl_alpha, C0687e.abc_cab_background_top_mtrl_alpha, C0687e.abc_text_cursor_material};
    private static final int[] f2722g = new int[]{C0687e.abc_popup_background_mtrl_mult, C0687e.abc_cab_background_internal_bg, C0687e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] f2723h = new int[]{C0687e.abc_edit_text_material, C0687e.abc_tab_indicator_material, C0687e.abc_textfield_search_material, C0687e.abc_spinner_mtrl_am_alpha, C0687e.abc_spinner_textfield_background_material, C0687e.abc_ratingbar_full_material, C0687e.abc_switch_track_mtrl_alpha, C0687e.abc_switch_thumb_material, C0687e.abc_btn_default_mtrl_shape, C0687e.abc_btn_borderless_material};
    private static final int[] f2724i = new int[]{C0687e.abc_btn_check_material, C0687e.abc_btn_radio_material};
    private WeakHashMap<Context, SparseArray<ColorStateList>> f2725j;
    private C0370a<String, C0889c> f2726k;
    private SparseArray<String> f2727l;
    private final Object f2728m = new Object();
    private final WeakHashMap<Context, C0374e<WeakReference<ConstantState>>> f2729n = new WeakHashMap(0);
    private TypedValue f2730o;

    private interface C0889c {
        Drawable mo869a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    private static class C0890a implements C0889c {
        private C0890a() {
        }

        public Drawable mo869a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0024b.m115a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    private static class C0891b extends C0375f<Integer, PorterDuffColorFilter> {
        public C0891b(int i) {
            super(i);
        }

        private static int m5415b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter m5416a(int i, Mode mode) {
            return (PorterDuffColorFilter) m1925a((Object) Integer.valueOf(C0891b.m5415b(i, mode)));
        }

        PorterDuffColorFilter m5417a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) m1926a(Integer.valueOf(C0891b.m5415b(i, mode)), porterDuffColorFilter);
        }
    }

    private static class C0892d implements C0889c {
        private C0892d() {
        }

        public Drawable mo869a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0038f.m178a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    private static long m5419a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private ColorStateList m5420a(Context context) {
        int a = bc.m5199a(context, C0683a.colorControlNormal);
        int a2 = bc.m5199a(context, C0683a.colorControlActivated);
        r2 = new int[7][];
        int[] iArr = new int[]{bc.f2576a, bc.m5203c(context, C0683a.colorControlNormal), bc.f2577b, a2, bc.f2578c, a2, bc.f2579d};
        iArr[3] = a2;
        r2[4] = bc.f2580e;
        iArr[4] = a2;
        r2[5] = bc.f2581f;
        iArr[5] = a2;
        r2[6] = bc.f2583h;
        iArr[6] = a;
        return new ColorStateList(r2, iArr);
    }

    public static PorterDuffColorFilter m5421a(int i, Mode mode) {
        PorterDuffColorFilter a = f2718c.m5416a(i, mode);
        if (a != null) {
            return a;
        }
        a = new PorterDuffColorFilter(i, mode);
        f2718c.m5417a(i, mode, a);
        return a;
    }

    private static PorterDuffColorFilter m5422a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        return (colorStateList == null || mode == null) ? null : C0893m.m5421a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable m5423a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = m5451b(context, i);
        if (b != null) {
            if (al.m5020b(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = C0314a.m1776f(drawable);
            C0314a.m1766a(drawable, b);
            Mode a = m5447a(i);
            if (a == null) {
                return drawable;
            }
            C0314a.m1769a(drawable, a);
            return drawable;
        } else if (i == C0687e.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            C0893m.m5427a(r0.findDrawableByLayerId(16908288), bc.m5199a(context, C0683a.colorControlNormal), f2716a);
            C0893m.m5427a(r0.findDrawableByLayerId(16908303), bc.m5199a(context, C0683a.colorControlNormal), f2716a);
            C0893m.m5427a(r0.findDrawableByLayerId(16908301), bc.m5199a(context, C0683a.colorControlActivated), f2716a);
            return drawable;
        } else if (i != C0687e.abc_ratingbar_indicator_material && i != C0687e.abc_ratingbar_small_material) {
            return (C0893m.m5431a(context, i, drawable) || !z) ? drawable : null;
        } else {
            r0 = (LayerDrawable) drawable;
            C0893m.m5427a(r0.findDrawableByLayerId(16908288), bc.m5203c(context, C0683a.colorControlNormal), f2716a);
            C0893m.m5427a(r0.findDrawableByLayerId(16908303), bc.m5199a(context, C0683a.colorControlActivated), f2716a);
            C0893m.m5427a(r0.findDrawableByLayerId(16908301), bc.m5199a(context, C0683a.colorControlActivated), f2716a);
            return drawable;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m5424a(android.content.Context r5, long r6) {
        /*
        r4 = this;
        r2 = 0;
        r3 = r4.f2728m;
        monitor-enter(r3);
        r0 = r4.f2729n;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002b }
        r0 = (android.support.v4.p015g.C0374e) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0.m1915a(r6);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0031;
    L_0x0019:
        r1 = r1.get();	 Catch:{ all -> 0x002b }
        r1 = (android.graphics.drawable.Drawable.ConstantState) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r5.getResources();	 Catch:{ all -> 0x002b }
        r0 = r1.newDrawable(r0);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0.m1920b(r6);	 Catch:{ all -> 0x002b }
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.m.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static C0893m m5425a() {
        if (f2717b == null) {
            f2717b = new C0893m();
            C0893m.m5429a(f2717b);
        }
        return f2717b;
    }

    private void m5426a(Context context, int i, ColorStateList colorStateList) {
        if (this.f2725j == null) {
            this.f2725j = new WeakHashMap();
        }
        SparseArray sparseArray = (SparseArray) this.f2725j.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.f2725j.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    private static void m5427a(Drawable drawable, int i, Mode mode) {
        if (al.m5020b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f2716a;
        }
        drawable.setColorFilter(C0893m.m5421a(i, mode));
    }

    public static void m5428a(Drawable drawable, bf bfVar, int[] iArr) {
        if (!al.m5020b(drawable) || drawable.mutate() == drawable) {
            if (bfVar.f2592d || bfVar.f2591c) {
                drawable.setColorFilter(C0893m.m5422a(bfVar.f2592d ? bfVar.f2589a : null, bfVar.f2591c ? bfVar.f2590b : f2716a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    private static void m5429a(C0893m c0893m) {
        int i = VERSION.SDK_INT;
        if (i < 23) {
            c0893m.m5430a("vector", new C0892d());
            if (i >= 11) {
                c0893m.m5430a("animated-vector", new C0890a());
            }
        }
    }

    private void m5430a(String str, C0889c c0889c) {
        if (this.f2726k == null) {
            this.f2726k = new C0370a();
        }
        this.f2726k.put(str, c0889c);
    }

    static boolean m5431a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = f2716a;
        if (C0893m.m5433a(f2719d, i)) {
            i2 = C0683a.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0893m.m5433a(f2721f, i)) {
            i2 = C0683a.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0893m.m5433a(f2722g, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C0687e.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (al.m5020b(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(C0893m.m5421a(bc.m5199a(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private boolean m5432a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.f2728m) {
            C0374e c0374e = (C0374e) this.f2729n.get(context);
            if (c0374e == null) {
                c0374e = new C0374e();
                this.f2729n.put(context, c0374e);
            }
            c0374e.m1921b(j, new WeakReference(constantState));
        }
        return true;
    }

    private static boolean m5433a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList m5434b(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{bc.f2576a, bc.m5203c(context, C0683a.colorControlNormal), bc.f2580e};
        iArr[1] = bc.m5199a(context, C0683a.colorControlActivated);
        r0[2] = bc.f2583h;
        iArr[2] = bc.m5199a(context, C0683a.colorControlNormal);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m5435c(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{bc.f2576a, bc.m5200a(context, 16842800, 0.1f), bc.f2580e};
        iArr[1] = bc.m5200a(context, C0683a.colorControlActivated, 0.3f);
        r0[2] = bc.f2583h;
        iArr[2] = bc.m5200a(context, 16842800, 0.3f);
        return new ColorStateList(r0, iArr);
    }

    private Drawable m5436c(Context context, int i) {
        if (this.f2730o == null) {
            this.f2730o = new TypedValue();
        }
        TypedValue typedValue = this.f2730o;
        context.getResources().getValue(i, typedValue, true);
        long a = C0893m.m5419a(typedValue);
        Drawable a2 = m5424a(context, a);
        if (a2 == null) {
            if (i == C0687e.abc_cab_background_top_material) {
                a2 = new LayerDrawable(new Drawable[]{m5448a(context, C0687e.abc_cab_background_internal_bg), m5448a(context, C0687e.abc_cab_background_top_mtrl_alpha)});
            }
            if (a2 != null) {
                a2.setChangingConfigurations(typedValue.changingConfigurations);
                m5432a(context, a, a2);
            }
        }
        return a2;
    }

    private ColorStateList m5437d(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = bc.m5202b(context, C0683a.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = bc.f2576a;
            iArr2[0] = bc.m5203c(context, C0683a.colorSwitchThumbNormal);
            iArr[1] = bc.f2580e;
            iArr2[1] = bc.m5199a(context, C0683a.colorControlActivated);
            iArr[2] = bc.f2583h;
            iArr2[2] = bc.m5199a(context, C0683a.colorSwitchThumbNormal);
        } else {
            iArr[0] = bc.f2576a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = bc.f2580e;
            iArr2[1] = bc.m5199a(context, C0683a.colorControlActivated);
            iArr[2] = bc.f2583h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m5438d(android.content.Context r10, int r11) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 2;
        r7 = 1;
        r0 = r9.f2726k;
        if (r0 == 0) goto L_0x00bf;
    L_0x0007:
        r0 = r9.f2726k;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00bf;
    L_0x000f:
        r0 = r9.f2727l;
        if (r0 == 0) goto L_0x002f;
    L_0x0013:
        r0 = r9.f2727l;
        r0 = r0.get(r11);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002d;
    L_0x0023:
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r2 = r9.f2726k;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0036;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = new android.util.SparseArray;
        r0.<init>();
        r9.f2727l = r0;
    L_0x0036:
        r0 = r9.f2730o;
        if (r0 != 0) goto L_0x0041;
    L_0x003a:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r9.f2730o = r0;
    L_0x0041:
        r2 = r9.f2730o;
        r0 = r10.getResources();
        r0.getValue(r11, r2, r7);
        r4 = android.support.v7.widget.C0893m.m5419a(r2);
        r1 = r9.m5424a(r10, r4);
        if (r1 == 0) goto L_0x0056;
    L_0x0054:
        r0 = r1;
        goto L_0x002e;
    L_0x0056:
        r3 = r2.string;
        if (r3 == 0) goto L_0x008a;
    L_0x005a:
        r3 = r2.string;
        r3 = r3.toString();
        r6 = ".xml";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x008a;
    L_0x0068:
        r3 = r0.getXml(r11);	 Catch:{ Exception -> 0x0082 }
        r6 = android.util.Xml.asAttributeSet(r3);	 Catch:{ Exception -> 0x0082 }
    L_0x0070:
        r0 = r3.next();	 Catch:{ Exception -> 0x0082 }
        if (r0 == r8) goto L_0x0078;
    L_0x0076:
        if (r0 != r7) goto L_0x0070;
    L_0x0078:
        if (r0 == r8) goto L_0x0095;
    L_0x007a:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x0082 }
        r2 = "No start tag found";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0082 }
        throw r0;	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        r0 = move-exception;
        r2 = "AppCompatDrawableManager";
        r3 = "Exception while inflating drawable";
        android.util.Log.e(r2, r3, r0);
    L_0x008a:
        r0 = r1;
    L_0x008b:
        if (r0 != 0) goto L_0x002e;
    L_0x008d:
        r1 = r9.f2727l;
        r2 = "appcompat_skip_skip";
        r1.append(r11, r2);
        goto L_0x002e;
    L_0x0095:
        r0 = r3.getName();	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f2727l;	 Catch:{ Exception -> 0x0082 }
        r7.append(r11, r0);	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f2726k;	 Catch:{ Exception -> 0x0082 }
        r0 = r7.get(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = (android.support.v7.widget.C0893m.C0889c) r0;	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00b0;
    L_0x00a8:
        r7 = r10.getTheme();	 Catch:{ Exception -> 0x0082 }
        r1 = r0.mo869a(r10, r3, r6, r7);	 Catch:{ Exception -> 0x0082 }
    L_0x00b0:
        if (r1 == 0) goto L_0x00bd;
    L_0x00b2:
        r0 = r2.changingConfigurations;	 Catch:{ Exception -> 0x0082 }
        r1.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = r9.m5432a(r10, r4, r1);	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00bd:
        r0 = r1;
        goto L_0x008b;
    L_0x00bf:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.m.d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private ColorStateList m5439e(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{bc.f2576a, bc.m5203c(context, C0683a.colorControlNormal), bc.f2582g};
        iArr[1] = bc.m5199a(context, C0683a.colorControlNormal);
        r0[2] = bc.f2583h;
        iArr[2] = bc.m5199a(context, C0683a.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m5440e(Context context, int i) {
        if (this.f2725j == null) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.f2725j.get(context);
        return sparseArray != null ? (ColorStateList) sparseArray.get(i) : null;
    }

    private ColorStateList m5441f(Context context) {
        return m5442f(context, bc.m5199a(context, C0683a.colorButtonNormal));
    }

    private ColorStateList m5442f(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = bc.m5199a(context, C0683a.colorControlHighlight);
        r0[0] = bc.f2576a;
        r1[0] = bc.m5203c(context, C0683a.colorButtonNormal);
        r0[1] = bc.f2579d;
        r1[1] = C0334a.m1820a(a, i);
        r0[2] = bc.f2577b;
        r1[2] = C0334a.m1820a(a, i);
        r0[3] = bc.f2583h;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    private ColorStateList m5443g(Context context) {
        return m5442f(context, 0);
    }

    private ColorStateList m5444h(Context context) {
        return m5442f(context, bc.m5199a(context, C0683a.colorAccent));
    }

    private ColorStateList m5445i(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{bc.f2576a, bc.m5203c(context, C0683a.colorControlNormal), bc.f2582g};
        iArr[1] = bc.m5199a(context, C0683a.colorControlNormal);
        r0[2] = bc.f2583h;
        iArr[2] = bc.m5199a(context, C0683a.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m5446j(Context context) {
        r0 = new int[2][];
        int[] iArr = new int[]{bc.f2576a, bc.m5203c(context, C0683a.colorControlActivated)};
        r0[1] = bc.f2583h;
        iArr[1] = bc.m5199a(context, C0683a.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    final Mode m5447a(int i) {
        return i == C0687e.abc_switch_thumb_material ? Mode.MULTIPLY : null;
    }

    public Drawable m5448a(Context context, int i) {
        return m5449a(context, i, false);
    }

    public Drawable m5449a(Context context, int i, boolean z) {
        Drawable d = m5438d(context, i);
        if (d == null) {
            d = m5436c(context, i);
        }
        if (d == null) {
            d = C0195a.m1224a(context, i);
        }
        if (d != null) {
            d = m5423a(context, i, z, d);
        }
        if (d != null) {
            al.m5019a(d);
        }
        return d;
    }

    public final Drawable m5450a(Context context, bj bjVar, int i) {
        Drawable d = m5438d(context, i);
        if (d == null) {
            d = bjVar.m5279a(i);
        }
        return d != null ? m5423a(context, i, false, d) : null;
    }

    public final ColorStateList m5451b(Context context, int i) {
        ColorStateList e = m5440e(context, i);
        if (e == null) {
            if (i == C0687e.abc_edit_text_material) {
                e = m5439e(context);
            } else if (i == C0687e.abc_switch_track_mtrl_alpha) {
                e = m5435c(context);
            } else if (i == C0687e.abc_switch_thumb_material) {
                e = m5437d(context);
            } else if (i == C0687e.abc_btn_default_mtrl_shape) {
                e = m5441f(context);
            } else if (i == C0687e.abc_btn_borderless_material) {
                e = m5443g(context);
            } else if (i == C0687e.abc_btn_colored_material) {
                e = m5444h(context);
            } else if (i == C0687e.abc_spinner_mtrl_am_alpha || i == C0687e.abc_spinner_textfield_background_material) {
                e = m5445i(context);
            } else if (C0893m.m5433a(f2720e, i)) {
                e = bc.m5202b(context, C0683a.colorControlNormal);
            } else if (C0893m.m5433a(f2723h, i)) {
                e = m5420a(context);
            } else if (C0893m.m5433a(f2724i, i)) {
                e = m5434b(context);
            } else if (i == C0687e.abc_seekbar_thumb_material) {
                e = m5446j(context);
            }
            if (e != null) {
                m5426a(context, i, e);
            }
        }
        return e;
    }
}
