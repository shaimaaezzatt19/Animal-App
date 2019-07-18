package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.khatab.animalapp.R;
import com.khatab.animalapp.data.model.Code.Code;
import com.khatab.animalapp.data.rest.ApiServices;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.khatab.animalapp.data.rest.RetrofitGeneral.getClient;

public class ConfirmCodeActivity extends AppCompatActivity {


    @BindView(R.id.CofirmOrder_Title)
    TextView CofirmOrderTitle;
    @BindView(R.id.CodeNumber1)
    EditText CodeNumber1;
    @BindView(R.id.CodeNumber2)
    EditText CodeNumber2;
    @BindView(R.id.CodeNumber3)
    EditText CodeNumber3;
    @BindView(R.id.CodeNumber4)
    EditText CodeNumber4;
    @BindView(R.id.LL1_Code)
    LinearLayout LL1Code;
    @BindView(R.id.SendConfirmCode_BT)
    Button SendConfirmCodeBT;
    @BindView(R.id.ConfirmCode_Back_IB)
    ImageView ConfirmCodeBackIB;
    @BindView(R.id.ConfirmCode_Menue_IB)
    ImageView ConfirmCodeMenueIB;

    private ApiServices apiServices;
    private static final String TAG = ConfirmCodeActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_confirm_code );
        ButterKnife.bind( this );

        apiServices = getClient().create( ApiServices.class );

    }

    public void ConfirmCode() {
        apiServices.getCode().enqueue( new Callback<Code>() {
            @Override
            public void onResponse(Call<Code> call, Response<Code> response) {

                Log.v( TAG, "onResponse: response body: " + response.body().toString() );
                if (response.isSuccessful()) {
                    Boolean status = response.body().getStatus();
                    Log.v( "ServiceActivity: ", "status:" + status );
                    if (status) {
                        Log.e( "hhh", "done" );

                        response.body().getData();


                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<Code> call, Throwable t) {

                Log.e( TAG, " onFailure: error:" + t.getLocalizedMessage() );

            }
        } );
    }

    @OnClick({R.id.SendConfirmCode_BT, R.id.ConfirmCode_Back_IB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.SendConfirmCode_BT:
                Intent intent1 = new Intent( ConfirmCodeActivity.this, CartAfterOrderingActivity.class );
                startActivity( intent1 );
                break;

            case R.id.ConfirmCode_Back_IB:
                Intent intent2 = new Intent( ConfirmCodeActivity.this, ConfirmRequestActivity.class );
                startActivity( intent2 );
                break;
        }
    }

    @OnClick(R.id.ConfirmCode_Menue_IB)
    public void onViewClicked() {

        Intent menueintent = new Intent( ConfirmCodeActivity.this, FullMenueWithIcons.class );
        startActivity( menueintent );
    }
}
