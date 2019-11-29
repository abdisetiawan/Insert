package com.example.SI_KRS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataDiriDosen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_dosen);
        this.setTitle("SI KRS - Hai Dosen");

        Button btnSimpanDsn = (Button)findViewById(R.id.btnSimpan);
        btnSimpanDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataDiriDosen.this, menuDosen.class);
                startActivity(intent);
            }
        });
    }
}
