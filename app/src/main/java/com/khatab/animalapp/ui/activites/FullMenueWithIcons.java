package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.khatab.animalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FullMenueWithIcons extends AppCompatActivity {

    VideoView simpleVideoView;
    MediaController mediaControls;
    private static final String VIDEO_SAMPLE = "tacoma_narrows";

    boolean pausing = false;
    @BindView(R.id.Main_Menue_Icon_IV)
    ImageView MainMenueIconIV;
    @BindView(R.id.MainIcons_CallUs_IV)
    ImageView MainIconsCallUsIV;
    @BindView(R.id.KnewUs_IV_Icon)
    ImageView KnewUsIVIcon;
    @BindView(R.id.shape1)
    LinearLayout shape1;
    @BindView(R.id.DialogIcon_IV)
    ImageView DialogIconIV;
    @BindView(R.id.OurWayStyle_IV_Icon)
    ImageView OurWayStyleIVIcon;
    @BindView(R.id.shape2)
    LinearLayout shape2;
    @BindView(R.id.Servies_Icon_IV)
    ImageView ServiesIconIV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_menue_with_icons);
        ButterKnife.bind(this);


        final ImageView zoom1 = (ImageView) findViewById(R.id.Main_Menue_Icon_IV);
        final Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
        zoom1.startAnimation(zoomAnimation);

        final ImageView zoom2 = (ImageView) findViewById(R.id.MainIcons_CallUs_IV);
        final Animation zoomAnimation2 = AnimationUtils.loadAnimation(this, R.anim.zoom);
        zoom2.startAnimation(zoomAnimation);

        final ImageView zoom3 = (ImageView) findViewById(R.id.DialogIcon_IV);
        final Animation zoomAnimation3 = AnimationUtils.loadAnimation(this, R.anim.zoom);
        zoom3.startAnimation(zoomAnimation);

        final ImageView zoom4 = (ImageView) findViewById(R.id.OurWayStyle_IV_Icon);
        final Animation zoomAnimation4 = AnimationUtils.loadAnimation(this, R.anim.zoom);
        zoom4.startAnimation(zoomAnimation);

        final ImageView zoom5 = (ImageView) findViewById(R.id.Servies_Icon_IV);
        final Animation zoomAnimation5 = AnimationUtils.loadAnimation(this, R.anim.zoom);
        zoom5.startAnimation(zoomAnimation);

        final ImageView zoom6 = (ImageView) findViewById(R.id.KnewUs_IV_Icon);
        final Animation zoomAnimation6 = AnimationUtils.loadAnimation(this, R.anim.zoom);
        zoom6.startAnimation(zoomAnimation);


        simpleVideoView = (VideoView) findViewById(R.id.main_Vedio);


        if (mediaControls == null) {
            // create an object of media controller class
            mediaControls = new MediaController(FullMenueWithIcons.this);
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
                Toast.makeText(getApplicationContext(), "أهلا بكم في :غنى الشام:", Toast.LENGTH_LONG).show();
            }
        });
        simpleVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), "Oops An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show();

                return false;

            }
        });

    }

    @OnClick({R.id.Main_Menue_Icon_IV, R.id.MainIcons_CallUs_IV, R.id.KnewUs_IV_Icon, R.id.shape1, R.id.DialogIcon_IV, R.id.OurWayStyle_IV_Icon, R.id.Servies_Icon_IV})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Main_Menue_Icon_IV:
                Intent intent1 = new Intent(FullMenueWithIcons.this, MainMenueActivity.class);
                startActivity(intent1);
                break;

            case R.id.MainIcons_CallUs_IV:
                Intent intent2 = new Intent(FullMenueWithIcons.this, ConnectUsActivity.class);
                startActivity(intent2);
                break;

            case R.id.KnewUs_IV_Icon:
                Intent intent3 = new Intent(FullMenueWithIcons.this, KnewUsActivity.class);
                startActivity(intent3);
                break;
            case R.id.shape1:
                break;
            case R.id.DialogIcon_IV:
                break;
            case R.id.OurWayStyle_IV_Icon:
                Intent intent4 = new Intent(FullMenueWithIcons.this, OurWayStyleActivity.class);
                startActivity(intent4);

                break;
            case R.id.Servies_Icon_IV:
                Intent intent5 = new Intent(FullMenueWithIcons.this, ServicesActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
