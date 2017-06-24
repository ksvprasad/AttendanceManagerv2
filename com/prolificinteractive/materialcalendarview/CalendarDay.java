package com.prolificinteractive.materialcalendarview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class CalendarDay implements Parcelable {
    public static final Creator<CalendarDay> CREATOR = new C21251();
    private final int f7131a;
    private final int f7132b;
    private final int f7133c;
    private transient Calendar f7134d;
    private transient Date f7135e;

    static class C21251 implements Creator<CalendarDay> {
        C21251() {
        }

        public CalendarDay m12203a(Parcel parcel) {
            return new CalendarDay(parcel);
        }

        public CalendarDay[] m12204a(int i) {
            return new CalendarDay[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m12203a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m12204a(i);
        }
    }

    @Deprecated
    public CalendarDay() {
        this(C2142b.m12274a());
    }

    @Deprecated
    public CalendarDay(int i, int i2, int i3) {
        this.f7131a = i;
        this.f7132b = i2;
        this.f7133c = i3;
    }

    public CalendarDay(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    @Deprecated
    public CalendarDay(Calendar calendar) {
        this(C2142b.m12278b(calendar), C2142b.m12279c(calendar), C2142b.m12280d(calendar));
    }

    public static CalendarDay m12205a() {
        return m12207a(C2142b.m12274a());
    }

    public static CalendarDay m12206a(int i, int i2, int i3) {
        return new CalendarDay(i, i2, i3);
    }

    public static CalendarDay m12207a(Calendar calendar) {
        return calendar == null ? null : m12206a(C2142b.m12278b(calendar), C2142b.m12279c(calendar), C2142b.m12280d(calendar));
    }

    public static CalendarDay m12208a(Date date) {
        return date == null ? null : m12207a(C2142b.m12275a(date));
    }

    private static int m12209b(int i, int i2, int i3) {
        return ((i * 10000) + (i2 * 100)) + i3;
    }

    public boolean m12210a(CalendarDay calendarDay) {
        if (calendarDay != null) {
            return this.f7131a == calendarDay.f7131a ? this.f7132b == calendarDay.f7132b ? this.f7133c < calendarDay.f7133c : this.f7132b < calendarDay.f7132b : this.f7131a < calendarDay.f7131a;
        } else {
            throw new IllegalArgumentException("other cannot be null");
        }
    }

    public boolean m12211a(CalendarDay calendarDay, CalendarDay calendarDay2) {
        return (calendarDay == null || !calendarDay.m12214b(this)) && (calendarDay2 == null || !calendarDay2.m12210a(this));
    }

    public int m12212b() {
        return this.f7131a;
    }

    public void m12213b(Calendar calendar) {
        calendar.clear();
        calendar.set(this.f7131a, this.f7132b, this.f7133c);
    }

    public boolean m12214b(CalendarDay calendarDay) {
        if (calendarDay != null) {
            return this.f7131a == calendarDay.f7131a ? this.f7132b == calendarDay.f7132b ? this.f7133c > calendarDay.f7133c : this.f7132b > calendarDay.f7132b : this.f7131a > calendarDay.f7131a;
        } else {
            throw new IllegalArgumentException("other cannot be null");
        }
    }

    public int m12215c() {
        return this.f7132b;
    }

    public int m12216d() {
        return this.f7133c;
    }

    public int describeContents() {
        return 0;
    }

    public Date m12217e() {
        if (this.f7135e == null) {
            this.f7135e = m12218f().getTime();
        }
        return this.f7135e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CalendarDay calendarDay = (CalendarDay) obj;
        return this.f7133c == calendarDay.f7133c && this.f7132b == calendarDay.f7132b && this.f7131a == calendarDay.f7131a;
    }

    public Calendar m12218f() {
        if (this.f7134d == null) {
            this.f7134d = C2142b.m12274a();
            m12213b(this.f7134d);
        }
        return this.f7134d;
    }

    public int hashCode() {
        return m12209b(this.f7131a, this.f7132b, this.f7133c);
    }

    public String toString() {
        return String.format(Locale.US, "CalendarDay{%d-%d-%d}", new Object[]{Integer.valueOf(this.f7131a), Integer.valueOf(this.f7132b + 1), Integer.valueOf(this.f7133c)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7131a);
        parcel.writeInt(this.f7132b);
        parcel.writeInt(this.f7133c);
    }
}
