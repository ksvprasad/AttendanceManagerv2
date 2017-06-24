package com.google.android.gms.p031b;

import android.os.SystemClock;
import com.google.android.gms.p031b.ar.C1369a;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ny implements ar {
    private final Map<String, C1824a> f6210a;
    private long f6211b;
    private final File f6212c;
    private final int f6213d;

    static class C1824a {
        public long f6201a;
        public String f6202b;
        public String f6203c;
        public long f6204d;
        public long f6205e;
        public long f6206f;
        public long f6207g;
        public Map<String, String> f6208h;

        private C1824a() {
        }

        public C1824a(String str, C1369a c1369a) {
            this.f6202b = str;
            this.f6201a = (long) c1369a.f4163a.length;
            this.f6203c = c1369a.f4164b;
            this.f6204d = c1369a.f4165c;
            this.f6205e = c1369a.f4166d;
            this.f6206f = c1369a.f4167e;
            this.f6207g = c1369a.f4168f;
            this.f6208h = c1369a.f4169g;
        }

        public static C1824a m10300a(InputStream inputStream) {
            C1824a c1824a = new C1824a();
            if (ny.m10304a(inputStream) != 538247942) {
                throw new IOException();
            }
            c1824a.f6202b = ny.m10313c(inputStream);
            c1824a.f6203c = ny.m10313c(inputStream);
            if (c1824a.f6203c.equals("")) {
                c1824a.f6203c = null;
            }
            c1824a.f6204d = ny.m10312b(inputStream);
            c1824a.f6205e = ny.m10312b(inputStream);
            c1824a.f6206f = ny.m10312b(inputStream);
            c1824a.f6207g = ny.m10312b(inputStream);
            c1824a.f6208h = ny.m10315d(inputStream);
            return c1824a;
        }

        public C1369a m10301a(byte[] bArr) {
            C1369a c1369a = new C1369a();
            c1369a.f4163a = bArr;
            c1369a.f4164b = this.f6203c;
            c1369a.f4165c = this.f6204d;
            c1369a.f4166d = this.f6205e;
            c1369a.f4167e = this.f6206f;
            c1369a.f4168f = this.f6207g;
            c1369a.f4169g = this.f6208h;
            return c1369a;
        }

        public boolean m10302a(OutputStream outputStream) {
            try {
                ny.m10306a(outputStream, 538247942);
                ny.m10308a(outputStream, this.f6202b);
                ny.m10308a(outputStream, this.f6203c == null ? "" : this.f6203c);
                ny.m10307a(outputStream, this.f6204d);
                ny.m10307a(outputStream, this.f6205e);
                ny.m10307a(outputStream, this.f6206f);
                ny.m10307a(outputStream, this.f6207g);
                ny.m10310a(this.f6208h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                no.m10169b("%s", e.toString());
                return false;
            }
        }
    }

    private static class C1825b extends FilterInputStream {
        private int f6209a;

        private C1825b(InputStream inputStream) {
            super(inputStream);
            this.f6209a = 0;
        }

        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f6209a++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f6209a += read;
            }
            return read;
        }
    }

    public ny(File file) {
        this(file, 5242880);
    }

    public ny(File file, int i) {
        this.f6210a = new LinkedHashMap(16, 0.75f, true);
        this.f6211b = 0;
        this.f6212c = file;
        this.f6213d = i;
    }

    static int m10304a(InputStream inputStream) {
        return ((((ny.m10316e(inputStream) << 0) | 0) | (ny.m10316e(inputStream) << 8)) | (ny.m10316e(inputStream) << 16)) | (ny.m10316e(inputStream) << 24);
    }

    private void m10305a(int i) {
        if (this.f6211b + ((long) i) >= ((long) this.f6213d)) {
            int i2;
            if (no.f6075b) {
                no.m10167a("Pruning old cache entries.", new Object[0]);
            }
            long j = this.f6211b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.f6210a.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                C1824a c1824a = (C1824a) ((Entry) it.next()).getValue();
                if (m10322c(c1824a.f6202b).delete()) {
                    this.f6211b -= c1824a.f6201a;
                } else {
                    no.m10169b("Could not delete cache entry for key=%s, filename=%s", c1824a.f6202b, m10314d(c1824a.f6202b));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.f6211b + ((long) i))) < ((float) this.f6213d) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            if (no.f6075b) {
                no.m10167a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f6211b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static void m10306a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void m10307a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void m10308a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        ny.m10307a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void m10309a(String str, C1824a c1824a) {
        if (this.f6210a.containsKey(str)) {
            C1824a c1824a2 = (C1824a) this.f6210a.get(str);
            this.f6211b = (c1824a.f6201a - c1824a2.f6201a) + this.f6211b;
        } else {
            this.f6211b += c1824a.f6201a;
        }
        this.f6210a.put(str, c1824a);
    }

    static void m10310a(Map<String, String> map, OutputStream outputStream) {
        if (map != null) {
            ny.m10306a(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                ny.m10308a(outputStream, (String) entry.getKey());
                ny.m10308a(outputStream, (String) entry.getValue());
            }
            return;
        }
        ny.m10306a(outputStream, 0);
    }

    private static byte[] m10311a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static long m10312b(InputStream inputStream) {
        return (((((((0 | ((((long) ny.m10316e(inputStream)) & 255) << null)) | ((((long) ny.m10316e(inputStream)) & 255) << 8)) | ((((long) ny.m10316e(inputStream)) & 255) << 16)) | ((((long) ny.m10316e(inputStream)) & 255) << 24)) | ((((long) ny.m10316e(inputStream)) & 255) << 32)) | ((((long) ny.m10316e(inputStream)) & 255) << 40)) | ((((long) ny.m10316e(inputStream)) & 255) << 48)) | ((((long) ny.m10316e(inputStream)) & 255) << 56);
    }

    static String m10313c(InputStream inputStream) {
        return new String(ny.m10311a(inputStream, (int) ny.m10312b(inputStream)), "UTF-8");
    }

    private String m10314d(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static Map<String, String> m10315d(InputStream inputStream) {
        int a = ny.m10304a(inputStream);
        Map<String, String> emptyMap = a == 0 ? Collections.emptyMap() : new HashMap(a);
        for (int i = 0; i < a; i++) {
            emptyMap.put(ny.m10313c(inputStream).intern(), ny.m10313c(inputStream).intern());
        }
        return emptyMap;
    }

    private static int m10316e(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private void m10317e(String str) {
        C1824a c1824a = (C1824a) this.f6210a.get(str);
        if (c1824a != null) {
            this.f6211b -= c1824a.f6201a;
            this.f6210a.remove(str);
        }
    }

    public synchronized C1369a mo1636a(String str) {
        C1369a c1369a;
        IOException e;
        Throwable th;
        C1824a c1824a = (C1824a) this.f6210a.get(str);
        if (c1824a == null) {
            c1369a = null;
        } else {
            File c = m10322c(str);
            C1825b c1825b;
            try {
                c1825b = new C1825b(new FileInputStream(c));
                try {
                    C1824a.m10300a((InputStream) c1825b);
                    c1369a = c1824a.m10301a(ny.m10311a((InputStream) c1825b, (int) (c.length() - ((long) c1825b.f6209a))));
                    if (c1825b != null) {
                        try {
                            c1825b.close();
                        } catch (IOException e2) {
                            c1369a = null;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        no.m10169b("%s: %s", c.getAbsolutePath(), e.toString());
                        m10321b(str);
                        if (c1825b != null) {
                            try {
                                c1825b.close();
                            } catch (IOException e4) {
                                c1369a = null;
                            }
                        }
                        c1369a = null;
                        return c1369a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (c1825b != null) {
                            try {
                                c1825b.close();
                            } catch (IOException e5) {
                                c1369a = null;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                c1825b = null;
                no.m10169b("%s: %s", c.getAbsolutePath(), e.toString());
                m10321b(str);
                if (c1825b != null) {
                    c1825b.close();
                }
                c1369a = null;
                return c1369a;
            } catch (Throwable th3) {
                th = th3;
                c1825b = null;
                if (c1825b != null) {
                    c1825b.close();
                }
                throw th;
            }
        }
        return c1369a;
    }

    public synchronized void mo1637a() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        if (this.f6212c.exists()) {
            File[] listFiles = this.f6212c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    BufferedInputStream bufferedInputStream2 = null;
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            C1824a a = C1824a.m10300a((InputStream) bufferedInputStream);
                            a.f6201a = file.length();
                            m10309a(a.f6202b, a);
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e) {
                                }
                            }
                        } catch (IOException e2) {
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    bufferedInputStream2 = bufferedInputStream;
                                    th = th3;
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                        }
                    } catch (IOException e4) {
                        bufferedInputStream = null;
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            }
        } else if (!this.f6212c.mkdirs()) {
            no.m10170c("Unable to create cache dir %s", this.f6212c.getAbsolutePath());
        }
        return;
        if (bufferedInputStream2 != null) {
            try {
                bufferedInputStream2.close();
            } catch (IOException e5) {
            }
        }
        throw th;
        throw th;
    }

    public synchronized void mo1638a(String str, C1369a c1369a) {
        m10305a(c1369a.f4163a.length);
        File c = m10322c(str);
        try {
            OutputStream fileOutputStream = new FileOutputStream(c);
            C1824a c1824a = new C1824a(str, c1369a);
            if (c1824a.m10302a(fileOutputStream)) {
                fileOutputStream.write(c1369a.f4163a);
                fileOutputStream.close();
                m10309a(str, c1824a);
            } else {
                fileOutputStream.close();
                no.m10169b("Failed to write header for %s", c.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException e) {
            if (!c.delete()) {
                no.m10169b("Could not clean up file %s", c.getAbsolutePath());
            }
        }
    }

    public synchronized void m10321b(String str) {
        boolean delete = m10322c(str).delete();
        m10317e(str);
        if (!delete) {
            no.m10169b("Could not delete cache entry for key=%s, filename=%s", str, m10314d(str));
        }
    }

    public File m10322c(String str) {
        return new File(this.f6212c, m10314d(str));
    }
}
