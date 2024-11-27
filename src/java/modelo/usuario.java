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
public class usuario {
     private int id_usuario;
    private persona persona; // Agregar un atributo de tipo Person
    private String user;
    private String password;
    private List <usuario_rol> UsuarioRol;
    

    public usuario() {
        UsuarioRol= new ArrayList<>();
    }

     public usuario(usuario u) {
        this.id_usuario = u.id_usuario;
        this.persona = u.persona;
        this.user = u.user;
        this.password = u.password;
        this.UsuarioRol = u.getUsuarioRol();
    }
   public usuario(int id_usuario, persona persona, String user, String password) {
    this.id_usuario = id_usuario;
    this.user = user;
    this.persona= persona;
    this.password = password;

}

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public persona getPersona() {
        return persona;
    }

    public void setPersona(persona persona) {
        this.persona = persona;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<usuario_rol> getUsuarioRol() {
        return UsuarioRol;
    }

    public void setUsuarioRol(List<usuario_rol> UsuarioRol) {
        this.UsuarioRol = UsuarioRol;
    }
   
}
