/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class usuario_rol {
    private int id_usuarioRol;
    private usuario Usuario;
    private rol Rol;

    public usuario_rol() {
    }
    

    public usuario_rol( usuario Usuario,rol Rol) {
        this.Usuario = new usuario (Usuario);
        this.Rol =  new rol (Rol);
    }

    public usuario_rol(int id_usuarioRol, usuario Usuario, rol Rol) {
        this.id_usuarioRol = id_usuarioRol;
        this.Usuario = Usuario;
        this.Rol = Rol;
    }
    

    public int getId_usuarioRol() {
        return id_usuarioRol;
    }

    public void setId_usuarioRol(int id_usuarioRol) {
        this.id_usuarioRol = id_usuarioRol;
    }

    public usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(usuario Usuario) {
        this.Usuario = Usuario;
    }

    public rol getRol() {
        return Rol;
    }

    public void setRol(rol Rol) {
        this.Rol = Rol;
    }
    


}
