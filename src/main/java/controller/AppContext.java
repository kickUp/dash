package controller;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppContext implements ApplicationContextAware {

    /*
        USING:
            ApplicationContext app = AppContext.getApplicationContext();
            log.info("Info login class: " + app.getBean("login", Login.class));
            log.info("Info login class: " + app.getBean("courses", Courses.class));

    */
	
	private static ApplicationContext context;

 	public static ApplicationContext getApplicationContext() {
        return context;
    }
 
    @Override
    public void setApplicationContext(ApplicationContext ctx) {
        context = ctx;
    }

    public String toString() {
    	return "This is AppContext class";
    }

}