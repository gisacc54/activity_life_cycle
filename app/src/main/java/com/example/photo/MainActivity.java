package com.example.photo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.show("On Create");
        imageView =(ImageView)findViewById(R.id.photo);
        imageView.setImageResource(R.drawable.pic1);
    }



    @Override
    protected void onStart() {
        super.onStart();
        play();
        this.show("On Start");
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        this.show("On Restart");
        play();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.show("On Stop");
        pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyPlayer();
        this.show("On Destroy");
    }

    public void play(){
        if(mediaPlayer == null)
        {
            mediaPlayer = MediaPlayer.create(this,R.raw.song);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }
        mediaPlayer.start();
    }
    public void pause(){
        if(mediaPlayer != null)
        {
            mediaPlayer.pause();
        }
    }
    public void stop(){
        if(mediaPlayer != null)
        {
            mediaPlayer.stop();
        }
    }
    public void destroyPlayer(){
        if(mediaPlayer != null){
            mediaPlayer.release();;
            mediaPlayer = null;
        }
    }
    public  void  show(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}