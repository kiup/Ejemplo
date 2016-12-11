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
public class ControladorLogin extends Controlador{
    AdminLogin admin = AdminLogin.obtenerAdminLogin();;
    
    public void insertarUsuarios(){
        UsuarioDAO dao = new UsuarioDAO();
        ArrayList<Usuario> usuarios = dao.obtenerUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i).getNombreUsuario()
            + " "+ usuarios.get(i).getContrasenia());
        }
        admin.pasarListaUsuarios(dao.obtenerUsuarios());
    }
    
    public void iniciarUsuario(){
        if (getEvt().getObject().toString().equals("ADMI")) {
            VistaAdmin vista = new VistaAdmin();
        }else{
            if (getEvt().getObject().toString().equals("PROF")) {
                VistaProfesor vista = new VistaProfesor();
            }else{
                if (getEvt().getObject().toString().equals("ALUM")) {
                    VistaAlumno vista = new VistaAlumno();
        }
            }
        }
    }
}
