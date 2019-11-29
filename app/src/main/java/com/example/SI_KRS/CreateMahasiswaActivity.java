package com.example.SI_KRS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateMahasiswaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_mahasiswa);
        this.setTitle("SI KRS - Hai Admin");

        Button btnSimpanKrs = (Button)findViewById(R.id.btnSimpan);
        btnSimpanKrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateMahasiswaActivity.this, menuAdmin.class);
                startActivity(intent);
            }
        });
    }
}