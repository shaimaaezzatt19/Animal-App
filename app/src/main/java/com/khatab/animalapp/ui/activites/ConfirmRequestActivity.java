package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.khatab.animalapp.R;
import com.khatab.animalapp.data.model.SaveOrder.SaveOrder;
import com.khatab.animalapp.data.model.ShowProducts.ShowProductsData;
import com.khatab.animalapp.data.rest.ApiServices;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.khatab.animalapp.data.rest.RetrofitGeneral.getClient;

public class ConfirmRequestActivity extends AppCompatActivity {


    @BindView(R.id.CofirmOrder_Title)
    TextView CofirmOrderTitle;
    @BindView(R.id.ConfirmCode_Back_IB)
    ImageView ConfirmCodeBackIB;
    @BindView(R.id.ConfirmCode_Menue_IB)
    ImageView ConfirmCodeMenueIB;
    @BindView(R.id.Confirm_Request_phone_TI)
    TextInputLayout ConfirmRequestPhoneTI;
    @BindView(R.id.Confirm_Request_Name_TI)
    TextInputLayout ConfirmRequestNameTI;
    @BindView(R.id.Confirm_Request_Address_TI)
    TextInputLayout ConfirmRequestAddressTI;
    private List<SaveOrder> data;


    private ApiServices apiServices;
    private static final String TAG = ConfirmRequestActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_confirm_request );
        ButterKnife.bind( this );
        apiServices = getClient().create( ApiServices.class );

    }

    @OnClick({R.id.Confirm_Request_Btn_Buy_TI, R.id.ConfirmCode_Back_IB, R.id.ConfirmCode_Menue_IB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Confirm_Request_Btn_Buy_TI:
                confirmRequest();
                Intent intent = new Intent( ConfirmRequestActivity.this, ConfirmCodeActivity.class );
                intent.putExtra( "id", data.get( 0 ).getData() );
                startActivity( intent );

                break;
            case R.id.ConfirmCode_Back_IB:
                Intent i = new Intent( ConfirmRequestActivity.this, ServicesActivity.class );
                startActivity( i );
                break;
            case R.id.ConfirmCode_Menue_IB:
                Intent menueintent = new Intent( ConfirmRequestActivity.this, FullMenueWithIcons.class );
                startActivity( menueintent );
                break;
        }
    }


    //صفحه send order  فوق أهي
    //لما أختار منها كل حاجة
    // هدخل بياناتي علشان يجيلي كود تأكيد
    //وبعد كود التأكيد هيجلي timer يعد تنازلي لمدة دقيقة
    //لو ملغتش الطلب ف الدقيقة
    //الطلب هيتنفذ ويظهر
    // تمام ؟


    public void confirmRequest() {

        String phone = ConfirmRequestPhoneTI.getEditText().getText().toString();
        String name = ConfirmRequestNameTI.getEditText().getText().toString();
        String address = ConfirmRequestAddressTI.getEditText().getText().toString();

        apiServices.SendAllDetailsToSaveOrder( phone, address,
                name, "", "", ""
                , "", "", "", "", "", "" ).enqueue( new Callback<SaveOrder>() {
            @Override
            public void onResponse(Call<SaveOrder> call, Response<SaveOrder> response) {

                if (response.isSuccessful()) {
                    Boolean status = response.body().getStatus();
                    if (status) {

                    }
                }
            }

            @Override
            public void onFailure(Call<SaveOrder> call, Throwable t) {

            }
        } );
    }

}
