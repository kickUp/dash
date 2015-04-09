package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
import freemarker.log.Logger;

import service.CourseService;

@Controller
public class FeatureCtrl {  
  
  Logger log = Logger.getLogger(Courses.class.getCanonicalName());
   
  
  @RequestMapping("/feature")
  public String getCourses(HttpSession session) { 
    
    return "feature";
  }
  

}
