/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import MVC.vista.Evento;
import MVC.vista.Vista;
import Seguridad.Contraseña;
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
import javax.swing.JOptionPane;


public class VistaProfesor extends Vista{
    private VentanaDatosProfesor ventana;
    
    public VistaProfesor(String cprof) {
        ventana = new VentanaDatosProfesor();
        ventana.getcProf().setText(cprof);
        ventana.setVisible(true);
        setConfiguracion("archivoConfiguracionMVC.xml");
        actualizarDatos();
    }
    
    public void actualizarDatos(){
        ventana.getRegistrar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Contraseña contraseña = new Contraseña();
                
                String contra = ventana.getContrasenia().getText();
                
                if (contraseña.validarRequerimientosContraseña(contra)) {
                    String[] datosProfesor = new String[6];
                    datosProfesor[0] = ventana.getcProf().getText();
                    datosProfesor[1] = ventana.getNombre().getText();
                    datosProfesor[2] = ventana.getGrado().getText();
                    datosProfesor[3] = ventana.getFecha().getText();
                    datosProfesor[4] = ventana.getContrasenia().getText();
                
                    Evento evt = new Evento("actualizarProfesor", datosProfesor);
                    
                    
                    try {
                        callService(evt);
                        ventana.dispose();
                    } catch (ClaseNoEncontrada ex) {
                        Logger.getLogger(VistaProfesor.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoEsSubclaseControlador ex) {
                        Logger.getLogger(VistaProfesor.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FalloInstanciaDeClase ex) {
                        Logger.getLogger(VistaProfesor.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSePuedeAccederAlaClase ex) {
                        Logger.getLogger(VistaProfesor.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MetodoNoExiste ex) {
                        Logger.getLogger(VistaProfesor.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ViolacionDeSeguridad ex) {
                        Logger.getLogger(VistaProfesor.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ArgumentosNoCorrectos ex) {
                        Logger.getLogger(VistaProfesor.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ErrorAlInvocarObjetivo ex) {
                        Logger.getLogger(VistaProfesor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                JOptionPane.showMessageDialog(null, "La contraseña es invalida"
                        + "\"*Debe tener al menos 8 caracteres\""
                        + "\"*Debe tener al menos una mayuscula\""
                        + "\"*Debe tener al menos una minuscula\""
                        + "\"*Debe tener al menos un numero\"",
                        "Error", JOptionPane.ERROR_MESSAGE);
                
            }
        });
        
    }
}
