package com.google.firebase.iid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.google.firebase.C2112a;

public class FirebaseInstanceIdService extends C2115b {
    private static BroadcastReceiver f7095c;
    private static final Object f7096d = new Object();
    private static boolean f7097e = false;
    private boolean f7098f = false;

    private C2120d m12135a(String str) {
        if (str == null) {
            return C2120d.m12156a(this, null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", str);
        return C2120d.m12156a(this, bundle);
    }

    static void m12136a(Context context) {
        if (C2123f.m12167a(context) != null) {
            synchronized (f7096d) {
                if (!f7097e) {
                    context.sendBroadcast(m12144c(0));
                    f7097e = true;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m12137a(android.content.Context r2, com.google.firebase.iid.FirebaseInstanceId r3) {
        /*
        r1 = f7096d;
        monitor-enter(r1);
        r0 = f7097e;	 Catch:{ all -> 0x001e }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x001e }
    L_0x0008:
        return;
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x001e }
        r0 = r3.m12120e();
        if (r0 == 0) goto L_0x001a;
    L_0x0010:
        r0 = r3.m12122g();
        r0 = r0.m12165a();
        if (r0 == 0) goto L_0x0008;
    L_0x001a:
        m12136a(r2);
        goto L_0x0008;
    L_0x001e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.a(android.content.Context, com.google.firebase.iid.FirebaseInstanceId):void");
    }

    private void m12138a(Intent intent, String str) {
        boolean c = m12145c((Context) this);
        final int b = m12142b(intent, c);
        Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(str).length() + 47).append("background sync failed: ").append(str).append(", retry in ").append(b).append("s").toString());
        synchronized (f7096d) {
            m12146d(b);
            f7097e = true;
        }
        if (!c) {
            if (this.f7098f) {
                Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
            }
            if (f7095c == null) {
                f7095c = new BroadcastReceiver(this) {
                    final /* synthetic */ FirebaseInstanceIdService f7089b;

                    public void onReceive(Context context, Intent intent) {
                        if (FirebaseInstanceIdService.m12145c(context)) {
                            if (this.f7089b.f7098f) {
                                Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
                            }
                            this.f7089b.getApplicationContext().unregisterReceiver(this);
                            context.sendBroadcast(FirebaseInstanceIdService.m12144c(b));
                        }
                    }
                };
            }
            getApplicationContext().registerReceiver(f7095c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12139a(android.content.Intent r9, boolean r10) {
        /*
        r8 = this;
        r2 = 1;
        r1 = 0;
        r3 = f7096d;
        monitor-enter(r3);
        r0 = 0;
        f7097e = r0;	 Catch:{ all -> 0x0010 }
        monitor-exit(r3);	 Catch:{ all -> 0x0010 }
        r0 = com.google.firebase.iid.C2123f.m12167a(r8);
        if (r0 != 0) goto L_0x0013;
    L_0x000f:
        return;
    L_0x0010:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0010 }
        throw r0;
    L_0x0013:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m12106a();
        r4 = r0.m12122g();
        r3 = r0.m12120e();
        if (r3 != 0) goto L_0x0051;
    L_0x0021:
        r1 = r0.m12121f();	 Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
        if (r1 == 0) goto L_0x0042;
    L_0x0027:
        r1 = r8.f7098f;	 Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
        if (r1 == 0) goto L_0x0032;
    L_0x002b:
        r1 = "FirebaseInstanceId";
        r2 = "get master token succeeded";
        android.util.Log.d(r1, r2);	 Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
    L_0x0032:
        m12137a(r8, r0);	 Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
        r8.m12149a();	 Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
        goto L_0x000f;
    L_0x0039:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.m12138a(r9, r0);
        goto L_0x000f;
    L_0x0042:
        r0 = "returned token is null";
        r8.m12138a(r9, r0);	 Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
        goto L_0x000f;
    L_0x0048:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = "Unable to get master token";
        android.util.Log.e(r1, r2, r0);
        goto L_0x000f;
    L_0x0051:
        r0 = r4.m12165a();
        r3 = r0;
    L_0x0056:
        if (r3 == 0) goto L_0x00be;
    L_0x0058:
        r0 = "!";
        r0 = r3.split(r0);
        r5 = r0.length;
        r6 = 2;
        if (r5 != r6) goto L_0x0071;
    L_0x0062:
        r5 = r0[r1];
        r6 = r0[r2];
        r0 = -1;
        r7 = r5.hashCode();	 Catch:{ IOException -> 0x00a1 }
        switch(r7) {
            case 83: goto L_0x007a;
            case 84: goto L_0x006e;
            case 85: goto L_0x0084;
            default: goto L_0x006e;
        };
    L_0x006e:
        switch(r0) {
            case 0: goto L_0x008e;
            case 1: goto L_0x00ab;
            default: goto L_0x0071;
        };
    L_0x0071:
        r4.m12166a(r3);
        r0 = r4.m12165a();
        r3 = r0;
        goto L_0x0056;
    L_0x007a:
        r7 = "S";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x00a1 }
        if (r5 == 0) goto L_0x006e;
    L_0x0082:
        r0 = r1;
        goto L_0x006e;
    L_0x0084:
        r7 = "U";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x00a1 }
        if (r5 == 0) goto L_0x006e;
    L_0x008c:
        r0 = r2;
        goto L_0x006e;
    L_0x008e:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m12106a();	 Catch:{ IOException -> 0x00a1 }
        r0.m12115a(r6);	 Catch:{ IOException -> 0x00a1 }
        r0 = r8.f7098f;	 Catch:{ IOException -> 0x00a1 }
        if (r0 == 0) goto L_0x0071;
    L_0x0099:
        r0 = "FirebaseInstanceId";
        r5 = "subscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x00a1 }
        goto L_0x0071;
    L_0x00a1:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.m12138a(r9, r0);
        goto L_0x000f;
    L_0x00ab:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m12106a();	 Catch:{ IOException -> 0x00a1 }
        r0.m12117b(r6);	 Catch:{ IOException -> 0x00a1 }
        r0 = r8.f7098f;	 Catch:{ IOException -> 0x00a1 }
        if (r0 == 0) goto L_0x0071;
    L_0x00b6:
        r0 = "FirebaseInstanceId";
        r5 = "unsubscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x00a1 }
        goto L_0x0071;
    L_0x00be:
        r0 = "FirebaseInstanceId";
        r1 = "topic sync succeeded";
        android.util.Log.d(r0, r1);
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.a(android.content.Intent, boolean):void");
    }

    private void m12140a(C2123f c2123f, Bundle bundle) {
        String a = C2123f.m12167a((Context) this);
        if (a == null) {
            Log.w("FirebaseInstanceId", "Unable to respond to ping due to missing target package");
            return;
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        intent.setPackage(a);
        intent.putExtras(bundle);
        c2123f.m12178a(intent);
        intent.putExtra("google.to", "google.com/iid");
        intent.putExtra("google.message_id", C2123f.m12175b());
        sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    private int m12142b(Intent intent, boolean z) {
        int intExtra = intent == null ? 10 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        return (intExtra >= 10 || z) ? intExtra >= 10 ? intExtra > 28800 ? 28800 : intExtra : 10 : 30;
    }

    private static Intent m12144c(int i) {
        Context a = C2112a.m12096d().m12099a();
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", i);
        return FirebaseInstanceIdInternalReceiver.m12125b(a, intent);
    }

    private static boolean m12145c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void m12146d(int i) {
        ((AlarmManager) getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) (i * 1000)), PendingIntent.getBroadcast(this, 0, m12144c(i * 2), 268435456));
    }

    private String m12147e(Intent intent) {
        String stringExtra = intent.getStringExtra("subtype");
        return stringExtra == null ? "" : stringExtra;
    }

    protected int mo1775a(Intent intent) {
        this.f7098f = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            return super.mo1775a(intent);
        }
        String e = m12147e(intent);
        if (this.f7098f) {
            String str = "FirebaseInstanceId";
            String str2 = "Register result in service ";
            String valueOf = String.valueOf(e);
            Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        m12135a(e).m12163d().m12184d(intent);
        m12130b();
        return 2;
    }

    public void m12149a() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1776b(android.content.Intent r5) {
        /*
        r4 = this;
        r1 = 0;
        r0 = r5.getAction();
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        r0 = "";
    L_0x0009:
        r2 = -1;
        r3 = r0.hashCode();
        switch(r3) {
            case -1737547627: goto L_0x0019;
            default: goto L_0x0011;
        };
    L_0x0011:
        r0 = r2;
    L_0x0012:
        switch(r0) {
            case 0: goto L_0x0023;
            default: goto L_0x0015;
        };
    L_0x0015:
        r4.m12152d(r5);
    L_0x0018:
        return;
    L_0x0019:
        r3 = "ACTION_TOKEN_REFRESH_RETRY";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0011;
    L_0x0021:
        r0 = r1;
        goto L_0x0012;
    L_0x0023:
        r4.m12139a(r5, r1);
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.b(android.content.Intent):void");
    }

    protected Intent mo1777c(Intent intent) {
        return FirebaseInstanceIdInternalReceiver.m12124a();
    }

    public void m12152d(Intent intent) {
        String e = m12147e(intent);
        C2120d a = m12135a(e);
        String stringExtra = intent.getStringExtra("CMD");
        if (this.f7098f) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("FirebaseInstanceId", new StringBuilder(((String.valueOf(e).length() + 18) + String.valueOf(stringExtra).length()) + String.valueOf(valueOf).length()).append("Service command ").append(e).append(" ").append(stringExtra).append(" ").append(valueOf).toString());
        }
        if (intent.getStringExtra("unregistered") != null) {
            C2124g c = a.m12161c();
            if (e == null) {
                e = "";
            }
            c.m12200e(e);
            a.m12163d().m12184d(intent);
        } else if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
            a.m12161c().m12200e(e);
            m12139a(intent, false);
        } else if ("RST".equals(stringExtra)) {
            a.m12160b();
            a.m12161c().m12200e(e);
            m12139a(intent, true);
        } else if ("RST_FULL".equals(stringExtra)) {
            if (!a.m12161c().m12196b()) {
                a.m12160b();
                a.m12161c().m12198c();
                m12139a(intent, true);
            }
        } else if ("SYNC".equals(stringExtra)) {
            a.m12161c().m12200e(e);
            m12139a(intent, false);
        } else if ("PING".equals(stringExtra)) {
            m12140a(a.m12163d(), intent.getExtras());
        }
    }
}
