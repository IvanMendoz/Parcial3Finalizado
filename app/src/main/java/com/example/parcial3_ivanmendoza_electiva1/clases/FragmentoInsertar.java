package com.example.parcial3_ivanmendoza_electiva1.clases;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.parcial3_ivanmendoza_electiva1.Helpers.AdminSQLiteHelper;
import com.example.parcial3_ivanmendoza_electiva1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentoInsertar extends Fragment {

    private EditText edCodigo, edNombres, edApellidos, edTelefono, edCorreo;
    private Button btGuardar, btLimpiar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate( R.layout.fargmento_insertar, container, false );

        edCodigo = root.findViewById( R.id.edtCodigo );
        edNombres = root.findViewById(  R.id.edtNombres );
        edApellidos = root.findViewById( R.id.edtApellidos );
        edTelefono = root.findViewById( R.id.edtTelefono );
        edCorreo = root.findViewById( R.id.edtCorreo );
        btGuardar = root.findViewById( R.id.btnGuardar);
        btLimpiar = root.findViewById( R.id.btnLimpiar );

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteHelper admin = new AdminSQLiteHelper( getContext(), "Parcial", null, 1 );
                SQLiteDatabase db =admin.getWritableDatabase();
                String cod_contacto = edCodigo.getText().toString(),
                        nombres = edNombres.getText().toString(),
                        apellidos = edApellidos.getText().toString(),
                        telefono = edTelefono.getText().toString(),
                        correo_electronico = edCorreo.getText().toString();

                ContentValues detalle = new ContentValues();
                detalle.put( "cod_contacto", cod_contacto );
                detalle.put( "nombres", nombres );
                detalle.put( "apellidos", apellidos );
                detalle.put( "telefono", telefono );
                detalle.put( "correo_electronico", correo_electronico );

                try {
                    db.insert( "contactos", null, detalle );
                    db.close();
                    Toast.makeText( getContext(), "Se inserto el contacto", Toast.LENGTH_LONG ).show();
                }catch ( Exception e ){
                    Toast.makeText( getContext(), e.getMessage().toString(), Toast.LENGTH_LONG ).show();
                }
            }
        });

        btLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edCodigo.setText("");
                edNombres.setText("");
                edApellidos.setText("");
                edTelefono.setText("");
                edCorreo.setText("");
            }
        });
        return root;
    }

}
