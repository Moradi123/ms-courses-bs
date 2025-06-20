package ms_courses_bs.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ms_courses_bs.model.dto.CourseDTO;

@FeignClient(name="ms-courses-db", url = "http://localhost:8181/courses")
public interface CourseDbFeignClient {
    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findCourseById(@PathVariable(name = "id") Long id);

}
