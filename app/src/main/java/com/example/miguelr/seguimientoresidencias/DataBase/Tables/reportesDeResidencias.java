package com.example.miguelr.seguimientoresidencias.DataBase.Tables;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.miguelr.seguimientoresidencias.Helper.config;

import java.util.ArrayList;

/**
 * Created by miguelr on 08/04/2018.
 */

public class reportesDeResidencias {
    private String TableName = "reportesDeResidencias";
    public String iIdReporte = "iIdReporte";
    public String vUsuarioCaptura = "vUsuarioCaptura";
    public String dFechaCaptura = "dFechaCaptura";
    public String vUsuarioModifica = "vUsuarioModifica";
    public String dFechaModifica = "dFechaModifica";
    public String iIdSolicitudfk = "iIdSolicitudfk";
    public String iAprobadoAcesorInterno = "iAprobadoAcesorInterno";
    public String iAprobadoJefeDeCarrera = "iAprobadoJefeDeCarrera";
    public String iHojaAsesoria = "iHojaAsesoria";
    public String vNumeroReporte  = "vNumeroReporte";
    public String vDescripcion = "vDescripcion";
    public String dFechaEntrega = "dFechaEntrega";
    public String bActive = "bActive";
    public String reporteDeResidencias = "reporteDeResidencias";
    public Context context;


    public reportesDeResidencias(){}
    public reportesDeResidencias(Context context){
        this.context = context;
    }

    public ArrayList<reportesDeResidencias> obtenerReportesPorSolicitud(String idSolicitud){
        ArrayList<reportesDeResidencias> reportesDeResidenciasList = null;
        SQLiteDatabase db = null;
        String sql = "SELECT "+this.getdFechaCaptura()+","+this.getiAprobadoAcesorInterno()+","+this.getiAprobadoJefeDeCarrera()+"," +
                     ""+this.getiHojaAsesoria()+","+this.getvNumeroReporte()+" " +
                     "FROM "+this.getTableName()+" WHERE "+this.getiIdSolicitudfk()+" = '"+idSolicitud+"'" +
                     " ORDER BY "+this.getvNumeroReporte();
        Cursor c = null;
        try{
            db = dbRedeable();
            c = db.rawQuery(sql,null);
            if(c.moveToFirst()){
                reportesDeResidenciasList = new ArrayList<>();
                reportesDeResidencias reporte = null;
                do{
                    reporte = new reportesDeResidencias();
                    reporte.setdFechaCaptura(c.getString(0));
                    reporte.setiAprobadoAcesorInterno(c.getString(1));
                    reporte.setiAprobadoJefeDeCarrera(c.getString(2));
                    reporte.setiHojaAsesoria(c.getString(3));
                    reporte.setvNumeroReporte(c.getString(4));
                    reportesDeResidenciasList.add(reporte);

                }while (c.moveToNext());
            }
        }catch (Exception e){

        }
        return reportesDeResidenciasList;
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

    public String getiIdReporte() {
        return iIdReporte;
    }

    public void setiIdReporte(String iIdReporte) {
        this.iIdReporte = iIdReporte;
    }

    public String getvUsuarioCaptura() {
        return vUsuarioCaptura;
    }

    public void setvUsuarioCaptura(String vUsuarioCaptura) {
        this.vUsuarioCaptura = vUsuarioCaptura;
    }

    public String getdFechaCaptura() {
        return dFechaCaptura;
    }

    public void setdFechaCaptura(String dFechaCaptura) {
        this.dFechaCaptura = dFechaCaptura;
    }

    public String getvUsuarioModifica() {
        return vUsuarioModifica;
    }

    public void setvUsuarioModifica(String vUsuarioModifica) {
        this.vUsuarioModifica = vUsuarioModifica;
    }

    public String getdFechaModifica() {
        return dFechaModifica;
    }

    public void setdFechaModifica(String dFechaModifica) {
        this.dFechaModifica = dFechaModifica;
    }

    public String getiIdSolicitudfk() {
        return iIdSolicitudfk;
    }

    public void setiIdSolicitudfk(String iIdSolicitudfk) {
        this.iIdSolicitudfk = iIdSolicitudfk;
    }

    public String getiAprobadoAcesorInterno() {
        return iAprobadoAcesorInterno;
    }

    public void setiAprobadoAcesorInterno(String iAprobadoAcesorInterno) {
        this.iAprobadoAcesorInterno = iAprobadoAcesorInterno;
    }

    public String getiAprobadoJefeDeCarrera() {
        return iAprobadoJefeDeCarrera;
    }

    public void setiAprobadoJefeDeCarrera(String iAprobadoJefeDeCarrera) {
        this.iAprobadoJefeDeCarrera = iAprobadoJefeDeCarrera;
    }

    public String getiHojaAsesoria() {
        return iHojaAsesoria;
    }

    public void setiHojaAsesoria(String iHojaAsesoria) {
        this.iHojaAsesoria = iHojaAsesoria;
    }

    public String getvNumeroReporte() {
        return vNumeroReporte;
    }

    public void setvNumeroReporte(String vNumeroReporte) {
        this.vNumeroReporte = vNumeroReporte;
    }

    public String getvDescripcion() {
        return vDescripcion;
    }

    public void setvDescripcion(String vDescripcion) {
        this.vDescripcion = vDescripcion;
    }

    public String getdFechaEntrega() {
        return dFechaEntrega;
    }

    public void setdFechaEntrega(String dFechaEntrega) {
        this.dFechaEntrega = dFechaEntrega;
    }

    public String getbActive() {
        return bActive;
    }

    public void setbActive(String bActive) {
        this.bActive = bActive;
    }
}
