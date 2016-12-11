/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import archivo.MonitorArchivo;
import excepciones.ArchivoConfigBDNoEncontradaException;
import pool.MonitorArchivoConfiguracion;

/**
 *
 * @author Milka
 */
public class Conexion {
    private static Conexion conexion;
    private String rutaArchivoBD = "configuracion-bd.xml";
    private String rutaArchivoPool = "archivoConfiguracion.xml";
    private MonitorArchivo monitor;
    private MonitorArchivoConfiguracion monitorPool;
    
    private Conexion(){
        inicializarMonitorArchivo();
    }
    
    public static Conexion getConexion(){
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }
    
    public void inicializarMonitorArchivo(){
        try {
            monitor = new MonitorArchivo("monitor1", rutaArchivoBD );
            monitor.start();
            monitorPool = new MonitorArchivoConfiguracion("pool", rutaArchivoPool);
            monitorPool.start();
        } catch (ArchivoConfigBDNoEncontradaException ex) {

        }
    }

    public MonitorArchivo getMonitor() {
        return monitor;
    }

    public MonitorArchivoConfiguracion getMonitorPool() {
        return monitorPool;
    }
    
    
}
