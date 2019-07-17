package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

public class UpdateOrderActivity extends AppCompatActivity {

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
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_update_order );
        ButterKnife.bind( this );
    }

    @OnClick(R.id.AddToCard_Back_IB)
    public void onViewClicked() {

        Intent backIntent = new Intent( UpdateOrderActivity.this,ExampleCardViewActivity.class);
        startActivity( backIntent );
    }
}
