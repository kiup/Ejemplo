/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import archivo.MonitorArchivo;
import excepciones.ArchivoConfigBDNoEncontradaException;
import excepciones.ArchivoConfiguracionNoEncontradoExcepcion;
import excepciones.MapeoErroneoExcepcion;
import excepciones.MapeoInexistenteExcepcion;
import excepciones.NotAvailableConnectionsException;
import excepciones.ObjetoErroneoExcepcion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapeo.MapeadorObjetoRelacional;
import pool.MonitorArchivoConfiguracion;
import pool.PoolConnection;

/**
 *
 * @author Milka
 */
public class AlumnoDAO {
    
    private String rutaArchivoMapeo = "configuracionMapeo.xml";
    private String rutaArchivoBD = "configuracion-bd.xml";
    private String rutaArchivoPool = "archivoConfiguracion.xml";
    private MonitorArchivo monitor;
    
    public AlumnoDAO(){
        inicializarMonitorArchivo();
    }
    
    public void inicializarMonitorArchivo(){
        try {
            monitor = new MonitorArchivo("monitor1", rutaArchivoBD );
            monitor.start();
        } catch (ArchivoConfigBDNoEncontradaException ex) {

        }
    }
    
    public void insertarAlumno(Alumno alumno){
        
        MonitorArchivoConfiguracion monitorPool = new MonitorArchivoConfiguracion("pool", rutaArchivoPool);
        monitorPool.start();
        
        PoolConnection poolConnection = null;
        monitorPool.getAdminPool().initializePoolConnections();
        try {
            poolConnection = monitorPool.getAdminPool().getPoolConnection();
        } catch (NotAvailableConnectionsException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String consulta  = "insert into alumno values("+
                "\""+alumno.getMatricula()+"\","+
                "\""+alumno.getNombre()+"\","+
                "\""+alumno.getDireccion()+"\","+
                "\""+alumno.getTelefono()+"\","+
                "\""+alumno.getCarrera()+"\")";
        
        try {
            poolConnection.insertQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        poolConnection.close();
    }
    
    public void actualizarAlumno(Alumno alumno){
        MonitorArchivoConfiguracion monitorPool = new MonitorArchivoConfiguracion("pool", rutaArchivoPool);
        monitorPool.start();
        
        PoolConnection poolConnection = null;
        monitorPool.getAdminPool().initializePoolConnections();
        try {
            poolConnection = monitorPool.getAdminPool().getPoolConnection();
        } catch (NotAvailableConnectionsException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String consulta  = "insert into alumno values("+
                "\""+alumno.getMatricula()+"\","+
                "\""+alumno.getNombre()+"\","+
                "\""+alumno.getDireccion()+"\","+
                "\""+alumno.getTelefono()+"\","+
                "\""+alumno.getCarrera()+"\")";
        
        try {
            poolConnection.insertQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        poolConnection.close();
    }
    
    public ArrayList<Alumno> obtenerAlumnos(){

        MonitorArchivoConfiguracion monitorPool = new MonitorArchivoConfiguracion("pool", rutaArchivoPool);
        monitorPool.start();
        
        PoolConnection poolConnection = null;
        monitorPool.getAdminPool().initializePoolConnections();
        try {
            poolConnection = monitorPool.getAdminPool().getPoolConnection();
        } catch (NotAvailableConnectionsException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        MapeadorObjetoRelacional mapeador = null;
        try {
           mapeador = new MapeadorObjetoRelacional(rutaArchivoMapeo);
        } catch (ArchivoConfiguracionNoEncontradoExcepcion ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        ArrayList<Alumno> alumnos =  null;
        try {
            mapeador.mapearObjetosRelacion("modelo.Alumno", poolConnection);
             alumnos = mapeador.getListaObjetos();
        } catch (MapeoInexistenteExcepcion ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ObjetoErroneoExcepcion ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MapeoErroneoExcepcion ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        poolConnection.close();
        return alumnos;
    }
}
