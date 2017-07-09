package com.hernanbosqued.toolbox;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class MainActivity extends BaseFragmentActivity implements MainFragment.Callbacks {

    MainPresenter mainPresenter;

    @Override
    protected Fragment getContent() {
        MainFragment fragment = MainFragment.newInstance();
        mainPresenter = new MainPresenter( Injection.provideSectionsService(getApplicationContext()), fragment);
        return fragment;
    }

    protected static Intent getIntent(Context context/*Composition composition*/) {
        Intent intent = new Intent(context, MainActivity.class);
        //intent.putExtra(Constants.COMPOSITION, composition);
        return intent;
    }
    @Override
    protected String getActionBarTitle() {
        return "Main";
    }

    @Override
    public void onButtonClicked() {
    }
}
