package com.example.SI_KRS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.SI_KRS.Adapter.DosenAdapter;
import com.example.SI_KRS.Model.Dosen;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class RecViewDosen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DosenAdapter dosenAdapter;
    private ArrayList<Dosen> dosenList;
    ProgressDialog progressDialog;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu) {
            Intent intent = new Intent(RecViewDosen.this, CreateDosenActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_view_dosen);
        this.setTitle("SI-KRS - Hai Admin");
//        tambahData();
       progressDialog = new ProgressDialog(this);
       progressDialog.setMessage("Sabar Yah....");
        progressDialog.show();

        DataDosenService service = RetrofitClient.getRetrofitInstance().create(DataDosenService.class);
        Call<ArrayList<Dosen>> call = service.getDosenAll("72170172");
        call.enqueue(new Callback<ArrayList<Dosen>>() {
            @Override
            public void onResponse(Call<ArrayList<Dosen>> call, Response<ArrayList<Dosen>> response) {
//                progressDialog.dismiss();

                recyclerView = findViewById(R.id.recDosen);
                dosenAdapter = new DosenAdapter(response.body());

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecViewDosen.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(dosenAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Dosen>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(RecViewDosen.this, "Gagal login Nih Broo, Coba sesuk wae ya lur", Toast.LENGTH_SHORT);
            }
        });

//    private void tambahData(){
//        dosenList = new ArrayList<>();
//        dosenList.add(new Dosen("001","Jong Jek Siang", "s.kom,MM","jjs@staff.ukdw.ac.id","Jl. Raya",R.drawable.diri));
//        dosenList.add(new Dosen("002","Yetli Oslan", "s,kom , MM","yetli@staff.ukdw.ac.id","Jl. Kenangan",R.drawable.diri));
//    }
    }
}
