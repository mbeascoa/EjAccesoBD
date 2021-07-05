package com.example.ejaccesobd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Eliminar extends AppCompatActivity {


        private EditText nombre;
        private TextView resultado;
        SQLiteDatabase db=null;
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_eliminar);
            this.resultado = (TextView) findViewById(R.id.txtBorrado);
            this.nombre = (EditText) findViewById(R.id.txtNombreBorrar);

        }
        public void BorrarBD(View view) {
            try {

                BaseDatosHelper usdbh = new BaseDatosHelper(this, "DBUsuarios", null, 1);
//Abrimos la base de datos 'DBUsuarios' en modo escritura
                db= usdbh.getWritableDatabase();



//Como vemos, volvemos a pasar como primer parámetro el nombre de la tabla y
//en segundo lugar la condición WHERE. Por supuesto,
//si no necesitáramos ninguna condición, podríamos dejar como null en este parámetro.

                db.delete("Usuarios", "nombre=?",new String[] { nombre.getText().toString() });


                this.resultado.setText("BORRADO CON ÉXITO");
                Toast.makeText(this, "Resgistro borrado correctamente", Toast.LENGTH_LONG).show();


            }
            catch(Exception e){
                System.out.println(e.toString());

            }
        }

        public void cerrar(View view) {
            finish();

        }

    }