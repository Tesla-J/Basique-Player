package com.marcos.basiqueplayer;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer extends MediaPlayer {
    private MediaPlayer mPlayer;

    public void play(Context c){
        stop();
        mPlayer = MediaPlayer.create(c, R.raw.alarm);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                stop();
            }
        });
        mPlayer.start();
    }

    public void stop(){
        if(mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }
}
