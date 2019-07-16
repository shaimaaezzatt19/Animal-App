package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.khatab.animalapp.R;
import com.khatab.animalapp.adapter.ServicesAdapter;
import com.khatab.animalapp.data.model.Services.Services;
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

public class ServicesActivity extends AppCompatActivity {
    @BindView(R.id.OurServices_Title)
    TextView OurServicesTitle;
    @BindView(R.id.Toolbar_services)
    ConstraintLayout ToolbarServices;
    @BindView(R.id.Services_RV)
    RecyclerView ServicesRV;
    @BindView(R.id.Services_IV_back)
    ImageView ServicesIVBack;

    private ApiServices apiServices;
    private static final String TAG = ServicesActivity.class.getSimpleName();
    private List<ServicesData> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_services );

        ButterKnife.bind( this );

        apiServices = getClient().create( ApiServices.class );
        ServicesRV.setLayoutManager( new LinearLayoutManager( ServicesActivity.this ) );
        ServicesRV.setHasFixedSize( true );

        apiServices.getservices().enqueue( new Callback<Services>() {

            @Override
            public void onResponse(Call<Services> call, Response<Services> response) {

                Log.v( TAG, "onResponse: response body: " + response.body().toString() );
                if (response.isSuccessful()) {
                    Boolean status = response.body().getStatus();
                    Log.v( "ServiceActivity: ", "status:" + status );
                    if (status) {
                        Log.e( "hhh", "done" );

                        ServicesRV.setAdapter( new ServicesAdapter( ServicesActivity.this,
                                response.body().getData() ) );


                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<Services> call, Throwable t) {
                Log.e( TAG, " onFailure: error:" + t.getLocalizedMessage() );

            }
        } );

    }

    @OnClick(R.id.Services_IV_back)
    public void onViewClicked() {
        Intent intentback = new Intent( ServicesActivity.this, FullMenueWithIcons.class );
        startActivity( intentback );
    }

    public void SeeMyServices() {
        apiServices.getservices().enqueue( new Callback<Services>() {
            @Override
            public void onResponse(Call<Services> call, Response<Services> response) {
                if (response.isSuccessful()) {
                    Boolean status = response.body().getStatus();
                    Log.e( "nnn", "false" );
                    if (status) {
                        Log.e( "hhh", "done" );

                        ServicesRV.setAdapter( new ServicesAdapter( ServicesActivity.this, response.body().getData() ) );
                    } else {
                    }
                }
            }

            @Override
            public void onFailure(Call<Services> call, Throwable t) {
                Log.v( TAG, "Onfalliuer:error " + t.getMessage() );

            }
        } );
    }

    @OnClick({R.id.OurServices_Title, R.id.Toolbar_services, R.id.Services_RV, R.id.Services_IV_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.OurServices_Title:
                break;
            case R.id.Toolbar_services:
                break;
            case R.id.Services_RV:

                Intent intent = new Intent( ServicesActivity.this, AskTypeOfOrederActivity.class );
                startActivity( intent );


                break;
            case R.id.Services_IV_back:

                Intent intentBack = new Intent( ServicesActivity.this, AskTypeOfOrederActivity.class );
                startActivity( intentBack );
                break;
        }
    }
}

