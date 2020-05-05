package pac;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;




public class Main {

	public static Modulo modulo03, modulo06, modulo08, modulo09;
	
	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sFactory.openSession();
		System.out.println("configuracion realizada");
		
		insertProfesor(session);
		insertModulo(session);
		insertAlumno(session);
		
	}
	
	//metodo para añadir modulos e imprimir por pantalla cada insert.
	public static void insertModulo(Session session) {
		
		try {
			
			//iniciamos la transaccion para insertar los datos
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("FROM Modulo");
			
		modulo03 = new Modulo("Programacion B", "M03B");
		session.save(modulo03);
		
		modulo06 = new Modulo("Acceso a Datos", "M06");
		session.save(modulo06);
		
		modulo08 = new Modulo("Desarrollo de Aplicaciones Moviles", "M08");
		session.save(modulo08);
		
		modulo09 = new Modulo("Servicios y Procesos", "M09");
		session.save(modulo09);
		
		tx.commit();
		
		List lista= query.list();
		
		for(Object o:lista) {
			System.out.println("Insert into "+o);
		}
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//metodo para añadir profesor e imprimir por pantalla cada insert.
	public static void insertProfesor(Session session) {
		try {
			
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("FROM Profesor");
			
		Profesor profesor01 = new Profesor("Alvaro", "Hombre");
		session.save(profesor01);
		
		tx.commit();
		
		List lista= query.list();
		
		for(Object o:lista) {
			System.out.println("Insert into "+o);
		}
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//metodo para añadir alumnos e imprimir por pantalla cada insert.
	
	public static void insertAlumno(Session session) {
		try {
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("FROM Alumno");
		
		Set<Modulo> mod = new HashSet<>();
		mod.add(modulo03);
		mod.add(modulo06);
		mod.add(modulo08);
		mod.add(modulo09);
		
		Alumno alumno1 = new Alumno("Juan", "Espaniola", 26, "Hombre", mod);
		session.save(alumno1);
		
		Set<Modulo> mod2 = new HashSet<>();
		mod2.add(modulo03);
		mod2.add(modulo06);
		mod2.add(modulo09);
		Alumno alumno2 = new Alumno("Pedro", "Andorrana", 21, "Hombre", mod2);
		session.save(alumno2);
		
		
		Set<Modulo> mod3 = new HashSet<>();
		mod3.add(modulo08);
		mod3.add(modulo09);
		Alumno alumno3 = new Alumno("Marta", "Espaniola", 19, "Mujer", mod3);
		session.save(alumno3);
		
		Set<Modulo> mod4 = new HashSet<>();
		mod4.add(modulo06);
		mod4.add(modulo08);
		mod4.add(modulo09);
		Alumno alumno4 = new Alumno("Carla", "Francesa", 35, "Mujer", mod4);
		session.save(alumno4);
		
		tx.commit();
		
		
		
		
	List lista= query.list();
		
		for(Object o:lista) {
			System.out.println("Insert into "+o);
		}
		
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
