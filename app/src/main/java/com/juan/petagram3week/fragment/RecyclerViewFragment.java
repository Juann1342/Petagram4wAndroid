package com.juan.petagram3week.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.juan.petagram3week.R;
import com.juan.petagram3week.adapter.MascotaAdaptador;
import com.juan.petagram3week.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    public MascotaAdaptador adaptador;
    //declaro recycler view
    private RecyclerView listaMascotas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v= inflater.inflate(R.layout.fragment_recyclerview, container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        //defino de que forma quiero mostrar el recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Pilo", R.drawable.pet1,"5"));
        mascotas.add(new Mascota("Luki",R.drawable.pet2,"4"));
        mascotas.add(new Mascota("Fuxy",R.drawable.pet3,"2"));
        mascotas.add(new Mascota("Pyt",R.drawable.pet4,"3"));
        mascotas.add(new Mascota("Shampy",R.drawable.pet5,"4"));
    }
}

