package com.example.miguelr.seguimientoresidencias.Helper;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.provider.CallLog;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.miguelr.seguimientoresidencias.DataBase.Tables.Alumnos;
import com.example.miguelr.seguimientoresidencias.DataBase.Tables.DataBaseStructure;
import com.example.miguelr.seguimientoresidencias.MainActivity;
import com.example.miguelr.seguimientoresidencias.PerfilActivity;
import com.example.miguelr.seguimientoresidencias.R;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * Created by miguelr on 11/03/2018.
 */

public class Common {
    private Context context;
    public Common(Context context){
        this.context = context;
    }

    public AlertDialog dialogErrorLogin(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);


        builder.setPositiveButton("SI",null);

        LayoutInflater inflater = LayoutInflater.from(context);

        View v = (View) inflater.inflate(R.layout.login_error,null);

        builder.setView(v);

        TextView txt1 = (TextView) v.findViewById(R.id.errorLogin);
        String mensaje1 = context.getString(R.string.errorLogin);
        Spanned htmlAsApanned = Html.fromHtml(mensaje1);
        txt1.setText(htmlAsApanned);

        return builder.create();

    }

    public boolean solicitarPermisosEscritura() {
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return true;
        }
        if(context.checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        if( ((Activity)context).shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)){
            dialogoRecomendacion();
        }else{
            ((Activity)context).requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE},100);
        }
        return false;
    }

    public void dialogoRecomendacion(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(context.getString(R.string.tituloPermisos));
        dialog.setMessage(context.getString(R.string.mensajePermisos));
        dialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ((Activity)context).requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE},100);
                }
            }
        });
        dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((Activity)context).finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        dialog.show();

    }

    public void dialogoSalir(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(context.getString(R.string.tituloSalir));
        dialog.setMessage(context.getString(R.string.mensajeSalir));
        dialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cerrarSession();
                ((Activity)context).finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        dialog.setNegativeButton("NO",null);
        dialog.show();
    }
    public boolean cerrarSession(){
        Alumnos alumno = new Alumnos(context);
        return alumno.cerrarSession();
    }


}
