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

/**
 *
 * @author Milka
 */
public class VistaAlumno extends Vista{
    private VentanaDatosAlumno ventana;
    
    public VistaAlumno(String matricula) {
        ventana = new VentanaDatosAlumno();
        ventana.getMatricula().setText(matricula);
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
                    String[] datosAlumno = new String[6];
                    datosAlumno[0] = ventana.getMatricula().getText();
                    datosAlumno[1] = ventana.getNombre().getText();
                    datosAlumno[2] = ventana.getDireccion().getText();
                    datosAlumno[3] = ventana.getTelefono().getText();
                    datosAlumno[4] = ventana.getCarrera().getText();
                    datosAlumno[5] = ventana.getContrasenia().getText();
                
                    Evento evt = new Evento("actualizarAlumno", datosAlumno);
                    
                    try {
                        callService(evt);
                        
                    } catch (ClaseNoEncontrada ex) {
                        Logger.getLogger(VistaAlumno.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoEsSubclaseControlador ex) {
                        Logger.getLogger(VistaAlumno.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FalloInstanciaDeClase ex) {
                        Logger.getLogger(VistaAlumno.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSePuedeAccederAlaClase ex) {
                        Logger.getLogger(VistaAlumno.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MetodoNoExiste ex) {
                        Logger.getLogger(VistaAlumno.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ViolacionDeSeguridad ex) {
                        Logger.getLogger(VistaAlumno.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ArgumentosNoCorrectos ex) {
                        Logger.getLogger(VistaAlumno.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ErrorAlInvocarObjetivo ex) {
                        Logger.getLogger(VistaAlumno.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ventana.dispose();
                }else{
                
                JOptionPane.showMessageDialog(null, "La contraseña es invalida"
                        + "\"*Debe tener al menos 8 caracteres\""
                        + "\"*Debe tener al menos una mayuscula\""
                        + "\"*Debe tener al menos una minuscula\""
                        + "\"*Debe tener al menos un numero\"",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
    }
    
    
}
