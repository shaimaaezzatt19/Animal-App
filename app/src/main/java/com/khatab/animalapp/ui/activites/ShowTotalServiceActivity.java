package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.khatab.animalapp.R;
import com.khatab.animalapp.data.model.ShowProducts.ShowProducts;
import com.khatab.animalapp.data.rest.ApiServices;

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
    @BindView(R.id.ShowService_NameOnImage_TV)
    TextView ShowServiceNameOnImageTV;
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

    }

    public void ShowProductsDeatils(Long id) {
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
}
