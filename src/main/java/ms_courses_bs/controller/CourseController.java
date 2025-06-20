package ms_courses_bs.controller;

import org.springframework.web.bind.annotation.RestController;
import ms_courses_bs.model.dto.CourseDTO;
import ms_courses_bs.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;
    
    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findCourseById(@PathVariable(name = "id") Long id) {
        CourseDTO courseDTO = courseService.getCourseById(id);
        if (courseDTO != null) {
            return ResponseEntity.ok(courseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@GetMapping("/courses")
    public List<Course> selectAllCourse(){
        return courseService.selectAllCourses();
    }*/
}
