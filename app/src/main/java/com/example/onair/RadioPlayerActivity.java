package com.example.onair;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;


public class RadioPlayerActivity extends AppCompatActivity {

    private SimpleExoPlayer player;
    DefaultDataSourceFactory dataSourceFactory;
    MediaSource mediaSource;
    static String RADIO_URL = "http://s1.radioheart.ru:8001/radiogomelfm";

    boolean isEnabled;

    private Button StartStop;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_player);

        player = ExoPlayerFactory.newSimpleInstance(this);
        dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "OnAir"));
        mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(RADIO_URL));
        player.prepare(mediaSource);

        isEnabled = true;

        }

    //public void OnStart(View view) {player.setPlayWhenReady(true);   }


    // public void OnStop(View view) { player.setPlayWhenReady(false); }

    public void OnPlay(View view) {
        if (isEnabled){
            player.setPlayWhenReady(true);
            isEnabled = false;
            Button StartStop = (Button) findViewById(R.id.btnPlay);
            StartStop.setText("STOP");

        }
        else {
            player.setPlayWhenReady(false);
            isEnabled = true;
            Button StartStop = (Button) findViewById(R.id.btnPlay);
            StartStop.setText("PLAY");
            }
    }
}

