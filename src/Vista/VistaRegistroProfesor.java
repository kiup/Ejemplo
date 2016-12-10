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
public class VistaRegistroProfesor extends Vista{
    private VentanaRegistroProfesor ventana;

    public VistaRegistroProfesor() {
        ventana = new VentanaRegistroProfesor();
        ventana.setVisible(true);
        setConfiguracion("archivoConfiguracionMVC.xml");
        registrarProfesor();
    }
    
    public void registrarProfesor(){
        
        ventana.getMostrar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Evento evt =  new Evento("mostrarProfesores", null);
                
                try {
                    callService(evt);
                } catch (ClaseNoEncontrada ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoEsSubclaseControlador ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FalloInstanciaDeClase ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSePuedeAccederAlaClase ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MetodoNoExiste ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ViolacionDeSeguridad ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ArgumentosNoCorrectos ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ErrorAlInvocarObjetivo ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        ventana.getRegistrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] datosProfesor = new String[6];
                datosProfesor[0] = ventana.getcProf().getText();
                datosProfesor[1] = ventana.getNombre().getText();
                datosProfesor[3] = ventana.getGrado().getText();
                datosProfesor[4] = ventana.getFecha().getText();
                
                Evento evt = new Evento("registrarProfesor", datosProfesor);
                
                try {
                    callService(evt);
                } catch (ClaseNoEncontrada ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoEsSubclaseControlador ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FalloInstanciaDeClase ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSePuedeAccederAlaClase ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MetodoNoExiste ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ViolacionDeSeguridad ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ArgumentosNoCorrectos ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ErrorAlInvocarObjetivo ex) {
                    Logger.getLogger(VistaRegistroProfesor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
