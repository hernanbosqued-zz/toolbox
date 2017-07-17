package com.hernanbosqued.toolbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public class VideoActivity extends BaseFragmentActivity {

    @Override
    protected Fragment getContent() {
        String videoUrl = getIntent().getStringExtra(getString(R.string.VIDEO_URL_KEY));
        return VideoFragment.getFragment(videoUrl);
    }

    @Override
    protected String getActionBarTitle() {
        return getString(R.string.app_name);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
