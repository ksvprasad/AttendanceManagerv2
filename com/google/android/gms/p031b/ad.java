package com.google.android.gms.p031b;

import java.util.Arrays;

public interface ad {

    public static final class C1359a extends C1358t<C1359a> implements Cloneable {
        public String[] f4061a;
        public String[] f4062b;
        public int[] f4063c;
        public long[] f4064d;
        public long[] f4065e;

        public C1359a() {
            m7358b();
        }

        protected int mo1230a() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int a = super.mo1230a();
            if (this.f4061a == null || this.f4061a.length <= 0) {
                i = a;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.f4061a) {
                    if (str != null) {
                        i3++;
                        i2 += C1843s.m10425b(str);
                    }
                }
                i = (a + i2) + (i3 * 1);
            }
            if (this.f4062b != null && this.f4062b.length > 0) {
                i3 = 0;
                a = 0;
                for (String str2 : this.f4062b) {
                    if (str2 != null) {
                        a++;
                        i3 += C1843s.m10425b(str2);
                    }
                }
                i = (i + i3) + (a * 1);
            }
            if (this.f4063c != null && this.f4063c.length > 0) {
                i3 = 0;
                for (int a2 : this.f4063c) {
                    i3 += C1843s.m10417b(a2);
                }
                i = (i + i3) + (this.f4063c.length * 1);
            }
            if (this.f4064d != null && this.f4064d.length > 0) {
                i3 = 0;
                for (long e : this.f4064d) {
                    i3 += C1843s.m10436e(e);
                }
                i = (i + i3) + (this.f4064d.length * 1);
            }
            if (this.f4065e == null || this.f4065e.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i4 < this.f4065e.length) {
                i2 += C1843s.m10436e(this.f4065e[i4]);
                i4++;
            }
            return (i + i2) + (this.f4065e.length * 1);
        }

        public C1359a m7356a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                int b;
                Object obj;
                int c;
                Object obj2;
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        b = ac.m7339b(c1841r, 10);
                        a = this.f4061a == null ? 0 : this.f4061a.length;
                        obj = new String[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f4061a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c1841r.m10398i();
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = c1841r.m10398i();
                        this.f4061a = obj;
                        continue;
                    case 18:
                        b = ac.m7339b(c1841r, 18);
                        a = this.f4062b == null ? 0 : this.f4062b.length;
                        obj = new String[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f4062b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c1841r.m10398i();
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = c1841r.m10398i();
                        this.f4062b = obj;
                        continue;
                    case 24:
                        b = ac.m7339b(c1841r, 24);
                        a = this.f4063c == null ? 0 : this.f4063c.length;
                        obj = new int[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f4063c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c1841r.m10396g();
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = c1841r.m10396g();
                        this.f4063c = obj;
                        continue;
                    case 26:
                        c = c1841r.m10389c(c1841r.m10401l());
                        b = c1841r.m10407r();
                        a = 0;
                        while (c1841r.m10405p() > 0) {
                            c1841r.m10396g();
                            a++;
                        }
                        c1841r.m10393e(b);
                        b = this.f4063c == null ? 0 : this.f4063c.length;
                        obj2 = new int[(a + b)];
                        if (b != 0) {
                            System.arraycopy(this.f4063c, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = c1841r.m10396g();
                            b++;
                        }
                        this.f4063c = obj2;
                        c1841r.m10391d(c);
                        continue;
                    case 32:
                        b = ac.m7339b(c1841r, 32);
                        a = this.f4064d == null ? 0 : this.f4064d.length;
                        obj = new long[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f4064d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c1841r.m10394f();
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = c1841r.m10394f();
                        this.f4064d = obj;
                        continue;
                    case 34:
                        c = c1841r.m10389c(c1841r.m10401l());
                        b = c1841r.m10407r();
                        a = 0;
                        while (c1841r.m10405p() > 0) {
                            c1841r.m10394f();
                            a++;
                        }
                        c1841r.m10393e(b);
                        b = this.f4064d == null ? 0 : this.f4064d.length;
                        obj2 = new long[(a + b)];
                        if (b != 0) {
                            System.arraycopy(this.f4064d, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = c1841r.m10394f();
                            b++;
                        }
                        this.f4064d = obj2;
                        c1841r.m10391d(c);
                        continue;
                    case 40:
                        b = ac.m7339b(c1841r, 40);
                        a = this.f4065e == null ? 0 : this.f4065e.length;
                        obj = new long[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f4065e, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c1841r.m10394f();
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = c1841r.m10394f();
                        this.f4065e = obj;
                        continue;
                    case 42:
                        c = c1841r.m10389c(c1841r.m10401l());
                        b = c1841r.m10407r();
                        a = 0;
                        while (c1841r.m10405p() > 0) {
                            c1841r.m10394f();
                            a++;
                        }
                        c1841r.m10393e(b);
                        b = this.f4065e == null ? 0 : this.f4065e.length;
                        obj2 = new long[(a + b)];
                        if (b != 0) {
                            System.arraycopy(this.f4065e, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = c1841r.m10394f();
                            b++;
                        }
                        this.f4065e = obj2;
                        c1841r.m10391d(c);
                        continue;
                    default:
                        if (!super.m7352a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            int i = 0;
            if (this.f4061a != null && this.f4061a.length > 0) {
                for (String str : this.f4061a) {
                    if (str != null) {
                        c1843s.m10451a(1, str);
                    }
                }
            }
            if (this.f4062b != null && this.f4062b.length > 0) {
                for (String str2 : this.f4062b) {
                    if (str2 != null) {
                        c1843s.m10451a(2, str2);
                    }
                }
            }
            if (this.f4063c != null && this.f4063c.length > 0) {
                for (int a : this.f4063c) {
                    c1843s.m10448a(3, a);
                }
            }
            if (this.f4064d != null && this.f4064d.length > 0) {
                for (long b : this.f4064d) {
                    c1843s.m10459b(4, b);
                }
            }
            if (this.f4065e != null && this.f4065e.length > 0) {
                while (i < this.f4065e.length) {
                    c1843s.m10459b(5, this.f4065e[i]);
                    i++;
                }
            }
            super.mo1231a(c1843s);
        }

        public C1359a m7358b() {
            this.f4061a = ac.f4056f;
            this.f4062b = ac.f4056f;
            this.f4063c = ac.f4051a;
            this.f4064d = ac.f4052b;
            this.f4065e = ac.f4052b;
            this.U = null;
            this.V = -1;
            return this;
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m7356a(c1841r);
        }

        public /* synthetic */ C1358t mo1235c() {
            return (C1359a) clone();
        }

        public /* synthetic */ Object clone() {
            return m7362g();
        }

        public /* synthetic */ C1357z mo1233d() {
            return (C1359a) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1359a)) {
                return false;
            }
            C1359a c1359a = (C1359a) obj;
            return (C1847x.m10502a(this.f4061a, c1359a.f4061a) && C1847x.m10502a(this.f4062b, c1359a.f4062b) && C1847x.m10500a(this.f4063c, c1359a.f4063c) && C1847x.m10501a(this.f4064d, c1359a.f4064d) && C1847x.m10501a(this.f4065e, c1359a.f4065e)) ? (this.U == null || this.U.m10488b()) ? c1359a.U == null || c1359a.U.m10488b() : this.U.equals(c1359a.U) : false;
        }

        public C1359a m7362g() {
            try {
                C1359a c1359a = (C1359a) super.mo1235c();
                if (this.f4061a != null && this.f4061a.length > 0) {
                    c1359a.f4061a = (String[]) this.f4061a.clone();
                }
                if (this.f4062b != null && this.f4062b.length > 0) {
                    c1359a.f4062b = (String[]) this.f4062b.clone();
                }
                if (this.f4063c != null && this.f4063c.length > 0) {
                    c1359a.f4063c = (int[]) this.f4063c.clone();
                }
                if (this.f4064d != null && this.f4064d.length > 0) {
                    c1359a.f4064d = (long[]) this.f4064d.clone();
                }
                if (this.f4065e != null && this.f4065e.length > 0) {
                    c1359a.f4065e = (long[]) this.f4065e.clone();
                }
                return c1359a;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public int hashCode() {
            int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + C1847x.m10497a(this.f4061a)) * 31) + C1847x.m10497a(this.f4062b)) * 31) + C1847x.m10495a(this.f4063c)) * 31) + C1847x.m10496a(this.f4064d)) * 31) + C1847x.m10496a(this.f4065e)) * 31;
            int hashCode2 = (this.U == null || this.U.m10488b()) ? 0 : this.U.hashCode();
            return hashCode2 + hashCode;
        }
    }

    public static final class C1360b extends C1358t<C1360b> implements Cloneable {
        public int f4066a;
        public String f4067b;
        public String f4068c;

        public C1360b() {
            m7366b();
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f4066a != 0) {
                a += C1843s.m10420b(1, this.f4066a);
            }
            if (!this.f4067b.equals("")) {
                a += C1843s.m10422b(2, this.f4067b);
            }
            return !this.f4068c.equals("") ? a + C1843s.m10422b(3, this.f4068c) : a;
        }

        public C1360b m7364a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f4066a = c1841r.m10396g();
                        continue;
                    case 18:
                        this.f4067b = c1841r.m10398i();
                        continue;
                    case 26:
                        this.f4068c = c1841r.m10398i();
                        continue;
                    default:
                        if (!super.m7352a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            if (this.f4066a != 0) {
                c1843s.m10448a(1, this.f4066a);
            }
            if (!this.f4067b.equals("")) {
                c1843s.m10451a(2, this.f4067b);
            }
            if (!this.f4068c.equals("")) {
                c1843s.m10451a(3, this.f4068c);
            }
            super.mo1231a(c1843s);
        }

        public C1360b m7366b() {
            this.f4066a = 0;
            this.f4067b = "";
            this.f4068c = "";
            this.U = null;
            this.V = -1;
            return this;
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m7364a(c1841r);
        }

        public /* synthetic */ C1358t mo1235c() {
            return (C1360b) clone();
        }

        public /* synthetic */ Object clone() {
            return m7370g();
        }

        public /* synthetic */ C1357z mo1233d() {
            return (C1360b) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1360b)) {
                return false;
            }
            C1360b c1360b = (C1360b) obj;
            if (this.f4066a != c1360b.f4066a) {
                return false;
            }
            if (this.f4067b == null) {
                if (c1360b.f4067b != null) {
                    return false;
                }
            } else if (!this.f4067b.equals(c1360b.f4067b)) {
                return false;
            }
            if (this.f4068c == null) {
                if (c1360b.f4068c != null) {
                    return false;
                }
            } else if (!this.f4068c.equals(c1360b.f4068c)) {
                return false;
            }
            return (this.U == null || this.U.m10488b()) ? c1360b.U == null || c1360b.U.m10488b() : this.U.equals(c1360b.U);
        }

        public C1360b m7370g() {
            try {
                return (C1360b) super.mo1235c();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f4068c == null ? 0 : this.f4068c.hashCode()) + (((this.f4067b == null ? 0 : this.f4067b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.f4066a) * 31)) * 31)) * 31;
            if (!(this.U == null || this.U.m10488b())) {
                i = this.U.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1361c extends C1358t<C1361c> implements Cloneable {
        public byte[] f4069a;
        public String f4070b;
        public byte[][] f4071c;
        public boolean f4072d;

        public C1361c() {
            m7374b();
        }

        protected int mo1230a() {
            int i = 0;
            int a = super.mo1230a();
            if (!Arrays.equals(this.f4069a, ac.f4058h)) {
                a += C1843s.m10424b(1, this.f4069a);
            }
            if (this.f4071c != null && this.f4071c.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i < this.f4071c.length) {
                    byte[] bArr = this.f4071c[i];
                    if (bArr != null) {
                        i3++;
                        i2 += C1843s.m10430c(bArr);
                    }
                    i++;
                }
                a = (a + i2) + (i3 * 1);
            }
            if (this.f4072d) {
                a += C1843s.m10423b(3, this.f4072d);
            }
            return !this.f4070b.equals("") ? a + C1843s.m10422b(4, this.f4070b) : a;
        }

        public C1361c m7372a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f4069a = c1841r.m10399j();
                        continue;
                    case 18:
                        int b = ac.m7339b(c1841r, 18);
                        a = this.f4071c == null ? 0 : this.f4071c.length;
                        Object obj = new byte[(b + a)][];
                        if (a != 0) {
                            System.arraycopy(this.f4071c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c1841r.m10399j();
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = c1841r.m10399j();
                        this.f4071c = obj;
                        continue;
                    case 24:
                        this.f4072d = c1841r.m10397h();
                        continue;
                    case 34:
                        this.f4070b = c1841r.m10398i();
                        continue;
                    default:
                        if (!super.m7352a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            if (!Arrays.equals(this.f4069a, ac.f4058h)) {
                c1843s.m10453a(1, this.f4069a);
            }
            if (this.f4071c != null && this.f4071c.length > 0) {
                for (byte[] bArr : this.f4071c) {
                    if (bArr != null) {
                        c1843s.m10453a(2, bArr);
                    }
                }
            }
            if (this.f4072d) {
                c1843s.m10452a(3, this.f4072d);
            }
            if (!this.f4070b.equals("")) {
                c1843s.m10451a(4, this.f4070b);
            }
            super.mo1231a(c1843s);
        }

        public C1361c m7374b() {
            this.f4069a = ac.f4058h;
            this.f4070b = "";
            this.f4071c = ac.f4057g;
            this.f4072d = false;
            this.U = null;
            this.V = -1;
            return this;
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m7372a(c1841r);
        }

        public /* synthetic */ C1358t mo1235c() {
            return (C1361c) clone();
        }

        public /* synthetic */ Object clone() {
            return m7378g();
        }

        public /* synthetic */ C1357z mo1233d() {
            return (C1361c) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1361c)) {
                return false;
            }
            C1361c c1361c = (C1361c) obj;
            if (!Arrays.equals(this.f4069a, c1361c.f4069a)) {
                return false;
            }
            if (this.f4070b == null) {
                if (c1361c.f4070b != null) {
                    return false;
                }
            } else if (!this.f4070b.equals(c1361c.f4070b)) {
                return false;
            }
            return (C1847x.m10503a(this.f4071c, c1361c.f4071c) && this.f4072d == c1361c.f4072d) ? (this.U == null || this.U.m10488b()) ? c1361c.U == null || c1361c.U.m10488b() : this.U.equals(c1361c.U) : false;
        }

        public C1361c m7378g() {
            try {
                C1361c c1361c = (C1361c) super.mo1235c();
                if (this.f4071c != null && this.f4071c.length > 0) {
                    c1361c.f4071c = (byte[][]) this.f4071c.clone();
                }
                return c1361c;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f4072d ? 1231 : 1237) + (((((this.f4070b == null ? 0 : this.f4070b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.f4069a)) * 31)) * 31) + C1847x.m10498a(this.f4071c)) * 31)) * 31;
            if (!(this.U == null || this.U.m10488b())) {
                i = this.U.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1362d extends C1358t<C1362d> implements Cloneable {
        public long f4073a;
        public long f4074b;
        public long f4075c;
        public String f4076d;
        public int f4077e;
        public int f4078f;
        public boolean f4079g;
        public C1363e[] f4080h;
        public byte[] f4081i;
        public C1360b f4082j;
        public byte[] f4083k;
        public String f4084l;
        public String f4085m;
        public C1359a f4086n;
        public String f4087o;
        public long f4088p;
        public C1361c f4089q;
        public byte[] f4090r;
        public String f4091s;
        public int f4092t;
        public int[] f4093u;
        public long f4094v;
        public C1364f f4095w;

        public C1362d() {
            m7382b();
        }

        protected int mo1230a() {
            int i;
            int i2 = 0;
            int a = super.mo1230a();
            if (this.f4073a != 0) {
                a += C1843s.m10432d(1, this.f4073a);
            }
            if (!this.f4076d.equals("")) {
                a += C1843s.m10422b(2, this.f4076d);
            }
            if (this.f4080h != null && this.f4080h.length > 0) {
                i = a;
                for (C1357z c1357z : this.f4080h) {
                    if (c1357z != null) {
                        i += C1843s.m10428c(3, c1357z);
                    }
                }
                a = i;
            }
            if (!Arrays.equals(this.f4081i, ac.f4058h)) {
                a += C1843s.m10424b(4, this.f4081i);
            }
            if (!Arrays.equals(this.f4083k, ac.f4058h)) {
                a += C1843s.m10424b(6, this.f4083k);
            }
            if (this.f4086n != null) {
                a += C1843s.m10428c(7, this.f4086n);
            }
            if (!this.f4084l.equals("")) {
                a += C1843s.m10422b(8, this.f4084l);
            }
            if (this.f4082j != null) {
                a += C1843s.m10428c(9, this.f4082j);
            }
            if (this.f4079g) {
                a += C1843s.m10423b(10, this.f4079g);
            }
            if (this.f4077e != 0) {
                a += C1843s.m10420b(11, this.f4077e);
            }
            if (this.f4078f != 0) {
                a += C1843s.m10420b(12, this.f4078f);
            }
            if (!this.f4085m.equals("")) {
                a += C1843s.m10422b(13, this.f4085m);
            }
            if (!this.f4087o.equals("")) {
                a += C1843s.m10422b(14, this.f4087o);
            }
            if (this.f4088p != 180000) {
                a += C1843s.m10435e(15, this.f4088p);
            }
            if (this.f4089q != null) {
                a += C1843s.m10428c(16, this.f4089q);
            }
            if (this.f4074b != 0) {
                a += C1843s.m10432d(17, this.f4074b);
            }
            if (!Arrays.equals(this.f4090r, ac.f4058h)) {
                a += C1843s.m10424b(18, this.f4090r);
            }
            if (this.f4092t != 0) {
                a += C1843s.m10420b(19, this.f4092t);
            }
            if (this.f4093u != null && this.f4093u.length > 0) {
                i = 0;
                while (i2 < this.f4093u.length) {
                    i += C1843s.m10417b(this.f4093u[i2]);
                    i2++;
                }
                a = (a + i) + (this.f4093u.length * 2);
            }
            if (this.f4075c != 0) {
                a += C1843s.m10432d(21, this.f4075c);
            }
            if (this.f4094v != 0) {
                a += C1843s.m10432d(22, this.f4094v);
            }
            if (this.f4095w != null) {
                a += C1843s.m10428c(23, this.f4095w);
            }
            return !this.f4091s.equals("") ? a + C1843s.m10422b(24, this.f4091s) : a;
        }

        public C1362d m7380a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                int b;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f4073a = c1841r.m10394f();
                        continue;
                    case 18:
                        this.f4076d = c1841r.m10398i();
                        continue;
                    case 26:
                        b = ac.m7339b(c1841r, 26);
                        a = this.f4080h == null ? 0 : this.f4080h.length;
                        obj = new C1363e[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f4080h, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1363e();
                            c1841r.m10384a(obj[a]);
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = new C1363e();
                        c1841r.m10384a(obj[a]);
                        this.f4080h = obj;
                        continue;
                    case 34:
                        this.f4081i = c1841r.m10399j();
                        continue;
                    case 50:
                        this.f4083k = c1841r.m10399j();
                        continue;
                    case 58:
                        if (this.f4086n == null) {
                            this.f4086n = new C1359a();
                        }
                        c1841r.m10384a(this.f4086n);
                        continue;
                    case 66:
                        this.f4084l = c1841r.m10398i();
                        continue;
                    case 74:
                        if (this.f4082j == null) {
                            this.f4082j = new C1360b();
                        }
                        c1841r.m10384a(this.f4082j);
                        continue;
                    case 80:
                        this.f4079g = c1841r.m10397h();
                        continue;
                    case 88:
                        this.f4077e = c1841r.m10396g();
                        continue;
                    case 96:
                        this.f4078f = c1841r.m10396g();
                        continue;
                    case 106:
                        this.f4085m = c1841r.m10398i();
                        continue;
                    case 114:
                        this.f4087o = c1841r.m10398i();
                        continue;
                    case 120:
                        this.f4088p = c1841r.m10400k();
                        continue;
                    case 130:
                        if (this.f4089q == null) {
                            this.f4089q = new C1361c();
                        }
                        c1841r.m10384a(this.f4089q);
                        continue;
                    case 136:
                        this.f4074b = c1841r.m10394f();
                        continue;
                    case 146:
                        this.f4090r = c1841r.m10399j();
                        continue;
                    case 152:
                        a = c1841r.m10396g();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                                this.f4092t = a;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        b = ac.m7339b(c1841r, 160);
                        a = this.f4093u == null ? 0 : this.f4093u.length;
                        obj = new int[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f4093u, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c1841r.m10396g();
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = c1841r.m10396g();
                        this.f4093u = obj;
                        continue;
                    case 162:
                        int c = c1841r.m10389c(c1841r.m10401l());
                        b = c1841r.m10407r();
                        a = 0;
                        while (c1841r.m10405p() > 0) {
                            c1841r.m10396g();
                            a++;
                        }
                        c1841r.m10393e(b);
                        b = this.f4093u == null ? 0 : this.f4093u.length;
                        Object obj2 = new int[(a + b)];
                        if (b != 0) {
                            System.arraycopy(this.f4093u, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = c1841r.m10396g();
                            b++;
                        }
                        this.f4093u = obj2;
                        c1841r.m10391d(c);
                        continue;
                    case 168:
                        this.f4075c = c1841r.m10394f();
                        continue;
                    case 176:
                        this.f4094v = c1841r.m10394f();
                        continue;
                    case 186:
                        if (this.f4095w == null) {
                            this.f4095w = new C1364f();
                        }
                        c1841r.m10384a(this.f4095w);
                        continue;
                    case 194:
                        this.f4091s = c1841r.m10398i();
                        continue;
                    default:
                        if (!super.m7352a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            int i = 0;
            if (this.f4073a != 0) {
                c1843s.m10459b(1, this.f4073a);
            }
            if (!this.f4076d.equals("")) {
                c1843s.m10451a(2, this.f4076d);
            }
            if (this.f4080h != null && this.f4080h.length > 0) {
                for (C1357z c1357z : this.f4080h) {
                    if (c1357z != null) {
                        c1843s.m10450a(3, c1357z);
                    }
                }
            }
            if (!Arrays.equals(this.f4081i, ac.f4058h)) {
                c1843s.m10453a(4, this.f4081i);
            }
            if (!Arrays.equals(this.f4083k, ac.f4058h)) {
                c1843s.m10453a(6, this.f4083k);
            }
            if (this.f4086n != null) {
                c1843s.m10450a(7, this.f4086n);
            }
            if (!this.f4084l.equals("")) {
                c1843s.m10451a(8, this.f4084l);
            }
            if (this.f4082j != null) {
                c1843s.m10450a(9, this.f4082j);
            }
            if (this.f4079g) {
                c1843s.m10452a(10, this.f4079g);
            }
            if (this.f4077e != 0) {
                c1843s.m10448a(11, this.f4077e);
            }
            if (this.f4078f != 0) {
                c1843s.m10448a(12, this.f4078f);
            }
            if (!this.f4085m.equals("")) {
                c1843s.m10451a(13, this.f4085m);
            }
            if (!this.f4087o.equals("")) {
                c1843s.m10451a(14, this.f4087o);
            }
            if (this.f4088p != 180000) {
                c1843s.m10466c(15, this.f4088p);
            }
            if (this.f4089q != null) {
                c1843s.m10450a(16, this.f4089q);
            }
            if (this.f4074b != 0) {
                c1843s.m10459b(17, this.f4074b);
            }
            if (!Arrays.equals(this.f4090r, ac.f4058h)) {
                c1843s.m10453a(18, this.f4090r);
            }
            if (this.f4092t != 0) {
                c1843s.m10448a(19, this.f4092t);
            }
            if (this.f4093u != null && this.f4093u.length > 0) {
                while (i < this.f4093u.length) {
                    c1843s.m10448a(20, this.f4093u[i]);
                    i++;
                }
            }
            if (this.f4075c != 0) {
                c1843s.m10459b(21, this.f4075c);
            }
            if (this.f4094v != 0) {
                c1843s.m10459b(22, this.f4094v);
            }
            if (this.f4095w != null) {
                c1843s.m10450a(23, this.f4095w);
            }
            if (!this.f4091s.equals("")) {
                c1843s.m10451a(24, this.f4091s);
            }
            super.mo1231a(c1843s);
        }

        public C1362d m7382b() {
            this.f4073a = 0;
            this.f4074b = 0;
            this.f4075c = 0;
            this.f4076d = "";
            this.f4077e = 0;
            this.f4078f = 0;
            this.f4079g = false;
            this.f4080h = C1363e.m7387b();
            this.f4081i = ac.f4058h;
            this.f4082j = null;
            this.f4083k = ac.f4058h;
            this.f4084l = "";
            this.f4085m = "";
            this.f4086n = null;
            this.f4087o = "";
            this.f4088p = 180000;
            this.f4089q = null;
            this.f4090r = ac.f4058h;
            this.f4091s = "";
            this.f4092t = 0;
            this.f4093u = ac.f4051a;
            this.f4094v = 0;
            this.f4095w = null;
            this.U = null;
            this.V = -1;
            return this;
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m7380a(c1841r);
        }

        public /* synthetic */ C1358t mo1235c() {
            return (C1362d) clone();
        }

        public /* synthetic */ Object clone() {
            return m7386g();
        }

        public /* synthetic */ C1357z mo1233d() {
            return (C1362d) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1362d)) {
                return false;
            }
            C1362d c1362d = (C1362d) obj;
            if (this.f4073a != c1362d.f4073a || this.f4074b != c1362d.f4074b || this.f4075c != c1362d.f4075c) {
                return false;
            }
            if (this.f4076d == null) {
                if (c1362d.f4076d != null) {
                    return false;
                }
            } else if (!this.f4076d.equals(c1362d.f4076d)) {
                return false;
            }
            if (this.f4077e != c1362d.f4077e || this.f4078f != c1362d.f4078f || this.f4079g != c1362d.f4079g || !C1847x.m10502a(this.f4080h, c1362d.f4080h) || !Arrays.equals(this.f4081i, c1362d.f4081i)) {
                return false;
            }
            if (this.f4082j == null) {
                if (c1362d.f4082j != null) {
                    return false;
                }
            } else if (!this.f4082j.equals(c1362d.f4082j)) {
                return false;
            }
            if (!Arrays.equals(this.f4083k, c1362d.f4083k)) {
                return false;
            }
            if (this.f4084l == null) {
                if (c1362d.f4084l != null) {
                    return false;
                }
            } else if (!this.f4084l.equals(c1362d.f4084l)) {
                return false;
            }
            if (this.f4085m == null) {
                if (c1362d.f4085m != null) {
                    return false;
                }
            } else if (!this.f4085m.equals(c1362d.f4085m)) {
                return false;
            }
            if (this.f4086n == null) {
                if (c1362d.f4086n != null) {
                    return false;
                }
            } else if (!this.f4086n.equals(c1362d.f4086n)) {
                return false;
            }
            if (this.f4087o == null) {
                if (c1362d.f4087o != null) {
                    return false;
                }
            } else if (!this.f4087o.equals(c1362d.f4087o)) {
                return false;
            }
            if (this.f4088p != c1362d.f4088p) {
                return false;
            }
            if (this.f4089q == null) {
                if (c1362d.f4089q != null) {
                    return false;
                }
            } else if (!this.f4089q.equals(c1362d.f4089q)) {
                return false;
            }
            if (!Arrays.equals(this.f4090r, c1362d.f4090r)) {
                return false;
            }
            if (this.f4091s == null) {
                if (c1362d.f4091s != null) {
                    return false;
                }
            } else if (!this.f4091s.equals(c1362d.f4091s)) {
                return false;
            }
            if (this.f4092t != c1362d.f4092t || !C1847x.m10500a(this.f4093u, c1362d.f4093u) || this.f4094v != c1362d.f4094v) {
                return false;
            }
            if (this.f4095w == null) {
                if (c1362d.f4095w != null) {
                    return false;
                }
            } else if (!this.f4095w.equals(c1362d.f4095w)) {
                return false;
            }
            return (this.U == null || this.U.m10488b()) ? c1362d.U == null || c1362d.U.m10488b() : this.U.equals(c1362d.U);
        }

        public C1362d m7386g() {
            try {
                C1362d c1362d = (C1362d) super.mo1235c();
                if (this.f4080h != null && this.f4080h.length > 0) {
                    c1362d.f4080h = new C1363e[this.f4080h.length];
                    for (int i = 0; i < this.f4080h.length; i++) {
                        if (this.f4080h[i] != null) {
                            c1362d.f4080h[i] = (C1363e) this.f4080h[i].clone();
                        }
                    }
                }
                if (this.f4082j != null) {
                    c1362d.f4082j = (C1360b) this.f4082j.clone();
                }
                if (this.f4086n != null) {
                    c1362d.f4086n = (C1359a) this.f4086n.clone();
                }
                if (this.f4089q != null) {
                    c1362d.f4089q = (C1361c) this.f4089q.clone();
                }
                if (this.f4093u != null && this.f4093u.length > 0) {
                    c1362d.f4093u = (int[]) this.f4093u.clone();
                }
                if (this.f4095w != null) {
                    c1362d.f4095w = (C1364f) this.f4095w.clone();
                }
                return c1362d;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f4095w == null ? 0 : this.f4095w.hashCode()) + (((((((((this.f4091s == null ? 0 : this.f4091s.hashCode()) + (((((this.f4089q == null ? 0 : this.f4089q.hashCode()) + (((((this.f4087o == null ? 0 : this.f4087o.hashCode()) + (((this.f4086n == null ? 0 : this.f4086n.hashCode()) + (((this.f4085m == null ? 0 : this.f4085m.hashCode()) + (((this.f4084l == null ? 0 : this.f4084l.hashCode()) + (((((this.f4082j == null ? 0 : this.f4082j.hashCode()) + (((((((this.f4079g ? 1231 : 1237) + (((((((this.f4076d == null ? 0 : this.f4076d.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.f4073a ^ (this.f4073a >>> 32)))) * 31) + ((int) (this.f4074b ^ (this.f4074b >>> 32)))) * 31) + ((int) (this.f4075c ^ (this.f4075c >>> 32)))) * 31)) * 31) + this.f4077e) * 31) + this.f4078f) * 31)) * 31) + C1847x.m10497a(this.f4080h)) * 31) + Arrays.hashCode(this.f4081i)) * 31)) * 31) + Arrays.hashCode(this.f4083k)) * 31)) * 31)) * 31)) * 31)) * 31) + ((int) (this.f4088p ^ (this.f4088p >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.f4090r)) * 31)) * 31) + this.f4092t) * 31) + C1847x.m10495a(this.f4093u)) * 31) + ((int) (this.f4094v ^ (this.f4094v >>> 32)))) * 31)) * 31;
            if (!(this.U == null || this.U.m10488b())) {
                i = this.U.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1363e extends C1358t<C1363e> implements Cloneable {
        private static volatile C1363e[] f4096c;
        public String f4097a;
        public String f4098b;

        public C1363e() {
            m7394g();
        }

        public static C1363e[] m7387b() {
            if (f4096c == null) {
                synchronized (C1847x.f6277c) {
                    if (f4096c == null) {
                        f4096c = new C1363e[0];
                    }
                }
            }
            return f4096c;
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (!this.f4097a.equals("")) {
                a += C1843s.m10422b(1, this.f4097a);
            }
            return !this.f4098b.equals("") ? a + C1843s.m10422b(2, this.f4098b) : a;
        }

        public C1363e m7389a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f4097a = c1841r.m10398i();
                        continue;
                    case 18:
                        this.f4098b = c1841r.m10398i();
                        continue;
                    default:
                        if (!super.m7352a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            if (!this.f4097a.equals("")) {
                c1843s.m10451a(1, this.f4097a);
            }
            if (!this.f4098b.equals("")) {
                c1843s.m10451a(2, this.f4098b);
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m7389a(c1841r);
        }

        public /* synthetic */ C1358t mo1235c() {
            return (C1363e) clone();
        }

        public /* synthetic */ Object clone() {
            return m7395h();
        }

        public /* synthetic */ C1357z mo1233d() {
            return (C1363e) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1363e)) {
                return false;
            }
            C1363e c1363e = (C1363e) obj;
            if (this.f4097a == null) {
                if (c1363e.f4097a != null) {
                    return false;
                }
            } else if (!this.f4097a.equals(c1363e.f4097a)) {
                return false;
            }
            if (this.f4098b == null) {
                if (c1363e.f4098b != null) {
                    return false;
                }
            } else if (!this.f4098b.equals(c1363e.f4098b)) {
                return false;
            }
            return (this.U == null || this.U.m10488b()) ? c1363e.U == null || c1363e.U.m10488b() : this.U.equals(c1363e.U);
        }

        public C1363e m7394g() {
            this.f4097a = "";
            this.f4098b = "";
            this.U = null;
            this.V = -1;
            return this;
        }

        public C1363e m7395h() {
            try {
                return (C1363e) super.mo1235c();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f4098b == null ? 0 : this.f4098b.hashCode()) + (((this.f4097a == null ? 0 : this.f4097a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.U == null || this.U.m10488b())) {
                i = this.U.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1364f extends C1358t<C1364f> implements Cloneable {
        public int f4099a;

        public C1364f() {
            m7399b();
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            return this.f4099a != -1 ? a + C1843s.m10420b(1, this.f4099a) : a;
        }

        public C1364f m7397a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a = c1841r.m10396g();
                        switch (a) {
                            case -1:
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                                this.f4099a = a;
                                break;
                            default:
                                continue;
                        }
                    default:
                        if (!super.m7352a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            if (this.f4099a != -1) {
                c1843s.m10448a(1, this.f4099a);
            }
            super.mo1231a(c1843s);
        }

        public C1364f m7399b() {
            this.f4099a = -1;
            this.U = null;
            this.V = -1;
            return this;
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m7397a(c1841r);
        }

        public /* synthetic */ C1358t mo1235c() {
            return (C1364f) clone();
        }

        public /* synthetic */ Object clone() {
            return m7403g();
        }

        public /* synthetic */ C1357z mo1233d() {
            return (C1364f) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1364f)) {
                return false;
            }
            C1364f c1364f = (C1364f) obj;
            return this.f4099a == c1364f.f4099a ? (this.U == null || this.U.m10488b()) ? c1364f.U == null || c1364f.U.m10488b() : this.U.equals(c1364f.U) : false;
        }

        public C1364f m7403g() {
            try {
                return (C1364f) super.mo1235c();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public int hashCode() {
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + this.f4099a) * 31;
            int hashCode2 = (this.U == null || this.U.m10488b()) ? 0 : this.U.hashCode();
            return hashCode2 + hashCode;
        }
    }
}
