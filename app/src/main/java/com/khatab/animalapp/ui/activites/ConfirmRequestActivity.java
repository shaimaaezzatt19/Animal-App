package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.khatab.animalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmRequestActivity extends AppCompatActivity {


    EditText editText;

    TextInputEditText textInputEditText;

    @BindView(R.id.CofirmOrder_Title)
    TextView CofirmOrderTitle;
    @BindView(R.id.ConfirmRequest_TV_Name)
    TextView ConfirmRequestTVName;
    @BindView(R.id.ConfirmRequest_ET_Name)
    TextInputEditText ConfirmRequestETName;
    @BindView(R.id.ConfirmRequest_TV_phone)
    TextView ConfirmRequestTVPhone;
    @BindView(R.id.ConfirmRequest_ET_phone)
    TextInputEditText ConfirmRequestETPhone;
    @BindView(R.id.ConfirmRequest_TV_Address)
    TextView ConfirmRequestTVAddress;
    @BindView(R.id.ConfirmRequest_ET_Address)
    TextInputEditText ConfirmRequestETAddress;
    @BindView(R.id.Confirm_Code_Order_BT)
    Button ConfirmCodeOrderBT;
    @BindView(R.id.LL1_ConfirmRequest)
    LinearLayout LL1ConfirmRequest;
    @BindView(R.id.ConfirmCode_Back_IB)
    ImageView ConfirmCodeBackIB;
    @BindView(R.id.ConfirmCode_Menue_IB)
    ImageView ConfirmCodeMenueIB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_confirm_request );


        TextInputEditText Name = (TextInputEditText) findViewById( R.id.ConfirmRequest_ET_Name );
        String EnterName = Name.getText().toString();


        TextInputEditText Phone = (TextInputEditText) findViewById( R.id.ConfirmRequest_ET_phone );
        String EnterPhone = Phone.getText().toString();


        TextInputEditText Location = (TextInputEditText) findViewById( R.id.ConfirmRequest_ET_Address );
        String EnterLocation = Location.getText().toString();


        ButterKnife.bind( this );
    }

    @OnClick(R.id.Confirm_Code_Order_BT)
    public void onViewClicked() {

        Intent i = new Intent( ConfirmRequestActivity.this, ConfirmCodeActivity.class );
        startActivity( i );
    }

    @OnClick({R.id.ConfirmCode_Back_IB, R.id.ConfirmCode_Menue_IB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ConfirmCode_Back_IB:

                Intent backIntent = new Intent( ConfirmRequestActivity.this, ServicesActivity.class );
                startActivity( backIntent );
                break;
            case R.id.ConfirmCode_Menue_IB:

                Intent menueintent = new Intent( ConfirmRequestActivity.this, FullMenueWithIcons.class );
                startActivity( menueintent );
                break;
        }
    }

}
