package com.example.raul.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    EditText et1,et2;
    public TextView linkSingUp;
    private Cursor fila;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        et1= (EditText) findViewById(R.id.input_email);
        et2= (EditText) findViewById(R.id.input_password);
        linkSingUp = (TextView)findViewById(R.id.link_signup);
        linkSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro(v);
            }
        });
    }

    public void dato(View v){
        Toast.makeText(this, "Please check the number you entered",
                Toast.LENGTH_LONG).show();
    }
    public void ingresar(View v){
        DBHelper admin=new DBHelper(this,"instituto",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String usuario=et1.getText().toString();
        String contrasena=et2.getText().toString();
        fila=db.rawQuery("select usuario,contrasena from usuarios where usuario='"+usuario+"' and contrasena='"+contrasena+"'",null);

        if (fila.moveToFirst()){
            String usua=fila.getString(0);
            String pass=fila.getString(1);
            if (usuario.equals(usua)&&contrasena.equals(pass)){
                Intent ven=new Intent(this,MainActivity.class);
                startActivity(ven);
                et1.setText("");
                et2.setText("");
            }

        }



    }
    public void registro(View v){
        Intent ven=new Intent(this,Registro.class);
        startActivity(ven);
    }

    public void salir(View v){
   finish();

    }






}
