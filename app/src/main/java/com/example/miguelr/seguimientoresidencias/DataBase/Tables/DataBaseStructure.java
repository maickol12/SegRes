package com.example.miguelr.seguimientoresidencias.DataBase.Tables;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by miguelr on 06/02/2018.
 */

public class DataBaseStructure extends SQLiteOpenHelper{

    /****************************************************************************************************************
     * TABLA DE Alumnos
     ****************************************************************************************************************/
    public static String TableNameAlumnos                            =               "alumnos";

    private String iIdAlumno                                         =               "iIdAlumno";
    private String vNombreAlumno                                     =               "vNombreAlumno";
    private String vApellidoPaterno                                  =               "vApellidoPaterno";
    private String vApellidoMaterno                                  =               "vApellidoMaterno";
    private String vMatricula                                        =               "vMatricula";
    private String vCorreo                                           =               "vCorreo";
    private String vContrasenia                                      =               "vContrasenia";
    private String iIdCarrerafk                                      =               "iIdCarrerafk";
    private String iServicioSocial                                   =               "iServicioSocial";
    private String iAsignaturasEnEspecial                            =               "iAsignaturasEnEspecial";
    private String iCreditosRequeridos                               =               "iCreditosRequeridos";
    private String iCreditosAlumno                                   =               "iCreditos";
    private String iSexo                                             =               "iSexo";
    private String dInicioServicio                                   =               "dInicioServicio";
    private String dFinServicio                                      =               "dFinServicio";
    private String vUsuarioCapturaAlumno                             =               "vUsuarioCaptura";
    private String dFechaCapturaAlumno                               =               "dFechaCaptura";
    private String vUsuarioModificaAlumno                            =               "vUsuarioModifica";
    private String dFechaModificaAlumno                              =               "dFechaModifica";
    private String bActiveAlumno                                     =               "bActive";

     /****************************************************************************************************************
     * FIN TABLA DE USUARIOS
     ****************************************************************************************************************/



    /****************************************************************************************************************
     * TABLA DE CARRERAS
     ****************************************************************************************************************/
    private String TableNameCarreras                                  =               "carreras";

    private String iIdcarrera                                         =               "iIdcarrera";
    private String vNombreCarrera                                     =               "vNombreCarrera";
    private String iCreditos                                          =               "iCreditos";
    private String bActiveCarrera                                      =               "bActive";


    /****************************************************************************************************************
     * FIN TABLA DE CARRERAS
     ****************************************************************************************************************/


    /****************************************************************************************************************
     * TABLA DE CARTAPRESENTACION
     ****************************************************************************************************************/

    private String TableNameCartaPresentacion                         =                "cartaPresentacion";

    private String idCartaPresentacion                                =                 "idCartaPresentacion";
    private String dFechaCapturaCartaPresentacion                     =                 "dFechaCaptura";
    private String vUsuarioCapturaCartaPresentacion                   =                 "vUsuarioCaptura";
    private String dFechaModificaCartaPresentacion                    =                 "dFechaModifica";
    private String vUsuarioModificaCartaPresentacion                  =                 "vUsuarioModifica";
    private String IidAlumnofkCartaPresentacion                       =                 "IidAlumnofk";
    private String bActiveCartaPresentacion                           =                 "bActive";


    /****************************************************************************************************************
     * FIN TABLA DE CARTAPRESENTACION
     ****************************************************************************************************************/

    /****************************************************************************************************************
     * TABLA DE ACEPTACION
     ****************************************************************************************************************/

    private String TableNameCartaAceptacion                         =                "cartaAceptacion";

    private String idCartaAceptacion                                =                 "idcartaAceptacion";
    private String dFechaCapturaCartaAceptacion                     =                 "dFechaCaptura";
    private String vUsuarioCapturaCartaAceptacion                   =                 "vUsuarioCaptura";
    private String dFechaModificaCartaAceptacion                    =                 "dFechaModifica";
    private String vUsuarioModificaCartaAceptacion                  =                 "vUsuarioModifica";
    private String IidAlumnofkCartaAceptacion                       =                 "IidAlumnofk";
    private String bActiveCartaAceptacion                           =                 "bActive";


    /****************************************************************************************************************
     * FIN TABLA DE ACEPTACION
     ****************************************************************************************************************/



    /****************************************************************************************************************
     * TABLA DE SolicitudDeResidencias
     ****************************************************************************************************************/
     private String TableNameSolicitudDeResidencias                   =                   "solicitudDeResidencias";

     private String iIdSolicitudDeResidencias                         =                   "iIdSolicitudDeResidencias";
     private String iIdAlumnofkSolicitudDeResidencias                 =                   "iIdAlumnofk";
     private String iAprobadoPorAcademiaSolicitudResidencias          =                   "iAprobadoPorAcademia";
     private String iAprobadoPorJefeDeCarreraSolicitudDeResidencias   =                   "iAprobadoPorJefeDeCarrera";
     private String dFechaAprobacionSolicitudDeResidencias            =                   "dFechaAprobacion";


    /****************************************************************************************************************
     * FIN TABLA DE SolicitudDeResidencias
     ****************************************************************************************************************/


    /****************************************************************************************************************
     * TABLA DE ObservacionesDeSolicitudResidencias
     ****************************************************************************************************************/
    private String TableNameObservacionesDeSolicitudResidencias       =                    "observacionesDeSolicitudResidencias";

    private String iIdObservaciones                                   =                     "iIdObservaciones";
    private String vDescripcionObservaciones                          =                     "vDescripcion";
    private String iIdSolicitudDeResidenciasObservaciones             =                     "IdSolicitudDeResidencias";



    /****************************************************************************************************************
     * FIN TABLA DE ObservacionesDeSolicitudResidencias
     ****************************************************************************************************************/

    /****************************************************************************************************************
     * TABLA DE expedienteFinal
     ****************************************************************************************************************/

    private String TableNameExpedienteFinal                          =                          "expedienteFinal";

    private String iIdexpedienteFinal                                =                          "iIdexpedienteFinal";
    private String vDescripcionExpedienteFinal                       =                          "vDescripcion";
    private String iProcesoFinalizadoExpedienteFinal                 =                          "iProcesoFinalizado";
    private String iCalificacionExpedienteFinal                      =                          "iCalificacion";
    private String iIdSolicitudResidenciasfkExpedienteFinal          =                          "iIdSolicitudResidenciasfk";



    /****************************************************************************************************************
     * FIN TABLA DE expedienteFinal
     ****************************************************************************************************************/

    /****************************************************************************************************************
     * TABLA DE reportesDeResidencias
     ****************************************************************************************************************/
     private String TableNameReportesDeResidencias                     =                            "reportesDeResidencias";

    private String  iIdReporte                                         =                            " iIdReporte";
     private String  vUsuarioCapturaReportesDeResidencias              =                            " vUsuarioCaptura";
     private String  dFechaCapturaReportesDeResidencias                =                            "dFechaCaptura";
     private String  vUsuarioModificaReportesDeResidencias             =                            "vUsuarioModifica";
     private String  dFechaModificaReportesDeResidencia                =                            "dFechaModificaE";
     private String  iIdSolicitudfkReportesDeResidencia                =                            "iIdSolicitudfk";
     private String  iAprobadoAcesorInternoReportesDeResidencia        =                            "iAprobadoAcesorInterno";
     private String  iAprobadoJefeDeCarreraReportesDeResidencia        =                            "iAprobadoJefeDeCarrera";
     private String  iIdReportefkReportesDeResidencia                  =                            "iIdReportefk";
     private String  iHojaAsesoriaReportesDeResidencia                 =                            "iHojaAsesoria";
     private String vNumeroReporteReportesDeResidencia                 =                            "vNumeroReporte";
     private String vDescripcionReportesDeResidencia                   =                            "vDescripcion";
     private String dFechaEntregaReportesDeResidencia                  =                            "dFechaEntrega";
     private String  bActiveReportesDeResidencia                       =                            "bActive";



    /****************************************************************************************************************
     * FIN TABLA DE reportesDeResidencias
     ****************************************************************************************************************/


    /****************************************************************************************************************
     * TABLA DE Usuarios
     ****************************************************************************************************************/

    private String TableNameUsuarios                                  =                          "Usuarios";

    private String iIdUsuario                                         =                          "iIdUsuario";
    private String vApellidoPaternoUsuario                            =                          "vApellidoPaternoUsuario";
    private String vApellidoMaternoUsuario                            =                          "vApellidoMaternoUsuario";
    private String vCorreoUsuario                                     =                          "vCorreoUsuario";
    private String vContraseniaUsuario                                =                          "vContraseniaUsuario";
    private String vUsuario                                           =                          "vUsuario";
    private String bActiveUsuario                                     =                          "bActiveUsuario";



    /****************************************************************************************************************
     * FIN TABLA DE Usuarios
     ****************************************************************************************************************/


    /*****************************************************************************************************************+
     * CREACION DE TABLAS
     ********************************************************************************************************************/
    private String alumnos = "" +
            "CREATE TABLE "+TableNameAlumnos+"(" +
            iIdAlumno+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            vNombreAlumno+" TEXT NOT NULL," +
            vApellidoPaterno+" TEXT NOT NULL," +
            vApellidoMaterno+" TEXT NOT NULL," +
            vMatricula+" TEXT NOT NULL," +
            vCorreo+" TEXT," +
            vContrasenia+" TEXT NOT NULL," +
            iIdCarrerafk+" INTEGER NOT NULL," +
            iServicioSocial+" INTEGER NOT NULL DEFAULT 1," +
            iAsignaturasEnEspecial+" INTEGERT NOT NULL DEFAULT 0," +
            iCreditosRequeridos+" INTEGER NOT NULL DEFAULT 1," +
            iCreditosAlumno+" INTEGER DEFAULT 0," +
            iSexo+" TEXT," +
            dInicioServicio+" TEXT," +
            dFinServicio+" TEXT," +
            vUsuarioCapturaAlumno+" TEXT," +
            dFechaCapturaAlumno+" TEXT," +
            vUsuarioModificaAlumno+" TEXT," +
            dFechaModificaAlumno+" TEXT," +
            bActiveAlumno+" INTEGER DEFAULT 1," +
            "FOREIGN KEY("+iIdCarrerafk+")REFERENCES "+TableNameCarreras+"("+iIdcarrera+")" +
            ")";


    private String carreras = "" +
            "CREATE TABLE "+TableNameCarreras+"(" +
            iIdcarrera+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            vNombreCarrera+" TEXT NOT NULL," +
            iCreditos+" INTEGER," +
            bActiveCarrera+" INTEGER DEFAULT 1" +
            ")";


    private String cartaPresentacion = "CREATE TABLE "+TableNameCartaPresentacion+"(" +
            idCartaPresentacion+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            dFechaCapturaCartaPresentacion+" TEXT," +
            vUsuarioCapturaCartaPresentacion+" TEXT," +
            dFechaModificaCartaPresentacion+" TEXT," +
            vUsuarioModificaCartaPresentacion+" TEXT," +
            IidAlumnofkCartaPresentacion+" INTEGER," +
            bActiveCartaPresentacion+" INTEGER DEFAULT 1," +
            "FOREIGN KEY("+IidAlumnofkCartaPresentacion+")REFERENCES "+TableNameCartaPresentacion+"("+iIdAlumno+")" +
            ")";


    private String cartaAceptacion = "CREATE TABLE "+TableNameCartaAceptacion+"(" +
            idCartaAceptacion+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            dFechaCapturaCartaAceptacion+" TEXT," +
            vUsuarioCapturaCartaAceptacion+" TEXT," +
            dFechaModificaCartaAceptacion+" TEXT," +
            vUsuarioModificaCartaAceptacion+" TEXT," +
            IidAlumnofkCartaAceptacion+" INTEGER," +
            bActiveCartaAceptacion+" INTEGER DEFAULT 1," +
            "FOREIGN KEY("+IidAlumnofkCartaAceptacion+")REFERENCES "+TableNameCartaPresentacion+"("+iIdAlumno+")" +
            ")";


    private String solicitudDeResidencias = "CREATE TABLE "+TableNameSolicitudDeResidencias+"(" +
            iIdSolicitudDeResidencias+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            iIdAlumnofkSolicitudDeResidencias+" INTEGER," +
            iAprobadoPorAcademiaSolicitudResidencias+" INTEGER DEFAULT 1," +
            iAprobadoPorJefeDeCarreraSolicitudDeResidencias+" INTEGER DEFAULT 1," +
            dFechaAprobacionSolicitudDeResidencias+" TEXT," +
            "FOREIGN KEY("+iIdAlumnofkSolicitudDeResidencias+") REFERENCES "+TableNameAlumnos+"("+iIdAlumno+")" +
            ")";

    private String observacionesDeSolicitudResidencias = "CREATE TABLE "+TableNameObservacionesDeSolicitudResidencias+"(" +
            iIdObservaciones+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            vDescripcionObservaciones+" TEXT," +
            iIdSolicitudDeResidenciasObservaciones+" INTEGER," +
            "FOREIGN KEY ("+iIdSolicitudDeResidenciasObservaciones+") REFERENCES "+TableNameObservacionesDeSolicitudResidencias+"("+iIdObservaciones+")" +
            ")";

    private String expedienteFinal = "CREATE TABLE "+TableNameExpedienteFinal+"(" +
            iIdexpedienteFinal+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            vDescripcionExpedienteFinal+" TEXT," +
            iProcesoFinalizadoExpedienteFinal+" INTEGER DEFAULT 0," +
            iCalificacionExpedienteFinal+" INTEGER DEFAULT 0," +
            iIdSolicitudResidenciasfkExpedienteFinal+" INTEGER," +
            "FOREIGN KEY ("+iIdSolicitudResidenciasfkExpedienteFinal+") REFERENCES "+TableNameSolicitudDeResidencias+"("+iIdSolicitudDeResidencias+")" +
            ")";


    private String reportesDeResidencias = "CREATE TABLE "+TableNameReportesDeResidencias+"(" +
            iIdReporte+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            vUsuarioCapturaReportesDeResidencias+" TEXT," +
            dFechaCapturaReportesDeResidencias+" TEXT," +
            vUsuarioModificaReportesDeResidencias+" TEXT," +
            dFechaModificaReportesDeResidencia+" TEXT," +
            iIdSolicitudfkReportesDeResidencia+" INTEGER," +
            iAprobadoAcesorInternoReportesDeResidencia+" INTEGER," +
            iAprobadoJefeDeCarreraReportesDeResidencia+" INTEGER," +
            iIdReportefkReportesDeResidencia+" INTEGER," +
            iHojaAsesoriaReportesDeResidencia+" INTEGER," +
            vNumeroReporteReportesDeResidencia+" TEXT," +
            vDescripcionReportesDeResidencia+" TEXT," +
            dFechaEntregaReportesDeResidencia+" TEXT," +
            bActiveReportesDeResidencia+" INTEGER DEFAULT 1," +
            "FOREIGN KEY ("+iIdSolicitudfkReportesDeResidencia+") REFERENCES "+TableNameReportesDeResidencias+"("+iIdSolicitudDeResidencias+")" +
            ")";

    private String Usuarios = "CREATE TABLE "+TableNameUsuarios+"(" +
            iIdUsuario+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            vApellidoPaternoUsuario+" TEXT," +
            vApellidoMaternoUsuario+" TEXT," +
            vCorreoUsuario+" TEXT," +
            vContraseniaUsuario+" TEXT" +
            vUsuario+" TEXT" +
            bActiveUsuario+" INTEGER DEFAULT 1" +
            ")";


    public DataBaseStructure(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(alumnos);
        db.execSQL(carreras);
        db.execSQL(cartaPresentacion);
        db.execSQL(solicitudDeResidencias);
        db.execSQL(observacionesDeSolicitudResidencias);
        db.execSQL(expedienteFinal);
        db.execSQL(reportesDeResidencias);
        db.execSQL(Usuarios);
        db.execSQL(cartaAceptacion);


        llenarDatos(db);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TableNameAlumnos);
        db.execSQL("DROP TABLE IF EXISTS "+TableNameCarreras);
        db.execSQL("DROP TABLE IF EXISTS "+TableNameCartaPresentacion);
        db.execSQL("DROP TABLE IF EXISTS "+TableNameSolicitudDeResidencias);
        db.execSQL("DROP TABLE IF EXISTS "+TableNameObservacionesDeSolicitudResidencias);
        db.execSQL("DROP TABLE IF EXISTS "+TableNameExpedienteFinal);
        db.execSQL("DROP TABLE IF EXISTS "+TableNameReportesDeResidencias);
        db.execSQL("DROP TABLE IF EXISTS "+TableNameUsuarios);
        db.execSQL("DROP TABLE IF EXISTS "+TableNameCartaAceptacion);
        Log.d("DBUPDATE","DBUPDATE");
        this.onCreate(db);
    }

    private void llenarDatos(SQLiteDatabase db){
        ContentValues cv2 = new ContentValues();
        cv2.put(vNombreCarrera,"Sistemas");
        cv2.put(iCreditos,200);
        db.insert(TableNameCarreras,null,cv2);

        ContentValues values = new ContentValues();
        values.put(vNombreAlumno,"maickol");
        values.put(vApellidoMaterno,"rodriguez");
        values.put(vApellidoPaterno,"cornejo");
        values.put(vMatricula,"14020463");
        values.put(vCorreo,"al14020463@itsa.edu.mx");
        values.put(vContrasenia,"123");
        values.put(iIdCarrerafk,1);
        values.put(iServicioSocial,1);
        values.put(iAsignaturasEnEspecial,0);
        values.put(iCreditosRequeridos,1);
        values.put(iSexo,1);
        values.put(dInicioServicio,"10-03-2018");
        values.put(dFinServicio,"10-06-2018");
        db.insert(TableNameAlumnos,null,values);

        db.insert(TableNameAlumnos,null,values);


    }



}
