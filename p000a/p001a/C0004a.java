package p000a.p001a;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import p000a.p001a.C0016e.C0015a;

public final class C0004a implements Serializable, Comparable<C0004a> {
    private static int f13k = 2400000;
    private String f14a;
    private Integer f15b;
    private Integer f16c;
    private Integer f17d;
    private Integer f18e;
    private Integer f19f;
    private Integer f20g;
    private Integer f21h;
    private boolean f22i = true;
    private int f23j;

    public enum C0000a {
        LastDay,
        FirstDay,
        Spillover,
        Abort
    }

    static final class C0001b extends RuntimeException {
        C0001b(String str) {
            super(str);
        }
    }

    static final class C0002c extends RuntimeException {
        C0002c(String str) {
            super(str);
        }
    }

    public enum C0003d {
        YEAR,
        MONTH,
        DAY,
        HOUR,
        MINUTE,
        SECOND,
        NANOSECONDS
    }

    public C0004a(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        this.f15b = num;
        this.f16c = num2;
        this.f17d = num3;
        this.f18e = num4;
        this.f19f = num5;
        this.f20g = num6;
        this.f21h = num7;
        m14o();
    }

    static C0004a m0a(int i) {
        int i2 = 68569 + i;
        int i3 = (i2 * 4) / 146097;
        i2 -= ((146097 * i3) + 3) / 4;
        int i4 = ((i2 + 1) * 4000) / 1461001;
        i2 = (i2 - ((i4 * 1461) / 4)) + 31;
        int i5 = (i2 * 80) / 2447;
        i2 -= (i5 * 2447) / 80;
        int i6 = i5 / 11;
        return C0004a.m2a(Integer.valueOf((((i3 - 49) * 100) + i4) + i6), Integer.valueOf((i5 + 2) - (i6 * 12)), Integer.valueOf(i2));
    }

    public static C0004a m1a(long j, TimeZone timeZone) {
        Calendar gregorianCalendar = new GregorianCalendar(timeZone);
        gregorianCalendar.setTimeInMillis(j);
        return new C0004a(Integer.valueOf(gregorianCalendar.get(1)), Integer.valueOf(gregorianCalendar.get(2) + 1), Integer.valueOf(gregorianCalendar.get(5)), Integer.valueOf(gregorianCalendar.get(11)), Integer.valueOf(gregorianCalendar.get(12)), Integer.valueOf(gregorianCalendar.get(13)), Integer.valueOf((gregorianCalendar.get(14) * 1000) * 1000));
    }

    public static C0004a m2a(Integer num, Integer num2, Integer num3) {
        return new C0004a(num, num2, num3, null, null, null, null);
    }

    public static C0004a m3a(TimeZone timeZone) {
        return C0004a.m1a(System.currentTimeMillis(), timeZone);
    }

    static Integer m4a(Integer num, Integer num2) {
        if (num == null || num2 == null) {
            return null;
        }
        if (num2.intValue() == 1) {
            return Integer.valueOf(31);
        }
        if (num2.intValue() == 2) {
            return Integer.valueOf(C0004a.m10c(num) ? 29 : 28);
        } else if (num2.intValue() == 3) {
            return Integer.valueOf(31);
        } else {
            if (num2.intValue() == 4) {
                return Integer.valueOf(30);
            }
            if (num2.intValue() == 5) {
                return Integer.valueOf(31);
            }
            if (num2.intValue() == 6) {
                return Integer.valueOf(30);
            }
            if (num2.intValue() == 7) {
                return Integer.valueOf(31);
            }
            if (num2.intValue() == 8) {
                return Integer.valueOf(31);
            }
            if (num2.intValue() == 9) {
                return Integer.valueOf(30);
            }
            if (num2.intValue() == 10) {
                return Integer.valueOf(31);
            }
            if (num2.intValue() == 11) {
                return Integer.valueOf(30);
            }
            if (num2.intValue() == 12) {
                return Integer.valueOf(31);
            }
            throw new AssertionError("Month is out of range 1..12:" + num2);
        }
    }

    private void m5a(Integer num, int i, int i2, String str) {
        if (num == null) {
            return;
        }
        if (num.intValue() < i || num.intValue() > i2) {
            throw new C0001b(str + " is not in the range " + i + ".." + i2 + ". Value is:" + num);
        }
    }

    private void m6a(String str, Object obj, StringBuilder stringBuilder) {
        stringBuilder.append(str + ":" + String.valueOf(obj) + " ");
    }

    private boolean m7a(Object... objArr) {
        for (Object obj : objArr) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static C0004a m8b(TimeZone timeZone) {
        return C0004a.m3a(timeZone).m18a(C0003d.DAY);
    }

    private void m9b(Integer num, Integer num2, Integer num3) {
        if (m11c(num, num2, num3) && num3.intValue() > C0004a.m4a(num, num2).intValue()) {
            throw new C0001b("The day-of-the-month value '" + num3 + "' exceeds the number of days in the month: " + C0004a.m4a(num, num2));
        }
    }

    private static boolean m10c(Integer num) {
        if (num.intValue() % 100 == 0) {
            if (num.intValue() % 400 == 0) {
                return true;
            }
        } else if (num.intValue() % 4 == 0) {
            return true;
        }
        return false;
    }

    private boolean m11c(Integer num, Integer num2, Integer num3) {
        return m7a(num, num2, num3);
    }

    private int m12m() {
        int intValue = this.f15b.intValue();
        int intValue2 = this.f16c.intValue();
        return (((((((intValue + 4800) + ((intValue2 - 14) / 12)) * 1461) / 4) + ((((intValue2 - 2) - (((intValue2 - 14) / 12) * 12)) * 367) / 12)) - (((((intValue + 4900) + ((intValue2 - 14) / 12)) / 100) * 3) / 4)) + this.f17d.intValue()) - 32075;
    }

    private void m13n() {
        m40l();
        if (!m39k()) {
            throw new C0002c("DateTime does not include year/month/day.");
        }
    }

    private void m14o() {
        m5a(this.f15b, 1, 9999, "Year");
        m5a(this.f16c, 1, 12, "Month");
        m5a(this.f17d, 1, 31, "Day");
        m5a(this.f18e, 0, 23, "Hour");
        m5a(this.f19f, 0, 59, "Minute");
        m5a(this.f20g, 0, 59, "Second");
        m5a(this.f21h, 0, 999999999, "Nanosecond");
        m9b(this.f15b, this.f16c, this.f17d);
    }

    private void m15p() {
        C0004a a = new C0014d().m99a(this.f14a);
        this.f15b = a.f15b;
        this.f16c = a.f16c;
        this.f17d = a.f17d;
        this.f18e = a.f18e;
        this.f19f = a.f19f;
        this.f20g = a.f20g;
        this.f21h = a.f21h;
        m14o();
    }

    private Object[] m16q() {
        return new Object[]{this.f15b, this.f16c, this.f17d, this.f18e, this.f19f, this.f20g, this.f21h};
    }

    private String m17r() {
        if (m24a(C0003d.YEAR)) {
            if (m29b(C0003d.MONTH, C0003d.DAY, C0003d.HOUR, C0003d.MINUTE, C0003d.SECOND, C0003d.NANOSECONDS)) {
                return "YYYY";
            }
        }
        if (m24a(C0003d.YEAR, C0003d.MONTH)) {
            if (m29b(C0003d.DAY, C0003d.HOUR, C0003d.MINUTE, C0003d.SECOND, C0003d.NANOSECONDS)) {
                return "YYYY-MM";
            }
        }
        if (m24a(C0003d.YEAR, C0003d.MONTH, C0003d.DAY)) {
            if (m29b(C0003d.HOUR, C0003d.MINUTE, C0003d.SECOND, C0003d.NANOSECONDS)) {
                return "YYYY-MM-DD";
            }
        }
        if (m24a(C0003d.YEAR, C0003d.MONTH, C0003d.DAY, C0003d.HOUR)) {
            if (m29b(C0003d.MINUTE, C0003d.SECOND, C0003d.NANOSECONDS)) {
                return "YYYY-MM-DD hh";
            }
        }
        if (m24a(C0003d.YEAR, C0003d.MONTH, C0003d.DAY, C0003d.HOUR, C0003d.MINUTE)) {
            if (m29b(C0003d.SECOND, C0003d.NANOSECONDS)) {
                return "YYYY-MM-DD hh:mm";
            }
        }
        if (m24a(C0003d.YEAR, C0003d.MONTH, C0003d.DAY, C0003d.HOUR, C0003d.MINUTE, C0003d.SECOND)) {
            if (m29b(C0003d.NANOSECONDS)) {
                return "YYYY-MM-DD hh:mm:ss";
            }
        }
        if (m24a(C0003d.YEAR, C0003d.MONTH, C0003d.DAY, C0003d.HOUR, C0003d.MINUTE, C0003d.SECOND, C0003d.NANOSECONDS)) {
            return "YYYY-MM-DD hh:mm:ss.fffffffff";
        }
        if (m29b(C0003d.YEAR, C0003d.MONTH, C0003d.DAY)) {
            if (m24a(C0003d.HOUR, C0003d.MINUTE, C0003d.SECOND, C0003d.NANOSECONDS)) {
                return "hh:mm:ss.fffffffff";
            }
        }
        if (m29b(C0003d.YEAR, C0003d.MONTH, C0003d.DAY, C0003d.NANOSECONDS)) {
            if (m24a(C0003d.HOUR, C0003d.MINUTE, C0003d.SECOND)) {
                return "hh:mm:ss";
            }
        }
        if (!m29b(C0003d.YEAR, C0003d.MONTH, C0003d.DAY, C0003d.SECOND, C0003d.NANOSECONDS)) {
            return null;
        }
        return m24a(C0003d.HOUR, C0003d.MINUTE) ? "hh:mm" : null;
    }

    public C0004a m18a(C0003d c0003d) {
        m40l();
        if (C0003d.NANOSECONDS != c0003d) {
            return C0003d.SECOND == c0003d ? new C0004a(this.f15b, this.f16c, this.f17d, this.f18e, this.f19f, this.f20g, null) : C0003d.MINUTE == c0003d ? new C0004a(this.f15b, this.f16c, this.f17d, this.f18e, this.f19f, null, null) : C0003d.HOUR == c0003d ? new C0004a(this.f15b, this.f16c, this.f17d, this.f18e, null, null, null) : C0003d.DAY == c0003d ? new C0004a(this.f15b, this.f16c, this.f17d, null, null, null, null) : C0003d.MONTH == c0003d ? new C0004a(this.f15b, this.f16c, null, null, null, null, null) : C0003d.YEAR == c0003d ? new C0004a(this.f15b, null, null, null, null, null, null) : null;
        } else {
            throw new IllegalArgumentException("It makes no sense to truncate to nanosecond precision, since that's the highest precision available.");
        }
    }

    public C0004a m19a(Integer num) {
        m13n();
        C0004a a = C0004a.m0a(((m36h().intValue() + 1) + f13k) + num.intValue());
        return new C0004a(a.m21a(), a.m27b(), a.m31c(), this.f18e, this.f19f, this.f20g, this.f21h);
    }

    public C0004a m20a(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, C0000a c0000a) {
        return new C0010c(this, c0000a).m88a(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue(), num5.intValue(), num6.intValue(), num7.intValue());
    }

    public Integer m21a() {
        m40l();
        return this.f15b;
    }

    public String m22a(String str) {
        return new C0009b(str).m67a(this);
    }

    public boolean m23a(C0004a c0004a) {
        return m30c(c0004a) < 0;
    }

    public boolean m24a(C0003d... c0003dArr) {
        m40l();
        boolean z = true;
        for (C0003d c0003d : c0003dArr) {
            if (C0003d.NANOSECONDS == c0003d) {
                z = z && this.f21h != null;
            } else if (C0003d.SECOND == c0003d) {
                z = z && this.f20g != null;
            } else if (C0003d.MINUTE == c0003d) {
                z = z && this.f19f != null;
            } else if (C0003d.HOUR == c0003d) {
                z = z && this.f18e != null;
            } else if (C0003d.DAY == c0003d) {
                z = z && this.f17d != null;
            } else if (C0003d.MONTH == c0003d) {
                z = z && this.f16c != null;
            } else if (C0003d.YEAR == c0003d) {
                z = z && this.f15b != null;
            }
        }
        return z;
    }

    public C0004a m25b(Integer num) {
        return m19a(Integer.valueOf(num.intValue() * -1));
    }

    public C0004a m26b(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, C0000a c0000a) {
        return new C0010c(this, c0000a).m89b(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue(), num5.intValue(), num6.intValue(), num7.intValue());
    }

    public Integer m27b() {
        m40l();
        return this.f16c;
    }

    public boolean m28b(C0004a c0004a) {
        return m30c(c0004a) > 0;
    }

    public boolean m29b(C0003d... c0003dArr) {
        m40l();
        boolean z = true;
        for (C0003d c0003d : c0003dArr) {
            if (C0003d.NANOSECONDS == c0003d) {
                z = z && this.f21h == null;
            } else if (C0003d.SECOND == c0003d) {
                z = z && this.f20g == null;
            } else if (C0003d.MINUTE == c0003d) {
                z = z && this.f19f == null;
            } else if (C0003d.HOUR == c0003d) {
                z = z && this.f18e == null;
            } else if (C0003d.DAY == c0003d) {
                z = z && this.f17d == null;
            } else if (C0003d.MONTH == c0003d) {
                z = z && this.f16c == null;
            } else if (C0003d.YEAR == c0003d) {
                z = z && this.f15b == null;
            }
        }
        return z;
    }

    public int m30c(C0004a c0004a) {
        if (this == c0004a) {
            return 0;
        }
        m40l();
        c0004a.m40l();
        C0015a c0015a = C0015a.FIRST;
        int a = C0016e.m104a(this.f15b, c0004a.f15b, c0015a);
        if (a != 0) {
            return a;
        }
        a = C0016e.m104a(this.f16c, c0004a.f16c, c0015a);
        if (a != 0) {
            return a;
        }
        a = C0016e.m104a(this.f17d, c0004a.f17d, c0015a);
        if (a != 0) {
            return a;
        }
        a = C0016e.m104a(this.f18e, c0004a.f18e, c0015a);
        if (a != 0) {
            return a;
        }
        a = C0016e.m104a(this.f19f, c0004a.f19f, c0015a);
        if (a != 0) {
            return a;
        }
        a = C0016e.m104a(this.f20g, c0004a.f20g, c0015a);
        if (a != 0) {
            return a;
        }
        a = C0016e.m104a(this.f21h, c0004a.f21h, c0015a);
        return a != 0 ? a : 0;
    }

    public Integer m31c() {
        m40l();
        return this.f17d;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m30c((C0004a) obj);
    }

    public Integer m32d() {
        m40l();
        return this.f18e;
    }

    public Integer m33e() {
        m40l();
        return this.f19f;
    }

    public boolean equals(Object obj) {
        m40l();
        Boolean a = C0016e.m106a((Object) this, obj);
        if (a == null) {
            C0004a c0004a = (C0004a) obj;
            c0004a.m40l();
            a = Boolean.valueOf(C0016e.m108a(m16q(), c0004a.m16q()));
        }
        return a.booleanValue();
    }

    public Integer m34f() {
        m40l();
        return this.f20g;
    }

    public Integer m35g() {
        m40l();
        return this.f21h;
    }

    public Integer m36h() {
        m13n();
        return Integer.valueOf((m12m() - 1) - f13k);
    }

    public int hashCode() {
        if (this.f23j == 0) {
            m40l();
            this.f23j = C0016e.m105a(m16q());
        }
        return this.f23j;
    }

    public Integer m37i() {
        m13n();
        return Integer.valueOf(((m12m() + 1) % 7) + 1);
    }

    public int m38j() {
        m13n();
        return C0004a.m4a(this.f15b, this.f16c).intValue();
    }

    public boolean m39k() {
        return m24a(C0003d.YEAR, C0003d.MONTH, C0003d.DAY);
    }

    void m40l() {
        if (!this.f22i) {
            m15p();
        }
    }

    public String toString() {
        String str = "";
        if (C0017f.m111a(this.f14a)) {
            return this.f14a;
        }
        if (m17r() != null) {
            return m22a(m17r());
        }
        StringBuilder stringBuilder = new StringBuilder();
        m6a("Y", this.f15b, stringBuilder);
        m6a("M", this.f16c, stringBuilder);
        m6a("D", this.f17d, stringBuilder);
        m6a("h", this.f18e, stringBuilder);
        m6a("m", this.f19f, stringBuilder);
        m6a("s", this.f20g, stringBuilder);
        m6a("f", this.f21h, stringBuilder);
        return stringBuilder.toString().trim();
    }
}
