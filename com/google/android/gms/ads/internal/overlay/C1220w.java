package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.overlay.C1219v.C1218a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.cl;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.id;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@id
@TargetApi(14)
public class C1220w extends Thread implements OnFrameAvailableListener, C1218a {
    private static final float[] f3571a = new float[]{-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean f3572A;
    private volatile boolean f3573B;
    private final C1219v f3574b;
    private final float[] f3575c;
    private final float[] f3576d;
    private final float[] f3577e;
    private final float[] f3578f;
    private final float[] f3579g;
    private final float[] f3580h;
    private final float[] f3581i;
    private float f3582j;
    private float f3583k;
    private float f3584l;
    private int f3585m;
    private int f3586n;
    private SurfaceTexture f3587o;
    private SurfaceTexture f3588p;
    private int f3589q;
    private int f3590r;
    private int f3591s;
    private FloatBuffer f3592t = ByteBuffer.allocateDirect(f3571a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private final CountDownLatch f3593u;
    private final Object f3594v;
    private EGL10 f3595w;
    private EGLDisplay f3596x;
    private EGLContext f3597y;
    private EGLSurface f3598z;

    C1220w(Context context) {
        super("SphericalVideoProcessor");
        this.f3592t.put(f3571a).position(0);
        this.f3575c = new float[9];
        this.f3576d = new float[9];
        this.f3577e = new float[9];
        this.f3578f = new float[9];
        this.f3579g = new float[9];
        this.f3580h = new float[9];
        this.f3581i = new float[9];
        this.f3582j = Float.NaN;
        this.f3574b = new C1219v(context);
        this.f3574b.m6745a((C1218a) this);
        this.f3593u = new CountDownLatch(1);
        this.f3594v = new Object();
    }

    private float m6750a(float[] fArr) {
        float[] a = m6755a(fArr, new float[]{0.0f, 1.0f, 0.0f});
        return ((float) Math.atan2((double) a[1], (double) a[0])) - 1.5707964f;
    }

    private int m6751a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m6752a("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            m6752a("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            m6752a("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            m6752a("getShaderiv");
            if (iArr[0] == 0) {
                Log.e("SphericalVideoRenderer", "Could not compile shader " + i + ":");
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                m6752a("deleteShader");
                return 0;
            }
        }
        return glCreateShader;
    }

    private void m6752a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("SphericalVideoRenderer", new StringBuilder(String.valueOf(str).length() + 21).append(str).append(": glError ").append(glGetError).toString());
        }
    }

    private void m6753a(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = (float) Math.cos((double) f);
        fArr[5] = (float) (-Math.sin((double) f));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin((double) f);
        fArr[8] = (float) Math.cos((double) f);
    }

    private void m6754a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = ((fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3])) + (fArr2[2] * fArr3[6]);
        fArr[1] = ((fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4])) + (fArr2[2] * fArr3[7]);
        fArr[2] = ((fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5])) + (fArr2[2] * fArr3[8]);
        fArr[3] = ((fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3])) + (fArr2[5] * fArr3[6]);
        fArr[4] = ((fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4])) + (fArr2[5] * fArr3[7]);
        fArr[5] = ((fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5])) + (fArr2[5] * fArr3[8]);
        fArr[6] = ((fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3])) + (fArr2[8] * fArr3[6]);
        fArr[7] = ((fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4])) + (fArr2[8] * fArr3[7]);
        fArr[8] = ((fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5])) + (fArr2[8] * fArr3[8]);
    }

    private float[] m6755a(float[] fArr, float[] fArr2) {
        return new float[]{((fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1])) + (fArr[2] * fArr2[2]), ((fArr[3] * fArr2[0]) + (fArr[4] * fArr2[1])) + (fArr[5] * fArr2[2]), ((fArr[6] * fArr2[0]) + (fArr[7] * fArr2[1])) + (fArr[8] * fArr2[2])};
    }

    private void m6756b(float[] fArr, float f) {
        fArr[0] = (float) Math.cos((double) f);
        fArr[1] = (float) (-Math.sin((double) f));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin((double) f);
        fArr[4] = (float) Math.cos((double) f);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private void m6757h() {
        GLES20.glViewport(0, 0, this.f3586n, this.f3585m);
        m6752a("viewport");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3589q, "uFOVx");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3589q, "uFOVy");
        if (this.f3586n > this.f3585m) {
            GLES20.glUniform1f(glGetUniformLocation, 0.87266463f);
            GLES20.glUniform1f(glGetUniformLocation2, (((float) this.f3585m) * 0.87266463f) / ((float) this.f3586n));
            return;
        }
        GLES20.glUniform1f(glGetUniformLocation, (((float) this.f3586n) * 0.87266463f) / ((float) this.f3585m));
        GLES20.glUniform1f(glGetUniformLocation2, 0.87266463f);
    }

    private int m6758i() {
        int a = m6751a(35633, m6760k());
        if (a == 0) {
            return 0;
        }
        int a2 = m6751a(35632, m6761l());
        if (a2 == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        m6752a("createProgram");
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, a);
            m6752a("attachShader");
            GLES20.glAttachShader(glCreateProgram, a2);
            m6752a("attachShader");
            GLES20.glLinkProgram(glCreateProgram);
            m6752a("linkProgram");
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            m6752a("getProgramiv");
            if (iArr[0] != 1) {
                Log.e("SphericalVideoRenderer", "Could not link program: ");
                Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                m6752a("deleteProgram");
                return 0;
            }
            GLES20.glValidateProgram(glCreateProgram);
            m6752a("validateProgram");
        }
        return glCreateProgram;
    }

    private EGLConfig m6759j() {
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        return !this.f3595w.eglChooseConfig(this.f3596x, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr) ? null : iArr[0] > 0 ? eGLConfigArr[0] : null;
    }

    private String m6760k() {
        cl clVar = cq.ap;
        return !((String) clVar.m7801c()).equals(clVar.m7800b()) ? (String) clVar.m7801c() : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}";
    }

    private String m6761l() {
        cl clVar = cq.aq;
        return !((String) clVar.m7801c()).equals(clVar.m7800b()) ? (String) clVar.m7801c() : "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}";
    }

    public void mo1161a() {
        synchronized (this.f3594v) {
            this.f3594v.notifyAll();
        }
    }

    void m6763a(float f, float f2) {
        float f3;
        float f4;
        if (this.f3586n > this.f3585m) {
            f3 = (1.7453293f * f) / ((float) this.f3586n);
            f4 = (1.7453293f * f2) / ((float) this.f3586n);
        } else {
            f3 = (1.7453293f * f) / ((float) this.f3585m);
            f4 = (1.7453293f * f2) / ((float) this.f3585m);
        }
        this.f3583k -= f3;
        this.f3584l -= f4;
        if (this.f3584l < -1.5707964f) {
            this.f3584l = -1.5707964f;
        }
        if (this.f3584l > 1.5707964f) {
            this.f3584l = 1.5707964f;
        }
    }

    void m6764a(int i, int i2) {
        synchronized (this.f3594v) {
            this.f3586n = i;
            this.f3585m = i2;
            this.f3572A = true;
            this.f3594v.notifyAll();
        }
    }

    void m6765a(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f3586n = i;
        this.f3585m = i2;
        this.f3588p = surfaceTexture;
    }

    void m6766b() {
        synchronized (this.f3594v) {
            this.f3573B = true;
            this.f3588p = null;
            this.f3594v.notifyAll();
        }
    }

    public SurfaceTexture m6767c() {
        if (this.f3588p == null) {
            return null;
        }
        try {
            this.f3593u.await();
        } catch (InterruptedException e) {
        }
        return this.f3587o;
    }

    void m6768d() {
        while (this.f3591s > 0) {
            this.f3587o.updateTexImage();
            this.f3591s--;
        }
        if (this.f3574b.m6748b(this.f3575c)) {
            if (Float.isNaN(this.f3582j)) {
                this.f3582j = -m6750a(this.f3575c);
            }
            m6756b(this.f3580h, this.f3582j + this.f3583k);
        } else {
            m6753a(this.f3575c, -1.5707964f);
            m6756b(this.f3580h, this.f3583k);
        }
        m6753a(this.f3576d, 1.5707964f);
        m6754a(this.f3577e, this.f3580h, this.f3576d);
        m6754a(this.f3578f, this.f3575c, this.f3577e);
        m6753a(this.f3579g, this.f3584l);
        m6754a(this.f3581i, this.f3579g, this.f3578f);
        GLES20.glUniformMatrix3fv(this.f3590r, 1, false, this.f3581i, 0);
        GLES20.glDrawArrays(5, 0, 4);
        m6752a("drawArrays");
        GLES20.glFinish();
        this.f3595w.eglSwapBuffers(this.f3596x, this.f3598z);
    }

    int m6769e() {
        this.f3589q = m6758i();
        GLES20.glUseProgram(this.f3589q);
        m6752a("useProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f3589q, "aPosition");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, this.f3592t);
        m6752a("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        m6752a("enableVertexAttribArray");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        m6752a("genTextures");
        glGetAttribLocation = iArr[0];
        GLES20.glBindTexture(36197, glGetAttribLocation);
        m6752a("bindTextures");
        GLES20.glTexParameteri(36197, 10240, 9729);
        m6752a("texParameteri");
        GLES20.glTexParameteri(36197, 10241, 9729);
        m6752a("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        m6752a("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        m6752a("texParameteri");
        this.f3590r = GLES20.glGetUniformLocation(this.f3589q, "uVMat");
        GLES20.glUniformMatrix3fv(this.f3590r, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        return glGetAttribLocation;
    }

    boolean m6770f() {
        this.f3595w = (EGL10) EGLContext.getEGL();
        this.f3596x = this.f3595w.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.f3596x == EGL10.EGL_NO_DISPLAY) {
            return false;
        }
        if (!this.f3595w.eglInitialize(this.f3596x, new int[2])) {
            return false;
        }
        EGLConfig j = m6759j();
        if (j == null) {
            return false;
        }
        this.f3597y = this.f3595w.eglCreateContext(this.f3596x, j, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        if (this.f3597y == null || this.f3597y == EGL10.EGL_NO_CONTEXT) {
            return false;
        }
        this.f3598z = this.f3595w.eglCreateWindowSurface(this.f3596x, j, this.f3588p, null);
        return (this.f3598z == null || this.f3598z == EGL10.EGL_NO_SURFACE) ? false : this.f3595w.eglMakeCurrent(this.f3596x, this.f3598z, this.f3598z, this.f3597y);
    }

    boolean m6771g() {
        boolean z = false;
        if (!(this.f3598z == null || this.f3598z == EGL10.EGL_NO_SURFACE)) {
            z = (this.f3595w.eglMakeCurrent(this.f3596x, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | 0) | this.f3595w.eglDestroySurface(this.f3596x, this.f3598z);
            this.f3598z = null;
        }
        if (this.f3597y != null) {
            z |= this.f3595w.eglDestroyContext(this.f3596x, this.f3597y);
            this.f3597y = null;
        }
        if (this.f3596x == null) {
            return z;
        }
        z |= this.f3595w.eglTerminate(this.f3596x);
        this.f3596x = null;
        return z;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f3591s++;
        synchronized (this.f3594v) {
            this.f3594v.notifyAll();
        }
    }

    public void run() {
        boolean z = false;
        if (this.f3588p == null) {
            C1324b.m7230b("SphericalVideoProcessor started with no output texture.");
            this.f3593u.countDown();
            return;
        }
        boolean f = m6770f();
        int e = m6769e();
        if (this.f3589q != 0) {
            z = true;
        }
        if (f && r0) {
            this.f3587o = new SurfaceTexture(e);
            this.f3587o.setOnFrameAvailableListener(this);
            this.f3593u.countDown();
            this.f3574b.m6747b();
            try {
                this.f3572A = true;
                while (!this.f3573B) {
                    m6768d();
                    if (this.f3572A) {
                        m6757h();
                        this.f3572A = false;
                    }
                    try {
                        synchronized (this.f3594v) {
                            if (!(this.f3573B || this.f3572A || this.f3591s != 0)) {
                                this.f3594v.wait();
                            }
                        }
                    } catch (InterruptedException e2) {
                    }
                }
            } catch (IllegalStateException e3) {
                C1324b.m7234d("SphericalVideoProcessor halted unexpectedly.");
            } catch (Throwable th) {
                C1324b.m7231b("SphericalVideoProcessor died.", th);
                C1319u.m7186h().m9117a(th, true);
            } finally {
                this.f3574b.m6749c();
                this.f3587o.setOnFrameAvailableListener(null);
                this.f3587o = null;
                m6771g();
            }
        } else {
            String str = "EGL initialization failed: ";
            String valueOf = String.valueOf(GLUtils.getEGLErrorString(this.f3595w.eglGetError()));
            valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
            C1324b.m7230b(valueOf);
            C1319u.m7186h().m9117a(new Throwable(valueOf), true);
            m6771g();
            this.f3593u.countDown();
        }
    }
}
