package ms_courses_bs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms_courses_bs.clients.CourseDbFeignClient;
import ms_courses_bs.model.dto.CourseDTO;

@Service
public class CourseService {
    @Autowired
    CourseDbFeignClient courseDbFeignClient;

    public CourseDTO getCourseById(Long id){
        CourseDTO courseDTO = courseDbFeignClient.findCourseById(id).getBody();
        return courseDTO;
    }

}
