package com.hernanbosqued.toolbox;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public class MainActivity extends BaseFragmentActivity implements MainFragment.Callbacks {


    @Override
    protected Fragment getContent() {
        return MainFragment.newInstance();
    }

    protected static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected String getActionBarTitle() {
        return getString(R.string.app_name);
    }

    @Override
    public void onButtonClicked(String videoUrl) {
        Intent i = new Intent(this,VideoActivity.class);
        i.putExtra(getString(R.string.VIDEO_URL_KEY),videoUrl);
        startActivity(i);
    }
}
