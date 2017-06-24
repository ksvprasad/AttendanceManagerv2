package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.fc.C1494a;
import com.google.android.gms.p031b.kt.C1161c;
import com.google.android.gms.p031b.kt.C1261a;
import com.google.android.gms.p031b.kt.C1687b;
import java.util.Map;

@id
public class ff {
    private final Object f4780a;
    private final Context f4781b;
    private final String f4782c;
    private final VersionInfoParcel f4783d;
    private kd<fc> f4784e;
    private kd<fc> f4785f;
    private C1524d f4786g;
    private int f4787h;

    static class C1514a {
        static int f4756a = 60000;
        static int f4757b = 10000;
    }

    public static class C1515b<T> implements kd<T> {
        public void mo1187a(T t) {
        }
    }

    public static class C1519c extends ku<fg> {
        private final Object f4765d = new Object();
        private final C1524d f4766e;
        private boolean f4767f;

        class C15161 implements C1161c<fg> {
            final /* synthetic */ C1519c f4758a;

            C15161(C1519c c1519c) {
                this.f4758a = c1519c;
            }

            public void m8263a(fg fgVar) {
                jv.m9152e("Ending javascript session.");
                ((fh) fgVar).mo1331a();
            }

            public /* synthetic */ void mo1101a(Object obj) {
                m8263a((fg) obj);
            }
        }

        class C15172 implements C1161c<fg> {
            final /* synthetic */ C1519c f4759a;

            C15172(C1519c c1519c) {
                this.f4759a = c1519c;
            }

            public void m8265a(fg fgVar) {
                jv.m9152e("Releasing engine reference.");
                this.f4759a.f4766e.j_();
            }

            public /* synthetic */ void mo1101a(Object obj) {
                m8265a((fg) obj);
            }
        }

        class C15183 implements C1261a {
            final /* synthetic */ C1519c f4760a;

            C15183(C1519c c1519c) {
                this.f4760a = c1519c;
            }

            public void mo1175a() {
                this.f4760a.f4766e.j_();
            }
        }

        public C1519c(C1524d c1524d) {
            this.f4766e = c1524d;
        }

        public void h_() {
            synchronized (this.f4765d) {
                if (this.f4767f) {
                    return;
                }
                this.f4767f = true;
                mo1327a(new C15161(this), new C1687b());
                mo1327a(new C15172(this), new C15183(this));
            }
        }
    }

    public static class C1524d extends ku<fc> {
        private final Object f4775d = new Object();
        private kd<fc> f4776e;
        private boolean f4777f;
        private int f4778g;

        class C15233 implements C1161c<fc> {
            final /* synthetic */ C1524d f4774a;

            C15233(C1524d c1524d) {
                this.f4774a = c1524d;
            }

            public void m8278a(final fc fcVar) {
                C1319u.m7183e().m9222a(new Runnable(this) {
                    final /* synthetic */ C15233 f4773b;

                    public void run() {
                        this.f4773b.f4774a.f4776e.mo1187a(fcVar);
                        fcVar.mo1315a();
                    }
                });
            }

            public /* synthetic */ void mo1101a(Object obj) {
                m8278a((fc) obj);
            }
        }

        public C1524d(kd<fc> kdVar) {
            this.f4776e = kdVar;
            this.f4777f = false;
            this.f4778g = 0;
        }

        public void m8281c() {
            boolean z = true;
            synchronized (this.f4775d) {
                if (this.f4778g < 0) {
                    z = false;
                }
                C1896c.m10794a(z);
                jv.m9152e("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.f4777f = true;
                m8282d();
            }
        }

        protected void m8282d() {
            synchronized (this.f4775d) {
                C1896c.m10794a(this.f4778g >= 0);
                if (this.f4777f && this.f4778g == 0) {
                    jv.m9152e("No reference is left (including root). Cleaning up engine.");
                    mo1327a(new C15233(this), new C1687b());
                } else {
                    jv.m9152e("There are still references to the engine. Not destroying.");
                }
            }
        }

        public C1519c i_() {
            final C1519c c1519c = new C1519c(this);
            synchronized (this.f4775d) {
                mo1327a(new C1161c<fc>(this) {
                    final /* synthetic */ C1524d f4769b;

                    public void m8275a(fc fcVar) {
                        jv.m9152e("Getting a new session for JS Engine.");
                        c1519c.mo1328a(fcVar.mo1322b());
                    }

                    public /* synthetic */ void mo1101a(Object obj) {
                        m8275a((fc) obj);
                    }
                }, new C1261a(this) {
                    final /* synthetic */ C1524d f4771b;

                    public void mo1175a() {
                        jv.m9152e("Rejecting reference for JS Engine.");
                        c1519c.mo1329a();
                    }
                });
                C1896c.m10794a(this.f4778g >= 0);
                this.f4778g++;
            }
            return c1519c;
        }

        protected void j_() {
            boolean z = true;
            synchronized (this.f4775d) {
                if (this.f4778g < 1) {
                    z = false;
                }
                C1896c.m10794a(z);
                jv.m9152e("Releasing 1 reference for JS Engine");
                this.f4778g--;
                m8282d();
            }
        }
    }

    public static class C1525e extends ku<fg> {
        private C1519c f4779d;

        public C1525e(C1519c c1519c) {
            this.f4779d = c1519c;
        }

        public void mo1329a() {
            this.f4779d.mo1329a();
        }

        public void m8284a(fg fgVar) {
            this.f4779d.mo1328a(fgVar);
        }

        public void mo1327a(C1161c<fg> c1161c, C1261a c1261a) {
            this.f4779d.mo1327a(c1161c, c1261a);
        }

        public /* synthetic */ void mo1328a(Object obj) {
            m8284a((fg) obj);
        }

        public int mo1330b() {
            return this.f4779d.mo1330b();
        }

        public void finalize() {
            this.f4779d.h_();
            this.f4779d = null;
        }
    }

    public ff(Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.f4780a = new Object();
        this.f4787h = 1;
        this.f4782c = str;
        this.f4781b = context.getApplicationContext();
        this.f4783d = versionInfoParcel;
        this.f4784e = new C1515b();
        this.f4785f = new C1515b();
    }

    public ff(Context context, VersionInfoParcel versionInfoParcel, String str, kd<fc> kdVar, kd<fc> kdVar2) {
        this(context, versionInfoParcel, str);
        this.f4784e = kdVar;
        this.f4785f = kdVar2;
    }

    private C1524d m8292c(final aj ajVar) {
        final C1524d c1524d = new C1524d(this.f4785f);
        C1319u.m7183e().m9222a(new Runnable(this) {
            final /* synthetic */ ff f4751c;

            public void run() {
                final fc a = this.f4751c.m8298a(this.f4751c.f4781b, this.f4751c.f4783d, ajVar);
                a.mo1317a(new C1494a(this) {
                    final /* synthetic */ C15111 f4740b;

                    class C15051 implements Runnable {
                        final /* synthetic */ C15061 f4738a;

                        class C15041 implements Runnable {
                            final /* synthetic */ C15051 f4737a;

                            C15041(C15051 c15051) {
                                this.f4737a = c15051;
                            }

                            public void run() {
                                a.mo1315a();
                            }
                        }

                        C15051(C15061 c15061) {
                            this.f4738a = c15061;
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                            r3 = this;
                            r0 = r3.f4738a;
                            r0 = r0.f4740b;
                            r0 = r0.f4751c;
                            r1 = r0.f4780a;
                            monitor-enter(r1);
                            r0 = r3.f4738a;	 Catch:{ all -> 0x0043 }
                            r0 = r0.f4740b;	 Catch:{ all -> 0x0043 }
                            r0 = r0;	 Catch:{ all -> 0x0043 }
                            r0 = r0.mo1330b();	 Catch:{ all -> 0x0043 }
                            r2 = -1;
                            if (r0 == r2) goto L_0x0025;
                        L_0x0018:
                            r0 = r3.f4738a;	 Catch:{ all -> 0x0043 }
                            r0 = r0.f4740b;	 Catch:{ all -> 0x0043 }
                            r0 = r0;	 Catch:{ all -> 0x0043 }
                            r0 = r0.mo1330b();	 Catch:{ all -> 0x0043 }
                            r2 = 1;
                            if (r0 != r2) goto L_0x0027;
                        L_0x0025:
                            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                        L_0x0026:
                            return;
                        L_0x0027:
                            r0 = r3.f4738a;	 Catch:{ all -> 0x0043 }
                            r0 = r0.f4740b;	 Catch:{ all -> 0x0043 }
                            r0 = r0;	 Catch:{ all -> 0x0043 }
                            r0.mo1329a();	 Catch:{ all -> 0x0043 }
                            r0 = com.google.android.gms.ads.internal.C1319u.m7183e();	 Catch:{ all -> 0x0043 }
                            r2 = new com.google.android.gms.b.ff$1$1$1$1;	 Catch:{ all -> 0x0043 }
                            r2.<init>(r3);	 Catch:{ all -> 0x0043 }
                            r0.m9222a(r2);	 Catch:{ all -> 0x0043 }
                            r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                            com.google.android.gms.p031b.jv.m9152e(r0);	 Catch:{ all -> 0x0043 }
                            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                            goto L_0x0026;
                        L_0x0043:
                            r0 = move-exception;
                            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                            throw r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.ff.1.1.1.run():void");
                        }
                    }

                    public void mo1313a() {
                        jz.f5567a.postDelayed(new C15051(this), (long) C1514a.f4757b);
                    }
                });
                a.mo1319a("/jsLoaded", new eb(this) {
                    final /* synthetic */ C15111 f4742b;

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void mo997a(com.google.android.gms.p031b.la r4, java.util.Map<java.lang.String, java.lang.String> r5) {
                        /*
                        r3 = this;
                        r0 = r3.f4742b;
                        r0 = r0.f4751c;
                        r1 = r0.f4780a;
                        monitor-enter(r1);
                        r0 = r3.f4742b;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.mo1330b();	 Catch:{ all -> 0x0051 }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.f4742b;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.mo1330b();	 Catch:{ all -> 0x0051 }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.f4742b;	 Catch:{ all -> 0x0051 }
                        r0 = r0.f4751c;	 Catch:{ all -> 0x0051 }
                        r2 = 0;
                        r0.f4787h = r2;	 Catch:{ all -> 0x0051 }
                        r0 = r3.f4742b;	 Catch:{ all -> 0x0051 }
                        r0 = r0.f4751c;	 Catch:{ all -> 0x0051 }
                        r0 = r0.f4784e;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.mo1187a(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.f4742b;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.mo1328a(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.f4742b;	 Catch:{ all -> 0x0051 }
                        r0 = r0.f4751c;	 Catch:{ all -> 0x0051 }
                        r2 = r3.f4742b;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.f4786g = r2;	 Catch:{ all -> 0x0051 }
                        r0 = "Successfully loaded JS Engine.";
                        com.google.android.gms.p031b.jv.m9152e(r0);	 Catch:{ all -> 0x0051 }
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        goto L_0x0020;
                    L_0x0051:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.ff.1.2.a(com.google.android.gms.b.la, java.util.Map):void");
                    }
                });
                final kk kkVar = new kk();
                eb c15083 = new eb(this) {
                    final /* synthetic */ C15111 f4745c;

                    public void mo997a(la laVar, Map<String, String> map) {
                        synchronized (this.f4745c.f4751c.f4780a) {
                            C1324b.m7232c("JS Engine is requesting an update");
                            if (this.f4745c.f4751c.f4787h == 0) {
                                C1324b.m7232c("Starting reload.");
                                this.f4745c.f4751c.f4787h = 2;
                                this.f4745c.f4751c.m8300a(ajVar);
                            }
                            a.mo1324b("/requestReload", (eb) kkVar.m9350a());
                        }
                    }
                };
                kkVar.m9351a(c15083);
                a.mo1319a("/requestReload", c15083);
                if (this.f4751c.f4782c.endsWith(".js")) {
                    a.mo1318a(this.f4751c.f4782c);
                } else if (this.f4751c.f4782c.startsWith("<html>")) {
                    a.mo1326c(this.f4751c.f4782c);
                } else {
                    a.mo1323b(this.f4751c.f4782c);
                }
                jz.f5567a.postDelayed(new Runnable(this) {
                    final /* synthetic */ C15111 f4748b;

                    class C15091 implements Runnable {
                        final /* synthetic */ C15104 f4746a;

                        C15091(C15104 c15104) {
                            this.f4746a = c15104;
                        }

                        public void run() {
                            a.mo1315a();
                        }
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                        r3 = this;
                        r0 = r3.f4748b;
                        r0 = r0.f4751c;
                        r1 = r0.f4780a;
                        monitor-enter(r1);
                        r0 = r3.f4748b;	 Catch:{ all -> 0x003b }
                        r0 = r0;	 Catch:{ all -> 0x003b }
                        r0 = r0.mo1330b();	 Catch:{ all -> 0x003b }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.f4748b;	 Catch:{ all -> 0x003b }
                        r0 = r0;	 Catch:{ all -> 0x003b }
                        r0 = r0.mo1330b();	 Catch:{ all -> 0x003b }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x003b }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.f4748b;	 Catch:{ all -> 0x003b }
                        r0 = r0;	 Catch:{ all -> 0x003b }
                        r0.mo1329a();	 Catch:{ all -> 0x003b }
                        r0 = com.google.android.gms.ads.internal.C1319u.m7183e();	 Catch:{ all -> 0x003b }
                        r2 = new com.google.android.gms.b.ff$1$4$1;	 Catch:{ all -> 0x003b }
                        r2.<init>(r3);	 Catch:{ all -> 0x003b }
                        r0.m9222a(r2);	 Catch:{ all -> 0x003b }
                        r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                        com.google.android.gms.p031b.jv.m9152e(r0);	 Catch:{ all -> 0x003b }
                        monitor-exit(r1);	 Catch:{ all -> 0x003b }
                        goto L_0x0020;
                    L_0x003b:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x003b }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.ff.1.4.run():void");
                    }
                }, (long) C1514a.f4756a);
            }
        });
        return c1524d;
    }

    protected fc m8298a(Context context, VersionInfoParcel versionInfoParcel, aj ajVar) {
        return new fe(context, versionInfoParcel, ajVar);
    }

    public C1519c m8299a() {
        return m8301b(null);
    }

    protected C1524d m8300a(aj ajVar) {
        final C1524d c = m8292c(ajVar);
        c.mo1327a(new C1161c<fc>(this) {
            final /* synthetic */ ff f4753b;

            public void m8259a(fc fcVar) {
                synchronized (this.f4753b.f4780a) {
                    this.f4753b.f4787h = 0;
                    if (!(this.f4753b.f4786g == null || c == this.f4753b.f4786g)) {
                        jv.m9152e("New JS engine is loaded, marking previous one as destroyable.");
                        this.f4753b.f4786g.m8281c();
                    }
                    this.f4753b.f4786g = c;
                }
            }

            public /* synthetic */ void mo1101a(Object obj) {
                m8259a((fc) obj);
            }
        }, new C1261a(this) {
            final /* synthetic */ ff f4755b;

            public void mo1175a() {
                synchronized (this.f4755b.f4780a) {
                    this.f4755b.f4787h = 1;
                    jv.m9152e("Failed loading new engine. Marking new engine destroyable.");
                    c.m8281c();
                }
            }
        });
        return c;
    }

    public C1519c m8301b(aj ajVar) {
        C1519c i_;
        synchronized (this.f4780a) {
            if (this.f4786g == null || this.f4786g.mo1330b() == -1) {
                this.f4787h = 2;
                this.f4786g = m8300a(ajVar);
                i_ = this.f4786g.i_();
            } else if (this.f4787h == 0) {
                i_ = this.f4786g.i_();
            } else if (this.f4787h == 1) {
                this.f4787h = 2;
                m8300a(ajVar);
                i_ = this.f4786g.i_();
            } else if (this.f4787h == 2) {
                i_ = this.f4786g.i_();
            } else {
                i_ = this.f4786g.i_();
            }
        }
        return i_;
    }
}
