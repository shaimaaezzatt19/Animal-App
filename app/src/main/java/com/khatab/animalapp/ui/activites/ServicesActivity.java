package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.khatab.animalapp.R;
import com.khatab.animalapp.adapter.ServicesPicAnimalNameAdapter;
import com.khatab.animalapp.data.model.Services.Datum;
import com.khatab.animalapp.data.model.Services.Services;
import com.khatab.animalapp.data.model.contact.Contact;
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
import static java.security.AccessController.getContext;

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
    private static final String TAG = ConnectUsActivity.class.getSimpleName();
    private List<Services> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_services );

        ButterKnife.bind( this );
        apiServices = getClient().create( ApiServices.class );

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
                    Boolean data = response.body().getStatus();
                    items.addAll( data );
                    ServicesRV.setAdapter( new ServicesPicAnimalNameAdapter
                            ( items, ServicesActivity.this ) );

                }
            }

            @Override
            public void onFailure(Call<Services> call, Throwable t) {
                Log.v( TAG, "Onfalliuer:error " + t.getMessage() );

            }
        } );
    }
}

