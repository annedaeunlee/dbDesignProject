package com.example.project.daos;

import com.example.project.models.Course;
import com.example.project.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseDao {
    @Autowired
    CourseRepository courseRepository;
    @GetMapping("/findAllCourses")
    public Iterable<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/findCourseById/{cid}")
    public Course findCourseById(@PathVariable("cid") Integer cid) {
        return courseRepository.findById(cid).get();
    }

    @GetMapping("/deleteCourse/{cid}")
    public void deleteCourse(@PathVariable("cid") Integer cid) {
        courseRepository.deleteById(cid);
    }


    @GetMapping("/createCourse/{title}/{creditHours}/{courseNumber}/{term}")
    public Course createCourse(
            @PathVariable("title") String title,
            @PathVariable("creditHours") Integer creditHours,
            @PathVariable("courseNumber") Integer courseNumber,
            @PathVariable("term") String term
    ) {
        Course course = new Course();
        course.setTitle(title);
        course.setCreditHours(creditHours);
        course.setCourseNumber(courseNumber);
        course.setTerm(term);
        return courseRepository.save(course);
    }

    //ADD FUNCTIONALITY TO UPDATE SPECIFIC ATTRIBUTES
    @GetMapping("/updateCourse/{courseId}/{title}/{creditHours}/{courseNumber}/{term}")
    public Course updateCourse(
            @PathVariable("courseId") Integer courseId,
            @PathVariable("title") String title,
            @PathVariable("creditHours") Integer creditHours,
            @PathVariable("courseNumber") Integer courseNumber,
            @PathVariable("term") String term) {
        Course course = courseRepository.findById(courseId).get();
        course.setTitle(title);
        course.setCreditHours(creditHours);
        course.setCourseNumber(courseNumber);
        course.setTerm(term);
        return courseRepository.save(course);
    }
}
