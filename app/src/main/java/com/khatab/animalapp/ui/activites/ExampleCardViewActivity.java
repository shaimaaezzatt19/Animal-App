package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.khatab.animalapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExampleCardViewActivity extends AppCompatActivity {

    @BindView(R.id.ItemsCard_Edit_IV)
    ImageView ItemsCardEditIV;
    @BindView(R.id.Button_Example)
    Button ButtonExample;
    Button button;
    @BindView(R.id.Items_Card_IV_MainPic)
    ImageView ItemsCardIVMainPic;
    @BindView(R.id.items_card_deatilsinTV)
    TextView itemsCardDeatilsinTV;
    @BindView(R.id.Items_Card_TV_TotalCard)
    TextView ItemsCardTVTotalCard;
    @BindView(R.id.ItemsCard_Close_IV)
    ImageView ItemsCardCloseIV;
    @BindView(R.id.RL1)
    RelativeLayout RL1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_example_card_view );
        ButterKnife.bind( this );


    }

    @OnClick({R.id.ItemsCard_Edit_IV, R.id.Button_Example})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ItemsCard_Edit_IV:
                Intent i = new Intent( ExampleCardViewActivity.this, UpdateOrderActivity.class );
                startActivity( i );
                break;

            case R.id.Button_Example:

                Intent i2 = new Intent( ExampleCardViewActivity.this, MainMenueActivity.class );
                startActivity( i2 );

                Toast.makeText( getApplicationContext(), "يمكنك انشاء طلب آخر من جديد ", Toast.LENGTH_LONG ).show();
                break;
        }
    }

    @OnClick(R.id.ItemsCard_Close_IV)
    public void onViewClicked() {
        ItemsCardIVMainPic.setVisibility( View.INVISIBLE );
        itemsCardDeatilsinTV.setVisibility( View.INVISIBLE );
        itemsCardDeatilsinTV.setVisibility( View.INVISIBLE );
        ItemsCardCloseIV.setVisibility( View.INVISIBLE );
        ItemsCardEditIV.setVisibility( View.INVISIBLE );
        ButtonExample.setVisibility( View.INVISIBLE );


    }
}