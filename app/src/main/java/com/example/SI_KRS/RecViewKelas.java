package com.example.SI_KRS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.SI_KRS.Adapter.KelasAdapter;
import com.example.SI_KRS.Model.Kelas;

import java.util.ArrayList;

public class RecViewKelas extends AppCompatActivity {

    private RecyclerView recyclerView;
    private KelasAdapter kelasAdapter;
    private ArrayList<Kelas> kelasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_view_kelas);

        this.setTitle("SI-KRS - Hai Dosen");

        tambahData();

        recyclerView = findViewById(R.id.recKelas);
        kelasAdapter = new KelasAdapter(kelasList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecViewKelas.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(kelasAdapter);
    }

    public void tambahData() {
        kelasList = new ArrayList<>();
        kelasList.add(new Kelas("SI001", "Pasar Modal", "6", "Senin", "Wimmie", "100"));
        kelasList.add(new Kelas("SI002", "Strukdat", "3", "Rabu", "Yetli", "50"));
        kelasList.add(new Kelas("SI003", "Jarkom", "3", "Jumat", "Argo", "25"));
    }
}
