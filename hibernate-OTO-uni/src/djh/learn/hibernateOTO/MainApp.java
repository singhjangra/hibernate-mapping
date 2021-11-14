package djh.learn.hibernateOTO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
				  //saving teh data 
					
					  Instructor instructor = new
					  Instructor("Deepak","Singh Jangra","djh@gmail.com");
					  
					  
					  InstructorDetail details = new InstructorDetail("djh.myyoutube","cricket");
					  instructor.setInstructorDetail(details); session.beginTransaction();
					  
					  
					  System.out.println("saving instructor details!"+instructor);
					  session.save(instructor);
					  session.getTransaction().commit(); System.out.println("Done!");
				 
			/*
			 * session.beginTransaction(); Instructor instructor2 =
			 * session.get(Instructor.class, 1); session.delete(instructor2);
			 * 
			 * session.getTransaction().commit(); System.out.println("Done!");
			 */

			/*
			 * session.beginTransaction(); int tid = 1; InstructorDetail instructor2 =
			 * session.get(InstructorDetail.class, tid);
			 * System.out.println("instructor detials is " + instructor2);
			 * 
			 * 
			 * System.out.println("Deleting----- "); session.delete(instructor2);
			 * session.getTransaction().commit(); System.out.println("Done!");
			 */

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
}
