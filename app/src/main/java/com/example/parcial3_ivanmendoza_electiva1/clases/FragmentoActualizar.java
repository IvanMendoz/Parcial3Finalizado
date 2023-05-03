package com.example.parcial3_ivanmendoza_electiva1.clases;

import android.content.ContentValues;
import android.database.Cursor;
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
import androidx.fragment.app.Fragment;

import com.example.parcial3_ivanmendoza_electiva1.Helpers.AdminSQLiteHelper;
import com.example.parcial3_ivanmendoza_electiva1.R;

public class FragmentoActualizar extends Fragment {

    private EditText edCodigo, edNombres, edApellidos, edTelefono, edCorreo;
    private Button btModificar, btLimpiar, btBuscar;

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate( R.layout.fargmento_actualizar, container, false );

        edCodigo = root.findViewById( R.id.edtCodigo );
        edNombres = root.findViewById(  R.id.edtNombre );
        edApellidos = root.findViewById( R.id.edtApellido );
        edTelefono = root.findViewById( R.id.edtTelefono );
        edCorreo = root.findViewById( R.id.edtCorreo );
        btBuscar = root.findViewById( R.id.btnBuscar );
        btModificar = root.findViewById( R.id.btnActualizar);
        btLimpiar = root.findViewById( R.id.btnLimpiar );

        btModificar.setOnClickListener(new View.OnClickListener() {
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

                int cat = db.update( "contactos", detalle, "cod_contacto = " + cod_contacto, null );
                db.close();
                if ( cat == 1 ){
                    Toast.makeText( getContext(), "Se actualizo el registro", Toast.LENGTH_LONG ).show();
                }else{
                    Toast.makeText( getContext(), "No se actualizo el registro", Toast.LENGTH_LONG ).show();
                }
            }
        });

        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteHelper admin = new AdminSQLiteHelper( getContext(), "Parcial", null, 1 );
                SQLiteDatabase db =admin.getWritableDatabase();
                String cod_contacto = edCodigo.getText().toString();

                Cursor fila = db.rawQuery( "select nombres, apellidos, telefono, correo_electronico from contactos WHERE cod_contacto = " + cod_contacto,
                        null );

                if ( fila.moveToFirst() ){
                    edNombres.setText( fila.getString( 0 ) );
                    edApellidos.setText( fila.getString( 1 ) );
                    edTelefono.setText( fila.getString( 2 ) );
                    edCorreo.setText( fila.getString( 3 ) );
                    Toast.makeText( getContext(), "El registro fue encontrado", Toast.LENGTH_LONG ).show();

                }else {
                    Toast.makeText( getContext(), "Registro no encontrado", Toast.LENGTH_LONG ).show();
                }
                db.close();
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
