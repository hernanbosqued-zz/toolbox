package com.hernanbosqued.toolbox;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

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
        return "Main";
    }

    @Override
    public void onButtonClicked() {
    }
}
