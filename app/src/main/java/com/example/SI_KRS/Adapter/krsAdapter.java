package com.example.SI_KRS.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.SI_KRS.CreateKrs;
import com.example.SI_KRS.Model.Krs;
import com.example.SI_KRS.R;

import java.util.ArrayList;

public class krsAdapter extends RecyclerView.Adapter<krsAdapter.ViewHolder> {
    private ArrayList<Krs> dataList;
    private Context context;
    public krsAdapter(ArrayList<Krs> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cv_krs,parent,false); //
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtKode.setText(dataList.get(position).getKodeKrs());
        holder.txtNama.setText(dataList.get(position).getNamaMatkul());
        holder.txtHari.setText(dataList.get(position).getHari());
        holder.txtSesi.setText(dataList.get(position).getSesi());
        holder.txtSks.setText(dataList.get(position).getSks());
        holder.txtMahasiswa.setText(dataList.get(position).getJmlMhs());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(context != null){
                    Intent intent = new Intent(context, CreateKrs.class);
                    context.startActivity(intent);}
            }
        });
    }

    @Override
    public int getItemCount() { //berguna untuk menghitung jumlah data yang ada
        return (dataList != null)? dataList.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtKode, txtNama, txtHari, txtSesi, txtSks, txtMahasiswa;
        private CardView cv;

        public ViewHolder(View view){
            super(view);
            txtKode = view.findViewById(R.id.txtKode);
            txtNama = view.findViewById(R.id.txtNama);
            txtHari = view.findViewById(R.id.txtHari);
            txtSesi = view.findViewById(R.id.txtSesi);
            txtSks = view.findViewById(R.id.txtSks);
            txtMahasiswa = view.findViewById(R.id.txtMahasiswa);
            cv = view.findViewById(R.id.cardKrs);
        }
    }
}
