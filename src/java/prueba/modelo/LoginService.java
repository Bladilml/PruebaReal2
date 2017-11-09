/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.modelo;

import prueba.services.HibernateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import prueba.services.HibernateUtil;

/**
 *
 * @author CETECOM
 */

public class LoginService {

    Session session = null;

 
    public LoginService() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Usuarios ObtenerUsuario(String nombre) {
        Usuarios usuario = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("from Usuarios where username =:param1");
            q.setString("param1", nombre);
            usuario = (Usuarios) q.uniqueResult();
            tx.commit();

        } catch (Exception ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, "no se puede consultar la BD:{0}", ex.toString());
        }
        return usuario;
    }

    public boolean verificarUsuario(String user) {
        return (ObtenerUsuario(user) != null);
    }

    public boolean validarUsuario(String user, String password) {

        try {
            Usuarios usuario = ObtenerUsuario(user);
            BCryptPasswordEncoder PE = new BCryptPasswordEncoder();
            boolean resultado = PE.matches(password, usuario.getPassword());
            return (resultado);

        } catch (Exception ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, "no se puede consultar la BD:{0}", ex.toString());
            return false;
        }

    }

    public void cerrarSession() {
        session.close();
    }

}
