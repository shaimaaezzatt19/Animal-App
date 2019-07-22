package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.khatab.animalapp.R;
import com.khatab.animalapp.adapter.ServicesAdapter;
import com.khatab.animalapp.data.model.CancleOrder.CancleOrder;
import com.khatab.animalapp.data.rest.ApiServices;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.khatab.animalapp.data.rest.RetrofitGeneral.getClient;

public class CartAfterOrderingActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 60000;
    private final int splash_Display_Length = 66000;


    public int counter;
    TextView textView;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;
    private Button CancleButton;


    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private long mEndTime;


    private ApiServices apiServices;
    private static final String TAG = CartAfterOrderingActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cart_after_ordering );


        apiServices = getClient().create( ApiServices.class );

        Intent i = getIntent();
        if (i != null && i.hasExtra( "id" )) {
            final Long id = i.getExtras().getLong( "id" );
//            Integer id = i.getExtras().getInt( "id" );
            MakeCancleorder( id );


            CancleButton = (Button) findViewById( R.id.CardCancleOrder );
            CancleButton.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    MakeCancleorder( id );

                }
            } );

            textView = (TextView) findViewById( R.id.Card_Timer_Image );

            textView.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    new CountDownTimer( 30000, 1000 ) {
                        public void onTick(long millisUntilFinished) {
                            textView.setText( String.valueOf( counter ) );
                            counter++;
                        }

                        public void onFinish() {
                            textView.setText( "انتهى الوقت لايمكنك الغاء الطلب" );
                        }
                    }.start();

                    new Handler().postDelayed( new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent( CartAfterOrderingActivity.this, ExampleCardViewActivity.class );
                            CartAfterOrderingActivity.this.startActivity( intent );
                            CartAfterOrderingActivity.this.finish();
                        }
                    }, splash_Display_Length );
                }

            } );

        }
    }

    private void MakeCancleorder(Long id) {
        apiServices.MakeCancle( id ).enqueue( new Callback<CancleOrder>() {
            @Override
            public void onResponse(Call<CancleOrder> call, Response<CancleOrder> response) {

            }

            @Override
            public void onFailure(Call<CancleOrder> call, Throwable t) {

            }
        } );

    }
}



