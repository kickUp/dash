package aspect;

import annotation.Logn;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;

import freemarker.log.Logger;

//@Aspect
public class LognAspect {

	Logger log = Logger.getLogger(LognAspect.class.getCanonicalName());


	public void login() {
		log.info("ASPECT login.");
	}


/*
	
	@Around("execution(@controller.Courses * *(..)) && @annotation(Logn)") //("@annotation(logn)")
	public void log() {
		log.info("Info annoation: Custom annotion logn!!");
		log.debug("Debug annotation: Custom annotion logn!!");
	}	

	@Around("@annotation(Logn)")
	public void logBefore() {
		log.info("Info annoation: Custom annotion logn!!");
		log.debug("Debug annotation: Custom annotion logn!!");
	}
*/
}