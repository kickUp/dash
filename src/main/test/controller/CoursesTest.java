package controller;

import java.util.ArrayList;
import java.util.List;
 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith; 
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import entity.Course;
import entity.User;

import service.CourseService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:app-context.xml"})//classes = {TestContext.class})
@WebAppConfiguration()
public class CoursesTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;	
	
	@Mock
	private CourseService courseService;
	
	@InjectMocks
	private Courses courses;
	

	private List<Course> courseList;
	private User user;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		
		courseList = new ArrayList<Course>();		
		user = new User();
		
		user.setId(1);
		user.setLogin("T user");
		user.setPassword("T pass");
		
		Course course = new Course();
		course.setId(1);
		course.setName("Test course");
		course.setDescription("Test description");
		course.setUser(user);	
		
		Course course1 = new Course();
		course1.setId(1);
		course1.setName("Test course 2");
		course1.setDescription("Test description 2");
		course1.setUser(user);
		
		courseList.add(course);
		courseList.add(course1);
	}
	 

	@Test
	public void getCoursesTest() throws Exception { 		
		when(courseService.getCourses()).thenReturn(courseList);
		
		mockMvc.perform(get("/courses"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/view/authorized/courses.ftl"));
			//
			//.andExpect()
	}

}
