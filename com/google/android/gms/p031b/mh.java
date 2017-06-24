package com.google.android.gms.p031b;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1872n;
import java.util.Iterator;

public class mh extends md {
    protected void mo1570a(ConnectionResult connectionResult, int i) {
        mq mqVar = null;
        mqVar.m10064b(connectionResult, i);
    }

    public void mo1568b() {
        Object obj = null;
        super.mo1568b();
        Iterator it = obj.iterator();
        while (it.hasNext()) {
            ((C1872n) it.next()).m10593a();
        }
        obj.clear();
        obj.m10061a(this);
    }

    protected void mo1572c() {
        mq mqVar = null;
        mqVar.m10063b();
    }
}
