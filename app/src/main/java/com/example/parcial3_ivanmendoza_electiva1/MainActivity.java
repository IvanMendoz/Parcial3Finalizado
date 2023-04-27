package com.example.parcial3_ivanmendoza_electiva1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial3_ivanmendoza_electiva1.clases.FragmentoActualizar;
import com.example.parcial3_ivanmendoza_electiva1.clases.FragmentoEliminar;
import com.example.parcial3_ivanmendoza_electiva1.clases.FragmentoInsertar;
import com.example.parcial3_ivanmendoza_electiva1.clases.FragmentoMostrar;
import com.google.android.material.bottomnavigation.BottomNavigationView;;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView btnNavigator;
    EditText edNombres, edApellidos, edTelefono, edCorreo;
    Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int fargmento_mostrar = R.layout.fargmento_mostrar;
        int fargmento_insertar = R.layout.fargmento_insertar;

        btnNavigator = findViewById( R.id.btnNav );
        btnNavigator.setOnNavigationItemSelectedListener( ( BottomNavigationView.OnNavigationItemSelectedListener ) navListener );
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectFragment = null;

            switch ( item.getItemId() ){
                case R.id.nav_update:
                    selectFragment = new FragmentoActualizar();
                    break;

                case R.id.nav_delete:
                    selectFragment =new FragmentoEliminar();
                    break;

                case R.id.nav_Edit:
                    selectFragment =new FragmentoInsertar();
                    break;

                case R.id.nav_Show:
                    selectFragment =new FragmentoMostrar();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace( R.id.FragmentContent, selectFragment ).commit();
            return true;
        }
    };

    public boolean onCreateOptionsMenu(Menu menu ){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_superior, menu );
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem items){
        switch ( items.getItemId() ){
            case R.id.opcion1:
                Toast.makeText( this, "Selecciono la opción 1", Toast.LENGTH_LONG ).show();
                return true;

            case R.id.opcion2:
                Toast.makeText( this, "Selecciono la opción 2", Toast.LENGTH_LONG ).show();
                return true;

            case R.id.opcion3:
                Toast.makeText( this, "Selecciono la opción 3", Toast.LENGTH_LONG ).show();
                return true;

            case R.id.opcion4:
                Toast.makeText( this, "Selecciono la opción 4", Toast.LENGTH_LONG ).show();
                return true;
        }
        return super.onOptionsItemSelected( items );
    }


}