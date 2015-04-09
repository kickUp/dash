package daoImpl;

import java.util.List;

import dao.DaoCourse;
import entity.Course;
import entity.User;
import freemarker.log.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Repository;

@Repository
public class DaoCourseImpl implements DaoCourse {
	
	Logger log = Logger.getLogger(DaoCourseImpl.class.getCanonicalName());

	@Autowired
	SessionFactory session;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Course> getCourses() {
		log.info("BEGIN REQUEST FOR COURSES" );
		List<Course> courses = null;
		try {
		 courses = session.getCurrentSession().createQuery("FROM Course").list();//.createCriteria(Course.class).list();
		} catch (Exception e) {
			log.info("Exception aqqure " + e.getMessage());
		}
		if(courses != null)
			log.info("in DAO we get courses size: " + courses.size());
		else
			log.debug("Courses is null");
		return courses;
	}

	@Override
	public Course getCourseById(Integer id) throws DataAccessException { 
		log.info(" SELECT BY ID " + id);
		Course course;	 
		course = (Course) session.getCurrentSession()
						.createCriteria(Course.class)
						.add(Restrictions.eq("id", id)).uniqueResult(); 
		if(course == null)
			throw new DataRetrievalFailureException("Unknown course");
 
		return course;
	}

	@Override
	public void createCourse(Course course) {
		if(course.getUser() == null) 
		{
			log.info("User null. Add static user ");
			User u = new User();
			u.setId(2);
			u.setLogin("lector");
			u.setPassword("lecotor");
			course.setUser(u);
		}
		session.getCurrentSession().save(course);
		
	}

	@Override
	public void updateCourse(Course course) {
		session.getCurrentSession().update(course);
		
	}
	
	

}
