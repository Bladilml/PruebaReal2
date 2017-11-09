/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import prueba.services.HibernateUtil;

/**
 *
 * @author CETECOM
 */
public class UsuariosHelper {

    Session session = null;

    public UsuariosHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
     public boolean crearUsuario(Usuarios nuevoUsuario){
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Integer id = (Integer)session.save(nuevoUsuario);
            tx.commit();
            return (id!=0);
        } catch (Exception ex){
            Logger.getLogger(UsuariosHelper.class.getName()).log(Level.SEVERE, "No se pudo agregar usuario a la BD:{0}", ex.toString());
            return false;
        }
    }
    
    

}
