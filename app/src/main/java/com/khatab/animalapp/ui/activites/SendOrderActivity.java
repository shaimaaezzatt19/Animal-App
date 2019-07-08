package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.khatab.animalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SendOrderActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_order);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.AddToCard_BT, R.id.AddToCard_Back_IB})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.AddToCard_BT:
                Intent intent1 = new Intent(SendOrderActivity.this, MyCardActivity.class);
                startActivity(intent1);
                break;
            case R.id.AddToCard_Back_IB:
                Intent intent2 = new Intent(SendOrderActivity.this, MyCardActivity.class);
                startActivity(intent2);
                break;
        }

        // Array of choices
        String Array1[] = {"أطباق مغلفة", "أكياس", "أكياس بدون هواء"};

// Selection of the spinner
        Spinner spinner = (Spinner) findViewById(R.id.SpinnerOne);

// Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Array1);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner.setAdapter(spinnerArrayAdapter);


        // Array of choices
        String Array2[] = {"أرباع ", "أنصاص", "كامل", "ثلاجة", "تفصيل كبير", "تفصيل صغير"};

// Selection of the spinner
        Spinner spinner2 = (Spinner) findViewById(R.id.SpinnerTWO);

// Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Array2);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner.setAdapter(spinnerArrayAdapter2);


    }
}