/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educomser.test;

import com.educomser.dao.EmpleadoDao;
import com.educomser.dao.HibernateUtil;
import com.educomser.model.Empleado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author MONTES
 */
public class TestEmpleado {

    private static EntityManager manager;
    private static EntityManagerFactory factory;

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        // INSTANCIAR OBJETOS EMPLEADO
        Empleado e1 = new Empleado();
        e1.setNombre("Juan");
        e1.setApellido("Perez");
        e1.setSueldo(5000);
        e1.setContrato(true);
        e1.setFechaNacimiento(format.parse("31/03/1995"));
        Empleado e2 = new Empleado();
        e2.setNombre("Ana");
        e2.setApellido("Gomez");
        e2.setSueldo(2000);
        e2.setContrato(false);
        e2.setFechaNacimiento(format.parse("20/07/1990"));
        // INSTANCIAR OBJETO DAO
        EmpleadoDao eDao = new EmpleadoDao();
        eDao.save(e1);
        eDao.save(e2);
        // RECUPERAR EL LISTADO DE EMPLEADOES
        System.out.println("LISTA DE EMPLEADOES");
        for (Empleado e : eDao.findAll()) {
            System.out.println(e.getId() + "-" + e.getNombre());
        }
        // BUSCAR UN EMPLEADO
        System.out.println("DETALLE EMPLEADO");
        System.out.print("Ingrese un id: ");
        Scanner t = new Scanner(System.in);
        int id = t.nextInt();
        Empleado emp = eDao.findById(id);
        if (emp != null) {
            System.out.println("ID: " + emp.getId());
            System.out.println("Nombre: " + emp.getNombre());
            System.out.println("Apellido: " + emp.getApellido());
            System.out.println("Fec. Nac.:" + emp.getFechaNacimiento());
        } else {
            System.out.println("El empleado no existe...");
        }

        // EDITAR UN EMPLEADO
        if (emp != null) {
            System.out.print("Ingrese un nuevo Nombre: ");
            emp.setNombre(t.next());
            eDao.update(emp);
            System.out.println("El empleado fue modificado...");
        }
        // ELIMINAR UN EMPLEADO
        System.out.print("Ingrese ID de empleado a eliminar:");
        emp = new Empleado();
        emp.setId(t.nextInt());
        eDao.delete(emp);
        System.out.println("El empleado fue eliminado...");
        // CERRAR LA SESION DE LA FACTORIA
        HibernateUtil.closeSessionFactory();
    }
}
