package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.ArrayList;
import java.util.Iterator;

@id
public class by {
    private final int f4273a;
    private final int f4274b;
    private final int f4275c;
    private final cd f4276d;
    private final Object f4277e = new Object();
    private ArrayList<String> f4278f = new ArrayList();
    private ArrayList<String> f4279g = new ArrayList();
    private int f4280h = 0;
    private int f4281i = 0;
    private int f4282j = 0;
    private int f4283k;
    private String f4284l = "";
    private String f4285m = "";

    public by(int i, int i2, int i3, int i4) {
        this.f4273a = i;
        this.f4274b = i2;
        this.f4275c = i3;
        this.f4276d = new cd(i4);
    }

    private String m7684a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= i ? stringBuffer2.substring(0, i) : stringBuffer2;
    }

    private void m7685c(String str, boolean z) {
        if (str != null && str.length() >= this.f4275c) {
            synchronized (this.f4277e) {
                this.f4278f.add(str);
                this.f4280h += str.length();
                if (z) {
                    this.f4279g.add(str);
                }
            }
        }
    }

    int m7686a(int i, int i2) {
        return (this.f4273a * i) + (this.f4274b * i2);
    }

    public void m7687a(int i) {
        this.f4281i = i;
    }

    public void m7688a(String str, boolean z) {
        m7685c(str, z);
        synchronized (this.f4277e) {
            if (this.f4282j < 0) {
                C1324b.m7227a("ActivityContent: negative number of WebViews.");
            }
            m7696g();
        }
    }

    public boolean m7689a() {
        boolean z;
        synchronized (this.f4277e) {
            z = this.f4282j == 0;
        }
        return z;
    }

    public String m7690b() {
        return this.f4284l;
    }

    public void m7691b(String str, boolean z) {
        m7685c(str, z);
    }

    public String m7692c() {
        return this.f4285m;
    }

    public void m7693d() {
        synchronized (this.f4277e) {
            this.f4283k -= 100;
        }
    }

    public void m7694e() {
        synchronized (this.f4277e) {
            this.f4282j--;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof by)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        by byVar = (by) obj;
        return byVar.m7690b() != null && byVar.m7690b().equals(m7690b());
    }

    public void m7695f() {
        synchronized (this.f4277e) {
            this.f4282j++;
        }
    }

    public void m7696g() {
        synchronized (this.f4277e) {
            int a = m7686a(this.f4280h, this.f4281i);
            if (a > this.f4283k) {
                this.f4283k = a;
                this.f4284l = this.f4276d.m7765a(this.f4278f);
                this.f4285m = this.f4276d.m7765a(this.f4279g);
            }
        }
    }

    public int m7697h() {
        return this.f4283k;
    }

    public int hashCode() {
        return m7690b().hashCode();
    }

    int m7698i() {
        return this.f4280h;
    }

    public String toString() {
        int i = this.f4281i;
        int i2 = this.f4283k;
        int i3 = this.f4280h;
        String valueOf = String.valueOf(m7684a(this.f4278f, 100));
        String valueOf2 = String.valueOf(m7684a(this.f4279g, 100));
        String str = this.f4284l;
        String str2 = this.f4285m;
        return new StringBuilder((((String.valueOf(valueOf).length() + 133) + String.valueOf(valueOf2).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()).append("ActivityContent fetchId: ").append(i).append(" score:").append(i2).append(" total_length:").append(i3).append("\n text: ").append(valueOf).append("\n viewableText").append(valueOf2).append("\n signture: ").append(str).append("\n viewableSignture: ").append(str2).toString();
    }
}
