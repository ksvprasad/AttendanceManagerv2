package com.google.android.gms.p031b;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C1876j;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.nq.C1803a;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;
import java.lang.reflect.Field;

public final class np {
    public static final C1793b f6080a = new C17942();
    public static final C1793b f6081b = new C17953();
    public static final C1793b f6082c = new C17964();
    public static final C1793b f6083d = new C17975();
    public static final C1793b f6084e = new C17986();
    private static nq f6085f;
    private static final C1791a f6086g = new C17921();
    private final Context f6087h;

    class C17921 implements C1791a {
        C17921() {
        }

        public int mo1624a(Context context, String str) {
            return np.m10184a(context, str);
        }

        public int mo1625a(Context context, String str, boolean z) {
            return np.m10185a(context, str, z);
        }
    }

    public interface C1793b {

        public interface C1791a {
            int mo1624a(Context context, String str);

            int mo1625a(Context context, String str, boolean z);
        }

        public static class C1801b {
            public int f6077a = 0;
            public int f6078b = 0;
            public int f6079c = 0;
        }

        C1801b mo1626a(Context context, String str, C1791a c1791a);
    }

    class C17942 implements C1793b {
        C17942() {
        }

        public C1801b mo1626a(Context context, String str, C1791a c1791a) {
            C1801b c1801b = new C1801b();
            c1801b.f6078b = c1791a.mo1625a(context, str, true);
            if (c1801b.f6078b != 0) {
                c1801b.f6079c = 1;
            } else {
                c1801b.f6077a = c1791a.mo1624a(context, str);
                if (c1801b.f6077a != 0) {
                    c1801b.f6079c = -1;
                }
            }
            return c1801b;
        }
    }

    class C17953 implements C1793b {
        C17953() {
        }

        public C1801b mo1626a(Context context, String str, C1791a c1791a) {
            C1801b c1801b = new C1801b();
            c1801b.f6077a = c1791a.mo1624a(context, str);
            if (c1801b.f6077a != 0) {
                c1801b.f6079c = -1;
            } else {
                c1801b.f6078b = c1791a.mo1625a(context, str, true);
                if (c1801b.f6078b != 0) {
                    c1801b.f6079c = 1;
                }
            }
            return c1801b;
        }
    }

    class C17964 implements C1793b {
        C17964() {
        }

        public C1801b mo1626a(Context context, String str, C1791a c1791a) {
            C1801b c1801b = new C1801b();
            c1801b.f6077a = c1791a.mo1624a(context, str);
            c1801b.f6078b = c1791a.mo1625a(context, str, true);
            if (c1801b.f6077a == 0 && c1801b.f6078b == 0) {
                c1801b.f6079c = 0;
            } else if (c1801b.f6077a >= c1801b.f6078b) {
                c1801b.f6079c = -1;
            } else {
                c1801b.f6079c = 1;
            }
            return c1801b;
        }
    }

    class C17975 implements C1793b {
        C17975() {
        }

        public C1801b mo1626a(Context context, String str, C1791a c1791a) {
            C1801b c1801b = new C1801b();
            c1801b.f6077a = c1791a.mo1624a(context, str);
            c1801b.f6078b = c1791a.mo1625a(context, str, true);
            if (c1801b.f6077a == 0 && c1801b.f6078b == 0) {
                c1801b.f6079c = 0;
            } else if (c1801b.f6078b >= c1801b.f6077a) {
                c1801b.f6079c = 1;
            } else {
                c1801b.f6079c = -1;
            }
            return c1801b;
        }
    }

    class C17986 implements C1793b {
        C17986() {
        }

        public C1801b mo1626a(Context context, String str, C1791a c1791a) {
            C1801b c1801b = new C1801b();
            c1801b.f6077a = c1791a.mo1624a(context, str);
            if (c1801b.f6077a != 0) {
                c1801b.f6078b = c1791a.mo1625a(context, str, false);
            } else {
                c1801b.f6078b = c1791a.mo1625a(context, str, true);
            }
            if (c1801b.f6077a == 0 && c1801b.f6078b == 0) {
                c1801b.f6079c = 0;
            } else if (c1801b.f6078b >= c1801b.f6077a) {
                c1801b.f6079c = 1;
            } else {
                c1801b.f6079c = -1;
            }
            return c1801b;
        }
    }

    class C17997 implements C1791a {
        final /* synthetic */ int f6076a;

        C17997(int i) {
            this.f6076a = i;
        }

        public int mo1624a(Context context, String str) {
            return this.f6076a;
        }

        public int mo1625a(Context context, String str, boolean z) {
            return 0;
        }
    }

    public static class C1800a extends Exception {
        private C1800a(String str) {
            super(str);
        }

        private C1800a(String str, Throwable th) {
            super(str, th);
        }
    }

    private np(Context context) {
        this.f6087h = (Context) C1896c.m10790a((Object) context);
    }

    public static int m10184a(Context context, String str) {
        String valueOf;
        String valueOf2;
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            valueOf2 = String.valueOf("ModuleDescriptor");
            Class loadClass = classLoader.loadClass(new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(".").append(valueOf2).toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            valueOf = String.valueOf(declaredField.get(null));
            Log.e("DynamiteModule", new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            valueOf = "DynamiteModule";
            valueOf2 = "Failed to load module descriptor class: ";
            String valueOf3 = String.valueOf(e2.getMessage());
            Log.e(valueOf, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
            return 0;
        }
    }

    public static int m10185a(Context context, String str, boolean z) {
        nq a = np.m10188a(context);
        if (a == null) {
            return 0;
        }
        try {
            return a.mo1628a(C1001b.m5713a((Object) context), str, z);
        } catch (RemoteException e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return 0;
        }
    }

    public static np m10186a(Context context, C1793b c1793b, String str) {
        C1801b a = c1793b.mo1626a(context, str, f6086g);
        Log.i("DynamiteModule", new StringBuilder((String.valueOf(str).length() + 68) + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(a.f6077a).append(" and remote module ").append(str).append(":").append(a.f6078b).toString());
        if (a.f6079c == 0 || ((a.f6079c == -1 && a.f6077a == 0) || (a.f6079c == 1 && a.f6078b == 0))) {
            throw new C1800a("No acceptable module found. Local version is " + a.f6077a + " and remote version is " + a.f6078b + ".");
        } else if (a.f6079c == -1) {
            return np.m10189b(context, str);
        } else {
            if (a.f6079c == 1) {
                try {
                    return np.m10187a(context, str, a.f6078b);
                } catch (Throwable e) {
                    Throwable th = e;
                    String str2 = "DynamiteModule";
                    String str3 = "Failed to load remote module: ";
                    String valueOf = String.valueOf(th.getMessage());
                    Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    if (a.f6077a != 0 && c1793b.mo1626a(context, str, new C17997(a.f6077a)).f6079c == -1) {
                        return np.m10189b(context, str);
                    }
                    throw new C1800a("Remote load failed. No local fallback found.", th);
                }
            }
            throw new C1800a("VersionPolicy returned invalid code:" + a.f6079c);
        }
    }

    private static np m10187a(Context context, String str, int i) {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        nq a = np.m10188a(context);
        if (a == null) {
            throw new C1800a("Failed to create IDynamiteLoader.");
        }
        try {
            C0998a a2 = a.mo1629a(C1001b.m5713a((Object) context), str, i);
            if (C1001b.m5714a(a2) != null) {
                return new np((Context) C1001b.m5714a(a2));
            }
            throw new C1800a("Failed to load remote module.");
        } catch (Throwable e) {
            throw new C1800a("Failed to load remote module.", e);
        }
    }

    private static nq m10188a(Context context) {
        synchronized (np.class) {
            nq nqVar;
            if (f6085f != null) {
                nqVar = f6085f;
                return nqVar;
            } else if (C1876j.m10605b().mo1643a(context) != 0) {
                return null;
            } else {
                try {
                    nqVar = C1803a.m10197a((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (nqVar != null) {
                        f6085f = nqVar;
                        return nqVar;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    return null;
                }
            }
        }
    }

    private static np m10189b(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        String valueOf = String.valueOf(str);
        Log.i(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        return new np(context.getApplicationContext());
    }

    public Context m10190a() {
        return this.f6087h;
    }
}
