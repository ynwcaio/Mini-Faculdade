package com.example.demo.services;


import com.example.demo.Course;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
    }

    // CRUD: CREATE
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // CRUD: READ ALL
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    // CRUD: UPDATE
    public Course updateCourse(Long id, Course courseDetails) {
        Course existingCourse = findById(id);
        existingCourse.setName(courseDetails.getName());
        existingCourse.setWorkload(courseDetails.getWorkload());
        return courseRepository.save(existingCourse);
    }

    // CRUD: DELETE
    public void deleteCourse(Long id) {
        Course courseToDelete = findById(id);
        courseRepository.delete(courseToDelete);

    }


}