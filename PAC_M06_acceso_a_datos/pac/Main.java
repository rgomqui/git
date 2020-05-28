package pac;


/*PAC DESARROLLO UF3 MP06 ACCESO A DATOS*/

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
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sFactory.openSession();
		System.out.println("configuracion realizada");
		
		insertProfesor(session);
		insertModulo(session);
		insertAlumno(session);

	}
	
	//metodo para incluir modulos e imprimir por pantalla cada insert.
	public static void insertModulo(Session session) {
		
		try {
			
			//iniciamos la transaccion para insertar los datos
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("FROM Modulo" );
			
		modulo03 = new Modulo();
		modulo03.setNombre("Programacion B");
		modulo03.setCodigo("M03B");
		session.save(modulo03);
		
		modulo06 = new Modulo();
		modulo06.setNombre("Acceso a Datos");
		modulo06.setCodigo("M06");
		session.save(modulo06);
		
		modulo08 = new Modulo();
		modulo08.setNombre("Desarrollo de Aplicaciones Moviles");
		modulo08.setCodigo("M08");
		session.save(modulo08);
		
		modulo09 = new Modulo();
		modulo09.setNombre("Servicios y Procesos");
		modulo09.setCodigo("M09");
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
	
	//metodo para incluir profesor e imprimir por pantalla cada insert.
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
	
	//metodo para incluir alumnos e imprimir por pantalla cada insert.
	
	public static void insertAlumno(Session session) {
		try {
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("FROM Alumno");
		
		
		
		Set<Modulo> mod2 = new HashSet<>();
		mod2.add(modulo03);
		mod2.add(modulo06);
		mod2.add(modulo09);
		Alumno alumno2 = new Alumno();
		alumno2.setNombre("Pedro");
		alumno2.setNacionalidad("Andorrana");
		alumno2.setEdad(21);
		alumno2.setSexo("Hombre");
		alumno2.setAlumno_modulo(mod2);
		
		
		
		Set<Modulo> mod = new HashSet<>();
		mod.add(modulo03);
		mod.add(modulo06);
		mod.add(modulo08);
		mod.add(modulo09);
		Alumno alumno1 = new Alumno();
		alumno1.setNombre("Juan");
		alumno1.setNacionalidad("Espaniola");
		alumno1.setEdad(26);
		alumno1.setSexo("Hombre");
		alumno1.setAlumno_modulo(mod);
		
		
		Set<Modulo> mod3 = new HashSet<>();
		mod3.add(modulo08);
		mod3.add(modulo09);
		Alumno alumno3 = new Alumno();
		alumno3.setNombre("Marta");
		alumno3.setNacionalidad("Espaniola");
		alumno3.setEdad(29);
		alumno3.setSexo("Mujer");
		alumno3.setAlumno_modulo(mod3);
		
		
		
		Set<Modulo> mod4 = new HashSet<>();
		mod4.add(modulo06);
		mod4.add(modulo08);
		mod4.add(modulo09);
		Alumno alumno4 = new Alumno();
		alumno4.setNombre("Carla");
		alumno4.setNacionalidad("Francesa");
		alumno4.setEdad(35);
		alumno4.setSexo("Mujer");
		alumno4.setAlumno_modulo(mod4);
		
		
		session.save(alumno4);
		session.save(alumno2);
		session.save(alumno3);
		session.save(alumno1);
		
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
