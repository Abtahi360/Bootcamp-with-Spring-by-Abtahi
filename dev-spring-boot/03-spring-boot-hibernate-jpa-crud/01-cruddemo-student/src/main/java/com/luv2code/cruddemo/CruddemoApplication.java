package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.hibernate.boot.archive.scan.spi.ScanOptions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner ->{
            // createMultipleStudents(studentDAO);
            // readStudent(studentDAO);
            // queryForStudents(studentDAO);
            // queryForStudentsByLastName(studentDAO);
            // updateStudent(studentDAO);
            deleteStudent(studentDAO);


        };
    }

    private void deleteStudent(StudentDAO studentDAO) {

        int studentId = 4;
        System.out.println("Deleting student with id " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id: primary key
        int studentId = 8;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // change first name to "Scooby"
        System.out.println("Updating the student");
        myStudent.setFirstName("Scooby");

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("Updated the student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Islam");

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

        // save the student
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Getting student with id " + theId);

        // display student
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
        Student tempStudent = new Student("Abtahi", "Islam", "abtahiislam@gmail.com");

        // Save the student object
        System.out.println("Saving the student..!");
        studentDAO.save(tempStudent);

        // Dispaly id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved the student. Generated id: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // Display student
        System.out.println("Found the student: " + myStudent);

    }

}
