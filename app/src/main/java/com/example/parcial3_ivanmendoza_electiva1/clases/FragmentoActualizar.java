package com.example.parcial3_ivanmendoza_electiva1.clases;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.parcial3_ivanmendoza_electiva1.R;

public class FragmentoActualizar extends Fragment {

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fargmento_actualizar, container, false );
    }
}
