/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import MVC.controlador.Controlador;
import Seguridad.AdminLogin;
import Seguridad.Usuario;
import Vista.VistaAdmin;
import Vista.VistaAlumno;
import Vista.VistaProfesor;
import java.util.ArrayList;

import modelo.UsuarioDAO;
import modelo.UsuarioN;

/**
 *
 * @author Milka
 */
public class ControladorLogin extends Controlador {

    AdminLogin admin = AdminLogin.obtenerAdminLogin();

    ;
    
    public void insertarUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        admin.pasarListaUsuarios(dao.obtenerUsuarios());
    }

    public void iniciarUsuario() {
        String tipo = buscarUsuario();
        if (tipo.equals("ADMI")) {
            VistaAdmin vista = new VistaAdmin();
        } else {
            if (tipo.equals("PROF")) {
                VistaProfesor vista = new VistaProfesor(getEvt().getObject().toString());
            } else {
                if (tipo.equals("ALUM")) {
                    VistaAlumno vista = new VistaAlumno(getEvt().getObject().toString());
                }
            }
        }
    }
    
    private String buscarUsuario(){
        String tipo = null;
        UsuarioDAO dao = new UsuarioDAO();
        ArrayList<Usuario> usuarios = dao.obtenerUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreUsuario().equals(getEvt().getObject())) {
                UsuarioN usuario = (UsuarioN)usuarios.get(i);
                tipo = usuario.getTipo();
            }
        }
        return tipo;
    }
    
    
}
