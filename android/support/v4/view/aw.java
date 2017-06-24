package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class aw {
    static final C0482g f1260a;
    private WeakReference<View> f1261b;
    private Runnable f1262c = null;
    private Runnable f1263d = null;
    private int f1264e = -1;

    interface C0482g {
        long mo429a(aw awVar, View view);

        void mo430a(aw awVar, View view, float f);

        void mo431a(aw awVar, View view, long j);

        void mo432a(aw awVar, View view, ba baVar);

        void mo433a(aw awVar, View view, bc bcVar);

        void mo434a(aw awVar, View view, Interpolator interpolator);

        void mo435b(aw awVar, View view);

        void mo436b(aw awVar, View view, float f);

        void mo437b(aw awVar, View view, long j);

        void mo438c(aw awVar, View view);

        void mo439c(aw awVar, View view, float f);
    }

    static class C0483a implements C0482g {
        WeakHashMap<View, Runnable> f1256a = null;

        class C0481a implements Runnable {
            WeakReference<View> f1253a;
            aw f1254b;
            final /* synthetic */ C0483a f1255c;

            private C0481a(C0483a c0483a, aw awVar, View view) {
                this.f1255c = c0483a;
                this.f1253a = new WeakReference(view);
                this.f1254b = awVar;
            }

            public void run() {
                View view = (View) this.f1253a.get();
                if (view != null) {
                    this.f1255c.m2692d(this.f1254b, view);
                }
            }
        }

        C0483a() {
        }

        private void m2691a(View view) {
            if (this.f1256a != null) {
                Runnable runnable = (Runnable) this.f1256a.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
        }

        private void m2692d(aw awVar, View view) {
            Object tag = view.getTag(2113929216);
            ba baVar = tag instanceof ba ? (ba) tag : null;
            Runnable a = awVar.f1262c;
            Runnable b = awVar.f1263d;
            awVar.f1262c = null;
            awVar.f1263d = null;
            if (a != null) {
                a.run();
            }
            if (baVar != null) {
                baVar.mo98a(view);
                baVar.mo99b(view);
            }
            if (b != null) {
                b.run();
            }
            if (this.f1256a != null) {
                this.f1256a.remove(view);
            }
        }

        private void m2693e(aw awVar, View view) {
            Runnable runnable = this.f1256a != null ? (Runnable) this.f1256a.get(view) : null;
            if (runnable == null) {
                runnable = new C0481a(awVar, view);
                if (this.f1256a == null) {
                    this.f1256a = new WeakHashMap();
                }
                this.f1256a.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }

        public long mo429a(aw awVar, View view) {
            return 0;
        }

        public void mo430a(aw awVar, View view, float f) {
            m2693e(awVar, view);
        }

        public void mo431a(aw awVar, View view, long j) {
        }

        public void mo432a(aw awVar, View view, ba baVar) {
            view.setTag(2113929216, baVar);
        }

        public void mo433a(aw awVar, View view, bc bcVar) {
        }

        public void mo434a(aw awVar, View view, Interpolator interpolator) {
        }

        public void mo435b(aw awVar, View view) {
            m2693e(awVar, view);
        }

        public void mo436b(aw awVar, View view, float f) {
            m2693e(awVar, view);
        }

        public void mo437b(aw awVar, View view, long j) {
        }

        public void mo438c(aw awVar, View view) {
            m2691a(view);
            m2692d(awVar, view);
        }

        public void mo439c(aw awVar, View view, float f) {
            m2693e(awVar, view);
        }
    }

    static class C0485b extends C0483a {
        WeakHashMap<View, Integer> f1259b = null;

        static class C0484a implements ba {
            aw f1257a;
            boolean f1258b;

            C0484a(aw awVar) {
                this.f1257a = awVar;
            }

            public void mo98a(View view) {
                this.f1258b = false;
                if (this.f1257a.f1264e >= 0) {
                    ag.m2514a(view, 2, null);
                }
                if (this.f1257a.f1262c != null) {
                    Runnable a = this.f1257a.f1262c;
                    this.f1257a.f1262c = null;
                    a.run();
                }
                Object tag = view.getTag(2113929216);
                ba baVar = tag instanceof ba ? (ba) tag : null;
                if (baVar != null) {
                    baVar.mo98a(view);
                }
            }

            public void mo99b(View view) {
                if (this.f1257a.f1264e >= 0) {
                    ag.m2514a(view, this.f1257a.f1264e, null);
                    this.f1257a.f1264e = -1;
                }
                if (VERSION.SDK_INT >= 16 || !this.f1258b) {
                    if (this.f1257a.f1263d != null) {
                        Runnable b = this.f1257a.f1263d;
                        this.f1257a.f1263d = null;
                        b.run();
                    }
                    Object tag = view.getTag(2113929216);
                    ba baVar = tag instanceof ba ? (ba) tag : null;
                    if (baVar != null) {
                        baVar.mo99b(view);
                    }
                    this.f1258b = true;
                }
            }

            public void mo100c(View view) {
                Object tag = view.getTag(2113929216);
                ba baVar = tag instanceof ba ? (ba) tag : null;
                if (baVar != null) {
                    baVar.mo100c(view);
                }
            }
        }

        C0485b() {
        }

        public long mo429a(aw awVar, View view) {
            return ax.m2737a(view);
        }

        public void mo430a(aw awVar, View view, float f) {
            ax.m2738a(view, f);
        }

        public void mo431a(aw awVar, View view, long j) {
            ax.m2739a(view, j);
        }

        public void mo432a(aw awVar, View view, ba baVar) {
            view.setTag(2113929216, baVar);
            ax.m2740a(view, new C0484a(awVar));
        }

        public void mo434a(aw awVar, View view, Interpolator interpolator) {
            ax.m2741a(view, interpolator);
        }

        public void mo435b(aw awVar, View view) {
            ax.m2742b(view);
        }

        public void mo436b(aw awVar, View view, float f) {
            ax.m2743b(view, f);
        }

        public void mo437b(aw awVar, View view, long j) {
            ax.m2744b(view, j);
        }

        public void mo438c(aw awVar, View view) {
            ax.m2745c(view);
        }

        public void mo439c(aw awVar, View view, float f) {
            ax.m2746c(view, f);
        }
    }

    static class C0486d extends C0485b {
        C0486d() {
        }

        public void mo432a(aw awVar, View view, ba baVar) {
            ay.m2747a(view, baVar);
        }
    }

    static class C0487c extends C0486d {
        C0487c() {
        }
    }

    static class C0488e extends C0487c {
        C0488e() {
        }

        public void mo433a(aw awVar, View view, bc bcVar) {
            az.m2748a(view, bcVar);
        }
    }

    static class C0489f extends C0488e {
        C0489f() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1260a = new C0489f();
        } else if (i >= 19) {
            f1260a = new C0488e();
        } else if (i >= 18) {
            f1260a = new C0487c();
        } else if (i >= 16) {
            f1260a = new C0486d();
        } else if (i >= 14) {
            f1260a = new C0485b();
        } else {
            f1260a = new C0483a();
        }
    }

    aw(View view) {
        this.f1261b = new WeakReference(view);
    }

    public long m2726a() {
        View view = (View) this.f1261b.get();
        return view != null ? f1260a.mo429a(this, view) : 0;
    }

    public aw m2727a(float f) {
        View view = (View) this.f1261b.get();
        if (view != null) {
            f1260a.mo430a(this, view, f);
        }
        return this;
    }

    public aw m2728a(long j) {
        View view = (View) this.f1261b.get();
        if (view != null) {
            f1260a.mo431a(this, view, j);
        }
        return this;
    }

    public aw m2729a(ba baVar) {
        View view = (View) this.f1261b.get();
        if (view != null) {
            f1260a.mo432a(this, view, baVar);
        }
        return this;
    }

    public aw m2730a(bc bcVar) {
        View view = (View) this.f1261b.get();
        if (view != null) {
            f1260a.mo433a(this, view, bcVar);
        }
        return this;
    }

    public aw m2731a(Interpolator interpolator) {
        View view = (View) this.f1261b.get();
        if (view != null) {
            f1260a.mo434a(this, view, interpolator);
        }
        return this;
    }

    public aw m2732b(float f) {
        View view = (View) this.f1261b.get();
        if (view != null) {
            f1260a.mo436b(this, view, f);
        }
        return this;
    }

    public aw m2733b(long j) {
        View view = (View) this.f1261b.get();
        if (view != null) {
            f1260a.mo437b(this, view, j);
        }
        return this;
    }

    public void m2734b() {
        View view = (View) this.f1261b.get();
        if (view != null) {
            f1260a.mo435b(this, view);
        }
    }

    public aw m2735c(float f) {
        View view = (View) this.f1261b.get();
        if (view != null) {
            f1260a.mo439c(this, view, f);
        }
        return this;
    }

    public void m2736c() {
        View view = (View) this.f1261b.get();
        if (view != null) {
            f1260a.mo438c(this, view);
        }
    }
}
