package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.hibernate.boot.archive.scan.spi.ScanOptions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner ->{
            createMultipleStudents(studentDAO);
        };
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // Create multiple students
        System.out.println("Creating 3 student objects..!");
        Student tempStudent1 = new Student("Abtahi", "Islam", "abtahiislam@gmail.com");
        Student tempStudent2 = new Student("Rahim", "Islam", "rahimislam@gmail.com");
        Student tempStudent3 = new Student("Korim", "Islam", "korimislam@gmail.com");

        // save the student objects
        System.out.println("Saving 3 student objects..!");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {

        // Create the student object
        System.out.println("Creating new student object..!");
        Student tempStudent = new Student("Paul", "Doe", "pauldoe@gmail.com");

        // Save the student object
        System.out.println("Saving the student..!");
        studentDAO.save(tempStudent);

        // Dispaly id of the saved student
        System.out.println("Saved the student. Generated id: " + tempStudent.getId());


    }

}
