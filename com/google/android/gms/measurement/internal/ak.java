package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1983p;
import com.google.android.gms.measurement.internal.C2046y.C2047a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class ak extends C2047a {
    private final aj f6874a;
    private final boolean f6875b;

    public ak(aj ajVar) {
        C1896c.m10790a((Object) ajVar);
        this.f6874a = ajVar;
        this.f6875b = false;
    }

    public ak(aj ajVar, boolean z) {
        C1896c.m10790a((Object) ajVar);
        this.f6874a = ajVar;
        this.f6875b = z;
    }

    private void m11534c(AppMetadata appMetadata) {
        C1896c.m10790a((Object) appMetadata);
        m11535c(appMetadata.f6657b);
        this.f6874a.m11510n().m11786g(appMetadata.f6658c);
    }

    private void m11535c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f6874a.m11502f().m11290f().m11249a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            m11544b(str);
        } catch (SecurityException e) {
            this.f6874a.m11502f().m11290f().m11250a("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    public List<UserAttributeParcel> mo1752a(final AppMetadata appMetadata, boolean z) {
        Object e;
        m11534c(appMetadata);
        try {
            List<C2081l> list = (List) this.f6874a.m11504h().m11423a(new Callable<List<C2081l>>(this) {
                final /* synthetic */ ak f6871b;

                public List<C2081l> m11524a() {
                    this.f6871b.f6874a.m11476J();
                    return this.f6871b.f6874a.m11511o().m11903a(appMetadata.f6657b);
                }

                public /* synthetic */ Object call() {
                    return m11524a();
                }
            }).get();
            List<UserAttributeParcel> arrayList = new ArrayList(list.size());
            for (C2081l c2081l : list) {
                if (z || !C2082m.m11758k(c2081l.f6962b)) {
                    arrayList.add(new UserAttributeParcel(c2081l));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.f6874a.m11502f().m11290f().m11250a("Failed to get user attributes", e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.f6874a.m11502f().m11290f().m11250a("Failed to get user attributes", e);
            return null;
        }
    }

    public void mo1753a(final AppMetadata appMetadata) {
        m11534c(appMetadata);
        this.f6874a.m11504h().m11424a(new Runnable(this) {
            final /* synthetic */ ak f6873b;

            public void run() {
                this.f6873b.f6874a.m11476J();
                this.f6873b.m11541a(appMetadata.f6663h);
                this.f6873b.f6874a.m11492b(appMetadata);
            }
        });
    }

    public void mo1754a(final EventParcel eventParcel, final AppMetadata appMetadata) {
        C1896c.m10790a((Object) eventParcel);
        m11534c(appMetadata);
        this.f6874a.m11504h().m11424a(new Runnable(this) {
            final /* synthetic */ ak f6856c;

            public void run() {
                this.f6856c.f6874a.m11476J();
                this.f6856c.m11541a(appMetadata.f6663h);
                this.f6856c.f6874a.m11482a(eventParcel, appMetadata);
            }
        });
    }

    public void mo1755a(final EventParcel eventParcel, final String str, final String str2) {
        C1896c.m10790a((Object) eventParcel);
        C1896c.m10792a(str);
        m11535c(str);
        this.f6874a.m11504h().m11424a(new Runnable(this) {
            final /* synthetic */ ak f6860d;

            public void run() {
                this.f6860d.f6874a.m11476J();
                this.f6860d.m11541a(str2);
                this.f6860d.f6874a.m11483a(eventParcel, str);
            }
        });
    }

    public void mo1756a(final UserAttributeParcel userAttributeParcel, final AppMetadata appMetadata) {
        C1896c.m10790a((Object) userAttributeParcel);
        m11534c(appMetadata);
        if (userAttributeParcel.m11201a() == null) {
            this.f6874a.m11504h().m11424a(new Runnable(this) {
                final /* synthetic */ ak f6866c;

                public void run() {
                    this.f6866c.f6874a.m11476J();
                    this.f6866c.m11541a(appMetadata.f6663h);
                    this.f6866c.f6874a.m11494b(userAttributeParcel, appMetadata);
                }
            });
        } else {
            this.f6874a.m11504h().m11424a(new Runnable(this) {
                final /* synthetic */ ak f6869c;

                public void run() {
                    this.f6869c.f6874a.m11476J();
                    this.f6869c.m11541a(appMetadata.f6663h);
                    this.f6869c.f6874a.m11484a(userAttributeParcel, appMetadata);
                }
            });
        }
    }

    void m11541a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.f6874a.m11501e().f6771b.m11358a(split[1], longValue);
                    } else {
                        this.f6874a.m11502f().m11310z().m11250a("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.f6874a.m11502f().m11310z().m11250a("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }

    public byte[] mo1757a(final EventParcel eventParcel, final String str) {
        Object e;
        C1896c.m10792a(str);
        C1896c.m10790a((Object) eventParcel);
        m11535c(str);
        this.f6874a.m11502f().m11282D().m11250a("Log and bundle. event", eventParcel.f6673b);
        long c = this.f6874a.m11514r().mo1725c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f6874a.m11504h().m11425b(new Callable<byte[]>(this) {
                final /* synthetic */ ak f6863c;

                public byte[] m11523a() {
                    this.f6863c.f6874a.m11476J();
                    return this.f6863c.f6874a.m11496b(eventParcel, str);
                }

                public /* synthetic */ Object call() {
                    return m11523a();
                }
            }).get();
            if (bArr == null) {
                this.f6874a.m11502f().m11290f().m11249a("Log and bundle returned null");
                bArr = new byte[0];
            }
            this.f6874a.m11502f().m11282D().m11252a("Log and bundle processed. event, size, time_ms", eventParcel.f6673b, Integer.valueOf(bArr.length), Long.valueOf((this.f6874a.m11514r().mo1725c() / 1000000) - c));
            return bArr;
        } catch (InterruptedException e2) {
            e = e2;
            this.f6874a.m11502f().m11290f().m11251a("Failed to log and bundle. event, error", eventParcel.f6673b, e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.f6874a.m11502f().m11290f().m11251a("Failed to log and bundle. event, error", eventParcel.f6673b, e);
            return null;
        }
    }

    public void mo1758b(final AppMetadata appMetadata) {
        m11534c(appMetadata);
        this.f6874a.m11504h().m11424a(new Runnable(this) {
            final /* synthetic */ ak f6853b;

            public void run() {
                this.f6853b.f6874a.m11476J();
                this.f6853b.m11541a(appMetadata.f6663h);
                this.f6853b.f6874a.m11480a(appMetadata);
            }
        });
    }

    protected void m11544b(String str) {
        int myUid = this.f6875b ? Process.myUid() : Binder.getCallingUid();
        if (!C1983p.m11126a(this.f6874a.m11513q(), myUid, str)) {
            if (!C1983p.m11125a(this.f6874a.m11513q(), myUid) || this.f6874a.m11469C()) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        }
    }
}
