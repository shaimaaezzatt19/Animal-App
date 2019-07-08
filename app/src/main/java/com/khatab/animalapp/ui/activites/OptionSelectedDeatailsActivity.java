package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.khatab.animalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OptionSelectedDeatailsActivity extends AppCompatActivity {

    @BindView(R.id.Service_Deatils_Selected_Toolbar_title_TV)
    TextView ServiceDeatilsSelectedToolbarTitleTV;
    @BindView(R.id.Pic_Selected_Service_IV)
    ImageView PicSelectedServiceIV;
    @BindView(R.id.Option_Selected_Show_Deatils_TV)
    TextView OptionSelectedShowDeatilsTV;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.Service_Selected_Order_BT)
    Button ServiceSelectedOrderBT;
    @BindView(R.id.LL1_Item_Selected)
    LinearLayout LL1ItemSelected;
    @BindView(R.id.Selected_item_Back_IB)
    ImageView SelectedItemBackIB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_selected_deatails);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.Service_Selected_Order_BT, R.id.Selected_item_Back_IB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Service_Selected_Order_BT:
                Intent intent1 = new Intent(OptionSelectedDeatailsActivity.this, AskTypeOfOrederActivity.class);
                startActivity(intent1);
                break;

            case R.id.Selected_item_Back_IB:
                Intent intent2 = new Intent(OptionSelectedDeatailsActivity.this, ServicesActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
