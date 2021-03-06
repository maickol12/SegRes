package com.example.miguelr.seguimientoresidencias.DataBase.Tables;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.miguelr.seguimientoresidencias.Helper.config;

/**
 * Created by miguelr on 08/04/2018.
 */

public class cartaDePresentacion {
    private String idCartaPresentacion        = "idCartaPresentacion";
    private String dFechaCaptura              = "dFechaCaptura";
    private String vUsuarioCaptura            = "vUsuarioCaptura";
    private String dFechaModifica             = "dFechaModifica";
    private String vUsuarioModifca            = "vUsuarioModifica";
    private String IidAlumno                  = "IidAlumnofk";
    private String bActive                    = "bActive";
    private String tableName                  = "cartaPresentacion";
    private Context context;


    public cartaDePresentacion obtenerCartaPresentacionPorAlumno(String idAlumno){

        SQLiteDatabase db = dbRedeable();
        cartaDePresentacion cdp = null;
        Cursor c = null;
        String sql = "SELECT "+this.getIdCartaPresentacion()+","+this.getdFechaCaptura()+" " +
                     "FROM "+this.getTableName()+"" +
                     " WHERE "+this.getIidAlumno()+" = '"+idAlumno+"'";
        try{
            c = db.rawQuery(sql,null);
            if(c.moveToFirst()){
                cdp = new cartaDePresentacion();
                cdp.setIdCartaPresentacion(c.getString(0));
                cdp.setdFechaCaptura(c.getString(1));
            }
        }catch (Exception e){
            cdp = null;
        }

        return cdp;
    }

    public boolean llenarDefaultCartaPresentacion(){
        SQLiteDatabase db = dbWritable();
        ContentValues cv = new ContentValues();
        cv.put(getIdCartaPresentacion(),1);
        cv.put(getdFechaCaptura(),"2018-04-11");
        cv.put(getvUsuarioCaptura(),"miguelr");
        cv.put(getdFechaModifica(),"2018-04-11");
        cv.put(getvUsuarioModifca(),"miguelr");
        cv.put(getIidAlumno(),1);
        cv.put(getbActive(),1);
        db.delete(this.getTableName(),null,null);
        try{
            return db.insert(getTableName(),null,cv)>0;
        }catch (Exception e){
            Log.d("errordb",e.getMessage());
            return false;
        }
    }


    public cartaDePresentacion(){}
    public cartaDePresentacion(Context context){
        this.context = context;
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
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getIdCartaPresentacion() {
        return idCartaPresentacion;
    }

    public void setIdCartaPresentacion(String idCartaPresentacion) {
        this.idCartaPresentacion = idCartaPresentacion;
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

    public String getvUsuarioModifca() {
        return vUsuarioModifca;
    }

    public void setvUsuarioModifca(String vUsuarioModifca) {
        this.vUsuarioModifca = vUsuarioModifca;
    }

    public String getIidAlumno() {
        return IidAlumno;
    }

    public void setIidAlumno(String iidAlumno) {
        IidAlumno = iidAlumno;
    }

    public String getbActive() {
        return bActive;
    }

    public void setbActive(String bActive) {
        this.bActive = bActive;
    }
}
