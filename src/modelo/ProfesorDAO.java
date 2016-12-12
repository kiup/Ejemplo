/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
import pool.PoolConnection;

/**
 *
 * @author Milka
 */
public class ProfesorDAO {
    private String rutaArchivoMapeo = "configuracionMapeo.xml";
    private Conexion conexion;
    
    public ProfesorDAO(){
        conexion = Conexion.getConexion();
    }
    
    public void insertarProfesor(Profesor profesor){
        
        PoolConnection poolConnection = null;
        conexion.getMonitorPool().getAdminPool().initializePoolConnections();
        try {
            poolConnection = conexion.getMonitorPool().getAdminPool().getPoolConnection();
        } catch (NotAvailableConnectionsException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String consulta  = "insert into profes values("+
                "\""+profesor.getCProf()+"\","+
                "\""+profesor.getNombre()+"\","+
                "\""+profesor.getGrado()+"\","+
                "\""+profesor.getFechaIngreso()+"\")";
        
        try {
            poolConnection.insertQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        poolConnection.close();
    }
    
    public ArrayList<Profesor> obtenerProfesores(){

        PoolConnection poolConnection = null;
        conexion.getMonitorPool().getAdminPool().initializePoolConnections();
        try {
            poolConnection = conexion.getMonitorPool().getAdminPool().getPoolConnection();
        } catch (NotAvailableConnectionsException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        MapeadorObjetoRelacional mapeador = null;
        try {
           mapeador = new MapeadorObjetoRelacional(rutaArchivoMapeo);
        } catch (ArchivoConfiguracionNoEncontradoExcepcion ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        ArrayList<Profesor> profesores =  null;
        try {
            mapeador.mapearObjetosRelacion("modelo.Profesor", poolConnection);
             profesores = mapeador.getListaObjetos();
        } catch (MapeoInexistenteExcepcion ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ObjetoErroneoExcepcion ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MapeoErroneoExcepcion ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        poolConnection.close();
        return profesores;
    }

    public void actualizarProfesor(Profesor profesor) {
        
        PoolConnection poolConnection = null;
        conexion.getMonitorPool().getAdminPool().initializePoolConnections();
        try {
            poolConnection = conexion.getMonitorPool().getAdminPool().getPoolConnection();
        } catch (NotAvailableConnectionsException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String consulta  = "update profes set "+
                "GRADO=\""+profesor.getGrado()+"\" "+
                "where CPROF=\""+profesor.getCProf()+"\"";
        
        try {
            poolConnection.insertQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        poolConnection.close();
    }
}
