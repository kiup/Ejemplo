/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import MVC.controlador.Controlador;
import modelo.Alumno;
import modelo.AlumnoDAO;
import modelo.Profesor;
import modelo.ProfesorDAO;


public class ControladorRegistro extends Controlador {

    public void registroAlumno() {
        String [] datosAlumno = (String [])getEvt().getObject();
        Alumno alumno =  new Alumno(datosAlumno[0],
                                    datosAlumno[1],
                                    datosAlumno[2],
                                    datosAlumno[3],
                                    datosAlumno[4]);
        
        AlumnoDAO dao = new AlumnoDAO();
        dao.insertarAlumno(alumno);
    }

    public void registroProfesor() {
        System.out.println("Hola");
        String [] datosProfesor = (String [])getEvt().getObject();
        Profesor profesor =  new Profesor(datosProfesor[0],
                                    datosProfesor[1],
                                    datosProfesor[2],
                                    datosProfesor[3]);
        
        ProfesorDAO dao = new ProfesorDAO();
        dao.insertarProfesor(profesor);
    }

}
