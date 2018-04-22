package com.example.miguelr.seguimientoresidencias.DataBase.Tables;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.miguelr.seguimientoresidencias.Helper.config;

/**
 * Created by miguelr on 09/04/2018.
 */

public class cartaAceptacion {
    private String TableName            = "cartaAceptacion";
    private String idcartaAceptacion    = "idcartaAceptacion";
    private String dFechaCaptura        = "dFechaCaptura";
    private String vUsuarioCaptura      = "vUsuarioCaptura";
    private String dFechaModifica       = "dFechaModifica";
    private String vUsuarioModifica     = "vUsuarioModifica";
    private String iIdAlumno            = "iIdAlumnofk";
    private String bActive              = "bActive";
    private Context context;

    public cartaAceptacion(){}
    public cartaAceptacion(Context context){
        this.context = context;
    }

    public cartaAceptacion buscarCartaDeAceptacionPorAlumno(String idAlumno){
        SQLiteDatabase db = dbRedeable();
        Cursor c = null;
        cartaAceptacion ca = null;
        String sql = "SELECT "+this.getdFechaCaptura()+","+this.getIdcartaAceptacion()+" " +
                     "FROM "+this.getTableName()+" WHERE "+this.getiIdAlumno()+" = '"+idAlumno+"'";
        try{
            c = db.rawQuery(sql,null);
            if(c.moveToFirst()){
                ca = new cartaAceptacion();
                ca.setdFechaCaptura(c.getString(0));
                ca.setIdcartaAceptacion(c.getString(1));
            }
        }catch (Exception e){
            ca = null;
        }
        return ca;
    }

    public boolean llenarDefaultCartaAceptacion(){
        SQLiteDatabase db = dbWritable();
        ContentValues cv = new ContentValues();
        cv.put(getIdcartaAceptacion(),1);
        cv.put(getdFechaCaptura(),"2018-04-11");
        cv.put(getvUsuarioCaptura(),"miguelr");
        cv.put(getdFechaModifica(),"2018-04-11");
        cv.put(getvUsuarioModifica(),"miguelr");
        cv.put(getiIdAlumno(),1);
        cv.put(getbActive(),1);
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

    public String getIdcartaAceptacion() {
        return idcartaAceptacion;
    }

    public void setIdcartaAceptacion(String idcartaAceptacion) {
        this.idcartaAceptacion = idcartaAceptacion;
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    public String getdFechaCaptura() {
        return dFechaCaptura;
    }

    public void setdFechaCaptura(String dFechaCaptura) {
        this.dFechaCaptura = dFechaCaptura;
    }

    public String getvUsuarioCaptura() {
        return vUsuarioCaptura;
    }

    public void setvUsuarioCaptura(String vUsuarioCaptura) {
        this.vUsuarioCaptura = vUsuarioCaptura;
    }

    public String getdFechaModifica() {
        return dFechaModifica;
    }

    public void setdFechaModifica(String dFechaModifica) {
        this.dFechaModifica = dFechaModifica;
    }

    public String getvUsuarioModifica() {
        return vUsuarioModifica;
    }

    public void setvUsuarioModifica(String vUsuarioModifica) {
        this.vUsuarioModifica = vUsuarioModifica;
    }

    public String getiIdAlumno() {
        return iIdAlumno;
    }

    public void setiIdAlumno(String iIdAlumno) {
        this.iIdAlumno = iIdAlumno;
    }

    public String getbActive() {
        return bActive;
    }

    public void setbActive(String bActive) {
        this.bActive = bActive;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
