package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.C1959b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class C1943u extends C1939t implements Callback {
    private final HashMap<C1940a, C1942b> f6522a = new HashMap();
    private final Context f6523b;
    private final Handler f6524c;
    private final C1959b f6525d;
    private final long f6526e;

    private static final class C1940a {
        private final String f6510a;
        private final String f6511b;
        private final ComponentName f6512c = null;

        public C1940a(String str, String str2) {
            this.f6510a = C1896c.m10792a(str);
            this.f6511b = C1896c.m10792a(str2);
        }

        public Intent m10958a() {
            return this.f6510a != null ? new Intent(this.f6510a).setPackage(this.f6511b) : new Intent().setComponent(this.f6512c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1940a)) {
                return false;
            }
            C1940a c1940a = (C1940a) obj;
            return C1895b.m10789a(this.f6510a, c1940a.f6510a) && C1895b.m10789a(this.f6512c, c1940a.f6512c);
        }

        public int hashCode() {
            return C1895b.m10787a(this.f6510a, this.f6512c);
        }

        public String toString() {
            return this.f6510a == null ? this.f6512c.flattenToString() : this.f6510a;
        }
    }

    private final class C1942b {
        final /* synthetic */ C1943u f6514a;
        private final C1941a f6515b = new C1941a(this);
        private final Set<ServiceConnection> f6516c = new HashSet();
        private int f6517d = 2;
        private boolean f6518e;
        private IBinder f6519f;
        private final C1940a f6520g;
        private ComponentName f6521h;

        public class C1941a implements ServiceConnection {
            final /* synthetic */ C1942b f6513a;

            public C1941a(C1942b c1942b) {
                this.f6513a = c1942b;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.f6513a.f6514a.f6522a) {
                    this.f6513a.f6519f = iBinder;
                    this.f6513a.f6521h = componentName;
                    for (ServiceConnection onServiceConnected : this.f6513a.f6516c) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    this.f6513a.f6517d = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.f6513a.f6514a.f6522a) {
                    this.f6513a.f6519f = null;
                    this.f6513a.f6521h = componentName;
                    for (ServiceConnection onServiceDisconnected : this.f6513a.f6516c) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    this.f6513a.f6517d = 2;
                }
            }
        }

        public C1942b(C1943u c1943u, C1940a c1940a) {
            this.f6514a = c1943u;
            this.f6520g = c1940a;
        }

        public void m10964a(ServiceConnection serviceConnection, String str) {
            this.f6514a.f6525d.m11051a(this.f6514a.f6523b, serviceConnection, str, this.f6520g.m10958a());
            this.f6516c.add(serviceConnection);
        }

        @TargetApi(14)
        public void m10965a(String str) {
            this.f6517d = 3;
            this.f6518e = this.f6514a.f6525d.m11053a(this.f6514a.f6523b, str, this.f6520g.m10958a(), this.f6515b, 129);
            if (!this.f6518e) {
                this.f6517d = 2;
                try {
                    this.f6514a.f6525d.m11050a(this.f6514a.f6523b, this.f6515b);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public boolean m10966a() {
            return this.f6518e;
        }

        public boolean m10967a(ServiceConnection serviceConnection) {
            return this.f6516c.contains(serviceConnection);
        }

        public int m10968b() {
            return this.f6517d;
        }

        public void m10969b(ServiceConnection serviceConnection, String str) {
            this.f6514a.f6525d.m11054b(this.f6514a.f6523b, serviceConnection);
            this.f6516c.remove(serviceConnection);
        }

        public void m10970b(String str) {
            this.f6514a.f6525d.m11050a(this.f6514a.f6523b, this.f6515b);
            this.f6518e = false;
            this.f6517d = 2;
        }

        public boolean m10971c() {
            return this.f6516c.isEmpty();
        }

        public IBinder m10972d() {
            return this.f6519f;
        }

        public ComponentName m10973e() {
            return this.f6521h;
        }
    }

    C1943u(Context context) {
        this.f6523b = context.getApplicationContext();
        this.f6524c = new Handler(context.getMainLooper(), this);
        this.f6525d = C1959b.m11039a();
        this.f6526e = 5000;
    }

    private boolean m10975a(C1940a c1940a, ServiceConnection serviceConnection, String str) {
        boolean a;
        C1896c.m10791a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f6522a) {
            C1942b c1942b = (C1942b) this.f6522a.get(c1940a);
            if (c1942b != null) {
                this.f6524c.removeMessages(0, c1942b);
                if (!c1942b.m10967a(serviceConnection)) {
                    c1942b.m10964a(serviceConnection, str);
                    switch (c1942b.m10968b()) {
                        case 1:
                            serviceConnection.onServiceConnected(c1942b.m10973e(), c1942b.m10972d());
                            break;
                        case 2:
                            c1942b.m10965a(str);
                            break;
                        default:
                            break;
                    }
                }
                String valueOf = String.valueOf(c1940a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
            }
            c1942b = new C1942b(this, c1940a);
            c1942b.m10964a(serviceConnection, str);
            c1942b.m10965a(str);
            this.f6522a.put(c1940a, c1942b);
            a = c1942b.m10966a();
        }
        return a;
    }

    private void m10977b(C1940a c1940a, ServiceConnection serviceConnection, String str) {
        C1896c.m10791a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f6522a) {
            C1942b c1942b = (C1942b) this.f6522a.get(c1940a);
            String valueOf;
            if (c1942b == null) {
                valueOf = String.valueOf(c1940a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (c1942b.m10967a(serviceConnection)) {
                c1942b.m10969b(serviceConnection, str);
                if (c1942b.m10971c()) {
                    this.f6524c.sendMessageDelayed(this.f6524c.obtainMessage(0, c1942b), this.f6526e);
                }
            } else {
                valueOf = String.valueOf(c1940a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
            }
        }
    }

    public boolean mo1713a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return m10975a(new C1940a(str, str2), serviceConnection, str3);
    }

    public void mo1714b(String str, String str2, ServiceConnection serviceConnection, String str3) {
        m10977b(new C1940a(str, str2), serviceConnection, str3);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                C1942b c1942b = (C1942b) message.obj;
                synchronized (this.f6522a) {
                    if (c1942b.m10971c()) {
                        if (c1942b.m10966a()) {
                            c1942b.m10970b("GmsClientSupervisor");
                        }
                        this.f6522a.remove(c1942b.f6520g);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
