/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import prueba.services.HibernateUtil;

/**
 *
 * @author CETECOM
 */
public class proyectoHelper {
    Session session = null;
    
    public proyectoHelper(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Proyecto> getAll(){
        List<Proyecto> listaProyecto = null;
        
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("from Proyecto");
            listaProyecto = (ArrayList<Proyecto>) q.list();
            tx.commit();
        } catch (Exception e) {
            Logger.getLogger(proyectoHelper.class.getName()).log(Level.SEVERE, "No se pudo hacer la consulta: ", e.toString());
        }
        return listaProyecto;
    }
    
}
