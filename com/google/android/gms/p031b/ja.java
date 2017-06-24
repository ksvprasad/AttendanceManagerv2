package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.reward.mediation.client.C1308a.C1310a;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;

@id
public class ja extends C1310a {
    private iy f5392a;
    private jb f5393b;
    private iz f5394c;

    public ja(iz izVar) {
        this.f5394c = izVar;
    }

    public void mo1211a(C0998a c0998a) {
        if (this.f5392a != null) {
            this.f5392a.mo1457c();
        }
    }

    public void mo1212a(C0998a c0998a, int i) {
        if (this.f5392a != null) {
            this.f5392a.mo1454a(i);
        }
    }

    public void mo1213a(C0998a c0998a, RewardItemParcel rewardItemParcel) {
        if (this.f5394c != null) {
            this.f5394c.mo1453b(rewardItemParcel);
        }
    }

    public void m9051a(iy iyVar) {
        this.f5392a = iyVar;
    }

    public void m9052a(jb jbVar) {
        this.f5393b = jbVar;
    }

    public void mo1214b(C0998a c0998a) {
        if (this.f5393b != null) {
            this.f5393b.mo1455a(C1001b.m5714a(c0998a).getClass().getName());
        }
    }

    public void mo1215b(C0998a c0998a, int i) {
        if (this.f5393b != null) {
            this.f5393b.mo1456a(C1001b.m5714a(c0998a).getClass().getName(), i);
        }
    }

    public void mo1216c(C0998a c0998a) {
        if (this.f5394c != null) {
            this.f5394c.mo1448F();
        }
    }

    public void mo1217d(C0998a c0998a) {
        if (this.f5394c != null) {
            this.f5394c.mo1449G();
        }
    }

    public void mo1218e(C0998a c0998a) {
        if (this.f5394c != null) {
            this.f5394c.mo1450H();
        }
    }

    public void mo1219f(C0998a c0998a) {
        if (this.f5394c != null) {
            this.f5394c.mo1451I();
        }
    }

    public void mo1220g(C0998a c0998a) {
        if (this.f5394c != null) {
            this.f5394c.mo1452J();
        }
    }
}
