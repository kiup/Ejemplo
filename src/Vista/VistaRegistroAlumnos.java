/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import MVC.vista.Evento;
import MVC.vista.Vista;
import excepciones.ArgumentosNoCorrectos;
import excepciones.ClaseNoEncontrada;
import excepciones.ErrorAlInvocarObjetivo;
import excepciones.FalloInstanciaDeClase;
import excepciones.MetodoNoExiste;
import excepciones.NoEsSubclaseControlador;
import excepciones.NoSePuedeAccederAlaClase;
import excepciones.ViolacionDeSeguridad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milka
 */
public class VistaRegistroAlumnos extends Vista{
    private VentanaRegistroAlumnos ventana;

    public VistaRegistroAlumnos() {
        ventana = new VentanaRegistroAlumnos();
        ventana.setVisible(true);
        setConfiguracion("archivoConfiguracionMVC.xml");
        registrarAlumnos();
    }
    
    public void registrarAlumnos(){
        
        ventana.getMostrar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Evento evt =  new Evento("mostrarAlumnos", null);
                
                try {
                    callService(evt);
                } catch (ClaseNoEncontrada ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoEsSubclaseControlador ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FalloInstanciaDeClase ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSePuedeAccederAlaClase ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MetodoNoExiste ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ViolacionDeSeguridad ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ArgumentosNoCorrectos ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ErrorAlInvocarObjetivo ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        ventana.getRegistrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] datosAlumno = new String[6];
                datosAlumno[0] = ventana.getMatricula().getText();
                datosAlumno[1] = ventana.getNombre().getText();
                datosAlumno[2] = ventana.getDireccion().getText();
                datosAlumno[3] = ventana.getTelefono().getText();
                datosAlumno[4] = ventana.getCarrera().getText();
                
                Evento evt = new Evento("registrarAlumno", datosAlumno);
                
                try {
                    callService(evt);
                } catch (ClaseNoEncontrada ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoEsSubclaseControlador ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FalloInstanciaDeClase ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSePuedeAccederAlaClase ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MetodoNoExiste ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ViolacionDeSeguridad ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ArgumentosNoCorrectos ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ErrorAlInvocarObjetivo ex) {
                    Logger.getLogger(VistaRegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
