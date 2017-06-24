package android.support.v7.widget;

class ax {
    private int f2527a = 0;
    private int f2528b = 0;
    private int f2529c = Integer.MIN_VALUE;
    private int f2530d = Integer.MIN_VALUE;
    private int f2531e = 0;
    private int f2532f = 0;
    private boolean f2533g = false;
    private boolean f2534h = false;

    ax() {
    }

    public int m5155a() {
        return this.f2527a;
    }

    public void m5156a(int i, int i2) {
        this.f2529c = i;
        this.f2530d = i2;
        this.f2534h = true;
        if (this.f2533g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f2527a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f2528b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f2527a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2528b = i2;
        }
    }

    public void m5157a(boolean z) {
        if (z != this.f2533g) {
            this.f2533g = z;
            if (!this.f2534h) {
                this.f2527a = this.f2531e;
                this.f2528b = this.f2532f;
            } else if (z) {
                this.f2527a = this.f2530d != Integer.MIN_VALUE ? this.f2530d : this.f2531e;
                this.f2528b = this.f2529c != Integer.MIN_VALUE ? this.f2529c : this.f2532f;
            } else {
                this.f2527a = this.f2529c != Integer.MIN_VALUE ? this.f2529c : this.f2531e;
                this.f2528b = this.f2530d != Integer.MIN_VALUE ? this.f2530d : this.f2532f;
            }
        }
    }

    public int m5158b() {
        return this.f2528b;
    }

    public void m5159b(int i, int i2) {
        this.f2534h = false;
        if (i != Integer.MIN_VALUE) {
            this.f2531e = i;
            this.f2527a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2532f = i2;
            this.f2528b = i2;
        }
    }

    public int m5160c() {
        return this.f2533g ? this.f2528b : this.f2527a;
    }

    public int m5161d() {
        return this.f2533g ? this.f2527a : this.f2528b;
    }
}
