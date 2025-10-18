package com.example.demo.services;

import com.example.demo.Course;
import com.example.demo.Student;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }


    public Student enrollStudent(Long courseId, Student studentDetails) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Cannot enroll: Course not found with id: " + courseId));
        studentDetails.setCourse(course);
        return studentRepository.save(studentDetails);
    }



    // CRUD: READ ONE
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    // CRUD: READ ALL
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // CRUD: UPDATE
    public Student updateStudent(Long id, Student studentDetails) {
        Student existingStudent = findById(id);
        existingStudent.setName(studentDetails.getName());
        existingStudent.setRegistrationNumber(studentDetails.getRegistrationNumber());
        return studentRepository.save(existingStudent);
    }

    // CRUD: DELETE
    public void deleteStudent(Long id) {
        Student studentToDelete = findById(id);
        studentRepository.delete(studentToDelete);
    }
}