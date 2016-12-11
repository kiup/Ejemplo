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
    
    Conexion conexion;
    private String rutaArchivoMapeo = "configuracionMapeo.xml";
    
    public AlumnoDAO(){
        conexion = Conexion.getConexion();
    }
    
    public void insertarAlumno(Alumno alumno){
        PoolConnection poolConnection = null;
        conexion.getMonitorPool().getAdminPool().initializePoolConnections();
        try {
            poolConnection = conexion.getMonitorPool().getAdminPool().getPoolConnection();
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
        PoolConnection poolConnection = null;
        conexion.getMonitorPool().getAdminPool().initializePoolConnections();
        try {
            poolConnection = conexion.getMonitorPool().getAdminPool().getPoolConnection();
        } catch (NotAvailableConnectionsException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String consulta  = "update into alumno set "+
                "DIREC=\""+alumno.getDireccion()+"\","+
                "TELEF=\""+alumno.getTelefono()+"\""+
                "where MATRIC=\""+alumno.getMatricula()+"\")";
        
        try {
            poolConnection.insertQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        poolConnection.close();
    }
    
    public ArrayList<Alumno> obtenerAlumnos(){
        PoolConnection poolConnection = null;
        conexion.getMonitorPool().getAdminPool().initializePoolConnections();
        try {
            poolConnection = conexion.getMonitorPool().getAdminPool().getPoolConnection();
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
