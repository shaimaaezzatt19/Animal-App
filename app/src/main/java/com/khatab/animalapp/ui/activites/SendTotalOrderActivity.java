package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.khatab.animalapp.R;
import com.khatab.animalapp.data.model.SaveOrder.SaveOrder;
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
import static com.khatab.animalapp.helper.HelperMethod.getTextFromSpinner;

public class SendTotalOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.odderTotalService_TV_toolbarTitle)
    TextView odderTotalServiceTVToolbarTitle;
    @BindView(R.id.Pic_Selected_Service_IV)
    ImageView PicSelectedServiceIV;
    @BindView(R.id.Option_Selected_Show_Deatils_TV)
    TextView OptionSelectedShowDeatilsTV;
    @BindView(R.id.textView9)
    TextView textView9;
    @BindView(R.id.textView10)
    TextView textView10;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.Count_SendAllOrder_TV)
    EditText CountSendAllOrderTV;
    @BindView(R.id.SpinnerOne)
    Spinner SpinnerOne;
    @BindView(R.id.SpinnerTWO)
    Spinner SpinnerTWO;
    @BindView(R.id.SpinnerThree)
    Spinner SpinnerThree;
    @BindView(R.id.Notes_TV)
    TextView NotesTV;
    @BindView(R.id.EnterNote)
    EditText EnterNote;
    @BindView(R.id.Total)
    TextView Total;
    @BindView(R.id.Selected_item_Back_IB)
    ImageView SelectedItemBackIB;

    private ApiServices apiServices;

    private static final String TAG = SendTotalOrderActivity.class.getSimpleName();
    private String name;
    private Long price;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_send_total_order );


        ButterKnife.bind( this );
        apiServices = getClient().create( ApiServices.class );
        setSpinnerView( SpinnerOne, R.array.Spinner1 );
        setSpinnerView( SpinnerTWO, R.array.Spinner2 );
        setSpinnerView( SpinnerThree, R.array.Spinner3 );

        Intent i = getIntent();
        if (i != null && i.hasExtra( "id" )) {
            id = i.getExtras().getLong( "id" );
            getProductDetails( id );

        }


    }

    public void getProductDetails(Long id)
    {
        apiServices.getProductsDeatils( id ).enqueue( new Callback<ShowProducts>() {
            @Override
            public void onResponse(Call<ShowProducts> call, Response<ShowProducts> response) {
                if (response.isSuccessful()) {
                    Boolean status = response.body().getStatus();
                    if (status) {
                        List<ShowProductsData> data = response.body().getData();
                        name = data.get( 0 ).getName();
                        price = data.get( 0 ).getPrice();

                        odderTotalServiceTVToolbarTitle.setText( name );
                        textView10.setText( price.toString() );
                        Glide.with( SendTotalOrderActivity.this ).load( data.get( 0 ).getImage() ).into( PicSelectedServiceIV );
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

    public void sendTotalorder()
    {
        String CountNumber = CountSendAllOrderTV.getText().toString();
        String EnterNotes = EnterNote.getText().toString();
        int sizePostion = getTextFromSpinner( SpinnerOne );
        int readyPostion = getTextFromSpinner( SpinnerTWO );
        int cutPostion = getTextFromSpinner( SpinnerThree );
"", "",
                ""
                apiServices.SendAllDetailsToSaveOrder( "",
                        "", name, CountNumber,
                        "", ""
                        ,
                        , "", "",
                "" ).enqueue( new Callback<SaveOrder>() {
            @Override
            public void onResponse(Call<SaveOrder> call, Response<SaveOrder> response) {
                if (response.isSuccessful()) {
                    Boolean status = response.body().getStatus();
                    if (status)
                    {

                    }
                }
            }
            @Override
            public void onFailure(Call<SaveOrder> call, Throwable t) {
                Log.i( "hhh", "Onfailure : " + t.getMessage() );
            }
        } );

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition( position ).toString();
        Toast.makeText( parent.getContext(), text, Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @OnClick(R.id.OrderTotalService_BT)
    public void onViewClicked()
    {
        sendTotalorder();
        Intent intent = new Intent( SendTotalOrderActivity.this, MyCardActivity.class );
        startActivity( intent );

    }


    private void setSpinnerView(Spinner spinner, int id) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this,
                id, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinner.setAdapter( adapter );
        spinner.setOnItemSelectedListener( this );
    }
}
