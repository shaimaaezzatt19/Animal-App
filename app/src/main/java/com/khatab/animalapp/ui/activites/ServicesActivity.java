package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.khatab.animalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServicesActivity extends AppCompatActivity {
    @BindView(R.id.OurServices_Title)
    TextView OurServicesTitle;
    @BindView(R.id.Toolbar_services)
    ConstraintLayout ToolbarServices;
    @BindView(R.id.Services_ServiceOne_PIC_IV)
    ImageView ServicesServiceOnePICIV;
    @BindView(R.id.Services_ServiceTWO_PIC_IV)
    ImageView ServicesServiceTWOPICIV;
    @BindView(R.id.Services_LL1)
    LinearLayout ServicesLL1;
    @BindView(R.id.Services_ServiceThree_PIC_IV)
    ImageView ServicesServiceThreePICIV;
    @BindView(R.id.Services_ServiceFour_PIC_IV)
    ImageView ServicesServiceFourPICIV;
    @BindView(R.id.Services_LL2)
    LinearLayout ServicesLL2;
    @BindView(R.id.Services_ServiceFive_PIC_IV)
    ImageView ServicesServiceFivePICIV;
    @BindView(R.id.Services_ServiceSix_PIC_IV)
    ImageView ServicesServiceSixPICIV;
    @BindView(R.id.Services_LL3)
    LinearLayout ServicesLL3;
    @BindView(R.id.Services_ServiceSeven_PIC_IV)
    ImageView ServicesServiceSevenPICIV;
    @BindView(R.id.Services_ServiceEight_PIC_IV)
    ImageView ServicesServiceEightPICIV;
    @BindView(R.id.Services_LL4)
    LinearLayout ServicesLL4;
    @BindView(R.id.Services_ServiceNine_PIC_IV)
    ImageView ServicesServiceNinePICIV;
    @BindView(R.id.Services_ServicTen_PIC_IV)
    ImageView ServicesServicTenPICIV;
    @BindView(R.id.Services_LL5)
    LinearLayout ServicesLL5;
    @BindView(R.id.Services_LL6)
    LinearLayout ServicesLL6;
    @BindView(R.id.Name_Pic1)
    TextView NamePic1;
    @BindView(R.id.Name_Pic1_Constrain)
    ConstraintLayout NamePic1Constrain;
    @BindView(R.id.Name_Pic2)
    TextView NamePic2;
    @BindView(R.id.Name_Pic2_Constrain)
    ConstraintLayout NamePic2Constrain;
    @BindView(R.id.Name_Pic3)
    TextView NamePic3;
    @BindView(R.id.Name_Pic3_Constrain)
    ConstraintLayout NamePic3Constrain;
    @BindView(R.id.Name_Pic4)
    TextView NamePic4;
    @BindView(R.id.Name_Pic4_Constrain)
    ConstraintLayout NamePic4Constrain;
    @BindView(R.id.Name_Pic5)
    TextView NamePic5;
    @BindView(R.id.Name_Pic5_Constrain)
    ConstraintLayout NamePic5Constrain;
    @BindView(R.id.Name_Pic6)
    TextView NamePic6;
    @BindView(R.id.Name_Pic6_Constrain)
    ConstraintLayout NamePic6Constrain;
    @BindView(R.id.Name_Pic7)
    TextView NamePic7;
    @BindView(R.id.Name_Pic7_Constrain)
    ConstraintLayout NamePic7Constrain;
    @BindView(R.id.Name_Pic8)
    TextView NamePic8;
    @BindView(R.id.Name_Pic8_Constrain)
    ConstraintLayout NamePic8Constrain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        ButterKnife.bind(this);


    }

    @OnClick({R.id.Services_ServiceOne_PIC_IV, R.id.Services_ServiceTWO_PIC_IV, R.id.Services_ServiceThree_PIC_IV, R.id.Services_ServiceFour_PIC_IV, R.id.Services_ServiceFive_PIC_IV, R.id.Services_ServiceSix_PIC_IV, R.id.Services_ServiceSeven_PIC_IV, R.id.Services_ServiceEight_PIC_IV, R.id.Services_ServiceNine_PIC_IV, R.id.Services_ServicTen_PIC_IV})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Services_ServiceOne_PIC_IV:

                Intent intent1 = new Intent(ServicesActivity.this, ItemSelectedFromServicesActivity.class);
                startActivity(intent1);
                break;

            case R.id.Services_ServiceTWO_PIC_IV:
                Intent intent2 = new Intent(ServicesActivity.this, ItemSelectedFromServicesActivity.class);
                startActivity(intent2);
                break;

            case R.id.Services_ServiceThree_PIC_IV:
                Intent intent3 = new Intent(ServicesActivity.this, ItemSelectedFromServicesActivity.class);
                startActivity(intent3);
                break;

            case R.id.Services_ServiceFour_PIC_IV:
                Intent intent4 = new Intent(ServicesActivity.this, ItemSelectedFromServicesActivity.class);
                startActivity(intent4);
                break;

            case R.id.Services_ServiceFive_PIC_IV:
                Intent intent5 = new Intent(ServicesActivity.this, ItemSelectedFromServicesActivity.class);
                startActivity(intent5);
                break;

            case R.id.Services_ServiceSix_PIC_IV:
                Intent intent6 = new Intent(ServicesActivity.this, ItemSelectedFromServicesActivity.class);
                startActivity(intent6);
                break;

            case R.id.Services_ServiceSeven_PIC_IV:
                Intent intent7 = new Intent(ServicesActivity.this, ItemSelectedFromServicesActivity.class);
                startActivity(intent7);
                break;

            case R.id.Services_ServiceEight_PIC_IV:
                Intent intent8 = new Intent(ServicesActivity.this, ItemSelectedFromServicesActivity.class);
                startActivity(intent8);
                break;

            case R.id.Services_ServiceNine_PIC_IV:
                Intent intent9 = new Intent(ServicesActivity.this, ItemSelectedFromServicesActivity.class);
                startActivity(intent9);
                break;

            case R.id.Services_ServicTen_PIC_IV:
                Intent intent10 = new Intent(ServicesActivity.this, ItemSelectedFromServicesActivity.class);
                startActivity(intent10);
                break;
        }
    }
}

