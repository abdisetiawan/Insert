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

import com.example.SI_KRS.Adapter.krsAdapter;
import com.example.SI_KRS.Model.Krs;

import java.util.ArrayList;

public class RecViewKrs extends AppCompatActivity {

    private RecyclerView recyclerView;
    private com.example.SI_KRS.Adapter.krsAdapter krsAdapter;
    private ArrayList<Krs> krsArrayList;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.create,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu){
            Intent intent = new Intent(RecViewKrs.this, CreateKrs.class);
            startActivity(intent);
        }
        return  true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_view_krs);
        this.setTitle("SI-KRS - Hai Admin");

        tambahData();

        recyclerView = findViewById(R.id.recKrs);
        krsAdapter = new krsAdapter(krsArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecViewKrs.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(krsAdapter);

    }

    public void tambahData(){
        krsArrayList = new ArrayList<>();
        krsArrayList.add(new Krs("SI001","PasarModal","Senin","6","4","Wimmie","100"));
        krsArrayList.add(new Krs("SI001","PasarModal","Senin","6","4","Wimmie","100"));
        krsArrayList.add(new Krs("SI001","PasarModal","Senin","6","4","Wimmie","100"));
        krsArrayList.add(new Krs("SI001","PasarModal","Senin","6","4","Wimmie","100"));
    }
}