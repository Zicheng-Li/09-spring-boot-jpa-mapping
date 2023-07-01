package lzc.com.example.mappingdemo;

import lzc.com.example.mappingdemo.dao.AppDAO;
import lzc.com.example.mappingdemo.entity.Instructor;
import lzc.com.example.mappingdemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
		/*
		//create Instructor
		Instructor tempInstructor = new Instructor("Susan", "Public", "susan@rbc.com");

		// create instructor detail

        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");

		 */

		// create instructor detail
		Instructor tempInstructor = new Instructor("HHHH", "lplplplp", "hhhh@rbc.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "code");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		// this will also save the details object because of CascadeType.ALL
		System.out.println("saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");

	}
}
