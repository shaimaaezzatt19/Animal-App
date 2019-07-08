package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.khatab.animalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmCodeActivity extends AppCompatActivity {


    @BindView(R.id.CofirmOrder_Title)
    TextView CofirmOrderTitle;
    @BindView(R.id.CodeNumber1)
    EditText CodeNumber1;
    @BindView(R.id.CodeNumber2)
    EditText CodeNumber2;
    @BindView(R.id.CodeNumber3)
    EditText CodeNumber3;
    @BindView(R.id.CodeNumber4)
    EditText CodeNumber4;
    @BindView(R.id.LL1_Code)
    LinearLayout LL1Code;
    @BindView(R.id.SendConfirmCode_BT)
    Button SendConfirmCodeBT;
    @BindView(R.id.ConfirmCode_Back_IB)
    ImageView ConfirmCodeBackIB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_code);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.SendConfirmCode_BT, R.id.ConfirmCode_Back_IB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.SendConfirmCode_BT:
                Intent intent1 = new Intent(ConfirmCodeActivity.this, CartAfterOrderingActivity.class);
                startActivity(intent1);
                break;

            case R.id.ConfirmCode_Back_IB:
                Intent intent2 = new Intent(ConfirmCodeActivity.this, ConfirmRequestActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
