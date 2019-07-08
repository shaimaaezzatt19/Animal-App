package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.khatab.animalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainMenueActivity extends AppCompatActivity {
    VideoView simpleVideoView;
    MediaController mediaControls;
    boolean pausing = false;
    @BindView(R.id.Main_MenuE_munueIcon_IV)
    ImageView MainMenuEMunueIconIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menue);
        ButterKnife.bind(this);


        simpleVideoView = (VideoView) findViewById(R.id.main_Vedio);


        if (mediaControls == null) {
            // create an object of media controller class
            mediaControls = new MediaController(MainMenueActivity.this);
            mediaControls.setAnchorView(simpleVideoView);
        }
        // set the media controller for video view
        simpleVideoView.setMediaController(mediaControls);
        // set the uri for the video view
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vediozoom));
        // start a video
        simpleVideoView.start();

        // implement on completion listener on video view
        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(), "أهلا بكم في :غنى الشام:", Toast.LENGTH_LONG).show(); // display a toast when an video is completed
            }
        });
        simpleVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), "Oops An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;

            }
        });

    }

    @OnClick(R.id.Main_MenuE_munueIcon_IV)
    public void onViewClicked() {
        Intent i = new Intent(MainMenueActivity.this, FullMenueWithIcons.class);
        startActivity(i);
    }
}


