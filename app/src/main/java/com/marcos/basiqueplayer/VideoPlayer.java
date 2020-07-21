package com.marcos.basiqueplayer;

import android.content.Context;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer {
    private VideoView mVideoView;
    private MediaController mMediaController;

    /**
    * Sets a video player.
     * Patameters: Context c, VideoView v, Uri uri
     * c -> the target context
     * v -> the view where the video will be hosted
     * uri -> the URI of the path of the video resource
     */
    public VideoPlayer(Context c, VideoView v, Uri uri){
        mVideoView = v;
        mVideoView.setVideoURI(uri);
        mMediaController = new MediaController(c);
        mVideoView.setMediaController(mMediaController);
        mMediaController.setAnchorView(mVideoView);

    }

}
