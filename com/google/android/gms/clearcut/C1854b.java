package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.C1713d;
import com.google.android.gms.common.api.C1767c;
import com.google.android.gms.common.api.C1767c.C1733c;
import com.google.android.gms.common.api.C1767c.C1742b;
import com.google.android.gms.common.api.C1864a;
import com.google.android.gms.common.api.C1864a.C1722f;
import com.google.android.gms.common.api.C1864a.C1827b;
import com.google.android.gms.common.api.C1864a.C1830a.C1858b;
import com.google.android.gms.common.api.C1864a.C1860g;
import com.google.android.gms.common.api.C1867e;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.C1927n;
import com.google.android.gms.common.util.C1970c;
import com.google.android.gms.common.util.C1972e;
import com.google.android.gms.p031b.ad.C1362d;
import com.google.android.gms.p031b.lr;
import com.google.android.gms.p031b.ls;
import com.google.android.gms.p031b.lw;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public final class C1854b {
    public static final C1860g<ls> f6305a = new C1860g();
    public static final C1827b<ls, C1858b> f6306b = new C18501();
    public static final C1864a<C1858b> f6307c = new C1864a("ClearcutLogger.API", f6306b, f6305a);
    public static final C1720c f6308d = new lr();
    private final Context f6309e;
    private final String f6310f;
    private final int f6311g;
    private String f6312h;
    private int f6313i;
    private String f6314j;
    private String f6315k;
    private final boolean f6316l;
    private int f6317m;
    private final C1720c f6318n;
    private final C1970c f6319o;
    private final C1849a f6320p;
    private C1853d f6321q;
    private final C1730b f6322r;

    public interface C1730b {
        boolean mo1559a(String str, int i);
    }

    class C18501 extends C1827b<ls, C1858b> {
        C18501() {
        }

        public ls m10512a(Context context, Looper looper, C1927n c1927n, C1858b c1858b, C1742b c1742b, C1733c c1733c) {
            return new ls(context, looper, c1927n, c1742b, c1733c);
        }

        public /* synthetic */ C1722f mo1639a(Context context, Looper looper, C1927n c1927n, Object obj, C1742b c1742b, C1733c c1733c) {
            return m10512a(context, looper, c1927n, (C1858b) obj, c1742b, c1733c);
        }
    }

    public class C1851a {
        final /* synthetic */ C1854b f6291a;
        private int f6292b;
        private String f6293c;
        private String f6294d;
        private String f6295e;
        private int f6296f;
        private final C1852c f6297g;
        private ArrayList<Integer> f6298h;
        private ArrayList<String> f6299i;
        private ArrayList<Integer> f6300j;
        private ArrayList<byte[]> f6301k;
        private boolean f6302l;
        private final C1362d f6303m;
        private boolean f6304n;

        private C1851a(C1854b c1854b, byte[] bArr) {
            this(c1854b, bArr, null);
        }

        private C1851a(C1854b c1854b, byte[] bArr, C1852c c1852c) {
            this.f6291a = c1854b;
            this.f6292b = this.f6291a.f6313i;
            this.f6293c = this.f6291a.f6312h;
            this.f6294d = this.f6291a.f6314j;
            this.f6295e = this.f6291a.f6315k;
            this.f6296f = 0;
            this.f6298h = null;
            this.f6299i = null;
            this.f6300j = null;
            this.f6301k = null;
            this.f6302l = true;
            this.f6303m = new C1362d();
            this.f6304n = false;
            this.f6294d = c1854b.f6314j;
            this.f6295e = c1854b.f6315k;
            this.f6303m.f4073a = c1854b.f6319o.mo1723a();
            this.f6303m.f4074b = c1854b.f6319o.mo1724b();
            this.f6303m.f4094v = (long) c1854b.f6320p.m10511a(c1854b.f6309e);
            this.f6303m.f4088p = c1854b.f6321q.m10519a(this.f6303m.f4073a);
            if (bArr != null) {
                this.f6303m.f4083k = bArr;
            }
            this.f6297g = c1852c;
        }

        public LogEventParcelable m10514a() {
            return new LogEventParcelable(new PlayLoggerContext(this.f6291a.f6310f, this.f6291a.f6311g, this.f6292b, this.f6293c, this.f6294d, this.f6295e, this.f6291a.f6316l, this.f6296f), this.f6303m, this.f6297g, null, C1854b.m10528d(null), C1854b.m10530e(null), C1854b.m10528d(null), C1854b.m10532f(null), this.f6302l);
        }

        public C1851a m10515a(int i) {
            this.f6303m.f4077e = i;
            return this;
        }

        public C1713d<Status> m10516a(C1767c c1767c) {
            if (this.f6304n) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.f6304n = true;
            PlayLoggerContext playLoggerContext = m10514a().f6279b;
            return this.f6291a.f6322r.mo1559a(playLoggerContext.f7036h, playLoggerContext.f7032d) ? this.f6291a.f6318n.mo1555a(c1767c, m10514a()) : C1867e.m10587a(Status.f6333a);
        }

        public C1851a m10517b(int i) {
            this.f6303m.f4078f = i;
            return this;
        }
    }

    public interface C1852c {
        byte[] m10518a();
    }

    public static class C1853d {
        public long m10519a(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / 1000);
        }
    }

    public C1854b(Context context, int i, String str, String str2, String str3, boolean z, C1720c c1720c, C1970c c1970c, C1853d c1853d, C1849a c1849a, C1730b c1730b) {
        this.f6313i = -1;
        this.f6317m = 0;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.f6309e = applicationContext;
        this.f6310f = context.getPackageName();
        this.f6311g = m10520a(context);
        this.f6313i = i;
        this.f6312h = str;
        this.f6314j = str2;
        this.f6315k = str3;
        this.f6316l = z;
        this.f6318n = c1720c;
        this.f6319o = c1970c;
        if (c1853d == null) {
            c1853d = new C1853d();
        }
        this.f6321q = c1853d;
        this.f6320p = c1849a;
        this.f6317m = 0;
        this.f6322r = c1730b;
        if (this.f6316l) {
            C1896c.m10799b(this.f6314j == null, "can't be anonymous with an upload account");
        }
    }

    public C1854b(Context context, String str, String str2) {
        this(context, -1, str, str2, null, false, f6308d, C1972e.m11087d(), null, C1849a.f6289a, new lw(context));
    }

    private int m10520a(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return i;
        }
    }

    private static int[] m10528d(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            iArr[i] = ((Integer) it.next()).intValue();
            i = i2;
        }
        return iArr;
    }

    private static String[] m10530e(ArrayList<String> arrayList) {
        return arrayList == null ? null : (String[]) arrayList.toArray(new String[0]);
    }

    private static byte[][] m10532f(ArrayList<byte[]> arrayList) {
        return arrayList == null ? null : (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public C1851a m10541a(byte[] bArr) {
        return new C1851a(bArr);
    }
}
