package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class SendTotalOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @BindView(R.id.odderTotalService_TV_toolbarTitle)
    TextView odderTotalServiceTVToolbarTitle;
    @BindView(R.id.Constrain)
    ConstraintLayout Constrain;
    @BindView(R.id.Pic_Selected_Service_IV)
    ImageView PicSelectedServiceIV;
    @BindView(R.id.Option_Selected_Show_Deatils_TV)
    TextView OptionSelectedShowDeatilsTV;
    @BindView(R.id.textView9)
    TextView textView9;
    @BindView(R.id.textView10)
    TextView textView10;
    @BindView(R.id.LL1_SendOrder)
    LinearLayout LL1SendOrder;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.Count_SendAllOrder_TV)
    EditText CountSendAllOrderTV;
    @BindView(R.id.SpinnerOne)
    Spinner SpinnerOne;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.SpinnerTWO)
    Spinner SpinnerTWO;
    @BindView(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @BindView(R.id.SpinnerThree)
    Spinner SpinnerThree;
    @BindView(R.id.relativeLayout3)
    RelativeLayout relativeLayout3;
    @BindView(R.id.Notes_TV)
    TextView NotesTV;
    @BindView(R.id.EnterNote)
    EditText EnterNote;
    @BindView(R.id.Total)
    TextView Total;
    @BindView(R.id.OrderTotalService_BT)
    Button OrderTotalServiceBT;
    @BindView(R.id.Constrain2)
    ConstraintLayout Constrain2;
    @BindView(R.id.Selected_item_Back_IB)
    ImageView SelectedItemBackIB;
    @BindView(R.id.scrollView2)
    ScrollView scrollView2;

    private ApiServices apiServices;
    private static final String TAG = SendTotalOrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_send_total_order );

        Spinner spinner1 = findViewById( R.id.SpinnerOne );
        Spinner spinner2 = findViewById( R.id.SpinnerTWO );
        Spinner spinner3 = findViewById( R.id.SpinnerThree );


        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource( this,
                R.array.Spinner1, android.R.layout.simple_spinner_item );
        adapter1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinner1.setAdapter( adapter1 );
        spinner1.setOnItemSelectedListener( this );


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource( this,
                R.array.Spinner2, android.R.layout.simple_spinner_item );
        adapter2.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinner2.setAdapter( adapter2 );
        spinner2.setOnItemSelectedListener( this );


        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource( this,
                R.array.Spinner3, android.R.layout.simple_spinner_item );
        adapter3.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinner3.setAdapter( adapter2 );
        spinner3.setOnItemSelectedListener( this );


        ButterKnife.bind( this );
        apiServices = getClient().create( ApiServices.class );
        Intent i = getIntent();
        if (i != null && i.hasExtra( "id" )) {
            Long id = i.getExtras().getLong( "id" );
//            Integer id = i.getExtras().getInt( "id" );
            SendTotalorder( id );

        }


        EditText Count = (EditText) findViewById( R.id.Count_SendAllOrder_TV );
        String CountNumber = Count.getText().toString();


        Spinner SpinnerOne = (Spinner) findViewById( R.id.SpinnerOne );
        String SpinnerOneDeatils = Count.getText().toString();

        Spinner SpinnerTwo = (Spinner) findViewById( R.id.SpinnerTWO );
        String SpinnerTWODeatils = Count.getText().toString();

        Spinner SpinnerThree = (Spinner) findViewById( R.id.SpinnerThree );
        String SpinnerThreeDeatils = Count.getText().toString();

        EditText Notes = (EditText) findViewById( R.id.EnterNote );
        String EnterNotes = Count.getText().toString();
    }

//         odderTotalServiceTVToolbarTitle.setText( data.get( 0 ).getName() );
//                        Glide.with( SendTotalOrderActivity.this ).load( data.get( 0 ).getImage() ).into( PicSelectedServiceIV );

    public void SendTotalorder(Long id) {
        apiServices.getProductsDeatils( id ).enqueue( new Callback<ShowProducts>() {
            @Override
            public void onResponse(Call<ShowProducts> call, Response<ShowProducts> response) {

                if (response.isSuccessful()) {
                    Boolean status = response.body().getStatus();
                    if (status) {
                        List<ShowProductsData> data = response.body().getData();

                        odderTotalServiceTVToolbarTitle.setText( data.get( 0 ).getName() );
                        textView10.setText( data.get( 0 ).getPrice().toString() );

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

    public void sendTotalorder() {

        String Count = CountSendAllOrderTV.getText().toString();
        String spinner1 = SpinnerOne.toString();
        String spinner2 = SpinnerTWO.toString();
        String spinner3 = SpinnerThree.toString();

        String notes = EnterNote.toString();

        apiServices.SendAllDetailsToSaveOrder( "",
                "", "", "", "", ""
                , "", "", ""
                , "", "", "" ).enqueue( new Callback<SaveOrder>() {
            @Override
            public void onResponse(Call<SaveOrder> call, Response<SaveOrder> response) {

                if (response.isSuccessful()) {
                    Boolean status = response.body().getStatus();
                    if (status) {

                        String Count = CountSendAllOrderTV.getText().toString();
                        String spinner1 = SpinnerOne.toString();
                        String spinner2 = SpinnerTWO.toString();
                        String spinner3 = SpinnerThree.toString();
                        String notes = EnterNote.toString();


                    }

                }
            }

            @Override
            public void onFailure(Call<SaveOrder> call, Throwable t) {
                Log.i( "hhh", "Onfalliuer : error " + t.getMessage() );


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
    public void onViewClicked() {
        Intent intent = new Intent( SendTotalOrderActivity.this, MyCardActivity.class );
        startActivity( intent );

    }
}
