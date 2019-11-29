package com.example.SI_KRS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataDiriAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_admin);
        this.setTitle("SI KRS - Hai Admin");

        Button btnSimpanAdm = (Button)findViewById(R.id.btnSimpanAdmin);
        btnSimpanAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataDiriAdmin.this, menuAdmin.class);
                startActivity(intent);
            }
        });
    }
}
