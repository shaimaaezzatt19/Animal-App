package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.khatab.animalapp.R;
import com.khatab.animalapp.data.model.ShowProducts.ShowProducts;
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

public class OptionSelectedDeatailsActivity extends AppCompatActivity {

    @BindView(R.id.Service_Deatils_Selected_Toolbar_title_TV)
    TextView ServiceDeatilsSelectedToolbarTitleTV;
    @BindView(R.id.Pic_Selected_Service_IV)
    ImageView PicSelectedServiceIV;
    @BindView(R.id.Option_Selected_Show_Deatils_TV)
    TextView OptionSelectedShowDeatilsTV;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.Service_Selected_Order_BT)
    Button ServiceSelectedOrderBT;
    @BindView(R.id.LL1_Item_Selected)
    LinearLayout LL1ItemSelected;
    @BindView(R.id.Selected_item_Back_IB)
    ImageView SelectedItemBackIB;

    private ApiServices apiServices;
    private static final String TAG = OptionSelectedDeatailsActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_option_selected_deatails );

        ButterKnife.bind( this );
        apiServices = getClient().create( ApiServices.class );

        Intent i = getIntent();
        if (i != null && i.hasExtra( "id" )) {
            Long id = i.getExtras().getLong( "id" );
//            Integer id = i.getExtras().getInt( "id" );
            ProductsDeatils( id );

        }


    }

    @OnClick({R.id.Service_Selected_Order_BT, R.id.Selected_item_Back_IB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Service_Selected_Order_BT:
                Intent intent1 = new Intent( OptionSelectedDeatailsActivity.this, AskTypeOfOrederActivity.class );
                startActivity( intent1 );
                break;

            case R.id.Selected_item_Back_IB:
                Intent intent2 = new Intent( OptionSelectedDeatailsActivity.this, ServicesActivity.class );
                startActivity( intent2 );
                break;
        }
    }

    public void ProductsDeatils(Long id) {
        apiServices.getProductsDeatils( id ).enqueue( new Callback<ShowProducts>() {
            @Override
            public void onResponse(Call<ShowProducts> call, Response<ShowProducts> response) {
                if (response.isSuccessful()) {
                    Boolean status = response.body().getStatus();
                    if (status) {

                        List<ShowProductsData> data = response.body().getData();

                        ServiceDeatilsSelectedToolbarTitleTV.setText( data.get( 0 ).getName() );
                        OptionSelectedShowDeatilsTV.setText( data.get( 0 ).getDescription() );
                        textView8.setText( data.get( 0 ).getPrice().toString() );

                        Glide.with( OptionSelectedDeatailsActivity.this ).load( data.get( 0 ).getImage() ).into( PicSelectedServiceIV );

                        Log.i( "hhh", "done stauts true" );

                    } else {
                        Log.i( "hhh", "staus false" );
                    }
                } else {
                    Log.i( "hhh", "onResponse: response ok but fail" );
                }
            }

            @Override
            public void onFailure(Call<ShowProducts> call, Throwable t) {
                Log.i( "hhh", "Onfalliuer : error " + t.getMessage() );

            }
        } );
    }
}