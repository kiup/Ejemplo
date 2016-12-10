
package controlador;

import MVC.controlador.Controlador;
import Vista.VentanaVerAlumnos;
import Vista.VentanaVerProfesores;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.AlumnoDAO;
import modelo.Profesor;
import modelo.ProfesorDAO;

public class ControladorMostrarDatos extends Controlador {

    private VentanaVerAlumnos ventanaAlumnos;
    private VentanaVerProfesores ventanaProfesores;

    public void mostrarAlumnos() {
        ventanaAlumnos = new VentanaVerAlumnos();
        AlumnoDAO  dao = new AlumnoDAO();
        mostrarDatosAlumnos(dao.obtenerAlumnos());
        ventanaAlumnos.setVisible(true);
        
    }

    private void mostrarDatosAlumnos(ArrayList<Alumno> alumnos) {
        vaciarTablaAlumnos();
        for (Alumno alumno : alumnos) {
            String[] fila = {alumno.getMatricula(),
                alumno.getNombre(),
                alumno.getDireccion(),
                alumno.getTelefono(),
                alumno.getCarrera()};
            ventanaAlumnos.getModelo().addRow(fila);
        }
    }

    private void vaciarTablaAlumnos() {
        ventanaAlumnos.getModelo().setRowCount(0);
    }
    
    public void mostrarProfesores() {
        ventanaProfesores = new VentanaVerProfesores();
        ProfesorDAO  dao = new ProfesorDAO();
        mostrarDatosProfesores(dao.obtenerProfesores());
        ventanaProfesores.setVisible(true);
        
    }

    private void mostrarDatosProfesores(ArrayList<Profesor> profesores) {
        vaciarTablaProfesores();
        for (Profesor profesor : profesores) {
            String[] fila = {profesor.getCProf(),
                profesor.getNombre(),
                profesor.getGrado(),
                profesor.getFechaIngreso()};
            ventanaProfesores.getModelo().addRow(fila);
        }
    }

    private void vaciarTablaProfesores() {
        ventanaProfesores.getModelo().setRowCount(0);
    }
}
