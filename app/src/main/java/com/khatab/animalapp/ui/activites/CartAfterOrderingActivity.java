package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.khatab.animalapp.R;

public class CartAfterOrderingActivity extends AppCompatActivity {


    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_after_ordering);




        textView = (TextView) findViewById(R.id.Card_Timer_Image);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ExampleCardViewActivity.class);
                startActivity(i);

            }
        });


        button = (Button) findViewById(R.id.CardCancleOrder);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i2 = new Intent(getApplicationContext(), MainMenueActivity.class);
                startActivity(i2);
            }
        });

    }
}

