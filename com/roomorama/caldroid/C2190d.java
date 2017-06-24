package com.roomorama.caldroid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import p000a.p001a.C0004a;

public class C2190d {
    private static SimpleDateFormat f7386a;

    public static C0004a m12487a(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.setTime(date);
        return new C0004a(Integer.valueOf(instance.get(1)), Integer.valueOf(instance.get(2) + 1), Integer.valueOf(instance.get(5)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
    }

    public static ArrayList<C0004a> m12488a(int i, int i2, int i3, boolean z) {
        int i4 = 1;
        ArrayList<C0004a> arrayList = new ArrayList();
        C0004a c0004a = new C0004a(Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        C0004a a = c0004a.m19a(Integer.valueOf(c0004a.m38j() - 1));
        int intValue = c0004a.m37i().intValue();
        if (intValue < i3) {
            intValue += 7;
        }
        while (intValue > 0) {
            C0004a b = c0004a.m25b(Integer.valueOf(intValue - i3));
            if (!b.m23a(c0004a)) {
                break;
            }
            arrayList.add(b);
            intValue--;
        }
        for (intValue = 0; intValue < a.m31c().intValue(); intValue++) {
            arrayList.add(c0004a.m19a(Integer.valueOf(intValue)));
        }
        int i5 = i3 - 1;
        if (i5 == 0) {
            i5 = 7;
        }
        if (a.m37i().intValue() != i5) {
            intValue = 1;
            do {
                b = a.m19a(Integer.valueOf(intValue));
                arrayList.add(b);
                intValue++;
            } while (b.m37i().intValue() != i5);
        }
        if (z) {
            i5 = arrayList.size();
            intValue = (6 - (i5 / 7)) * 7;
            c0004a = (C0004a) arrayList.get(i5 - 1);
            while (i4 <= intValue) {
                arrayList.add(c0004a.m19a(Integer.valueOf(i4)));
                i4++;
            }
        }
        return arrayList;
    }

    public static Date m12489a(C0004a c0004a) {
        int intValue = c0004a.m21a().intValue();
        int intValue2 = c0004a.m27b().intValue();
        int intValue3 = c0004a.m31c().intValue();
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(intValue, intValue2 - 1, intValue3);
        return instance.getTime();
    }

    public static Date m12490a(String str, String str2) {
        SimpleDateFormat simpleDateFormat;
        if (str2 == null) {
            if (f7386a == null) {
                C2190d.m12491a();
            }
            simpleDateFormat = f7386a;
        } else {
            simpleDateFormat = new SimpleDateFormat(str2, Locale.ENGLISH);
        }
        return simpleDateFormat.parse(str);
    }

    public static void m12491a() {
        f7386a = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    }

    public static C0004a m12492b(String str, String str2) {
        try {
            return C2190d.m12487a(C2190d.m12490a(str, str2));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
