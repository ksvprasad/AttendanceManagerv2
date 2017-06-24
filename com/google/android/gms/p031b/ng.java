package com.google.android.gms.p031b;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.C1458f;
import com.google.android.gms.common.api.C1713d;
import com.google.android.gms.common.api.C1767c;
import com.google.android.gms.common.api.C1779k;
import com.google.android.gms.common.api.C1780h;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.C1868i;
import com.google.android.gms.common.api.C1869j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1896c;
import java.lang.ref.WeakReference;

public class ng<R extends C1857g> extends C1779k<R> implements C1780h<R> {
    private C1869j<? super R, ? extends C1857g> f6034a;
    private ng<? extends C1857g> f6035b;
    private volatile C1868i<? super R> f6036c;
    private C1713d<R> f6037d;
    private final Object f6038e;
    private Status f6039f;
    private final WeakReference<C1767c> f6040g;
    private final C1778a f6041h;
    private boolean f6042i;

    private final class C1778a extends Handler {
        final /* synthetic */ ng f6033a;

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    C1713d c1713d = (C1713d) message.obj;
                    synchronized (this.f6033a.f6038e) {
                        if (c1713d == null) {
                            this.f6033a.f6035b.m10115a(new Status(13, "Transform returned null"));
                        } else if (c1713d instanceof nc) {
                            this.f6033a.f6035b.m10115a(((nc) c1713d).m10093b());
                        } else {
                            this.f6033a.f6035b.m10125a(c1713d);
                        }
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    String str = "TransformedResultImpl";
                    String str2 = "Runtime exception on the transformation worker thread: ";
                    String valueOf = String.valueOf(runtimeException.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
                    return;
            }
        }
    }

    private void m10115a(Status status) {
        synchronized (this.f6038e) {
            this.f6039f = status;
            m10118b(this.f6039f);
        }
    }

    private void m10117b() {
        if (this.f6034a != null || this.f6036c != null) {
            C1767c c1767c = (C1767c) this.f6040g.get();
            if (!(this.f6042i || this.f6034a == null || c1767c == null)) {
                c1767c.mo1607a(this);
                this.f6042i = true;
            }
            if (this.f6039f != null) {
                m10118b(this.f6039f);
            } else if (this.f6037d != null) {
                this.f6037d.mo1548a((C1780h) this);
            }
        }
    }

    private void m10118b(Status status) {
        synchronized (this.f6038e) {
            if (this.f6034a != null) {
                Status a = this.f6034a.m10590a(status);
                C1896c.m10791a((Object) a, (Object) "onFailure must not return null");
                this.f6035b.m10115a(a);
            } else if (m10121c()) {
                this.f6036c.m10588a(status);
            }
        }
    }

    private void m10119b(C1857g c1857g) {
        if (c1857g instanceof C1458f) {
            try {
                ((C1458f) c1857g).mo1308a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(c1857g);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private boolean m10121c() {
        return (this.f6036c == null || ((C1767c) this.f6040g.get()) == null) ? false : true;
    }

    void m10124a() {
        this.f6036c = null;
    }

    public void m10125a(C1713d<?> c1713d) {
        synchronized (this.f6038e) {
            this.f6037d = c1713d;
            m10117b();
        }
    }

    public void mo1621a(final R r) {
        synchronized (this.f6038e) {
            if (!r.mo1642a().m10565e()) {
                m10115a(r.mo1642a());
                m10119b((C1857g) r);
            } else if (this.f6034a != null) {
                nb.m10089a().submit(new Runnable(this) {
                    final /* synthetic */ ng f6032b;

                    public void run() {
                        C1767c c1767c;
                        try {
                            me.f5781a.set(Boolean.valueOf(true));
                            this.f6032b.f6041h.sendMessage(this.f6032b.f6041h.obtainMessage(0, this.f6032b.f6034a.m10591a(r)));
                            me.f5781a.set(Boolean.valueOf(false));
                            this.f6032b.m10119b(r);
                            c1767c = (C1767c) this.f6032b.f6040g.get();
                            if (c1767c != null) {
                                c1767c.mo1612b(this.f6032b);
                            }
                        } catch (RuntimeException e) {
                            this.f6032b.f6041h.sendMessage(this.f6032b.f6041h.obtainMessage(1, e));
                            me.f5781a.set(Boolean.valueOf(false));
                            this.f6032b.m10119b(r);
                            c1767c = (C1767c) this.f6032b.f6040g.get();
                            if (c1767c != null) {
                                c1767c.mo1612b(this.f6032b);
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            me.f5781a.set(Boolean.valueOf(false));
                            this.f6032b.m10119b(r);
                            c1767c = (C1767c) this.f6032b.f6040g.get();
                            if (c1767c != null) {
                                c1767c.mo1612b(this.f6032b);
                            }
                        }
                    }
                });
            } else if (m10121c()) {
                this.f6036c.m10589b(r);
            }
        }
    }
}
