package dotinc.attendancemanager2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0236e;
import android.support.v4.p015g.C0381h;
import android.support.v7.p018a.C0633d;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import dotinc.attendancemanager2.Utils.C2258b;

public class ChooseAvatarActivity extends C0633d {
    private ImageView f7402m;
    private ImageView f7403n;
    private Animation f7404o;
    private TextView f7405p;
    private TextView f7406q;
    private Context f7407r;
    private Typeface f7408s;

    class C21951 implements AnimationListener {
        final /* synthetic */ ChooseAvatarActivity f7401a;

        C21951(ChooseAvatarActivity chooseAvatarActivity) {
            this.f7401a = chooseAvatarActivity;
        }

        public void onAnimationEnd(Animation animation) {
            this.f7401a.f7406q.setVisibility(0);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    @TargetApi(21)
    private void m12505c(Intent intent) {
        View findViewById = findViewById(R.id.user_male);
        View findViewById2 = findViewById(R.id.user_female);
        this.f7402m.setTransitionName("user_male_transition");
        this.f7403n.setTransitionName("user_female_transition");
        C0381h a = C0381h.m1933a(findViewById, "user_male_transition");
        C0381h a2 = C0381h.m1933a(findViewById2, "user_female_transition");
        startActivity(intent, C0236e.m1328a(this, a, a2).mo183a());
    }

    void m12506k() {
        this.f7407r = this;
        this.f7408s = Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf");
        this.f7405p = (TextView) findViewById(R.id.select_avatar_text);
        this.f7405p.setTypeface(this.f7408s);
        this.f7406q = (TextView) findViewById(R.id.or_text);
        this.f7406q.setTypeface(this.f7408s);
        this.f7402m = (ImageView) findViewById(R.id.user_male);
        this.f7403n = (ImageView) findViewById(R.id.user_female);
        this.f7404o = AnimationUtils.loadAnimation(this.f7407r, R.anim.expand_in);
        this.f7404o.setAnimationListener(new C21951(this));
    }

    public void onClickFemale(View view) {
        C2258b.m12715a(this.f7407r, "USER_IMAGE_ID", String.valueOf(2));
        if (VERSION.SDK_INT >= 21) {
            Intent intent = new Intent(this, NameAndCriteriaActivity.class);
            intent.putExtra("transitionName", "user_female_transition");
            m12505c(intent);
            return;
        }
        startActivity(new Intent(this, NameAndCriteriaActivity.class));
    }

    public void onClickMale(View view) {
        C2258b.m12715a(this.f7407r, "USER_IMAGE_ID", String.valueOf(1));
        if (VERSION.SDK_INT >= 21) {
            Intent intent = new Intent(this, NameAndCriteriaActivity.class);
            intent.putExtra("transitionName", "user_male_transition");
            m12505c(intent);
            return;
        }
        startActivity(new Intent(this, NameAndCriteriaActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_choose_avatar);
        m12506k();
        this.f7402m.startAnimation(this.f7404o);
        this.f7403n.startAnimation(this.f7404o);
        C2258b.m12716a(this.f7405p, getResources().getString(R.string.chooseAvatar), 45);
    }
}
