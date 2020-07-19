package com.marcos.basiqueplayer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class BasiquePlayerFragment extends Fragment {
    private Button mPlayButton;
    private Button mStopButton;
    private AudioPlayer mPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_basique_player, parent, false);

        mPlayer = new AudioPlayer();
        mPlayButton = (Button) v.findViewById(R.id.play_button);
        mPlayButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPlayer.play(getActivity());
            }
        });
        mStopButton = (Button) v.findViewById(R.id.stop_button);
        mStopButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPlayer.stop();
            }
        });

        return v;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mPlayer.stop();
    }
}
