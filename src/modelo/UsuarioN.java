/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Seguridad.Usuario;

/**
 *
 * @author Milka
 */
public class UsuarioN extends Usuario{
    private String tipo;
    private String cuser;
    private String contr;

    public UsuarioN() {
        super(null, null);
    }

    public UsuarioN(String cuser, String contr, String tipo) {
        super(cuser, contr);
        this.tipo = tipo;
    }

    public String getCuser() {
        return getNombreUsuario();
    }

    public void setCuser(String cuser) {
        setNombreUsuario(cuser);
    }

    public String getContr() {
        return getContrasenia();
    }

    public void setContr(String contr) {
        setContrasenia(contr);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
