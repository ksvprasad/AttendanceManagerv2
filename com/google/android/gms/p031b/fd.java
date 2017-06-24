package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.fc.C1494a;
import java.util.concurrent.Future;

@id
public class fd {

    private static class C1497a<JavascriptEngine> extends kn<JavascriptEngine> {
        JavascriptEngine f4721a;

        private C1497a() {
        }
    }

    private fc m8238a(Context context, VersionInfoParcel versionInfoParcel, final C1497a<fc> c1497a, aj ajVar) {
        fc feVar = new fe(context, versionInfoParcel, ajVar);
        c1497a.f4721a = feVar;
        feVar.mo1317a(new C1494a(this) {
            final /* synthetic */ fd f4715b;

            public void mo1313a() {
                c1497a.m8236b((Object) (fc) c1497a.f4721a);
            }
        });
        return feVar;
    }

    public Future<fc> m8240a(Context context, VersionInfoParcel versionInfoParcel, String str, aj ajVar) {
        final Future c1497a = new C1497a();
        final Context context2 = context;
        final VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        final aj ajVar2 = ajVar;
        final String str2 = str;
        jz.f5567a.post(new Runnable(this) {
            final /* synthetic */ fd f4713f;

            public void run() {
                this.f4713f.m8238a(context2, versionInfoParcel2, c1497a, ajVar2).mo1323b(str2);
            }
        });
        return c1497a;
    }
}
