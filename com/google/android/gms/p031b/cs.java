package com.google.android.gms.p031b;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@id
public class cs {
    BlockingQueue<cy> f4418a;
    ExecutorService f4419b;
    LinkedHashMap<String, String> f4420c = new LinkedHashMap();
    Map<String, cv> f4421d = new HashMap();
    String f4422e;
    final Context f4423f;
    final String f4424g;
    private AtomicBoolean f4425h;
    private File f4426i;

    class C14071 implements Runnable {
        final /* synthetic */ cs f4417a;

        C14071(cs csVar) {
            this.f4417a = csVar;
        }

        public void run() {
            this.f4417a.m7835a();
        }
    }

    public cs(Context context, String str, String str2, Map<String, String> map) {
        this.f4423f = context;
        this.f4424g = str;
        this.f4422e = str2;
        this.f4425h = new AtomicBoolean(false);
        this.f4425h.set(((Boolean) cq.f4369J.m7801c()).booleanValue());
        if (this.f4425h.get()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                this.f4426i = new File(externalStorageDirectory, "sdk_csi_data.txt");
            }
        }
        for (Entry entry : map.entrySet()) {
            this.f4420c.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.f4418a = new ArrayBlockingQueue(30);
        this.f4419b = Executors.newSingleThreadExecutor();
        this.f4419b.execute(new C14071(this));
        this.f4421d.put("action", cv.f4428b);
        this.f4421d.put("ad_format", cv.f4428b);
        this.f4421d.put("e", cv.f4429c);
    }

    private void m7835a() {
        while (true) {
            try {
                cy cyVar = (cy) this.f4418a.take();
                String c = cyVar.m7869c();
                if (!TextUtils.isEmpty(c)) {
                    m7838a(m7841a(this.f4420c, cyVar.m7870d()), c);
                }
            } catch (Throwable e) {
                C1324b.m7235d("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    private void m7837a(File file, String str) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (file != null) {
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.write(10);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (Throwable e2) {
                            C1324b.m7235d("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
                            return;
                        }
                    }
                    return;
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        C1324b.m7235d("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e2);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (Throwable e22) {
                                C1324b.m7235d("CsiReporter: Cannot close file: sdk_csi_data.txt.", e22);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e22 = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e4) {
                                C1324b.m7235d("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                            }
                        }
                        throw e22;
                    }
                }
            } catch (IOException e5) {
                e22 = e5;
                fileOutputStream = null;
                C1324b.m7235d("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e22);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                e22 = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e22;
            }
        }
        C1324b.m7234d("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
    }

    private void m7838a(Map<String, String> map, String str) {
        String a = m7840a(this.f4422e, map, str);
        if (this.f4425h.get()) {
            m7837a(this.f4426i, a);
        } else {
            C1319u.m7183e().m9216a(this.f4423f, this.f4424g, a);
        }
    }

    public cv m7839a(String str) {
        cv cvVar = (cv) this.f4421d.get(str);
        return cvVar != null ? cvVar : cv.f4427a;
    }

    String m7840a(String str, Map<String, String> map, String str2) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (Entry entry : map.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        StringBuilder stringBuilder = new StringBuilder(buildUpon.build().toString());
        stringBuilder.append("&").append("it").append("=").append(str2);
        return stringBuilder.toString();
    }

    Map<String, String> m7841a(Map<String, String> map, Map<String, String> map2) {
        Map<String, String> linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, m7839a(str).mo1274a(str2, (String) entry.getValue()));
        }
        return linkedHashMap;
    }

    public void m7842a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.f4420c.put("e", TextUtils.join(",", list));
        }
    }

    public boolean m7843a(cy cyVar) {
        return this.f4418a.offer(cyVar);
    }
}
