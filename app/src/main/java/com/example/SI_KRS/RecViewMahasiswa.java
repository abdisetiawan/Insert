package com.example.SI_KRS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.SI_KRS.Adapter.MahasiswaAdapter;
import com.example.SI_KRS.Model.Mahasiswa;

import java.util.ArrayList;

public class RecViewMahasiswa extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.create,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu){
            Intent intent = new Intent(RecViewMahasiswa.this,CreateMahasiswaActivity.class);
            startActivity(intent);
        }
        return  true;
    }

    private RecyclerView recyclerView;
    private MahasiswaAdapter mhsAdapter;
    private ArrayList<Mahasiswa> mhsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_view_mahasiswa);
        this.setTitle("SI-KRS - Hai Admin");
        tambahData();

        recyclerView = findViewById(R.id.recMahasiswa);
        mhsAdapter = new MahasiswaAdapter(mhsList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecViewMahasiswa.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mhsAdapter);
    }

    private void tambahData(){
        mhsList = new ArrayList<>();
        mhsList.add(new Mahasiswa("72170106","Deo Bulin","Deo.bulin@si.ukdw.ac.id","Jl.Sagan",R.drawable.diri));
        mhsList.add(new Mahasiswa("72170126","Desta Sp","Desta.sp@si.ukdw.ac.id","Jl.Godean",R.drawable.diri));
        mhsList.add(new Mahasiswa("72170172","Abdi S","Abdi.s@si.ukdw.ac.id","Jl.Colombo",R.drawable.diri));
    }
}
