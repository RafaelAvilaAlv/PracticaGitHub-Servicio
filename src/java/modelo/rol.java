/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class rol {
    private int id_rol;
    private String nombreRol;
    private boolean estado;
    private List <usuario_rol> usuarioRol;
    
     public rol() {
        usuarioRol = new ArrayList<>();
    }
    
    //composicion
    public rol(rol r) {
        this.id_rol = r.id_rol;
        this.nombreRol = r.nombreRol;
        this.estado = r.estado;
        this.usuarioRol = r.usuarioRol;
    }

    public rol(int id_rol, String nombreRol, boolean estado) {
        this.id_rol = id_rol;
        this.nombreRol = nombreRol;
        this.estado = estado;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<usuario_rol> getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(List<usuario_rol> usuarioRol) {
        this.usuarioRol = usuarioRol;
    }
    
    
}
