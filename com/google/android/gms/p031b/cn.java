package com.google.android.gms.p031b;

public class cn implements lp {
    private int f4350a;
    private int f4351b;
    private final int f4352c;
    private final float f4353d;

    public cn() {
        this(2500, 1, 1.0f);
    }

    public cn(int i, int i2, float f) {
        this.f4350a = i;
        this.f4352c = i2;
        this.f4353d = f;
    }

    public int mo1271a() {
        return this.f4350a;
    }

    public void mo1272a(nj njVar) {
        this.f4351b++;
        this.f4350a = (int) (((float) this.f4350a) + (((float) this.f4350a) * this.f4353d));
        if (!m7821c()) {
            throw njVar;
        }
    }

    public int mo1273b() {
        return this.f4351b;
    }

    protected boolean m7821c() {
        return this.f4351b <= this.f4352c;
    }
}
