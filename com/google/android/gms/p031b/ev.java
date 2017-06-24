package com.google.android.gms.p031b;

import android.os.Handler;
import com.google.android.gms.ads.internal.C1173l;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.ab.C1059a;
import com.google.android.gms.ads.internal.client.ac.C1061a;
import com.google.android.gms.ads.internal.client.ai.C1072a;
import com.google.android.gms.ads.internal.reward.client.C1292a;
import com.google.android.gms.ads.internal.reward.client.C1301d.C1303a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.dc.C1415a;
import com.google.android.gms.p031b.hd.C1469a;
import java.util.LinkedList;
import java.util.List;

@id
class ev {
    private final List<C1459a> f4608a = new LinkedList();

    interface C1459a {
        void mo1311a(ew ewVar);
    }

    class C14651 extends C1061a {
        final /* synthetic */ ev f4582a;

        class C14601 implements C1459a {
            final /* synthetic */ C14651 f4576a;

            C14601(C14651 c14651) {
                this.f4576a = c14651;
            }

            public void mo1311a(ew ewVar) {
                if (ewVar.f4611a != null) {
                    ewVar.f4611a.mo1006a();
                }
                C1319u.m7194p().m8138a();
            }
        }

        class C14623 implements C1459a {
            final /* synthetic */ C14651 f4579a;

            C14623(C14651 c14651) {
                this.f4579a = c14651;
            }

            public void mo1311a(ew ewVar) {
                if (ewVar.f4611a != null) {
                    ewVar.f4611a.mo1008b();
                }
            }
        }

        class C14634 implements C1459a {
            final /* synthetic */ C14651 f4580a;

            C14634(C14651 c14651) {
                this.f4580a = c14651;
            }

            public void mo1311a(ew ewVar) {
                if (ewVar.f4611a != null) {
                    ewVar.f4611a.mo1009c();
                }
            }
        }

        class C14645 implements C1459a {
            final /* synthetic */ C14651 f4581a;

            C14645(C14651 c14651) {
                this.f4581a = c14651;
            }

            public void mo1311a(ew ewVar) {
                if (ewVar.f4611a != null) {
                    ewVar.f4611a.mo1010d();
                }
            }
        }

        C14651(ev evVar) {
            this.f4582a = evVar;
        }

        public void mo1006a() {
            this.f4582a.f4608a.add(new C14601(this));
        }

        public void mo1007a(final int i) {
            this.f4582a.f4608a.add(new C1459a(this) {
                final /* synthetic */ C14651 f4578b;

                public void mo1311a(ew ewVar) {
                    if (ewVar.f4611a != null) {
                        ewVar.f4611a.mo1007a(i);
                    }
                }
            });
            jv.m9152e("Pooled interstitial failed to load.");
        }

        public void mo1008b() {
            this.f4582a.f4608a.add(new C14623(this));
        }

        public void mo1009c() {
            this.f4582a.f4608a.add(new C14634(this));
            jv.m9152e("Pooled interstitial loaded.");
        }

        public void mo1010d() {
            this.f4582a.f4608a.add(new C14645(this));
        }
    }

    class C14672 extends C1072a {
        final /* synthetic */ ev f4586a;

        C14672(ev evVar) {
            this.f4586a = evVar;
        }

        public void mo1024a(final String str, final String str2) {
            this.f4586a.f4608a.add(new C1459a(this) {
                final /* synthetic */ C14672 f4585c;

                public void mo1311a(ew ewVar) {
                    if (ewVar.f4612b != null) {
                        ewVar.f4612b.mo1024a(str, str2);
                    }
                }
            });
        }
    }

    class C14703 extends C1469a {
        final /* synthetic */ ev f4589a;

        C14703(ev evVar) {
            this.f4589a = evVar;
        }

        public void mo1312a(final hc hcVar) {
            this.f4589a.f4608a.add(new C1459a(this) {
                final /* synthetic */ C14703 f4588b;

                public void mo1311a(ew ewVar) {
                    if (ewVar.f4613c != null) {
                        ewVar.f4613c.mo1312a(hcVar);
                    }
                }
            });
        }
    }

    class C14724 extends C1415a {
        final /* synthetic */ ev f4592a;

        C14724(ev evVar) {
            this.f4592a = evVar;
        }

        public void mo1280a(final db dbVar) {
            this.f4592a.f4608a.add(new C1459a(this) {
                final /* synthetic */ C14724 f4591b;

                public void mo1311a(ew ewVar) {
                    if (ewVar.f4614d != null) {
                        ewVar.f4614d.mo1280a(dbVar);
                    }
                }
            });
        }
    }

    class C14745 extends C1059a {
        final /* synthetic */ ev f4594a;

        class C14731 implements C1459a {
            final /* synthetic */ C14745 f4593a;

            C14731(C14745 c14745) {
                this.f4593a = c14745;
            }

            public void mo1311a(ew ewVar) {
                if (ewVar.f4615e != null) {
                    ewVar.f4615e.mo1005a();
                }
            }
        }

        C14745(ev evVar) {
            this.f4594a = evVar;
        }

        public void mo1005a() {
            this.f4594a.f4608a.add(new C14731(this));
        }
    }

    class C14826 extends C1303a {
        final /* synthetic */ ev f4604a;

        class C14751 implements C1459a {
            final /* synthetic */ C14826 f4595a;

            C14751(C14826 c14826) {
                this.f4595a = c14826;
            }

            public void mo1311a(ew ewVar) {
                if (ewVar.f4616f != null) {
                    ewVar.f4616f.mo1202a();
                }
            }
        }

        class C14762 implements C1459a {
            final /* synthetic */ C14826 f4596a;

            C14762(C14826 c14826) {
                this.f4596a = c14826;
            }

            public void mo1311a(ew ewVar) {
                if (ewVar.f4616f != null) {
                    ewVar.f4616f.mo1205b();
                }
            }
        }

        class C14773 implements C1459a {
            final /* synthetic */ C14826 f4597a;

            C14773(C14826 c14826) {
                this.f4597a = c14826;
            }

            public void mo1311a(ew ewVar) {
                if (ewVar.f4616f != null) {
                    ewVar.f4616f.mo1206c();
                }
            }
        }

        class C14784 implements C1459a {
            final /* synthetic */ C14826 f4598a;

            C14784(C14826 c14826) {
                this.f4598a = c14826;
            }

            public void mo1311a(ew ewVar) {
                if (ewVar.f4616f != null) {
                    ewVar.f4616f.mo1207d();
                }
            }
        }

        class C14806 implements C1459a {
            final /* synthetic */ C14826 f4601a;

            C14806(C14826 c14826) {
                this.f4601a = c14826;
            }

            public void mo1311a(ew ewVar) {
                if (ewVar.f4616f != null) {
                    ewVar.f4616f.mo1208e();
                }
            }
        }

        C14826(ev evVar) {
            this.f4604a = evVar;
        }

        public void mo1202a() {
            this.f4604a.f4608a.add(new C14751(this));
        }

        public void mo1203a(final int i) {
            this.f4604a.f4608a.add(new C1459a(this) {
                final /* synthetic */ C14826 f4603b;

                public void mo1311a(ew ewVar) {
                    if (ewVar.f4616f != null) {
                        ewVar.f4616f.mo1203a(i);
                    }
                }
            });
        }

        public void mo1204a(final C1292a c1292a) {
            this.f4604a.f4608a.add(new C1459a(this) {
                final /* synthetic */ C14826 f4600b;

                public void mo1311a(ew ewVar) {
                    if (ewVar.f4616f != null) {
                        ewVar.f4616f.mo1204a(c1292a);
                    }
                }
            });
        }

        public void mo1205b() {
            this.f4604a.f4608a.add(new C14762(this));
        }

        public void mo1206c() {
            this.f4604a.f4608a.add(new C14773(this));
        }

        public void mo1207d() {
            this.f4604a.f4608a.add(new C14784(this));
        }

        public void mo1208e() {
            this.f4604a.f4608a.add(new C14806(this));
        }
    }

    ev() {
    }

    void m8120a(C1173l c1173l) {
        c1173l.mo952a(new C14651(this));
        c1173l.mo953a(new C14672(this));
        c1173l.mo957a(new C14703(this));
        c1173l.mo956a(new C14724(this));
        c1173l.mo951a(new C14745(this));
        c1173l.mo955a(new C14826(this));
    }

    void m8121a(final ew ewVar) {
        Handler handler = jz.f5567a;
        for (final C1459a c1459a : this.f4608a) {
            handler.post(new Runnable(this) {
                final /* synthetic */ ev f4607c;

                public void run() {
                    try {
                        c1459a.mo1311a(ewVar);
                    } catch (Throwable e) {
                        C1324b.m7235d("Could not propagate interstitial ad event.", e);
                    }
                }
            });
        }
    }
}
