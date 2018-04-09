package com.educomser.dao;

import com.educomser.model.Empleado;
import com.educomser.test.TestEmpleado;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpleadoDao {

    private Session session; // Mantiene la referencia de la sesión a la BD
    private Transaction tx;  // Mantiene la referencia a la transacción

    // Inicia una sesión y una transacción a la base de datos
    private void iniciaOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    public void save(Empleado empleado) {
        try {
            iniciaOperacion();
            session.save(empleado);
            // El método saveOrUpdate(empleado) guarda y modifica
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            String message = "Error al guardar";
            Logger.getLogger(TestEmpleado.class.getName()).log(Level.SEVERE, message, ex);
        } finally {
            session.close();
        }
    }

    public void update(Empleado empleado) {
        try {
            iniciaOperacion();
            session.update(empleado);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            String message = "Error al actualizar";
            Logger.getLogger(TestEmpleado.class.getName()).log(Level.SEVERE, message, ex);
        } finally {
            session.close();
        }
    }

    public void delete(Empleado empleado) {
        try {
            iniciaOperacion();
            session.delete(empleado);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            String message = "Error al eliminar";
            Logger.getLogger(TestEmpleado.class.getName()).log(Level.SEVERE, message, ex);
        } finally {
            session.close();
        }
    }

    public Empleado findById(int id) {
        Empleado empleado = null;
        try {
            iniciaOperacion();
            empleado = (Empleado) session.get(Empleado.class, id);
        } catch (HibernateException ex) {
            tx.rollback();
            String message = "Error al buscar";
            Logger.getLogger(TestEmpleado.class.getName()).log(Level.SEVERE, message, ex);
        } finally {
            session.close();
        }
        return empleado;
    }

    public List<Empleado> findAll() {
        List<Empleado> empleadoes = null;
        try {
            iniciaOperacion();
            empleadoes = session.createQuery("from Empleado").list();
        } catch (HibernateException ex) {
            tx.rollback();
            String message = "Error al listar";
            Logger.getLogger(TestEmpleado.class.getName()).log(Level.SEVERE, message, ex);
        } finally {
            session.close();
        }
        return empleadoes;
    }

}
