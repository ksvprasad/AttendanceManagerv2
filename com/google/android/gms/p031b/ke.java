package com.google.android.gms.p031b;

import com.google.android.gms.common.internal.C1895b;
import java.util.ArrayList;
import java.util.List;

@id
public class ke {
    private final String[] f5597a;
    private final double[] f5598b;
    private final double[] f5599c;
    private final int[] f5600d;
    private int f5601e;

    public static class C1673a {
        public final String f5589a;
        public final double f5590b;
        public final double f5591c;
        public final double f5592d;
        public final int f5593e;

        public C1673a(String str, double d, double d2, double d3, int i) {
            this.f5589a = str;
            this.f5591c = d;
            this.f5590b = d2;
            this.f5592d = d3;
            this.f5593e = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1673a)) {
                return false;
            }
            C1673a c1673a = (C1673a) obj;
            return C1895b.m10789a(this.f5589a, c1673a.f5589a) && this.f5590b == c1673a.f5590b && this.f5591c == c1673a.f5591c && this.f5593e == c1673a.f5593e && Double.compare(this.f5592d, c1673a.f5592d) == 0;
        }

        public int hashCode() {
            return C1895b.m10787a(this.f5589a, Double.valueOf(this.f5590b), Double.valueOf(this.f5591c), Double.valueOf(this.f5592d), Integer.valueOf(this.f5593e));
        }

        public String toString() {
            return C1895b.m10788a((Object) this).m10786a("name", this.f5589a).m10786a("minBound", Double.valueOf(this.f5591c)).m10786a("maxBound", Double.valueOf(this.f5590b)).m10786a("percent", Double.valueOf(this.f5592d)).m10786a("count", Integer.valueOf(this.f5593e)).toString();
        }
    }

    public static class C1674b {
        private final List<String> f5594a = new ArrayList();
        private final List<Double> f5595b = new ArrayList();
        private final List<Double> f5596c = new ArrayList();

        public C1674b m9317a(String str, double d, double d2) {
            int i = 0;
            while (i < this.f5594a.size()) {
                double doubleValue = ((Double) this.f5596c.get(i)).doubleValue();
                double doubleValue2 = ((Double) this.f5595b.get(i)).doubleValue();
                if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                    break;
                }
                i++;
            }
            this.f5594a.add(i, str);
            this.f5596c.add(i, Double.valueOf(d));
            this.f5595b.add(i, Double.valueOf(d2));
            return this;
        }

        public ke m9318a() {
            return new ke();
        }
    }

    private ke(C1674b c1674b) {
        int size = c1674b.f5595b.size();
        this.f5597a = (String[]) c1674b.f5594a.toArray(new String[size]);
        this.f5598b = m9319a(c1674b.f5595b);
        this.f5599c = m9319a(c1674b.f5596c);
        this.f5600d = new int[size];
        this.f5601e = 0;
    }

    private double[] m9319a(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public List<C1673a> m9320a() {
        List<C1673a> arrayList = new ArrayList(this.f5597a.length);
        for (int i = 0; i < this.f5597a.length; i++) {
            arrayList.add(new C1673a(this.f5597a[i], this.f5599c[i], this.f5598b[i], ((double) this.f5600d[i]) / ((double) this.f5601e), this.f5600d[i]));
        }
        return arrayList;
    }

    public void m9321a(double d) {
        this.f5601e++;
        int i = 0;
        while (i < this.f5599c.length) {
            if (this.f5599c[i] <= d && d < this.f5598b[i]) {
                int[] iArr = this.f5600d;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.f5599c[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
