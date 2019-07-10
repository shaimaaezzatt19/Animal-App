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
import static com.khatab.animalapp.util.ValidationUtil.validatePhone;
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
    @BindView(R.id.connectUs_Facbook)
    ImageView connectUsFacbook;
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

    public void Connectue() {
        String name = ConnectUsName.getText().toString();
        final String phone = ConnectUsPhone.getText().toString();
        String message = ConnectUsMessage.getText().toString();
        apiServices.SendContact(name, phone, message).enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                if (response.isSuccessful()) {

                    if (!validatePhone(phone)) {
                        ConnectUsPhone.setError(getString(R.string.phone_number_error));
                        return;
                    } else
                        {

                        Toast.makeText(getApplicationContext(), "لا يوجد اتصال بالانترنت .. برجاء المحاولة لاحقا", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video

                    }

                    if (response.body().getStatus()) {
                        Toast.makeText(getApplicationContext(), response.body().getData(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), response.body().getError(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {

                Log.v(TAG, "Onfalliuer:error " + t.getMessage());
            }
        });

        ConnectUsMessage.setText("");
        ConnectUsPhone.setText("");
        ConnectUsName.setText("");
    }

    @OnClick({R.id.SendConnectUs_BT, R.id.ConnectUs_Insteghram, R.id.connectUs_Facbook, R.id.onnectUs_Whatsapp, R.id.ConnecUs_Back_IV})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.SendConnectUs_BT:

                Connectue();

                break;
            case R.id.ConnectUs_Insteghram:

                String url = "https://www.google.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                break;
            case R.id.connectUs_Facbook:

                String url2 = "https://www.google.com/";
                Intent i2 = new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse(url2));
                startActivity(i2);

                break;
            case R.id.onnectUs_Whatsapp:

                Uri uri = Uri.parse("https://wa.me/015551234567");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.ConnecUs_Back_IV:
                Intent back = new Intent(ConnectUsActivity.this, FullMenueWithIcons.class);
                startActivity(back);
                break;
        }
    }

    public final static boolean isValidPhoneNumber(CharSequence target) {
        if (target == null || target.length() < 11 || target.length() >= 10) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(target).matches();
        }

    }
}
