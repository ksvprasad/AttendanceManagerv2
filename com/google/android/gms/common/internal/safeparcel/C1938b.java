package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class C1938b {
    public static int m10930a(Parcel parcel) {
        return C1938b.m10951b(parcel, 20293);
    }

    public static void m10931a(Parcel parcel, int i) {
        C1938b.m10954c(parcel, i);
    }

    public static void m10932a(Parcel parcel, int i, float f) {
        C1938b.m10952b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m10933a(Parcel parcel, int i, int i2) {
        C1938b.m10952b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m10934a(Parcel parcel, int i, long j) {
        C1938b.m10952b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m10935a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b = C1938b.m10951b(parcel, i);
            parcel.writeBundle(bundle);
            C1938b.m10954c(parcel, b);
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    public static void m10936a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b = C1938b.m10951b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C1938b.m10954c(parcel, b);
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    public static void m10937a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b = C1938b.m10951b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C1938b.m10954c(parcel, b);
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    public static void m10938a(Parcel parcel, int i, Double d, boolean z) {
        if (d != null) {
            C1938b.m10952b(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    public static void m10939a(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            C1938b.m10952b(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    public static void m10940a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            C1938b.m10952b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    public static void m10941a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            C1938b.m10952b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    public static void m10942a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b = C1938b.m10951b(parcel, i);
            parcel.writeString(str);
            C1938b.m10954c(parcel, b);
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    public static void m10943a(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int b = C1938b.m10951b(parcel, i);
            parcel.writeStringList(list);
            C1938b.m10954c(parcel, b);
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    public static void m10944a(Parcel parcel, int i, boolean z) {
        C1938b.m10952b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m10945a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int b = C1938b.m10951b(parcel, i);
            parcel.writeByteArray(bArr);
            C1938b.m10954c(parcel, b);
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    public static void m10946a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int b = C1938b.m10951b(parcel, i);
            parcel.writeIntArray(iArr);
            C1938b.m10954c(parcel, b);
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void m10947a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int b = C1938b.m10951b(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C1938b.m10950a(parcel, parcelable, i2);
                }
            }
            C1938b.m10954c(parcel, b);
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    public static void m10948a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int b = C1938b.m10951b(parcel, i);
            parcel.writeStringArray(strArr);
            C1938b.m10954c(parcel, b);
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    public static void m10949a(Parcel parcel, int i, byte[][] bArr, boolean z) {
        int i2 = 0;
        if (bArr != null) {
            int b = C1938b.m10951b(parcel, i);
            int length = bArr.length;
            parcel.writeInt(length);
            while (i2 < length) {
                parcel.writeByteArray(bArr[i2]);
                i2++;
            }
            C1938b.m10954c(parcel, b);
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void m10950a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static int m10951b(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m10952b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static <T extends Parcelable> void m10953b(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int b = C1938b.m10951b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C1938b.m10950a(parcel, parcelable, 0);
                }
            }
            C1938b.m10954c(parcel, b);
        } else if (z) {
            C1938b.m10952b(parcel, i, 0);
        }
    }

    private static void m10954c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }
}
