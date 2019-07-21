package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.drm.ProcessedData;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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

public class ShowTotalServiceActivity extends AppCompatActivity {
    @BindView(R.id.SendMyOrder_Title)
    TextView SendMyOrderTitle;
    @BindView(R.id.Constrain)
    ConstraintLayout Constrain;
    @BindView(R.id.ImageService_IV)
    ImageView ImageServiceIV;
    @BindView(R.id.ShowService_ServiceNotes_TV)
    TextView ShowServiceServiceNotesTV;
    @BindView(R.id.ShowTotsalServices_1_TV)
    TextView ShowTotsalServices1TV;
    @BindView(R.id.ShowTotsalServices_2_TV)
    TextView ShowTotsalServices2TV;
    @BindView(R.id.ShowTotsalServices_3_TV)
    TextView ShowTotsalServices3TV;
    @BindView(R.id.ShowTotalServices_BT_Requset)
    Button ShowTotalServicesBTRequset;
    @BindView(R.id.RL_ShowTotalServices)
    RelativeLayout RLShowTotalServices;

    private ApiServices apiServices;
    private static final String TAG = ShowTotalServiceActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_show_total_service );
        ButterKnife.bind( this );

        apiServices = getClient().create( ApiServices.class );
        Intent i = getIntent();
        if (i != null && i.hasExtra( "id" )) {
            Long id = i.getExtras().getLong( "id" );
            Log.i( "hhh2", "id value from intent : "+id );
            ProductsAllDeatils( id );
        }

    }

    public void ShowProductsDeatils(Long id)
    {
        apiServices.getProductsDeatils( id ).enqueue( new Callback<ShowProducts>() {
            @Override
            public void onResponse(Call<ShowProducts> call, Response<ShowProducts> response) {

                if (response.isSuccessful()) {
                    Boolean status = response.body().getStatus();
                    Log.e( "nnn", "false" );
                    if (status) {
                        Log.e( "hhh", "done" );

                    } else {
                    }
                }
            }

            @Override
            public void onFailure(Call<ShowProducts> call, Throwable t) {
                Log.v( TAG, "Onfalliuer:error " + t.getMessage() );

            }
        } );
    }

    @OnClick(R.id.ShowTotalServices_BT_Requset)
    public void onViewClicked() {
        Intent intent = new Intent( ShowTotalServiceActivity.this, SendTotalOrderActivity.class );
        startActivity( intent );
    }

    public void ProductsAllDeatils(Long id) {
        apiServices.getProductsDeatils( id ).enqueue( new Callback<ShowProducts>() {
            @Override
            public void onResponse(Call<ShowProducts> call, Response<ShowProducts> response) {
                if (response.isSuccessful()) {
                    Boolean status = response.body().getStatus();
                    if (status) {

                        Log.i( "hhh2", "done stauts true" );

                        List<ShowProductsData> data = response.body().getData();
                        SendMyOrderTitle.setText( data.get( 0 ).getName() );
                        ShowServiceServiceNotesTV.setText( data.get( 0 ).getDescription() );
                        ShowTotsalServices1TV.setText( ": صغير "+data.get( 0 ).getPrice().toString() );
                        ShowTotsalServices2TV.setText( ": متوسط "+data.get( 0 ).getPrice().toString() );
                        ShowTotsalServices3TV.setText( ": كبير "+data.get( 0 ).getPrice().toString() );
                        Glide.with( ShowTotalServiceActivity.this ).load( data.get( 0 ).getImage() ).into( ImageServiceIV );
                    } else {
                        Log.i( "hhh2", "staus false" );
                    }
                } else {
                    Log.i( "hhh2", "onResponse: response ok but fail" );
                }
            }

            @Override
            public void onFailure(Call<ShowProducts> call, Throwable t) {
                Log.i( "hhh2", "Onfalliuer : error " + t.getMessage() );

            }
        } );
    }
}
