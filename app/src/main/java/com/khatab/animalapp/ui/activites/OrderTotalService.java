package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.khatab.animalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderTotalService extends AppCompatActivity {


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
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @BindView(R.id.relativeLayout3)
    RelativeLayout relativeLayout3;
    @BindView(R.id.text3)
    TextView text3;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.textView7)
    TextView textView7;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_total_service);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.OrderTotalService_BT)
    public void onViewClicked() {
        Intent intent = new Intent(OrderTotalService.this,MyCardActivity.class);
        startActivity(intent);

    }
}
