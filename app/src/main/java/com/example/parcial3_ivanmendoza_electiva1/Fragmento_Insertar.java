package com.example.parcial3_ivanmendoza_electiva1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Fragmento_Insertar extends AppCompatActivity {

    EditText edNombres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmento_insertar);

        edNombres = findViewById( R.id.edtNombreeeeeeees);
    }
}