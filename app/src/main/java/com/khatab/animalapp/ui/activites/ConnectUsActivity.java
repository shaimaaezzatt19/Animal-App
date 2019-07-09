package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.khatab.animalapp.R;
import com.khatab.animalapp.data.model.contact.Contact;
import com.khatab.animalapp.data.rest.ApiServices;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.khatab.animalapp.data.rest.RetrofitGeneral.getClient;
import static java.security.AccessController.getContext;

public class ConnectUsActivity extends AppCompatActivity {

    @BindView(R.id.ConnectUs_Title)
    TextView ConnectUsTitle;
    @BindView(R.id.ConnectUs_Name)
    TextInputEditText ConnectUsName;
    @BindView(R.id.ConnectUs_phone)
    TextInputEditText ConnectUsPhone;
    @BindView(R.id.ConnectUs_Message)
    TextInputEditText ConnectUsMessage;
    @BindView(R.id.SendConnectUs_BT)
    Button SendConnectUsBT;
    @BindView(R.id.Main_LL1)
    LinearLayout MainLL1;
    @BindView(R.id.ConnectUs_Insteghram)
    ImageView ConnectUsInsteghram;
    @BindView(R.id.onnectUs_Whatsapp)
    ImageView onnectUsWhatsapp;
    @BindView(R.id.splash_LL_socilImages)
    LinearLayout splashLLSocilImages;
    @BindView(R.id.ConnecUs_Back_IV)
    ImageView ConnecUsBackIV;

    private ApiServices apiServices;
    private static final String TAG = ConnectUsActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_us);
        ButterKnife.bind(this);

        apiServices = getClient().create(ApiServices.class);


    }

    @OnClick({R.id.SendConnectUs_BT, R.id.ConnectUs_Insteghram, R.id.onnectUs_Whatsapp, R.id.ConnecUs_Back_IV})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.SendConnectUs_BT:
                connectue("shaimaa", "012", "dfds");
                break;

            case R.id.ConnectUs_Insteghram:
                String url = "https://www.google.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;

            case R.id.onnectUs_Whatsapp:
                Intent WhatsApp = new Intent(Intent.ACTION_CALL);
                WhatsApp.setData(Uri.parse("telephone :: 012364584"));
                startActivity(WhatsApp);
                break;

            case R.id.ConnecUs_Back_IV:
                Intent i5 = new Intent(ConnectUsActivity.this, FullMenueWithIcons.class);
                startActivity(i5);
                break;
        }
    }

    public void connectue(String name, String phone, String message) {
        name = ConnectUsName.getText().toString();
        phone = ConnectUsPhone.getText().toString();
        message = ConnectUsMessage.getText().toString();
        apiServices.SendContact(name, phone, message).enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {

                Log.v(TAG, "Onfalliuer:error " + t.getMessage());
            }
        });
    }
}
