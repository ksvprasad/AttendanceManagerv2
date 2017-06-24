package dotinc.attendancemanager2;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.p018a.C0633d;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.p043a.C2266a;
import dotinc.attendancemanager2.p043a.C2279f;
import dotinc.attendancemanager2.p045c.C2312b;
import java.util.ArrayList;

public class PredictorActivity extends C0633d {
    private Button f7601A;
    private C2259c f7602B;
    private int f7603C;
    private int f7604D;
    ArrayList<String> f7605m;
    ArrayList<String> f7606n;
    private Context f7607o;
    private Toolbar f7608p;
    private Spinner f7609q;
    private EditText f7610r;
    private TextView f7611s;
    private TextView f7612t;
    private TextView f7613u;
    private TextView f7614v;
    private RecyclerView f7615w;
    private C2279f f7616x;
    private ArrayList<String> f7617y;
    private ArrayList<C2312b> f7618z;

    class C22281 implements OnItemSelectedListener {
        final /* synthetic */ PredictorActivity f7599a;

        C22281(PredictorActivity predictorActivity) {
            this.f7599a = predictorActivity;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == 0) {
                this.f7599a.f7603C = 1;
            } else {
                this.f7599a.f7603C = 2;
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class C22292 implements OnClickListener {
        final /* synthetic */ PredictorActivity f7600a;

        C22292(PredictorActivity predictorActivity) {
            this.f7600a = predictorActivity;
        }

        public void onClick(View view) {
            if (this.f7600a.f7610r.getText().toString().trim().equals("")) {
                Snackbar.m706a(this.f7600a.findViewById(R.id.root), "Enter number of classes", 0).m724a();
                return;
            }
            this.f7600a.f7604D = Integer.parseInt(this.f7600a.f7610r.getText().toString());
            this.f7600a.f7616x = new C2279f(this.f7600a, this.f7600a.f7603C, this.f7600a.f7604D, this.f7600a.f7618z);
            this.f7600a.f7615w.setAdapter(this.f7600a.f7616x);
        }
    }

    private void m12619k() {
        this.f7606n.add("Attended");
        this.f7606n.add("Bunked");
        this.f7609q.setAdapter(new C2266a(this, this.f7606n));
        this.f7609q.setVisibility(0);
        this.f7610r.setVisibility(0);
        this.f7610r.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans-bold.ttf"));
        this.f7609q.setOnItemSelectedListener(new C22281(this));
        this.f7601A.setOnClickListener(new C22292(this));
    }

    private void m12620l() {
        this.f7607o = this;
        this.f7608p = (Toolbar) findViewById(R.id.toolbar);
        m3331a(this.f7608p);
        m3337g().mo582a(true);
        m3337g().mo581a((CharSequence) "Predictor");
        this.f7602B = new C2259c(this);
        this.f7617y = new ArrayList();
        this.f7609q = (Spinner) findViewById(R.id.second_choice);
        this.f7611s = (TextView) findViewById(R.id.predict_text);
        this.f7611s.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7612t = (TextView) findViewById(R.id.subjects);
        this.f7612t.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-regular.ttf"));
        this.f7613u = (TextView) findViewById(R.id.current);
        this.f7613u.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-regular.ttf"));
        this.f7614v = (TextView) findViewById(R.id.predicted);
        this.f7614v.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-regular.ttf"));
        this.f7610r = (EditText) findViewById(R.id.number_of_classes);
        this.f7615w = (RecyclerView) findViewById(R.id.predictor_recycler);
        this.f7618z = this.f7602B.m12727a();
        this.f7601A = (Button) findViewById(R.id.load_perc);
        this.f7601A.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-regular.ttf"));
        this.f7605m = new ArrayList();
        this.f7606n = new ArrayList();
        this.f7615w.setHasFixedSize(true);
        this.f7615w.setLayoutManager(new LinearLayoutManager(this));
    }

    private void showHelp() {
        Builder builder = new Builder(this.f7607o);
        View inflate = LayoutInflater.from(this.f7607o).inflate(R.layout.custom_need_break, null);
        builder.setView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.need_break_help);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-regular.ttf"));
        textView.setText(getResources().getString(R.string.predictor_help));
        builder.create().show();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_predictor);
        m12620l();
        m12619k();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.predictor_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        } else if (menuItem.getItemId() == R.id.help) {
            showHelp();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
