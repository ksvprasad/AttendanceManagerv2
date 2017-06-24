package com.google.android.gms.p031b;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@id
class fb {
    final AdRequestParcel f4705a;
    final String f4706b;
    final int f4707c;

    fb(AdRequestParcel adRequestParcel, String str, int i) {
        this.f4705a = adRequestParcel;
        this.f4706b = str;
        this.f4707c = i;
    }

    fb(ez ezVar) {
        this(ezVar.m8149a(), ezVar.m8154c(), ezVar.m8153b());
    }

    fb(String str) {
        String[] split = str.split("\u0000");
        if (split.length != 3) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel obtain = Parcel.obtain();
        try {
            this.f4706b = new String(Base64.decode(split[0], 0), "UTF-8");
            this.f4707c = Integer.parseInt(split[1]);
            byte[] decode = Base64.decode(split[2], 0);
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            this.f4705a = (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(obtain);
            obtain.recycle();
        } catch (Throwable th) {
            obtain.recycle();
        }
    }

    String m8218a() {
        String encodeToString;
        Parcel obtain = Parcel.obtain();
        try {
            encodeToString = Base64.encodeToString(this.f4706b.getBytes("UTF-8"), 0);
            String num = Integer.toString(this.f4707c);
            this.f4705a.writeToParcel(obtain, 0);
            String encodeToString2 = Base64.encodeToString(obtain.marshall(), 0);
            encodeToString = new StringBuilder(((String.valueOf(encodeToString).length() + 2) + String.valueOf(num).length()) + String.valueOf(encodeToString2).length()).append(encodeToString).append("\u0000").append(num).append("\u0000").append(encodeToString2).toString();
            return encodeToString;
        } catch (UnsupportedEncodingException e) {
            encodeToString = "QueueSeed encode failed because UTF-8 is not available.";
            C1324b.m7230b(encodeToString);
            return "";
        } finally {
            obtain.recycle();
        }
    }
}
