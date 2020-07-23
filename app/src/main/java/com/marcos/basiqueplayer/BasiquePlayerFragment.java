package com.marcos.basiqueplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class BasiquePlayerFragment extends Fragment {
    private Button mPlayButton;
    private Button mStopButton;
    private Button mPauseButton;
    private Button mWatchVideoButton;
    private AudioPlayer mAudioPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_basique_player, parent, false);

        //Audio
        mAudioPlayer = new AudioPlayer();
        mPlayButton = (Button) v.findViewById(R.id.play_button);
        mPlayButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mAudioPlayer.play(getActivity());
            }
        });
        mStopButton = (Button) v.findViewById(R.id.stop_button);
        mStopButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mAudioPlayer.stop();
            }
        });
        mPauseButton = (Button) v.findViewById(R.id.pause_button);
        mPauseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mAudioPlayer.pause();
            }
        });
        mWatchVideoButton = (Button) v.findViewById(R.id.watch_video_button);
        mWatchVideoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), VideoActivity.class);
                getActivity().startActivity(i);
            }
        });

        return v;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mAudioPlayer.stop();
    }
}
