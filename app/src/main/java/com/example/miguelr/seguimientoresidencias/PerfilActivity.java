package com.example.miguelr.seguimientoresidencias;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.miguelr.seguimientoresidencias.DataBase.Tables.Alumnos;
import com.example.miguelr.seguimientoresidencias.Helper.Common;
import com.example.miguelr.seguimientoresidencias.Alumnos.mostrarAlumnosActivity;


/**
 * Created by miguelr on 12/03/2018.
 */

public class PerfilActivity extends AppCompatActivity{
    private Toolbar toolbar;
    private Common common;
    private Alumnos alumno;
    private TextView nombreAlumno;
    private TextView creditos;
    private TextView estatus;
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.acitivity_perfil);

        common = new Common(this);
        toolbar = (Toolbar) findViewById(R.id.toolbarMasDetalles);
        nombreAlumno = (TextView) findViewById(R.id.nombreAlumno);
        creditos = (TextView) findViewById(R.id.creditos);
        estatus = (TextView) findViewById(R.id.estatus);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

       alumno = new Alumnos(PerfilActivity.this);

       Bundle b = getIntent().getExtras();
       boolean Bolroot = false;
       if(b!=null){
            try{
                int root = b.getInt("root");
                if(root==1){
                    Bolroot = true;
                }else{
                    Bolroot = false;
                }
            }catch (Exception e){
                Bolroot = false;
            }
       }
        int idAlumnoSession = 0;
        if(!Bolroot){
            idAlumnoSession = alumno.obtenerIdSession();
        }else{
            try{
                idAlumnoSession = b.getInt("idAlumno");
            }catch (Exception e){
                idAlumnoSession = 0;
            }
        }

        if(idAlumnoSession>0){
            alumno = alumno.buscarAlumnoPorId(idAlumnoSession);
            if(alumno!=null){
                nombreAlumno.setText(alumno.getvNombreAlumno());
                creditos.setText(alumno.getiCreditos());

            }
        }else{
            iniciarActividad(MainActivity.class);
            this.finish();
        }
    }



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                common.dialogoSalir();
            break;
            case R.id.mostrarAlumnos:
                iniciarActividad(mostrarAlumnosActivity.class);
                break;
        }
        return true;
    }

    public void onBackPressed(){
        common.dialogoSalir();
    }

    private void iniciarActividad(Class<?> clase){
        Intent intent = new Intent(PerfilActivity.this,clase);
        startActivity(intent);
    }
}
