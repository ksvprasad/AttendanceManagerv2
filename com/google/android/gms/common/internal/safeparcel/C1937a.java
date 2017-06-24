package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class C1937a {

    public static class C1936a extends RuntimeException {
        public C1936a(String str, Parcel parcel) {
            int dataPosition = parcel.dataPosition();
            super(new StringBuilder(String.valueOf(str).length() + 41).append(str).append(" Parcel: pos=").append(dataPosition).append(" size=").append(parcel.dataSize()).toString());
        }
    }

    public static int m10904a(int i) {
        return 65535 & i;
    }

    public static int m10905a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int m10906a(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static <T extends Parcelable> T m10907a(Parcel parcel, int i, Creator<T> creator) {
        int a = C1937a.m10906a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m10908a(Parcel parcel, int i, int i2) {
        int a = C1937a.m10906a(parcel, i);
        if (a != i2) {
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new C1936a(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i2).append(" got ").append(a).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    private static void m10909a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String valueOf = String.valueOf(Integer.toHexString(i2));
            throw new C1936a(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i3).append(" got ").append(i2).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    public static int m10910b(Parcel parcel) {
        int a = C1937a.m10905a(parcel);
        int a2 = C1937a.m10906a(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (C1937a.m10904a(a) != 20293) {
            String str = "Expected object header. Got 0x";
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new C1936a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), parcel);
        }
        a = dataPosition + a2;
        if (a >= dataPosition && a <= parcel.dataSize()) {
            return a;
        }
        throw new C1936a("Size read is invalid start=" + dataPosition + " end=" + a, parcel);
    }

    public static void m10911b(Parcel parcel, int i) {
        parcel.setDataPosition(C1937a.m10906a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] m10912b(Parcel parcel, int i, Creator<T> creator) {
        int a = C1937a.m10906a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static <T> ArrayList<T> m10913c(Parcel parcel, int i, Creator<T> creator) {
        int a = C1937a.m10906a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    public static boolean m10914c(Parcel parcel, int i) {
        C1937a.m10908a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int m10915d(Parcel parcel, int i) {
        C1937a.m10908a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer m10916e(Parcel parcel, int i) {
        int a = C1937a.m10906a(parcel, i);
        if (a == 0) {
            return null;
        }
        C1937a.m10909a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long m10917f(Parcel parcel, int i) {
        C1937a.m10908a(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long m10918g(Parcel parcel, int i) {
        int a = C1937a.m10906a(parcel, i);
        if (a == 0) {
            return null;
        }
        C1937a.m10909a(parcel, i, a, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static float m10919h(Parcel parcel, int i) {
        C1937a.m10908a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float m10920i(Parcel parcel, int i) {
        int a = C1937a.m10906a(parcel, i);
        if (a == 0) {
            return null;
        }
        C1937a.m10909a(parcel, i, a, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static Double m10921j(Parcel parcel, int i) {
        int a = C1937a.m10906a(parcel, i);
        if (a == 0) {
            return null;
        }
        C1937a.m10909a(parcel, i, a, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static String m10922k(Parcel parcel, int i) {
        int a = C1937a.m10906a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static IBinder m10923l(Parcel parcel, int i) {
        int a = C1937a.m10906a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m10924m(Parcel parcel, int i) {
        int a = C1937a.m10906a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    public static byte[] m10925n(Parcel parcel, int i) {
        int a = C1937a.m10906a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    public static byte[][] m10926o(Parcel parcel, int i) {
        int a = C1937a.m10906a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + a);
        return bArr;
    }

    public static int[] m10927p(Parcel parcel, int i) {
        int a = C1937a.m10906a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a + dataPosition);
        return createIntArray;
    }

    public static String[] m10928q(Parcel parcel, int i) {
        int a = C1937a.m10906a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }

    public static ArrayList<String> m10929r(Parcel parcel, int i) {
        int a = C1937a.m10906a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }
}
