package com.example.SI_KRS;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.SI_KRS.Model.Dosen;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateDosenActivity extends AppCompatActivity {
    EditText edtNama, edtNidn, edtAlamat, edtEmail, edtGelar;
    DataDosenService service;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_dosen);
        this.setTitle("SI-KRS - Hai Admin");

        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CreateDosenActivity.this);

                builder.setMessage("Simpan Gak Ni Bro?")
                        .setNegativeButton("Ora", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(CreateDosenActivity.this, "Batal Simpan", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Iyo", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                requestInsertDosen();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }

    private void requestInsertDosen() {
        edtNama = (EditText) findViewById(R.id.txtDosenNama);
        edtNidn = (EditText) findViewById(R.id.txtNIDN);
        edtAlamat = (EditText) findViewById(R.id.txtAlamatDosen);
        edtEmail = (EditText) findViewById(R.id.txtEmailDosen);
        edtGelar = (EditText) findViewById(R.id.txtGelarDosen);
        service = RetrofitClient.getRetrofitInstance().create(DataDosenService.class);
        progressDialog = ProgressDialog.show(this, null, "Tunggu Sek Tahh", true, false);

        Call<Dosen> call = service.insert_dosen(edtNama.getText().toString(), edtNidn.getText().toString(),
                edtAlamat.getText().toString(), edtEmail.getText().toString(), edtGelar.getText().toString(), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlvIYbRjkKCjZjzlX24fOM_P2_zvh4YQIAe6uNToYNXOGoaZ5lCw&s",
                "72170172");
        call.enqueue(new Callback<Dosen>() {
            @Override
            public void onResponse(Call<Dosen> call, Response<Dosen> response) {
                progressDialog.dismiss();
                Toast.makeText(CreateDosenActivity.this, "Data Berhasil Masuk", Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(CreateDosenActivity.this, RecViewDosen.class);
                startActivity(refresh);
                finish();
            }

            @Override
            public void onFailure(Call<Dosen> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(CreateDosenActivity.this, "Error", Toast.LENGTH_SHORT);
            }
        });
    }
}
