package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.khatab.animalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ItemSelectedFromServicesActivity extends AppCompatActivity {


    @BindView(R.id.Service_Selected_Toolbar_title_TV)
    TextView ServiceSelectedToolbarTitleTV;
    @BindView(R.id.Pic_Selected_Service_IV)
    ImageView PicSelectedServiceIV;
    @BindView(R.id.Service_Selected_Option1_BT)
    Button ServiceSelectedOption1BT;
    @BindView(R.id.Service_Selected_Option2_BT)
    Button ServiceSelectedOption2BT;
    @BindView(R.id.Service_Selected_Option3_BT)
    Button ServiceSelectedOption3BT;
    @BindView(R.id.LL1_Item_Selected)
    LinearLayout LL1ItemSelected;
    @BindView(R.id.Selected_item_Back_IB)
    ImageView SelectedItemBackIB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_selected_from_services);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.Service_Selected_Option1_BT, R.id.Service_Selected_Option2_BT, R.id.Service_Selected_Option3_BT, R.id.Selected_item_Back_IB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Service_Selected_Option1_BT:
                Intent intent1 = new Intent(ItemSelectedFromServicesActivity.this, OptionSelectedDeatailsActivity.class);
                startActivity(intent1);
                break;

            case R.id.Service_Selected_Option2_BT:
                Intent intent2 = new Intent(ItemSelectedFromServicesActivity.this, OptionSelectedDeatailsActivity.class);
                startActivity(intent2);
                break;

            case R.id.Service_Selected_Option3_BT:
                Intent intent3 = new Intent(ItemSelectedFromServicesActivity.this, OptionSelectedDeatailsActivity.class);
                startActivity(intent3);


                break;
            case R.id.Selected_item_Back_IB:
                Intent intent4 = new Intent(ItemSelectedFromServicesActivity.this, FullMenueWithIcons.class);
                startActivity(intent4);
                break;
        }
    }
}
