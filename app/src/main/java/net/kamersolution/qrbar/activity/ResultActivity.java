package net.kamersolution.qrbar.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdListener;

import net.kamersolution.qrbar.R;
import net.kamersolution.qrbar.data.preference.AppPreference;
import net.kamersolution.qrbar.data.preference.PrefKey;
import net.kamersolution.qrbar.utility.AdManager;

import java.util.ArrayList;


public class ResultActivity<FloatingActionButton> extends AppCompatActivity {

    private AppCompatActivity mActivity;
    private Context mContext;

    private TextView result;
    private FloatingActionButton copyButton;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVars();
        initViews();
        initFunctionality();
        initListeners();
    }

    private void initListeners() {
    }

    private void initVars() {
        mActivity = ResultActivity.this;
        mContext = mActivity.getApplicationContext();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initViews() {
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        result = (TextView) findViewById(R.id.result);
        copyButton = (FloatingActionButton) findViewById(R.id.copy);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    private void initFunctionality() {

        getSupportActionBar().setTitle(getString(R.string.result));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ArrayList<String> arrayList = AppPreference.getInstance(mContext).getStringArray(PrefKey.RESULT_LIST);
        String lastResult = arrayList.get(arrayList.size()-1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            result.setText(Html.fromHtml(lastResult, Html.FROM_HTML_MODE_LEGACY));
        } else {
            result.setText(Html.fromHtml(lastResult));
        }
        result.setMovementMethod(LinkMovementMethod.getInstance());

        // TODO Sample fullscreen Ad implementation
        // fullscreen ad
        AdManager.getInstance(mContext).loadFullScreenAd(mActivity);
        AdManager.getInstance(mContext).getInterstitialAd().setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                AdManager.getInstance(mContext).showFullScreenAd();
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

