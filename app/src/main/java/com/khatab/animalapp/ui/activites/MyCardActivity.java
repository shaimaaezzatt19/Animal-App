package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.khatab.animalapp.R;
import com.khatab.animalapp.adapter.MyCardAdapter;
import com.khatab.animalapp.adapter.ServicesAdapter;
import com.khatab.animalapp.data.model.SaveOrder.SaveOrder;
import com.khatab.animalapp.data.model.Services.ServicesData;
import com.khatab.animalapp.data.rest.ApiServices;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.khatab.animalapp.data.rest.RetrofitGeneral.getClient;

public class MyCardActivity extends AppCompatActivity {
    @BindView(R.id.Card_Title)
    TextView CardTitle;
    @BindView(R.id.RV1)
    RecyclerView RV1;
    @BindView(R.id.Card_TotalPrice)
    TextView CardTotalPrice;
    @BindView(R.id.MYCard_confirmBuying_BT)
    Button MYCardConfirmBuyingBT;
    @BindView(R.id.MYCard_Back_IB)
    ImageView MYCardBackIB;


    private ApiServices apiServices;
    private static final String TAG = MyCardActivity.class.getSimpleName();
    private List<SaveOrder> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_my_card );


        ButterKnife.bind( this );

        apiServices = getClient().create( ApiServices.class );
        RV1.setLayoutManager( new LinearLayoutManager( MyCardActivity.this ) );
        RV1.setHasFixedSize( true );

        apiServices.SendAllDetailsToSaveOrder( "", "",
                "", "", "",
                "", "", "",
                "", "", "", "" )
                .enqueue( new Callback<SaveOrder>() {
                    @Override
                    public void onResponse(Call<SaveOrder> call, Response<SaveOrder> response) {

                        Log.v( TAG, "onResponse: response body: " + response.body().toString() );
                        if (response.isSuccessful()) {
                            Boolean status = response.body().getStatus();
                            Log.v( "ServiceActivity: ", "status:" + status );
                            if (status) {
                                Log.e( "hhh", "done" );

                                RV1.setAdapter( new MyCardAdapter( response.body().getData(), MyCardActivity.this ) );


                            } else {

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<SaveOrder> call, Throwable t) {
                        Log.e( TAG, " onFailure: error:" + t.getLocalizedMessage() );

                    }
                } );
    }

    @OnClick({R.id.MYCard_confirmBuying_BT, R.id.MYCard_Back_IB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.MYCard_confirmBuying_BT:
                Intent intent1 = new Intent( MyCardActivity.this, ConfirmRequestActivity.class );
                startActivity( intent1 );
                break;

            case R.id.MYCard_Back_IB:
                Intent intent2 = new Intent( MyCardActivity.this, SendOrderActivity.class );
                startActivity( intent2 );
                break;
        }
    }
}
