package com.gaurav.spring.data.jpa.repository;

import com.gaurav.spring.data.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
