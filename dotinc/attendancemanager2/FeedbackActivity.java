package dotinc.attendancemanager2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.p018a.C0633d;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import dotinc.attendancemanager2.Utils.C2258b;

public class FeedbackActivity extends C0633d {
    Toolbar f7444m;
    EditText f7445n;
    EditText f7446o;
    TextInputLayout f7447p;
    TextInputLayout f7448q;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_feedback);
        this.f7444m = (Toolbar) findViewById(R.id.app_bar);
        m3331a(this.f7444m);
        m3337g().mo581a((CharSequence) "FeedBack");
        m3337g().mo582a(true);
        this.f7445n = (EditText) findViewById(R.id.feedtitle);
        this.f7445n.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans-bold.ttf"));
        this.f7446o = (EditText) findViewById(R.id.feedmsg);
        this.f7446o.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf"));
        this.f7447p = (TextInputLayout) findViewById(R.id.textTitle);
        this.f7448q = (TextInputLayout) findViewById(R.id.textMsg);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_feedback, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
        } else if (itemId == R.id.feedback) {
            String obj = this.f7445n.getText().toString();
            String obj2 = this.f7446o.getText().toString();
            if (obj.matches("") && obj2.matches("")) {
                this.f7447p.setError("Title cannot be blank");
                this.f7448q.setError("Message cannot be blank");
            } else if (obj.matches("")) {
                this.f7447p.setError("Title cannot be blank");
                this.f7448q.setError(null);
            } else if (obj2.matches("")) {
                this.f7447p.setError(null);
                this.f7448q.setError("Message cannot be blank");
            } else {
                this.f7447p.setError(null);
                this.f7448q.setError(null);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"agamgupta2895@gmail.com", "subhakr11droy@gmail.com"});
                intent.putExtra("android.intent.extra.SUBJECT", obj);
                intent.putExtra("android.intent.extra.TEXT", obj2 + C2258b.m12714a((Context) this));
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an Email Client"));
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onStop() {
        super.onStop();
        this.f7445n.setText("");
        this.f7446o.setText("");
    }
}
