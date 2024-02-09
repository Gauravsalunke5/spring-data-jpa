package com.gaurav.spring.data.jpa.repository;

import com.gaurav.spring.data.jpa.entity.Course;
import com.gaurav.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseDBA = Course.builder()
                .title("C")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("TFN")
                        .lastName("TLN")
                        //.courses(List.of(courseDBA, courseJava))
                        .build();

        teacherRepository.save(teacher);
    }
}