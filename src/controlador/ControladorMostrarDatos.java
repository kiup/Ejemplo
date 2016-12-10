
package controlador;

import MVC.controlador.Controlador;
import Vista.VentanaVerAlumnos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.AlumnoDAO;

public class ControladorMostrarDatos extends Controlador {

    public VentanaVerAlumnos ventanaAlumnos;

    public void mostrarAlumnos() {
        AlumnoDAO  dao = new AlumnoDAO();
        mostrarDatosAlumnos(dao.obtenerAlumnos());
    }

    private void mostrarDatosAlumnos(ArrayList<Alumno> alumnos) {
        vaciarTablaAlumnos();
        DefaultTableModel modeloTabla = new DefaultTableModel();
        Object[] identificadores = {"Matricula", "Nombre", "Dirección", "Teléfono", "Carrera"};
        modeloTabla.setColumnIdentifiers(identificadores);
        for (Alumno alumno : alumnos) {
            Object[] fila = {alumno.getMatricula(),
                alumno.getNombre(),
                alumno.getDireccion(),
                alumno.getTelefono(),
                alumno.getCarrera()};
            modeloTabla.addRow(fila);
        }
        ventanaAlumnos.setContenidoTabla(modeloTabla);
        ventanaAlumnos.setVisible(true);
    }

    private void vaciarTablaAlumnos() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.setRowCount(0);
        ventanaAlumnos.setContenidoTabla(modeloTabla);
    }
}
