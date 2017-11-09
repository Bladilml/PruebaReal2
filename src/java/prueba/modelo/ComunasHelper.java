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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import prueba.services.HibernateUtil;

/**
 *
 * @author Bladi
 */
public class ComunasHelper {

  
    Session session = null;

    public ComunasHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Comunas> getAllByProvinciaId(int provinciaId) {
        List<Comunas> lista = null;

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.setTimeout(5);
            Query q = session.createQuery("from Comunas where provincia_id=:param1");
            q.setParameter("param1", provinciaId);
            lista = (ArrayList<Comunas>) q.list();
            tx.commit();
            //session.close();
        } catch (HibernateException ex) {
            Logger.getLogger(RegionesHelper.class.getName()).log(Level.SEVERE, "Error al obtener todas las regiones:{0}", ex.toString());
        }

        return lista;
    }
}


