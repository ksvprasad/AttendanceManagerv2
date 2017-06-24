package com.google.android.gms.p031b;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.cg.C1400a;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@id
public class cd {
    private final int f4334a;
    private final int f4335b;
    private final int f4336c;
    private final cc f4337d = new cf();

    class C13981 implements Comparator<C1400a> {
        final /* synthetic */ cd f4331a;

        C13981(cd cdVar) {
            this.f4331a = cdVar;
        }

        public int m7761a(C1400a c1400a, C1400a c1400a2) {
            int i = c1400a.f4341c - c1400a2.f4341c;
            return i != 0 ? i : (int) (c1400a.f4339a - c1400a2.f4339a);
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7761a((C1400a) obj, (C1400a) obj2);
        }
    }

    static class C1399a {
        ByteArrayOutputStream f4332a = new ByteArrayOutputStream(4096);
        Base64OutputStream f4333b = new Base64OutputStream(this.f4332a, 10);

        public void m7762a(byte[] bArr) {
            this.f4333b.write(bArr);
        }

        public String toString() {
            String byteArrayOutputStream;
            try {
                this.f4333b.close();
            } catch (Throwable e) {
                C1324b.m7231b("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.f4332a.close();
                byteArrayOutputStream = this.f4332a.toString();
            } catch (Throwable e2) {
                C1324b.m7231b("HashManager: Unable to convert to Base64.", e2);
                byteArrayOutputStream = "";
            } finally {
                this.f4332a = null;
                this.f4333b = null;
            }
            return byteArrayOutputStream;
        }
    }

    public cd(int i) {
        this.f4335b = i;
        this.f4334a = 6;
        this.f4336c = 0;
    }

    C1399a m7763a() {
        return new C1399a();
    }

    String m7764a(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        C1399a a = m7763a();
        PriorityQueue priorityQueue = new PriorityQueue(this.f4335b, new C13981(this));
        for (String b : split) {
            String[] b2 = ce.m7770b(b);
            if (b2.length != 0) {
                cg.m7780a(b2, this.f4335b, this.f4334a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                a.m7762a(this.f4337d.mo1268a(((C1400a) it.next()).f4340b));
            } catch (Throwable e) {
                C1324b.m7231b("Error while writing hash to byteStream", e);
            }
        }
        return a.toString();
    }

    public String m7765a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        return m7764a(stringBuffer.toString());
    }
}
