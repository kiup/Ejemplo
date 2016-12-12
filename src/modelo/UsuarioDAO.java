/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Seguridad.Usuario;
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
public class UsuarioDAO {
    private final String rutaArchivoMapeo = "configuracionMapeo.xml";
    private Conexion conexion;
    public UsuarioDAO(){
        conexion = Conexion.getConexion();
    }
    
    public void insertarUsuario(UsuarioN usuario){
        
        
        
        PoolConnection poolConnection = null;
        conexion.getMonitorPool().getAdminPool().initializePoolConnections();
        try {
            poolConnection = conexion.getMonitorPool().getAdminPool().getPoolConnection();
        } catch (NotAvailableConnectionsException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String consulta  = "insert into usuario values("+
                "\""+usuario.getCuser()+"\","+
                "\""+usuario.getContr()+"\","+
                "\""+usuario.getTipo()+"\")";
        
        try {
            poolConnection.insertQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        poolConnection.close();
    }
    
    public void actualizarUsuario(UsuarioN usuario){
        
        PoolConnection poolConnection = null;
        conexion.getMonitorPool().getAdminPool().initializePoolConnections();
        try {
            poolConnection = conexion.getMonitorPool().getAdminPool().getPoolConnection();
        } catch (NotAvailableConnectionsException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String consulta  = "update usuario set "+
                "CONTR=\""+usuario.getContr()+"\" "+
                "where CUSER=\""+usuario.getCuser()+"\"";
        
        try {
            poolConnection.insertQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        poolConnection.close();
    }
    
    public ArrayList<Usuario> obtenerUsuarios(){
        PoolConnection poolConnection = null;
        conexion.getMonitorPool().getAdminPool().initializePoolConnections();
        try {
            poolConnection = conexion.getMonitorPool().getAdminPool().getPoolConnection();
        } catch (NotAvailableConnectionsException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        MapeadorObjetoRelacional mapeador = null;
        try {
           mapeador = new MapeadorObjetoRelacional(rutaArchivoMapeo);
        } catch (ArchivoConfiguracionNoEncontradoExcepcion ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        ArrayList<Usuario> usuarios =  null;
        try {
            mapeador.mapearObjetosRelacion("modelo.UsuarioN", poolConnection);
             usuarios = mapeador.getListaObjetos();
        } catch (MapeoInexistenteExcepcion ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ObjetoErroneoExcepcion ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MapeoErroneoExcepcion ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        poolConnection.close();
        return usuarios;
    }
}
