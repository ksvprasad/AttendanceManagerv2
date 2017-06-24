package android.support.v4.p015g;

import android.util.Log;
import java.io.Writer;

public class C0373d extends Writer {
    private final String f1116a;
    private StringBuilder f1117b = new StringBuilder(128);

    public C0373d(String str) {
        this.f1116a = str;
    }

    private void m1912a() {
        if (this.f1117b.length() > 0) {
            Log.d(this.f1116a, this.f1117b.toString());
            this.f1117b.delete(0, this.f1117b.length());
        }
    }

    public void close() {
        m1912a();
    }

    public void flush() {
        m1912a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m1912a();
            } else {
                this.f1117b.append(c);
            }
        }
    }
}
