package com.example.miguelr.seguimientoresidencias.DataBase.Tables;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.miguelr.seguimientoresidencias.Helper.config;

/**
 * Created by miguelr on 08/04/2018.
 */

public class expedienteFinal {
    public String iIdExpedienteFinal = "iIdExpedienteFinal";
    public String vDescripcion = "vDescripcion";
    public String iProcesoFinalizado = "iProcesoFinalizado";
    public String iCalificacion = "iCalificacion";
    public String iIdSolicitudResidenciasfk = "iIdSolicitudResidenciasfk";
    public String TableName =  "expedienteFinal";
    public Context context;

    public expedienteFinal(){}
    public expedienteFinal(Context context){
        this.context = context;
    }

    public boolean llenarExpedienteDefault(){
        ContentValues cv = new ContentValues();
        cv.put(getiIdExpedienteFinal(),1);
        cv.put(getvDescripcion(),"Todo con exito");
        cv.put(getiProcesoFinalizado(),1);
        cv.put(getiCalificacion(),90);
        cv.put(getiIdSolicitudResidenciasfk(),1);
        SQLiteDatabase db = dbWritable();
        db.delete(this.getTableName(),null,null);
        try{
            return db.insert(getTableName(),null,cv)>0;
        }catch (Exception e){
            return false;
        }
    }

    public SQLiteDatabase dbRedeable(){
        DataBaseStructure help = new DataBaseStructure(context, config.dbName,null,config.versionDB);
        SQLiteDatabase db = help.getReadableDatabase();
        return db;
    }
    public SQLiteDatabase dbWritable(){
        DataBaseStructure help = new DataBaseStructure(context, config.dbName,null,config.versionDB);
        SQLiteDatabase db = help.getWritableDatabase();
        return db;
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    public String getiIdExpedienteFinal() {
        return iIdExpedienteFinal;
    }

    public void setiIdExpedienteFinal(String iIdExpedienteFinal) {
        this.iIdExpedienteFinal = iIdExpedienteFinal;
    }

    public String getvDescripcion() {
        return vDescripcion;
    }

    public void setvDescripcion(String vDescripcion) {
        this.vDescripcion = vDescripcion;
    }

    public String getiProcesoFinalizado() {
        return iProcesoFinalizado;
    }

    public void setiProcesoFinalizado(String iProcesoFinalizado) {
        this.iProcesoFinalizado = iProcesoFinalizado;
    }

    public String getiCalificacion() {
        return iCalificacion;
    }

    public void setiCalificacion(String iCalificacion) {
        this.iCalificacion = iCalificacion;
    }

    public String getiIdSolicitudResidenciasfk() {
        return iIdSolicitudResidenciasfk;
    }

    public void setiIdSolicitudResidenciasfk(String iIdSolicitudResidenciasfk) {
        this.iIdSolicitudResidenciasfk = iIdSolicitudResidenciasfk;
    }
}
