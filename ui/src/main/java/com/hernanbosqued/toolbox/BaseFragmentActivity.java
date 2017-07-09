package com.hernanbosqued.toolbox;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

@SuppressWarnings("SameParameterValue")
public abstract class BaseFragmentActivity extends AppCompatActivity {

    protected static final String MAIN_FRAGMENT_TAG = "main_tag";
    private static final String STACK_KEY = "stack";
    private int mFragmentId;

    protected abstract Fragment getContent();

    protected abstract String getActionBarTitle();

    protected void setToolbarTitle( ) {
        if( getSupportActionBar() != null ) {
            getSupportActionBar().setTitle(getActionBarTitle());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView();

        initContentView();

        setToolbarTitle( );

        if (savedInstanceState == null) {
            initFragmentContent();
        }
    }

    protected void setContentView() {
        setContentView(R.layout.activity_base);
    }

    protected void initContentView() {
        mFragmentId = R.id.fragmentContainer;
    }

    protected void initFragmentContent() {
        replaceContent(getContent(), false, MAIN_FRAGMENT_TAG);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getCurrentFragment();
        if (fragment instanceof BackPressedCallbacks) {
            if (((BackPressedCallbacks) fragment).onBackPressedCallback()) {
                return;
            }
        }

        super.onBackPressed();
    }

    protected Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(mFragmentId);
    }

    protected void replaceContent(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(mFragmentId, fragment, tag);
        if (addToBackStack) {
            ft.addToBackStack(STACK_KEY);
        }
        ft.commitAllowingStateLoss();
    }

    public interface BackPressedCallbacks {
        boolean onBackPressedCallback();
    }
}