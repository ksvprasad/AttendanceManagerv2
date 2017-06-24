package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.support.v4.p015g.C0370a;
import android.util.Log;
import com.google.android.gms.common.internal.C1895b;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.ac;
import com.google.android.gms.common.util.C1968a;
import com.google.android.gms.common.util.C1979l;
import com.google.android.gms.p031b.C1659k;
import com.google.android.gms.p031b.C1689l;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class C2112a {
    static final Map<String, C2112a> f7061a = new C0370a();
    private static final List<String> f7062b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> f7063c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> f7064d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final Set<String> f7065e = Collections.emptySet();
    private static final Object f7066f = new Object();
    private final Context f7067g;
    private final String f7068h;
    private final C2113b f7069i;
    private final AtomicBoolean f7070j = new AtomicBoolean(true);
    private final AtomicBoolean f7071k = new AtomicBoolean();
    private final List<Object> f7072l = new CopyOnWriteArrayList();
    private final List<C2110a> f7073m = new CopyOnWriteArrayList();
    private final List<Object> f7074n = new CopyOnWriteArrayList();

    public interface C2110a {
        void m12084a(boolean z);
    }

    protected C2112a(Context context, String str, C2113b c2113b) {
        this.f7067g = (Context) C1896c.m10790a((Object) context);
        this.f7068h = C1896c.m10792a(str);
        this.f7069i = (C2113b) C1896c.m10790a((Object) c2113b);
    }

    public static C2112a m12087a(Context context) {
        C2113b a = C2113b.m12103a(context);
        return a == null ? null : C2112a.m12088a(context, a);
    }

    public static C2112a m12088a(Context context, C2113b c2113b) {
        return C2112a.m12089a(context, c2113b, "[DEFAULT]");
    }

    public static C2112a m12089a(Context context, C2113b c2113b, String str) {
        Object c2112a;
        C1689l a = C1689l.m9394a(context);
        C2112a.m12094b(context);
        String b = C2112a.m12093b(str);
        Object applicationContext = context.getApplicationContext();
        synchronized (f7066f) {
            C1896c.m10795a(!f7061a.containsKey(b), new StringBuilder(String.valueOf(b).length() + 33).append("FirebaseApp name ").append(b).append(" already exists!").toString());
            C1896c.m10791a(applicationContext, (Object) "Application context cannot be null.");
            c2112a = new C2112a(applicationContext, b, c2113b);
            f7061a.put(b, c2112a);
        }
        a.m9395a((C2112a) c2112a);
        C2112a.m12091a(C2112a.class, c2112a, f7062b);
        if (c2112a.m12102e()) {
            C2112a.m12091a(C2112a.class, c2112a, f7063c);
            C2112a.m12091a(Context.class, c2112a.m12099a(), f7064d);
        }
        return c2112a;
    }

    public static C2112a m12090a(String str) {
        C2112a c2112a;
        synchronized (f7066f) {
            c2112a = (C2112a) f7061a.get(C2112a.m12093b(str));
            if (c2112a != null) {
            } else {
                String str2;
                Iterable g = C2112a.m12098g();
                if (g.isEmpty()) {
                    str2 = "";
                } else {
                    String str3 = "Available app names: ";
                    str2 = String.valueOf(ac.m10779a(", ").m10781a(g));
                    str2 = str2.length() != 0 ? str3.concat(str2) : new String(str3);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return c2112a;
    }

    private static <T> void m12091a(Class<T> cls, T t, Iterable<String> iterable) {
        String valueOf;
        for (String valueOf2 : iterable) {
            try {
                Method method = Class.forName(valueOf2).getMethod("getInstance", new Class[]{cls});
                int modifiers = method.getModifiers();
                if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                    method.invoke(null, new Object[]{t});
                }
            } catch (ClassNotFoundException e) {
                if (f7065e.contains(valueOf2)) {
                    throw new IllegalStateException(String.valueOf(valueOf2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                }
                Log.d("FirebaseApp", String.valueOf(valueOf2).concat(" is not linked. Skipping initialization."));
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException(String.valueOf(valueOf2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
            } catch (Throwable e3) {
                Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
            } catch (Throwable e4) {
                String str = "FirebaseApp";
                String str2 = "Failed to initialize ";
                valueOf2 = String.valueOf(valueOf2);
                Log.wtf(str, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e4);
            }
        }
    }

    public static void m12092a(boolean z) {
        synchronized (f7066f) {
            Iterator it = new ArrayList(f7061a.values()).iterator();
            while (it.hasNext()) {
                C2112a c2112a = (C2112a) it.next();
                if (c2112a.f7070j.get()) {
                    c2112a.m12095b(z);
                }
            }
        }
    }

    private static String m12093b(String str) {
        return str.trim();
    }

    @TargetApi(14)
    private static void m12094b(Context context) {
        if (C1979l.m11110d() && (context.getApplicationContext() instanceof Application)) {
            C1659k.m9258a((Application) context.getApplicationContext());
        }
    }

    private void m12095b(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (C2110a a : this.f7073m) {
            a.m12084a(z);
        }
    }

    public static C2112a m12096d() {
        return C2112a.m12090a("[DEFAULT]");
    }

    private void m12097f() {
        C1896c.m10795a(!this.f7071k.get(), (Object) "FirebaseApp was deleted");
    }

    private static List<String> m12098g() {
        Collection c1968a = new C1968a();
        synchronized (f7066f) {
            for (C2112a b : f7061a.values()) {
                c1968a.add(b.m12100b());
            }
            C1689l a = C1689l.m9393a();
            if (a != null) {
                c1968a.addAll(a.m9396b());
            }
        }
        List<String> arrayList = new ArrayList(c1968a);
        Collections.sort(arrayList);
        return arrayList;
    }

    public Context m12099a() {
        m12097f();
        return this.f7067g;
    }

    public String m12100b() {
        m12097f();
        return this.f7068h;
    }

    public C2113b m12101c() {
        m12097f();
        return this.f7069i;
    }

    public boolean m12102e() {
        return "[DEFAULT]".equals(m12100b());
    }

    public boolean equals(Object obj) {
        return !(obj instanceof C2112a) ? false : this.f7068h.equals(((C2112a) obj).m12100b());
    }

    public int hashCode() {
        return this.f7068h.hashCode();
    }

    public String toString() {
        return C1895b.m10788a((Object) this).m10786a("name", this.f7068h).m10786a("options", this.f7069i).toString();
    }
}
