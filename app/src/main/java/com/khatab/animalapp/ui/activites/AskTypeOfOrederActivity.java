package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.khatab.animalapp.R;
import com.khatab.animalapp.data.model.ShowService.ShowService;
import com.khatab.animalapp.data.model.ShowService.ShowServiceData;
import com.khatab.animalapp.data.rest.ApiServices;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.khatab.animalapp.data.rest.RetrofitGeneral.getClient;

public class AskTypeOfOrederActivity extends AppCompatActivity {


    @BindView(R.id.Service_Selected_Toolbar_title_TV)
    TextView ServiceSelectedToolbarTitleTV;
    @BindView(R.id.Pic_Selected_Service_IV)
    ImageView PicSelectedServiceIV;
    @BindView(R.id.SendOrder_Option1_BT)
    Button SendOrderOption1BT;
    @BindView(R.id.SendOrder_Option2_BT)
    Button SendOrderOption2BT;
    @BindView(R.id.SendOrder_Option3_BT)
    Button SendOrderOption3BT;
    @BindView(R.id.LL1_Item_Selected)
    LinearLayout LL1ItemSelected;
    @BindView(R.id.SendOrder_item_Back_IB)
    ImageView SendOrderItemBackIB;
    @BindView(R.id.AskTypeOfOrder_MenueIcon_IV)
    ImageView AskTypeOfOrderMenueIconIV;

    private ApiServices apiServices;
    private static final String TAG = AskTypeOfOrederActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_ask_type_of_oreder );
        ButterKnife.bind( this );
        apiServices = getClient().create( ApiServices.class );

        Intent i = getIntent();
        if (i != null && i.hasExtra( "id" )) {
            Long id = i.getExtras().getLong( "id" );
//            Integer id = i.getExtras().getInt( "id" );
            ShowServiceName( id );

        }
    }

    public void ShowServiceName(Long id) {
        apiServices.getservicesDeatils( id ).enqueue( new Callback<ShowService>() {
            @Override
            public void onResponse(Call<ShowService> call, Response<ShowService> response) {
                if (response.isSuccessful()) {
                    Boolean status = response.body().getStatus();
                    if (status) {

                        List<ShowServiceData> data = response.body().getData();

                        ServiceSelectedToolbarTitleTV.setText( data.get( 0 ).getName() );
//                        PicSelectedServiceIV.setImageResource( data.get( 0 ).getImage() );
                        Glide.with( AskTypeOfOrederActivity.this ).load( data.get( 0 ).getImage() ).into( PicSelectedServiceIV );
//                        SendOrderOption1BT.setText( data.get(0).get );
//                        SendOrderOption2BT.setText( data.get( 0 ).getName() );


                        SendOrderOption1BT.setText( data.get( 0 ).getName() );
                        SendOrderOption2BT.setText( data.get( 0 ).getName() );
                        SendOrderOption3BT.setText( data.get( 0 ).getName() );


                        Log.i( "hhh", "done stauts true" );

                    } else {
                        Log.i( "hhh", "staus false" );
                    }
                } else {
                    Log.i( "hhh", "onResponse: response ok but fail" );
                }
            }

            @Override
            public void onFailure(Call<ShowService> call, Throwable t) {
                Log.i( "hhh", "Onfalliuer : error " + t.getMessage() );
            }
        } );
    }
//    public void ShowServiceName(Long id) {
//        // المفروض هنا أحط ال id بتاع الخدمة اللي اختارتها من ال Services
//        apiServices.getservicesDeatils( id ).enqueue( new Callback<ShowService>() {
//            @Override
//            public void onResponse(Call<ShowService> call, Response<ShowService> response) {
//
//                if (response.isSuccessful())
//                {
//                    Boolean status = response.body().getStatus();
////                    Log.e( "nnn", "false" );
//                    if (status)
//                    {
//                        List<ShowServiceData> data = response.body().getData();
//                        ServiceSelectedToolbarTitleTV.setText( data.get( 1 ).getName() );
////                        PicSelectedServiceIV.setImageResource(  );
//
//                        Log.i( "hhh", "done stauts true" );
//
//                    } else
//                    {
//                        Log.i( "hhh", "staus false" );
//                    }
//                }else {
//                    Log.i( "hhh", "onResponse: response ok but fail" );
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ShowService> call, Throwable t)
//            {
//                Log.i( "hhh", "Onfalliuer : error " + t.getMessage() );
//
//            }
//        } );
//
//    }

    @OnClick({R.id.SendOrder_Option1_BT, R.id.SendOrder_Option2_BT, R.id.SendOrder_Option3_BT, R.id.SendOrder_item_Back_IB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.SendOrder_Option1_BT:
                Intent intent1 = new Intent( AskTypeOfOrederActivity.this, SendOrderActivity.class );
                startActivity( intent1 );

                break;
            case R.id.SendOrder_Option2_BT:
                Intent intent2 = new Intent( AskTypeOfOrederActivity.this, SendOrderActivity.class );
                startActivity( intent2 );

                break;
            case R.id.SendOrder_Option3_BT:
                Intent intent3 = new Intent( AskTypeOfOrederActivity.this, ShowTotalServiceActivity.class );
                startActivity( intent3 );

                break;
            case R.id.SendOrder_item_Back_IB:

                Intent back = new Intent( AskTypeOfOrederActivity.this, ServicesActivity.class );
                startActivity( back );

                break;
        }
    }

    @OnClick(R.id.AskTypeOfOrder_MenueIcon_IV)
    public void onViewClicked() {

        Intent menueIntent = new Intent( AskTypeOfOrederActivity.this, FullMenueWithIcons.class );
        startActivity( menueIntent );
    }
}
