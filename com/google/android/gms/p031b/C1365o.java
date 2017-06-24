package com.google.android.gms.p031b;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.p031b.C1493f.C1487a;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class C1365o implements C1165n {
    protected MotionEvent f4100a;
    protected LinkedList<MotionEvent> f4101b = new LinkedList();
    protected long f4102c = 0;
    protected long f4103d = 0;
    protected long f4104e = 0;
    protected long f4105f = 0;
    protected long f4106g = 0;
    protected DisplayMetrics f4107h;
    private boolean f4108i = false;

    protected C1365o(Context context) {
        C1597i.m8853a();
        try {
            this.f4107h = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.f4107h = new DisplayMetrics();
            this.f4107h.density = 1.0f;
        }
    }

    private String m7404a(Context context, String str, boolean z) {
        boolean z2 = true;
        if (z) {
            try {
                C1487a c = mo1237c(context);
                this.f4108i = true;
            } catch (NoSuchAlgorithmException e) {
                return Integer.toString(7);
            } catch (UnsupportedEncodingException e2) {
                return Integer.toString(7);
            } catch (Throwable th) {
                return Integer.toString(3);
            }
        }
        c = mo1236b(context);
        if (c == null || c.m7349f() == 0) {
            return Integer.toString(5);
        }
        if (C1365o.m7406a(z)) {
            z2 = false;
        }
        return C1597i.m8848a(c, str, z2);
    }

    private void m7405a() {
        if (((Boolean) cq.aW.m7801c()).booleanValue()) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int i = 0;
            int length = stackTrace.length - 1;
            while (length >= 0) {
                i++;
                if (stackTrace[length].toString().startsWith("com.google.android.ads.") || stackTrace[length].toString().startsWith("com.google.android.gms.")) {
                    break;
                }
                length--;
            }
            this.f4106g = (long) i;
        }
    }

    private static boolean m7406a(boolean z) {
        return !((Boolean) cq.aO.m7801c()).booleanValue() ? true : ((Boolean) cq.aX.m7801c()).booleanValue() && z;
    }

    public String mo1102a(Context context) {
        return m7404a(context, null, false);
    }

    public String mo1103a(Context context, String str) {
        return m7404a(context, str, true);
    }

    public void mo1104a(int i, int i2, int i3) {
        if (this.f4100a != null) {
            this.f4100a.recycle();
        }
        this.f4100a = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.f4107h.density, ((float) i2) * this.f4107h.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    public void mo1105a(MotionEvent motionEvent) {
        if (this.f4108i) {
            this.f4105f = 0;
            this.f4104e = 0;
            this.f4103d = 0;
            this.f4102c = 0;
            this.f4106g = 0;
            Iterator it = this.f4101b.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.f4101b.clear();
            this.f4100a = null;
            this.f4108i = false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f4102c++;
                return;
            case 1:
                this.f4100a = MotionEvent.obtain(motionEvent);
                this.f4101b.add(this.f4100a);
                if (this.f4101b.size() > 6) {
                    ((MotionEvent) this.f4101b.remove()).recycle();
                }
                this.f4104e++;
                m7405a();
                return;
            case 2:
                this.f4103d += (long) (motionEvent.getHistorySize() + 1);
                return;
            case 3:
                this.f4105f++;
                return;
            default:
                return;
        }
    }

    protected abstract C1487a mo1236b(Context context);

    protected abstract C1487a mo1237c(Context context);
}
