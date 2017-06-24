package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;
import com.google.android.gms.p031b.id;

@id
@TargetApi(14)
public abstract class C1191i extends TextureView {
    public C1191i(Context context) {
        super(context);
    }

    public abstract String mo1117a();

    public abstract void mo1118a(float f);

    public abstract void mo1119a(float f, float f2);

    public abstract void mo1120a(int i);

    public abstract void mo1121a(C1204h c1204h);

    public abstract void mo1122b();

    public abstract void mo1123c();

    public abstract void mo1124d();

    public abstract void mo1125e();

    public abstract void mo1126f();

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void setMimeType(String str);

    public abstract void setVideoPath(String str);
}
