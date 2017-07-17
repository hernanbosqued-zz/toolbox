package com.hernanbosqued.toolbox;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoFragment extends BaseFragment<Void>{

    private static String videoUrl;

    public static VideoFragment getFragment(String videoUrl){
        VideoFragment.videoUrl = videoUrl;
        return new VideoFragment();
    }
    @Override
    protected Void getDummyCallbacks() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        VideoView videoView = view.findViewById(R.id.video_view);
        MediaController mc = new MediaController(getActivity());
        mc.setAnchorView(videoView);
        mc.setMediaPlayer(videoView);
        Uri video = Uri.parse(videoUrl);
        videoView.setMediaController(mc);
        videoView.setVideoURI(video);
        videoView.requestFocus();
        videoView.start();
    }
}
