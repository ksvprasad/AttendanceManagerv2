package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class C2123f {
    static String f7114a = null;
    static int f7115b = 0;
    static int f7116c = 0;
    static int f7117d = 0;
    Context f7118e;
    Map<String, Object> f7119f = new HashMap();
    Messenger f7120g;
    Messenger f7121h;
    MessengerCompat f7122i;
    PendingIntent f7123j;
    long f7124k;
    long f7125l;
    int f7126m;
    int f7127n;
    long f7128o;

    public C2123f(Context context) {
        this.f7118e = context;
    }

    public static String m12167a(Context context) {
        if (f7114a != null) {
            return f7114a;
        }
        f7115b = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo.uid);
                    f7116c = applicationInfo.uid;
                    f7114a = resolveInfo.serviceInfo.packageName;
                    return f7114a;
                } catch (NameNotFoundException e) {
                }
            } else {
                String valueOf = String.valueOf(resolveInfo.serviceInfo.packageName);
                String valueOf2 = String.valueOf("com.google.android.c2dm.intent.REGISTER");
                Log.w("InstanceID/Rpc", new StringBuilder((String.valueOf(valueOf).length() + 56) + String.valueOf(valueOf2).length()).append("Possible malicious package ").append(valueOf).append(" declares ").append(valueOf2).append(" without permission").toString());
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        ApplicationInfo applicationInfo2;
        try {
            applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gms", 0);
            f7114a = applicationInfo2.packageName;
            f7116c = applicationInfo2.uid;
            return f7114a;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                f7114a = applicationInfo2.packageName;
                f7116c = applicationInfo2.uid;
                return f7114a;
            } catch (NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    static String m12168a(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = FirebaseInstanceId.m12109a(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    private void m12169a(Object obj) {
        synchronized (getClass()) {
            for (String str : this.f7119f.keySet()) {
                Object obj2 = this.f7119f.get(str);
                this.f7119f.put(str, obj);
                m12170a(obj2, obj);
            }
        }
    }

    private void m12170a(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to send response ").append(valueOf).toString());
            }
        }
    }

    private void m12171a(String str) {
        if ("com.google.android.gsf".equals(f7114a)) {
            this.f7126m++;
            if (this.f7126m >= 3) {
                if (this.f7126m == 3) {
                    this.f7127n = new Random().nextInt(1000) + 1000;
                }
                this.f7127n *= 2;
                this.f7128o = SystemClock.elapsedRealtime() + ((long) this.f7127n);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 31).append("Backoff due to ").append(str).append(" for ").append(this.f7127n).toString());
            }
        }
    }

    private void m12172a(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.f7119f.get(str);
            this.f7119f.put(str, obj);
            m12170a(obj2, obj);
        }
    }

    private static int m12173b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(C2123f.m12167a(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    private Intent m12174b(Bundle bundle, KeyPair keyPair) {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String b = C2123f.m12175b();
        synchronized (getClass()) {
            this.f7119f.put(b, conditionVariable);
        }
        m12180a(bundle, keyPair, b);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.f7119f.remove(b);
            if (remove instanceof Intent) {
                intent = (Intent) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                String valueOf = String.valueOf(remove);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 12).append("No response ").append(valueOf).toString());
                throw new IOException("TIMEOUT");
            }
        }
        return intent;
    }

    public static synchronized String m12175b() {
        String num;
        synchronized (C2123f.class) {
            int i = f7117d;
            f7117d = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    Intent m12176a(Bundle bundle, KeyPair keyPair) {
        Intent b = m12174b(bundle, keyPair);
        return (b == null || !b.hasExtra("google.messenger")) ? b : m12174b(bundle, keyPair);
    }

    void m12177a() {
        if (this.f7120g == null) {
            C2123f.m12167a(this.f7118e);
            this.f7120g = new Messenger(new Handler(this, Looper.getMainLooper()) {
                final /* synthetic */ C2123f f7113a;

                public void handleMessage(Message message) {
                    this.f7113a.m12181a(message);
                }
            });
        }
    }

    synchronized void m12178a(Intent intent) {
        if (this.f7123j == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f7123j = PendingIntent.getBroadcast(this.f7118e, 0, intent2, 0);
        }
        intent.putExtra("app", this.f7123j);
    }

    protected void m12179a(Intent intent, String str) {
        this.f7124k = SystemClock.elapsedRealtime();
        intent.putExtra("kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        intent.putExtra("X-kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        boolean equals = "com.google.android.gsf".equals(f7114a);
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf).toString());
        }
        if (equals) {
            this.f7118e.startService(intent);
            return;
        }
        intent.putExtra("google.messenger", this.f7120g);
        if (!(this.f7121h == null && this.f7122i == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                if (this.f7121h != null) {
                    this.f7121h.send(obtain);
                    return;
                } else {
                    this.f7122i.m11185b(obtain);
                    return;
                }
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.f7118e.startService(intent);
    }

    public void m12180a(Bundle bundle, KeyPair keyPair, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f7128o == 0 || elapsedRealtime > this.f7128o) {
            m12177a();
            if (f7114a == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.f7124k = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(f7114a);
            bundle.putString("gmsv", Integer.toString(C2123f.m12173b(this.f7118e)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(FirebaseInstanceId.m12111b(this.f7118e)));
            bundle.putString("app_ver_name", FirebaseInstanceId.m12112c(this.f7118e));
            bundle.putString("cliv", "fiid-9452000");
            bundle.putString("appid", FirebaseInstanceId.m12108a(keyPair));
            String a = FirebaseInstanceId.m12107a(this.f7118e);
            if (a != null) {
                bundle.putString("gmp_app_id", a);
            }
            bundle.putString("pub2", FirebaseInstanceId.m12109a(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", C2123f.m12168a(keyPair, this.f7118e.getPackageName(), a));
            intent.putExtras(bundle);
            m12178a(intent);
            m12179a(intent, str);
            return;
        }
        elapsedRealtime = this.f7128o - elapsedRealtime;
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + elapsedRealtime + " interval: " + this.f7127n);
        throw new IOException("RETRY_LATER");
    }

    public void m12181a(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.f7122i = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f7121h = (Messenger) parcelableExtra;
                    }
                }
                m12184d((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    String m12182b(Intent intent) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = intent.getStringExtra("error");
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        String valueOf = String.valueOf(intent.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    void m12183c(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            valueOf = "InstanceID/Rpc";
            String str = "Received InstanceID error ";
            String valueOf2 = String.valueOf(stringExtra);
            Log.d(valueOf, valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                String str2 = "InstanceID/Rpc";
                String str3 = "Unexpected structured response ";
                valueOf2 = String.valueOf(stringExtra);
                Log.w(str2, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
            }
            if (split.length > 2) {
                valueOf2 = split[2];
                valueOf = split[3];
                if (valueOf.startsWith(":")) {
                    valueOf = valueOf.substring(1);
                }
            } else {
                valueOf = "UNKNOWN";
                valueOf2 = null;
            }
            intent.putExtra("error", valueOf);
        } else {
            valueOf2 = null;
            valueOf = stringExtra;
        }
        if (valueOf2 == null) {
            m12169a((Object) valueOf);
        } else {
            m12172a(valueOf2, (Object) valueOf);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.f7125l = SystemClock.elapsedRealtime();
            this.f7127n = ((int) longExtra) * 1000;
            this.f7128o = SystemClock.elapsedRealtime() + ((long) this.f7127n);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.f7127n);
        } else if ("SERVICE_NOT_AVAILABLE".equals(valueOf) || "AUTHENTICATION_FAILED".equals(valueOf)) {
            m12171a(valueOf);
        }
    }

    void m12184d(Intent intent) {
        if (intent != null) {
            String stringExtra;
            String str;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                stringExtra = intent.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    m12183c(intent);
                    return;
                }
                this.f7124k = SystemClock.elapsedRealtime();
                this.f7128o = 0;
                this.f7126m = 0;
                this.f7127n = 0;
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    String valueOf = String.valueOf(intent.getExtras());
                    Log.d("InstanceID/Rpc", new StringBuilder((String.valueOf(stringExtra).length() + 16) + String.valueOf(valueOf).length()).append("AppIDResponse: ").append(stringExtra).append(" ").append(valueOf).toString());
                }
                if (stringExtra.startsWith("|")) {
                    String[] split = stringExtra.split("\\|");
                    if (!"ID".equals(split[1])) {
                        str = "InstanceID/Rpc";
                        String str2 = "Unexpected structured response ";
                        stringExtra = String.valueOf(stringExtra);
                        Log.w(str, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
                    }
                    str = split[2];
                    if (split.length > 4) {
                        if ("SYNC".equals(split[3])) {
                            FirebaseInstanceId.m12113d(this.f7118e);
                        } else if ("RST".equals(split[3])) {
                            FirebaseInstanceId.m12110a(this.f7118e, C2120d.m12156a(this.f7118e, null).m12161c());
                            intent.removeExtra("registration_id");
                            m12172a(str, (Object) intent);
                            return;
                        }
                    }
                    stringExtra = split[split.length - 1];
                    if (stringExtra.startsWith(":")) {
                        stringExtra = stringExtra.substring(1);
                    }
                    intent.putExtra("registration_id", stringExtra);
                    stringExtra = str;
                } else {
                    stringExtra = null;
                }
                if (stringExtra == null) {
                    m12169a((Object) intent);
                } else {
                    m12172a(stringExtra, (Object) intent);
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                str = "InstanceID/Rpc";
                String str3 = "Unexpected response ";
                stringExtra = String.valueOf(intent.getAction());
                Log.d(str, stringExtra.length() != 0 ? str3.concat(stringExtra) : new String(str3));
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }
}
