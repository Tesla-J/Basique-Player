package com.marcos.basiqueplayer;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer extends MediaPlayer {
    private MediaPlayer mAudioPlayer;

    public void play(Context c){
        //resume if paused
        if(mAudioPlayer != null){
            mAudioPlayer.start();
            return;
        }
        //stop();
        mAudioPlayer = MediaPlayer.create(c, R.raw.alarm);
        mAudioPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                stop();
            }
        });
        mAudioPlayer.start();
    }

    public void stop(){
        if(mAudioPlayer != null){
            mAudioPlayer.release();
            mAudioPlayer = null;
        }
    }

    public void pause(){
        if(mAudioPlayer != null){
            mAudioPlayer.pause();
        }
    }
}
