package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.C1029d;
import com.google.android.gms.ads.C1330k;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;

@id
public class AdSizeParcel extends AbstractSafeParcelable {
    public static final C1109u CREATOR = new C1109u();
    public final int f3103a;
    public final String f3104b;
    public final int f3105c;
    public final int f3106d;
    public final boolean f3107e;
    public final int f3108f;
    public final int f3109g;
    public final AdSizeParcel[] f3110h;
    public final boolean f3111i;
    public final boolean f3112j;
    public boolean f3113k;

    public AdSizeParcel() {
        this(5, "interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    AdSizeParcel(int i, String str, int i2, int i3, boolean z, int i4, int i5, AdSizeParcel[] adSizeParcelArr, boolean z2, boolean z3, boolean z4) {
        this.f3103a = i;
        this.f3104b = str;
        this.f3105c = i2;
        this.f3106d = i3;
        this.f3107e = z;
        this.f3108f = i4;
        this.f3109g = i5;
        this.f3110h = adSizeParcelArr;
        this.f3111i = z2;
        this.f3112j = z3;
        this.f3113k = z4;
    }

    public AdSizeParcel(Context context, C1029d c1029d) {
        this(context, new C1029d[]{c1029d});
    }

    public AdSizeParcel(Context context, C1029d[] c1029dArr) {
        int i;
        int i2;
        C1029d c1029d = c1029dArr[0];
        this.f3103a = 5;
        this.f3107e = false;
        this.f3112j = c1029d.m5805c();
        if (this.f3112j) {
            this.f3108f = C1029d.f3015a.m5803b();
            this.f3105c = C1029d.f3015a.m5801a();
        } else {
            this.f3108f = c1029d.m5803b();
            this.f3105c = c1029d.m5801a();
        }
        boolean z = this.f3108f == -1;
        boolean z2 = this.f3105c == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            if (C1120y.m6293a().m7224c(context) && C1120y.m6293a().m7225d(context)) {
                this.f3109g = m5966a(displayMetrics) - C1120y.m6293a().m7226e(context);
            } else {
                this.f3109g = m5966a(displayMetrics);
            }
            double d = (double) (((float) this.f3109g) / displayMetrics.density);
            i = (int) d;
            if (d - ((double) ((int) d)) >= 0.01d) {
                i++;
            }
            i2 = i;
        } else {
            i = this.f3108f;
            this.f3109g = C1120y.m6293a().m7209a(displayMetrics, this.f3108f);
            i2 = i;
        }
        i = z2 ? m5970c(displayMetrics) : this.f3105c;
        this.f3106d = C1120y.m6293a().m7209a(displayMetrics, i);
        if (z || z2) {
            this.f3104b = i2 + "x" + i + "_as";
        } else if (this.f3112j) {
            this.f3104b = "320x50_mb";
        } else {
            this.f3104b = c1029d.toString();
        }
        if (c1029dArr.length > 1) {
            this.f3110h = new AdSizeParcel[c1029dArr.length];
            for (int i3 = 0; i3 < c1029dArr.length; i3++) {
                this.f3110h[i3] = new AdSizeParcel(context, c1029dArr[i3]);
            }
        } else {
            this.f3110h = null;
        }
        this.f3111i = false;
        this.f3113k = false;
    }

    public AdSizeParcel(AdSizeParcel adSizeParcel, AdSizeParcel[] adSizeParcelArr) {
        this(5, adSizeParcel.f3104b, adSizeParcel.f3105c, adSizeParcel.f3106d, adSizeParcel.f3107e, adSizeParcel.f3108f, adSizeParcel.f3109g, adSizeParcelArr, adSizeParcel.f3111i, adSizeParcel.f3112j, adSizeParcel.f3113k);
    }

    public static int m5966a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static AdSizeParcel m5967a() {
        return new AdSizeParcel(5, "reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public static AdSizeParcel m5968a(Context context) {
        return new AdSizeParcel(5, "320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    public static int m5969b(DisplayMetrics displayMetrics) {
        return (int) (((float) m5970c(displayMetrics)) * displayMetrics.density);
    }

    private static int m5970c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    public void m5971a(boolean z) {
        this.f3113k = z;
    }

    public C1029d m5972b() {
        return C1330k.m7257a(this.f3108f, this.f3105c, this.f3104b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1109u.m6242a(this, parcel, i);
    }
}
