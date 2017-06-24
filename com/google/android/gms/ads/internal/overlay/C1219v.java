package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.id;

@id
class C1219v implements SensorEventListener {
    private final SensorManager f3563a;
    private final Object f3564b = new Object();
    private final Display f3565c;
    private final float[] f3566d = new float[9];
    private final float[] f3567e = new float[9];
    private float[] f3568f;
    private Handler f3569g;
    private C1218a f3570h;

    class C12171 implements Runnable {
        final /* synthetic */ C1219v f3562a;

        C12171(C1219v c1219v) {
            this.f3562a = c1219v;
        }

        public void run() {
            Looper.myLooper().quit();
        }
    }

    interface C1218a {
        void mo1161a();
    }

    C1219v(Context context) {
        this.f3563a = (SensorManager) context.getSystemService("sensor");
        this.f3565c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private void m6743a(int i, int i2) {
        float f = this.f3567e[i];
        this.f3567e[i] = this.f3567e[i2];
        this.f3567e[i2] = f;
    }

    int m6744a() {
        return this.f3565c.getRotation();
    }

    void m6745a(C1218a c1218a) {
        this.f3570h = c1218a;
    }

    void m6746a(float[] fArr) {
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.f3564b) {
                if (this.f3568f == null) {
                    this.f3568f = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.f3566d, fArr);
            switch (m6744a()) {
                case 1:
                    SensorManager.remapCoordinateSystem(this.f3566d, 2, 129, this.f3567e);
                    break;
                case 2:
                    SensorManager.remapCoordinateSystem(this.f3566d, 129, 130, this.f3567e);
                    break;
                case 3:
                    SensorManager.remapCoordinateSystem(this.f3566d, 130, 1, this.f3567e);
                    break;
                default:
                    System.arraycopy(this.f3566d, 0, this.f3567e, 0, 9);
                    break;
            }
            m6743a(1, 3);
            m6743a(2, 6);
            m6743a(5, 7);
            synchronized (this.f3564b) {
                System.arraycopy(this.f3567e, 0, this.f3568f, 0, 9);
            }
            if (this.f3570h != null) {
                this.f3570h.mo1161a();
            }
        }
    }

    void m6747b() {
        if (this.f3569g == null) {
            Sensor defaultSensor = this.f3563a.getDefaultSensor(11);
            if (defaultSensor == null) {
                C1324b.m7230b("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            this.f3569g = new Handler(handlerThread.getLooper());
            if (!this.f3563a.registerListener(this, defaultSensor, 0, this.f3569g)) {
                C1324b.m7230b("SensorManager.registerListener failed.");
                m6749c();
            }
        }
    }

    boolean m6748b(float[] fArr) {
        boolean z = false;
        synchronized (this.f3564b) {
            if (this.f3568f == null) {
            } else {
                System.arraycopy(this.f3568f, 0, fArr, 0, this.f3568f.length);
                z = true;
            }
        }
        return z;
    }

    void m6749c() {
        if (this.f3569g != null) {
            this.f3563a.unregisterListener(this);
            this.f3569g.post(new C12171(this));
            this.f3569g = null;
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        m6746a(sensorEvent.values);
    }
}
