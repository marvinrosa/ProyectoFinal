package com.example.raul.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

      EditText et1,et2,et3;
      TextView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        et1= (EditText) findViewById(R.id.txtId);
        et2= (EditText) findViewById(R.id.txtUsuario);
        et3= (EditText) findViewById(R.id.input_password);
        login = (TextView)findViewById(R.id.link_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(v);
            }
        });


    }
    public void registrar(View view){

        DBHelper admin=new DBHelper(this,"instituto",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String codigo=et1.getText().toString();
        String usuario=et2.getText().toString();
        String contraseña=et3.getText().toString();

        ContentValues values=new ContentValues();
        values.put("codigo",codigo);
        values.put("usuario",usuario);
        values.put("contrasena",contraseña);

        db.insert("usuarios",null,values);
        db.close();

        Intent ven=new Intent(this,Main.class);
        startActivity(ven);

    }

    public void login(View v){
        Intent ven=new Intent(this,Main.class);
        startActivity(ven);
    }

    public void cancelar(View view){
        finish();

    }



}
