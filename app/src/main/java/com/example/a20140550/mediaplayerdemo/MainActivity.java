package com.example.a20140550.mediaplayerdemo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private ImageButton pause,play;
  private   MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play= (ImageButton) findViewById(R.id.PlayID);
        pause= (ImageButton) findViewById(R.id.pauseID);

        mediaPlayer=MediaPlayer.create(this,R.raw.arifin);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.PlayID)
        {
            if(mediaPlayer!=null)
            {
               mediaPlayer.start();
          int duration   =   mediaPlayer.getDuration()/1000;
                Toast.makeText(this,"Play"+ duration,Toast.LENGTH_SHORT).show();
            }
        }
        if(v.getId()==R.id.pauseID)
        {
            if(mediaPlayer!=null)
            {
                mediaPlayer.pause();
                Toast.makeText(this,"Paused",Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer!=null && mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        super.onDestroy();
    }
}
