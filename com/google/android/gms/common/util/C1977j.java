package com.google.android.gms.common.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class C1977j {
    public static long m11100a(InputStream inputStream, OutputStream outputStream, boolean z) {
        return C1977j.m11101a(inputStream, outputStream, z, 1024);
    }

    public static long m11101a(InputStream inputStream, OutputStream outputStream, boolean z, int i) {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, i);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    C1977j.m11102a((Closeable) inputStream);
                    C1977j.m11102a((Closeable) outputStream);
                }
            }
        }
        return j;
    }

    public static void m11102a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] m11103a(InputStream inputStream) {
        return C1977j.m11104a(inputStream, true);
    }

    public static byte[] m11104a(InputStream inputStream, boolean z) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C1977j.m11100a(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }
}
