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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class VentanaSesion extends Vista{
    private VentanaLogin ventanaLogin;
    
    public VentanaSesion(){
        ventanaLogin = new VentanaLogin();
        ventanaLogin.setVisible(true);
        setConfiguracion("archivoConfiguracionMVC.xml");
        tomarDatos();
    }
    
    public void tomarDatos(){
        ventanaLogin.getbtnIniciarSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario  = ventanaLogin.getTxtUsuario().getText();
                String clave = ventanaLogin.getTxtContrasenia().getPassword().toString();
                
                String[] datos = new String[3];
                
                datos[0] = usuario;
                datos[1] = clave;
                
                Evento evento = new Evento("buscarUsuario", datos);
                
                
                try {
                    callService(evento);
                } catch (ClaseNoEncontrada ex) {
                    Logger.getLogger(VentanaSesion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoEsSubclaseControlador ex) {
                    Logger.getLogger(VentanaSesion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FalloInstanciaDeClase ex) {
                    Logger.getLogger(VentanaSesion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSePuedeAccederAlaClase ex) {
                    Logger.getLogger(VentanaSesion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MetodoNoExiste ex) {
                    Logger.getLogger(VentanaSesion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ViolacionDeSeguridad ex) {
                    Logger.getLogger(VentanaSesion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ArgumentosNoCorrectos ex) {
                    Logger.getLogger(VentanaSesion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ErrorAlInvocarObjetivo ex) {
                    Logger.getLogger(VentanaSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
}
