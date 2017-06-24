package com.google.android.gms.p031b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.lb.C1148a;

@id
public class ho implements Runnable {
    protected final la f5039a;
    protected boolean f5040b;
    protected boolean f5041c;
    private final Handler f5042d;
    private final long f5043e;
    private long f5044f;
    private C1148a f5045g;
    private final int f5046h;
    private final int f5047i;

    protected final class C1575a extends AsyncTask<Void, Void, Boolean> {
        final /* synthetic */ ho f5036a;
        private final WebView f5037b;
        private Bitmap f5038c;

        public C1575a(ho hoVar, WebView webView) {
            this.f5036a = hoVar;
            this.f5037b = webView;
        }

        protected synchronized Boolean m8743a(Void... voidArr) {
            Boolean valueOf;
            int width = this.f5038c.getWidth();
            int height = this.f5038c.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.f5038c.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        protected void m8744a(Boolean bool) {
            ho.m8747c(this.f5036a);
            if (bool.booleanValue() || this.f5036a.m8756c() || this.f5036a.f5044f <= 0) {
                this.f5036a.f5041c = bool.booleanValue();
                this.f5036a.f5045g.mo1096a(this.f5036a.f5039a, true);
            } else if (this.f5036a.f5044f > 0) {
                if (C1324b.m7229a(2)) {
                    C1324b.m7227a("Ad not detected, scheduling another run.");
                }
                this.f5036a.f5042d.postDelayed(this.f5036a, this.f5036a.f5043e);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m8743a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m8744a((Boolean) obj);
        }

        protected synchronized void onPreExecute() {
            this.f5038c = Bitmap.createBitmap(this.f5036a.f5047i, this.f5036a.f5046h, Config.ARGB_8888);
            this.f5037b.setVisibility(0);
            this.f5037b.measure(MeasureSpec.makeMeasureSpec(this.f5036a.f5047i, 0), MeasureSpec.makeMeasureSpec(this.f5036a.f5046h, 0));
            this.f5037b.layout(0, 0, this.f5036a.f5047i, this.f5036a.f5046h);
            this.f5037b.draw(new Canvas(this.f5038c));
            this.f5037b.invalidate();
        }
    }

    public ho(C1148a c1148a, la laVar, int i, int i2) {
        this(c1148a, laVar, i, i2, 200, 50);
    }

    public ho(C1148a c1148a, la laVar, int i, int i2, long j, long j2) {
        this.f5043e = j;
        this.f5044f = j2;
        this.f5042d = new Handler(Looper.getMainLooper());
        this.f5039a = laVar;
        this.f5045g = c1148a;
        this.f5040b = false;
        this.f5041c = false;
        this.f5046h = i2;
        this.f5047i = i;
    }

    static /* synthetic */ long m8747c(ho hoVar) {
        long j = hoVar.f5044f - 1;
        hoVar.f5044f = j;
        return j;
    }

    public void m8752a() {
        this.f5042d.postDelayed(this, this.f5043e);
    }

    public void m8753a(AdResponseParcel adResponseParcel) {
        m8754a(adResponseParcel, new lk(this, this.f5039a, adResponseParcel.f3795q));
    }

    public void m8754a(AdResponseParcel adResponseParcel, lk lkVar) {
        this.f5039a.setWebViewClient(lkVar);
        this.f5039a.loadDataWithBaseURL(TextUtils.isEmpty(adResponseParcel.f3780b) ? null : C1319u.m7183e().m9207a(adResponseParcel.f3780b), adResponseParcel.f3781c, "text/html", "UTF-8", null);
    }

    public synchronized void m8755b() {
        this.f5040b = true;
    }

    public synchronized boolean m8756c() {
        return this.f5040b;
    }

    public boolean m8757d() {
        return this.f5041c;
    }

    public void run() {
        if (this.f5039a == null || m8756c()) {
            this.f5045g.mo1096a(this.f5039a, true);
        } else {
            new C1575a(this, this.f5039a.mo1492a()).execute(new Void[0]);
        }
    }
}
