/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import MVC.vista.Evento;
import MVC.vista.Vista;
import Seguridad.AdminLogin;
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
public class VistaSesion extends Vista {

    private VentanaLogin ventanaLogin;
    private AdminLogin admin;

    public VistaSesion() {
        ventanaLogin = new VentanaLogin();
        ventanaLogin.setVisible(true);
        setConfiguracion("archivoConfiguracionMVC.xml");
        admin = AdminLogin.obtenerAdminLogin();
        inicializarAdminLogin();
        tomarDatos();
    }

    public void inicializarAdminLogin() {
        Evento evento = new Evento("insertarUsuarios", null);
        try {
            callService(evento);
        } catch (ClaseNoEncontrada ex) {
            Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoEsSubclaseControlador ex) {
            Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FalloInstanciaDeClase ex) {
            Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSePuedeAccederAlaClase ex) {
            Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MetodoNoExiste ex) {
            Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ViolacionDeSeguridad ex) {
            Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArgumentosNoCorrectos ex) {
            Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ErrorAlInvocarObjetivo ex) {
            Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tomarDatos() {
        ventanaLogin.getbtnIniciarSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hoal");
                String usuario = ventanaLogin.getTxtUsuario().getText();
                String clave = ventanaLogin.getTxtContrasenia().getText();

                if (admin.validarAccesoAlSistema(usuario, clave)) {
                    String[] datos = new String[3];

                    datos[0] = usuario;
                    datos[1] = clave;

                    Evento evento = new Evento("iniciarUsuario", datos);

                    try {
                        callService(evento);
                    } catch (ClaseNoEncontrada ex) {
                        Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoEsSubclaseControlador ex) {
                        Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FalloInstanciaDeClase ex) {
                        Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSePuedeAccederAlaClase ex) {
                        Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MetodoNoExiste ex) {
                        Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ViolacionDeSeguridad ex) {
                        Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ArgumentosNoCorrectos ex) {
                        Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ErrorAlInvocarObjetivo ex) {
                        Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        });
    }

}
