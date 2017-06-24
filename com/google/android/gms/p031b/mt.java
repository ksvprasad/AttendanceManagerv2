package com.google.android.gms.p031b;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.C1864a.C1721c;
import com.google.android.gms.p031b.mc.C1714a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface mt {

    public interface C1744a {
        void mo1576a(int i, boolean z);

        void mo1577a(Bundle bundle);

        void mo1578a(ConnectionResult connectionResult);
    }

    <A extends C1721c, R extends C1857g, T extends C1714a<R, A>> T mo1579a(T t);

    void mo1580a();

    void mo1581a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    <A extends C1721c, T extends C1714a<? extends C1857g, A>> T mo1582b(T t);

    void mo1583b();

    boolean mo1584c();

    void mo1585d();
}
