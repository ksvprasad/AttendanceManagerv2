package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.cu;
import com.google.android.gms.p031b.cw;
import com.google.android.gms.p031b.cy;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.ke;
import com.google.android.gms.p031b.ke.C1673a;
import com.google.android.gms.p031b.ke.C1674b;
import java.util.concurrent.TimeUnit;

@id
public class C1221x {
    private final Context f3599a;
    private final String f3600b;
    private final VersionInfoParcel f3601c;
    private final cw f3602d;
    private final cy f3603e;
    private final ke f3604f = new C1674b().m9317a("min_1", Double.MIN_VALUE, 1.0d).m9317a("1_5", 1.0d, 5.0d).m9317a("5_10", 5.0d, 10.0d).m9317a("10_20", 10.0d, 20.0d).m9317a("20_30", 20.0d, 30.0d).m9317a("30_max", 30.0d, Double.MAX_VALUE).m9318a();
    private final long[] f3605g;
    private final String[] f3606h;
    private cw f3607i;
    private cw f3608j;
    private cw f3609k;
    private cw f3610l;
    private boolean f3611m;
    private C1191i f3612n;
    private boolean f3613o;
    private boolean f3614p;
    private long f3615q = -1;

    public C1221x(Context context, VersionInfoParcel versionInfoParcel, String str, cy cyVar, cw cwVar) {
        this.f3599a = context;
        this.f3601c = versionInfoParcel;
        this.f3600b = str;
        this.f3603e = cyVar;
        this.f3602d = cwVar;
        String str2 = (String) cq.f4408w.m7801c();
        if (str2 == null) {
            this.f3606h = new String[0];
            this.f3605g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.f3606h = new String[split.length];
        this.f3605g = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.f3605g[i] = Long.parseLong(split[i]);
            } catch (Throwable e) {
                C1324b.m7235d("Unable to parse frame hash target time number.", e);
                this.f3605g[i] = -1;
            }
        }
    }

    private void m6772c(C1191i c1191i) {
        long longValue = ((Long) cq.f4409x.m7801c()).longValue();
        long currentPosition = (long) c1191i.getCurrentPosition();
        int i = 0;
        while (i < this.f3606h.length) {
            if (this.f3606h[i] == null && longValue > Math.abs(currentPosition - this.f3605g[i])) {
                this.f3606h[i] = m6774a((TextureView) c1191i);
                return;
            }
            i++;
        }
    }

    private void m6773e() {
        if (this.f3609k != null && this.f3610l == null) {
            cu.m7848a(this.f3603e, this.f3609k, "vff");
            cu.m7848a(this.f3603e, this.f3602d, "vtt");
            this.f3610l = cu.m7845a(this.f3603e);
        }
        long c = C1319u.m7187i().mo1725c();
        if (this.f3611m && this.f3614p && this.f3615q != -1) {
            this.f3604f.m9321a(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (c - this.f3615q)));
        }
        this.f3614p = this.f3611m;
        this.f3615q = c;
    }

    String m6774a(TextureView textureView) {
        Bitmap bitmap = textureView.getBitmap(8, 8);
        long j = 0;
        long j2 = 63;
        int i = 0;
        while (i < 8) {
            long j3 = j;
            j = j2;
            for (int i2 = 0; i2 < 8; i2++) {
                int pixel = bitmap.getPixel(i2, i);
                j3 |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > 128 ? 1 : 0) << ((int) j);
                j--;
            }
            i++;
            j2 = j;
            j = j3;
        }
        return String.format("%016X", new Object[]{Long.valueOf(j)});
    }

    public void m6775a() {
        if (this.f3607i != null && this.f3608j == null) {
            cu.m7848a(this.f3603e, this.f3607i, "vfr");
            this.f3608j = cu.m7845a(this.f3603e);
        }
    }

    public void m6776a(C1191i c1191i) {
        cu.m7848a(this.f3603e, this.f3602d, "vpc");
        this.f3607i = cu.m7845a(this.f3603e);
        if (this.f3603e != null) {
            this.f3603e.m7865a("vpn", c1191i.mo1117a());
        }
        this.f3612n = c1191i;
    }

    public void m6777b() {
        if (((Boolean) cq.f4407v.m7801c()).booleanValue() && !this.f3613o) {
            String valueOf;
            String valueOf2;
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.f3600b);
            bundle.putString("player", this.f3612n.mo1117a());
            for (C1673a c1673a : this.f3604f.m9320a()) {
                valueOf = String.valueOf("fps_c_");
                valueOf2 = String.valueOf(c1673a.f5589a);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(c1673a.f5593e));
                valueOf = String.valueOf("fps_p_");
                valueOf2 = String.valueOf(c1673a.f5589a);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Double.toString(c1673a.f5592d));
            }
            for (int i = 0; i < this.f3605g.length; i++) {
                valueOf2 = this.f3606h[i];
                if (valueOf2 != null) {
                    String valueOf3 = String.valueOf("fh_");
                    valueOf = String.valueOf(Long.valueOf(this.f3605g[i]));
                    bundle.putString(new StringBuilder((String.valueOf(valueOf3).length() + 0) + String.valueOf(valueOf).length()).append(valueOf3).append(valueOf).toString(), valueOf2);
                }
            }
            C1319u.m7183e().m9217a(this.f3599a, this.f3601c.f3957b, "gmob-apps", bundle, true);
            this.f3613o = true;
        }
    }

    public void m6778b(C1191i c1191i) {
        m6773e();
        m6772c(c1191i);
    }

    public void m6779c() {
        this.f3611m = true;
        if (this.f3608j != null && this.f3609k == null) {
            cu.m7848a(this.f3603e, this.f3608j, "vfp");
            this.f3609k = cu.m7845a(this.f3603e);
        }
    }

    public void m6780d() {
        this.f3611m = false;
    }
}
