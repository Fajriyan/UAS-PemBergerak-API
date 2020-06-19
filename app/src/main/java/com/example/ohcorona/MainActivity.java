package com.example.ohcorona;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ohcorona.Model.ModelDataIndo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tSembuh, tSakit, tMeninggal;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tSembuh = findViewById(R.id.tSembuh);
        tSakit = findViewById(R.id.tSakit);
        tMeninggal = findViewById(R.id.tMeninggal);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
        dialog.show();
        Call<List<ModelDataIndo>> call = Api.service().getData();
        call.enqueue(new Callback<List<ModelDataIndo>>() {
            @Override
            public void onResponse(Call<List<ModelDataIndo>> call, Response<List<ModelDataIndo>> response) {
                tSembuh.setText(response.body().get(0).getSembuh());
                tSakit.setText(response.body().get(0).getPositif());
                tMeninggal.setText(response.body().get(0).getMeninggal());
                dialog.cancel();
            }

            @Override
            public void onFailure(Call<List<ModelDataIndo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

    }
}
