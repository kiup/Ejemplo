/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import MVC.controlador.Controlador;
import modelo.Alumno;
import modelo.AlumnoDAO;
import modelo.UsuarioDAO;
import modelo.UsuarioN;


public class ControladorActualizarDatos extends Controlador {
    
    public void actualizarAlumno(){
        String [] datosAlumno = (String [])getEvt().getObject();
        Alumno alumno =  new Alumno(datosAlumno[0],
                                    datosAlumno[1],
                                    datosAlumno[2],
                                    datosAlumno[3],
                                    datosAlumno[4]);
        
        AlumnoDAO dao = new AlumnoDAO();
        dao.actualizarAlumno(alumno);
        
        UsuarioDAO daoU = new UsuarioDAO();
        
        UsuarioN usuario = new UsuarioN();
        usuario.setCuser(alumno.getMatricula());
        usuario.setContr(datosAlumno[5]);
        
        daoU.actualizarUsuario(usuario);
    }
    
}
