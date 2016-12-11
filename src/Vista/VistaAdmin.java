/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import MVC.vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VistaAdmin extends Vista{
    
    VentanaAdmin ventana;
    
    public VistaAdmin(){
        ventana = new VentanaAdmin();
        ventana.setVisible(true);
        abrirVentana();
    }
    
    public void abrirVentana(){
        ventana.getAlumno().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VistaRegistroAlumnos vista = new VistaRegistroAlumnos();
            }
        });
        
        ventana.getProfesor().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VistaRegistroProfesor vista = new VistaRegistroProfesor();
            }
        });
    }
    
}
