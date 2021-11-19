package djh.learn.hibernateOTM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			// saving teh data
			/*
			 * Instructor instructor = new
			 * Instructor("Deepak","Singh Jangra","djh@gmail.com"); InstructorDetail details
			 * = new InstructorDetail("djh.myyoutube","cricket"); Course course = new
			 * Course("java");
			 * 
			 * 
			 * instructor.setInstructorDetail(details); session.beginTransaction();
			 * 
			 * 
			 * System.out.println("saving instructor details!"+instructor);
			 * session.save(instructor);
			 */

			session.beginTransaction();
			Course course = session.get(Course.class, 11);
			session.delete(course);

			session.getTransaction().commit();
			System.out.println("Done!");

			/*
			 * session.beginTransaction(); int tid = 1; Instructor instructor2 =
			 * session.get(Instructor.class, tid);
			 * System.out.println("instructor detials is " + instructor2);
			 * 
			 * 
			 * Course course1 = new Course("Java"); Course course2 = new Course("Spring");
			 * instructor2.courses(course1); instructor2.courses(course2);
			 * session.save(course1); session.save(course2);
			 * 
			 * System.out.println("Courses---" + instructor2.getCourses());
			 * session.getTransaction().commit();
			 */
			System.out.println("Done!");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
}
