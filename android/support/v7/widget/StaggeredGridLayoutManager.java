package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.p016a.C0413a;
import android.support.v4.view.p016a.C0426c;
import android.support.v4.view.p016a.C0426c.C0425k;
import android.support.v4.view.p016a.C0450l;
import android.support.v7.widget.RecyclerView.C0761i;
import android.support.v7.widget.RecyclerView.C0763h;
import android.support.v7.widget.RecyclerView.C0763h.C0788a;
import android.support.v7.widget.RecyclerView.C0793n;
import android.support.v7.widget.RecyclerView.C0798r;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends C0763h {
    private final Runnable f2279A = new C08081(this);
    as f2280a;
    as f2281b;
    boolean f2282c = false;
    int f2283d = -1;
    int f2284e = Integer.MIN_VALUE;
    LazySpanLookup f2285f = new LazySpanLookup();
    private int f2286g = -1;
    private C0813c[] f2287h;
    private int f2288i;
    private int f2289j;
    private final an f2290k;
    private boolean f2291l = false;
    private BitSet f2292m;
    private int f2293n = 2;
    private boolean f2294o;
    private boolean f2295t;
    private SavedState f2296u;
    private int f2297v;
    private final Rect f2298w = new Rect();
    private final C0811a f2299x = new C0811a();
    private boolean f2300y = false;
    private boolean f2301z = true;

    class C08081 implements Runnable {
        final /* synthetic */ StaggeredGridLayoutManager f2249a;

        C08081(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f2249a = staggeredGridLayoutManager;
        }

        public void run() {
            this.f2249a.m4677I();
        }
    }

    static class LazySpanLookup {
        int[] f2254a;
        List<FullSpanItem> f2255b;

        static class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new C08091();
            int f2250a;
            int f2251b;
            int[] f2252c;
            boolean f2253d;

            static class C08091 implements Creator<FullSpanItem> {
                C08091() {
                }

                public FullSpanItem m4631a(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public FullSpanItem[] m4632a(int i) {
                    return new FullSpanItem[i];
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return m4631a(parcel);
                }

                public /* synthetic */ Object[] newArray(int i) {
                    return m4632a(i);
                }
            }

            public FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.f2250a = parcel.readInt();
                this.f2251b = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.f2253d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f2252c = new int[readInt];
                    parcel.readIntArray(this.f2252c);
                }
            }

            int m4633a(int i) {
                return this.f2252c == null ? 0 : this.f2252c[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f2250a + ", mGapDir=" + this.f2251b + ", mHasUnwantedGapAfter=" + this.f2253d + ", mGapPerSpan=" + Arrays.toString(this.f2252c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f2250a);
                parcel.writeInt(this.f2251b);
                parcel.writeInt(this.f2253d ? 1 : 0);
                if (this.f2252c == null || this.f2252c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f2252c.length);
                parcel.writeIntArray(this.f2252c);
            }
        }

        LazySpanLookup() {
        }

        private void m4634c(int i, int i2) {
            if (this.f2255b != null) {
                int i3 = i + i2;
                for (int size = this.f2255b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f2255b.get(size);
                    if (fullSpanItem.f2250a >= i) {
                        if (fullSpanItem.f2250a < i3) {
                            this.f2255b.remove(size);
                        } else {
                            fullSpanItem.f2250a -= i2;
                        }
                    }
                }
            }
        }

        private void m4635d(int i, int i2) {
            if (this.f2255b != null) {
                for (int size = this.f2255b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f2255b.get(size);
                    if (fullSpanItem.f2250a >= i) {
                        fullSpanItem.f2250a += i2;
                    }
                }
            }
        }

        private int m4636g(int i) {
            if (this.f2255b == null) {
                return -1;
            }
            FullSpanItem f = m4648f(i);
            if (f != null) {
                this.f2255b.remove(f);
            }
            int size = this.f2255b.size();
            int i2 = 0;
            while (i2 < size) {
                if (((FullSpanItem) this.f2255b.get(i2)).f2250a >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            f = (FullSpanItem) this.f2255b.get(i2);
            this.f2255b.remove(i2);
            return f.f2250a;
        }

        int m4637a(int i) {
            if (this.f2255b != null) {
                for (int size = this.f2255b.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.f2255b.get(size)).f2250a >= i) {
                        this.f2255b.remove(size);
                    }
                }
            }
            return m4643b(i);
        }

        public FullSpanItem m4638a(int i, int i2, int i3, boolean z) {
            if (this.f2255b == null) {
                return null;
            }
            int size = this.f2255b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f2255b.get(i4);
                if (fullSpanItem.f2250a >= i2) {
                    return null;
                }
                if (fullSpanItem.f2250a >= i) {
                    if (i3 == 0 || fullSpanItem.f2251b == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.f2253d) {
                        return fullSpanItem;
                    }
                }
            }
            return null;
        }

        void m4639a() {
            if (this.f2254a != null) {
                Arrays.fill(this.f2254a, -1);
            }
            this.f2255b = null;
        }

        void m4640a(int i, int i2) {
            if (this.f2254a != null && i < this.f2254a.length) {
                m4647e(i + i2);
                System.arraycopy(this.f2254a, i + i2, this.f2254a, i, (this.f2254a.length - i) - i2);
                Arrays.fill(this.f2254a, this.f2254a.length - i2, this.f2254a.length, -1);
                m4634c(i, i2);
            }
        }

        void m4641a(int i, C0813c c0813c) {
            m4647e(i);
            this.f2254a[i] = c0813c.f2276d;
        }

        public void m4642a(FullSpanItem fullSpanItem) {
            if (this.f2255b == null) {
                this.f2255b = new ArrayList();
            }
            int size = this.f2255b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.f2255b.get(i);
                if (fullSpanItem2.f2250a == fullSpanItem.f2250a) {
                    this.f2255b.remove(i);
                }
                if (fullSpanItem2.f2250a >= fullSpanItem.f2250a) {
                    this.f2255b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f2255b.add(fullSpanItem);
        }

        int m4643b(int i) {
            if (this.f2254a == null || i >= this.f2254a.length) {
                return -1;
            }
            int g = m4636g(i);
            if (g == -1) {
                Arrays.fill(this.f2254a, i, this.f2254a.length, -1);
                return this.f2254a.length;
            }
            Arrays.fill(this.f2254a, i, g + 1, -1);
            return g + 1;
        }

        void m4644b(int i, int i2) {
            if (this.f2254a != null && i < this.f2254a.length) {
                m4647e(i + i2);
                System.arraycopy(this.f2254a, i, this.f2254a, i + i2, (this.f2254a.length - i) - i2);
                Arrays.fill(this.f2254a, i, i + i2, -1);
                m4635d(i, i2);
            }
        }

        int m4645c(int i) {
            return (this.f2254a == null || i >= this.f2254a.length) ? -1 : this.f2254a[i];
        }

        int m4646d(int i) {
            int length = this.f2254a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void m4647e(int i) {
            if (this.f2254a == null) {
                this.f2254a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f2254a, -1);
            } else if (i >= this.f2254a.length) {
                Object obj = this.f2254a;
                this.f2254a = new int[m4646d(i)];
                System.arraycopy(obj, 0, this.f2254a, 0, obj.length);
                Arrays.fill(this.f2254a, obj.length, this.f2254a.length, -1);
            }
        }

        public FullSpanItem m4648f(int i) {
            if (this.f2255b == null) {
                return null;
            }
            for (int size = this.f2255b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f2255b.get(size);
                if (fullSpanItem.f2250a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C08101();
        int f2256a;
        int f2257b;
        int f2258c;
        int[] f2259d;
        int f2260e;
        int[] f2261f;
        List<FullSpanItem> f2262g;
        boolean f2263h;
        boolean f2264i;
        boolean f2265j;

        static class C08101 implements Creator<SavedState> {
            C08101() {
            }

            public SavedState m4649a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m4650a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m4649a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m4650a(i);
            }
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            this.f2256a = parcel.readInt();
            this.f2257b = parcel.readInt();
            this.f2258c = parcel.readInt();
            if (this.f2258c > 0) {
                this.f2259d = new int[this.f2258c];
                parcel.readIntArray(this.f2259d);
            }
            this.f2260e = parcel.readInt();
            if (this.f2260e > 0) {
                this.f2261f = new int[this.f2260e];
                parcel.readIntArray(this.f2261f);
            }
            this.f2263h = parcel.readInt() == 1;
            this.f2264i = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f2265j = z;
            this.f2262g = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f2258c = savedState.f2258c;
            this.f2256a = savedState.f2256a;
            this.f2257b = savedState.f2257b;
            this.f2259d = savedState.f2259d;
            this.f2260e = savedState.f2260e;
            this.f2261f = savedState.f2261f;
            this.f2263h = savedState.f2263h;
            this.f2264i = savedState.f2264i;
            this.f2265j = savedState.f2265j;
            this.f2262g = savedState.f2262g;
        }

        void m4651a() {
            this.f2259d = null;
            this.f2258c = 0;
            this.f2260e = 0;
            this.f2261f = null;
            this.f2262g = null;
        }

        void m4652b() {
            this.f2259d = null;
            this.f2258c = 0;
            this.f2256a = -1;
            this.f2257b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            parcel.writeInt(this.f2256a);
            parcel.writeInt(this.f2257b);
            parcel.writeInt(this.f2258c);
            if (this.f2258c > 0) {
                parcel.writeIntArray(this.f2259d);
            }
            parcel.writeInt(this.f2260e);
            if (this.f2260e > 0) {
                parcel.writeIntArray(this.f2261f);
            }
            parcel.writeInt(this.f2263h ? 1 : 0);
            parcel.writeInt(this.f2264i ? 1 : 0);
            if (!this.f2265j) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeList(this.f2262g);
        }
    }

    private class C0811a {
        int f2266a;
        int f2267b;
        boolean f2268c;
        boolean f2269d;
        final /* synthetic */ StaggeredGridLayoutManager f2270e;

        private C0811a(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f2270e = staggeredGridLayoutManager;
        }

        void m4653a() {
            this.f2266a = -1;
            this.f2267b = Integer.MIN_VALUE;
            this.f2268c = false;
            this.f2269d = false;
        }

        void m4654a(int i) {
            if (this.f2268c) {
                this.f2267b = this.f2270e.f2280a.mo812d() - i;
            } else {
                this.f2267b = this.f2270e.f2280a.mo810c() + i;
            }
        }

        void m4655b() {
            this.f2267b = this.f2268c ? this.f2270e.f2280a.mo812d() : this.f2270e.f2280a.mo810c();
        }
    }

    public static class C0812b extends C0761i {
        C0813c f2271e;
        boolean f2272f;

        public C0812b(int i, int i2) {
            super(i, i2);
        }

        public C0812b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0812b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0812b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean m4656a() {
            return this.f2272f;
        }

        public final int m4657b() {
            return this.f2271e == null ? -1 : this.f2271e.f2276d;
        }
    }

    class C0813c {
        int f2273a;
        int f2274b;
        int f2275c;
        final int f2276d;
        final /* synthetic */ StaggeredGridLayoutManager f2277e;
        private ArrayList<View> f2278f;

        private C0813c(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
            this.f2277e = staggeredGridLayoutManager;
            this.f2278f = new ArrayList();
            this.f2273a = Integer.MIN_VALUE;
            this.f2274b = Integer.MIN_VALUE;
            this.f2275c = 0;
            this.f2276d = i;
        }

        int m4659a(int i) {
            if (this.f2273a != Integer.MIN_VALUE) {
                return this.f2273a;
            }
            if (this.f2278f.size() == 0) {
                return i;
            }
            m4661a();
            return this.f2273a;
        }

        public View m4660a(int i, int i2) {
            View view = null;
            int size;
            View view2;
            if (i2 == -1) {
                size = this.f2278f.size();
                int i3 = 0;
                while (i3 < size) {
                    view2 = (View) this.f2278f.get(i3);
                    if (!view2.isFocusable()) {
                        break;
                    }
                    if ((this.f2277e.m4167d(view2) > i) != this.f2277e.f2291l) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            size = this.f2278f.size() - 1;
            while (size >= 0) {
                view2 = (View) this.f2278f.get(size);
                if (!view2.isFocusable()) {
                    break;
                }
                if ((this.f2277e.m4167d(view2) > i ? 1 : null) != (!this.f2277e.f2291l ? 1 : null)) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }

        void m4661a() {
            View view = (View) this.f2278f.get(0);
            C0812b c = m4667c(view);
            this.f2273a = this.f2277e.f2280a.mo807a(view);
            if (c.f2272f) {
                FullSpanItem f = this.f2277e.f2285f.m4648f(c.m4072e());
                if (f != null && f.f2251b == -1) {
                    this.f2273a -= f.m4633a(this.f2276d);
                }
            }
        }

        void m4662a(View view) {
            C0812b c = m4667c(view);
            c.f2271e = this;
            this.f2278f.add(0, view);
            this.f2273a = Integer.MIN_VALUE;
            if (this.f2278f.size() == 1) {
                this.f2274b = Integer.MIN_VALUE;
            }
            if (c.m4070c() || c.m4071d()) {
                this.f2275c += this.f2277e.f2280a.mo811c(view);
            }
        }

        void m4663a(boolean z, int i) {
            int b = z ? m4665b(Integer.MIN_VALUE) : m4659a(Integer.MIN_VALUE);
            m4672e();
            if (b != Integer.MIN_VALUE) {
                if (z && b < this.f2277e.f2280a.mo812d()) {
                    return;
                }
                if (z || b <= this.f2277e.f2280a.mo810c()) {
                    if (i != Integer.MIN_VALUE) {
                        b += i;
                    }
                    this.f2274b = b;
                    this.f2273a = b;
                }
            }
        }

        int m4664b() {
            if (this.f2273a != Integer.MIN_VALUE) {
                return this.f2273a;
            }
            m4661a();
            return this.f2273a;
        }

        int m4665b(int i) {
            if (this.f2274b != Integer.MIN_VALUE) {
                return this.f2274b;
            }
            if (this.f2278f.size() == 0) {
                return i;
            }
            m4668c();
            return this.f2274b;
        }

        void m4666b(View view) {
            C0812b c = m4667c(view);
            c.f2271e = this;
            this.f2278f.add(view);
            this.f2274b = Integer.MIN_VALUE;
            if (this.f2278f.size() == 1) {
                this.f2273a = Integer.MIN_VALUE;
            }
            if (c.m4070c() || c.m4071d()) {
                this.f2275c += this.f2277e.f2280a.mo811c(view);
            }
        }

        C0812b m4667c(View view) {
            return (C0812b) view.getLayoutParams();
        }

        void m4668c() {
            View view = (View) this.f2278f.get(this.f2278f.size() - 1);
            C0812b c = m4667c(view);
            this.f2274b = this.f2277e.f2280a.mo809b(view);
            if (c.f2272f) {
                FullSpanItem f = this.f2277e.f2285f.m4648f(c.m4072e());
                if (f != null && f.f2251b == 1) {
                    this.f2274b = f.m4633a(this.f2276d) + this.f2274b;
                }
            }
        }

        void m4669c(int i) {
            this.f2273a = i;
            this.f2274b = i;
        }

        int m4670d() {
            if (this.f2274b != Integer.MIN_VALUE) {
                return this.f2274b;
            }
            m4668c();
            return this.f2274b;
        }

        void m4671d(int i) {
            if (this.f2273a != Integer.MIN_VALUE) {
                this.f2273a += i;
            }
            if (this.f2274b != Integer.MIN_VALUE) {
                this.f2274b += i;
            }
        }

        void m4672e() {
            this.f2278f.clear();
            m4673f();
            this.f2275c = 0;
        }

        void m4673f() {
            this.f2273a = Integer.MIN_VALUE;
            this.f2274b = Integer.MIN_VALUE;
        }

        void m4674g() {
            int size = this.f2278f.size();
            View view = (View) this.f2278f.remove(size - 1);
            C0812b c = m4667c(view);
            c.f2271e = null;
            if (c.m4070c() || c.m4071d()) {
                this.f2275c -= this.f2277e.f2280a.mo811c(view);
            }
            if (size == 1) {
                this.f2273a = Integer.MIN_VALUE;
            }
            this.f2274b = Integer.MIN_VALUE;
        }

        void m4675h() {
            View view = (View) this.f2278f.remove(0);
            C0812b c = m4667c(view);
            c.f2271e = null;
            if (this.f2278f.size() == 0) {
                this.f2274b = Integer.MIN_VALUE;
            }
            if (c.m4070c() || c.m4071d()) {
                this.f2275c -= this.f2277e.f2280a.mo811c(view);
            }
            this.f2273a = Integer.MIN_VALUE;
        }

        public int m4676i() {
            return this.f2275c;
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.f2288i = i2;
        m4729a(i);
        if (this.f2293n == 0) {
            z = false;
        }
        m4164c(z);
        this.f2290k = new an();
        m4709m();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        C0788a a = C0763h.m4081a(context, attributeSet, i, i2);
        m4747b(a.f2133a);
        m4729a(a.f2134b);
        m4741a(a.f2135c);
        if (this.f2293n == 0) {
            z = false;
        }
        m4164c(z);
        this.f2290k = new an();
        m4709m();
    }

    private boolean m4677I() {
        if (m4204t() == 0 || this.f2293n == 0 || !m4199o()) {
            return false;
        }
        int L;
        int M;
        if (this.f2282c) {
            L = m4680L();
            M = m4681M();
        } else {
            L = m4681M();
            M = m4680L();
        }
        if (L == 0 && m4762f() != null) {
            this.f2285f.m4639a();
            m4097G();
            m4197n();
            return true;
        } else if (!this.f2300y) {
            return false;
        } else {
            int i = this.f2282c ? -1 : 1;
            FullSpanItem a = this.f2285f.m4638a(L, M + 1, i, true);
            if (a == null) {
                this.f2300y = false;
                this.f2285f.m4637a(M + 1);
                return false;
            }
            FullSpanItem a2 = this.f2285f.m4638a(L, a.f2250a, i * -1, true);
            if (a2 == null) {
                this.f2285f.m4637a(a.f2250a);
            } else {
                this.f2285f.m4637a(a2.f2250a + 1);
            }
            m4097G();
            m4197n();
            return true;
        }
    }

    private void m4678J() {
        boolean z = true;
        if (this.f2288i == 1 || !m4765h()) {
            this.f2282c = this.f2291l;
            return;
        }
        if (this.f2291l) {
            z = false;
        }
        this.f2282c = z;
    }

    private void m4679K() {
        if (this.f2281b.mo817h() != 1073741824) {
            float f = 0.0f;
            int t = m4204t();
            int i = 0;
            while (i < t) {
                float f2;
                View h = m4186h(i);
                float c = (float) this.f2281b.mo811c(h);
                if (c < f) {
                    f2 = f;
                } else {
                    f2 = Math.max(f, ((C0812b) h.getLayoutParams()).m4656a() ? (1.0f * c) / ((float) this.f2286g) : c);
                }
                i++;
                f = f2;
            }
            i = this.f2289j;
            int round = Math.round(((float) this.f2286g) * f);
            if (this.f2281b.mo817h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f2281b.mo815f());
            }
            m4759e(round);
            if (this.f2289j != i) {
                for (int i2 = 0; i2 < t; i2++) {
                    View h2 = m4186h(i2);
                    C0812b c0812b = (C0812b) h2.getLayoutParams();
                    if (!c0812b.f2272f) {
                        if (m4765h() && this.f2288i == 1) {
                            h2.offsetLeftAndRight(((-((this.f2286g - 1) - c0812b.f2271e.f2276d)) * this.f2289j) - ((-((this.f2286g - 1) - c0812b.f2271e.f2276d)) * i));
                        } else {
                            int i3 = c0812b.f2271e.f2276d * this.f2289j;
                            round = c0812b.f2271e.f2276d * i;
                            if (this.f2288i == 1) {
                                h2.offsetLeftAndRight(i3 - round);
                            } else {
                                h2.offsetTopAndBottom(i3 - round);
                            }
                        }
                    }
                }
            }
        }
    }

    private int m4680L() {
        int t = m4204t();
        return t == 0 ? 0 : m4167d(m4186h(t - 1));
    }

    private int m4681M() {
        return m4204t() == 0 ? 0 : m4167d(m4186h(0));
    }

    private int m4682a(C0793n c0793n, an anVar, C0798r c0798r) {
        int q;
        this.f2292m.set(0, this.f2286g, true);
        int i = this.f2290k.f2434i ? anVar.f2430e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : anVar.f2430e == 1 ? anVar.f2432g + anVar.f2427b : anVar.f2431f - anVar.f2427b;
        m4704e(anVar.f2430e, i);
        int d = this.f2282c ? this.f2280a.mo812d() : this.f2280a.mo810c();
        Object obj = null;
        while (anVar.m5023a(c0798r) && (this.f2290k.f2434i || !this.f2292m.isEmpty())) {
            C0813c c0813c;
            int c;
            int c2;
            View a = anVar.m5022a(c0793n);
            C0812b c0812b = (C0812b) a.getLayoutParams();
            int e = c0812b.m4072e();
            int c3 = this.f2285f.m4645c(e);
            Object obj2 = c3 == -1 ? 1 : null;
            if (obj2 != null) {
                C0813c a2 = c0812b.f2272f ? this.f2287h[0] : m4684a(anVar);
                this.f2285f.m4641a(e, a2);
                c0813c = a2;
            } else {
                c0813c = this.f2287h[c3];
            }
            c0812b.f2271e = c0813c;
            if (anVar.f2430e == 1) {
                m4150b(a);
            } else {
                m4151b(a, 0);
            }
            m4693a(a, c0812b, false);
            if (anVar.f2430e == 1) {
                q = c0812b.f2272f ? m4714q(d) : c0813c.m4665b(d);
                c = q + this.f2280a.mo811c(a);
                if (obj2 == null || !c0812b.f2272f) {
                    c3 = q;
                } else {
                    FullSpanItem m = m4708m(q);
                    m.f2251b = -1;
                    m.f2250a = e;
                    this.f2285f.m4642a(m);
                    c3 = q;
                }
            } else {
                q = c0812b.f2272f ? m4712p(d) : c0813c.m4659a(d);
                c3 = q - this.f2280a.mo811c(a);
                if (obj2 != null && c0812b.f2272f) {
                    FullSpanItem n = m4710n(q);
                    n.f2251b = 1;
                    n.f2250a = e;
                    this.f2285f.m4642a(n);
                }
                c = q;
            }
            if (c0812b.f2272f && anVar.f2429d == -1) {
                if (obj2 != null) {
                    this.f2300y = true;
                } else {
                    obj = anVar.f2430e == 1 ? !m4769j() ? 1 : null : !m4771l() ? 1 : null;
                    if (obj != null) {
                        FullSpanItem f = this.f2285f.m4648f(e);
                        if (f != null) {
                            f.f2253d = true;
                        }
                        this.f2300y = true;
                    }
                }
            }
            m4692a(a, c0812b, anVar);
            if (m4765h() && this.f2288i == 1) {
                q = c0812b.f2272f ? this.f2281b.mo812d() : this.f2281b.mo812d() - (((this.f2286g - 1) - c0813c.f2276d) * this.f2289j);
                c2 = q - this.f2281b.mo811c(a);
                e = q;
            } else {
                q = c0812b.f2272f ? this.f2281b.mo810c() : (c0813c.f2276d * this.f2289j) + this.f2281b.mo810c();
                e = q + this.f2281b.mo811c(a);
                c2 = q;
            }
            if (this.f2288i == 1) {
                m4699b(a, c2, c3, e, c);
            } else {
                m4699b(a, c3, c2, c, e);
            }
            if (c0812b.f2272f) {
                m4704e(this.f2290k.f2430e, i);
            } else {
                m4690a(c0813c, this.f2290k.f2430e, i);
            }
            m4688a(c0793n, this.f2290k);
            if (this.f2290k.f2433h && a.isFocusable()) {
                if (c0812b.f2272f) {
                    this.f2292m.clear();
                } else {
                    this.f2292m.set(c0813c.f2276d, false);
                }
            }
            obj = 1;
        }
        if (obj == null) {
            m4688a(c0793n, this.f2290k);
        }
        q = this.f2290k.f2430e == -1 ? this.f2280a.mo810c() - m4712p(this.f2280a.mo810c()) : m4714q(this.f2280a.mo812d()) - this.f2280a.mo812d();
        return q > 0 ? Math.min(anVar.f2427b, q) : 0;
    }

    private int m4683a(C0798r c0798r) {
        boolean z = false;
        if (m4204t() == 0) {
            return 0;
        }
        as asVar = this.f2280a;
        View a = m4728a(!this.f2301z, true);
        if (!this.f2301z) {
            z = true;
        }
        return ay.m5163a(c0798r, asVar, a, m4746b(z, true), this, this.f2301z, this.f2282c);
    }

    private C0813c m4684a(an anVar) {
        int i;
        int i2;
        C0813c c0813c = null;
        int i3 = -1;
        if (m4717s(anVar.f2430e)) {
            i = this.f2286g - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.f2286g;
            i3 = 1;
        }
        int c;
        int i4;
        C0813c c0813c2;
        int b;
        C0813c c0813c3;
        if (anVar.f2430e == 1) {
            c = this.f2280a.mo810c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                c0813c2 = this.f2287h[i4];
                b = c0813c2.m4665b(c);
                if (b < i) {
                    c0813c3 = c0813c2;
                } else {
                    b = i;
                    c0813c3 = c0813c;
                }
                i4 += i3;
                c0813c = c0813c3;
                i = b;
            }
        } else {
            c = this.f2280a.mo812d();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                c0813c2 = this.f2287h[i4];
                b = c0813c2.m4659a(c);
                if (b > i) {
                    c0813c3 = c0813c2;
                } else {
                    b = i;
                    c0813c3 = c0813c;
                }
                i4 += i3;
                c0813c = c0813c3;
                i = b;
            }
        }
        return c0813c;
    }

    private void m4685a(int i, C0798r c0798r) {
        int c;
        int i2;
        an anVar;
        boolean z = false;
        this.f2290k.f2427b = 0;
        this.f2290k.f2428c = i;
        if (m4201q()) {
            c = c0798r.m4538c();
            if (c != -1) {
                if (this.f2282c == (c < i)) {
                    c = this.f2280a.mo815f();
                    i2 = 0;
                } else {
                    i2 = this.f2280a.mo815f();
                    c = 0;
                }
                if (m4200p()) {
                    this.f2290k.f2432g = c + this.f2280a.mo814e();
                    this.f2290k.f2431f = -i2;
                } else {
                    this.f2290k.f2431f = this.f2280a.mo810c() - i2;
                    this.f2290k.f2432g = c + this.f2280a.mo812d();
                }
                this.f2290k.f2433h = false;
                this.f2290k.f2426a = true;
                anVar = this.f2290k;
                if (this.f2280a.mo817h() == 0 && this.f2280a.mo814e() == 0) {
                    z = true;
                }
                anVar.f2434i = z;
            }
        }
        c = 0;
        i2 = 0;
        if (m4200p()) {
            this.f2290k.f2432g = c + this.f2280a.mo814e();
            this.f2290k.f2431f = -i2;
        } else {
            this.f2290k.f2431f = this.f2280a.mo810c() - i2;
            this.f2290k.f2432g = c + this.f2280a.mo812d();
        }
        this.f2290k.f2433h = false;
        this.f2290k.f2426a = true;
        anVar = this.f2290k;
        z = true;
        anVar.f2434i = z;
    }

    private void m4686a(C0793n c0793n, int i) {
        while (m4204t() > 0) {
            View h = m4186h(0);
            if (this.f2280a.mo809b(h) <= i) {
                C0812b c0812b = (C0812b) h.getLayoutParams();
                if (c0812b.f2272f) {
                    int i2 = 0;
                    while (i2 < this.f2286g) {
                        if (this.f2287h[i2].f2278f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f2286g; i2++) {
                        this.f2287h[i2].m4675h();
                    }
                } else if (c0812b.f2271e.f2278f.size() != 1) {
                    c0812b.f2271e.m4675h();
                } else {
                    return;
                }
                m4128a(h, c0793n);
            } else {
                return;
            }
        }
    }

    private void m4687a(C0793n c0793n, C0798r c0798r, boolean z) {
        C0811a c0811a = this.f2299x;
        c0811a.m4653a();
        if (!(this.f2296u == null && this.f2283d == -1) && c0798r.m4540e() == 0) {
            m4158c(c0793n);
            return;
        }
        boolean z2;
        if (this.f2296u != null) {
            m4689a(c0811a);
        } else {
            m4678J();
            c0811a.f2268c = this.f2282c;
        }
        m4733a(c0798r, c0811a);
        if (this.f2296u == null && !(c0811a.f2268c == this.f2294o && m4765h() == this.f2295t)) {
            this.f2285f.m4639a();
            c0811a.f2269d = true;
        }
        if (m4204t() > 0 && (this.f2296u == null || this.f2296u.f2258c < 1)) {
            int i;
            if (c0811a.f2269d) {
                for (i = 0; i < this.f2286g; i++) {
                    this.f2287h[i].m4672e();
                    if (c0811a.f2267b != Integer.MIN_VALUE) {
                        this.f2287h[i].m4669c(c0811a.f2267b);
                    }
                }
            } else {
                for (i = 0; i < this.f2286g; i++) {
                    this.f2287h[i].m4663a(this.f2282c, c0811a.f2267b);
                }
            }
        }
        m4111a(c0793n);
        this.f2290k.f2426a = false;
        this.f2300y = false;
        m4759e(this.f2281b.mo815f());
        m4685a(c0811a.f2266a, c0798r);
        if (c0811a.f2268c) {
            m4707l(-1);
            m4682a(c0793n, this.f2290k, c0798r);
            m4707l(1);
            this.f2290k.f2428c = c0811a.f2266a + this.f2290k.f2429d;
            m4682a(c0793n, this.f2290k, c0798r);
        } else {
            m4707l(1);
            m4682a(c0793n, this.f2290k, c0798r);
            m4707l(-1);
            this.f2290k.f2428c = c0811a.f2266a + this.f2290k.f2429d;
            m4682a(c0793n, this.f2290k, c0798r);
        }
        m4679K();
        if (m4204t() > 0) {
            if (this.f2282c) {
                m4698b(c0793n, c0798r, true);
                m4702c(c0793n, c0798r, false);
            } else {
                m4702c(c0793n, c0798r, true);
                m4698b(c0793n, c0798r, false);
            }
        }
        if (!z || c0798r.m4536a()) {
            z2 = false;
        } else {
            z2 = this.f2293n != 0 && m4204t() > 0 && (this.f2300y || m4762f() != null);
            if (z2) {
                m4141a(this.f2279A);
                if (m4677I()) {
                    z2 = true;
                    this.f2283d = -1;
                    this.f2284e = Integer.MIN_VALUE;
                }
            }
            z2 = false;
            this.f2283d = -1;
            this.f2284e = Integer.MIN_VALUE;
        }
        this.f2294o = c0811a.f2268c;
        this.f2295t = m4765h();
        this.f2296u = null;
        if (z2) {
            m4687a(c0793n, c0798r, false);
        }
    }

    private void m4688a(C0793n c0793n, an anVar) {
        if (anVar.f2426a && !anVar.f2434i) {
            if (anVar.f2427b == 0) {
                if (anVar.f2430e == -1) {
                    m4697b(c0793n, anVar.f2432g);
                } else {
                    m4686a(c0793n, anVar.f2431f);
                }
            } else if (anVar.f2430e == -1) {
                r0 = anVar.f2431f - m4711o(anVar.f2431f);
                m4697b(c0793n, r0 < 0 ? anVar.f2432g : anVar.f2432g - Math.min(r0, anVar.f2427b));
            } else {
                r0 = m4716r(anVar.f2432g) - anVar.f2432g;
                m4686a(c0793n, r0 < 0 ? anVar.f2431f : Math.min(r0, anVar.f2427b) + anVar.f2431f);
            }
        }
    }

    private void m4689a(C0811a c0811a) {
        if (this.f2296u.f2258c > 0) {
            if (this.f2296u.f2258c == this.f2286g) {
                for (int i = 0; i < this.f2286g; i++) {
                    this.f2287h[i].m4672e();
                    int i2 = this.f2296u.f2259d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        i2 = this.f2296u.f2264i ? i2 + this.f2280a.mo812d() : i2 + this.f2280a.mo810c();
                    }
                    this.f2287h[i].m4669c(i2);
                }
            } else {
                this.f2296u.m4651a();
                this.f2296u.f2256a = this.f2296u.f2257b;
            }
        }
        this.f2295t = this.f2296u.f2265j;
        m4741a(this.f2296u.f2263h);
        m4678J();
        if (this.f2296u.f2256a != -1) {
            this.f2283d = this.f2296u.f2256a;
            c0811a.f2268c = this.f2296u.f2264i;
        } else {
            c0811a.f2268c = this.f2282c;
        }
        if (this.f2296u.f2260e > 1) {
            this.f2285f.f2254a = this.f2296u.f2261f;
            this.f2285f.f2255b = this.f2296u.f2262g;
        }
    }

    private void m4690a(C0813c c0813c, int i, int i2) {
        int i3 = c0813c.m4676i();
        if (i == -1) {
            if (i3 + c0813c.m4664b() <= i2) {
                this.f2292m.set(c0813c.f2276d, false);
            }
        } else if (c0813c.m4670d() - i3 >= i2) {
            this.f2292m.set(c0813c.f2276d, false);
        }
    }

    private void m4691a(View view, int i, int i2, boolean z) {
        m4126a(view, this.f2298w);
        C0812b c0812b = (C0812b) view.getLayoutParams();
        int b = m4696b(i, c0812b.leftMargin + this.f2298w.left, c0812b.rightMargin + this.f2298w.right);
        int b2 = m4696b(i2, c0812b.topMargin + this.f2298w.top, c0812b.bottomMargin + this.f2298w.bottom);
        if (z ? m4139a(view, b, b2, (C0761i) c0812b) : m4153b(view, b, b2, c0812b)) {
            view.measure(b, b2);
        }
    }

    private void m4692a(View view, C0812b c0812b, an anVar) {
        if (anVar.f2430e == 1) {
            if (c0812b.f2272f) {
                m4713p(view);
            } else {
                c0812b.f2271e.m4666b(view);
            }
        } else if (c0812b.f2272f) {
            m4715q(view);
        } else {
            c0812b.f2271e.m4662a(view);
        }
    }

    private void m4693a(View view, C0812b c0812b, boolean z) {
        if (c0812b.f2272f) {
            if (this.f2288i == 1) {
                m4691a(view, this.f2297v, C0763h.m4080a(m4208x(), m4206v(), 0, c0812b.height, true), z);
            } else {
                m4691a(view, C0763h.m4080a(m4207w(), m4205u(), 0, c0812b.width, true), this.f2297v, z);
            }
        } else if (this.f2288i == 1) {
            m4691a(view, C0763h.m4080a(this.f2289j, m4205u(), 0, c0812b.width, false), C0763h.m4080a(m4208x(), m4206v(), 0, c0812b.height, true), z);
        } else {
            m4691a(view, C0763h.m4080a(m4207w(), m4205u(), 0, c0812b.width, true), C0763h.m4080a(this.f2289j, m4206v(), 0, c0812b.height, false), z);
        }
    }

    private boolean m4694a(C0813c c0813c) {
        boolean z = true;
        if (this.f2282c) {
            if (c0813c.m4670d() < this.f2280a.mo812d()) {
                return !c0813c.m4667c((View) c0813c.f2278f.get(c0813c.f2278f.size() + -1)).f2272f;
            }
        } else if (c0813c.m4664b() > this.f2280a.mo810c()) {
            if (c0813c.m4667c((View) c0813c.f2278f.get(0)).f2272f) {
                z = false;
            }
            return z;
        }
        return false;
    }

    private int m4696b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private void m4697b(C0793n c0793n, int i) {
        int t = m4204t() - 1;
        while (t >= 0) {
            View h = m4186h(t);
            if (this.f2280a.mo807a(h) >= i) {
                C0812b c0812b = (C0812b) h.getLayoutParams();
                if (c0812b.f2272f) {
                    int i2 = 0;
                    while (i2 < this.f2286g) {
                        if (this.f2287h[i2].f2278f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f2286g; i2++) {
                        this.f2287h[i2].m4674g();
                    }
                } else if (c0812b.f2271e.f2278f.size() != 1) {
                    c0812b.f2271e.m4674g();
                } else {
                    return;
                }
                m4128a(h, c0793n);
                t--;
            } else {
                return;
            }
        }
    }

    private void m4698b(C0793n c0793n, C0798r c0798r, boolean z) {
        int q = m4714q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE) {
            q = this.f2280a.mo812d() - q;
            if (q > 0) {
                q -= -m4751c(-q, c0793n, c0798r);
                if (z && q > 0) {
                    this.f2280a.mo808a(q);
                }
            }
        }
    }

    private void m4699b(View view, int i, int i2, int i3, int i4) {
        C0812b c0812b = (C0812b) view.getLayoutParams();
        m4124a(view, i + c0812b.leftMargin, i2 + c0812b.topMargin, i3 - c0812b.rightMargin, i4 - c0812b.bottomMargin);
    }

    private void m4701c(int i, int i2, int i3) {
        int i4;
        int i5;
        int L = this.f2282c ? m4680L() : m4681M();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.f2285f.m4643b(i5);
        switch (i3) {
            case 1:
                this.f2285f.m4644b(i, i2);
                break;
            case 2:
                this.f2285f.m4640a(i, i2);
                break;
            case 8:
                this.f2285f.m4640a(i, 1);
                this.f2285f.m4644b(i2, 1);
                break;
        }
        if (i4 > L) {
            if (i5 <= (this.f2282c ? m4681M() : m4680L())) {
                m4197n();
            }
        }
    }

    private void m4702c(C0793n c0793n, C0798r c0798r, boolean z) {
        int p = m4712p(Integer.MAX_VALUE);
        if (p != Integer.MAX_VALUE) {
            p -= this.f2280a.mo810c();
            if (p > 0) {
                p -= m4751c(p, c0793n, c0798r);
                if (z && p > 0) {
                    this.f2280a.mo808a(-p);
                }
            }
        }
    }

    private boolean m4703c(C0798r c0798r, C0811a c0811a) {
        c0811a.f2266a = this.f2294o ? m4720v(c0798r.m4540e()) : m4719u(c0798r.m4540e());
        c0811a.f2267b = Integer.MIN_VALUE;
        return true;
    }

    private void m4704e(int i, int i2) {
        for (int i3 = 0; i3 < this.f2286g; i3++) {
            if (!this.f2287h[i3].f2278f.isEmpty()) {
                m4690a(this.f2287h[i3], i, i2);
            }
        }
    }

    private int m4705h(C0798r c0798r) {
        boolean z = false;
        if (m4204t() == 0) {
            return 0;
        }
        as asVar = this.f2280a;
        View a = m4728a(!this.f2301z, true);
        if (!this.f2301z) {
            z = true;
        }
        return ay.m5162a(c0798r, asVar, a, m4746b(z, true), this, this.f2301z);
    }

    private int m4706i(C0798r c0798r) {
        boolean z = false;
        if (m4204t() == 0) {
            return 0;
        }
        as asVar = this.f2280a;
        View a = m4728a(!this.f2301z, true);
        if (!this.f2301z) {
            z = true;
        }
        return ay.m5164b(c0798r, asVar, a, m4746b(z, true), this, this.f2301z);
    }

    private void m4707l(int i) {
        int i2 = 1;
        this.f2290k.f2430e = i;
        an anVar = this.f2290k;
        if (this.f2282c != (i == -1)) {
            i2 = -1;
        }
        anVar.f2429d = i2;
    }

    private FullSpanItem m4708m(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f2252c = new int[this.f2286g];
        for (int i2 = 0; i2 < this.f2286g; i2++) {
            fullSpanItem.f2252c[i2] = i - this.f2287h[i2].m4665b(i);
        }
        return fullSpanItem;
    }

    private void m4709m() {
        this.f2280a = as.m5082a(this, this.f2288i);
        this.f2281b = as.m5082a(this, 1 - this.f2288i);
    }

    private FullSpanItem m4710n(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f2252c = new int[this.f2286g];
        for (int i2 = 0; i2 < this.f2286g; i2++) {
            fullSpanItem.f2252c[i2] = this.f2287h[i2].m4659a(i) - i;
        }
        return fullSpanItem;
    }

    private int m4711o(int i) {
        int a = this.f2287h[0].m4659a(i);
        for (int i2 = 1; i2 < this.f2286g; i2++) {
            int a2 = this.f2287h[i2].m4659a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int m4712p(int i) {
        int a = this.f2287h[0].m4659a(i);
        for (int i2 = 1; i2 < this.f2286g; i2++) {
            int a2 = this.f2287h[i2].m4659a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private void m4713p(View view) {
        for (int i = this.f2286g - 1; i >= 0; i--) {
            this.f2287h[i].m4666b(view);
        }
    }

    private int m4714q(int i) {
        int b = this.f2287h[0].m4665b(i);
        for (int i2 = 1; i2 < this.f2286g; i2++) {
            int b2 = this.f2287h[i2].m4665b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private void m4715q(View view) {
        for (int i = this.f2286g - 1; i >= 0; i--) {
            this.f2287h[i].m4662a(view);
        }
    }

    private int m4716r(int i) {
        int b = this.f2287h[0].m4665b(i);
        for (int i2 = 1; i2 < this.f2286g; i2++) {
            int b2 = this.f2287h[i2].m4665b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private boolean m4717s(int i) {
        if (this.f2288i == 0) {
            return (i == -1) != this.f2282c;
        } else {
            return ((i == -1) == this.f2282c) == m4765h();
        }
    }

    private int m4718t(int i) {
        int i2 = -1;
        if (m4204t() == 0) {
            return this.f2282c ? 1 : -1;
        } else {
            if ((i < m4681M()) == this.f2282c) {
                i2 = 1;
            }
            return i2;
        }
    }

    private int m4719u(int i) {
        int t = m4204t();
        for (int i2 = 0; i2 < t; i2++) {
            int d = m4167d(m4186h(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int m4720v(int i) {
        for (int t = m4204t() - 1; t >= 0; t--) {
            int d = m4167d(m4186h(t));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int m4721w(int i) {
        int i2 = 1;
        int i3 = Integer.MIN_VALUE;
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                return this.f2288i != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.f2288i != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                if (this.f2288i != 0) {
                    i2 = Integer.MIN_VALUE;
                }
                return i2;
            case 130:
                if (this.f2288i == 1) {
                    i3 = 1;
                }
                return i3;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public int mo703a(int i, C0793n c0793n, C0798r c0798r) {
        return m4751c(i, c0793n, c0798r);
    }

    public int mo725a(C0793n c0793n, C0798r c0798r) {
        return this.f2288i == 0 ? this.f2286g : super.mo725a(c0793n, c0798r);
    }

    public C0761i mo704a() {
        return this.f2288i == 0 ? new C0812b(-2, -1) : new C0812b(-1, -2);
    }

    public C0761i mo726a(Context context, AttributeSet attributeSet) {
        return new C0812b(context, attributeSet);
    }

    public C0761i mo727a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new C0812b((MarginLayoutParams) layoutParams) : new C0812b(layoutParams);
    }

    public View mo705a(View view, int i, C0793n c0793n, C0798r c0798r) {
        int i2 = 0;
        if (m4204t() == 0) {
            return null;
        }
        View e = m4174e(view);
        if (e == null) {
            return null;
        }
        m4678J();
        int w = m4721w(i);
        if (w == Integer.MIN_VALUE) {
            return null;
        }
        View a;
        C0812b c0812b = (C0812b) e.getLayoutParams();
        boolean z = c0812b.f2272f;
        C0813c c0813c = c0812b.f2271e;
        int L = w == 1 ? m4680L() : m4681M();
        m4685a(L, c0798r);
        m4707l(w);
        this.f2290k.f2428c = this.f2290k.f2429d + L;
        this.f2290k.f2427b = (int) (0.33333334f * ((float) this.f2280a.mo815f()));
        this.f2290k.f2433h = true;
        this.f2290k.f2426a = false;
        m4682a(c0793n, this.f2290k, c0798r);
        this.f2294o = this.f2282c;
        if (!z) {
            a = c0813c.m4660a(L, w);
            if (!(a == null || a == e)) {
                return a;
            }
        }
        if (m4717s(w)) {
            for (int i3 = this.f2286g - 1; i3 >= 0; i3--) {
                View a2 = this.f2287h[i3].m4660a(L, w);
                if (a2 != null && a2 != e) {
                    return a2;
                }
            }
        } else {
            while (i2 < this.f2286g) {
                a = this.f2287h[i2].m4660a(L, w);
                if (a != null && a != e) {
                    return a;
                }
                i2++;
            }
        }
        return null;
    }

    View m4728a(boolean z, boolean z2) {
        int c = this.f2280a.mo810c();
        int d = this.f2280a.mo812d();
        int t = m4204t();
        View view = null;
        for (int i = 0; i < t; i++) {
            View h = m4186h(i);
            int a = this.f2280a.mo807a(h);
            if (this.f2280a.mo809b(h) > c && a < d) {
                if (a >= c || !z) {
                    return h;
                }
                if (z2 && view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    public void m4729a(int i) {
        mo709a(null);
        if (i != this.f2286g) {
            m4764g();
            this.f2286g = i;
            this.f2292m = new BitSet(this.f2286g);
            this.f2287h = new C0813c[this.f2286g];
            for (int i2 = 0; i2 < this.f2286g; i2++) {
                this.f2287h[i2] = new C0813c(i2);
            }
            m4197n();
        }
    }

    public void mo729a(Rect rect, int i, int i2) {
        int A = m4091A() + m4209y();
        int z = m4210z() + m4092B();
        if (this.f2288i == 1) {
            z = C0763h.m4079a(i2, z + rect.height(), m4095E());
            A = C0763h.m4079a(i, A + (this.f2289j * this.f2286g), m4094D());
        } else {
            A = C0763h.m4079a(i, A + rect.width(), m4094D());
            z = C0763h.m4079a(i2, z + (this.f2289j * this.f2286g), m4095E());
        }
        m4170d(A, z);
    }

    public void mo706a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f2296u = (SavedState) parcelable;
            m4197n();
        }
    }

    public void mo732a(C0793n c0793n, C0798r c0798r, View view, C0426c c0426c) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C0812b) {
            C0812b c0812b = (C0812b) layoutParams;
            if (this.f2288i == 0) {
                c0426c.m2197b(C0425k.m2183a(c0812b.m4657b(), c0812b.f2272f ? this.f2286g : 1, -1, -1, c0812b.f2272f, false));
                return;
            } else {
                c0426c.m2197b(C0425k.m2183a(-1, -1, c0812b.m4657b(), c0812b.f2272f ? this.f2286g : 1, c0812b.f2272f, false));
                return;
            }
        }
        super.m4127a(view, c0426c);
    }

    void m4733a(C0798r c0798r, C0811a c0811a) {
        if (!m4750b(c0798r, c0811a) && !m4703c(c0798r, c0811a)) {
            c0811a.m4655b();
            c0811a.f2266a = 0;
        }
    }

    public void mo733a(RecyclerView recyclerView) {
        this.f2285f.m4639a();
        m4197n();
    }

    public void mo734a(RecyclerView recyclerView, int i, int i2) {
        m4701c(i, i2, 1);
    }

    public void mo735a(RecyclerView recyclerView, int i, int i2, int i3) {
        m4701c(i, i2, 8);
    }

    public void mo736a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m4701c(i, i2, 4);
    }

    public void mo707a(RecyclerView recyclerView, C0793n c0793n) {
        m4141a(this.f2279A);
        for (int i = 0; i < this.f2286g; i++) {
            this.f2287h[i].m4672e();
        }
    }

    public void mo708a(AccessibilityEvent accessibilityEvent) {
        super.mo708a(accessibilityEvent);
        if (m4204t() > 0) {
            C0450l a = C0413a.m2088a(accessibilityEvent);
            View a2 = m4728a(false, true);
            View b = m4746b(false, true);
            if (a2 != null && b != null) {
                int d = m4167d(a2);
                int d2 = m4167d(b);
                if (d < d2) {
                    a.m2297b(d);
                    a.m2298c(d2);
                    return;
                }
                a.m2297b(d2);
                a.m2298c(d);
            }
        }
    }

    public void mo709a(String str) {
        if (this.f2296u == null) {
            super.mo709a(str);
        }
    }

    public void m4741a(boolean z) {
        mo709a(null);
        if (!(this.f2296u == null || this.f2296u.f2263h == z)) {
            this.f2296u.f2263h = z;
        }
        this.f2291l = z;
        m4197n();
    }

    public boolean mo738a(C0761i c0761i) {
        return c0761i instanceof C0812b;
    }

    public int mo710b(int i, C0793n c0793n, C0798r c0798r) {
        return m4751c(i, c0793n, c0798r);
    }

    public int mo739b(C0793n c0793n, C0798r c0798r) {
        return this.f2288i == 1 ? this.f2286g : super.mo739b(c0793n, c0798r);
    }

    public int mo711b(C0798r c0798r) {
        return m4683a(c0798r);
    }

    View m4746b(boolean z, boolean z2) {
        int c = this.f2280a.mo810c();
        int d = this.f2280a.mo812d();
        View view = null;
        for (int t = m4204t() - 1; t >= 0; t--) {
            View h = m4186h(t);
            int a = this.f2280a.mo807a(h);
            int b = this.f2280a.mo809b(h);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return h;
                }
                if (z2 && view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    public void m4747b(int i) {
        if (i == 0 || i == 1) {
            mo709a(null);
            if (i != this.f2288i) {
                this.f2288i = i;
                as asVar = this.f2280a;
                this.f2280a = this.f2281b;
                this.f2281b = asVar;
                m4197n();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void mo740b(RecyclerView recyclerView, int i, int i2) {
        m4701c(i, i2, 2);
    }

    public boolean mo712b() {
        return this.f2296u == null;
    }

    boolean m4750b(C0798r c0798r, C0811a c0811a) {
        boolean z = false;
        if (c0798r.m4536a() || this.f2283d == -1) {
            return false;
        }
        if (this.f2283d < 0 || this.f2283d >= c0798r.m4540e()) {
            this.f2283d = -1;
            this.f2284e = Integer.MIN_VALUE;
            return false;
        } else if (this.f2296u == null || this.f2296u.f2256a == -1 || this.f2296u.f2258c < 1) {
            View c = mo715c(this.f2283d);
            if (c != null) {
                c0811a.f2266a = this.f2282c ? m4680L() : m4681M();
                if (this.f2284e != Integer.MIN_VALUE) {
                    if (c0811a.f2268c) {
                        c0811a.f2267b = (this.f2280a.mo812d() - this.f2284e) - this.f2280a.mo809b(c);
                        return true;
                    }
                    c0811a.f2267b = (this.f2280a.mo810c() + this.f2284e) - this.f2280a.mo807a(c);
                    return true;
                } else if (this.f2280a.mo811c(c) > this.f2280a.mo815f()) {
                    c0811a.f2267b = c0811a.f2268c ? this.f2280a.mo812d() : this.f2280a.mo810c();
                    return true;
                } else {
                    int a = this.f2280a.mo807a(c) - this.f2280a.mo810c();
                    if (a < 0) {
                        c0811a.f2267b = -a;
                        return true;
                    }
                    a = this.f2280a.mo812d() - this.f2280a.mo809b(c);
                    if (a < 0) {
                        c0811a.f2267b = a;
                        return true;
                    }
                    c0811a.f2267b = Integer.MIN_VALUE;
                    return true;
                }
            }
            c0811a.f2266a = this.f2283d;
            if (this.f2284e == Integer.MIN_VALUE) {
                if (m4718t(c0811a.f2266a) == 1) {
                    z = true;
                }
                c0811a.f2268c = z;
                c0811a.m4655b();
            } else {
                c0811a.m4654a(this.f2284e);
            }
            c0811a.f2269d = true;
            return true;
        } else {
            c0811a.f2267b = Integer.MIN_VALUE;
            c0811a.f2266a = this.f2283d;
            return true;
        }
    }

    int m4751c(int i, C0793n c0793n, C0798r c0798r) {
        int L;
        int i2;
        if (i > 0) {
            L = m4680L();
            i2 = 1;
        } else {
            i2 = -1;
            L = m4681M();
        }
        this.f2290k.f2426a = true;
        m4685a(L, c0798r);
        m4707l(i2);
        this.f2290k.f2428c = this.f2290k.f2429d + L;
        int abs = Math.abs(i);
        this.f2290k.f2427b = abs;
        i2 = m4682a(c0793n, this.f2290k, c0798r);
        if (abs >= i2) {
            i = i < 0 ? -i2 : i2;
        }
        this.f2280a.mo808a(-i);
        this.f2294o = this.f2282c;
        return i;
    }

    public int mo713c(C0798r c0798r) {
        return m4683a(c0798r);
    }

    public Parcelable mo714c() {
        if (this.f2296u != null) {
            return new SavedState(this.f2296u);
        }
        SavedState savedState = new SavedState();
        savedState.f2263h = this.f2291l;
        savedState.f2264i = this.f2294o;
        savedState.f2265j = this.f2295t;
        if (this.f2285f == null || this.f2285f.f2254a == null) {
            savedState.f2260e = 0;
        } else {
            savedState.f2261f = this.f2285f.f2254a;
            savedState.f2260e = savedState.f2261f.length;
            savedState.f2262g = this.f2285f.f2255b;
        }
        if (m4204t() > 0) {
            savedState.f2256a = this.f2294o ? m4680L() : m4681M();
            savedState.f2257b = m4766i();
            savedState.f2258c = this.f2286g;
            savedState.f2259d = new int[this.f2286g];
            for (int i = 0; i < this.f2286g; i++) {
                int b;
                if (this.f2294o) {
                    b = this.f2287h[i].m4665b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f2280a.mo812d();
                    }
                } else {
                    b = this.f2287h[i].m4659a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f2280a.mo810c();
                    }
                }
                savedState.f2259d[i] = b;
            }
        } else {
            savedState.f2256a = -1;
            savedState.f2257b = -1;
            savedState.f2258c = 0;
        }
        return savedState;
    }

    public void mo716c(C0793n c0793n, C0798r c0798r) {
        m4687a(c0793n, c0798r, true);
    }

    public int mo717d(C0798r c0798r) {
        return m4705h(c0798r);
    }

    public void mo718d(int i) {
        if (!(this.f2296u == null || this.f2296u.f2256a == i)) {
            this.f2296u.m4652b();
        }
        this.f2283d = i;
        this.f2284e = Integer.MIN_VALUE;
        m4197n();
    }

    public boolean mo719d() {
        return this.f2288i == 0;
    }

    public int mo720e(C0798r c0798r) {
        return m4705h(c0798r);
    }

    void m4759e(int i) {
        this.f2289j = i / this.f2286g;
        this.f2297v = MeasureSpec.makeMeasureSpec(i, this.f2281b.mo817h());
    }

    public boolean mo721e() {
        return this.f2288i == 1;
    }

    public int mo722f(C0798r c0798r) {
        return m4706i(c0798r);
    }

    View m4762f() {
        int i;
        int t = m4204t() - 1;
        BitSet bitSet = new BitSet(this.f2286g);
        bitSet.set(0, this.f2286g, true);
        boolean z = (this.f2288i == 1 && m4765h()) ? true : true;
        if (this.f2282c) {
            i = -1;
        } else {
            i = t + 1;
            t = 0;
        }
        int i2 = t < i ? 1 : -1;
        int i3 = t;
        while (i3 != i) {
            View h = m4186h(i3);
            C0812b c0812b = (C0812b) h.getLayoutParams();
            if (bitSet.get(c0812b.f2271e.f2276d)) {
                if (m4694a(c0812b.f2271e)) {
                    return h;
                }
                bitSet.clear(c0812b.f2271e.f2276d);
            }
            if (!(c0812b.f2272f || i3 + i2 == i)) {
                boolean z2;
                View h2 = m4186h(i3 + i2);
                int b;
                if (this.f2282c) {
                    t = this.f2280a.mo809b(h);
                    b = this.f2280a.mo809b(h2);
                    if (t < b) {
                        return h;
                    }
                    if (t == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    t = this.f2280a.mo807a(h);
                    b = this.f2280a.mo807a(h2);
                    if (t > b) {
                        return h;
                    }
                    if (t == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if ((c0812b.f2271e.f2276d - ((C0812b) h2.getLayoutParams()).f2271e.f2276d < 0) != (z >= false)) {
                        return h;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    public int mo723g(C0798r c0798r) {
        return m4706i(c0798r);
    }

    public void m4764g() {
        this.f2285f.m4639a();
        m4197n();
    }

    boolean m4765h() {
        return m4202r() == 1;
    }

    int m4766i() {
        View b = this.f2282c ? m4746b(true, true) : m4728a(true, true);
        return b == null ? -1 : m4167d(b);
    }

    public void mo768i(int i) {
        super.mo768i(i);
        for (int i2 = 0; i2 < this.f2286g; i2++) {
            this.f2287h[i2].m4671d(i);
        }
    }

    public void mo769j(int i) {
        super.mo769j(i);
        for (int i2 = 0; i2 < this.f2286g; i2++) {
            this.f2287h[i2].m4671d(i);
        }
    }

    boolean m4769j() {
        int b = this.f2287h[0].m4665b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f2286g; i++) {
            if (this.f2287h[i].m4665b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    public void mo770k(int i) {
        if (i == 0) {
            m4677I();
        }
    }

    boolean m4771l() {
        int a = this.f2287h[0].m4659a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f2286g; i++) {
            if (this.f2287h[i].m4659a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }
}
