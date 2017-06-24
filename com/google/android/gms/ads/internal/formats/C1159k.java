package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.dh.C1158a;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jz;
import com.google.android.gms.p031b.la;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@id
public class C1159k extends C1158a implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    boolean f3382a = false;
    int f3383b;
    int f3384c;
    private final Object f3385d = new Object();
    private final FrameLayout f3386e;
    private FrameLayout f3387f;
    private Map<String, WeakReference<View>> f3388g = new HashMap();
    private C1132b f3389h;
    private C1142h f3390i;

    public C1159k(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f3386e = frameLayout;
        this.f3387f = frameLayout2;
        C1319u.m7203y().m9377a(this.f3386e, (OnGlobalLayoutListener) this);
        C1319u.m7203y().m9378a(this.f3386e, (OnScrollChangedListener) this);
        this.f3386e.setOnTouchListener(this);
        this.f3386e.setOnClickListener(this);
    }

    int m6461a(int i) {
        return C1120y.m6293a().m7220b(this.f3390i.mo1091f(), i);
    }

    Point m6462a(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        this.f3386e.getLocationOnScreen(iArr);
        return new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
    }

    public C0998a mo1097a(String str) {
        C0998a a;
        synchronized (this.f3385d) {
            Object obj;
            WeakReference weakReference = (WeakReference) this.f3388g.get(str);
            if (weakReference == null) {
                obj = null;
            } else {
                View view = (View) weakReference.get();
            }
            a = C1001b.m5713a(obj);
        }
        return a;
    }

    C1132b m6464a(C1143i c1143i) {
        return c1143i.mo1092a((OnClickListener) this);
    }

    public void mo1098a() {
        synchronized (this.f3385d) {
            if (this.f3387f != null) {
                this.f3387f.removeAllViews();
            }
            this.f3387f = null;
            this.f3388g = null;
            this.f3389h = null;
            this.f3390i = null;
        }
    }

    void m6466a(View view) {
        if (this.f3390i != null) {
            C1142h c = this.f3390i instanceof C1144g ? ((C1144g) this.f3390i).m6438c() : this.f3390i;
            if (c != null) {
                c.mo1089b(view);
            }
        }
    }

    public void mo1099a(C0998a c0998a) {
        synchronized (this.f3385d) {
            m6466a(null);
            Object a = C1001b.m5714a(c0998a);
            if (a instanceof C1143i) {
                if (this.f3387f != null) {
                    this.f3387f.setLayoutParams(new LayoutParams(0, 0));
                    this.f3386e.requestLayout();
                }
                this.f3382a = true;
                final C1143i c1143i = (C1143i) a;
                if (this.f3390i != null && ((Boolean) cq.bk.m7801c()).booleanValue()) {
                    this.f3390i.mo1086a(this.f3386e, this.f3388g);
                }
                if ((this.f3390i instanceof C1144g) && ((C1144g) this.f3390i).m6437b()) {
                    ((C1144g) this.f3390i).m6436a((C1142h) c1143i);
                } else {
                    this.f3390i = c1143i;
                    if (c1143i instanceof C1144g) {
                        ((C1144g) c1143i).m6436a(null);
                    }
                }
                if (((Boolean) cq.bk.m7801c()).booleanValue()) {
                    this.f3387f.setClickable(false);
                }
                this.f3387f.removeAllViews();
                this.f3389h = m6464a(c1143i);
                if (this.f3389h != null) {
                    this.f3388g.put("1007", new WeakReference(this.f3389h.m6327a()));
                    this.f3387f.addView(this.f3389h);
                }
                jz.f5567a.post(new Runnable(this) {
                    final /* synthetic */ C1159k f3381b;

                    public void run() {
                        la d = c1143i.mo1094d();
                        if (d != null && this.f3381b.f3387f != null) {
                            this.f3381b.f3387f.addView(d.mo1503b());
                        }
                    }
                });
                c1143i.mo1093a(this.f3386e, this.f3388g, (OnTouchListener) this, (OnClickListener) this);
                m6466a(this.f3386e);
                return;
            }
            C1324b.m7234d("Not an instance of native engine. This is most likely a transient error");
        }
    }

    public void mo1100a(String str, C0998a c0998a) {
        View view = (View) C1001b.m5714a(c0998a);
        synchronized (this.f3385d) {
            if (view == null) {
                this.f3388g.remove(str);
            } else {
                this.f3388g.put(str, new WeakReference(view));
                view.setOnTouchListener(this);
                view.setClickable(true);
                view.setOnClickListener(this);
            }
        }
    }

    int m6469b() {
        return this.f3386e.getMeasuredWidth();
    }

    Point m6470b(View view) {
        if (this.f3389h == null || !this.f3389h.m6327a().equals(view)) {
            Point point = new Point();
            view.getGlobalVisibleRect(new Rect(), point);
            return point;
        }
        Point point2 = new Point();
        this.f3386e.getGlobalVisibleRect(new Rect(), point2);
        Point point3 = new Point();
        view.getGlobalVisibleRect(new Rect(), point3);
        return new Point(point3.x - point2.x, point3.y - point2.y);
    }

    int m6471c() {
        return this.f3386e.getMeasuredHeight();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r10) {
        /*
        r9 = this;
        r6 = r9.f3385d;
        monitor-enter(r6);
        r0 = r9.f3390i;	 Catch:{ all -> 0x0090 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r6);	 Catch:{ all -> 0x0090 }
    L_0x0008:
        return;
    L_0x0009:
        r3 = new org.json.JSONObject;	 Catch:{ all -> 0x0090 }
        r3.<init>();	 Catch:{ all -> 0x0090 }
        r0 = r9.f3388g;	 Catch:{ all -> 0x0090 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0090 }
        r2 = r0.iterator();	 Catch:{ all -> 0x0090 }
    L_0x0018:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0090 }
        if (r0 == 0) goto L_0x0099;
    L_0x001e:
        r0 = r2.next();	 Catch:{ all -> 0x0090 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0090 }
        r1 = r0.getValue();	 Catch:{ all -> 0x0090 }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x0090 }
        r1 = r1.get();	 Catch:{ all -> 0x0090 }
        r1 = (android.view.View) r1;	 Catch:{ all -> 0x0090 }
        if (r1 == 0) goto L_0x0018;
    L_0x0032:
        r4 = r9.m6470b(r1);	 Catch:{ all -> 0x0090 }
        r5 = new org.json.JSONObject;	 Catch:{ all -> 0x0090 }
        r5.<init>();	 Catch:{ all -> 0x0090 }
        r7 = "width";
        r8 = r1.getWidth();	 Catch:{ JSONException -> 0x0075 }
        r8 = r9.m6461a(r8);	 Catch:{ JSONException -> 0x0075 }
        r5.put(r7, r8);	 Catch:{ JSONException -> 0x0075 }
        r7 = "height";
        r1 = r1.getHeight();	 Catch:{ JSONException -> 0x0075 }
        r1 = r9.m6461a(r1);	 Catch:{ JSONException -> 0x0075 }
        r5.put(r7, r1);	 Catch:{ JSONException -> 0x0075 }
        r1 = "x";
        r7 = r4.x;	 Catch:{ JSONException -> 0x0075 }
        r7 = r9.m6461a(r7);	 Catch:{ JSONException -> 0x0075 }
        r5.put(r1, r7);	 Catch:{ JSONException -> 0x0075 }
        r1 = "y";
        r4 = r4.y;	 Catch:{ JSONException -> 0x0075 }
        r4 = r9.m6461a(r4);	 Catch:{ JSONException -> 0x0075 }
        r5.put(r1, r4);	 Catch:{ JSONException -> 0x0075 }
        r1 = r0.getKey();	 Catch:{ JSONException -> 0x0075 }
        r1 = (java.lang.String) r1;	 Catch:{ JSONException -> 0x0075 }
        r3.put(r1, r5);	 Catch:{ JSONException -> 0x0075 }
        goto L_0x0018;
    L_0x0075:
        r1 = move-exception;
        r1 = "Unable to get view rectangle for view ";
        r0 = r0.getKey();	 Catch:{ all -> 0x0090 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0090 }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x0090 }
        r4 = r0.length();	 Catch:{ all -> 0x0090 }
        if (r4 == 0) goto L_0x0093;
    L_0x0088:
        r0 = r1.concat(r0);	 Catch:{ all -> 0x0090 }
    L_0x008c:
        com.google.android.gms.ads.internal.util.client.C1324b.m7234d(r0);	 Catch:{ all -> 0x0090 }
        goto L_0x0018;
    L_0x0090:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0090 }
        throw r0;
    L_0x0093:
        r0 = new java.lang.String;	 Catch:{ all -> 0x0090 }
        r0.<init>(r1);	 Catch:{ all -> 0x0090 }
        goto L_0x008c;
    L_0x0099:
        r4 = new org.json.JSONObject;	 Catch:{ all -> 0x0090 }
        r4.<init>();	 Catch:{ all -> 0x0090 }
        r0 = "x";
        r1 = r9.f3383b;	 Catch:{ JSONException -> 0x0103 }
        r1 = r9.m6461a(r1);	 Catch:{ JSONException -> 0x0103 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0103 }
        r0 = "y";
        r1 = r9.f3384c;	 Catch:{ JSONException -> 0x0103 }
        r1 = r9.m6461a(r1);	 Catch:{ JSONException -> 0x0103 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x0103 }
    L_0x00b4:
        r5 = new org.json.JSONObject;	 Catch:{ all -> 0x0090 }
        r5.<init>();	 Catch:{ all -> 0x0090 }
        r0 = "width";
        r1 = r9.m6469b();	 Catch:{ JSONException -> 0x010a }
        r1 = r9.m6461a(r1);	 Catch:{ JSONException -> 0x010a }
        r5.put(r0, r1);	 Catch:{ JSONException -> 0x010a }
        r0 = "height";
        r1 = r9.m6471c();	 Catch:{ JSONException -> 0x010a }
        r1 = r9.m6461a(r1);	 Catch:{ JSONException -> 0x010a }
        r5.put(r0, r1);	 Catch:{ JSONException -> 0x010a }
    L_0x00d3:
        r0 = r9.f3389h;	 Catch:{ all -> 0x0090 }
        if (r0 == 0) goto L_0x0119;
    L_0x00d7:
        r0 = r9.f3389h;	 Catch:{ all -> 0x0090 }
        r0 = r0.m6327a();	 Catch:{ all -> 0x0090 }
        r0 = r0.equals(r10);	 Catch:{ all -> 0x0090 }
        if (r0 == 0) goto L_0x0119;
    L_0x00e3:
        r0 = r9.f3390i;	 Catch:{ all -> 0x0090 }
        r0 = r0 instanceof com.google.android.gms.ads.internal.formats.C1144g;	 Catch:{ all -> 0x0090 }
        if (r0 == 0) goto L_0x0111;
    L_0x00e9:
        r0 = r9.f3390i;	 Catch:{ all -> 0x0090 }
        r0 = (com.google.android.gms.ads.internal.formats.C1144g) r0;	 Catch:{ all -> 0x0090 }
        r0 = r0.m6438c();	 Catch:{ all -> 0x0090 }
        if (r0 == 0) goto L_0x0111;
    L_0x00f3:
        r0 = r9.f3390i;	 Catch:{ all -> 0x0090 }
        r0 = (com.google.android.gms.ads.internal.formats.C1144g) r0;	 Catch:{ all -> 0x0090 }
        r0 = r0.m6438c();	 Catch:{ all -> 0x0090 }
        r1 = "1007";
        r0.mo1088a(r1, r3, r4, r5);	 Catch:{ all -> 0x0090 }
    L_0x0100:
        monitor-exit(r6);	 Catch:{ all -> 0x0090 }
        goto L_0x0008;
    L_0x0103:
        r0 = move-exception;
        r0 = "Unable to get click location";
        com.google.android.gms.ads.internal.util.client.C1324b.m7234d(r0);	 Catch:{ all -> 0x0090 }
        goto L_0x00b4;
    L_0x010a:
        r0 = move-exception;
        r0 = "Unable to get native ad view bounding box";
        com.google.android.gms.ads.internal.util.client.C1324b.m7234d(r0);	 Catch:{ all -> 0x0090 }
        goto L_0x00d3;
    L_0x0111:
        r0 = r9.f3390i;	 Catch:{ all -> 0x0090 }
        r1 = "1007";
        r0.mo1088a(r1, r3, r4, r5);	 Catch:{ all -> 0x0090 }
        goto L_0x0100;
    L_0x0119:
        r0 = r9.f3390i;	 Catch:{ all -> 0x0090 }
        r2 = r9.f3388g;	 Catch:{ all -> 0x0090 }
        r1 = r10;
        r0.mo1087a(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0090 }
        goto L_0x0100;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.formats.k.onClick(android.view.View):void");
    }

    public void onGlobalLayout() {
        synchronized (this.f3385d) {
            if (this.f3382a) {
                int b = m6469b();
                int c = m6471c();
                if (!(b == 0 || c == 0 || this.f3387f == null)) {
                    this.f3387f.setLayoutParams(new LayoutParams(b, c));
                    this.f3382a = false;
                }
            }
            if (this.f3390i != null) {
                this.f3390i.mo1085a(this.f3386e);
            }
        }
    }

    public void onScrollChanged() {
        synchronized (this.f3385d) {
            if (this.f3390i != null) {
                this.f3390i.mo1085a(this.f3386e);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.f3385d) {
            if (this.f3390i == null) {
            } else {
                Point a = m6462a(motionEvent);
                this.f3383b = a.x;
                this.f3384c = a.y;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation((float) a.x, (float) a.y);
                this.f3390i.mo1084a(obtain);
                obtain.recycle();
            }
        }
        return false;
    }
}
