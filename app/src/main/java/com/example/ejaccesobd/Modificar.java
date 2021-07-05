package com.example.ejaccesobd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Modificar  extends Activity {

    private EditText codigo,nombre;
    private TextView resultado;
    SQLiteDatabase db=null;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        this.resultado = (TextView) findViewById(R.id.txtModifi);
        this.codigo = (EditText) findViewById(R.id.txtCodigoActualizar);
        this.nombre = (EditText) findViewById(R.id.txtNombreActualizar);

    }

    public void ModificarBD(View view) {
        try {

            BaseDatosHelper usdbh = new BaseDatosHelper(this, "DBUsuarios", null, 1);
//Abrimos la base de datos 'DBUsuarios' en modo escritura
            db= usdbh.getWritableDatabase();


//Establecemos los campos-valores a actualizar

            ContentValues valores = new ContentValues();
            valores.put("codigo",codigo.getText().toString());
            //Actualizamos el registro en la base de datos

            // tabla que quiero modificar
            //campo igual balor, campo igual valor que quieres modificar a través de campo contentvalue
            //condicion de modificacion

            db.update("Usuarios",valores, "nombre=?",new String[] { nombre.getText().toString() });

            this.resultado.setText("REGISTRO MODIFICADO");

        }
        catch(Exception e){
            System.out.println(e.toString());

        }
    }

    public void cerrar(View view) {
        finish();

    }

}
