package com.example.ejaccesobd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
        /** Called when the activity is first created. */
        SQLiteDatabase db=null;
        private RadioButton r1,r2,r3,r4;
        private RadioGroup rg;
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            r1=(RadioButton)findViewById(R.id.radio_consultas);
            r2=(RadioButton)findViewById(R.id.radio_alta);
            r3=(RadioButton)findViewById(R.id.radio_eliminar);
            r4=(RadioButton)findViewById(R.id.radio_modificar);
            rg=(RadioGroup)findViewById(R.id.radioGroup1);

        }
        public void crearBd(View view) {

            BaseDatosHelper usdbh = new BaseDatosHelper(this, "DBUsuarios", null, 1);
//Abrimos la base de datos 'DBUsuarios' en modo escritura
            db= usdbh.getWritableDatabase();
//Si hemos abierto correctamente la base de datos
            if(db != null)         {
//Insertamos 5 usuarios de ejemplo
                for(int i=1; i<=5; i++)             {
//Generamos los datos
                    int codigo = i;
                    String nombre = "Usuario" + i;
//Insertamos los datos en la tabla Usuarios
                    db.execSQL("INSERT INTO Usuarios (codigo, nombre) " +
                            "VALUES (" + codigo + ", '" + nombre +"')");
                }
                System.out.println("INSERTADO!!!!");
//Cerramos la base de datos
//db.close();

            }

        }

        public void mostrarLayout(View view) {

            int radioseleccionado=rg.getCheckedRadioButtonId();

            switch (radioseleccionado) {
                case R.id.radio_consultas:
                    Intent i = new Intent(this, Consultas.class );
                    startActivity(i);
                    break;
                case R.id.radio_alta:
                    Intent i2 = new Intent(this, Alta.class );
                    startActivity(i2);
                    break;
                case R.id.radio_eliminar:
                    Intent i3 = new Intent(this, Eliminar.class );
                    startActivity(i3);
                    break;
                case R.id.radio_modificar:
                    Intent i4 = new Intent(this, Modificar.class );
                    startActivity(i4);
                    break;
                default:
                    break;
            }

        }

    }