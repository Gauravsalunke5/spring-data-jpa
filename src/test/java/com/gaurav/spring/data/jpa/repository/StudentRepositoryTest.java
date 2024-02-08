package com.gaurav.spring.data.jpa.repository;

import com.gaurav.spring.data.jpa.entity.Guardian;
import com.gaurav.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("Gaurav")
                .lastName("Salunke")
                .emailId("gaurav@gmail.com")
                //.guardianName("GN")
                //.guardianEmail("gn@gmail.com")
                //.guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("GN")
                .email("gn@gmail.com")
                .mobile("9999999999")
                .build();

        Student student = Student.builder()
                .firstName("Gaurav")
                .lastName("Salunke")
                .emailId("gaurav1@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printAllStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("Gaurav");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printAllStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("Gaur");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printAllStudentBasedOnGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("GN");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printgetStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "gaurav@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "gaurav@gmail.com"
                );
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative() {
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "gaurav@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam() {
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "gaurav@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
                "GauravS",
                "gaurav@gmail.com");
    }
}