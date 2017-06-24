package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class C2115b extends Service {
    MessengerCompat f7090a = new MessengerCompat(new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ C2115b f7099a;

        public void handleMessage(Message message) {
            int a = MessengerCompat.m11182a(message);
            C2123f.m12167a(this.f7099a);
            this.f7099a.getPackageManager();
            if (a == C2123f.f7116c || a == C2123f.f7115b) {
                this.f7099a.mo1776b((Intent) message.obj);
                return;
            }
            int i = C2123f.f7115b;
            Log.w("FirebaseInstanceId", "Message from unexpected caller " + a + " mine=" + i + " appid=" + C2123f.f7116c);
        }
    });
    final ExecutorService f7091b = Executors.newSingleThreadExecutor();
    private final Object f7092c = new Object();
    private int f7093d;
    private int f7094e = 0;

    protected int mo1775a(final Intent intent) {
        this.f7091b.execute(new Runnable(this) {
            final /* synthetic */ C2115b f7101b;

            public void run() {
                this.f7101b.mo1776b(intent);
                this.f7101b.m12130b();
            }
        });
        return 3;
    }

    protected void m12130b() {
        synchronized (this.f7092c) {
            this.f7094e--;
            if (this.f7094e == 0) {
                m12132b(this.f7093d);
            }
        }
    }

    public abstract void mo1776b(Intent intent);

    boolean m12132b(int i) {
        return stopSelfResult(i);
    }

    protected abstract Intent mo1777c(Intent intent);

    public final IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.firebase.INSTANCE_ID_EVENT".equals(intent.getAction())) ? null : this.f7090a.m11184a();
    }

    public final int onStartCommand(android.content.Intent r4, int r5, int r6) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r1 = r3.f7092c;
        monitor-enter(r1);
        r3.f7093d = r6;
        r0 = r3.f7094e;
        r0 = r0 + 1;
        r3.f7094e = r0;
        monitor-exit(r1);
        r1 = r3.mo1777c(r4);
        if (r1 != 0) goto L_0x001a;
    L_0x0012:
        r3.m12130b();
        r0 = 2;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x001a:
        r0 = r3.mo1775a(r1);	 Catch:{ all -> 0x002a }
        r2 = "from";
        r2 = r1.getStringExtra(r2);
        if (r2 == 0) goto L_0x0016;
    L_0x0026:
        android.support.v4.p010b.C0305j.m1707a(r1);
        goto L_0x0016;
    L_0x002a:
        r0 = move-exception;
        r2 = "from";
        r2 = r1.getStringExtra(r2);
        if (r2 == 0) goto L_0x0036;
    L_0x0033:
        android.support.v4.p010b.C0305j.m1707a(r1);
    L_0x0036:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.b.onStartCommand(android.content.Intent, int, int):int");
    }
}
