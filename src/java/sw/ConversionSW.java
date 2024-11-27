/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.persona;
import modelo.rol;
import modelo.usuario;
import modelo.usuario_rol;

/**
 *
 * @author LENOVO
 */
@WebService(serviceName = "ConversionSW")
public class ConversionSW {

    Map<String, String> diccionario = new HashMap<>();
    ArrayList<persona> listaPersonas = new ArrayList<>();
    ArrayList<usuario> listaUsuarios = new ArrayList<>();
    ArrayList<usuario_rol> listaUsuariosRoles = new ArrayList<>();
    ArrayList<rol> listaRoles = new ArrayList<>();

    public void crearDatos() {
        // Imprimir la cantidad de personas y facturas
        System.out.println("Cantidad de personas: " + listaPersonas.size());
        //Datos quemados
        persona p1 = new persona(1, "Juan", "Pérez", "0150115509", "987654321", "juan@example.com");
        persona p2 = new persona(2, "María", "López", "0150224408", "123456789", "maria@example.com");
        persona p3 = new persona(3, "Pedro", "Gómez", "56789012", "654321987", "pedro@example.com");
        persona p4 = new persona(4, "Ana", "Martínez", "34567890", "321654987", "ana@example.com");
        listaPersonas.add(p1);
        listaPersonas.add(p2);
        listaPersonas.add(p3);
        listaPersonas.add(p4);

        //Rol
        rol r1 = new rol(001, "Admintrador", true);
        rol r2 = new rol(002, "Usuario", true);
        rol r3 = new rol(003, "Invitado", true);
        rol r4 = new rol(004, "Supervisor", true);
        listaRoles.add(r1);
        listaRoles.add(r2);
        listaRoles.add(r3);
        listaRoles.add(r4);

        //Usuarios 
        usuario u1 = new usuario(01, p1, "admin", "1234");
        listaUsuariosRoles = new ArrayList<>();
        listaUsuariosRoles.add(new usuario_rol(u1, r1));

        usuario u2 = new usuario(02, p2, "admin1", "1234");
        listaUsuariosRoles = new ArrayList<>();
        listaUsuariosRoles.add(new usuario_rol(u2, r2));

        usuario u3 = new usuario(03, p3, "admin2", "1234");
        listaUsuariosRoles = new ArrayList<>();
        listaUsuariosRoles.add(new usuario_rol(u3, r3));

        usuario u4 = new usuario(04, p4, "admin3", "1234");
        listaUsuariosRoles = new ArrayList<>();
        listaUsuariosRoles.add(new usuario_rol(u1, r3));
        u1.setUsuarioRol(listaUsuariosRoles);

        listaUsuarios.add(u1);
        listaUsuarios.add(u2);
        listaUsuarios.add(u3);
        listaUsuarios.add(u4);

        //palabras_diccionario
        diccionario.put("automóvil", "Vehículo de transporte con motor que se desplaza sobre ruedas y está diseñado principalmente para el transporte de personas.");
        diccionario.put("teléfono", "Dispositivo electrónico que permite la comunicación bidireccional mediante la transmisión de señales de audio a distancia.");
        diccionario.put("perro", "Mamífero domesticado de la familia de los cánidos, de tamaño variable, pelaje espeso y hocico alargado, que se cría como animal de compañía o para el trabajo.");
        diccionario.put("mariposa", "Insecto volador, generalmente de colores llamativos, con dos pares de alas membranosas cubiertas de escamas.");
        diccionario.put("cine", "Arte y técnica de la cinematografía; lugar destinado a la proyección de películas.");
        diccionario.put("científico", "Persona que se dedica a la investigación y estudio sistemático de la realidad natural y social, a través de un método científico.");
        diccionario.put("jarden", "Espacio de terreno, generalmente cercado, destinado al cultivo de flores, plantas ornamentales o vegetales.");
        diccionario.put("fotografía", "Técnica de capturar imágenes mediante la acción de la luz sobre una superficie fotosensible, como película o un sensor electrónico.");
        diccionario.put("escuela", "Institución destinada a la enseñanza y educación de niños y jóvenes.");
        diccionario.put("revolución", "Cambio profundo y rápido en cualquier cosa, especialmente en un sistema político, social o económico.");

    }

    //Identificaciones
    @WebMethod(operationName = "ValidarDatos")
    public usuario credenciales(String usuario, String password) {
        crearDatos();
        usuario encontrado = null;
        for (usuario us : listaUsuarios) {
            if (usuario.equals(us.getUser()) && password.equals(us.getPassword())) {
                encontrado = us;
            }
        }
        return encontrado;
    }

    //Iniciar Sesión
    @WebMethod(operationName = "iniciarSesion")
    public boolean iniciarSesion(@WebParam(name = "usuario") String usuario, @WebParam(name = "contrasena") String contrasena) {
        crearDatos();
        for (usuario u : listaUsuarios) {
            if (u.getUser().equals(usuario) && u.getPassword().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

    //Buscar palabra_diccionario
    @WebMethod(operationName = "palabra")
    public String obtenerDescripcionPalabra(@WebParam(name = "termino") String palabra) {
        crearDatos();
        String minusculap = palabra.toLowerCase();
        if (diccionario.containsKey(minusculap)) {
            return diccionario.get(minusculap);
        } else {
            return "No se encontro el significado de la palabra que esta buscando ";
        }
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
