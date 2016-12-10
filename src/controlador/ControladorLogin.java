/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import MVC.controlador.Controlador;
import archivo.MonitorArchivo;
import excepciones.ArchivoConfigBDNoEncontradaException;
import excepciones.NotAvailableConnectionsException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pool.MonitorArchivoConfiguracion;
import pool.PoolConnection;


public class ControladorLogin extends Controlador {
    
    public void guardarDatosLogin(){
        MonitorArchivo monitorArchivoBD=null;
        try {
            monitorArchivoBD = new MonitorArchivo("monitor2", "configuracion-bd.xml");
        } catch (ArchivoConfigBDNoEncontradaException ex) {
            
        }
        
        monitorArchivoBD.start();
        
        ArrayList<String> datos = (ArrayList)getEvt().getObject();
        
        String ruta = "archivoConfiguracion.xml";
        MonitorArchivoConfiguracion monitorPool = new MonitorArchivoConfiguracion("pool2", ruta);
        
        monitorPool.start();
        
        PoolConnection poolConnection = null;
        
        monitorPool.getAdminPool().initializePoolConnections();
        
       
        try {
            poolConnection = monitorPool.getAdminPool().getPoolConnection();
        } catch (NotAvailableConnectionsException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
