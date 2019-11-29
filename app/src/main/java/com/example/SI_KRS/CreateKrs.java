package com.example.SI_KRS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CreateKrs extends AppCompatActivity {
    private Spinner spinner1;
    private static final String[] dosen = {"Jong Jek Siang","Haryanto","Willy",
            "Argo Wibowo","Yetli Oslan", "Budi susanto", "Wimmie"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_krs);
        this.setTitle("SI-KRS - Hai Admin");

        spinner1 = (Spinner)findViewById(R.id.spinnerDosen);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(CreateKrs.this,android.R.layout.simple_spinner_item,dosen);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        Button btnSimpanKrs = (Button)findViewById(R.id.btnSimpan);
        btnSimpanKrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateKrs.this, menuAdmin.class);
                startActivity(intent);
            }
        });
    }
}
