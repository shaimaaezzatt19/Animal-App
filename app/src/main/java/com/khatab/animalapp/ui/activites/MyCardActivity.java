package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.khatab.animalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_card);


        ButterKnife.bind(this);
    }

    @OnClick({R.id.MYCard_confirmBuying_BT, R.id.MYCard_Back_IB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.MYCard_confirmBuying_BT:
                Intent intent1 = new Intent(MyCardActivity.this, ConfirmRequestActivity.class);
                startActivity(intent1);
                break;

            case R.id.MYCard_Back_IB:
                Intent intent2 = new Intent(MyCardActivity.this, SendOrderActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
