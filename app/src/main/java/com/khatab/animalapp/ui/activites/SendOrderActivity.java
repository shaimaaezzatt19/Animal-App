package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

public class SendOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @BindView(R.id.SendMyOrder_Title)
    TextView SendMyOrderTitle;
    @BindView(R.id.Pic_SendMyOrder_IV)
    ImageView PicSendMyOrderIV;
    @BindView(R.id.SendMyOrder_Show_Deatils_TV)
    TextView SendMyOrderShowDeatilsTV;
    @BindView(R.id.SendMyOrder_Kilo_TV)
    TextView SendMyOrderKiloTV;
    @BindView(R.id.SendMyOrder_Price_TV)
    TextView SendMyOrderPriceTV;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.SendMyOrder_Count_TV)
    TextView SendMyOrderCountTV;
    @BindView(R.id.SendMyOrder_Count_ET)
    EditText SendMyOrderCountET;
    @BindView(R.id.SpinnerOne)
    Spinner SpinnerOne;
    @BindView(R.id.RL1_SpinerOne)
    RelativeLayout RL1SpinerOne;
    @BindView(R.id.SpinnerTWO)
    Spinner SpinnerTWO;
    @BindView(R.id.RL1_SpinerTWO)
    RelativeLayout RL1SpinerTWO;
    @BindView(R.id.Notes_TV)
    TextView NotesTV;
    @BindView(R.id.WriteYourNotes_ET)
    EditText WriteYourNotesET;
    @BindView(R.id.totalPriceTextView)
    TextView totalPriceTextView;
    @BindView(R.id.AddToCard_BT)
    Button AddToCardBT;
    @BindView(R.id.AddToCard_Back_IB)
    ImageView AddToCardBackIB;

    private ApiServices apiServices;
    private static final String TAG = SendOrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_send_order );

        Spinner spinner1 = findViewById( R.id.SpinnerOne );
        Spinner spinner2 = findViewById( R.id.SpinnerTWO );


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


        ButterKnife.bind( this );
        apiServices = getClient().create( ApiServices.class );


        Intent i = getIntent();
        if (i != null && i.hasExtra( "id" )) {
            Long id = i.getExtras().getLong( "id" );
//            Integer id = i.getExtras().getInt( "id" );
            Sendorder( id );
        }


        EditText Count = (EditText) findViewById( R.id.SendMyOrder_Count_ET );
        String CountNumber = Count.getText().toString();


        Spinner SpinnerOne = (Spinner) findViewById( R.id.SpinnerOne );
        String SpinnerOneDeatils = Count.getText().toString();

        Spinner SpinnerTwo = (Spinner) findViewById( R.id.SpinnerTWO );
        String SpinnerTWODeatils = Count.getText().toString();

        EditText Notes = (EditText) findViewById( R.id.WriteYourNotes_ET );
        String EnterNotes = Count.getText().toString();


    }

    public void Sendorder(Long id) {
        apiServices.getProductsDeatils(id).enqueue( new Callback<ShowProducts>() {
            @Override
            public void onResponse(Call<ShowProducts> call, Response<ShowProducts> response) {
                if (response.isSuccessful()) {
                    Boolean status = response.body().getStatus();
                    if (status) {

//                       // List<ProductsData> data = response.body().getData();
//                        SendMyOrderTitle.setText( data.get( 0 ).getName() );
//                        Glide.with( SendOrderActivity.this ).load( data.get( 0 ).getImage() ).into( PicSendMyOrderIV );
//                        SendMyOrderPriceTV.setText( data.get( 0 ).getName() );
//

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition( position ).toString();
        Toast.makeText( parent.getContext(), text, Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @OnClick({R.id.AddToCard_BT, R.id.AddToCard_Back_IB})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.AddToCard_BT:
                Intent intent1 = new Intent( SendOrderActivity.this, ConfirmRequestActivity.class );
                startActivity( intent1 );
                break;
            case R.id.AddToCard_Back_IB:
                Intent intent2 = new Intent( SendOrderActivity.this, MyCardActivity.class );
                startActivity( intent2 );
                break;
        }

        // Array of choices
        String Array1[] = {"أطباق مغلفة", "أكياس", "أكياس بدون هواء"};


        // Selection of the spinner
        Spinner spinner = (Spinner) findViewById( R.id.SpinnerOne );


        // Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>( this,
                android.R.layout.simple_spinner_item, Array1 );
        spinnerArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item ); // The drop down view
        spinner.setAdapter( spinnerArrayAdapter );


        // Array of choices
        String Array2[] = {"أرباع ", "أنصاص", "كامل", "ثلاجة", "تفصيل كبير", "تفصيل صغير"};

        // Selection of the spinner
        Spinner spinner2 = (Spinner) findViewById( R.id.SpinnerTWO );

        // Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>( this,
                android.R.layout.simple_spinner_item, Array2 );
        spinnerArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item ); // The drop down view
        spinner.setAdapter( spinnerArrayAdapter2 );


    }
}
