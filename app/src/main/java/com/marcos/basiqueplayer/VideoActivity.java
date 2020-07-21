package com.marcos.basiqueplayer;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoActivity extends Activity {
    private VideoPlayer mVideoPlayer;
    private VideoView mVideoView;
    private String VIDEO_PATH;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //Video
        VIDEO_PATH =  "android.resource://" + getPackageName() + "/" + R.raw.opening;
        uri = Uri.parse(VIDEO_PATH);
        mVideoView = (VideoView) findViewById(R.id.video_view);
        mVideoPlayer = new VideoPlayer(VideoActivity.this, mVideoView, uri);
    }
}
