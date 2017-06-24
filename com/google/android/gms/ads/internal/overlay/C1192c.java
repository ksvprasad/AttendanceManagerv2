package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jv;
import com.google.android.gms.p031b.jz;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@id
@TargetApi(14)
public class C1192c extends C1191i implements OnAudioFocusChangeListener, OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnVideoSizeChangedListener, SurfaceTextureListener {
    private static final Map<Integer, String> f3500a = new HashMap();
    private final C1221x f3501b;
    private final boolean f3502c;
    private int f3503d = 0;
    private int f3504e = 0;
    private MediaPlayer f3505f;
    private Uri f3506g;
    private int f3507h;
    private int f3508i;
    private int f3509j;
    private int f3510k;
    private int f3511l;
    private float f3512m = 1.0f;
    private boolean f3513n;
    private boolean f3514o;
    private C1220w f3515p;
    private boolean f3516q;
    private int f3517r;
    private C1204h f3518s;

    class C11841 implements Runnable {
        final /* synthetic */ C1192c f3491a;

        C11841(C1192c c1192c) {
            this.f3491a = c1192c;
        }

        public void run() {
            if (this.f3491a.f3518s != null) {
                this.f3491a.f3518s.mo1148b();
            }
        }
    }

    class C11852 implements Runnable {
        final /* synthetic */ C1192c f3492a;

        C11852(C1192c c1192c) {
            this.f3492a = c1192c;
        }

        public void run() {
            if (this.f3492a.f3518s != null) {
                this.f3492a.f3518s.mo1151e();
            }
        }
    }

    class C11874 implements Runnable {
        final /* synthetic */ C1192c f3496a;

        C11874(C1192c c1192c) {
            this.f3496a = c1192c;
        }

        public void run() {
            if (this.f3496a.f3518s != null) {
                this.f3496a.f3518s.mo1146a();
            }
        }
    }

    class C11885 implements Runnable {
        final /* synthetic */ C1192c f3497a;

        C11885(C1192c c1192c) {
            this.f3497a = c1192c;
        }

        public void run() {
            if (this.f3497a.f3518s != null) {
                this.f3497a.f3518s.mo1150d();
                this.f3497a.f3518s.mo1152f();
            }
        }
    }

    class C11896 implements Runnable {
        final /* synthetic */ C1192c f3498a;

        C11896(C1192c c1192c) {
            this.f3498a = c1192c;
        }

        public void run() {
            if (this.f3498a.f3518s != null) {
                this.f3498a.f3518s.mo1149c();
            }
        }
    }

    class C11907 implements Runnable {
        final /* synthetic */ C1192c f3499a;

        C11907(C1192c c1192c) {
            this.f3499a = c1192c;
        }

        public void run() {
            if (this.f3499a.f3518s != null) {
                this.f3499a.f3518s.mo1150d();
            }
        }
    }

    static {
        f3500a.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
        f3500a.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
        f3500a.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
        f3500a.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
        f3500a.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        f3500a.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        f3500a.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        f3500a.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        f3500a.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        f3500a.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        f3500a.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        f3500a.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        f3500a.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        f3500a.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        f3500a.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        f3500a.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public C1192c(Context context, boolean z, boolean z2, C1221x c1221x) {
        super(context);
        setSurfaceTextureListener(this);
        this.f3501b = c1221x;
        this.f3516q = z;
        this.f3502c = z2;
        this.f3501b.m6776a((C1191i) this);
    }

    private void m6611a(boolean z) {
        jv.m9152e("AdMediaPlayerView release");
        if (this.f3515p != null) {
            this.f3515p.m6766b();
            this.f3515p = null;
        }
        if (this.f3505f != null) {
            this.f3505f.reset();
            this.f3505f.release();
            this.f3505f = null;
            m6613b(0);
            if (z) {
                this.f3504e = 0;
                m6614c(0);
            }
            m6618j();
        }
    }

    private void m6612b(float f) {
        if (this.f3505f != null) {
            try {
                this.f3505f.setVolume(f, f);
                return;
            } catch (IllegalStateException e) {
                return;
            }
        }
        C1324b.m7234d("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
    }

    private void m6613b(int i) {
        if (i == 3) {
            this.f3501b.m6779c();
        } else if (this.f3503d == 3) {
            this.f3501b.m6780d();
        }
        this.f3503d = i;
    }

    private void m6614c(int i) {
        this.f3504e = i;
    }

    private void m6615g() {
        Throwable e;
        String valueOf;
        jv.m9152e("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.f3506g != null && surfaceTexture != null) {
            m6611a(false);
            try {
                SurfaceTexture c;
                this.f3505f = C1319u.m7196r().m6733a();
                this.f3505f.setOnBufferingUpdateListener(this);
                this.f3505f.setOnCompletionListener(this);
                this.f3505f.setOnErrorListener(this);
                this.f3505f.setOnInfoListener(this);
                this.f3505f.setOnPreparedListener(this);
                this.f3505f.setOnVideoSizeChangedListener(this);
                this.f3509j = 0;
                if (this.f3516q) {
                    this.f3515p = new C1220w(getContext());
                    this.f3515p.m6765a(surfaceTexture, getWidth(), getHeight());
                    this.f3515p.start();
                    c = this.f3515p.m6767c();
                    if (c == null) {
                        this.f3515p.m6766b();
                        this.f3515p = null;
                    }
                    this.f3505f.setDataSource(getContext(), this.f3506g);
                    this.f3505f.setSurface(C1319u.m7197s().m6734a(c));
                    this.f3505f.setAudioStreamType(3);
                    this.f3505f.setScreenOnWhilePlaying(true);
                    this.f3505f.prepareAsync();
                    m6613b(1);
                }
                c = surfaceTexture;
                this.f3505f.setDataSource(getContext(), this.f3506g);
                this.f3505f.setSurface(C1319u.m7197s().m6734a(c));
                this.f3505f.setAudioStreamType(3);
                this.f3505f.setScreenOnWhilePlaying(true);
                this.f3505f.prepareAsync();
                m6613b(1);
            } catch (IOException e2) {
                e = e2;
                valueOf = String.valueOf(this.f3506g);
                C1324b.m7235d(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.f3505f, 1, 0);
            } catch (IllegalArgumentException e3) {
                e = e3;
                valueOf = String.valueOf(this.f3506g);
                C1324b.m7235d(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.f3505f, 1, 0);
            } catch (IllegalStateException e4) {
                e = e4;
                valueOf = String.valueOf(this.f3506g);
                C1324b.m7235d(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.f3505f, 1, 0);
            }
        }
    }

    private void m6616h() {
        if (this.f3502c && m6619k() && this.f3505f.getCurrentPosition() > 0 && this.f3504e != 3) {
            jv.m9152e("AdMediaPlayerView nudging MediaPlayer");
            m6612b(0.0f);
            this.f3505f.start();
            int currentPosition = this.f3505f.getCurrentPosition();
            long a = C1319u.m7187i().mo1723a();
            while (m6619k() && this.f3505f.getCurrentPosition() == currentPosition) {
                if (C1319u.m7187i().mo1723a() - a > 250) {
                    break;
                }
            }
            this.f3505f.pause();
            m6622n();
        }
    }

    private void m6617i() {
        AudioManager o = m6623o();
        if (o != null && !this.f3514o) {
            if (o.requestAudioFocus(this, 3, 2) == 1) {
                m6620l();
            } else {
                C1324b.m7234d("AdMediaPlayerView audio focus request failed");
            }
        }
    }

    private void m6618j() {
        jv.m9152e("AdMediaPlayerView abandon audio focus");
        AudioManager o = m6623o();
        if (o != null && this.f3514o) {
            if (o.abandonAudioFocus(this) == 1) {
                this.f3514o = false;
            } else {
                C1324b.m7234d("AdMediaPlayerView abandon audio focus failed");
            }
        }
    }

    private boolean m6619k() {
        return (this.f3505f == null || this.f3503d == -1 || this.f3503d == 0 || this.f3503d == 1) ? false : true;
    }

    private void m6620l() {
        jv.m9152e("AdMediaPlayerView audio focus gained");
        this.f3514o = true;
        m6622n();
    }

    private void m6621m() {
        jv.m9152e("AdMediaPlayerView audio focus lost");
        this.f3514o = false;
        m6622n();
    }

    private void m6622n() {
        if (this.f3513n || !this.f3514o) {
            m6612b(0.0f);
        } else {
            m6612b(this.f3512m);
        }
    }

    private AudioManager m6623o() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    public String mo1117a() {
        String str = "MediaPlayer";
        String valueOf = String.valueOf(this.f3516q ? " spherical" : "");
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    public void mo1118a(float f) {
        this.f3512m = f;
        m6622n();
    }

    public void mo1119a(float f, float f2) {
        if (this.f3515p != null) {
            this.f3515p.m6763a(f, f2);
        }
    }

    public void mo1120a(int i) {
        jv.m9152e("AdMediaPlayerView seek " + i);
        if (m6619k()) {
            this.f3505f.seekTo(i);
            this.f3517r = 0;
            return;
        }
        this.f3517r = i;
    }

    public void mo1121a(C1204h c1204h) {
        this.f3518s = c1204h;
    }

    public void mo1122b() {
        jv.m9152e("AdMediaPlayerView stop");
        if (this.f3505f != null) {
            this.f3505f.stop();
            this.f3505f.release();
            this.f3505f = null;
            m6613b(0);
            m6614c(0);
            m6618j();
        }
        this.f3501b.m6777b();
    }

    public void mo1123c() {
        jv.m9152e("AdMediaPlayerView play");
        if (m6619k()) {
            this.f3505f.start();
            m6613b(3);
            jz.f5567a.post(new C11896(this));
        }
        m6614c(3);
    }

    public void mo1124d() {
        jv.m9152e("AdMediaPlayerView pause");
        if (m6619k() && this.f3505f.isPlaying()) {
            this.f3505f.pause();
            m6613b(4);
            jz.f5567a.post(new C11907(this));
        }
        m6614c(4);
    }

    public void mo1125e() {
        this.f3513n = true;
        m6622n();
    }

    public void mo1126f() {
        this.f3513n = false;
        m6622n();
    }

    public int getCurrentPosition() {
        return m6619k() ? this.f3505f.getCurrentPosition() : 0;
    }

    public int getDuration() {
        return m6619k() ? this.f3505f.getDuration() : -1;
    }

    public int getVideoHeight() {
        return this.f3505f != null ? this.f3505f.getVideoHeight() : 0;
    }

    public int getVideoWidth() {
        return this.f3505f != null ? this.f3505f.getVideoWidth() : 0;
    }

    public void onAudioFocusChange(int i) {
        if (i > 0) {
            m6620l();
        } else if (i < 0) {
            m6621m();
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.f3509j = i;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        jv.m9152e("AdMediaPlayerView completion");
        m6613b(5);
        m6614c(5);
        jz.f5567a.post(new C11852(this));
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        final String str = (String) f3500a.get(Integer.valueOf(i));
        final String str2 = (String) f3500a.get(Integer.valueOf(i2));
        C1324b.m7234d(new StringBuilder((String.valueOf(str).length() + 38) + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer error: ").append(str).append(":").append(str2).toString());
        m6613b(-1);
        m6614c(-1);
        jz.f5567a.post(new Runnable(this) {
            final /* synthetic */ C1192c f3495c;

            public void run() {
                if (this.f3495c.f3518s != null) {
                    this.f3495c.f3518s.mo1147a(str, str2);
                }
            }
        });
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f3500a.get(Integer.valueOf(i));
        String str2 = (String) f3500a.get(Integer.valueOf(i2));
        jv.m9152e(new StringBuilder((String.valueOf(str).length() + 37) + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer info: ").append(str).append(":").append(str2).toString());
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = C1192c.getDefaultSize(this.f3507h, i);
        int defaultSize2 = C1192c.getDefaultSize(this.f3508i, i2);
        if (this.f3507h > 0 && this.f3508i > 0 && this.f3515p == null) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            defaultSize2 = MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.f3507h * defaultSize2 < this.f3508i * size) {
                    defaultSize = (this.f3507h * defaultSize2) / this.f3508i;
                } else if (this.f3507h * defaultSize2 > this.f3508i * size) {
                    defaultSize2 = (this.f3508i * size) / this.f3507h;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                defaultSize = (this.f3508i * size) / this.f3507h;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.f3507h * defaultSize2) / this.f3508i;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i3 = this.f3507h;
                defaultSize = this.f3508i;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i3;
                } else {
                    defaultSize = (this.f3507h * defaultSize2) / this.f3508i;
                }
                if (mode == Integer.MIN_VALUE && r1 > size) {
                    defaultSize2 = (this.f3508i * size) / this.f3507h;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (this.f3515p != null) {
            this.f3515p.m6764a(defaultSize, defaultSize2);
        }
        if (VERSION.SDK_INT == 16) {
            if ((this.f3510k > 0 && this.f3510k != defaultSize) || (this.f3511l > 0 && this.f3511l != defaultSize2)) {
                m6616h();
            }
            this.f3510k = defaultSize;
            this.f3511l = defaultSize2;
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        jv.m9152e("AdMediaPlayerView prepared");
        m6613b(2);
        this.f3501b.m6775a();
        jz.f5567a.post(new C11841(this));
        this.f3507h = mediaPlayer.getVideoWidth();
        this.f3508i = mediaPlayer.getVideoHeight();
        if (this.f3517r != 0) {
            mo1120a(this.f3517r);
        }
        m6616h();
        int i = this.f3507h;
        C1324b.m7232c("AdMediaPlayerView stream dimensions: " + i + " x " + this.f3508i);
        if (this.f3504e == 3) {
            mo1123c();
        }
        m6617i();
        m6622n();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        jv.m9152e("AdMediaPlayerView surface created");
        m6615g();
        jz.f5567a.post(new C11874(this));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        jv.m9152e("AdMediaPlayerView surface destroyed");
        if (this.f3505f != null && this.f3517r == 0) {
            this.f3517r = this.f3505f.getCurrentPosition();
        }
        if (this.f3515p != null) {
            this.f3515p.m6766b();
        }
        jz.f5567a.post(new C11885(this));
        m6611a(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Object obj = 1;
        jv.m9152e("AdMediaPlayerView surface changed");
        Object obj2 = this.f3504e == 3 ? 1 : null;
        if (!(this.f3507h == i && this.f3508i == i2)) {
            obj = null;
        }
        if (!(this.f3505f == null || obj2 == null || r1 == null)) {
            if (this.f3517r != 0) {
                mo1120a(this.f3517r);
            }
            mo1123c();
        }
        if (this.f3515p != null) {
            this.f3515p.m6764a(i, i2);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f3501b.m6778b(this);
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        jv.m9152e("AdMediaPlayerView size changed: " + i + " x " + i2);
        this.f3507h = mediaPlayer.getVideoWidth();
        this.f3508i = mediaPlayer.getVideoHeight();
        if (this.f3507h != 0 && this.f3508i != 0) {
            requestLayout();
        }
    }

    public void setMimeType(String str) {
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.f3506g = uri;
        this.f3517r = 0;
        m6615g();
        requestLayout();
        invalidate();
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getName());
        String valueOf2 = String.valueOf(Integer.toHexString(hashCode()));
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("@").append(valueOf2).toString();
    }
}
