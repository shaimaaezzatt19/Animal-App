package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.khatab.animalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowTotalServiceActivity extends AppCompatActivity {
    @BindView(R.id.SendMyOrder_Title)
    TextView SendMyOrderTitle;
    @BindView(R.id.Constrain)
    ConstraintLayout Constrain;
    @BindView(R.id.ImageService_IV)
    ImageView ImageServiceIV;
    @BindView(R.id.ShowService_NameOnImage_TV)
    TextView ShowServiceNameOnImageTV;
    @BindView(R.id.ShowService_ServiceNotes_TV)
    TextView ShowServiceServiceNotesTV;
    @BindView(R.id.ShowTotsalServices_1_TV)
    TextView ShowTotsalServices1TV;
    @BindView(R.id.ShowTotsalServices_2_TV)
    TextView ShowTotsalServices2TV;
    @BindView(R.id.ShowTotsalServices_3_TV)
    TextView ShowTotsalServices3TV;
    @BindView(R.id.ShowTotalServices_BT_Requset)
    Button ShowTotalServicesBTRequset;
    @BindView(R.id.RL_ShowTotalServices)
    RelativeLayout RLShowTotalServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_total_service);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.ShowTotalServices_BT_Requset)
    public void onViewClicked() {
        Intent intent = new Intent(ShowTotalServiceActivity.this, OrderTotalService.class);
        startActivity(intent);
    }
}
