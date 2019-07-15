package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
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

import com.khatab.animalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderTotalService extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_order_total_service );


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
        Intent intent = new Intent( OrderTotalService.this, MyCardActivity.class );
        startActivity( intent );

    }
}
