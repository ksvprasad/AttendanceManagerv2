package android.support.v7.p018a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.p010b.C0304i;
import android.util.Log;
import java.util.Calendar;

class C0675p {
    private static final C0674a f1650a = new C0674a();
    private final Context f1651b;
    private final LocationManager f1652c;

    private static class C0674a {
        boolean f1644a;
        long f1645b;
        long f1646c;
        long f1647d;
        long f1648e;
        long f1649f;

        private C0674a() {
        }
    }

    C0675p(Context context) {
        this.f1651b = context;
        this.f1652c = (LocationManager) context.getSystemService("location");
    }

    private Location m3548a(String str) {
        if (this.f1652c != null) {
            try {
                if (this.f1652c.isProviderEnabled(str)) {
                    return this.f1652c.getLastKnownLocation(str);
                }
            } catch (Throwable e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    private void m3549a(Location location) {
        long j;
        C0674a c0674a = f1650a;
        long currentTimeMillis = System.currentTimeMillis();
        C0672o a = C0672o.m3546a();
        a.m3547a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f1641a;
        a.m3547a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f1643c == 1;
        long j3 = a.f1642b;
        long j4 = a.f1641a;
        a.m3547a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a.f1642b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3;
            j += 60000;
        }
        c0674a.f1644a = z;
        c0674a.f1645b = j2;
        c0674a.f1646c = j3;
        c0674a.f1647d = j4;
        c0674a.f1648e = j5;
        c0674a.f1649f = j;
    }

    private boolean m3550a(C0674a c0674a) {
        return c0674a != null && c0674a.f1649f > System.currentTimeMillis();
    }

    private Location m3551b() {
        Location location = null;
        Location a = C0304i.m1704a(this.f1651b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m3548a("network") : null;
        if (C0304i.m1704a(this.f1651b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m3548a("gps");
        }
        if (location != null && a != null) {
            return location.getTime() > a.getTime() ? location : a;
        } else {
            if (location == null) {
                location = a;
            }
            return location;
        }
    }

    boolean m3552a() {
        C0674a c0674a = f1650a;
        if (m3550a(c0674a)) {
            return c0674a.f1644a;
        }
        Location b = m3551b();
        if (b != null) {
            m3549a(b);
            return c0674a.f1644a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
