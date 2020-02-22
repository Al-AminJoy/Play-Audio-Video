package com.trustedoffer.playaudiovideo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private MediaPlayer mediaPlayer;
    private int pausePosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView=findViewById(R.id.vvVideo);
        String videoPath="android.resource://"+getPackageName()+"/"+R.raw.ural_pankhire;
        Uri uri=Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


    }
    public void play(View view)
    {
        if (mediaPlayer==null)
        {
            mediaPlayer=MediaPlayer.create(this,R.raw.voboghure);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlay();
                }
            });
            mediaPlayer.start();
        }
        else if (!mediaPlayer.isPlaying())
        {
            mediaPlayer.seekTo(pausePosition);
            mediaPlayer.start();
        }
    }

    public void pause(View view) {
        if (mediaPlayer!=null)
        {
          mediaPlayer.pause();
          pausePosition=mediaPlayer.getCurrentPosition();
        }
    }

    public void stop(View view) {

         stopPlay();
    }

    private void stopPlay() {
        if (mediaPlayer!=null)
        {
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

}
