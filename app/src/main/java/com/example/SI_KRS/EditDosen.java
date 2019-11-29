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

public class EditDosen extends AppCompatActivity {
    EditText eIdDsn, eNamaDsn, eNIDN, eAlamatDsn, eEmailDsn, eGelarDsn;
    Intent mIntent = getIntent();
    DataDosenService service;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dosen);
        this.setTitle("SI KRS - Hai Admin");

        Button btnEdit = (Button)findViewById(R.id.btnEdosen);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(EditDosen.this);

                builder.setMessage("Apakah yakin untuk menyimpan?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(EditDosen.this, "Gagal Update", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                requestUpdateDosen();
                            }
                        });

                AlertDialog dialog = builder.create(); dialog.show();
            }
        });
    }
    private void requestUpdateDosen(){
        eIdDsn = (EditText)findViewById(R.id.eIdDsn);
        eNamaDsn = (EditText)findViewById(R.id.eNamaDsn);
        eNIDN = (EditText)findViewById(R.id.eNIDN);
        eAlamatDsn = (EditText)findViewById(R.id.eAlamatDsn);
        eEmailDsn = (EditText)findViewById(R.id.eEmailDsn);
        eGelarDsn = (EditText)findViewById(R.id.eGelarDsn);

        eIdDsn.setText(mIntent.getStringExtra("id"));
        eIdDsn.setTag(eIdDsn.getKeyListener());
        eIdDsn.setKeyListener(null);
        eNamaDsn.setText(mIntent.getStringExtra("nama"));
        eNIDN.setText(mIntent.getStringExtra("nidn"));
        eAlamatDsn.setText(mIntent.getStringExtra("alamat"));
        eEmailDsn.setText(mIntent.getStringExtra("email"));
        eGelarDsn.setText(mIntent.getStringExtra("gelar"));

        service = RetrofitClient.getRetrofitInstance().create(DataDosenService.class);
        progressDialog =  ProgressDialog.show(this, null, "Tunggu Lur...", true, false);

        Call<Dosen> call =  service.update_dosen(eIdDsn.getText().toString(),eNamaDsn.getText().toString(),eNIDN.getText().toString(),
                eAlamatDsn.getText().toString(),eEmailDsn.getText().toString(),eGelarDsn.getText().toString(),"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlvIYbRjkKCjZjzlX24fOM_P2_zvh4YQIAe6uNToYNXOGoaZ5lCw&s",
                "72170172");
        call.enqueue(new Callback<Dosen>() {
            @Override
            public void onResponse(Call<Dosen> call, Response<Dosen> response) {
                progressDialog.dismiss();
                Toast.makeText(EditDosen.this,"Berhasil Edit",Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(EditDosen.this, RecViewDosen.class);
                startActivity(refresh);
                finish();

            }

            @Override
            public void onFailure(Call<Dosen> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(EditDosen.this,"Error",Toast.LENGTH_SHORT);
            }
        });
    }
}
