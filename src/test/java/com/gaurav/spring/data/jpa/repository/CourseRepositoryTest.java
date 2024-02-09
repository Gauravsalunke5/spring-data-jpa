package com.gaurav.spring.data.jpa.repository;

import com.gaurav.spring.data.jpa.entity.Course;
import com.gaurav.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses =
                courseRepository.findAll();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Tf1")
                .lastName("Tl1")
                .build();

        Course course = Course
                .builder()
                .title("NET")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

//    @Test
//    public void findAllPagination(){
//        Pageable firstPagewithThreeRecords =
//                PageRequest.of(0, 3);
//        Pageable secondPageWithTwoRecords =
//                PageRequest.of(1,2);
//
//        List<Course> courses =
//                courseRepository.findAll(secondPageWithTwoRecords)
//                        .getContent();
//
//        long totalElements =
//                courseRepository.findAll(secondPageWithTwoRecords)
//                        .getTotalElements();
//
//        long totalPages =
//                courseRepository.findAll(secondPageWithTwoRecords)
//                        .getTotalPages();
//
//        System.out.println("totalPages = " + totalPages);
//
//        System.out.println("totalElements = " + totalElements);
//
//        System.out.println("courses = " + courses);
//    }

}